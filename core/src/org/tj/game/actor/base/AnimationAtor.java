package org.tj.game.actor.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import org.tj.game.res.Res;

public class AnimationAtor extends Actor {


    Texture[] walkFrames;
    // 摇头动画
    private Animation walkAnimation;

    private Texture currentFrame;

    // 状态时间, 渲染时间步 delta 的累加值
    private float stateTime;


    public AnimationAtor(String[] animationFile, float x, float y) {
        walkFrames = new Texture[animationFile.length];
        for (int i = 0; i < animationFile.length; i++) {
            walkFrames[i] = Res.assetManager.get(animationFile[i], Texture.class);
        }
        walkAnimation = new Animation(0.2F, walkFrames);
        walkAnimation.setPlayMode(Animation.PlayMode.LOOP);
        this.setX(x);
        this.setY(y);
        //设置演员的尺寸
        this.setSize(walkFrames[0].getWidth(), walkFrames[0].getHeight());
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
        currentFrame = (Texture) walkAnimation.getKeyFrame(stateTime);

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
