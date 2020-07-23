package org.tj.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.actor.BackImageActor;
import org.tj.game.actor.LineMapGroup;
import org.tj.game.listener.LineMapInputListener;
import org.tj.game.res.Res;

/**
 * 游戏场景
 */
@Slf4j
public class GameStage extends Stage {


    public GameStage() {

        Texture bk = Res.assetManager.get(Res.BK_PATH);
        BackImageActor backImage = new BackImageActor(bk, 0, 0);

        Texture chose = Res.assetManager.get(Res.CHOSE_PATH);
        Image choseImage = new Image(chose);
        choseImage.setY(Gdx.graphics.getHeight() - choseImage.getHeight());
        this.addActor(backImage);
        this.addActor(choseImage);
        Music music = Res.assetManager.get(Res.BGM, Music.class);
        music.setLooping(true);
        music.play();
        /**
         * 安排上五个地图行
         */
        for (int i = 0; i < 5; i++) {
            LineMapGroup lineMapGroup = new LineMapGroup(i);
            this.addActor(lineMapGroup);
            lineMapGroup.addListener(new LineMapInputListener(lineMapGroup));
        }


    }

}
