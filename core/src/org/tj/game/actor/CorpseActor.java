package org.tj.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.res.Res;

/**
 * 僵尸
 */
public class CorpseActor extends AnimationAtor {


    //private String status = "";


    /**
     * 僵尸的矩形框
     */
    @Getter
    private Rectangle rectangle;
    /**
     * 僵尸水平移动速度, px/s
     */
    public static float moveVelocity = 20;

    private Music walkBellow = Res.assetManager.get(Res.CORPSEBELLOW, Music.class);

    public CorpseActor(String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        super(animationFile, x, y, textureRegionx, textureRegiony);

        walkBellow.setLooping(true);
        walkBellow.setVolume(0.2f);
        walkBellow.play();
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());


    }

    @Override
    public void act(float delta) {
        if (isVisible()) {
            /**
             * 移动起来
             */
            setX(getX() - delta * CorpseActor.moveVelocity);
            //动态更新他的位置框
            rectangle.setX(getX() + 40);
        }
    }
}
