import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TransactFailedView extends JPanel
{
    private JButton btnBackToMenu;
    
    public TransactFailedView()
    {
        setLayout(new BorderLayout());
        init();
    }

    public void init()
    {
        JPanel panel;
        JPanel subPanel;

        Icon iFailed = new ImageIcon(getClass().getResource("resources/Failed.png"),"Failed.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JLabel lblFailed = new JLabel("Transaction Unsuccessful!", SwingConstants.CENTER);
        lblFailed.setFont(new Font("Arial", Font.BOLD, 35));

        subPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subPanel.setBackground(new Color(222,243,253));
        btnBackToMenu = new JButton(iContinue);
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setContentAreaFilled(false); 
        subPanel.add(btnBackToMenu);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(222,243,253));
        panel.add(lblFailed, BorderLayout.NORTH);
        panel.add(new JLabel(iFailed), BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(subPanel, BorderLayout.SOUTH);
        
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setBackground(new Color(222,243,253));
        JLabel lblNote1 = new JLabel("The items could not fit ");
        lblNote1.setFont(new Font("Arial", Font.BOLD, 22));
        JLabel lblNote2 = new JLabel("in any available parcel sizes. ");
        lblNote2.setFont(new Font("Arial", Font.BOLD, 22));
        JLabel lblNote3 = new JLabel("Please divide the items for ");
        lblNote3.setFont(new Font("Arial", Font.BOLD, 22));
        JLabel lblNote4 = new JLabel("multiple shipping transactions.");
        lblNote4.setFont(new Font("Arial", Font.BOLD, 22));
        subPanel.add(lblNote1);
        subPanel.add(lblNote2);
        subPanel.add(lblNote3);
        subPanel.add(lblNote4);
        add(subPanel, BorderLayout.CENTER);
    }

    public void addListeners(EventListener listener)
    {
        btnBackToMenu.addActionListener((ActionListener) listener);
    }
}