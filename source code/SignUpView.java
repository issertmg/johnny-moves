import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpView extends JPanel
{
    private JButton btnBackToLogin;
    private JButton btnOk;

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JPasswordField pfAdminPass;
    
    public SignUpView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iSignUp = new ImageIcon(getClass().getResource("resources/SignUp.png"),"SignUp.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JPanel panel; 
        JPanel subPanel;
        JPanel subberPanel;
        
        panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        JLabel lblSignUp = new JLabel("Sign Up");
        lblSignUp.setFont(new Font("Arial", Font.BOLD, 56));
        panel.add(new JLabel(iSignUp));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(lblSignUp);
        panel.add(subPanel);
        add(panel, BorderLayout.NORTH);

        panel = new JPanel(new GridLayout(5, 1));
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

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Confirm password: "));
        pfConfirmPassword = new JPasswordField(15);
        subPanel.add(pfConfirmPassword);
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setBackground(new Color(212,233,253));
        subPanel.add(new JLabel("Note: Ask admin for assistance. <admin key>"));
        panel.add(subPanel);

        subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Admin key: "));
        pfAdminPass = new JPasswordField(15);
        subPanel.add(pfAdminPass);
        panel.add(subPanel);

        subberPanel = new JPanel(new GridLayout(2, 1));
        subberPanel.setOpaque(false);

        btnOk = new JButton(iContinue);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false); 
        subberPanel.add(panel);
        subberPanel.add(btnOk);

        add(subberPanel, BorderLayout.CENTER);

        panel = new JPanel();
        panel.setOpaque(false);
        btnBackToLogin = new JButton("Back to Sign in");
        btnBackToLogin.setContentAreaFilled(false); 
        btnBackToLogin.setBorder(BorderFactory.createMatteBorder(0,0,5,0, new Color(0,181,236)));
        panel.add(btnBackToLogin);

        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnOk.addActionListener((ActionListener) listener);
        btnBackToLogin.addActionListener((ActionListener) listener);
    }

    public void reset()
    {
        tfUsername.setText("");
        pfPassword.setText("");
        pfConfirmPassword.setText("");
        pfAdminPass.setText("");
    }

    public String getUsername()
    {
        return tfUsername.getText();
    }

    public String getPassword()
    {
        return new String(pfPassword.getPassword());
    }

    public String getConfirmPass()
    {
        return new String(pfConfirmPassword.getPassword());
    }

    public String getAdminPass()
    {
        return new String(pfAdminPass.getPassword());
    }
}