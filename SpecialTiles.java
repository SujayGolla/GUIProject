/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;

public class SpecialTiles extends ShopItem{
    public SpecialTiles(String name, ImageIcon img) {
        super(name, img);
    }
    public boolean isSpecialTile(){
        return true;
    }
}