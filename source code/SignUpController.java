import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SignUpController implements ActionListener
{
    private MainView gui;
    private SignUpView subGui;
    private MainController mainController;

    public SignUpController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (SignUpView) gui.getPanel(gui.SIGN_UP);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (o.getActionCommand().equals("Back to Sign in"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.LOGIN);
        }
        else if (i.getDescription().equals("Continue.png"))
        {
            String username = subGui.getUsername();
            String password = subGui.getPassword();
            String confirmPass = subGui.getConfirmPass();
            String adminPass = subGui.getAdminPass();
            
            JOptionPane.showMessageDialog(null, mainController.getMachine().createAccount(username, password, confirmPass, adminPass), "Sign Up Status", JOptionPane.INFORMATION_MESSAGE);
            subGui.reset();
        }

    }
}