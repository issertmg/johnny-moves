import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MenuView extends JPanel
{
    private JButton btnSendParcel;
    private JButton btnTrackParcel;
    private JButton btnExit;

    public MenuView()
    {
        setLayout(new GridLayout(4, 3));
        setBackground(new Color(222,243,253));
        init();
    }
    
    public void init()
    {
        Icon sendParcel = new ImageIcon(getClass().getResource("resources/SendParcel.png"),"SendParcel.png");
        Icon trackParcel = new ImageIcon(getClass().getResource("resources/TrackParcel.png"),"TrackParcel.png");
        Icon exit = new ImageIcon(getClass().getResource("resources/Exit.png"),"Exit.png");
        
        JPanel panel;
        JPanel subPanel;

        panel = new JPanel(new GridLayout(2,1));
        panel.setBackground(new Color(222,243,253));
        JLabel lblJohnnyMoves = new JLabel("Johnny Moves!");
        lblJohnnyMoves.setFont(new Font("Arial", Font.BOLD, 56));
        subPanel = new JPanel(new GridBagLayout());
        subPanel.setOpaque(false);
        subPanel.add(lblJohnnyMoves);
        panel.add(subPanel);
        subPanel = new JPanel(new GridBagLayout());
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("What do you want to do?"));
        panel.add(subPanel);
        
        
        btnSendParcel = new JButton("Send Parcel");
        btnSendParcel.setIcon(sendParcel);
        btnSendParcel.setBorderPainted(false);
        btnSendParcel.setContentAreaFilled(false); 

        btnTrackParcel = new JButton("Track Parcel");
        btnTrackParcel.setIcon(trackParcel);
        btnTrackParcel.setBorderPainted(false);
        btnTrackParcel.setContentAreaFilled(false); 

        btnExit = new JButton("Exit     ");
        btnExit.setIcon(exit);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        
        add(panel);
        add(btnSendParcel);
        add(btnTrackParcel);
        add(btnExit);
    }

    public void addListeners(EventListener listener)
    {
        btnSendParcel.addActionListener((ActionListener) listener);
        btnTrackParcel.addActionListener((ActionListener) listener);
        btnExit.addActionListener((ActionListener) listener);
    }
}