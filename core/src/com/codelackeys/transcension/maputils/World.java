package com.codelackeys.transcension.maputils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
	public static void render(OrthographicCamera camera) {
		renderer.setView(camera);
		renderer.render();
	}
	public static String getMapName() {
		return mapName;
	}
}
