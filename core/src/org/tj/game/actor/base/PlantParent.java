package org.tj.game.actor.base;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;

/**
 * 植物的父类
 */
public class PlantParent extends AnimationAtor {

    /**
     * 植物的矩形框
     */
    @Getter
    private Rectangle rectangle;

    public PlantParent(String[] animationFile, float x, float y) {
        super(animationFile, x, y);
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());
    }

    public PlantParent(String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        super(animationFile, x, y, textureRegionx, textureRegiony);
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());
    }

    public PlantParent(String[] animationFile, float x, float y, float textureRegionx, float textureRegiony, Animation.PlayMode playMode, float frameDuration) {
        super(animationFile, x, y, textureRegionx, textureRegiony, playMode, frameDuration);
        rectangle = new Rectangle(getX() + 40, getY(), getWidth() - 40, getHeight());
    }
}
