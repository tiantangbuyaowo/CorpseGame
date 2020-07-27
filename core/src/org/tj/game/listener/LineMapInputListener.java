package org.tj.game.listener;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.actor.LineMapGroup;
import org.tj.game.actor.PeaseActor;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.model.MapPoint;
import org.tj.game.res.Res;

/**
 * 行级地图点击事件
 */
@Slf4j
public class LineMapInputListener extends InputListener {
    private LineMapGroup lineMapGroup;

    public LineMapInputListener(LineMapGroup lineMapGroup) {
        this.lineMapGroup = lineMapGroup;
    }

    /**
     * 手指/鼠标 抬起时调用
     */
    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

        MapPoint clickPoint = lineMapGroup.getClickPoint(x, y);

        if (null == clickPoint) {
            //没点到地图位置，或者里头已经有了植物，就啥也不干
            return;
        }
        //否则生成豌豆射手
        AnimationAtor pease = new PeaseActor(Res.PEASE_PATH, clickPoint.getLeftDown().x, clickPoint.getLeftDown().y, lineMapGroup);
        lineMapGroup.addActor(pease);


    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        log.error("touchDown: " + x + ", " + y + "; pointer: " + pointer);
        return true;
    }

    /**
     * 手指/鼠标 按下后拖动时调用
     */
    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        //log.error( "touchDragged: " + x + ", " + y + "; pointer: " + pointer);
    }

    /**
     * 当有键盘按键被按下时调用, 参数 keycode 是被按下的按键的键值,
     * 所有键盘按键的键值常量定义在 com.badlogic.gdx.Input.Keys 类中
     */
    @Override
    public boolean keyDown(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.UP: {
                log.error("被按下的按键: 方向上键");
                break;
            }
            case Input.Keys.DOWN: {
                log.error("被按下的按键: 方向下键 ");
                break;
            }
            case Input.Keys.A: {
                log.error("被按下的按键: A键");
                break;
            }
            case Input.Keys.ENTER: {
                log.error("被按下的按键: 回车键");
                break;
            }
            default: {
                log.error("其他按键, KeyCode: " + keycode);
                break;
            }
        }
        return false;
    }
}