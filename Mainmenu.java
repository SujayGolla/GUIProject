import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mainmenu extends JPanel implements ActionListener{
  private JButton btn;
  private ImageIcon img;
  
  public Mainmenu(){
    this.setLayout(null);
    img = new ImageIcon("simcity_mainMenu.jpg");
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
     g.drawImage(img.getImage(), 0, 10, 1000, 500, this);
  }
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == btn){
      Homepage p = new Homepage();
      p.setVisible(true);
    }
  }
}