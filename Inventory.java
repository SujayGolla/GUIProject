/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private static ArrayList<ShopItem> houses;
    private static ArrayList<ShopItem> factories;
    private static ArrayList<ShopItem> farms;
    private static ArrayList<ShopItem> basics;
    private static ArrayList<ShopItem> specials;
    private static final ArrayList<ArrayList<ShopItem>> inventory = new ArrayList<ArrayList<ShopItem>>();

    public Inventory() throws Exception {
        houses = new ArrayList<ShopItem>();
        inventory.add(houses);
        factories = new ArrayList<ShopItem>();
        inventory.add(factories);
        farms = new ArrayList<ShopItem>();
        inventory.add(farms);
        basics = new ArrayList<ShopItem>();
        inventory.add(basics);
        specials = new ArrayList<ShopItem>();
        inventory.add(specials);

        Scanner sc = new Scanner(new File("Inventory.txt"));
        
        for(ArrayList<ShopItem> a : inventory) {
            int tmp = 0;
            if(a == houses)
                tmp = ShopItem.getNumHouses();
            else if (a == factories)
                tmp = ShopItem.getNumFactories();
            else if (a == farms)
                tmp = ShopItem.getNumFarms();
            else if (a == basics)
                tmp = ShopItem.getNumBasics();
            else if (a == specials)
                tmp = ShopItem.getNumSpecials();

            sc.nextLine();
            for(int i = 0; i < tmp; i++) {
                String line = sc.nextLine();
                int numItems = Integer.parseInt(line.substring(0, line.indexOf("-")));
                String name = line.substring(line.indexOf("-") + 1);
                addItemsInitialization(a, numItems, name);
            }
            sc.nextLine();
        }
    }
    public static void addItemsInitialization(ArrayList<ShopItem> a, int n, String name){
        for(int i = 0; i < n; i++){
            a.add(ShopItem.getShopItem(name));
        }
    }
    public static void update(){
        try {
            new FileWriter("Inventory.txt", false).close();
            FileWriter gameData = new FileWriter("Inventory.txt");
            gameData.write("Houses" + "\n");
            gameData.write(specificItemCounter(houses, "Townhouse") + "-" + "Townhouse\n");
            gameData.write(specificItemCounter(houses, "Bungalow") + "-" + "Bungalow\n");
            gameData.write(specificItemCounter(houses, "Apartment") + "-" + "Apartment\n");
            gameData.write(specificItemCounter(houses, "Condos") + "-" + "Condos\n");
            gameData.write("----------\n");
            gameData.write("Factories" + "\n");
            gameData.write(specificItemCounter(factories, "Feed Mill") + "-" + "Feed Mill\n");
            gameData.write(specificItemCounter(factories, "Dairy Factory") + "-" + "Dairy Factory\n");
            gameData.write(specificItemCounter(factories, "Textile Factory") + "-" + "Textile Factory\n");
            gameData.write(specificItemCounter(factories, "Meat Production") + "-" + "Meat Production\n");
            gameData.write(specificItemCounter(factories, "Bakery") + "-" + "Bakery\n");
            gameData.write(specificItemCounter(factories, "Fast Food Restaurant") + "-" + "Fast Food Restaurant\n");
            gameData.write("----------\n");
            gameData.write("Farms" + "\n");
            gameData.write(specificItemCounter(farms, "Cowshed") + "-" + "Cowshed\n");
            gameData.write(specificItemCounter(farms, "Chicken Coop") + "-" + "Chicken Coop\n");
            gameData.write(specificItemCounter(farms, "Sheep Farm") + "-" + "Sheep Farm\n");
            gameData.write("----------\n");
            gameData.write("Basics" + "\n");
            gameData.write(specificItemCounter(basics, "Roads") + "-" + "Roads\n");
            gameData.write(specificItemCounter(basics, "Gravel") + "-" + "Gravel\n");
            gameData.write(specificItemCounter(basics, "Tiles") + "-" + "Tiles\n");
            gameData.write("----------\n");
            gameData.write("Specials" + "\n");
            gameData.write(specificItemCounter(specials, "Barn") + "-" + "Barn\n");
            gameData.write(specificItemCounter(specials, "Townhall") + "-" + "Townhall\n");
            gameData.write(specificItemCounter(specials, "Fountain") + "-" + "Fountain\n");
            gameData.write("----------\n");
            gameData.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static int specificItemCounter(ArrayList<ShopItem> a, String name){
        int cnt = 0;
        for(ShopItem s : a){
            if(s.getName().equals(name))
                cnt++;
        }
        return cnt;
    }
    public static void addShopItem(ShopItem s, String category){
        if (category.equals("Houses")) {
            houses.add(s);
        } else if (category.equals("Factories")) {
            factories.add(s);
        } else if (category.equals("Farms")) {
            farms.add(s);
        } else if (category.equals("Basics")) {
            basics.add(s);
        } else if (category.equals("Specials")) {
            specials.add(s);
        }
        update();
    }
    public static ArrayList<ArrayList<ShopItem>> getInventory(){
        return inventory;
    }
}