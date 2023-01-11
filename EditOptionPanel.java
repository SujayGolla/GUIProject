/*
Name: Sujay and Akaren
Class: ICS 3U7
Teacher: Ms.Strelkovska
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditOptionPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private JPanel top, center, centerLeft, navBar, itemsList, map, cHou, cFac, cFar, cBas, cSpe;
    private JButton factories, houses, farming, basics, special, back, merchant;
    private CardLayout layout;
    public EditOptionPanel(){
        try {
            new Inventory();
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setLayout(new BorderLayout());

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
        merchant = new JButton(resizeImg(new ImageIcon("Merchant.png"), 100,100));
        defaultButtonSetup(merchant);
        merchant.setSize(new Dimension(100,100));

        top = new JPanel(new GridLayout(1, 5));
        top.setBackground(Color.GRAY);
        JLabel title = new JLabel("    Edit");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        top.add(back);
        top.add(new JLabel(""));
        top.add(title);
        top.add(new JLabel(""));
        top.add(new JLabel(""));

        center = new JPanel(new BorderLayout());

        centerLeft = new JPanel(new BorderLayout());
        navBar = new JPanel(new GridLayout(7,1));
        navBar.setBackground(Color.LIGHT_GRAY);
        navBar.add(houses);
        navBar.add(factories);
        navBar.add(farming);
        navBar.add(basics);
        navBar.add(special);
        navBar.add(new JLabel(""));
        navBar.add(merchant);
        
        layout = new CardLayout();
        itemsList = new JPanel(layout);
        cHou = new JPanel(new GridLayout(ShopItem.getNumHouses()+1, 1));
        JLabel l = new JLabel("List of Houses", JLabel.CENTER);
        l.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cHou.add(l);
        itemsList.add("Houses", cHou);
        cFac = new JPanel(new GridLayout(ShopItem.getNumFactories()+1, 1));
        l = new JLabel("List of Factories", JLabel.CENTER);
        l.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cFac.add(l);
        itemsList.add("Factories", cFac);
        cFar = new JPanel(new GridLayout(ShopItem.getNumFarms()+1, 1));
        l = new JLabel("List of Farms", JLabel.CENTER);
        l.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cFar.add(l);
        itemsList.add("Farming", cFar);
        cBas = new JPanel(new GridLayout(ShopItem.getNumBasics()+1, 1));
        l = new JLabel("List of Basics", JLabel.CENTER);
        l.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cBas.add(l);
        itemsList.add("Basics", cBas);
        cSpe = new JPanel(new GridLayout(ShopItem.getNumSpecials()+1, 1));
        l = new JLabel("List of Specials", JLabel.CENTER);
        l.setFont(new Font("Times New Roman", Font.BOLD, 18));
        cSpe.add(l);
        itemsList.add("Specials", cSpe);
        makeItemsList();
        centerLeft.add(navBar, BorderLayout.WEST);
        centerLeft.add(itemsList, BorderLayout.EAST);
        center.add(centerLeft, BorderLayout.WEST);

        map = new Edit();
        center.add(map, BorderLayout.CENTER);

        this.add(top, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
    }
    public void makeItemsList(){
        ArrayList<ArrayList<ShopItem>> inventory = Inventory.getInventory();
        JPanel[] panels = {cHou, cFac, cFar, cBas, cSpe};
        for(int i = 0; i < panels.length; i++){
            JPanel p = panels[i];
            String onPanel = "";
            int y = 0;
            for(ShopItem s : inventory.get(i)){
                if(!onPanel.contains(s.getName())){
                    JPanel panel = new JPanel(null);

                    JButton b = new JButton(resizeImg(s.getImg(), 35,35));
                    Dimension bSize = b.getPreferredSize();
                    b.setBounds(13+50-(bSize.width/2),y+45-(bSize.height/2),bSize.width, bSize.height);
                    defaultButtonSetup(b);
                    b.addMouseListener(this);
                    b.addMouseMotionListener(this);
                    panel.add(b);

                    JLabel l = new JLabel(Inventory.specificItemCounter(inventory.get(i), s.getName()) + "");
                    Dimension lSize = l.getPreferredSize();
                    l.setBounds(13+50-(lSize.width/2),y+15-(lSize.height/2),lSize.width, lSize.height);
                    l.setFont(new Font("Times New Roman", Font.BOLD, 12));
                    panel.add(l);

                    JLabel background = new JLabel(new ImageIcon("inventoryBox.png"));
                    Dimension backGSize = background.getPreferredSize();
                    background.setBounds(13,y,backGSize.width, backGSize.height);
                    panel.add(background);

                    p.add(panel);
                    onPanel += s.getName();
                    y += 70;
                }
            }
        }
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
        else if (b == merchant)
            Cards.flipToCard("Merchant");
    }
    public void centerFlipToCard(String ID){
        layout.show(itemsList, ID);
    }
    public ImageIcon resizeImg(ImageIcon img, int w, int h){
        Image image = img.getImage();
        Image newImg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
