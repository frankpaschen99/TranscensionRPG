package com.codelackeys.transcension.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.codelackeys.transcension.CoreGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CoreGame(), config);
		// Actual screen dimensions
		config.width = 800;
		config.height = 600;
		config.resizable = true;
		config.fullscreen = false;
	}
}
