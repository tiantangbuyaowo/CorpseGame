package org.tj.game.actor.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.NoArgsConstructor;
import org.tj.game.res.Res;


public class AnimationAtor extends Actor {


    protected TextureRegion[] walkFrames;
    // 摇头动画
    protected Animation walkAnimation;

    protected TextureRegion currentFrame;

    // 状态时间, 渲染时间步 delta 的累加值
    private float stateTime;


    public AnimationAtor(String[] animationFile, float x, float y) {
        this(animationFile, x, y, 0, 0);
    }

    public AnimationAtor(String[] animationFile, float x, float y, float textureRegionx, float textureRegiony) {
        initAnimation(animationFile, x, y, (int) textureRegionx, (int) textureRegiony);
    }

    /**
     * 初始化一下动画
     * @param animationFile
     * @param x
     * @param y
     * @param textureRegionx
     * @param textureRegiony
     */
    private void initAnimation(String[] animationFile, float x, float y, int textureRegionx, int textureRegiony) {
        walkFrames = new TextureRegion[animationFile.length];
        for (int i = 0; i < animationFile.length; i++) {
            //如果有宽度就截取，否则就按所有的长度来
            Texture texture = Res.assetManager.get(animationFile[i], Texture.class);
            walkFrames[i] = new TextureRegion(texture, textureRegionx, textureRegiony, texture.getWidth(), texture.getHeight());

        }
        walkAnimation = new Animation(0.3F, walkFrames);
        walkAnimation.setPlayMode(Animation.PlayMode.LOOP);
        this.setX(x);
        this.setY(y);
        //设置演员的尺寸
        this.setSize(walkFrames[0].getRegionWidth(), walkFrames[0].getRegionHeight());
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (null == walkFrames || !isVisible()) {
            return;
        }
        // 累加时间步（stateTime 也可表示游戏的运行时间）
        stateTime += Gdx.graphics.getDeltaTime();

        // 根据当前 播放模式 获取当前关键帧, 就是在 stateTime 这个时刻应该播放哪一帧
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime);

        batch.draw(new TextureRegion(currentFrame), getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
