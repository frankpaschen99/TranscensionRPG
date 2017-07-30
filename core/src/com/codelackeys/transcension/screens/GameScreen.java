package com.codelackeys.transcension.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codelackeys.transcension.utils.Constants;

public class GameScreen implements Screen {
	
	SpriteBatch batch;
	Sprite sprite;
	OrthographicCamera camera;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("vetfinal.png")));
		camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
		camera.translate(camera.viewportWidth / 2, camera.viewportHeight / 2);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		batch.draw(sprite, 0, 0);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
