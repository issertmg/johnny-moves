import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ChangePassController implements ActionListener
{
    private MainView gui;
    private ChangePassView subGui;
    private MainController mainController;

    public ChangePassController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (ChangePassView) gui.getPanel(gui.CHANGE_PASSWORD);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (o.getActionCommand().equals("Back to Login"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.LOGIN);
        }
        else if (i.getDescription().equals("Continue.png"))
        {
            String username = subGui.getUsername();
            String oldPass = subGui.getOldPassword();
            String newPass = subGui.getNewPassword();
            String confirmNewPass = subGui.getConfirmNewPass();
            
            JOptionPane.showMessageDialog(null, mainController.getMachine().changePassword(username, oldPass, newPass, confirmNewPass), "Change Password Status", JOptionPane.INFORMATION_MESSAGE);
            subGui.reset();
        }
    }
}