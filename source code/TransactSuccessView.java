import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TransactSuccessView extends JPanel
{
    private JTextArea taFee;
    private JTextField tfTrackingNum;

    private JButton btnBackToMenu;

    public TransactSuccessView()
    {
        setLayout(new BorderLayout());
        init();
    }

    public void init()
    {
        JPanel panel;
        JPanel subPanel;

        Icon iSuccess = new ImageIcon(getClass().getResource("resources/Success.png"),"Success.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JLabel lblSuccess = new JLabel("Transaction Successful!", SwingConstants.CENTER);
        lblSuccess.setFont(new Font("Arial", Font.BOLD, 30));

        subPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subPanel.setBackground(new Color(222,243,253));
        btnBackToMenu = new JButton(iContinue);
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setContentAreaFilled(false); 
        subPanel.add(btnBackToMenu);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(222,243,253));
        panel.add(lblSuccess, BorderLayout.NORTH);
        panel.add(new JLabel(iSuccess), BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(subPanel, BorderLayout.SOUTH);

        taFee = new JTextArea();
        taFee.setEditable(false);
        taFee.setBackground(new Color(212,233,253));
        taFee.setFont(new Font("Arial", Font.PLAIN, 18));
        tfTrackingNum = new JTextField(18);
        tfTrackingNum.setEditable(false);
        tfTrackingNum.setFont(new Font("Arial", Font.PLAIN, 18));
        tfTrackingNum.setBorder(BorderFactory.createEmptyBorder());
        tfTrackingNum.setOpaque(false);
        subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subPanel.setBackground(new Color(222,243,253));
        JLabel lblTrackingNum = new JLabel("    Tracking Number:  ");
        lblTrackingNum.setFont(new Font("Arial", Font.BOLD, 18));
        subPanel.add(lblTrackingNum);
        subPanel.add(tfTrackingNum);
        panel = new JPanel(new BorderLayout());
        panel.add(subPanel, BorderLayout.NORTH);
        panel.add(taFee, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
    }

    public void addListeners(EventListener listener)
    {
        btnBackToMenu.addActionListener((ActionListener) listener);
    }

    public void setup(String trackNum, String recipientFee)
    {
        tfTrackingNum.setText(trackNum);
        taFee.setText(recipientFee);
    }
}