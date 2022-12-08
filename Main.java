import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Township");
    Container cont = frame.getContentPane();
    cont.setLayout(new GridLayout());  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true); 
    frame.setSize(1000,500);
    frame.setResizable(false);
  }
}