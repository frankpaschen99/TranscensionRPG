package com.codelackeys.transcension.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	private Sprite sprite;
	
	public Player() { 
		sprite = new Sprite(new Texture(Gdx.files.internal("sprite.png")));
	}
	public void render(SpriteBatch batch) {
		
		// update logic/drawing
		
		batch.draw(sprite, sprite.getX(), sprite.getY());
	}
	
}
