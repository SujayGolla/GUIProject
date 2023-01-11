/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;

public class FactoryItem extends ShopItem{
    private int reqPpl;
    private static final String factories = "Feed Mill, Dairy Factory, Textile Factory, Meat Production, Bakery, Fast Food Restaurant";
    public FactoryItem(String name, int price, ImageIcon img, ImageIcon[] animations, int unlockLVL, int reqPpl) {
        super(name, price, img, animations, unlockLVL);
        this.reqPpl = reqPpl;
    }

    public int getReqPpl() {
        return reqPpl;
    }

    public void setReqPpl(int reqPpl) {
        this.reqPpl = reqPpl;
    }
    public void purchaseItem() throws Exception {
        if(canBuyItem()){
            Game.setCoins(Game.getCoins() - price);
            Game.setXp(Game.getXp() + 10);
            setReqPpl(getReqPpl() + 35);
        }else{
            if(Game.getLvl() < unlockLVL)
                JOptionPane.showMessageDialog(Cards.c, "You haven't reached Level " + unlockLVL + " yet.", "Can't buy", JOptionPane.WARNING_MESSAGE);
            else if (Game.getCoins() - price >= 0)
                JOptionPane.showMessageDialog(Cards.c, "You don't have enough coins.", "Can't buy", JOptionPane.WARNING_MESSAGE);
            else if (Game.getPopulation() < reqPpl)
                JOptionPane.showMessageDialog(Cards.c, "You don't have the required number of people", "Can't buy", JOptionPane.WARNING_MESSAGE);
        }
        Game.update();
    }
    public static boolean isFactory(String name){
        return factories.contains(name);
    }
}
