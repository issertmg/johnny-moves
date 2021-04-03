import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ReportGenController implements ActionListener
{
    private MainView gui;
    private ReportGenView subGui;
    private MainController mainController;

    public ReportGenController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (ReportGenView) gui.getPanel(gui.GENERATE_REPORT);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        mainController.getMachine().shutdown(); 
    }
}