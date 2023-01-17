import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JPanel implements ActionListener {
    private JButton shop, inventoryBtn, factoryBtn;
    private JPanel top, center, bottom;
    public Homepage(){
        this.setLayout(new BorderLayout());

        top = new JPanel();
        top.setBackground(new Color(0,0,0, 100));
        JLabel l = new JLabel(new ImageIcon("Untitled.png"));
        l.setBounds(0,0,1,100);
        top.add(l);
        this.add(top, BorderLayout.NORTH);

        center = new Map();
        this.add(center, BorderLayout.CENTER);

        bottom = new JPanel(new BorderLayout());
        top.setBackground(new Color(0,0,0, 10));
        shop = new JButton(new ImageIcon("shop.png"));
        shop.setBorderPainted(false);
        shop.setContentAreaFilled(false);
        shop.setOpaque(false);
        shop.addActionListener(this);
        bottom.add(shop, BorderLayout.EAST);
        inventoryBtn = new JButton(new ImageIcon("edit.png"));
        inventoryBtn.setBorderPainted(false);
        inventoryBtn.setContentAreaFilled(false);
        inventoryBtn.setOpaque(false);
        inventoryBtn.addActionListener(this);

        factoryBtn = new JButton(new ImageIcon("factory.png"));
        factoryBtn.setBorderPainted(false);
        factoryBtn.setContentAreaFilled(false);
        factoryBtn.setOpaque(false);
        factoryBtn.addActionListener(this);
        bottom.add(factoryBtn BorderLayout.WEST);
        this.add(bottom, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0,100));
        g2.fillRoundRect(50,20,100,25,20,20);
        g2.fillRoundRect(50,60,100,25,20,20);
        g2.fillRoundRect(850,20,100,25,20,20);
        g2.fillRoundRect(850,60,100,25,20,20);

        g2.setPaint(new GradientPaint(50, 20, new Color(8, 238, 179), 50+Game.getXp()%100, 45, new Color(0, 69, 146)));
        g2.fillRoundRect(50,20, Game.getXp()%100, 25,20,20);
        g2.fillRoundRect(50,60, Game.getPopulation()*100 / Game.getMaxPopulation(), 25,20,20);

        g.drawImage(new ImageIcon("star.png").getImage(), 17,7, null);
        g.drawImage(new ImageIcon("population.png").getImage(), 17,47, null);
        g.drawImage(new ImageIcon("coin.png").getImage(), 827,7, null);
        g.drawImage(new ImageIcon("cash.png").getImage(), 827,47, null);

        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Monospaced", Font.BOLD, 18));
        g.drawString("" + Game.getLvl(), 37,36);
        g.drawString(Game.getPopulation() + "/" + Game.getMaxPopulation(), 78,78);
        g.drawString(""+Game.getCoins(), 885, 38);
        g.drawString(""+Game.getCash(), 885, 78);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shop)
            Cards.flipToCard("Shop");
        else if(e.getSource() == inventoryBtn)
            Cards.flipToCard("Inventory");
        else if(e.getSource()) == factoryBtn)
            Cards.flipToCard("Factory");
    }
}
