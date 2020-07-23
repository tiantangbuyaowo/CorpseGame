package org.tj.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.Getter;
import org.tj.game.MyCorpseGame;
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
     * 豌豆子弹的矩形框
     */
    @Getter
    private Rectangle rectangle;
    /**
     * 他需要知道自己属于哪个豌豆射手
     */
    @Getter
    private PeaseActor peaseActor;

    private LineMapGroup lineMapGroup;

    private Texture bullet;


    public BulletActor(PeaseActor peaseActor, LineMapGroup lineMapGroup) {
        this.lineMapGroup = lineMapGroup;
        this.peaseActor = peaseActor;
        bullet = Res.assetManager.get(Res.BULLET_PATH);
        this.setX(peaseActor.getX() + 60);
        this.setY(peaseActor.getY() + 40);
        //设置演员的尺寸
        this.setSize(bullet.getWidth(), bullet.getHeight());
        rectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Res.assetManager.get(Res.ADDBULLET, Music.class).play();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        BulletAndCorpseCollide();


        //如果是不显示了，就结束
        if (!isVisible()) {
            return;
        }

        //到位置了就消失
        if (this.getX() > MyCorpseGame.WORLD_HEIGHT) {
            this.setVisible(false);
            //MyCorpseGame.EVENTBUS.post(new GameStageRemoveActorEvent(this));
            this.remove();
/*            //System.out.println(this.getParent());
            //如果豌豆射手还在，同时再产生一个子弹
            if (null != peaseActor && peaseActor.isVisible()) {
                lineMapGroup.removeActor(this);
                lineMapGroup.addActor(new BulletActor(peaseActor, lineMapGroup));
            }*/
            return;
        }


        batch.draw(new TextureRegion(bullet), getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
    }

    /**
     * 子弹和僵尸的碰撞检测
     */
    private void BulletAndCorpseCollide() {
        lineMapGroup.getCorpseActors().forEach(corpseActors -> {

            //子弹碰到了僵尸
            if (this.getRectangle().overlaps(corpseActors.getRectangle())) {
                Res.assetManager.get(Res.ATTACHCORPSE, Music.class).play();
                corpseActors.hurt();
                this.setVisible(false);
                this.remove();
            }
        });
    }

    @Override
    public void act(float delta) {
        if (isVisible()) {
            /**
             * 移动起来
             */
            setX(getX() + delta * BulletActor.moveVelocity);
            //动态更新他的位置框
            rectangle.setX(getX());
            //System.out.println(getX());
        }
    }


}
