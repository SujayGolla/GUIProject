import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel extends JPanel implements ActionListener {
    private JPanel top, center, centerList;
    private JButton factories, houses, farming, basics, special, back;
    private JLabel title;
    private CardLayout layout;
    public InventoryPanel(){
        this.setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(1, 5));
        top.setBackground(Color.GRAY);
        JPanel center = new JPanel(new BorderLayout());
        JPanel navBar = new JPanel(new GridLayout(7,1));
        navBar.setBackground(Color.LIGHT_GRAY);
        centerList = new JPanel();

        JLabel title = new JLabel("    Inventory");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));

        back = new JButton(new ImageIcon("back.png"));
        defaultButtonSetup(back);
        farming = new JButton(new ImageIcon("shopFarming.png"));
        defaultButtonSetup(farming);
        houses = new JButton(new ImageIcon("shopHouses.png"));
        defaultButtonSetup(houses);
        factories = new JButton(new ImageIcon("shopFactories.png"));
        defaultButtonSetup(factories);
        basics = new JButton(new ImageIcon("shopBasics.png"));
        defaultButtonSetup(basics);
        special = new JButton(new ImageIcon("shopSpecials.png"));
        defaultButtonSetup(special);

        top.add(back);
        top.add(new JLabel(""));
        top.add(title);
        top.add(new JLabel(""));
        top.add(new JLabel(""));

        center.add(navBar, BorderLayout.WEST);
        center.add(centerList, BorderLayout.CENTER);

        navBar.add(houses);
        navBar.add(factories);
        navBar.add(farming);
        navBar.add(basics);
        navBar.add(special);
        navBar.add(new JLabel(""));
        navBar.add(new JLabel(""));

        layout = new CardLayout();
        centerList.setLayout(layout);

        JPanel cHou = new JPanel(new GridLayout(ShopItem.getNumHouses(), 1));
        cHou.setBackground(Color.red);
        JPanel cFac = new JPanel(new GridLayout(ShopItem.getNumFactories(), 1));
        cFac.setBackground(Color.ORANGE);
        JPanel cFar = new JPanel(new GridLayout(ShopItem.getNumFarms(), 1));
        cFar.setBackground(Color.YELLOW);
        JPanel cBas = new JPanel(new GridLayout(ShopItem.getNumBasics(), 1));
        cBas.setBackground(Color.GREEN);
        JPanel cSpe = new JPanel(new GridLayout(ShopItem.getNumSpecials(), 1));
        cSpe.setBackground(Color.BLUE);

        centerList.add("Houses", cHou);
        centerList.add("Factories", cFac);
        centerList.add("Farms", cFar);
        centerList.add("Basics", cBas);
        centerList.add("Specials", cSpe);



        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
    }
    /*public void displayUnlockedItems(ShopItem s, JPanel panel, int x, int y){
        JPanel p = new JPanel();
        p.setLayout(null);
        Dimension sizeTitle,sizePrice, sizeBuy;

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
        price.setBounds(x+150-(sizePrice.width / 2), y+30+sizeTitle.height+15+200+5, sizePrice.width, sizePrice.height);
        p.add(price);

        JButton buy = new JButton(new ImageIcon("buy.png"));
        buy.setName(s.getName() + " Buy");
        defaultButtonSetup(buy);
        sizeBuy = buy.getPreferredSize();
        buy.setBounds(x+150-(sizeBuy.width / 2), y+350-sizeBuy.height-10, sizeBuy.width, sizeBuy.height);
        p.add(buy);

        JLabel box = new JLabel(new ImageIcon("ShopItemDisplayBox.png"));
        box.setBounds(x,y,300,350);
        p.add(box);

        p.setBounds(350*cnt++, 0, 350, 400);

        panel.add(p);
    }*/
    public void defaultButtonSetup(JButton b){
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setOpaque(false);
        b.setFocusable(false);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton) e.getSource();

        if(b == back)
            Cards.flipToCard("Homepage");
        else if(b == factories)
            centerFlipToCard("Factories");
        else if(b == houses)
            centerFlipToCard("Houses");
        else if(b == farming)
            centerFlipToCard("Farming");
        else if(b == basics)
            centerFlipToCard("Basics");
        else if(b == special)
            centerFlipToCard("Specials");
    }
    public void centerFlipToCard(String ID){
        layout.show(centerList, ID);
    }
}
