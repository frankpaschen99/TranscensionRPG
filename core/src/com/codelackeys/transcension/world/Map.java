package com.codelackeys.transcension.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMapTileLayer collisionObjectLayer;
	private MapObjects objects;
	private Batch batch;
	private static OrthographicCamera camera;
	private float unitScale = 1 / 32f;
	
	public Map(String json) {
		map = new TmxMapLoader().load(json.split(".")[1] == "json" ? getTmxFromJSON(json) : json);
		renderer = new OrthogonalTiledMapRenderer(map, unitScale);
		batch = renderer.getBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 30, 20);
	}
	private String getTmxFromJSON(String json) {
		return "do this";
	}
	public void render() {
		renderer.setView(camera);
		renderer.render();
	}
	public void dispose() {
		map.dispose();
		renderer.dispose();
		batch.dispose();
	}
}
