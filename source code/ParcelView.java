import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ParcelView extends JPanel
{
    private ButtonGroup bgParcel;
    private JRadioButton rbFlat1;
    private JRadioButton rbFlat2;
    private JRadioButton rbBox1;
    private JRadioButton rbBox2;
    private JRadioButton rbBox3;
    private JRadioButton rbBox4;

    private JButton btnChooseParcel; 
    
    public ParcelView()
    {
        setLayout(new BorderLayout());
        init();
    }
    
    public void init()
    {
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");
        Icon iFlat1 = new ImageIcon(getClass().getResource("resources/Flat1.png"),"Flat1.png");
        Icon iFlat2 = new ImageIcon(getClass().getResource("resources/Flat2.png"),"Flat2.png");
        Icon iBox1 = new ImageIcon(getClass().getResource("resources/Box1.png"),"Box1.png");
        Icon iBox2 = new ImageIcon(getClass().getResource("resources/Box2.png"),"Box2.png");
        Icon iBox3 = new ImageIcon(getClass().getResource("resources/Box3.png"),"Box3.png");
        Icon iBox4 = new ImageIcon(getClass().getResource("resources/Box4.png"),"Box4.png");
        

        JPanel panel;
        JPanel subPanel;
        JPanel subberPanel;

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(222,243,253));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblParcelOptions = new JLabel("Parcel Options");
        lblParcelOptions.setFont(new Font("Arial", Font.BOLD, 42));
        subPanel.add(lblParcelOptions);
        subPanel.setBackground(new Color(222,243,253));
        panel.add(subPanel, BorderLayout.NORTH);
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblOption = new JLabel("Choose parcel size: ");
        lblOption.setFont(new Font("Arial", Font.BOLD, 18));
        subPanel.add(lblOption);
        subPanel.setBackground(new Color(222,243,253));
        panel.add(subPanel, BorderLayout.CENTER);


        subberPanel = new JPanel(new GridLayout(1, 4));
        subberPanel.setBackground(new Color(212,233,253));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Parcel Type"));
        subberPanel.add(subPanel);
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Size"));
        subberPanel.add(subPanel);
        subberPanel.add(new JLabel(""));
        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setOpaque(false);
        subPanel.add(new JLabel("Rates"));
        subberPanel.add(subPanel);

        panel.add(subberPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.NORTH);
        

        panel = new JPanel(new GridLayout(6, 4));
        panel.setBackground(new Color(222,243,253));
        rbFlat1 = new JRadioButton("Small Pouch");
        rbFlat2 = new JRadioButton("Big Pouch");
        rbBox1 = new JRadioButton("Small Box");
        rbBox2 = new JRadioButton("Medium Box");
        rbBox3 = new JRadioButton("Large Box");
        rbBox4 = new JRadioButton("X-L Box");
        rbFlat1.setOpaque(false);
        rbFlat2.setOpaque(false);
        rbBox1.setOpaque(false);
        rbBox2.setOpaque(false);
        rbBox3.setOpaque(false);
        rbBox4.setOpaque(false);
        bgParcel = new ButtonGroup();
        bgParcel.add(rbFlat1);
        bgParcel.add(rbFlat2);
        bgParcel.add(rbBox1);
        bgParcel.add(rbBox2);
        bgParcel.add(rbBox3);
        bgParcel.add(rbBox4);

        panel.add(rbFlat1);
        panel.add(new JLabel("< 9 x 14 x 1 >   in."));
        panel.add(new JLabel(iFlat1));
        panel.add(new JLabel("Php 30 (up to 3 kilos)"));
        panel.add(rbFlat2);
        panel.add(new JLabel("< 12 x 18 x 3 >   in."));
        panel.add(new JLabel(iFlat2));
        panel.add(new JLabel("Php 50 (up to 3 kilos)"));
        panel.add(rbBox1);
        panel.add(new JLabel("< 12 x 10 x 5 >   in."));
        panel.add(new JLabel(iBox1));

        subPanel = new JPanel(new GridLayout(3,1));
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("For all boxes: "));
        subPanel.add(new JLabel("PhP40 per kilo for"));
        subPanel.add(new JLabel("regular products or"));
        panel.add(subPanel);

        panel.add(subPanel);
        panel.add(rbBox2);
        panel.add(new JLabel("< 14 x 11 x 7 >   in."));
        panel.add(new JLabel(iBox2));

        subPanel = new JPanel(new GridLayout(3,1));
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("documents; "));
        subPanel.add(new JLabel("For irregular"));
        subPanel.add(new JLabel("shaped items,"));
        panel.add(subPanel);

        panel.add(rbBox3);
        panel.add(new JLabel("< 18 x 12 x 9 >   in."));
        panel.add(new JLabel(iBox3));

        subPanel = new JPanel(new GridLayout(3,1));
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Php 30 per kilo"));
        subPanel.add(new JLabel("of volumetric"));
        subPanel.add(new JLabel("weight or"));
        panel.add(subPanel);
        
        panel.add(rbBox4);
        panel.add(new JLabel("< 20 x 16 x 12 >   in."));
        panel.add(new JLabel(iBox4));

        subPanel = new JPanel(new GridLayout(3,1));
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Php 40 per kilo"));
        subPanel.add(new JLabel("of actual weight,"));
        subPanel.add(new JLabel("whichever is higher"));
        panel.add(subPanel);
        

        subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        subPanel.setBackground(new Color(222,243,253));
        btnChooseParcel = new JButton(iContinue);
        btnChooseParcel.setBorderPainted(false);
        btnChooseParcel.setContentAreaFilled(false); 
        subPanel.add(btnChooseParcel);

        add(subPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    public void updateParcelOptions(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f)
    {
        rbFlat1.setEnabled(a);
        rbFlat2.setEnabled(b);
        rbBox1.setEnabled(c);
        rbBox2.setEnabled(d);
        rbBox3.setEnabled(e);
        rbBox4.setEnabled(f);
        rbBox4.setSelected(true);
    }

    public void resetParcelOptions()
    {
        rbFlat1.setEnabled(true);
        rbFlat2.setEnabled(true);
        rbBox1.setEnabled(true);
        rbBox2.setEnabled(true);
        rbBox3.setEnabled(true);
        rbBox4.setEnabled(true);
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

    public int getSelectedParcelIndex()
    {
        String parcel = getSelectedButtonText(bgParcel);

        if (parcel.equals("Small Pouch"))
            return 0;
        else if (parcel.equals("Big Pouch"))
            return 1;
        else if (parcel.equals("Small Box"))
            return 2;
        else if (parcel.equals("Medium Box"))
            return 3;
        else if (parcel.equals("Large Box"))
            return 4;
        else return 5;
    }

    public void addListeners(EventListener listener)
    {
        btnChooseParcel.addActionListener((ActionListener) listener);
    }
}