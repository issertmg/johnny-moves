import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ChangePassView extends JPanel
{
    private JButton btnChangePass;
    private JButton btnBackToLogin;

    private JTextField tfUsername;
    private JPasswordField pfOldPassword;
    private JPasswordField pfNewPassword;
    private JPasswordField pfConfirmNewPass;
    
    public ChangePassView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iChangePass = new ImageIcon(getClass().getResource("resources/SignOut.png"),"SignOut.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JPanel panel; 
        JPanel subPanel;
        JPanel subberPanel;
        
        panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        JLabel lblChangePass = new JLabel("Change Password");
        lblChangePass.setFont(new Font("Arial", Font.BOLD, 45));
        panel.add(new JLabel(iChangePass));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(lblChangePass);
        panel.add(subPanel);
        add(panel, BorderLayout.NORTH);

        panel = new JPanel(new GridLayout(4, 1));
        panel.setOpaque(false);
        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Username: "));
        tfUsername = new JTextField(15);
        subPanel.add(tfUsername);
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Old password: "));
        pfOldPassword = new JPasswordField(15);
        subPanel.add(pfOldPassword);
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("New password: "));
        pfNewPassword = new JPasswordField(15);
        subPanel.add(pfNewPassword);
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Confirm new password: "));
        pfConfirmNewPass = new JPasswordField(15);
        subPanel.add(pfConfirmNewPass);
        panel.add(subPanel);

        subberPanel = new JPanel(new GridLayout(2, 1));
        subberPanel.setOpaque(false);

        btnChangePass = new JButton(iContinue);
        btnChangePass.setBorderPainted(false);
        btnChangePass.setContentAreaFilled(false); 
        subberPanel.add(panel);
        subberPanel.add(btnChangePass);

        add(subberPanel, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setOpaque(false);
        btnBackToLogin = new JButton("Back to Login");
        btnBackToLogin.setContentAreaFilled(false); 
        btnBackToLogin.setBorder(BorderFactory.createMatteBorder(0,0,5,0, new Color(0,181,236)));
        panel.add(btnBackToLogin);
        
        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnBackToLogin.addActionListener((ActionListener) listener);
        btnChangePass.addActionListener((ActionListener) listener);
    }

    public void reset()
    {
        tfUsername.setText("");
        pfOldPassword.setText("");
        pfNewPassword.setText("");
        pfConfirmNewPass.setText("");
    }

    public String getUsername()
    {
        return tfUsername.getText();
    }

    public String getOldPassword()
    {
        return new String(pfOldPassword.getPassword());
    }

    public String getNewPassword()
    {
        return new String(pfNewPassword.getPassword());
    }

    public String getConfirmNewPass()
    {
        return new String(pfConfirmNewPass.getPassword());
    }
}