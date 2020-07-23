package org.tj.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.model.CorpseActorStatus;
import org.tj.game.res.Res;

/**
 * 僵尸
 */
public class CorpseActor extends AnimationAtor {


    /**
     * 僵尸状态，默认移动状态
     */
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

    /**
     * 僵尸有10点血
     */
    private int Hp = 10;

    private Music walkBellow = Res.assetManager.get(Res.CORPSEBELLOW, Music.class);


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
            //如果是在走的状态
            if (corpseActorStatus.equals(CorpseActorStatus.WALK) || corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) {
                /**
                 * 移动起来
                 */
                setX(getX() - delta * CorpseActor.moveVelocity);
                //动态更新他的位置框
                rectangle.setX(getX() + 40);

                for (PeaseActor peaseActor : lineMapGroup.getPeaseActorss()) {
                    //发生了碰撞
                    if (peaseActor.getRectangle().contains(this.getX(), this.getY())) {
                        //如果碰到了植物
                        changStatus();
                        break;
                    }
                }


                //吃植物
            } else if (corpseActorStatus.equals(CorpseActorStatus.EAT) || corpseActorStatus.equals(CorpseActorStatus.LOSTHEADEAT)) {

            }
        }
    }

    /**
     * 改变僵尸的状态
     */
    private void changStatus() {
        if (this.corpseActorStatus.equals(CorpseActorStatus.WALK)) { //有头
            super.initAnimation(Res.CORPSE_HEAD_ATTACK_PASH, getX(), getY(), 0, 0);
            this.corpseActorStatus = CorpseActorStatus.EAT;
        } else if (this.corpseActorStatus.equals(CorpseActorStatus.LOSTHEADWALK)) { //没头

        }
    }
}
