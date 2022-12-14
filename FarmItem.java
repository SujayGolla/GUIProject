/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;

public class FarmItem extends ShopItem{
    private int reqPpl;
    private static final String farms = "Field, Cowshed, Chicken Coop, Sheep Farm";
    public FarmItem(String name, int price, ImageIcon img, ImageIcon[] animations, int unlockLVL, int reqPpl) {
        super(name, price, img, animations, unlockLVL);
        this.reqPpl = reqPpl;
    }

    public int getReqPpl() {
        return reqPpl;
    }

    public void setReqPpl(int reqPpl) {
        this.reqPpl = reqPpl;
    }

    public boolean canBuyItem(){
        return super.canBuyItem() && Game.getPopulation() >= reqPpl;
    }

    public void purchaseItem() throws Exception {
        if(canBuyItem()){
            Game.setCoins(Game.getCoins() - price);
            Game.setXp(Game.getXp() + 10);
            if(name.equals("Field"))
                setReqPpl(getReqPpl() + 5);
            else
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
    public static boolean isFarm(String name){
        return farms.contains(name);
    }
}