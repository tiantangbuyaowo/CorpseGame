package org.tj.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.BulletActor;
import org.tj.game.actor.CorpseActor;
import org.tj.game.actor.PeaseActor;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.event.PeaseCreateEvent;
import org.tj.game.res.Res;
import org.tj.game.stage.GameStage;

@Slf4j
public class GameScreen implements Screen {

    private MyCorpseGame myCorpseGame;

    private GameStage stage;

    public GameScreen(MyCorpseGame myCorpseGame) {

        MyCorpseGame.EVENTBUS.register(this);
        this.myCorpseGame = myCorpseGame;
        stage = new GameStage();
        Gdx.input.setInputProcessor(stage);

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


    //eventbus事件

    /**
     * 产生豌豆射手监听事件
     *
     * @param peaseCreateEvent 消息
     */
    @Subscribe
    public void createBullet(PeaseCreateEvent peaseCreateEvent) {

        //在场景中生成一个子弹
        BulletActor bullet = new BulletActor((PeaseActor) peaseCreateEvent.getActor());
        stage.addActor(bullet);

    }


}
