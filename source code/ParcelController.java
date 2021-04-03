import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ParcelController implements ActionListener
{
    private MainView gui;
    private ParcelView subGui;
    private MainController mainController;


    public ParcelController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (ParcelView) gui.getPanel(gui.CHOOSE_PARCEL);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        mainController.setParcelIndex(subGui.getSelectedParcelIndex());
        subGui.resetParcelOptions();
        mainController.createTransaction();
        mainController.setupTransactSuccessView();
        gui.updateCenterPane(gui.TRANSACT_SUCCESS);
    }
}