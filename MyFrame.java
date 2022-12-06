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
      img = new ImageIcon("Township.jpg");
      playImg = new ImageIcon("play.png");
      btn = new JButton (playImg);
      
      ctn = getContentPane();
      ctn.setLayout(new FlowLayout());
      ctn.add(btn);
    }	
  
	public void paint (Graphics g){
	  super.paint(g);
    g.drawImage(img.getImage(),0,10, 600, 600, this);
  }
}
