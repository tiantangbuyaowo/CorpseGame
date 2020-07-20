package org.tj.game.model;

import com.badlogic.gdx.math.Vector2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 植物僵尸运动地图的坐标封装对象
 */
@Getter
@Setter
public class MapPoint {

    public static float leftx = 115;
    public static float rightx = 870;

    public static float downy = 52;
    public static float upy = 567;

    public static float width = (rightx - leftx) / 9;
    public static float height = (upy - downy) / 5;


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

    public MapPoint(Vector2 leftDown, Vector2 rightDown, Vector2 leftUp, Vector2 rightUp) {
        this.leftDown = leftDown;
        this.rightDown = rightDown;
        this.leftUp = leftUp;
        this.rightUp = rightUp;
    }

    /**
     * 拿到一个mapPoint
     *
     * @return
     */
    public static MapPoint[][] getMapPoints() {

        MapPoint[][] mapPoints = new MapPoint[5][9];


        /*左上 115, 567.0; pointer: 0
        左下 ERROR - touchDown: 115.0, 52.0; pointer: 0
        右上 ERROR - touchDown: 870.0, 567.0; pointer: 0
        右下 ERROR - touchDown: 870.0, 52.0; pointer: 0*/
        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 9; y++) {

                Vector2 leftDown = new Vector2(leftx + (y * width), (i * height) + downy);
                Vector2 rightDown = new Vector2(leftDown.x + width, leftDown.y);
                Vector2 leftUp = new Vector2(leftDown.x, leftDown.y + height);
                Vector2 rightUp = new Vector2(leftUp.x + width, leftUp.y);
                mapPoints[i][y] = new MapPoint(leftDown, rightDown, leftUp, rightUp);
            }
        }

        return mapPoints;

    }


}
