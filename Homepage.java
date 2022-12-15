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
      super.paintComponent(g);
      g.setColor(Color.darkGray);
      g.fillRoundRect(10,10,100,30,20,20);
      g.setColor(Color.lightGray);
      g.fillRoundRect(10,10, Game.getXp(), 30,20,20);
 }
}
