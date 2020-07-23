package org.tj.game.actor;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.tj.game.MyCorpseGame;
import org.tj.game.actor.base.AnimationAtor;
import org.tj.game.model.MapPoint;
import org.tj.game.res.Res;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


/**
 * 单行地图演员组
 */
@Slf4j
public class LineMapGroup extends Group {


    public static float LEFTX = 115;
    public static float RIGHTX = 870;

    public static float DOWNY = 52;
    public static float UPY = 567;

    public static float WIDTH = (RIGHTX - LEFTX) / 9;
    public static float HEIGHT = (UPY - DOWNY) / 5;

    /**
     * 要知道当前行是第几行，从下往上，用来计算y的索引
     */
    private int lineIndex;

    /**
     * 当前行所拥有的射手
     */
    @Getter
    @Setter
    private List<PeaseActor> peaseActorss;


    /**
     * 当前行所拥有的僵尸
     */
    @Getter
    @Setter
    private List<CorpseActor> corpseActors;


    /* *//**
     * 当前行拥有的子弹
     *//*
    @Getter
    @Setter
    private List<BulletActor> bulletActors;
*/
    /**
     * 需要有九个格子
     */
    private MapPoint[] mapPoints;

    public LineMapGroup(int lineIndex) {

        // this.bulletActors = new ArrayList<>();
        this.corpseActors = new ArrayList<>();
        this.peaseActorss = new ArrayList<>();

        this.lineIndex = lineIndex;
        this.setX(LEFTX);
        this.setY(this.lineIndex * HEIGHT + DOWNY);
        this.setSize(RIGHTX - LEFTX, UPY - DOWNY);
        init();
    }

    private void init() {

        MyCorpseGame.EVENTBUS.register(this);
        //初始化九个格子
        mapPoints = new MapPoint[9];
        for (int i = 0; i < mapPoints.length; i++) {
            mapPoints[i] = new MapPoint(WIDTH * i, 0, WIDTH, HEIGHT);
        }


        //增加僵尸
        AnimationAtor corpseActor = new CorpseActor(this, Res.CORPSE_WALK_PASH, WIDTH * 8, 0, 70, 0);
        this.addActor(corpseActor);

/*        //增加僵尸
        AnimationAtor corpseAttachActor = new CorpseActor(Res.CORPSE_HEAD_ATTACK_PASH, width * 7, 0, 0, 0);
        this.addActor(corpseAttachActor);*/
    }


    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);

        if (actor instanceof BulletActor) {
            // this.getBulletActors().add((BulletActor) actor);
        } else if (actor instanceof PeaseActor) {
            //播放安放植物的音乐
            Res.assetManager.get(Res.ADDPLANT, Music.class).play();
            this.getPeaseActorss().add((PeaseActor) actor);
        } else if (actor instanceof CorpseActor) {
            this.getCorpseActors().add((CorpseActor) actor);
        }

    }


    /**
     * 获取被点击的格子,防止疯狂点击出错，这里加锁
     *
     * @param x
     * @param y
     * @return
     */
    public synchronized MapPoint getClickPoint(float x, float y) {
        //算出索引
        int index = (int) (x / WIDTH);
        if (!mapPoints[index].isHasPlant()) { //还没有植物了
            mapPoints[index].setHasPlant(true);
            return mapPoints[index];
        }
        return null;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }


}
