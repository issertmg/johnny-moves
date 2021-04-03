import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignOutView extends JPanel
{
    private JButton btnSignOut;
    private JButton btnBackToMenu;

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    
    public SignOutView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iSignOut = new ImageIcon(getClass().getResource("resources/SignOut.png"),"SignOut.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JPanel panel; 
        JPanel subPanel;
        JPanel subberPanel;
        
        panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        JLabel lblLogin = new JLabel("Sign out");
        lblLogin.setFont(new Font("Arial", Font.BOLD, 56));
        panel.add(new JLabel(iSignOut));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(lblLogin);
        panel.add(subPanel);
        add(panel, BorderLayout.NORTH);

        panel = new JPanel(new GridLayout(3, 1));
        panel.setOpaque(false);
        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Username: "));
        tfUsername = new JTextField(15);
        subPanel.add(tfUsername);
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Password: "));
        pfPassword = new JPasswordField(15);
        subPanel.add(pfPassword);
        panel.add(subPanel);

        subberPanel = new JPanel(new GridLayout(2, 1));
        subberPanel.setOpaque(false);

        btnSignOut = new JButton(iContinue);
        btnSignOut.setBorderPainted(false);
        btnSignOut.setContentAreaFilled(false); 
        subberPanel.add(panel);
        subberPanel.add(btnSignOut);

        add(subberPanel, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setOpaque(false);
        btnBackToMenu = new JButton("Back to Menu");
        btnBackToMenu.setContentAreaFilled(false); 
        btnBackToMenu.setBorder(BorderFactory.createMatteBorder(0,0,5,0, new Color(0,181,236)));
        panel.add(btnBackToMenu);
        
        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnSignOut.addActionListener((ActionListener) listener);
        btnBackToMenu.addActionListener((ActionListener) listener);
    }

    public String getUsername()
    {
        return tfUsername.getText();
    }

    public String getPassword()
    {
        return new String(pfPassword.getPassword());
    }

    public void reset()
    {
        tfUsername.setText("");
        pfPassword.setText("");
    }
}