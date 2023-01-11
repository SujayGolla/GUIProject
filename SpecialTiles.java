import javax.swing.*;

public class SpecialTiles extends ShopItem{
    public SpecialTiles(String name, ImageIcon img) {
        super(name, img);
    }
    public boolean isSpecialTile(){
        return true;
    }
}