import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JPanel implements ActionListener {
  private JPanel center;
  private JPanel bottom;
  private JPanel top;
  private JButton shop;
  public Homepage(){
      try {
          new Game();
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      center = new JPanel();
      bottom = new JPanel();
      top = new JPanel();

      shop = new JButton(new ImageIcon("shop.png"));
      shop.setBorderPainted(false);
      shop.setContentAreaFilled(false);
      shop.setOpaque(false);
      shop.addActionListener(this);

      this.setLayout(new BorderLayout());

      this.add(top, BorderLayout.NORTH);
      top.setLayout(new BorderLayout());
      top.setBackground(new Color(0,0,0,65));
      top.setOpaque(false);
      top.add(new JLabel(new ImageIcon("Untitled.png")));

      this.add(center, BorderLayout.CENTER);
      center.setLayout(new GridLayout());
      center.setBackground(Color.GRAY);

      this.add(bottom, BorderLayout.SOUTH);
      bottom.setLayout(new BorderLayout());
      bottom.setBackground(Color.WHITE);
      bottom.add(shop, BorderLayout.EAST);
  }

  public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      try {
          new Game();
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      super.paintComponent(g);
      g2.setColor(new Color(0,0,0,100));
      g2.fillRoundRect(50,20,100,25,20,20);
      g2.fillRoundRect(50,60,100,25,20,20);
      g2.fillRoundRect(850,20,100,25,20,20);
      g2.fillRoundRect(850,60,100,25,20,20);

      g2.setPaint(new GradientPaint(50, 20, new Color(23,255,198), 50+Game.getXp()%100, 45, new Color(3,68,140)));
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
 public void actionPerformed(ActionEvent e){
      if(e.getSource() == shop)
          Cards.flipToCard("Shop");
 }
}
