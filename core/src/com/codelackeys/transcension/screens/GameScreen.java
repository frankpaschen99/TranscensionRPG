package com.codelackeys.transcension.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codelackeys.transcension.CoreGame;
import com.codelackeys.transcension.debug.DeveloperHud;

public class GameScreen implements Screen, InputProcessor {
	
	SpriteBatch batch;
	Sprite world;
	public OrthographicCamera camera;
	int WORLD_HEIGHT = 240;
	int WORLD_WIDTH = 320;
	
	Viewport viewport;
	
	public GameScreen(CoreGame game) {
		batch = new SpriteBatch();
		
		world = new Sprite(new Texture(Gdx.files.internal("level.png")));
		world.setSize(WORLD_WIDTH, WORLD_HEIGHT);
		
		camera = new OrthographicCamera();
		
		viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
		viewport.apply();
		
		Gdx.input.setInputProcessor(this);
	
	}
	
	@Override
	public void show() {
		
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,  0,  0,  1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		world.draw(batch);
		DeveloperHud.draw(batch, this);
		
		batch.end();
		
		camera.update();
		
		
	}
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
	}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {
		world.getTexture().dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if (keycode == Keys.LEFT)
			camera.translate(-1f, 0);
		if (keycode == Keys.RIGHT)
			camera.translate(1f, 0);
		if (keycode == Keys.UP)
			camera.translate(0, 1f);
		if (keycode == Keys.DOWN)
			camera.translate(0, -1f);
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
