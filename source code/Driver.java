import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Driver
{
    public static void main(String[] args)
    {
        Machine machine = new Machine();
        MainView gui = new MainView("Johnny Moves");
        MainController mainController = new MainController(gui, machine); 
    }
}