import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JPanel implements ActionListener{
    private JPanel n, c;
    private JButton factories, houses, farming, basics, special, crops, back;
    private CardLayout layout;
    private final ShopItem[] housesArray = {new ShopItem("Townhouse", 50, new ImageIcon("Townhouse.png"), null, 1), new ShopItem("Bungalow", 30, new ImageIcon("Bungalow.png"), null, 2), new ShopItem("Apartment", 150, new ImageIcon("Apartment.png"), null, 4), new ShopItem("Condos", 300, new ImageIcon("Condo.png"), null, 8)};
    private final ShopItem[] factoriesArray = {new ShopItem("Feed Mill", 50, new ImageIcon("Feedmill.png"), null, 1), new ShopItem("Dairy Factory", 50, new ImageIcon("Dairy.png"), null, 2), new ShopItem("Textile Factory", 100, new ImageIcon("Textile.png"), null, 4), new ShopItem("Meat Production", 150, new ImageIcon("Meat.png"), null, 5), new ShopItem("Bakery", 200, new ImageIcon("Bakery.png"), null, 7), new ShopItem("Fast Food Restaurant", 300, new ImageIcon("Fastfood.png"), null, 9)};
    private final ShopItem[] farmsArray = {new ShopItem("Cowshed", 50, new ImageIcon("Cowshed.png"), null, 1), new ShopItem("Chicken Coop", 150, new ImageIcon("Chicken.png"), null, 2), new ShopItem("Sheep Farm", 300, new ImageIcon("Sheep.png"), null, 5)};
    private final ShopItem[] cropsArray = {new ShopItem("Wheat", 5, new ImageIcon("Wheat.png"), null, 1), new ShopItem("Carrot", 5, new ImageIcon("Carrot.png"), null, 1), new ShopItem("Corn", 5, new ImageIcon("Corn.png"), null, 2), new ShopItem("Rice", 5, new ImageIcon("Rice.png"), null, 4), new ShopItem("Apples", 10, new ImageIcon("Apples.png"), null, 5), new ShopItem("Strawberry", 10, new ImageIcon("Strawberry.png"), null, 6), new ShopItem("Cotton", 5, new ImageIcon("Cotton.png"), null, 2), new ShopItem("Tomatoes", 5, new ImageIcon("Tomato.png"), null, 3)};
    private final ShopItem[] basicsArray = {new ShopItem("Roads", 0, new ImageIcon("Road.png"), null, 1), new ShopItem("Gravel", 0, new ImageIcon("Gravel.png"), null, 1), new ShopItem("Tiles", 0, new ImageIcon("Tiles.png"), null, 1)};
    private final ShopItem[] specialsArray = {new ShopItem("Barn", 0, new ImageIcon("Barn.png"), null, 1), new ShopItem("Townhall", 0, new ImageIcon("Townhall.png"), null, 2), new ShopItem("Fountain", 200, new ImageIcon("Fountain.png"), null, 3)};
    private final ShopItem[][] shop = {housesArray, factoriesArray, farmsArray, cropsArray, basicsArray, specialsArray};
    private int cnt = 0;
    public Shop(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        makeNorth();
        this.add(n, BorderLayout.NORTH);
        makeCenter();
        this.add(c, BorderLayout.CENTER);
    }
    public void makeNorth(){
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
        crops = new JButton(new ImageIcon("shopCrops.png"));
        defaultButtonSetup(crops);
        back = new JButton(new ImageIcon("back.png"));
        defaultButtonSetup(back);

        JPanel navBar = new JPanel();
        navBar.setLayout(new GridLayout(1,8));
        n = new JPanel();
        n.setLayout(new BorderLayout());
        n.setBackground(Color.GRAY);
        JPanel titleN = new JPanel();
        titleN.setLayout(new BorderLayout());
        titleN.setBackground(Color.LIGHT_GRAY);

        n.add(titleN, BorderLayout.NORTH);
        JLabel title = new JLabel("Shop");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Dimension size = title.getPreferredSize();
        title.setBounds(450, 30,size.width,size.height);
        back.setBounds(15,15,30,20);
        titleN.add(back, BorderLayout.WEST);
        titleN.add(title, BorderLayout.CENTER);

        n.add(navBar, BorderLayout.CENTER);
        navBar.add(new JLabel(""));
        navBar.add(houses);
        navBar.add(factories);
        navBar.add(farming);
        navBar.add(crops);
        navBar.add(basics);
        navBar.add(special);
        navBar.add(new JLabel(""));
    }
    public void makeCenter() {
        c = new JPanel();
        layout = new CardLayout();
        c.setLayout(layout);
        c.setBackground(Color.WHITE);

        JPanel cHou = new JPanel(new GridLayout(1, housesArray.length + 1));
        JPanel cFac = new JPanel(new GridLayout(1, factoriesArray.length + 1));
        JPanel cFar = new JPanel(new GridLayout(1, farmsArray.length + 1));
        JPanel cCro = new JPanel(new GridLayout(1, cropsArray.length + 1));
        JPanel cBas = new JPanel(new GridLayout(1, basicsArray.length + 1));
        JPanel cSpe = new JPanel(new GridLayout(1, specialsArray.length + 1));

        addShopItemsToPanels(cHou, housesArray);
        cnt = 0;
        addShopItemsToPanels(cFac, factoriesArray);
        cnt = 0;
        addShopItemsToPanels(cFar, farmsArray);
        cnt = 0;
        addShopItemsToPanels(cCro, cropsArray);
        cnt = 0;
        addShopItemsToPanels(cBas, basicsArray);
        cnt = 0;
        addShopItemsToPanels(cSpe, specialsArray);


        JScrollPane scrollPaneCHou = new JScrollPane(cHou, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCHou.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCHou, "Houses");
        JScrollPane scrollPaneCFac = new JScrollPane(cFac, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCFac.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCFac, "Factories");
        JScrollPane scrollPaneCFar = new JScrollPane(cFar, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCFar.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCFar, "Farming");
        JScrollPane scrollPaneCCro = new JScrollPane(cCro, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCCro.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCCro, "Crops");
        JScrollPane scrollPaneCBas = new JScrollPane(cBas, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCBas.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCBas, "Basics");
        JScrollPane scrollPaneCSpe = new JScrollPane(cSpe, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneCSpe.setPreferredSize(new Dimension(3500, 350));
        c.add(scrollPaneCSpe, "Specials");
    }
    public void addShopItemsToPanels(JPanel p, ShopItem[] array){
        p.add(new JLabel(new ImageIcon("Untitled(1).png")));
        for(ShopItem i : array){
            if(i.isUnlocked()) {
                displayUnlockedItems(i, p, 30,25);
            } else {
                displayLockedItems(i, p, 30, 25);
            }
        }
    }
    public void centerFlipToCard(String ID){
        layout.show(c, ID);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    public void displayUnlockedItems(ShopItem s, JPanel panel, int x, int y){
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
    }
    public void displayLockedItems(ShopItem s, JPanel panel, int x, int y){
        JPanel p = new JPanel();
        p.setLayout(null);
        Dimension sizeTitle,sizePrice;

        JButton lock = new JButton(new ImageIcon("lock.png"));
        lock.setName(s.getName() + " Locked");
        defaultButtonSetup(lock);
        lock.setBounds(x,y,300,350);
        p.add(lock);

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
        price.setBounds(x+150-(sizePrice.width / 2), y+30+sizeTitle.height+15+200+10, sizePrice.width, sizePrice.height);
        p.add(price);

        JLabel box = new JLabel(new ImageIcon("ShopItemDisplayBoxLocked.png"));
        box.setBounds(x,y,300,350);
        p.add(box);

        p.setBounds(350*cnt++, 0, 350, 400);

        panel.add(p);
    }
    public void defaultButtonSetup(JButton b){
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setOpaque(false);
        b.setFocusable(false);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton) e.getSource();
        String name = "";
        if(b.getName() != null)
            name = b.getName();

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
        else if(b == crops)
            centerFlipToCard("Crops");
        else {
            for(ShopItem[] a : shop){
                for(ShopItem s : a){
                    if (name.startsWith(s.getName())) {
                        try {
                            s.purchaseItem();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }
    }
}
