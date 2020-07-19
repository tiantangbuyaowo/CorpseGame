package org.tj.game.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.eventbus.EventBus;
import org.tj.game.MyCorpseGame;
import org.tj.game.event.GameStageRemoveActorEvent;
import org.tj.game.event.PeaseCreateEvent;
import org.tj.game.res.Res;

/**
 * 子弹演员
 */
public class BulletActor extends Actor {


    /**
     * 子弹水平移动速度, px/s
     */
    public static float moveVelocity = 160;


    /**
     * 他需要知道自己属于哪个豌豆射手
     */
    private PeaseActor peaseActor;

    private Texture bullet;

    public BulletActor(PeaseActor peaseActor) {
        this.peaseActor = peaseActor;
        bullet = Res.assetManager.get(Res.BULLET_PATH);
        this.setX(peaseActor.getX() + 60);
        this.setY(peaseActor.getY() + 40);
        //设置演员的尺寸
        this.setSize(bullet.getWidth(), bullet.getHeight());


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        //如果是不显示了，就结束
        if (!isVisible()) {
            return;
        }

        //到位置了就消失
        if (this.getX() > MyCorpseGame.WORLD_HEIGHT) {
            this.setVisible(false);
            //MyCorpseGame.EVENTBUS.post(new GameStageRemoveActorEvent(this));
            this.remove();
            //如果豌豆射手还在，同时再产生一个子弹
            if (null != peaseActor && peaseActor.isVisible()) {
                MyCorpseGame.EVENTBUS.post(new PeaseCreateEvent(peaseActor));
            }
            return;
        }
        batch.draw(new TextureRegion(bullet), getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
    }

    @Override
    public void act(float delta) {
        if (isVisible()) {
            /**
             * 移动起来
             */
            setX(getX() + delta * BulletActor.moveVelocity);
        }
    }


}
