import javax.swing.*;
import java.awt.*;

public class Cards extends JFrame{
    static CardLayout layout;
    static Container c;
    static MainMenu m;
    static Homepage h;
    static Shop s;
    static InventoryPanel iP;

    public Cards() throws Exception{
        c = getContentPane();
        layout = new CardLayout();
        c.setLayout(layout);

        m = new MainMenu();
        h = new Homepage();
        s = new Shop();
        iP = new InventoryPanel();

        c.add("MainMenu", m);
        c.add("Homepage", h);
        c.add("Shop", s);
        c.add("Inventory", iP);
    }

    public static void flipToCard(String cardID){
        layout.show(c, cardID);
    }
}
