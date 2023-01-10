

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Merchant extends JPanel  {

  private int random;
  private String[] items;
  private ShopItem item;
  private int cnt;

  public Merchant() {
    random = (int) (Math.random()*8);
    items = new String[] {"Wheat", "Carrot", "Corn", "Tomatoes", "Rice", "Apples", "Strawberry", "Cotton"};
    item = ShopItem.getShopItem(items[random]);
    cnt = 0;
    
  }

  public void displaySellableItem(ShopItem s, int x, int y){
    JPanel p = new JPanel();
    p.setLayout(null);
    Dimension sizeTitle,sizePrice;

    JLabel title = new JLabel(s.getName());
    sizeTitle = title.getPreferredSize();
    title.setFont(new Font("Times New Roman", Font.BOLD, 12));
    title.setBounds(x+150-(sizeTitle.width / 2),y+30, sizeTitle.width, sizeTitle.height);
    p.add(title);

    JLabel img = new JLabel(s.getImg());
    img.setBounds(x+50, y+30+sizeTitle.height+15, 200, 200);
    p.add(img);

    JLabel price = new JLabel(s.getPrice() + "", new ImageIcon("shopCoin.png"), JLabel.CENTER);
    price.setFont(new Font("Times New Roman", Font.BOLD, 18));
    sizePrice = price.getPreferredSize();
    price.setBounds(x+75-(sizePrice.width / 2), y+30+sizeTitle.height+15+200-5+((y+350 - (y+30+sizeTitle.height+15+200-5))/2)-(sizePrice.height/2), sizePrice.width, sizePrice.height);
    p.add(price);

    JLabel box = new JLabel(new ImageIcon("ShopItemDisplayBox.png"));
    box.setBounds(x,y,300,350);
    p.add(box);

    p.setBounds(350*cnt++, 0, 350, 400);

    this.add(p);
}

}

  