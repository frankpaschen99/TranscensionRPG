package com.codelackeys.transcension.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.codelackeys.transcension.CoreGame;
import com.codelackeys.transcension.debug.DeveloperHud;
import com.codelackeys.transcension.dialogue.DialogueResponse;
import com.codelackeys.transcension.dialogue.DialogueScript;
import com.codelackeys.transcension.utils.Constants;
import com.codelackeys.transcension.maputils.World;

public class GameScreen implements Screen, InputProcessor {
	
	/* Rendering / Camera */
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Viewport viewport;
	
	public GameScreen(CoreGame game) {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.position.set(Constants.WORLD_WIDTH / 2, Constants.WORLD_HEIGHT / 2, 0);
		viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);
		viewport.apply();

		// load the desert tmx
		World.setMap("desert/desert.tmx");
		
		Gdx.input.setInputProcessor(this);
		
		/** DIALOGUE TESTING - REMOVE LATER **/
		DialogueScript script = new DialogueScript("npc_speech.json");
		System.out.println(script.fetchCurrentNPCText());
		System.out.println("possible dialogue choices:");
		for (DialogueResponse r : script.fetchPossiblePlayerResponses()) {
			System.out.println(r.responseText);
		}
		script.advanceDialogue(script.fetchPossiblePlayerResponses().get(0).jumpTo);
		System.out.println(script.fetchCurrentNPCText());
		System.out.println("possible dialogue choices:");
		for (DialogueResponse r : script.fetchPossiblePlayerResponses()) {
			System.out.println(r.responseText);
		}
	}
	
	@Override
	public void show() {
		
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,  0,  0,  1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Render the current map
		World.render(camera);
		
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		
		// Developer HUD
		DeveloperHud.draw(batch, camera);
		
		batch.end();
		
		camera.update();

	}
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {}

	@Override
	public boolean keyDown(int keycode) {
		// TODO: remove this shit
		if (keycode == Keys.LEFT)
			camera.translate(-32f, 0);
		if (keycode == Keys.RIGHT)
			camera.translate(32f, 0);
		if (keycode == Keys.UP)
			camera.translate(0, 32f);
		if (keycode == Keys.DOWN)
			camera.translate(0, -32f);
		
		if (keycode == Keys.F)
			DeveloperHud.toggle();
		
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
