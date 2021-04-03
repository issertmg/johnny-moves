import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignOutController implements ActionListener
{
    private MainView gui;
    private SignOutView subGui;
    private MainController mainController;

    public SignOutController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (SignOutView) gui.getPanel(gui.SIGN_OUT);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (o.getActionCommand().equals("Back to Menu"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.MENU);
        }
        else if (i.getDescription().equals("Continue.png"))
        {
            String username = subGui.getUsername();
            String password = subGui.getPassword();
            
            if (mainController.getMachine().isAuthorizeLogin(username, password))
            {
                mainController.generateReport();
                mainController.getMachine().saveData();
                gui.updateCenterPane(gui.GENERATE_REPORT);
            }
            else
                JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Unathorize Exit", JOptionPane.ERROR_MESSAGE);
        }
    }
}