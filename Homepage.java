import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Homepage extends JPanel {
  private JPanel bg;
  private JPanel bottom;
  private JPanel top;
  public Homepage(){
      bg = new JPanel();
      bottom = new JPanel();
      top = new JPanel();

      this.setLayout(new BorderLayout());

      this.add(top, BorderLayout.NORTH);
      top.setLayout(new BorderLayout());
      top.setBackground(new Color(0,0,0,65));

      this.add(bg, BorderLayout.CENTER);
      bg.setLayout(new GridLayout());
      bg.setBackground(Color.GRAY);
      bg.add(new JLabel(new ImageIcon("Township.jpg")));

      this.add(bottom, BorderLayout.SOUTH);
      bottom.setLayout(new FlowLayout());
      bottom.setBackground(Color.WHITE);
      bottom.add(new Label("SALUT MES AMIS, JE SUIS FOU"));
  }

  public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.fillRoundRect(10, 20, 50, 20, 5,5);
      g2.fillRoundRect(10,20,(int)(20*(Game.getXp() / Game.getLvl()*100.0)), 20, 5, 5);
 }
}
