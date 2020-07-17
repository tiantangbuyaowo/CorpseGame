package org.tj.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.tj.game.MyCorpseGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		float scale = 0.6F;            // 适当改变窗口缩放比以适应自己的电脑屏幕

		/*
		 * 窗口（实际屏幕）宽高比设置为 480:800, 与视口世界的宽高比相同, 所以最终显示到屏幕上的内容将不会被压扁或拉长
		 */
		config.width = (int) (800 * scale);         // 窗口宽度
		config.height = (int) (540 * scale);        // 窗口高度
		config.resizable = false;   // 窗口设置为大小不可改变
		new LwjglApplication(new MyCorpseGame(), config);
	}
}
