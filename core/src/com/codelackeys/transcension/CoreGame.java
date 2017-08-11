package com.codelackeys.transcension;

import com.badlogic.gdx.Game;
import com.codelackeys.transcension.screens.GameScreen;

public class CoreGame extends Game {
	
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
