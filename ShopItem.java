/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;
import java.awt.*;

public class ShopItem {
    protected final String name;
    protected final int price;
    protected final ImageIcon img;
    protected final ImageIcon[] animations;
    protected final int unlockLVL;
    protected int x = -1;
    protected int y = -1;
    protected static final int numFactories = 6;
    protected static final int numHouses = 4;
    protected static final int numFarms = 3;
    protected static final int numCrops = 7;
    protected static final int numBasics = 3;
    protected static final int numSpecials = 3;

    public ShopItem(String name, int price, ImageIcon img, ImageIcon[] animations, int unlockLVL){
        try {
            new Game();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.name = name;
        this.price = price;
        this.img = img;
        this.animations = animations;
        this.unlockLVL = unlockLVL;
    }

    public ShopItem(String name, ImageIcon img){
        try {
            new Game();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.name = name;
        this.price = 0;
        this.img = img;
        this.animations = null;
        this.unlockLVL = 0;
    }

    public void purchaseItem() throws Exception {
        if(canBuyItem()) {
            Game.setCoins(Game.getCoins() - price);
            Game.setXp(Game.getXp() + 10);
        }else {
            if(Game.getLvl() < unlockLVL)
                JOptionPane.showMessageDialog(Cards.c, "You haven't reached Level " + unlockLVL + " yet.", "Can't buy", JOptionPane.WARNING_MESSAGE);
            else if (Game.getCoins() - price >= 0)
                JOptionPane.showMessageDialog(Cards.c, "You don't have enough coins.", "Can't buy", JOptionPane.WARNING_MESSAGE);
        }
        Game.update();
    }

    public boolean canBuyItem(){
        return isUnlocked() && Game.getCoins() - price >= 0;
    }

    public ImageIcon getImg() {
        return img;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ImageIcon[] getAnimations() {
        return animations;
    }
    public boolean isUnlocked(){
        return Game.getLvl() >= unlockLVL;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isSpecialTile(){
        return false;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getNumHouses() {
        return numHouses;
    }

    public static int getNumFactories() {
        return numFactories;
    }

    public int getPpl() {
        return 0;
    }

    public int getReqPpl(){
        return 0;
    }

    public static int getNumFarms() {
        return numFarms;
    }

    public static int getNumCrops() {
        return numCrops;
    }

    public static int getNumBasics() {
        return numBasics;
    }

    public static int getNumSpecials() {
        return numSpecials;
    }
    public void myDraw(Graphics g){
        g.drawImage(img.getImage(), x, y, 30, 30,null);
    }

    public boolean isOnTile(int mouseX, int mouseY){
        return (x <= mouseX && mouseX <= x+30 && y <= mouseY && mouseY <= y+30);
    }
    public void replaceTile(ShopItem other){
        x = other.x;
        y = other.y;
    }
    public static ShopItem getShopItem(String name){
        return switch (name) {
            case "Townhouse" -> new HouseItem("Townhouse", 50, new ImageIcon("Townhouse.png"), null, 2, 15);
            case "Bungalow" -> new HouseItem("Bungalow", 30, new ImageIcon("Bungalow.png"), null, 1, 10);
            case "Apartment" -> new HouseItem("Apartment", 150, new ImageIcon("Apartment.png"), null, 4, 50);
            case "Condos" -> new HouseItem("Condos", 300, new ImageIcon("Condo.png"), null, 8, 100);
            case "Feed Mill" -> new FactoryItem("Feed Mill", 50, new ImageIcon("Feedmill.png"), null, 1, 10);
            case "Dairy Factory" -> new FactoryItem("Dairy Factory", 50, new ImageIcon("Dairy.png"), null, 2, 25);
            case "Textile Factory" ->
                    new FactoryItem("Textile Factory", 100, new ImageIcon("Textile.png"), null, 4, 50);
            case "Meat Production" -> new FactoryItem("Meat Production", 150, new ImageIcon("Meat.png"), null, 5, 70);
            case "Bakery" -> new FactoryItem("Bakery", 200, new ImageIcon("Bakery.png"), null, 7, 100);
            case "Fast Food Restaurant" ->
                    new FactoryItem("Fast Food Restaurant", 300, new ImageIcon("Fastfood.png"), null, 9, 120);
            case "Field" -> new FarmItem("Field", 0, new ImageIcon("field.png"), null, 1, 5);
            case "Cowshed" -> new FarmItem("Cowshed", 50, new ImageIcon("Cowshed.png"), null, 1, 10);
            case "Chicken Coop" -> new FarmItem("Chicken Coop", 150, new ImageIcon("Chicken.png"), null, 2, 20);
            case "Sheep Farm" -> new FarmItem("Sheep Farm", 300, new ImageIcon("Sheep.png"), null, 5, 65);
            case "Wheat" -> new ShopItem("Wheat", 5, new ImageIcon("Wheat.png"), null, 1);
            case "Carrot" -> new ShopItem("Carrot", 5, new ImageIcon("Carrot.png"), null, 1);
            case "Corn" -> new ShopItem("Corn", 5, new ImageIcon("Corn.png"), null, 2);
            case "Rice" -> new ShopItem("Rice", 5, new ImageIcon("Rice.png"), null, 4);
            case "Apples" -> new ShopItem("Apples", 10, new ImageIcon("Apple.png"), null, 5);
            case "Strawberry" -> new ShopItem("Strawberry", 10, new ImageIcon("Strawberry.png"), null, 6);
            case "Cotton" -> new ShopItem("Cotton", 5, new ImageIcon("Cotton.png"), null, 2);
            case "Tomatoes" -> new ShopItem("Tomatoes", 5, new ImageIcon("Tomato.png"), null, 3);
            case "Roads" -> new ShopItem("Roads", 0, new ImageIcon("Road.png"), null, 1);
            case "Gravel" -> new ShopItem("Gravel", 0, new ImageIcon("Gravel.png"), null, 1);
            case "Tiles" -> new ShopItem("Tiles", 0, new ImageIcon("Tiles.png"), null, 1);
            case "Barn" -> new ShopItem("Barn", 0, new ImageIcon("Barn.png"), null, 1);
            case "Townhall" -> new ShopItem("Townhall", 0, new ImageIcon("Townhall.png"), null, 2);
            case "Fountain" -> new ShopItem("Fountain", 200, new ImageIcon("Fountain.png"), null, 3);
            case "Grass" -> new SpecialTiles("Grass", new ImageIcon("grass.png"));
            case "Water" -> new SpecialTiles("Water", new ImageIcon("water.png"));
            default -> null;
        };
    }
}