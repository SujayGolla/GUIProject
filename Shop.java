import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JPanel implements ActionListener{
    private JLabel title;
    private JPanel n, navBar, titleN;
    private JButton factories, houses, farming, basics, special, crops, back;
    public Shop(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);

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

        navBar = new JPanel();
        navBar.setLayout(new GridLayout(1,8));
        titleN = new JPanel();
        titleN.setLayout(new BorderLayout());
        n = new JPanel();
        n.setLayout(new BorderLayout());
        n.setBackground(Color.WHITE);

        n.add(titleN, BorderLayout.NORTH);
        title = new JLabel("Shop");
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
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

        this.add(n, BorderLayout.NORTH);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    public void defaultButtonSetup(JButton b){
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
        b.setOpaque(false);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

    }
}
