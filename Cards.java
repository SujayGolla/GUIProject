import javax.swing.*;
import java.awt.*;

public class Cards extends JFrame{
    static CardLayout layout;
    static Container c;
    static MainMenu m;
    static Homepage h;
    static Shop s;

    public Cards() throws Exception{
        c = getContentPane();
        layout = new CardLayout();
        c.setLayout(layout);

        m = new MainMenu();
        h = new Homepage();
        s = new Shop();

        c.add("MainMenu", m);
        c.add("Homepage", h);
        c.add("Shop", s);
    }

    public static void flipToCard(String cardID){
        layout.show(c, cardID);
    }
}
