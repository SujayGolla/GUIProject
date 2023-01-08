package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen extends ScreenAdapter {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Tilemap map;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
        camera = new OrthographicCamera(1000,500);
        map = new Tilemap();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor((float) 115/255,(float) 215/255,(float) 255/255,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        cameraInput();
        camera.update();
        batch.begin();
        map.render(batch);
        batch.end();
    }

    private void cameraInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.A))
            camera.position.x -= 1;
        else if(Gdx.input.isKeyPressed(Input.Keys.D))
            camera.position.x += 1;
        else if(Gdx.input.isKeyPressed(Input.Keys.W))
            camera.position.x += 1;
        else if(Gdx.input.isKeyPressed(Input.Keys.S))
            camera.position.x -= 1;
        else if(Gdx.input.isKeyPressed(Input.Keys.Z))
            camera.zoom -= 0.005;
        else if(Gdx.input.isKeyPressed(Input.Keys.Y))
            camera.zoom += 0.005;
     }
}
