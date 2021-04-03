import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TrackingInfoView extends JPanel
{
    public final String PREPARING = "Preparing";
    public final String SHIPPING = "Shipping";
    public final String DELIVERED = "Delivered";
    public final String BLANK = "";

    private JTextArea taTrackingInfo;
    private JTextField tfTrackingNum;
    private JTextField tfStatus;

    private JButton btnBackToMenu;
    private JButton btnOk;

    private JPanel centerPane;
    
    public TrackingInfoView()
    {
        setLayout(new BorderLayout());
        setBackground(new Color(222,243,253));
        init();
    }

    public void init()
    {
        Icon iTrack = new ImageIcon(getClass().getResource("resources/Track.png"),"Track.png");
        Icon iTracking = new ImageIcon(getClass().getResource("resources/Tracking.png"),"Tracking.png");
        Icon iBack = new ImageIcon(getClass().getResource("resources/BackToMenu.png"),"BackToMenu.png");
        
        Icon iPreparing = new ImageIcon(getClass().getResource("resources/Preparing.png"),"Preparing.png");
        Icon iShipping = new ImageIcon(getClass().getResource("resources/Shipping.png"),"Shipping.png");
        Icon iDelivered = new ImageIcon(getClass().getResource("resources/Delivered.png"),"Delivered.png");

        JPanel panel;
        JPanel subPanel;
        JPanel panelBlank;
        JPanel panelPreparing;
        JPanel panelShipping;
        JPanel panelDelivered;

        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(222,243,253));

        JLabel lblTrackingNum = new JLabel("Tracking Number: ");
        lblTrackingNum.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTrackingNum);

        tfTrackingNum = new JTextField(15);
        tfTrackingNum.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(tfTrackingNum);
        
        btnOk = new JButton(iTrack);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false); 
        panel.add(btnOk);

        add(panel, BorderLayout.NORTH);

        centerPane = new JPanel(new CardLayout());
        centerPane.setBackground(new Color(222,243,253));

        panelBlank = new JPanel();
        panelBlank.setOpaque(false);
        panelBlank.add(new JLabel(iTracking));
        centerPane.add(panelBlank, BLANK);

        panelPreparing = new JPanel();
        panelPreparing.setOpaque(false);
        panelPreparing.add(new JLabel(iPreparing));
        centerPane.add( panelPreparing, PREPARING);

        panelShipping = new JPanel();
        panelShipping.setOpaque(false);
        panelShipping.add(new JLabel(iShipping));
        centerPane.add(panelShipping, SHIPPING);

        panelDelivered = new JPanel();
        panelDelivered.setOpaque(false);
        panelDelivered.add(new JLabel(iDelivered));
        centerPane.add(panelDelivered, DELIVERED);

        panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        subPanel = new JPanel(new BorderLayout());
        subPanel.setOpaque(false);
        subPanel.add(centerPane, BorderLayout.CENTER);
        
        tfStatus = new JTextField(1);
        tfStatus.setFont(new Font("Arial", Font.BOLD, 18));
        tfStatus.setBorder(BorderFactory.createEmptyBorder());
        tfStatus.setOpaque(false);
        tfStatus.setEditable(false);

        subPanel.add(tfStatus, BorderLayout.SOUTH);

        panel.add(subPanel);
        taTrackingInfo = new JTextArea();
        taTrackingInfo.setEditable(false);
        taTrackingInfo.setBackground(new Color(212,233,253));
        taTrackingInfo.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(taTrackingInfo);

        add(panel, BorderLayout.CENTER);

        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setOpaque(false);
        btnBackToMenu = new JButton(iBack);
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setContentAreaFilled(false); 
        panel.add(btnBackToMenu);
        add(panel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        btnOk.addActionListener((ActionListener) listener);
        btnBackToMenu.addActionListener((ActionListener) listener);
    }

    public String getTrackingNumber()
    {
        return tfTrackingNum.getText();
    }

    public void updateCenterPane(String name)
	{
		CardLayout cards = (CardLayout) centerPane.getLayout ();
		cards.show(centerPane, name);
    }

    public void setup(String info)
    {
        taTrackingInfo.setText(info);
    }

    public void setStatus(String info)
    {
        tfStatus.setText(info);
    }

    public void reset()
    {
        updateCenterPane(BLANK);
        tfTrackingNum.setText("");
        tfStatus.setText("");
        taTrackingInfo.setText("");
    }
}