import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class RecipientController implements ActionListener
{
    private MainView gui;
    private RecipientView subGui;
    private MainController mainController;

    public RecipientController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (RecipientView) gui.getPanel(gui.ADD_RECIPIENT);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton b = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) b.getIcon());

        if (i.getDescription().equals("Continue.png"))
        {
            if (subGui.getRecipientName().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Recipient name cannot be empty.", "Adding Recipient Info", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                mainController.addRecipient(getRecipient());
                mainController.setupItemController(subGui.getNumberOfItems());
                mainController.isInsured(subGui.isInsured());
                gui.updateCenterPane(gui.ADD_ITEM);
                JOptionPane.showMessageDialog(null, "Note: For irregularly shaped products, input the largest measures for length, width, and height. Input weight in grams.", "Adding Items", JOptionPane.INFORMATION_MESSAGE);
            }  
        }
            
        else if (i.getDescription().equals("Cancel.png"))
        {
            gui.updateCenterPane(gui.MENU);
        }
    }

    public Recipient getRecipient()
    {
        String name = subGui.getRecipientName();
        String destination = subGui.getDestination();

        Recipient recipient = new Recipient(name, destination);

        return recipient;
    }
}