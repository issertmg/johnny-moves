import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TransactSuccessController implements ActionListener
{
    private MainView gui;
    private MainController mainController;
    private TransactSuccessView subGui;

    public TransactSuccessController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (TransactSuccessView) gui.getPanel(gui.TRANSACT_SUCCESS);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        ((RecipientView) gui.getPanel(gui.ADD_RECIPIENT)).reset();
        gui.updateCenterPane(gui.MENU);
    }
}