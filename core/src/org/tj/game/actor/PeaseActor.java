package org.tj.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import org.tj.game.actor.base.AnimationAtor;

/**
 * 豌豆射手
 */
public class PeaseActor extends AnimationAtor {

    /**
     * 上次产生子弹的时间
     */
    private float lastCreatebullet = 0f;

    private LineMapGroup lineMapGroup;


    public PeaseActor(String[] animationFile, float x, float y, LineMapGroup lineMapGroup) {
        super(animationFile, x, y);
        this.lineMapGroup = lineMapGroup;


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);


    }

    @Override
    public void act(float delta) {
        super.act(delta);

        lastCreatebullet = lastCreatebullet + delta;


        //两秒
        if ((lastCreatebullet - delta) >= 2f) {
            lastCreatebullet = 0;
            //增加一个子弹演员
            this.lineMapGroup.addActor(new BulletActor(this, lineMapGroup));
        }


    }
}
