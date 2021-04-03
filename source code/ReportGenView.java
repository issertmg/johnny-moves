import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ReportGenView extends JPanel
{
    private String[] columnNames = {"Transaction Date", "Recipient name", "Destination", "ETA", "Status"};
    private JButton btnOk;
    
    public ReportGenView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        btnOk = new JButton(iContinue);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false);   
        
        add(btnOk, BorderLayout.SOUTH);
    }

    public void setup(String[][] data, String currentDate)
    {       
        JLabel lblHeader = new JLabel("Transactions as of " + currentDate);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 23));
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelHeader.setOpaque(false);
        panelHeader.add(lblHeader);
        
        JTable table = new JTable(data, columnNames);

        JScrollPane scroll = new JScrollPane(table);

        add(panelHeader, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);     
    }

    public void addListeners(EventListener listener)
    {
        btnOk.addActionListener((ActionListener) listener);
    }
}