package org.tj.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.google.common.eventbus.EventBus;
import org.tj.game.res.Res;
import org.tj.game.screen.GameScreen;

public class MyCorpseGame extends Game {

    public static final float WORLD_WIDTH = 1480;
    public static final float WORLD_HEIGHT = 1080;
    public static final EventBus EVENTBUS = new EventBus("gameBus");

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
        Res.assetManager.load(Res.CHOSE_PATH, Texture.class);
        //向日葵
        for (String name : Res.SUNFLOWER_PATH) {
            Res.assetManager.load(name, Texture.class);
        }
        //豌豆射手
        for (String name : Res.PEASE_PATH) {
            Res.assetManager.load(name, Texture.class);
        }
        //行走中的僵尸
        for (String name : Res.CORPSE_WALK_PASH) {
            Res.assetManager.load(name, Texture.class);
        }

        /**
         * 豌豆射手的子弹
         */
        Res.assetManager.load(Res.BULLET_PATH, Texture.class);

        Res.assetManager.finishLoading();
    }


    @Override
    public void dispose() {
        if (null != gameScreen) {
            gameScreen.dispose();
        }
    }
}
