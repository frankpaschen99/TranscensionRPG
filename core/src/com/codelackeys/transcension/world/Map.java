package com.codelackeys.transcension.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.codelackeys.transcension.utils.Constants;

public class Map {
	private Texture texture;
	private Cell[][] tiles = new Cell[60][60];
	
	public Map() {
		
	}
	public void draw() {
		
	}
	public Cell getTile(Vector2 c) {
		return tiles[(int) c.x][(int) c.y];
	}
	public int[] getTileFromPos(Vector2 pos) {
		// somehow i wrote this
		return new int[]{(int) (Math.floor(pos.x / Constants.CELL_SIZE)), (int) (Math.floor(pos.y / Constants.CELL_SIZE))};
	}
}
