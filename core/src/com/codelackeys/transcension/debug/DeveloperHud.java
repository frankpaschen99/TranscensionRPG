package com.codelackeys.transcension.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.codelackeys.transcension.screens.GameScreen;

public final class DeveloperHud {
	
	private static FreeTypeFontGenerator generator;
	private static FreeTypeFontParameter parameter;
	private static BitmapFont font12;
	private static OrthographicCamera devCam;
	static {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("consola.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		font12 = generator.generateFont(parameter); // font size 12 pixels
		font12.setColor(Color.BLACK);
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		devCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		devCam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	}
	
	public static void draw(SpriteBatch batch, GameScreen debugScreen) {
		CharSequence hudString = "FPS: " + Gdx.graphics.getFramesPerSecond() 
		+ " | " 
		+ "ScrPos: (" 
		+ Gdx.graphics.getWidth() 
		+ ", " 
		+ Gdx.graphics.getHeight()
		+ ") | "
		+ "CamPos: ("
		+ debugScreen.camera.position.x 
		+ ", "
		+ debugScreen.camera.position.y
		+ ")";
		batch.setProjectionMatrix(devCam.combined);
		font12.draw(batch, hudString, 0, Gdx.graphics.getHeight() - font12.getCapHeight());
		devCam.update();
	}
}
