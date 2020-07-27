package org.tj.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
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
        initImage();
        initMusic();
        Res.assetManager.finishLoading();
    }

    private void initMusic() {
        //背景音乐
        Res.assetManager.load(Res.BGM, Music.class);
        //种植物
        Res.assetManager.load(Res.ADDPLANT, Music.class);
        //僵尸吼叫
        Res.assetManager.load(Res.CORPSEBELLOW, Music.class);
        //吐出子弹
        Res.assetManager.load(Res.ADDBULLET, Music.class);
        //子弹击中僵尸
        Res.assetManager.load(Res.ATTACHCORPSE, Music.class);
        //吃植物
        Res.assetManager.load(Res.EATPLANT, Music.class);
    }

    private void initImage() {
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

        //有头的攻击僵尸
        for (String name : Res.CORPSE_HEAD_ATTACK) {
            Res.assetManager.load(name, Texture.class);
        }
        //僵尸脑袋落地
        for (String name : Res.CORPSE_HEAD_DOWN) {
            Res.assetManager.load(name, Texture.class);
        }
        //僵尸无头移动
        for (String name : Res.CORPSE_LOST_HEAD_WALK) {
            Res.assetManager.load(name, Texture.class);
        }
        //僵尸无头攻击
        for (String name : Res.CORPSE_LOST_HEAD_ATTACK) {
            Res.assetManager.load(name, Texture.class);
        }
        //僵尸死去
        for (String name : Res.CORPSE_DIE) {
            Res.assetManager.load(name, Texture.class);
        }
        /**
         * 豌豆射手的子弹
         */
        Res.assetManager.load(Res.BULLET_PATH, Texture.class);
    }


    @Override
    public void dispose() {
        if (null != gameScreen) {
            gameScreen.dispose();
        }
    }
}
