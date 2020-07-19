package org.tj.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.event.PeaseCreateEvent;

/**
 * 向日葵
 */
public class PeaseActor extends AnimationAtor {


    public PeaseActor(String[] animationFile, float x, float y) {
        super(animationFile, x, y);
        //发送一个产生子弹的事件
        MyCorpseGame.EVENTBUS.post(new PeaseCreateEvent(this));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);




    }
}
