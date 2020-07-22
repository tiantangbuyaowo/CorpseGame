package org.tj.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.MyCorpseGame;
import org.tj.game.stage.GameStage;

@Slf4j
public class GameScreen implements Screen {

    private MyCorpseGame myCorpseGame;

    private GameStage stage;

    public GameScreen(MyCorpseGame myCorpseGame) {

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


}
