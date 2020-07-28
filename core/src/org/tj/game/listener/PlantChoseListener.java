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
import org.tj.game.stage.GameStage;

/**
 * 植物点击事件
 */
@Slf4j
public class PlantChoseListener extends InputListener {

    private int type;

    public PlantChoseListener(int type) {
        this.type = type;
    }

    /**
     * 手指/鼠标 抬起时调用
     */
    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        log.error("touchUp: " + x + ", " + y + "; pointer: " + pointer);
        GameStage.currentPlantType = type;

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