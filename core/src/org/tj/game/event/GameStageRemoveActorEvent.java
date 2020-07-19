package org.tj.game.event;

import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通知场景移除演员
 */
@AllArgsConstructor
public class GameStageRemoveActorEvent {

    @Getter
    private Actor actor;
}
