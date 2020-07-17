package org.tj.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.SunFlowerActor;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.res.Res;

@Slf4j
public class GameScreen implements Screen {

    private MyCorpseGame myCorpseGame;

    private Stage stage;

    public GameScreen(MyCorpseGame myCorpseGame) {
        this.myCorpseGame = myCorpseGame;
        Texture bk = Res.assetManager.get(Res.BK_PATH);
        Image backImage = new Image(bk);
        backImage.setHeight(bk.getHeight());
        backImage.setWidth(bk.getWidth());
        stage = new Stage();
        stage.addActor(backImage);


        Gdx.input.setInputProcessor(stage);
        stage.addListener(new MyInputListener());
/*        for (int i = 4; i >= 0; i--) {
            SunFlowerActor flowerActor = new SunFlowerActor(40, 30 + i * 50);
            flowerActor.setName("flower" + i);
            stage.addActor(flowerActor);

        }
        Array<Actor> actors = stage.getActors();
        System.out.println(actors.get(0).getZIndex());*/


    }


    /**
     * 输入事件监听器（包括触屏, 鼠标点击, 键盘按键 的输入）
     */
    private class MyInputListener extends InputListener {

        /**
         * 手指/鼠标 抬起时调用
         */
        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            //AnimationAtor flowerActor = new AnimationAtor(Res.SUNFLOWER_PATH, x - 40, y - 10);
            AnimationAtor pease = new AnimationAtor(Res.PEASE_PATH, x - 40, y - 10);
            //flowerActor.setName("flower" + i);
            stage.addActor(pease);
        }

        @Override
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            //log.error( "touchDown: " + x + ", " + y + "; pointer: " + pointer);
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
