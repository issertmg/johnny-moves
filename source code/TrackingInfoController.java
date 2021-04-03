import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class TrackingInfoController implements ActionListener
{
    private MainView gui;
    private TrackingInfoView subGui;
    private MainController mainController;

    public TrackingInfoController(MainView gui, MainController mainController)
    {
        this.gui = gui;
        this.mainController = mainController;
        subGui = (TrackingInfoView) gui.getPanel(gui.TRACKING_INFO);
        subGui.addListeners(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton o = ((JButton) e.getSource());
        ImageIcon i = ((ImageIcon) o.getIcon());

        if (i.getDescription().equals("Track.png"))
        {
            subGui.setup(mainController.getMachine().trackParcel(subGui.getTrackingNumber()));
            subGui.setStatus("   Status:\t\t" + (mainController.getMachine().getStatusOfParcel(subGui.getTrackingNumber())));
            
            if (!(mainController.getMachine().getStatusOfParcel(subGui.getTrackingNumber()).equals("")))
                subGui.updateCenterPane(mainController.getMachine().getStatusOfParcel(subGui.getTrackingNumber()));
            else 
            {
                subGui.updateCenterPane(subGui.BLANK);
                subGui.setStatus("");
            }
        }
        else if (i.getDescription().equals("BackToMenu.png"))
        {
            subGui.reset();
            gui.updateCenterPane(gui.MENU);
        }
    }
}