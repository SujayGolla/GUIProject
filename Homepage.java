import javax.swing.*;
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
        top.setBackground(Color.DARK_GRAY);
        top.add(new Label("Third"), BorderLayout.EAST);
        top.add(new Label("Second"), BorderLayout.CENTER);
        top.add(new Label("First"), BorderLayout.WEST);

        this.add(bg, BorderLayout.CENTER);
        bg.setLayout(new GridLayout());
        bg.setBackground(Color.GRAY);
        bg.add(new JLabel(new ImageIcon("Township.jpg")));

        this.add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(null);
        bottom.setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
     super.paintComponent(g);
   }
}
