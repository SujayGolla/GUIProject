//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Map{
//    private char[][] map;
//    private ArrayList<ShopItem> tiles;
//    private Scanner sc;
//    public Map(){
//        try {
//            sc = new Scanner(new File("Map.txt"));
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        }
//        map = new char[15][15];
//        tiles = new ArrayList<ShopItem>();
//        for(int i = 0; i < map.length; i++){
//            for(int j= 0; j < map[i].length; j++){
//                map[i][j] = sc.next().charAt(0);
//                if(map[i][j] == 'g') {
//                    ShopItem s = ShopItem.getShopItem("Townhouse");
//                    s.setX(i*20);
//                    s.setY(j*20);
//                    tiles.add(s);
//                } else if(map[][])
//            }
//        }
//    }
//}