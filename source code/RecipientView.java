import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class RecipientView extends JPanel
{
    private JTextField tfRecipientName;
    private ButtonGroup bgDestination;
    private JRadioButton rbMM;
    private JRadioButton rbLUZ;
    private JRadioButton rbVIS;
    private JRadioButton rbMIN;
    private JSpinner sNumItems;
    private JCheckBox cbInsure;
    
    private JButton btnContinue;
    private JButton btnBackToMenu;
    
    public RecipientView()
    {
        setLayout(new BorderLayout());
        init();
    }
    
    public void init()
    {
        Icon iRecipient = new ImageIcon(getClass().getResource("resources/Recipient.png"),"Recipient.png");
        Icon iDestination = new ImageIcon(getClass().getResource("resources/Destination.png"),"Destination.png");
        Icon iNumItems = new ImageIcon(getClass().getResource("resources/NumItems.png"),"NumItems.png");
        Icon iInsure = new ImageIcon(getClass().getResource("resources/Insure.png"),"Insure.png");

        JPanel panel;
        JPanel subPanel;

        panel = new JPanel(new GridLayout(2,1));

        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        JLabel lblRecipient = new JLabel("Recipient Information");
        lblRecipient.setFont(new Font("Arial", Font.BOLD, 35));
        subPanel.add(lblRecipient);
        panel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        JLabel lblFillUp = new JLabel("Form");
        lblFillUp.setFont(new Font("Arial", Font.BOLD, 30));
        subPanel.add(lblFillUp);
        panel.add(subPanel);
        
        add(panel, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.setBackground(new Color(222,243,253));

        panel.add(new JLabel(iRecipient));
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.setLayout(new GridBagLayout());
        subPanel.add(new JLabel("Recipient Name: "));
        tfRecipientName = new JTextField(13);
        subPanel.add(tfRecipientName);
        panel.add(subPanel);

        panel.add(new JLabel(iDestination));
        subPanel = new JPanel(new GridLayout(4, 1));
        subPanel.setBackground(new Color(222,243,253));
        rbMM = new JRadioButton("Metro Manila", true);
        rbLUZ = new JRadioButton("Provincial Luzon");
        rbVIS = new JRadioButton("Visayas");
        rbMIN = new JRadioButton("Mindanao");
        rbMM.setOpaque(false);
        rbLUZ.setOpaque(false);
        rbVIS.setOpaque(false);
        rbMIN.setOpaque(false);
        bgDestination = new ButtonGroup();
        bgDestination.add(rbMM);
        bgDestination.add(rbLUZ);
        bgDestination.add(rbVIS);
        bgDestination.add(rbMIN);
        subPanel.add(rbMM);
        subPanel.add(rbLUZ);
        subPanel.add(rbVIS);
        subPanel.add(rbMIN);
        subPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Destination"));
        panel.add(subPanel);

        panel.add(new JLabel(iNumItems));
        subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Number of Items: "));
        sNumItems = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        ((JSpinner.DefaultEditor) sNumItems.getEditor()).getTextField().setEditable(false);
        subPanel.add(sNumItems);
        panel.add(subPanel);
        
        panel.add(new JLabel(iInsure));
        subPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subPanel.setBackground(new Color(222,243,253));
        cbInsure = new JCheckBox("Insure");
        cbInsure.setOpaque(false);
        subPanel.add(cbInsure);
        subPanel.add(new JLabel("(Php 5 per item)"));
        panel.add(subPanel);

        add(panel, BorderLayout.CENTER);

        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");
        Icon iCancel = new ImageIcon(getClass().getResource("resources/Cancel.png"),"Cancel.png");

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(new Color(222,243,253));
        btnBackToMenu = new JButton(iCancel);
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setContentAreaFilled(false); 
        btnContinue = new JButton(iContinue);
        btnContinue.setBorderPainted(false);
        btnContinue.setContentAreaFilled(false); 
        panel.add(btnBackToMenu);
        panel.add(btnContinue);

        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnContinue.addActionListener((ActionListener) listener);
        btnBackToMenu.addActionListener((ActionListener) listener);
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) 
    {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) 
        {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) 
                return button.getText();
        }
        return null;
    }

    public String getDestination()
    {
        String destination = getSelectedButtonText(bgDestination);

        if (destination.equals("Metro Manila"))
            return "MML";
        else if (destination.equals("Provincial Luzon"))
            return "LUZ";
        else if (destination.equals("Visayas"))
            return "VIS";
        else return "MIN";
    }

    public String getRecipientName()
    {
        return tfRecipientName.getText();
    }

    public int getNumberOfItems()
    {
        return ((Integer) sNumItems.getValue());
    }

    public boolean isInsured()
    {
        return cbInsure.isSelected();
    }

    public void reset()
    {
        tfRecipientName.setText("");
        rbMM.setSelected(true);
        sNumItems.setValue(1);
        cbInsure.setSelected(false);
    }
}