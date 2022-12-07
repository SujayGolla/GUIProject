import javax. swing.*;
import java.awt.*;

	public class MyFrame extends JFrame{

    private ImageIcon img;
    private JButton btn;
    private Container ctn;
    private ImageIcon playImg;
    
    public MyFrame(String title){
      super(title);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      img = new ImageIcon("simtown_mainMenu.jpg");
      playImg = new ImageIcon("play.png");
      btn = new JButton (playImg);
      btn.setBounds(450,350,100,50);
      
      btn.setBorder(null);
      btn.setBorderPainted(false);
      btn.setContentAreaFilled(false);
      btn.setOpaque(false);
      
      ctn = getContentPane();
      ctn.setLayout(null);
      ctn.add(btn);
    }	
  
	public void paint (Graphics g){
	  super.paint(g);
    g.drawImage(img.getImage(),0,10, 1000, 500, this);
  }
}
