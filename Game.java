import java.util.*;
import java.io.*;
public class Game{
    private static int lvl;
    private static int xp;
    private static int coins;
    private static int cash;
    private static int population;
    private static int maxPopulation;

    public Game() throws Exception{
        Scanner sc = new Scanner(new File("GameData.txt"));
        lvl = Integer.parseInt(sc.nextLine().substring(1,2));
        xp = Integer.parseInt(sc.nextLine().substring(2));
        population = Integer.parseInt(sc.nextLine().substring(1));
        coins = Integer.parseInt(sc.nextLine().substring(2));
        cash = Integer.parseInt(sc.nextLine().substring(2));
        maxPopulation = lvl * 15;
    }

    public static int getCash() {
        return cash;
    }

    public static int getCoins() {
        return coins;
    }

    public static int getLvl() {
        return lvl;
    }

    public static int getPopulation() {
        return population;
    }

    public static int getXp() {
        return xp;
    }

    public static void setCash(int c) {
        cash = c;
    }

    public static void setCoins(int c) {
        coins = c;
    }

    public static void setLvl(int l) {
        lvl = l;
    }

    public static void setPopulation(int p) {
        population = p;
    }

    public static void setXp(int x) {
        xp = x;
    }

    public static int getMaxPopulation() {
        return maxPopulation;
    }

    public static void update(){
        lvl = (int)(xp/100.0);
        xp = xp%100;
        maxPopulation = lvl * 15;
    }
}