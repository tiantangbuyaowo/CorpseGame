package org.tj.game.actor;

import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;

/**
 * 僵尸
 */
public class CorpseActor extends AnimationAtor {

    /**
     * 僵尸水平移动速度, px/s
     */
    public static float moveVelocity = 20;

    public CorpseActor(String[] animationFile, float x, float y) {
        super(animationFile, x, y);
    }

    public CorpseActor(String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        super(animationFile, x, y, textureRegionx, textureRegiony);
    }

    @Override
    public void act(float delta) {
        if (isVisible()) {
            /**
             * 移动起来
             */
            setX(getX() - delta * CorpseActor.moveVelocity);
        }
    }
}
