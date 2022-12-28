import javax.swing.*;

public class ShopItem {
    private final String name;
    private final int price;
    private final ImageIcon img;
    private final ImageIcon[] animations;
    private final int unlockLVL;

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
}
