import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AdminKeyController implements ActionListener
{
    private MainController mainController;
    private MainView gui;
    private AdminKeyView subGui;

    public AdminKeyController(MainView gui, MainController mainController)
    {
        this.mainController = mainController;
        this.gui = gui;
        subGui = (AdminKeyView) gui.getPanel(gui.SETUP_ADMIN);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (subGui.getAdminKey().equals(""))
            JOptionPane.showMessageDialog(null, "Admin key cannot be empty.", "Set up Admin key", JOptionPane.ERROR_MESSAGE);
        else
        {
            JOptionPane.showMessageDialog(null, "Admin key has been successfully initialized.", "Set up Admin key", JOptionPane.INFORMATION_MESSAGE);
            mainController.getMachine().setAdminKey(subGui.getAdminKey());
            gui.updateCenterPane(gui.LOGIN);
        }        
    }
}