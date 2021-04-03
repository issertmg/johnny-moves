import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class LoginController implements ActionListener
{
    private MainView gui;
    private LoginView subGui;
    private MainController mainController;

    public LoginController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (LoginView) gui.getPanel(gui.LOGIN);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (o.getActionCommand().equals("Sign Up"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.SIGN_UP);
        }
        else if (o.getActionCommand().equals("Change Password"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.CHANGE_PASSWORD);
        }
        else if (i.getDescription().equals("Continue.png"))
        {
            String username = subGui.getUsername();
            String password = subGui.getPassword();
            
            if (mainController.getMachine().isAuthorizeLogin(username, password))
            {
                gui.updateCenterPane(gui.MENU);
                gui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                mainController.getMachine().simulateDayPerMinute();
            }
            else
                JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Unathorize Access", JOptionPane.ERROR_MESSAGE);
        }
    }
}