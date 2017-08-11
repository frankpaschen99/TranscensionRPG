package com.codelackeys.transcension.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.codelackeys.transcension.maputils.World;
import com.codelackeys.transcension.screens.GameScreen;

public final class DeveloperHud {
	
	private static FreeTypeFontGenerator generator;
	private static FreeTypeFontParameter parameter;
	private static BitmapFont font12;
	private static OrthographicCamera devCam;
	static {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("consola.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 14;
		font12 = generator.generateFont(parameter); // font size 12 pixels
		font12.setColor(Color.BLACK);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		// pixel perfect ortho cam for text rendering
		devCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		devCam.setToOrtho(false);	// center the camera
		devCam.update();
	}
	public static void setColor(Color color) {
		font12.setColor(color);
	}
	public static void draw(SpriteBatch batch, GameScreen debugScreen) {
		StringBuilder sb = new StringBuilder();
		sb.append("FPS: " + Gdx.graphics.getFramesPerSecond() + " | ");
		sb.append("ScrPos: (" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight() + ") | ");
		sb.append("CamPos: (" + debugScreen.camera.position.x + ", " + debugScreen.camera.position.y + ") | ");
		sb.append("MousePos: (" + Gdx.input.getX() + ", " + Gdx.input.getY() + ") |\n");
		sb.append("CurMap: " + World.getMapName() + " | ");
		
		batch.setProjectionMatrix(devCam.combined);
		font12.draw(batch, sb, 0, devCam.viewportHeight - font12.getCapHeight());
	}
}
