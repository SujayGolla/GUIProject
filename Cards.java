import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Cards extends JFrame{
    static CardLayout layout;
    static Container c;
    static Mainmenu m;
    static Homepage h;

    public Cards() throws Exception{
        c = getContentPane();
        layout = new CardLayout();
        c.setLayout(layout);

        m = new Mainmenu();
        h = new Homepage();

        c.add("Main Menu", m);
        c.add("Homepage", h);
    }

    public void flipToCard(String cardID){
        layout.show(c, cardID);

        if(cardID.equals("Main Menu")){
            m.requestFocusInWindow();
        }
        else if(cardID.equals("Homepage")){
            h.requestFocusInWindow();
        }
    }
}
