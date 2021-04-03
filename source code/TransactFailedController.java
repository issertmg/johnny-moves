import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TransactFailedController implements ActionListener
{
    private MainView gui;
    private MainController mainController;
    private TransactFailedView subGui;

    public TransactFailedController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (TransactFailedView) gui.getPanel(gui.TRANSACT_FAILED);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        gui.updateCenterPane(gui.ADD_RECIPIENT);
        mainController.dispose();
    }
}