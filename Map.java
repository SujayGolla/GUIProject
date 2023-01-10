import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends JPanel implements MouseMotionListener, MouseListener {
    private char[][] map;
    private ArrayList<ShopItem> tiles;
    private Scanner sc;
    private ShopItem currentItem = null;
    public Map(){
        try {
            sc = new Scanner(new File("Map.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        map = new char[15][15];
        tiles = new ArrayList<ShopItem>();
        for(int i = 0; i < map.length; i++){
            for(int j= 0; j < map[i].length; j++){
                map[i][j] = sc.next().charAt(0);
                if(map[i][j] == 'g') {
                    ShopItem s = ShopItem.getShopItem("Grass");
                    s.setX(j*30);
                    s.setY(i*30);
                    tiles.add(s);
                } else if(map[i][j] == 'w'){
                    ShopItem s = ShopItem.getShopItem("Water");
                    s.setX(j*30);
                    s.setY(i*30);
                    tiles.add(s);
                }
            }
        }
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < tiles.size(); i++){
            tiles.get(i).myDraw(g);
        }
        if(currentItem != null)
            currentItem.myDraw(g);
    }
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(int i = 0; i < tiles.size(); i++){
            if(tiles.get(i).isOnTile(e.getX(), e.getY())) {
                currentItem = tiles.get(i);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i = 0; i < tiles.size(); i++){
            if(tiles.get(i).isOnTile(e.getX(), e.getY()) && currentItem != null) {
                currentItem.replaceTile(tiles.get(i));
                tiles.set(i, currentItem);
            }
        }
        repaint();
        currentItem = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(currentItem != null){
            currentItem.setX(e.getX());
            currentItem.setY(e.getY());
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}