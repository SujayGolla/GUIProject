import javax.swing.*;

public class ShopItem {
    private final String name;
    private final int price;
    private final ImageIcon img;
    private final ImageIcon[] animations;
    private final int unlockLVL;
    private static final int numFactories = 6;
    private static final int numHouses = 4;
    private static final int numFarms = 3;
    private static final int numCrops = 7;
    private static final int numBasics = 3;
    private static final int numSpecials = 3;

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

    public void purchaseItem() throws Exception {
        //Inventory.add(this);
        if(isUnlocked()) {
            Game.setCoins(Game.getCoins() - price);
            Game.setXp(Game.getXp() + 10);
        }else
            JOptionPane.showMessageDialog(Cards.c, "You haven't reached Level " + unlockLVL + " yet.", "Can't buy", JOptionPane.WARNING_MESSAGE);
        Game.update();
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

    public static int getNumHouses() {
        return numHouses;
    }

    public static int getNumFactories() {
        return numFactories;
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

    public static ShopItem getShopItem(String name){
        return switch (name) {
            case "Townhouse" -> new ShopItem("Townhouse", 50, new ImageIcon("Townhouse.png"), null, 1);
            case "Bungalow" -> new ShopItem("Bungalow", 30, new ImageIcon("Bungalow.png"), null, 2);
            case "Apartment" -> new ShopItem("Apartment", 150, new ImageIcon("Apartment.png"), null, 4);
            case "Condos" -> new ShopItem("Condos", 300, new ImageIcon("Condo.png"), null, 8);
            case "Feed Mill" -> new ShopItem("Feed Mill", 50, new ImageIcon("Feedmill.png"), null, 1);
            case "Dairy Factory" -> new ShopItem("Dairy Factory", 50, new ImageIcon("Dairy.png"), null, 2);
            case "Textile Factory" -> new ShopItem("Textile Factory", 100, new ImageIcon("Textile.png"), null, 4);
            case "Meat Production" -> new ShopItem("Meat Production", 150, new ImageIcon("Meat.png"), null, 5);
            case "Bakery" -> new ShopItem("Bakery", 200, new ImageIcon("Bakery.png"), null, 7);
            case "Fast Food Restaurant" -> new ShopItem("Fast Food Restaurant", 300, new ImageIcon("Fastfood.png"), null, 9);
            case "Cowshed" -> new ShopItem("Cowshed", 50, new ImageIcon("Cowshed.png"), null, 1);
            case "Chicken Coop" -> new ShopItem("Chicken Coop", 150, new ImageIcon("Chicken.png"), null, 2);
            case "Sheep Farm" -> new ShopItem("Sheep Farm", 300, new ImageIcon("Sheep.png"), null, 5);
            case "Wheat" -> new ShopItem("Wheat", 5, new ImageIcon("Wheat.png"), null, 1);
            case "Carrot" -> new ShopItem("Carrot", 5, new ImageIcon("Carrot.png"), null, 1);
            case "Corn" -> new ShopItem("Corn", 5, new ImageIcon("Corn.png"), null, 2);
            case "Rice" -> new ShopItem("Rice", 5, new ImageIcon("Rice.png"), null, 4);
            case "Apples" -> new ShopItem("Apples", 10, new ImageIcon("Apples.png"), null, 5);
            case "Strawberry" -> new ShopItem("Strawberry", 10, new ImageIcon("Strawberry.png"), null, 6);
            case "Cotton" -> new ShopItem("Cotton", 5, new ImageIcon("Cotton.png"), null, 2);
            case "Tomato" -> new ShopItem("Tomatoes", 5, new ImageIcon("Tomato.png"), null, 3);
            case "Roads" -> new ShopItem("Roads", 0, new ImageIcon("Road.png"), null, 1);
            case "Gravel" -> new ShopItem("Gravel", 0, new ImageIcon("Gravel.png"), null, 1);
            case "Tiles" -> new ShopItem("Tiles", 0, new ImageIcon("Tiles.png"), null, 1);
            case "Barn" -> new ShopItem("Barn", 0, new ImageIcon("Barn.png"), null, 1);
            case "Townhall" -> new ShopItem("Townhall", 0, new ImageIcon("Townhall.png"), null, 2);
            case "Fountain" -> new ShopItem("Fountain", 200, new ImageIcon("Fountain.png"), null, 3);
            default -> null;
        };
    }
}
