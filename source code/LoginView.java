import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class LoginView extends JPanel
{
    private JButton btnLogin;
    private JButton btnSignUp;
    private JButton btnChangePass;

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    
    public LoginView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iLogin = new ImageIcon(getClass().getResource("resources/Login.png"),"Login.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JPanel panel; 
        JPanel subPanel;
        JPanel subberPanel;
        
        panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Arial", Font.BOLD, 56));
        panel.add(new JLabel(iLogin));
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

        btnLogin = new JButton(iContinue);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false); 
        subberPanel.add(panel);
        subberPanel.add(btnLogin);

        add(subberPanel, BorderLayout.CENTER);

        panel = new JPanel(new GridLayout(1,2));
        panel.setOpaque(false);
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setContentAreaFilled(false); 
        btnSignUp.setBorder(BorderFactory.createMatteBorder(0,0,5,0, new Color(0,181,236)));
        panel.add(btnSignUp);
        btnChangePass = new JButton("Change Password");
        btnChangePass.setContentAreaFilled(false); 
        btnChangePass.setBorder(BorderFactory.createMatteBorder(0,0,5,0, new Color(244,147,242)));
        panel.add(btnChangePass);
        
        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnLogin.addActionListener((ActionListener) listener);
        btnSignUp.addActionListener((ActionListener) listener);
        btnChangePass.addActionListener((ActionListener) listener);
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