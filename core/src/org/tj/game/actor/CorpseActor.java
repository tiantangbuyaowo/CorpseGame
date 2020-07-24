package org.tj.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;
import lombok.Setter;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.model.CorpseActorStatus;
import org.tj.game.res.Res;

import static org.tj.game.actor.LineMapGroup.WIDTH;

/**
 * 僵尸
 */
public class CorpseActor extends AnimationAtor {


    /**
     * 僵尸状态，默认移动状态
     */
    @Setter
    private CorpseActorStatus corpseActorStatus = CorpseActorStatus.WALK;
    /**
     * 僵尸的矩形框
     */
    @Getter
    private Rectangle rectangle;
    /**
     * 僵尸水平移动速度, px/s
     */
    public static float moveVelocity = 20;


    private LineMapGroup lineMapGroup;

    private float anim_time;

    /**
     * 僵尸有10点血
     */
    @Setter
    @Getter
    private int Hp = 5;

    private Music walkBellow = Res.assetManager.get(Res.CORPSEBELLOW, Music.class);


    private Music eatMusic = Res.assetManager.get(Res.EATPLANT, Music.class);


    public CorpseActor(LineMapGroup lineMapGroup, String[] animationFile, float x, float y, float textureRegionx, float textureRegiony, Animation.PlayMode PlayMode, float frameDuration) {
        super(animationFile, x, y, textureRegionx, textureRegiony, PlayMode, frameDuration);


        this.lineMapGroup = lineMapGroup;

        walkBellow.setLooping(true);
        walkBellow.setVolume(0.2f);
        walkBellow.play();
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());


    }

    public CorpseActor(LineMapGroup lineMapGroup, String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        super(animationFile, x, y, textureRegionx, textureRegiony);


        this.lineMapGroup = lineMapGroup;

        walkBellow.setLooping(true);
        walkBellow.setVolume(0.2f);
        walkBellow.play();
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());


    }


    @Override
    public void act(float delta) {
        if (isVisible()) {

            if (corpseActorStatus.equals(CorpseActorStatus.HEADDOWN)) { //正在脑袋落地
                anim_time = anim_time + delta;
                if (walkAnimation.isAnimationFinished(anim_time)) { //如果结束了
                    this.lineMapGroup.getCorpseActors().remove(this);
                    this.remove();
                    CorpseActor corpseActor = new CorpseActor(lineMapGroup, Res.CORPSE_LOST_HEAD_WALK, getX(), getY(), 0, 0);
                    corpseActor.setHp(this.getHp());
                    corpseActor.setCorpseActorStatus(CorpseActorStatus.LOSTHEADWALK);
                    lineMapGroup.addActor(corpseActor);
                } else {
                    //继续播放
                    return;
                }
            }


            //如果是在走的状态
            if (corpseActorStatus.equals(CorpseActorStatus.WALK) || corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) {
                if (this.getHp() <= 4 && corpseActorStatus.equals(CorpseActorStatus.WALK)) {//血量到达了4,但是还是有头，就要播放掉头动画
                    this.lineMapGroup.getCorpseActors().remove(this);
                    this.remove();
                    CorpseActor corpseActor = new CorpseActor(lineMapGroup, Res.CORPSE_HEAD_DOWN, getX(), getY(), 70, 5, Animation.PlayMode.NORMAL, 0.3f);
                    corpseActor.setHp(this.getHp());
                    corpseActor.setCorpseActorStatus(CorpseActorStatus.HEADDOWN);
                    lineMapGroup.addActor(corpseActor);
                }

                /**
                 * 移动起来
                 */
                setX(getX() - delta * CorpseActor.moveVelocity);
                //动态更新他的位置框
                rectangle.setX(getX() + 40);

                for (PeaseActor peaseActor : lineMapGroup.getPeaseActorss()) {
                    //发生了碰撞
                    if (peaseActor.getRectangle().overlaps(this.getRectangle())) {
                        //如果碰到了植物
                        changStatus();
                        break;
                    }
                }


                //吃植物
            } else if (corpseActorStatus.equals(CorpseActorStatus.EAT)) {

            } else if (corpseActorStatus.equals(CorpseActorStatus.LOSTHEADEAT)) {

            }
        }
    }

    /**
     * 改变僵尸的状态
     */
    private void changStatus() {
        walkBellow.pause();
        eatMusic.setLooping(true);
        eatMusic.play();
        if (this.corpseActorStatus.equals(CorpseActorStatus.WALK)) { //有头
            super.initAnimation(Res.CORPSE_HEAD_ATTACK, getX(), getY(), 0, 0);
            this.corpseActorStatus = CorpseActorStatus.EAT;
        } else if (this.corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) { //没头
            super.initAnimation(Res.CORPSE_LOST_HEAD_ATTACK, getX(), getY(), 0, 0);
            this.corpseActorStatus = CorpseActorStatus.LOSTHEADEAT;
        }
    }


    /**
     * 僵尸受伤扣除hp
     */
    public synchronized void hurt() {
        if (this.Hp > 0) {
            this.setHp(this.getHp() - 1);
        }
    }
}
