package com.codelackeys.transcension.maputils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

public final class World {
	private static OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(null, 1);
	private static TiledMap currentMap;
	private static String mapName = "";
	
	public static void setMap(String mapFile) {
		if (renderer.getMap() != null)
			renderer.getMap().dispose();
		currentMap = new TmxMapLoader().load(mapFile);
		renderer.setMap(currentMap);
		mapName = mapFile;
	}
	public static void stop() {
		if (renderer.getMap() != null)
			renderer.getMap().dispose();
	}
	public static void render(OrthographicCamera camera) {
		renderer.setView(camera);
		renderer.render();
	}
	public static int distanceBetween(Vector2 v1, Vector2 v2) {
		return (int) Math.sqrt(Math.pow((v2.x - v1.x), 2) + Math.pow((v2.y - v1.y), 2));
	}
	public static String getMapName() {
		return mapName;
	}
}
