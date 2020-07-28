package org.tj.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import org.tj.game.listener.PlantChoseListener;
import org.tj.game.res.Res;

public class PlantChoseBkGroup extends Group {


    //private

    private Image backImage;


    public PlantChoseBkGroup() {
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
        image.addListener(new PlantChoseListener(0));
        this.addActor(image);

        //选择豌豆射手
        Image peaseImage = new Image(Res.assetManager.get(Res.PEASE_CHOSE, Texture.class));
        peaseImage.setX(75 + image.getWidth() + 10);
        peaseImage.setY(10);
        peaseImage.addListener(new PlantChoseListener(1));
        this.addActor(peaseImage);

    }
}
