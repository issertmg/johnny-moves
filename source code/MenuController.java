import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MenuController implements ActionListener
{
    private MainView gui;
    private MainController mainController;

    public MenuController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        ((MenuView)gui.getPanel(gui.MENU)).addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (i.getDescription().equals("SendParcel.png"))
        {
            ((RecipientView) gui.getPanel(gui.ADD_RECIPIENT)).reset();
            gui.updateCenterPane(gui.ADD_RECIPIENT);
        }
        else if (i.getDescription().equals("TrackParcel.png"))
            gui.updateCenterPane(gui.TRACKING_INFO);

        else if (i.getDescription().equals("Exit.png"))
            gui.updateCenterPane(gui.SIGN_OUT);
        
    }
}