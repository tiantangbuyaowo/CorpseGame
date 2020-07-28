package org.tj.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;
import lombok.Setter;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.actor.base.PlantParent;
import org.tj.game.model.CorpseActorStatus;
import org.tj.game.res.Res;

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

    // private Music walkBellow = Res.assetManager.get(Res.CORPSEBELLOW, Music.class);
    private Music walkBellow = Gdx.audio.newMusic(Gdx.files.internal(Res.CORPSEBELLOW));


    //private Music eatMusic = Res.assetManager.get(Res.EATPLANT, Music.class);
    private Music eatMusic = Gdx.audio.newMusic(Gdx.files.internal(Res.EATPLANT));


    public CorpseActor(LineMapGroup lineMapGroup, String[] animationFile, float x, float y, float textureRegionx, float textureRegiony, Animation.PlayMode PlayMode, float frameDuration) {

        super(animationFile, x, y, textureRegionx, textureRegiony, PlayMode, frameDuration);
        init(lineMapGroup);
    }


    public CorpseActor(LineMapGroup lineMapGroup, String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        super(animationFile, x, y, textureRegionx, textureRegiony);
        init(lineMapGroup);
    }

    private void init(LineMapGroup lineMapGroup) {
        this.lineMapGroup = lineMapGroup;
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());
        //System.out.println(this.eatMusic);
    }


    @Override
    public boolean remove() {
        this.eatMusic.stop();
        //System.out.println("停止吃" + this.eatMusic);
        this.eatMusic.dispose();
        this.walkBellow.stop();
        this.walkBellow.dispose();
        this.lineMapGroup.getCorpseActors().remove(this);
        this.setVisible(false);
        return super.remove();

    }

    @Override
    public void act(float delta) {
        if (isVisible()) {
            if (this.getHp() == 0 && !this.corpseActorStatus.equals(CorpseActorStatus.DIE)) { //僵尸血量为0了,但是还没播放死亡动画
                updateObject(CorpseActorStatus.DIE, Res.CORPSE_DIE, getX() - 70, getY(), 0, 5);
                return;
            } else if (this.corpseActorStatus.equals(CorpseActorStatus.DIE)) { //是死亡状态了
                anim_time = anim_time + delta;
                if (walkAnimation.isAnimationFinished(anim_time)) { //动画结束了
                    this.remove();
                }
                return;
            }
            if (corpseActorStatus.equals(CorpseActorStatus.WALK_TO_HEADDOWN) || corpseActorStatus.equals(CorpseActorStatus.EAT_TO_HEADDOWN)) { //走的时候正在脑袋落地,或者吃的时候脑袋落地
                anim_time = anim_time + delta;
                if (walkAnimation.isAnimationFinished(anim_time)) { //如果结束了
                    this.remove();
                    CorpseActor corpseActor = null;
                    if (corpseActorStatus.equals(CorpseActorStatus.WALK_TO_HEADDOWN)) {
                        corpseActor = new CorpseActor(lineMapGroup, Res.CORPSE_LOST_HEAD_WALK, getX(), getY(), 0, 0);
                        corpseActor.setCorpseActorStatus(CorpseActorStatus.LOSTHEADWALK);
                    } else if (corpseActorStatus.equals(CorpseActorStatus.EAT_TO_HEADDOWN)) {
                        corpseActor = new CorpseActor(lineMapGroup, Res.CORPSE_LOST_HEAD_ATTACK, getX(), getY(), 0, 0);
                        corpseActor.setCorpseActorStatus(CorpseActorStatus.LOSTHEADEAT);
                    }
                    corpseActor.setHp(this.getHp());

                    lineMapGroup.addActor(corpseActor);

                }
                return;

            }


            //如果是在走的状态
            if (corpseActorStatus.equals(CorpseActorStatus.WALK) || corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) {
                playWalkMusic();
                if (this.getHp() <= 4 && corpseActorStatus.equals(CorpseActorStatus.WALK)) {//血量到达了4,但是还是有头，就要播放掉头动画
                    updateObject(CorpseActorStatus.WALK_TO_HEADDOWN, Res.CORPSE_HEAD_DOWN, getX(), getY(), 70, 5);
                    return;
                }

                /**
                 * 移动起来
                 */
                setX(getX() - delta * CorpseActor.moveVelocity);
                //动态更新他的位置框
                rectangle.setX(getX() + 40);

                for (PlantParent peaseActor : lineMapGroup.getPeaseActorss()) {
                    //发生了碰撞
                    if (peaseActor.getRectangle().overlaps(this.getRectangle())) {
                        //如果碰到了植物
                        changStatus();
                        break;
                    }
                }


                //有头吃植物
            } else if (corpseActorStatus.equals(CorpseActorStatus.EAT)) {
                if (this.getHp() <= 4) {//血量到达了4,就要播放掉头动画
                    updateObject(CorpseActorStatus.EAT_TO_HEADDOWN, Res.CORPSE_HEAD_DOWN, getX(), getY(), 70, 5);
                    return;
                }
                playEatMusic();
            } else if (corpseActorStatus.equals(CorpseActorStatus.LOSTHEADEAT)) {
                playEatMusic();
            }
        }
    }

    /**
     * 播放行走的音乐
     */
    private void playWalkMusic() {
        eatMusic.pause();
        if (!walkBellow.isPlaying()) {
            walkBellow.setVolume(0.2f);
            walkBellow.setLooping(true);
            walkBellow.play();
        }
    }

    /**
     * 播放吃植物的音乐
     */
    private void playEatMusic() {
        walkBellow.pause();
        if (!eatMusic.isPlaying()) {
            //System.out.println("吃" + this.eatMusic);
            eatMusic.setVolume(0.2f);
            eatMusic.setLooping(true);
            eatMusic.play();
        }
    }

    /**
     * 更新对象，这个方法会播放动画，同时用新对象替换老对象
     *
     * @param corpseActorStatus
     * @param amiFile
     * @param x
     * @param y
     * @param textureRegionx
     * @param textureRegiony
     */
    private void updateObject(CorpseActorStatus corpseActorStatus, String[] amiFile, float x, float y, int textureRegionx, int textureRegiony) {
        this.remove();
        CorpseActor corpseActor = new CorpseActor(lineMapGroup, amiFile, x, y, textureRegionx, textureRegiony, Animation.PlayMode.NORMAL, 0.3f);
        corpseActor.setHp(this.getHp());
        corpseActor.setCorpseActorStatus(corpseActorStatus);
        lineMapGroup.addActor(corpseActor);
    }

    /**
     * 改变僵尸的状态
     */
    private void changStatus() {
        if (this.corpseActorStatus.equals(CorpseActorStatus.WALK)) { //有头
            super.initAnimation(Res.CORPSE_HEAD_ATTACK, getX(), getY(), 0, 0, Animation.PlayMode.LOOP, 0.3f);
            this.corpseActorStatus = CorpseActorStatus.EAT;
        } else if (this.corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) { //没头
            super.initAnimation(Res.CORPSE_LOST_HEAD_ATTACK, getX(), getY(), 0, 0, Animation.PlayMode.LOOP, 0.3f);
            this.corpseActorStatus = CorpseActorStatus.LOSTHEADEAT;
        }
    }


    /**
     * 僵尸受伤扣除hp
     */
    public synchronized void hurt() {
        if (this.Hp > 0) {
            this.setHp(this.getHp() - 1);
        } else { //血量为0

        }
    }

}
