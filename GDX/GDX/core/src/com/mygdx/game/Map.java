package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Game;

public class Map extends Game {
	private SpriteBatch batch;
	private GameScreen screen;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		screen = new GameScreen(batch);
		setScreen(screen);
	}

	@Override
	public void render() {
		super.render();
	}

	public void dispose () {

	}
}
