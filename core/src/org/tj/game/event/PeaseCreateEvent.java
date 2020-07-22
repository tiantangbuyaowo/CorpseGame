package org.tj.game.event;

import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.tj.game.actor.PeaseActor;

/**
 * 产生一个豌豆射手的事件
 */

@AllArgsConstructor
public class PeaseCreateEvent {
    @Getter
    PeaseActor actor;
}
