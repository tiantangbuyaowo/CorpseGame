package org.tj.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.tj.game.res.Res;
import org.tj.game.screen.GameScreen;

public class MyCorpseGame extends Game {


    private GameScreen gameScreen;


    @Override
    public void create() {
        initResource();
        gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }

    /**
     * 初始化资源
     */
    private void initResource() {
        Res.assetManager.load(Res.BK_PATH, Texture.class);
        //向日葵
        for (String name : Res.SUNFLOWER_PATH) {
            Res.assetManager.load(name, Texture.class);
        }
        //豌豆射手
        for (String name : Res.PEASE_PATH) {
            Res.assetManager.load(name, Texture.class);
        }
        Res.assetManager.finishLoading();
    }


    @Override
    public void dispose() {
        if (null != gameScreen) {
            gameScreen.dispose();
        }
    }
}
