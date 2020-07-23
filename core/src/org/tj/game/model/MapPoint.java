package org.tj.game.model;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;

/**
 * 植物僵尸运动地图的坐标封装对象
 */
@Getter
@Setter
public class MapPoint {

    /**
     * 左下坐标
     */
    private Vector2 leftDown;
    /**
     * 右下坐标
     */
    private Vector2 rightDown;
    /**
     * 左下坐标
     */
    private Vector2 leftUp;
    /**
     * 右上坐标
     */
    private Vector2 rightUp;

    /**
     * 是否已经有植物
     */

    private boolean hasPlant = false;

    public MapPoint(float x, float y, float width, float height) {
        Vector2 leftDown = new Vector2(x, y);
        Vector2 rightDown = new Vector2(leftDown.x + width, leftDown.y);
        Vector2 leftUp = new Vector2(leftDown.x, leftDown.y + height);
        Vector2 rightUp = new Vector2(leftUp.x + width, leftUp.y);
        this.setLeftDown(leftDown);
        this.setRightDown(rightDown);
        this.setLeftUp(leftUp);
        this.setRightUp(rightUp);

    }


}
