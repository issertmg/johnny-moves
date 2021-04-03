import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AdminKeyView extends JPanel
{
    private JButton btnOk;

    private JTextField tfAdminKey;

    public AdminKeyView()
    {
        setBackground(new Color(222,243,253));
        setLayout(new BorderLayout());
        init();
    }

    public void init()
    {
        Icon iAdminKey = new ImageIcon(getClass().getResource("resources/AdminKey.png"), "AdminKey.png");

        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"), "Continue.png");


        JPanel panel;
        JPanel subPanel;

        panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(new JLabel(iAdminKey));
        panel.add(subPanel, BorderLayout.CENTER);

        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        JLabel lblSetup = new JLabel("Administrator setup");
        lblSetup.setFont(new Font("Arial", Font.BOLD, 42));
        subPanel.add(lblSetup);
        panel.add(subPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.NORTH);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);
        panel.add(new JLabel("Set admin key: "));
        tfAdminKey = new JTextField(15);
        panel.add(tfAdminKey);

        add(panel, BorderLayout.CENTER);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);
        btnOk = new JButton(iContinue);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false); 
        panel.add(btnOk);

        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnOk.addActionListener((ActionListener) listener);
    }

    public String getAdminKey()
    {
        return tfAdminKey.getText();
    }
}


