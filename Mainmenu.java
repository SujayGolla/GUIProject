import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class Mainmenu extends JPanel implements ActionListener {
  private JButton btn;
  private BufferedImage menuBackground;

  public Mainmenu() throws Exception{
    this.setLayout(new GridLayout());
    btn = new JButton(new ImageIcon("play.png"));
    btn.setBounds(450,350,100,50);
    btn.setBorderPainted(false);
    btn.setContentAreaFilled(false);
    btn.setOpaque(false);
    btn.setContentAreaFilled(false);
    btn.setBorderPainted(false);
    this.add(btn);
    btn.addActionListener(this);

    menuBackground = ImageIO.read(new File("mMenu.jpg"));
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(menuBackground, 0,0, null);
  }
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == btn){
      Cards.layout.show(Cards.c, "Homepage");
    }
  }
}