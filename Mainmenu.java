import javax.swing.*;
import java.awt.*;

public class Mainmenu extends JPanel implements ActionListener{
  private JButton btn;

  public Mainmenu(){
    this.setLayout(new GridLayout());
    this.add(new ImageIcon("simtown_mainMenu.jpg"))
    btn = new JButton(new ImageIcon("play.png"));
    btn.setBounds(450,350,100,50);
    btn.setBorderPainted(false);
    btn.setContentAreaFilled(false);
    btn.setOpaque(false);
    btn.setContentAreaFilled(false);
    btn.setBorderPainted(false);
    this.add(btn);
    btn.addActionListener(this);
  }
  public void paintComponent(Graphics g){
     super.paintComponent(g);
  }
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == btn){
      Homepage p = new Homepage();
      p.setVisible(true);
    }
  }
}