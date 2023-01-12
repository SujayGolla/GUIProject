/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends JPanel {
    private char[][] map;
    private ArrayList<ShopItem> tiles;
    private Scanner sc;
    private ShopItem currentItem = null;
    public Map(){
        try {
            sc = new Scanner(new File("Map.txt"));
            new Inventory();
        } catch (Exception e) {
            System.out.println(e);
        }
        map = new char[20][40];
        tiles = new ArrayList<ShopItem>();
        for(int i = 0; i < map.length; i++){
            for(int j= 0; j < map[i].length; j++){
                map[i][j] = sc.next().charAt(0);
                if(map[i][j] == 'g') {
                    addToTiles("Grass", i, j);
                } else if(map[i][j] == 'w'){
                    addToTiles("Water", i, j);
                } else if(map[i][j] == 'm'){
                    addToTiles("Mountains", i, j);
                }
            }
        }
        ArrayList<ArrayList<ShopItem>> inventory = Inventory.getInventory();
        for(ArrayList<ShopItem> a : inventory){
            for(ShopItem s : a){
                if(s.getX() != -1 && s.getY() != -1){
                    tiles.add(s);
                }
            }
        }
    }
    public void addToTiles(String name, int i, int j){
        ShopItem s = ShopItem.getShopItem(name);
        s.setX(j*30);
        s.setY(i*30);
        tiles.add(s);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < tiles.size(); i++){
            tiles.get(i).myDraw(g);
        }
        if(currentItem != null)
            currentItem.myDraw(g);
    }
}