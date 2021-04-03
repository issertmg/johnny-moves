import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ItemController implements ActionListener, ItemListener
{
    private MainView gui;
    private ItemView subGui;
    private MainController mainController;

    private ArrayList<Item> items;
    private int numItems;

    public ItemController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (ItemView) gui.getPanel(gui.ADD_ITEM);
        subGui.addListeners(this);
    }

    public void setup(int numItems)
    {
        this.numItems = numItems;
        items = new ArrayList<Item>();
    }

    public void itemStateChanged (ItemEvent e)
	{
        if (e.getStateChange () == ItemEvent.SELECTED)
		{
                if (((JRadioButton)e.getSource()).getText().equals("Document"))
                    subGui.updateCenterPane(subGui.ADD_DOCUMENT);
                else if (((JRadioButton)e.getSource()).getText().equals("Regular Product"))
                    subGui.updateCenterPane(subGui.ADD_REGULAR);
                else if (((JRadioButton)e.getSource()).getText().equals("Irregular Product"))
                    subGui.updateCenterPane(subGui.ADD_IRREGULAR);
		}
	}

    public void actionPerformed(ActionEvent e)
    {
        if (subGui.getItemNumber() <= numItems)
        {
            if (subGui.getItemType().equals("Regular Product"))
            {
                try
                {
                RegularShapedProduct regProduct = getRegularProduct();
                items.add(regProduct);
                subGui.incrementItemNumber();
                subGui.reset();
                }
                catch (NumberFormatException f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException a)
                {
                    JOptionPane.showMessageDialog(null, a.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (subGui.getItemType().equals("Irregular Product"))
            {
                try
                {
                    IrregularShapedProduct irregProduct = getIrregularProduct();
                    items.add(irregProduct);
                    subGui.incrementItemNumber();
                    subGui.reset();
                }
                catch (NumberFormatException f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException a)
                {
                    JOptionPane.showMessageDialog(null, a.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                try
                {
                    Document docu = getDocument();
                    items.add(docu);
                    subGui.incrementItemNumber();
                    subGui.reset();
                }
                catch (NumberFormatException f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException a)
                {
                    JOptionPane.showMessageDialog(null, a.getMessage(), "Measurement inputs", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (subGui.getItemNumber() > numItems)
            {
                subGui.resetItemNumber();
                mainController.addItem(items);
                
                Machine machine = mainController.getMachine();

                if(machine.isAnyParcelAvailable(items))
                {
                    boolean[] p = machine.getParcelOptions(items);

                    ((ParcelView) gui.getPanel(gui.CHOOSE_PARCEL)).updateParcelOptions(p[0], p[1], p[2], p[3], p[4], p[5]);
                    gui.updateCenterPane(gui.CHOOSE_PARCEL);
                }
                else
                {
                    gui.updateCenterPane(gui.TRANSACT_FAILED);
                }
            } 
        }
    }

    public RegularShapedProduct getRegularProduct() throws NumberFormatException
    {
        double length, width, height, weight;
        try 
        {
            length = subGui.getRegLength();
            width = subGui.getRegWidth();
            height = subGui.getRegHeight();
            weight = subGui.getRegWeight();
        } 
        catch (NumberFormatException e) 
        {
            throw new NumberFormatException("Incorrect input, enter appropriate \nmeasurements in respective fields.");
        }      
        return new RegularShapedProduct(length, width, height, weight);
    }

    public IrregularShapedProduct getIrregularProduct() throws NumberFormatException
    {
        double length, width, height, weight;
        try
        {
            length = subGui.getIrrLength();
            width = subGui.getIrrWidth();
            height = subGui.getIrrHeight();
            weight = subGui.getIrrWeight();
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Incorrect input, enter appropriate \nmeasurements in respective fields.");
        }
        return new IrregularShapedProduct(length, width, height, weight);
    }

    public Document getDocument() throws NumberFormatException
    {
        double length, width;
        int numPages;
        try
        {
            length = subGui.getDocLength();
            width = subGui.getDocWidth();
            numPages = subGui.getNumberOfPages();
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Incorrect input, enter appropriate \nmeasurements in respective fields.");
        }
        return new Document(length, width, numPages);
    }

    public void disposeItems()
    {
        items = new ArrayList<Item>();
    }

}
