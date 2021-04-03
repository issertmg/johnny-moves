import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MainView extends JFrame
{
    
    public final String LOGIN = "Login";
    public final String SIGN_UP = "Sign Up";
    public final String SIGN_OUT = "Sign Out";
    public final String MENU = "Menu";
    public final String ADD_RECIPIENT = "Add Recipient";
    public final String ADD_ITEM = "Add Item";
    public final String TRANSACT_SUCCESS = "Transaction Success";
    public final String TRANSACT_FAILED = "Transaction Failed";
    public final String TRACKING_INFO = "Tracking Info";
    public final String CHOOSE_PARCEL = "Choose Parcel";
    public final String CHANGE_PASSWORD = "Change Password";
    public final String GENERATE_REPORT = "Report";
    public final String SETUP_ADMIN = "Setup Admin";

    private JPanel centerPane;
    private AdminKeyView panelSetupAdmin;
    private LoginView panelLogin;
    private SignUpView panelSignUp;
    private SignOutView panelSignOut;
    private MenuView panelMenu;
    private RecipientView panelAddRecipient;
    private ItemView panelAddItem;
    private TransactSuccessView panelTransactSuccess;
    private TransactFailedView panelTransactFailed;
    private ParcelView panelChooseParcel;
    private TrackingInfoView panelTrackingInfo;
    private ChangePassView panelChangePassword;
    private ReportGenView panelReportGen;

    private JLabel lblDate;

    public MainView(String name)
	{
		super(name);
        setLayout(new BorderLayout ());
        
        init(); 
        initStatusBar();           

        ImageIcon iJohnnyMoves = new ImageIcon(getClass().getResource("resources/JMIcon.png"));
        setIconImage(iJohnnyMoves.getImage());
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (500, 630);
        setMaximumSize(new Dimension(500, 630));
        setMinimumSize(new Dimension(500, 630));
        setPreferredSize(new Dimension(500, 630));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
		setVisible (true);
    }
    
    public void init()
    {
        centerPane = new JPanel(new CardLayout());

        panelMenu = new MenuView();
        panelSetupAdmin = new AdminKeyView();
        panelAddRecipient = new RecipientView();
        panelAddItem = new ItemView();
        panelChooseParcel = new ParcelView();
        panelTransactSuccess = new TransactSuccessView();
        panelTransactFailed = new TransactFailedView();
        panelTrackingInfo = new TrackingInfoView();
        panelLogin = new LoginView();
        panelSignUp = new SignUpView();
        panelSignOut = new SignOutView();
        panelChangePassword = new ChangePassView();
        panelReportGen = new ReportGenView();
        

        centerPane.add(panelSetupAdmin, SETUP_ADMIN);
        centerPane.add(panelLogin, LOGIN);
        centerPane.add(panelMenu, MENU);
        centerPane.add(panelAddRecipient, ADD_RECIPIENT);
        centerPane.add(panelAddItem, ADD_ITEM);
        centerPane.add(panelChooseParcel, CHOOSE_PARCEL);
        centerPane.add(panelTransactSuccess, TRANSACT_SUCCESS);
        centerPane.add(panelTransactFailed, TRANSACT_FAILED);
        centerPane.add(panelTrackingInfo, TRACKING_INFO);
        centerPane.add(panelSignUp, SIGN_UP);
        centerPane.add(panelSignOut, SIGN_OUT);
        centerPane.add(panelChangePassword, CHANGE_PASSWORD);
        centerPane.add(panelReportGen, GENERATE_REPORT);
                
        add(centerPane, BorderLayout.CENTER);
    }

    public void initStatusBar()
    {
        lblDate = new JLabel();
        lblDate.setForeground(new Color(255,255,255));
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));


        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setSize (500, 30);
        panel.setMaximumSize(new Dimension(500, 30));
        panel.setMinimumSize(new Dimension(500, 30));
        panel.setPreferredSize(new Dimension(500, 30));
        panel.setBackground(new Color(66,66,66));
        panel.add(lblDate);

        add(panel, BorderLayout.SOUTH);
    }

    public void updateStatusBar(String strDate)
    {
        lblDate.setText(strDate);
    }

    public void updateCenterPane (String name)
	{
		CardLayout cards = (CardLayout) centerPane.getLayout ();
		cards.show(centerPane, name);
    }

    public JPanel getPanel(String panelName)
    {
        if (panelName.equals(MENU))
            return panelMenu;
        else if (panelName.equals(ADD_RECIPIENT))
            return panelAddRecipient;
        else if (panelName.equals(ADD_ITEM))
            return panelAddItem;
        else if (panelName.equals(CHOOSE_PARCEL))
            return panelChooseParcel;
        else if (panelName.equals(TRANSACT_FAILED))
            return panelTransactFailed;
        else if (panelName.equals(TRANSACT_SUCCESS))
            return panelTransactSuccess;
        else if (panelName.equals(TRACKING_INFO))
            return panelTrackingInfo;
        else if (panelName.equals(LOGIN))
            return panelLogin;
        else if (panelName.equals(SIGN_UP))
            return panelSignUp;
        else if (panelName.equals(SIGN_OUT))
            return panelSignOut;
        else if (panelName.equals(CHANGE_PASSWORD))
            return panelChangePassword;
        else if (panelName.equals(SETUP_ADMIN))
            return panelSetupAdmin;
        else return panelReportGen;
    }
}