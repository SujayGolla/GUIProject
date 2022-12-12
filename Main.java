import javax.swing.*;

public class Main {
  public static void main(String[] args) throws Exception{
    Cards game = new Cards();
    game.setSize(1000,500);
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setVisible(true);
    game.setResizable(true);
  }
}