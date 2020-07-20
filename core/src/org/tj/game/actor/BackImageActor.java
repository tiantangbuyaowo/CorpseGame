package org.tj.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Bresenham2;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * 背景图片演员
 */
public class BackImageActor extends Actor {

    private TextureRegion texture;

    Texture result;


    public BackImageActor(Texture bk, float x, float y) {
        this.texture = new TextureRegion(bk);
        this.setX(x);
        this.setY(y);
        float bgHeight = Gdx.graphics.getHeight();
        float bgWidth = Gdx.graphics.getHeight() * (bk.getWidth() / bk.getHeight());
        this.setHeight(bgHeight);
        this.setWidth(bgWidth);


        initLine(bgHeight, (int) bgWidth);


    }

    /**
     * 画出辅助线
     *
     * @param bgHeight
     * @param bgWidth
     */
    private void initLine(float bgHeight, int bgWidth) {
        Pixmap pixmap = new Pixmap(bgWidth, (int) bgHeight, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);

        Bresenham2 bresenham = new Bresenham2();
        for (int i = 80; i < ((int) bgHeight - 50); i = (int) (i + (bgHeight - 50 - 80) / 5)) {
            for (GridPoint2 point : bresenham.line(115, i, bgWidth - 425, i))
                pixmap.drawPixel(point.x, point.y);

        }

        for (int i = 110; i < bgWidth - 430; i = (i + (bgWidth - 430 - 100) / 9)) {
            for (GridPoint2 point : bresenham.line(i + 5, (int) bgHeight - 50, i + 5, 80))
                pixmap.drawPixel(point.x, point.y);
        }


        for (GridPoint2 point : bresenham.line(bgWidth - 430 + 5, 80, bgWidth - 430 + 5, (int) bgHeight - 50))
            pixmap.drawPixel(point.x, point.y);


        result = new Texture(pixmap);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (null == texture || !isVisible()) {
            return;
        }

        batch.draw(texture, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
        batch.draw(result, 0, 0);
    }
}
