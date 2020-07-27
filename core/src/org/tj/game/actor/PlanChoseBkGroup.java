package org.tj.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import org.tj.game.res.Res;

public class PlanChoseBkGroup extends Group {


    //private

    private Image backImage;


    public PlanChoseBkGroup() {
        init();
    }

    /**
     * 初始化一手
     */
    private void init() {
        backImage = new Image(Res.assetManager.get(Res.CHOSE_PATH, Texture.class));
        this.setWidth(backImage.getWidth());
        this.setHeight(backImage.getHeight());
        this.setY(Gdx.graphics.getHeight() - this.getHeight());
        this.addActor(backImage);

        //选择flower
        Image image = new Image(Res.assetManager.get(Res.FLOWER_CHOSE, Texture.class));
        image.setX(75);
        image.setY(10);
        this.addActor(image);

    }
}
