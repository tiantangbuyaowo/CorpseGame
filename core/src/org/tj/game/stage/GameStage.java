package org.tj.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.BackImageActor;
import org.tj.game.actor.CorpseActor;
import org.tj.game.actor.PeaseActor;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.model.MapPoint;
import org.tj.game.res.Res;

import java.util.Map;

/**
 * 游戏场景
 */
@Slf4j
public class GameStage extends Stage {

    private MapPoint[][] mapPoints = MapPoint.getMapPoints();


    public GameStage() {

        Texture bk = Res.assetManager.get(Res.BK_PATH);
        BackImageActor backImage = new BackImageActor(bk, 0, 0);

        Texture chose = Res.assetManager.get(Res.CHOSE_PATH);
        Image choseImage = new Image(chose);
        choseImage.setY(Gdx.graphics.getHeight() - choseImage.getHeight());
        this.addActor(backImage);
        this.addActor(choseImage);


        backImage.addListener(new MyInputListener(this));


        //增加僵尸
        AnimationAtor corpseActor = new CorpseActor(Res.CORPSE_WALK_PASH, MyCorpseGame.WORLD_WIDTH - 1000, 45, 70, 0);
        this.addActor(corpseActor);

        //增加僵尸
        AnimationAtor corpseAttachActor = new CorpseActor(Res.CORPSE_HEAD_ATTACK_PASH, MyCorpseGame.WORLD_WIDTH - 1000, 45 + MapPoint.height, 0, 0);
        this.addActor(corpseAttachActor);


    }


    /**
     * 输入事件监听器（包括触屏, 鼠标点击, 键盘按键 的输入）
     */
    private class MyInputListener extends InputListener {
        private GameStage gameStage;

        public MyInputListener(GameStage gameStage) {
            this.gameStage = gameStage;
        }

        /**
         * 手指/鼠标 抬起时调用
         */
        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
           /* AnimationAtor pease = new PeaseActor(Res.PEASE_PATH, x - 40, y - 10);
            gameStage.addActor(pease);*/

            //计算出点的是哪个point

            MapPoint clickPoint = getClinkPoint(x, y);
            if (null == clickPoint) {
                //没点到地图位置，或者里头已经有了植物，就啥也不干
                return;
            }


            //否则生成豌豆射手
            AnimationAtor pease = new PeaseActor(Res.PEASE_PATH, clickPoint.getLeftDown().x, clickPoint.getLeftDown().y);
            gameStage.addActor(pease);


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

    private MapPoint getClinkPoint(float x, float y) {

        //这就是在地图外的点击
        if (x > MapPoint.rightx || x < MapPoint.leftx || y > MapPoint.upy || y < MapPoint.downy) {
            return null;
        }


        /*//在地图里头，就是要算是在哪个点了
        int indexX = (int) ((x - MapPoint.leftx) / MapPoint.width);
        int indexY = (int) ((y - MapPoint.downy) / MapPoint.height);*/

        for (int i = 0; i < 5; i++) {
            for (int a = 0; a < 9; a++) {

                if (x > mapPoints[i][a].getLeftDown().x && x < mapPoints[i][a].getRightDown().x && y > mapPoints[i][a].getLeftDown().y && y < mapPoints[i][a].getRightUp().y) {
                    synchronized (GameStage.class) {
                        if (mapPoints[i][a].isHasPlant()) { //如果已经有植物了
                            return null;
                        }

                        //设置为有植物了
                        mapPoints[i][a].setHasPlant(true);
                        return mapPoints[i][a];
                    }
                }
            }
        }


        return null;
    }

}
