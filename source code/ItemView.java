import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ItemView extends JPanel
{
    public final String ADD_REGULAR = "Add Regular";
    public final String ADD_IRREGULAR = "Add Irregular";
    public final String ADD_DOCUMENT = "Add Document";
    
    private JPanel centerPaneAddItem;
    private JPanel subPanelAddRegular;
    private JPanel subPanelAddIrregular;
    private JPanel subPanelAddDocument;
   
    private JButton btnOk;

    private JTextField tfRegLength;
    private JTextField tfRegWidth;
    private JTextField tfRegHeight;
    private JTextField tfRegWeight;

    private JTextField tfIrrLength;
    private JTextField tfIrrWidth;
    private JTextField tfIrrHeight;
    private JTextField tfIrrWeight;

    private JTextField tfDocLength;
    private JTextField tfDocWidth;
    private JTextField tfNumPages;


    private JTextField tfItemNumber;

    private ButtonGroup bgItemType;
    private JRadioButton rbRegular;
    private JRadioButton rbIrregular;
    private JRadioButton rbDocument;

    
    public ItemView()
    {
        setLayout(new BorderLayout());
        init();
        setBackground(new Color(222,243,253));
    }
    
    public void init()
    {
        Icon iRegular = new ImageIcon(getClass().getResource("resources/Regular.png"),"Regular.png");
        Icon iIrregular = new ImageIcon(getClass().getResource("resources/Irregular.png"),"Irregular.png");
        Icon iDocument = new ImageIcon(getClass().getResource("resources/Document.png"),"Document.png");
        Icon iContinue = new ImageIcon(getClass().getResource("resources/Continue.png"),"Continue.png");

        JPanel panel;
        JPanel subPanel;
        JPanel subberPanel;

        JLabel lblInches;
        JLabel lblGrams;
        
        panel = new JPanel(new BorderLayout());
        
        subPanel = new JPanel(new GridLayout(1, 3));
        subPanel.setBackground(new Color(222,243,253));
        rbRegular = new JRadioButton("Regular Product", true);
        rbIrregular = new JRadioButton("Irregular Product");
        rbDocument = new JRadioButton("Document");
        rbRegular.setOpaque(false);
        rbIrregular.setOpaque(false);
        rbDocument.setOpaque(false);
        bgItemType = new ButtonGroup();
        bgItemType.add(rbRegular);
        bgItemType.add(rbIrregular);
        bgItemType.add(rbDocument);
        subPanel.add(rbRegular);
        subPanel.add(rbIrregular);
        subPanel.add(rbDocument);
        subPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Item Type"));
        panel.add(subPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        centerPaneAddItem = new JPanel(new CardLayout());
        
        //ADD REGULAR PANE
        subPanelAddRegular = new JPanel(new GridLayout(3,1));
        subPanelAddRegular.setBackground(new Color(222,243,253));
        subPanelAddRegular.add(new JLabel(iRegular));
        subberPanel = new JPanel(new GridLayout(4, 1));
        subberPanel.setBackground(new Color(222,243,253));
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Length: "));
        tfRegLength = new JTextField(5);
        subPanel.add(tfRegLength);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Width: "));
        tfRegWidth = new JTextField(5);
        subPanel.add(tfRegWidth);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Height: "));
        tfRegHeight = new JTextField(5);
        subPanel.add(tfRegHeight);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Weight: "));
        tfRegWeight = new JTextField(5);
        subPanel.add(tfRegWeight);
        lblGrams = new JLabel(" g.");
        lblGrams.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblGrams);
        subberPanel.add(subPanel);

        subPanelAddRegular.add(subberPanel);

        centerPaneAddItem.add(subPanelAddRegular, ADD_REGULAR);

        //ADD IRREGULAR PANE
        subPanelAddIrregular = new JPanel(new GridLayout(3,1));
        subPanelAddIrregular.setBackground(new Color(222,243,253));
        subPanelAddIrregular.add(new JLabel(iIrregular));
        subberPanel = new JPanel(new GridLayout(4, 1));
        subberPanel.setBackground(new Color(222,243,253));
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Length: "));
        tfIrrLength = new JTextField(5);
        subPanel.add(tfIrrLength);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Width: "));
        tfIrrWidth = new JTextField(5);
        subPanel.add(tfIrrWidth);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Height: "));
        tfIrrHeight = new JTextField(5);
        subPanel.add(tfIrrHeight);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Weight: "));
        tfIrrWeight = new JTextField(5);
        subPanel.add(tfIrrWeight);
        lblGrams = new JLabel(" g.");
        lblGrams.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblGrams);
        subberPanel.add(subPanel);

        subPanelAddIrregular.add(subberPanel);

        centerPaneAddItem.add(subPanelAddIrregular, ADD_IRREGULAR);

        //ADD DOCUMENT PANE
        subPanelAddDocument = new JPanel(new GridLayout(3,1));
        subPanelAddDocument.setBackground(new Color(222,243,253));
        subPanelAddDocument.add(new JLabel(iDocument));
        subberPanel = new JPanel(new GridLayout(3, 1));
        subberPanel.setBackground(new Color(222,243,253));
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Length: "));
        tfDocLength = new JTextField(5);
        subPanel.add(tfDocLength);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Width: "));
        tfDocWidth = new JTextField(5);
        subPanel.add(tfDocWidth);
        lblInches = new JLabel(" in.");
        lblInches.setFont(new Font("Arial", Font.ITALIC, 14));
        subPanel.add(lblInches);
        subberPanel.add(subPanel);
        subPanel = new JPanel();
        subPanel.setBackground(new Color(222,243,253));
        subPanel.add(new JLabel("Number of Pages: "));
        tfNumPages = new JTextField(5);
        subPanel.add(tfNumPages);
        subberPanel.add(subPanel);

        subPanelAddDocument.add(subberPanel);

        centerPaneAddItem.add(subPanelAddDocument, ADD_DOCUMENT);

        panel.add(centerPaneAddItem, BorderLayout.CENTER);

        JLabel lblItem = new JLabel("Item #");
        lblItem.setFont(new Font("Arial", Font.BOLD, 30));

        tfItemNumber = new JTextField(3);
        tfItemNumber.setFont(new Font("Arial", Font.BOLD, 30));
        tfItemNumber.setBorder(BorderFactory.createEmptyBorder());
        tfItemNumber.setOpaque(false);
        tfItemNumber.setEditable(false);
        tfItemNumber.setText("1");

        panel = new JPanel(new FlowLayout());
        panel.setBackground(new Color(222,243,253));
        panel.add(lblItem);
        panel.add(tfItemNumber);

        add(panel, BorderLayout.NORTH);

        subPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subPanel.setBackground(new Color(222,243,253));
        btnOk = new JButton(iContinue);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false); 
        subPanel.add(btnOk);
        add(subPanel, BorderLayout.SOUTH);
    }

    public void addListeners(EventListener listener)
    {
        rbDocument.addItemListener((ItemListener) listener);
        rbIrregular.addItemListener((ItemListener) listener);
        rbRegular.addItemListener((ItemListener) listener);
        
        btnOk.addActionListener((ActionListener) listener);
    }

    public String getItemTypeSelected()
    {
        return bgItemType.getSelection().getActionCommand();
    }
    
    public void updateCenterPane(String name)
	{
		CardLayout cards = (CardLayout) centerPaneAddItem.getLayout ();
		cards.show(centerPaneAddItem, name);
    }

    public void incrementItemNumber()
    {
        int newVal = getItemNumber() + 1;
        tfItemNumber.setText(String.valueOf(newVal));
    }

    public int getItemNumber()
    {
        return Integer.parseInt(tfItemNumber.getText());
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

    public String getItemType()
    {
        String itemType = getSelectedButtonText(bgItemType);

        return itemType;
    }

    public double getRegLength()
    {
        return Double.parseDouble(tfRegLength.getText());
    }

    public double getRegWidth()
    {
        return Double.parseDouble(tfRegWidth.getText());
    }

    public double getRegHeight()
    {
        return Double.parseDouble(tfRegHeight.getText());
    }

    public double getRegWeight()
    {
        return Double.parseDouble(tfRegWeight.getText());
    }

    public double getIrrLength()
    {
        return Double.parseDouble(tfIrrLength.getText());
    }

    public double getIrrWidth()
    {
        return Double.parseDouble(tfIrrWidth.getText());
    }

    public double getIrrHeight()
    {
        return Double.parseDouble(tfIrrHeight.getText());
    }

    public double getIrrWeight()
    {
        return Double.parseDouble(tfIrrWeight.getText());
    }

    public double getDocLength()
    {
        return Double.parseDouble(tfDocLength.getText());
    }

    public double getDocWidth()
    {
        return Double.parseDouble(tfDocWidth.getText());
    }
    
    public int getNumberOfPages()
    {
        return Integer.parseInt(tfNumPages.getText());
    }

    public void reset()
    {
        rbRegular.setSelected(true);

        tfRegLength.setText("");;
        tfRegWidth.setText("");;
        tfRegHeight.setText("");;
        tfRegWeight.setText("");;

        tfIrrLength.setText("");;
        tfIrrWidth.setText("");;
        tfIrrHeight.setText("");;
        tfIrrWeight.setText("");;

        tfDocLength.setText("");;
        tfDocWidth.setText("");;
        tfNumPages.setText("");;
    }

    public void resetItemNumber()
    {
        tfItemNumber.setText("1");
    }
}