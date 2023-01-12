/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;



public class Homepage extends JPanel implements ActionListener, MouseWheelListener{
  
      private double zoomFactor = 1;
      private double prevZoomFactor = 1;
      private boolean zoomer;
  
    
    private char[][] map;
    private ArrayList<ShopItem> tiles;
    private Scanner sc;
    private ShopItem currentItem = null;
    private JButton shop, inventoryBtn;
    public Homepage(){
        try {
            sc = new Scanner(new File("Map.txt"));
            new Inventory();
            new Game();
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

        shop = new JButton(new ImageIcon("shop.png"));
        shop.setBorderPainted(false);
        shop.setContentAreaFilled(false);
        shop.setOpaque(false);
        shop.addActionListener(this);
        Dimension size = shop.getPreferredSize();
        shop.setBounds(15,  475, size.width, size.height);
        this.add(shop);

        inventoryBtn = new JButton(new ImageIcon("edit.png"));
        inventoryBtn.setBorderPainted(false);
        inventoryBtn.setContentAreaFilled(false);
        inventoryBtn.setOpaque(false);
        inventoryBtn.addActionListener(this);
        size = inventoryBtn.getPreferredSize();
        inventoryBtn.setBounds(985, 475, size.width, size.height);
        this.add(inventoryBtn);
    }
    public void addToTiles(String name, int i, int j){
        ShopItem s = ShopItem.getShopItem(name);
        s.setX(j*30);
        s.setY(i*30);
        tiles.add(s);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        addMouseWheelListener(this);
        Graphics2D g3 = (Graphics2D) g;
        if (zoomer) {
          AffineTransform at = new AffineTransform();
          at.scale(zoomFactor, zoomFactor);
          prevZoomFactor = zoomFactor;
          g3.transform(at);
          zoomer = false;
    }
          
        for(int i = 0; i < tiles.size(); i++){
            tiles.get(i).myDraw(g);
        }
        if(currentItem != null)
            currentItem.myDraw(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0,100));
        g2.fillRoundRect(50,20,100,25,20,20);
        g2.fillRoundRect(50,60,100,25,20,20);
        g2.fillRoundRect(850,20,100,25,20,20);
        g2.fillRoundRect(850,60,100,25,20,20);

        g2.setPaint(new GradientPaint(50, 20, new Color(8, 238, 179), 50+Game.getXp()%100, 45, new Color(0, 69, 146)));
        g2.fillRoundRect(50,20, Game.getXp()%100, 25,20,20);
        g2.fillRoundRect(50,60, Game.getPopulation()*100 / Game.getMaxPopulation(), 25,20,20);

        g.drawImage(new ImageIcon("star.png").getImage(), 17,7, null);
        g.drawImage(new ImageIcon("population.png").getImage(), 17,47, null);
        g.drawImage(new ImageIcon("coin.png").getImage(), 827,7, null);
        g.drawImage(new ImageIcon("cash.png").getImage(), 827,47, null);

        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Monospaced", Font.BOLD, 18));
        g.drawString("" + Game.getLvl(), 37,36);
        g.drawString(Game.getPopulation() + "/" + Game.getMaxPopulation(), 78,78);
        g.drawString(""+Game.getCoins(), 885, 38);
        g.drawString(""+Game.getCash(), 885, 78);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shop)
            Cards.flipToCard("Shop");
        else if(e.getSource() == inventoryBtn)
            Cards.flipToCard("Inventory");
    }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    zoomer = true;
    //Zoom in
    if (e.getWheelRotation() < 0) {
        zoomFactor *= 1.05;
        repaint();
    }
    //Zoom out
    if (e.getWheelRotation() > 0) {
        zoomFactor /= 1.05;
        repaint();
    }
}

}