package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Tilemap {

    public LinkedList<Tile> base;
    public LinkedList<Tile> objects;
    private Texture hill;
    private Texture water;
    private Texture grass;
    private Texture tree;
    private String[][] map;

    public Tilemap() {
        grass = new Texture("grass.png");
        water = new Texture("water.png");
        hill = new Texture("hill.png");
        base = new LinkedList<Tile>();
        objects = new LinkedList<Tile>();
        map = new String[15][15];
        try {
            fillMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(SpriteBatch batch) {
        for (Tile t : base) {
            t.render(batch);
        }
        for (Tile t : objects) {
            t.render(batch);
        }
    }

    public void fillMap() throws IOException {
        FileHandle fh = Gdx.files.internal("/Users/akarensutharsan/Downloads/GDX/core/src/com/mygdx/game/mapBase.txt");
        BufferedReader br = new BufferedReader(new FileReader(fh.path()));
        String s = "";
        int count = 0;
        while((s = br.readLine()) != null) {
            map[count] = s.split(" ");
            count++;
        }
        br.close();

        Random r = new Random();
        for (int row = 14; row >= 0; row--) {
            for (int col = 14; col >= 0; col--) {

                float x = (row-col) * 64 /2.0001f;
                float y = (col + row)* 32/2f;

                if (col == 0 || col == 14)
                    base.add(new Tile(hill, new Vector2(row, col), new Vector2 (x,y)));

                else if (row == 0 || row == 14)
                    base.add(new Tile(hill, new Vector2(row, col), new Vector2 (x,y)));

                else {
                    if ((map[row][col]).equals("g"))
                        base.add(new Tile(grass, new Vector2(row, col), new Vector2(x, y)));
                    else if ((map[row][col]).equals("w"))
                        base.add(new Tile(water, new Vector2(row, col), new Vector2(x, y)));
                }
            }
        }
    }






















}
