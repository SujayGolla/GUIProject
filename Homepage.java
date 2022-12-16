import javax.swing.*;
import java.awt.*;

public class Homepage extends JPanel {
  private JPanel center;
  private JPanel bottom;
  private JPanel top;
  public Homepage(){
      center = new JPanel();
      bottom = new JPanel();
      top = new JPanel();

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
      bottom.setLayout(new FlowLayout());
      bottom.setBackground(Color.WHITE);
      bottom.add(new Label("SALUT MES AMIS"));
  }

  public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      try {
          new Game();
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      super.paintComponent(g);
      g2.setColor(Color.darkGray);
      g2.fillRoundRect(50,20,100,30,20,20);
      g2.setPaint(new GradientPaint(50, 20, new Color(23,255,198), 50+Game.getXp()%100, 50, new Color(3,68,140)));
      g2.fillRoundRect(50,20, Game.getXp()%100, 30,20,20);
      g.drawImage(new ImageIcon("star.png").getImage(), 15,10, null);
 }
}
