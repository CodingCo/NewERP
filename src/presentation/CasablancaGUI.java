package presentation;

import domain.Apartment;
import domain.Booking;
import domain.Controller;
import domain.Customer;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Robert
 */
public class CasablancaGUI extends javax.swing.JFrame {

    private CardLayout cl;
    private Controller controller;
    private DefaultListModel nBListModel;
    private DefaultListModel eBListModel;
    private DefaultListModel lBlistModel;
    private DefaultListModel cBListModel;
    private int createCounter = 0;
    private int dateCounter = 0;
    private Apartment tempA = null;
    private HashMap<Booking, Customer> bcHM = null;

    private boolean drawTodayFlag = false;
    private boolean drawMonthFlag = false;
    private boolean drawApartmentFlag = false;

    private boolean isFullScreen = false;
    private final GraphicsDevice device;
    private DisplayMode originalDM;
    public static int INDEX_WIDTH = 0;
    public static int INDEX_HEIGHT = 1;

    private DrawToday drawToday;
    private DrawMonth drawMonth;
    private DrawApartment drawApartment;

    /**
     * Creates new form CasablancaGUI
     *
     * @param device
     */
    public CasablancaGUI(GraphicsDevice device) {
        super(device.getDefaultConfiguration());
        this.device = device;
        initComponents();
        originalDM = device.getDisplayMode();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        INDEX_WIDTH = d.width;
        INDEX_HEIGHT = d.height;
        setSize(d.width, d.height);

        this.controller = new Controller();
        this.controller.updateLists();
        this.cl = (CardLayout) (mainPage.getLayout());
        this.cl.addLayoutComponent(frontPagePanel, "FrontPage");
        this.cl.addLayoutComponent(newBookingPanel, "NewBooking");
        this.cl.addLayoutComponent(editBookingPanel, "EditBooking");
        this.cl.addLayoutComponent(listBookingPanel, "ListBooking");
        this.cl.addLayoutComponent(previousCustomerPanel, "PreviousCustomer");
        this.frontPageLogoutButton.setVisible(false);

        this.lBlistModel = new DefaultListModel();
        this.listBookingApartmentjList.setModel(lBlistModel);
        this.nBListModel = new DefaultListModel();
        this.newBookingAvailList.setModel(nBListModel);
        this.eBListModel = new DefaultListModel();
        this.eBMatchList.setModel(eBListModel);
        this.cBListModel = new DefaultListModel();
        this.previousCustomerList.setModel(cBListModel);
        this.bcHM = new HashMap();
        this.drawToday = new DrawToday(this.listBookingDrawingPanel, this.controller.getBookingsToDay());
        this.drawApartment = new DrawApartment(this.listBookingDrawingPanel);
        //pack();
        //setVisible(true);
        setFullScreenSettings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPage = new javax.swing.JPanel();
        frontPagePanel = new javax.swing.JPanel();
        frontPageNewBooking = new javax.swing.JButton();
        frontPageEditBooking = new javax.swing.JButton();
        frontPageExitButton = new javax.swing.JButton();
        frontPageLogoutButton = new javax.swing.JButton();
        listBookingPageButton = new javax.swing.JButton();
        newBookingPanel = new javax.swing.JPanel();
        newBookingFindPanel = new javax.swing.JPanel();
        newBookingFindSearchPanel = new javax.swing.JPanel();
        newBookingFindSearchFromTextField = new javax.swing.JTextField();
        newBookingFindSearchNONTextField = new javax.swing.JTextField();
        newBookingFindSearchTypeComboBox = new javax.swing.JComboBox();
        newBookingFindRoomNRTextField = new javax.swing.JTextField();
        newBookingFindButtonBackButton = new javax.swing.JButton();
        newBookingFindButtonFindButton = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        newBookingAvailablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newBookingAvailList = new javax.swing.JList();
        newBookingAvailTitleTitle = new javax.swing.JLabel();
        newBookingFormPanel = new javax.swing.JPanel();
        newBookingFormFirstTextField = new javax.swing.JTextField();
        newBookingFormNameTextField = new javax.swing.JTextField();
        newBookingFormNOGTextField = new javax.swing.JTextField();
        newBookingFormPhoneTextField = new javax.swing.JTextField();
        newBookingFormNatTextField = new javax.swing.JTextField();
        newBookingFormCityTextField = new javax.swing.JTextField();
        newBookingFormStreetTextField = new javax.swing.JTextField();
        newBookingFormButtonPanel = new javax.swing.JPanel();
        newBookingFormCreateButton = new javax.swing.JButton();
        newBookingFormPreviousButton = new javax.swing.JButton();
        newBookingFormGreyPanel = new javax.swing.JPanel();
        newBookingFormADateLabel = new javax.swing.JLabel();
        newBookingFormNONLabel = new javax.swing.JLabel();
        newBookingFormRoomLabel = new javax.swing.JLabel();
        newBookingFormADateTextField = new javax.swing.JTextField();
        newBookingFormNONTextField = new javax.swing.JTextField();
        newBookingFormRoomTextField = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        newBookingFormAgenTextField = new javax.swing.JTextField();
        newBookingFormEmailTextField = new javax.swing.JTextField();
        newBookingFormZipTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newBookingTitleTitle = new javax.swing.JLabel();
        listBookingPanel = new javax.swing.JPanel();
        menuOptionsjPanel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        listBookingTodayjButton = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        listBookingDatejTextField1 = new javax.swing.JTextField();
        listBookingSearchjButton = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listBookingApartmentjList = new javax.swing.JList();
        listBookingBackButton = new javax.swing.JButton();
        listOptionjPanel = new javax.swing.JPanel();
        listBookingDrawingPanel = new javax.swing.JPanel();
        listBookingDisplayTypejLabel = new javax.swing.JLabel();
        listBookingRefreshjButton = new javax.swing.JButton();
        listBookingLastUpdatedjLabel = new javax.swing.JLabel();
        listBookingUpListButton = new javax.swing.JButton();
        listBookingDownListButton = new javax.swing.JButton();
        listBookingnextListButton = new javax.swing.JButton();
        listBookingPreviousListButton = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        editBookingPanel = new javax.swing.JPanel();
        eBFindPanel = new javax.swing.JPanel();
        eBFindNameTextField = new javax.swing.JTextField();
        eBFindDateTextField = new javax.swing.JTextField();
        eBFindRoomNrTextField = new javax.swing.JTextField();
        eBFindBookingNRTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        eBFindTitleTitleLabel = new javax.swing.JLabel();
        eBFindButtonFindButton = new javax.swing.JButton();
        eBFindButtonBackButton = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        eBMatchPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eBMatchList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        eBMatchButtonEditButton = new javax.swing.JButton();
        eBMAtchButtonDeleteButton = new javax.swing.JButton();
        eBFormPanel = new javax.swing.JPanel();
        eBFormADateTextField = new javax.swing.JTextField();
        eBFormNONTextField = new javax.swing.JTextField();
        eBFormANRTextField = new javax.swing.JTextField();
        eBFormButtonSaveButton = new javax.swing.JButton();
        eBFormButtonCancelButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eBFormFirstTextField = new javax.swing.JTextField();
        eBFormNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        eBFormNOGTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        eBFormPhoneTextField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        eBFormEmailTextField = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        eBFormCityTextField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        eBFormStreetTextField = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        eBFormZipTextField = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        eBFormNatTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        eBTitleTitleLabel = new javax.swing.JLabel();
        previousCustomerPanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        previousCustomerList = new javax.swing.JList();
        previousCustomerSearchField = new javax.swing.JTextField();
        previousCustomerSearchButton = new javax.swing.JButton();
        previousCustomerChooseButton = new javax.swing.JButton();
        previousCustomerCancelbutton = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 22, 1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));

        mainPage.setMaximumSize(new java.awt.Dimension(999999, 999999));
        mainPage.setMinimumSize(new java.awt.Dimension(1024, 720));
        mainPage.setPreferredSize(new java.awt.Dimension(1024, 720));
        mainPage.setLayout(new java.awt.CardLayout());

        frontPagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frontPagePanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        frontPagePanel.setMinimumSize(new java.awt.Dimension(1024, 720));
        frontPagePanel.setPreferredSize(new java.awt.Dimension(1024, 720));

        frontPageNewBooking.setText("New Booking");
        frontPageNewBooking.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frontPageNewBooking.setMaximumSize(new java.awt.Dimension(150, 50));
        frontPageNewBooking.setMinimumSize(new java.awt.Dimension(150, 50));
        frontPageNewBooking.setPreferredSize(new java.awt.Dimension(150, 50));
        frontPageNewBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontPageNewBookingMouseEntered(evt);
            }
        });
        frontPageNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frontPageNewBookingActionPerformed(evt);
            }
        });

        frontPageEditBooking.setText("Edit Booking");
        frontPageEditBooking.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frontPageEditBooking.setMaximumSize(new java.awt.Dimension(150, 50));
        frontPageEditBooking.setMinimumSize(new java.awt.Dimension(150, 50));
        frontPageEditBooking.setPreferredSize(new java.awt.Dimension(150, 50));
        frontPageEditBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontPageEditBookingMouseEntered(evt);
            }
        });
        frontPageEditBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frontPageEditBookingActionPerformed(evt);
            }
        });

        frontPageExitButton.setText("Exit");
        frontPageExitButton.setMaximumSize(new java.awt.Dimension(76, 25));
        frontPageExitButton.setMinimumSize(new java.awt.Dimension(76, 25));
        frontPageExitButton.setPreferredSize(new java.awt.Dimension(76, 25));
        frontPageExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontPageExitButtonMouseEntered(evt);
            }
        });
        frontPageExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frontPageExitButtonActionPerformed(evt);
            }
        });

        frontPageLogoutButton.setText("Logout");
        frontPageLogoutButton.setMaximumSize(new java.awt.Dimension(76, 25));
        frontPageLogoutButton.setMinimumSize(new java.awt.Dimension(76, 25));
        frontPageLogoutButton.setPreferredSize(new java.awt.Dimension(76, 25));
        frontPageLogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontPageLogoutButtonMouseEntered(evt);
            }
        });

        listBookingPageButton.setText("List Booking");
        listBookingPageButton.setToolTipText("go to booking list page");
        listBookingPageButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listBookingPageButton.setMaximumSize(new java.awt.Dimension(150, 50));
        listBookingPageButton.setMinimumSize(new java.awt.Dimension(150, 50));
        listBookingPageButton.setPreferredSize(new java.awt.Dimension(150, 50));
        listBookingPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listBookingPageButtonMouseEntered(evt);
            }
        });
        listBookingPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingPageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frontPagePanelLayout = new javax.swing.GroupLayout(frontPagePanel);
        frontPagePanel.setLayout(frontPagePanelLayout);
        frontPagePanelLayout.setHorizontalGroup(
            frontPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPagePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(frontPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(frontPageExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frontPageLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(frontPagePanelLayout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addGroup(frontPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listBookingPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frontPageEditBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frontPageNewBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        frontPagePanelLayout.setVerticalGroup(
            frontPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontPagePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(frontPageExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(frontPageLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(frontPageNewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(frontPageEditBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listBookingPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        mainPage.add(frontPagePanel, "card2");

        newBookingPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        newBookingPanel.setMinimumSize(new java.awt.Dimension(1024, 720));
        newBookingPanel.setPreferredSize(new java.awt.Dimension(1024, 720));

        newBookingFindPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        newBookingFindPanel.setMaximumSize(new java.awt.Dimension(455, 728));
        newBookingFindPanel.setMinimumSize(new java.awt.Dimension(340, 0));
        newBookingFindPanel.setPreferredSize(new java.awt.Dimension(340, 728));

        newBookingFindSearchPanel.setMaximumSize(new java.awt.Dimension(453, 630));
        newBookingFindSearchPanel.setMinimumSize(new java.awt.Dimension(340, 0));
        newBookingFindSearchPanel.setPreferredSize(new java.awt.Dimension(321, 200));
        newBookingFindSearchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingFindSearchPanelMouseClicked(evt);
            }
        });

        newBookingFindSearchFromTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFindSearchFromTextField.setText("DD-MM-YY");
        newBookingFindSearchFromTextField.setMaximumSize(new java.awt.Dimension(58, 19));
        newBookingFindSearchFromTextField.setMinimumSize(new java.awt.Dimension(58, 19));
        newBookingFindSearchFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingFindSearchFromTextFieldMouseClicked(evt);
            }
        });
        newBookingFindSearchFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFindSearchFromTextFieldActionPerformed(evt);
            }
        });
        newBookingFindSearchFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newBookingFindSearchFromTextFieldKeyTyped(evt);
            }
        });

        newBookingFindSearchNONTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFindSearchNONTextField.setText("1 - many");
        newBookingFindSearchNONTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newBookingFindSearchNONTextFieldFocusGained(evt);
            }
        });
        newBookingFindSearchNONTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingFindSearchNONTextFieldMouseClicked(evt);
            }
        });

        newBookingFindSearchTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double", "Family" }));
        newBookingFindSearchTypeComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingFindSearchTypeComboBoxMouseClicked(evt);
            }
        });

        newBookingFindRoomNRTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFindRoomNRTextField.setText("1 - 104");

        newBookingFindButtonBackButton.setText("Back");
        newBookingFindButtonBackButton.setMaximumSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonBackButton.setMinimumSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonBackButton.setPreferredSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingFindButtonBackButtonMouseEntered(evt);
            }
        });
        newBookingFindButtonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFindButtonBackButtonActionPerformed(evt);
            }
        });

        newBookingFindButtonFindButton.setText("Find");
        newBookingFindButtonFindButton.setMaximumSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonFindButton.setMinimumSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonFindButton.setPreferredSize(new java.awt.Dimension(100, 30));
        newBookingFindButtonFindButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingFindButtonFindButtonMouseEntered(evt);
            }
        });
        newBookingFindButtonFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFindButtonFindButtonActionPerformed(evt);
            }
        });

        jLabel24.setText("Start date");

        jLabel26.setText("Number of nights");

        jLabel41.setText("Apartment type");

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel42.setText("Optional fields");

        jLabel43.setText("Enter apartment no. to find a specific apartment");

        jLabel25.setText("Click to find available apartments");

        javax.swing.GroupLayout newBookingFindSearchPanelLayout = new javax.swing.GroupLayout(newBookingFindSearchPanel);
        newBookingFindSearchPanel.setLayout(newBookingFindSearchPanelLayout);
        newBookingFindSearchPanelLayout.setHorizontalGroup(
            newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newBookingFindSearchFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(newBookingFindRoomNRTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addGap(216, 216, 216))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newBookingFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFindSearchNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFindSearchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newBookingFindSearchPanelLayout.setVerticalGroup(
            newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindSearchFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindSearchNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindSearchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindRoomNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Fill out date and night to find an available ");

        jLabel23.setText("apartment on the specified date. ");

        javax.swing.GroupLayout newBookingFindPanelLayout = new javax.swing.GroupLayout(newBookingFindPanel);
        newBookingFindPanel.setLayout(newBookingFindPanelLayout);
        newBookingFindPanelLayout.setHorizontalGroup(
            newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newBookingFindSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE)
                    .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel23))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newBookingFindPanelLayout.setVerticalGroup(
            newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(54, 54, 54)
                .addComponent(newBookingFindSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );

        newBookingAvailablePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        newBookingAvailablePanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        newBookingAvailablePanel.setMinimumSize(new java.awt.Dimension(320, 0));
        newBookingAvailablePanel.setPreferredSize(new java.awt.Dimension(320, 200));
        newBookingAvailablePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingAvailablePanelMouseEntered(evt);
            }
        });

        newBookingAvailList.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        newBookingAvailList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingAvailListMouseClicked(evt);
            }
        });
        newBookingAvailList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                newBookingAvailListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(newBookingAvailList);

        newBookingAvailTitleTitle.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        newBookingAvailTitleTitle.setText("Available Apartments");

        javax.swing.GroupLayout newBookingAvailablePanelLayout = new javax.swing.GroupLayout(newBookingAvailablePanel);
        newBookingAvailablePanel.setLayout(newBookingAvailablePanelLayout);
        newBookingAvailablePanelLayout.setHorizontalGroup(
            newBookingAvailablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingAvailablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingAvailablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingAvailablePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newBookingAvailTitleTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        newBookingAvailablePanelLayout.setVerticalGroup(
            newBookingAvailablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingAvailablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingAvailTitleTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        newBookingFormPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        newBookingFormPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        newBookingFormPanel.setMinimumSize(new java.awt.Dimension(340, 0));
        newBookingFormPanel.setPreferredSize(new java.awt.Dimension(340, 200));

        newBookingFormFirstTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormFirstTextField.setText("First name");
        newBookingFormFirstTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newBookingFormFirstTextFieldFocusGained(evt);
            }
        });

        newBookingFormNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormNameTextField.setText("Last name");
        newBookingFormNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormNameTextFieldActionPerformed(evt);
            }
        });

        newBookingFormNOGTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormNOGTextField.setText("Visiting residents");

        newBookingFormPhoneTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormPhoneTextField.setText("Phone");

        newBookingFormNatTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormNatTextField.setText("Country");

        newBookingFormCityTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormCityTextField.setText("City");

        newBookingFormStreetTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormStreetTextField.setText("Street address");

        newBookingFormCreateButton.setText("Submit");
        newBookingFormCreateButton.setMaximumSize(new java.awt.Dimension(150, 30));
        newBookingFormCreateButton.setMinimumSize(new java.awt.Dimension(150, 30));
        newBookingFormCreateButton.setPreferredSize(new java.awt.Dimension(150, 30));
        newBookingFormCreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingFormCreateButtonMouseEntered(evt);
            }
        });
        newBookingFormCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormCreateButtonActionPerformed(evt);
            }
        });

        newBookingFormPreviousButton.setText("Previous Customer");
        newBookingFormPreviousButton.setMaximumSize(new java.awt.Dimension(150, 30));
        newBookingFormPreviousButton.setMinimumSize(new java.awt.Dimension(150, 30));
        newBookingFormPreviousButton.setPreferredSize(new java.awt.Dimension(150, 30));
        newBookingFormPreviousButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingFormPreviousButtonMouseEntered(evt);
            }
        });
        newBookingFormPreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormPreviousButtonActionPerformed(evt);
            }
        });

        newBookingFormADateLabel.setText("Arrival Date:");

        newBookingFormNONLabel.setText("Number of Nights:");

        newBookingFormRoomLabel.setText("Room:");

        newBookingFormADateTextField.setEditable(false);
        newBookingFormADateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormADateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormADateTextFieldActionPerformed(evt);
            }
        });

        newBookingFormNONTextField.setEditable(false);
        newBookingFormNONTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormNONTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormNONTextFieldActionPerformed(evt);
            }
        });

        newBookingFormRoomTextField.setEditable(false);
        newBookingFormRoomTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout newBookingFormGreyPanelLayout = new javax.swing.GroupLayout(newBookingFormGreyPanel);
        newBookingFormGreyPanel.setLayout(newBookingFormGreyPanelLayout);
        newBookingFormGreyPanelLayout.setHorizontalGroup(
            newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel31))
                    .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormNONLabel)
                            .addComponent(newBookingFormRoomLabel)
                            .addComponent(newBookingFormADateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormADateTextField)
                            .addComponent(newBookingFormNONTextField)
                            .addComponent(newBookingFormRoomTextField))))
                .addContainerGap())
        );
        newBookingFormGreyPanelLayout.setVerticalGroup(
            newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormADateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormNONLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormRoomLabel)
                    .addComponent(newBookingFormRoomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31))
        );

        javax.swing.GroupLayout newBookingFormButtonPanelLayout = new javax.swing.GroupLayout(newBookingFormButtonPanel);
        newBookingFormButtonPanel.setLayout(newBookingFormButtonPanelLayout);
        newBookingFormButtonPanelLayout.setHorizontalGroup(
            newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        newBookingFormButtonPanelLayout.setVerticalGroup(
            newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newBookingFormAgenTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormAgenTextField.setText("Travel agency");

        newBookingFormEmailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormEmailTextField.setText("email");

        newBookingFormZipTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormZipTextField.setText("postal / zip code");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel1.setText("Optional fields");

        jLabel39.setText("To book an apartment. Complete and submit this ");

        jLabel40.setText("booking registration form");

        jLabel32.setText("Enter number of residents");

        javax.swing.GroupLayout newBookingFormPanelLayout = new javax.swing.GroupLayout(newBookingFormPanel);
        newBookingFormPanel.setLayout(newBookingFormPanelLayout);
        newBookingFormPanelLayout.setHorizontalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormNOGTextField)
                        .addContainerGap())
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newBookingFormNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormNatTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormCityTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormEmailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormPhoneTextField))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormAgenTextField)
                        .addContainerGap())
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel32))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))))
        );
        newBookingFormPanelLayout.setVerticalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormNatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newBookingFormAgenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        newBookingTitleTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        newBookingTitleTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newBookingTitleTitle.setText("New Booking");

        javax.swing.GroupLayout newBookingPanelLayout = new javax.swing.GroupLayout(newBookingPanel);
        newBookingPanel.setLayout(newBookingPanelLayout);
        newBookingPanelLayout.setHorizontalGroup(
            newBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFindPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newBookingAvailablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 314, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newBookingFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newBookingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newBookingTitleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newBookingPanelLayout.setVerticalGroup(
            newBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(newBookingTitleTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newBookingFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(newBookingFindPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(newBookingAvailablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPage.add(newBookingPanel, "card3");

        listBookingPanel.setMinimumSize(new java.awt.Dimension(1024, 720));

        menuOptionsjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuOptionsjPanel.setMaximumSize(new java.awt.Dimension(200, 32767));
        menuOptionsjPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        menuOptionsjPanel.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel34.setText("Show Bookings Today");

        listBookingTodayjButton.setText("Show");
        listBookingTodayjButton.setMaximumSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.setMinimumSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.setPreferredSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingTodayjButtonActionPerformed(evt);
            }
        });

        jLabel35.setText("Search Bookings by month");

        listBookingDatejTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        listBookingDatejTextField1.setText("10-04-14");
        listBookingDatejTextField1.setMinimumSize(new java.awt.Dimension(120, 30));
        listBookingDatejTextField1.setPreferredSize(new java.awt.Dimension(120, 30));
        listBookingDatejTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listBookingDatejTextField1FocusGained(evt);
            }
        });
        listBookingDatejTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingDatejTextField1ActionPerformed(evt);
            }
        });
        listBookingDatejTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                listBookingDatejTextField1KeyTyped(evt);
            }
        });

        listBookingSearchjButton.setText("Search");
        listBookingSearchjButton.setMaximumSize(new java.awt.Dimension(120, 30));
        listBookingSearchjButton.setMinimumSize(new java.awt.Dimension(120, 30));
        listBookingSearchjButton.setPreferredSize(new java.awt.Dimension(120, 30));
        listBookingSearchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingSearchjButtonActionPerformed(evt);
            }
        });

        jLabel33.setText("Apartment List");

        listBookingApartmentjList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBookingApartmentjListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listBookingApartmentjList);

        listBookingBackButton.setText("Back");
        listBookingBackButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingBackButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingBackButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuOptionsjPanelLayout = new javax.swing.GroupLayout(menuOptionsjPanel);
        menuOptionsjPanel.setLayout(menuOptionsjPanelLayout);
        menuOptionsjPanelLayout.setHorizontalGroup(
            menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                        .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel33))
                            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel34)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listBookingTodayjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listBookingDatejTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                                .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listBookingBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listBookingSearchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel35)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        menuOptionsjPanelLayout.setVerticalGroup(
            menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBookingTodayjButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBookingDatejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBookingSearchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBookingBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        listOptionjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listBookingDrawingPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout listBookingDrawingPanelLayout = new javax.swing.GroupLayout(listBookingDrawingPanel);
        listBookingDrawingPanel.setLayout(listBookingDrawingPanelLayout);
        listBookingDrawingPanelLayout.setHorizontalGroup(
            listBookingDrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        listBookingDrawingPanelLayout.setVerticalGroup(
            listBookingDrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        listBookingDisplayTypejLabel.setText("Display");
        listBookingDisplayTypejLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listBookingRefreshjButton.setText("Refresh");
        listBookingRefreshjButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingRefreshjButtonActionPerformed(evt);
            }
        });

        listBookingLastUpdatedjLabel.setText(" ");

        listBookingUpListButton.setText("Up");
        listBookingUpListButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingUpListButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingUpListButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingUpListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingUpListButtonActionPerformed(evt);
            }
        });

        listBookingDownListButton.setText("Down");
        listBookingDownListButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingDownListButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingDownListButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingDownListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingDownListButtonActionPerformed(evt);
            }
        });

        listBookingnextListButton.setText("Next");

        listBookingPreviousListButton.setText("Previous");

        javax.swing.GroupLayout listOptionjPanelLayout = new javax.swing.GroupLayout(listOptionjPanel);
        listOptionjPanel.setLayout(listOptionjPanelLayout);
        listOptionjPanelLayout.setHorizontalGroup(
            listOptionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listOptionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listOptionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listBookingDrawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(listOptionjPanelLayout.createSequentialGroup()
                        .addComponent(listBookingRefreshjButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listBookingDisplayTypejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listBookingLastUpdatedjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(listOptionjPanelLayout.createSequentialGroup()
                        .addComponent(listBookingUpListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listBookingDownListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listBookingPreviousListButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listBookingnextListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        listOptionjPanelLayout.setVerticalGroup(
            listOptionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listOptionjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listOptionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBookingRefreshjButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listBookingLastUpdatedjLabel)
                    .addComponent(listBookingDisplayTypejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listBookingDrawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(listOptionjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBookingUpListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listBookingDownListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listBookingnextListButton)
                    .addComponent(listBookingPreviousListButton))
                .addContainerGap())
        );

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel36.setText("Booking List");

        javax.swing.GroupLayout listBookingPanelLayout = new javax.swing.GroupLayout(listBookingPanel);
        listBookingPanel.setLayout(listBookingPanelLayout);
        listBookingPanelLayout.setHorizontalGroup(
            listBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listBookingPanelLayout.createSequentialGroup()
                        .addComponent(menuOptionsjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listOptionjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listBookingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listBookingPanelLayout.setVerticalGroup(
            listBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(16, 16, 16)
                .addGroup(listBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(listOptionjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuOptionsjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPage.add(listBookingPanel, "card5");

        editBookingPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        editBookingPanel.setMinimumSize(new java.awt.Dimension(1024, 720));
        editBookingPanel.setPreferredSize(new java.awt.Dimension(1024, 720));

        eBFindPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        eBFindPanel.setMaximumSize(new java.awt.Dimension(380, 720));
        eBFindPanel.setMinimumSize(new java.awt.Dimension(380, 200));
        eBFindPanel.setPreferredSize(new java.awt.Dimension(340, 200));

        eBFindDateTextField.setText("DD-MM-YY");

        jLabel27.setText("Find booking by entering a search criteria. All  ");

        eBFindTitleTitleLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        eBFindTitleTitleLabel.setText("Find Booking");

        eBFindButtonFindButton.setText("Find");
        eBFindButtonFindButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBFindButtonFindButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBFindButtonFindButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBFindButtonFindButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBFindButtonFindButtonMouseEntered(evt);
            }
        });
        eBFindButtonFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFindButtonFindButtonActionPerformed(evt);
            }
        });

        eBFindButtonBackButton.setText("Back");
        eBFindButtonBackButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBFindButtonBackButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBFindButtonBackButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBFindButtonBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBFindButtonBackButtonMouseEntered(evt);
            }
        });
        eBFindButtonBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFindButtonBackButtonActionPerformed(evt);
            }
        });

        jLabel44.setText("fields are optional. Make your changes in the");

        jLabel6.setText("Booking number");

        jLabel18.setText("Customer name");

        jLabel7.setText("Booking start date");

        jLabel28.setText("Apartment number");

        jLabel8.setText("Click to find your booking");

        jLabel5.setText("booking form on the right.");

        javax.swing.GroupLayout eBFindPanelLayout = new javax.swing.GroupLayout(eBFindPanel);
        eBFindPanel.setLayout(eBFindPanelLayout);
        eBFindPanelLayout.setHorizontalGroup(
            eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFindPanelLayout.createSequentialGroup()
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eBFindPanelLayout.createSequentialGroup()
                        .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eBFindPanelLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(eBFindTitleTitleLabel))
                            .addGroup(eBFindPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(eBFindPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFindNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFindDateTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFindRoomNrTextField)
                            .addComponent(eBFindBookingNRTextField)
                            .addGroup(eBFindPanelLayout.createSequentialGroup()
                                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel28)
                                    .addComponent(eBFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eBFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(eBFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eBFindPanelLayout.setVerticalGroup(
            eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eBFindTitleTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindBookingNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindRoomNrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        eBMatchPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        eBMatchPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        eBMatchPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        eBMatchPanel.setPreferredSize(new java.awt.Dimension(200, 200));

        eBMatchList.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        eBMatchList.setName(""); // NOI18N
        eBMatchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eBMatchListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eBMatchList);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Matching Bookings");

        eBMatchButtonEditButton.setText("Edit");
        eBMatchButtonEditButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBMatchButtonEditButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBMatchButtonEditButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBMatchButtonEditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBMatchButtonEditButtonMouseEntered(evt);
            }
        });
        eBMatchButtonEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBMatchButtonEditButtonActionPerformed(evt);
            }
        });

        eBMAtchButtonDeleteButton.setText("Delete");
        eBMAtchButtonDeleteButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBMAtchButtonDeleteButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBMAtchButtonDeleteButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBMAtchButtonDeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBMAtchButtonDeleteButtonMouseEntered(evt);
            }
        });
        eBMAtchButtonDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBMAtchButtonDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eBMatchPanelLayout = new javax.swing.GroupLayout(eBMatchPanel);
        eBMatchPanel.setLayout(eBMatchPanelLayout);
        eBMatchPanelLayout.setHorizontalGroup(
            eBMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBMatchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(eBMatchPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(eBMatchButtonEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(eBMAtchButtonDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(eBMatchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        eBMatchPanelLayout.setVerticalGroup(
            eBMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBMatchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addGroup(eBMatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBMatchButtonEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBMAtchButtonDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        eBFormPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        eBFormPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        eBFormPanel.setMinimumSize(new java.awt.Dimension(340, 600));
        eBFormPanel.setPreferredSize(new java.awt.Dimension(340, 600));
        eBFormPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eBFormPanelMouseClicked(evt);
            }
        });

        eBFormButtonSaveButton.setText("Save");
        eBFormButtonSaveButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBFormButtonSaveButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBFormButtonSaveButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBFormButtonSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBFormButtonSaveButtonMouseEntered(evt);
            }
        });
        eBFormButtonSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFormButtonSaveButtonActionPerformed(evt);
            }
        });

        eBFormButtonCancelButton.setText("Cancel");
        eBFormButtonCancelButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBFormButtonCancelButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBFormButtonCancelButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBFormButtonCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBFormButtonCancelButtonMouseEntered(evt);
            }
        });
        eBFormButtonCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFormButtonCancelButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Arrival date");

        jLabel29.setText("Number of nights");

        jLabel46.setText("Apartment number");

        jLabel3.setText("First name");

        jLabel10.setText("Last name");

        jLabel11.setText("Number of guests");

        jLabel12.setText("Phone");

        jLabel47.setText("Email");

        eBFormEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFormEmailTextFieldActionPerformed(evt);
            }
        });

        jLabel48.setText("City");

        jLabel49.setText("Street address");

        jLabel50.setText("postal / zip code");

        jLabel51.setText("Country");

        javax.swing.GroupLayout eBFormPanelLayout = new javax.swing.GroupLayout(eBFormPanel);
        eBFormPanel.setLayout(eBFormPanelLayout);
        eBFormPanelLayout.setHorizontalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eBFormADateTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eBFormNONTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormFirstTextField)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 70, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(eBFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(eBFormNOGTextField)
                    .addComponent(eBFormPhoneTextField)
                    .addComponent(eBFormEmailTextField)
                    .addComponent(eBFormStreetTextField)
                    .addComponent(eBFormCityTextField)
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(eBFormNatTextField)))
                    .addComponent(jSeparator2)
                    .addComponent(eBFormANRTextField)
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel29)
                            .addComponent(jLabel46)
                            .addComponent(eBFormButtonCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eBFormPanelLayout.setVerticalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormANRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBFormNatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormButtonCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        eBTitleTitleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        eBTitleTitleLabel.setText("Edit Booking");

        javax.swing.GroupLayout editBookingPanelLayout = new javax.swing.GroupLayout(editBookingPanel);
        editBookingPanel.setLayout(editBookingPanelLayout);
        editBookingPanelLayout.setHorizontalGroup(
            editBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editBookingPanelLayout.createSequentialGroup()
                        .addComponent(eBFindPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eBMatchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eBFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editBookingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(eBTitleTitleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        editBookingPanelLayout.setVerticalGroup(
            editBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editBookingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eBTitleTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eBFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(eBMatchPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(eBFindPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPage.add(editBookingPanel, "card4");

        previousCustomerPanel.setMinimumSize(new java.awt.Dimension(1024, 720));

        jLabel37.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel37.setText("Find Previous Customer");

        jScrollPane4.setViewportView(previousCustomerList);

        previousCustomerSearchButton.setText("Search");
        previousCustomerSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousCustomerSearchButtonActionPerformed(evt);
            }
        });

        previousCustomerChooseButton.setText("Choose");
        previousCustomerChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousCustomerChooseButtonActionPerformed(evt);
            }
        });

        previousCustomerCancelbutton.setText("Cancel");
        previousCustomerCancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousCustomerCancelbuttonActionPerformed(evt);
            }
        });

        jLabel38.setText("Enter search criteria and choose your customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(previousCustomerChooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(previousCustomerCancelbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(previousCustomerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(previousCustomerSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousCustomerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousCustomerSearchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousCustomerChooseButton)
                    .addComponent(previousCustomerCancelbutton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout previousCustomerPanelLayout = new javax.swing.GroupLayout(previousCustomerPanel);
        previousCustomerPanel.setLayout(previousCustomerPanelLayout);
        previousCustomerPanelLayout.setHorizontalGroup(
            previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousCustomerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        previousCustomerPanelLayout.setVerticalGroup(
            previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(72, 72, 72)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        mainPage.add(previousCustomerPanel, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eBFindButtonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFindButtonBackButtonActionPerformed
        cl.show(mainPage, "FrontPage");
        this.clearEditBookingsFields();
    }//GEN-LAST:event_eBFindButtonBackButtonActionPerformed
    private void eBMatchButtonEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBMatchButtonEditButtonActionPerformed
        this.enableComponents(this.eBFormPanel, true);

        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        Customer c = this.bcHM.get(b);
        setUpTextFields(b, c);

    }//GEN-LAST:event_eBMatchButtonEditButtonActionPerformed
    private void eBFindButtonFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFindButtonFindButtonActionPerformed
        bcHM.clear();

        int bNr = 0;
        int roomNr = 0;

        try {
            bNr = Integer.parseInt(this.eBFindBookingNRTextField.getText());
        } catch (NumberFormatException ex) {
        }
        try {
            roomNr = Integer.parseInt(this.eBFindRoomNrTextField.getText());
        } catch (NumberFormatException ex) {

        }

        String name = this.eBFindNameTextField.getText();
        String date = this.eBFindDateTextField.getText();

        bcHM = controller.findBookings(bNr, name, date, roomNr);

        this.eBListModel.clear();

        if (bcHM == null) {
            JOptionPane.showMessageDialog(this, "No Booking Found", "", WIDTH);
        } else {

            for (Booking b : bcHM.keySet()) {

                this.eBListModel.addElement(b);

            }
            this.enableComponents(this.eBMatchPanel, true);
        }
    }//GEN-LAST:event_eBFindButtonFindButtonActionPerformed
    private void eBFormButtonSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFormButtonSaveButtonActionPerformed

        Booking b = (Booking) eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        boolean status = controller.updateBooking(b, Integer.parseInt(this.eBFormANRTextField.getText()), this.eBFormADateTextField.getText(), Integer.parseInt(this.eBFormNONTextField.getText()), b.getPrice(), bcHM.get(b), this.eBFormFirstTextField.getText(), this.eBFormNameTextField.getText(), this.eBFormPhoneTextField.getText(), this.eBFormEmailTextField.getText(), this.eBFormNatTextField.getText(), this.eBFormCityTextField.getText(), this.eBFormZipTextField.getText(), this.eBFormStreetTextField.getText());
        if (status) {
            this.clearEditBookingsFields();
            JOptionPane.showMessageDialog(this, "Booking Updated", "", WIDTH);
            clearEditBookingsFields();
            this.eBListModel.clear();
            this.enableComponents(this.eBMatchPanel, false);
            this.enableComponents(this.eBFormPanel, false);
        } else {
            JOptionPane.showMessageDialog(this, "Booking Not Updated", "", WIDTH);
        }

    }//GEN-LAST:event_eBFormButtonSaveButtonActionPerformed
    private void eBMatchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBMatchListMouseClicked
        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        //setUpTextFields(b);
    }//GEN-LAST:event_eBMatchListMouseClicked
    private void eBMAtchButtonDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBMAtchButtonDeleteButtonActionPerformed

        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        boolean status = controller.deleteBooking(b.getB_id());
        if (status) {
            JOptionPane.showMessageDialog(this, "Booking Deleted", "", WIDTH);
        } else {
            JOptionPane.showMessageDialog(this, "Booking Not Deleted", "", WIDTH);
        }

        this.clearEditBookingsFields();

    }//GEN-LAST:event_eBMAtchButtonDeleteButtonActionPerformed
    private void eBFormPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFormPanelMouseClicked
        this.enableComponents(this.eBFormPanel, false);
    }//GEN-LAST:event_eBFormPanelMouseClicked
    private void eBFormButtonCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFormButtonCancelButtonActionPerformed
        this.clearEditBookingsFields();
        this.enableComponents(this.eBFormPanel, false);
        this.enableComponents(this.eBMatchPanel, false);
    }//GEN-LAST:event_eBFormButtonCancelButtonActionPerformed
    private void eBFindButtonBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFindButtonBackButtonMouseEntered
        this.eBFindButtonBackButton.setToolTipText("Press to go to Front Page");
    }//GEN-LAST:event_eBFindButtonBackButtonMouseEntered
    private void eBFindButtonFindButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFindButtonFindButtonMouseEntered
        this.eBFindButtonFindButton.setToolTipText("Press to Search for Bookings");
    }//GEN-LAST:event_eBFindButtonFindButtonMouseEntered
    private void eBMatchButtonEditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBMatchButtonEditButtonMouseEntered
        this.eBMatchButtonEditButton.setToolTipText("Press to Edit Booking");
    }//GEN-LAST:event_eBMatchButtonEditButtonMouseEntered
    private void eBMAtchButtonDeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBMAtchButtonDeleteButtonMouseEntered
        this.eBMAtchButtonDeleteButton.setToolTipText("Press to Delete Selected Booking");
    }//GEN-LAST:event_eBMAtchButtonDeleteButtonMouseEntered
    private void eBFormButtonSaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFormButtonSaveButtonMouseEntered
        this.eBFormButtonSaveButton.setToolTipText("Press to Save Changes");
    }//GEN-LAST:event_eBFormButtonSaveButtonMouseEntered
    private void eBFormButtonCancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFormButtonCancelButtonMouseEntered
        this.eBFormButtonCancelButton.setToolTipText("Press to Cancel Changes");
    }//GEN-LAST:event_eBFormButtonCancelButtonMouseEntered
    private void frontPageLogoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontPageLogoutButtonMouseEntered
        this.frontPageLogoutButton.setToolTipText("Press to Logout");
    }//GEN-LAST:event_frontPageLogoutButtonMouseEntered
    private void frontPageExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frontPageExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_frontPageExitButtonActionPerformed
    private void frontPageExitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontPageExitButtonMouseEntered
        this.frontPageExitButton.setToolTipText("Press to Exit System");
    }//GEN-LAST:event_frontPageExitButtonMouseEntered
    private void frontPageEditBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frontPageEditBookingActionPerformed
        cl.show(mainPage, "EditBooking");
        this.enableComponents(this.eBMatchPanel, false);
        this.enableComponents(this.eBFormPanel, false);
    }//GEN-LAST:event_frontPageEditBookingActionPerformed
    private void frontPageEditBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontPageEditBookingMouseEntered
        this.frontPageEditBooking.setToolTipText("Press to go to Edit Booking Page");
    }//GEN-LAST:event_frontPageEditBookingMouseEntered
    private void frontPageNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frontPageNewBookingActionPerformed
        cl.show(mainPage, "NewBooking");
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_frontPageNewBookingActionPerformed
    private void frontPageNewBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontPageNewBookingMouseEntered
        this.frontPageNewBooking.setToolTipText("Press to go to New Booking Page");
    }//GEN-LAST:event_frontPageNewBookingMouseEntered
    private void newBookingFormNONTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormNONTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBookingFormNONTextFieldActionPerformed
    private void newBookingFormADateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormADateTextFieldActionPerformed
        //not supported
    }//GEN-LAST:event_newBookingFormADateTextFieldActionPerformed
    private void newBookingFormPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormPreviousButtonActionPerformed
        // TODO add your handling code here:

        cl.show(mainPage, "PreviousCustomer");
    }//GEN-LAST:event_newBookingFormPreviousButtonActionPerformed
    private void newBookingFormPreviousButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFormPreviousButtonMouseEntered
        this.newBookingFormPreviousButton.setToolTipText("Press to load Previous Customer");
    }//GEN-LAST:event_newBookingFormPreviousButtonMouseEntered
    private void newBookingFormCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormCreateButtonActionPerformed

        try {
            Customer c = this.controller.newCustomer(this.newBookingFormFirstTextField.getText(), this.newBookingFormNameTextField.getText(), this.newBookingFormPhoneTextField.getText(), this.newBookingFormEmailTextField.getText(), this.newBookingFormNatTextField.getText(), this.newBookingFormCityTextField.getText(), this.newBookingFormZipTextField.getText(), this.newBookingFormStreetTextField.getText());
            Apartment a = (Apartment) nBListModel.getElementAt(this.newBookingAvailList.getSelectedIndex());
            boolean success = this.controller.newBooking(c, a.getA_num(), this.newBookingFormADateTextField.getText(), Integer.parseInt(this.newBookingFormNONTextField.getText()), this.newBookingFormAgenTextField.getText(), Integer.parseInt(this.newBookingFormNOGTextField.getText()), Integer.parseInt(this.newBookingFormNONTextField.getText()) * a.getPrice(), c.getFirst_name(), c.getLast_name(), c.getPhone());
            if (success) {
                //this.createCounter++;
                this.enableComponents(this, false);
                JOptionPane.showMessageDialog(this, "Booking created", "", WIDTH);
                this.enableComponents(this, true);
                this.enableComponents(this.newBookingFormPanel, false);
                this.enableComponents(this.newBookingFormButtonPanel, true);
                this.enableComponents(this.newBookingFormGreyPanel, false);
                this.enableComponents(this.newBookingAvailablePanel, false);
                this.clearNewBookingFields();
            }
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Wrong input type", "", WIDTH);
        }
    }//GEN-LAST:event_newBookingFormCreateButtonActionPerformed
    private void newBookingFormCreateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFormCreateButtonMouseEntered
        this.newBookingFormCreateButton.setToolTipText("Press to Create Booking");
    }//GEN-LAST:event_newBookingFormCreateButtonMouseEntered
    private void newBookingAvailablePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingAvailablePanelMouseEntered
        this.newBookingAvailablePanel.setToolTipText("Select Apartment");
    }//GEN-LAST:event_newBookingAvailablePanelMouseEntered
    private void newBookingAvailListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_newBookingAvailListValueChanged

    }//GEN-LAST:event_newBookingAvailListValueChanged
    private void newBookingAvailListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingAvailListMouseClicked

        this.newBookingFormADateTextField.setText(this.newBookingFindSearchFromTextField.getText());
        this.newBookingFormNONTextField.setText(this.newBookingFindSearchNONTextField.getText());
        Apartment a = (Apartment) nBListModel.getElementAt(this.newBookingAvailList.getSelectedIndex());

        this.newBookingFormRoomTextField.setText("" + a.getA_num());
        this.enableComponents(this.newBookingFormPanel, true);
        this.enableComponents(this.newBookingFormGreyPanel, false);
    }//GEN-LAST:event_newBookingAvailListMouseClicked
    private void newBookingFindSearchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchPanelMouseClicked

    }//GEN-LAST:event_newBookingFindSearchPanelMouseClicked
    private void newBookingFindButtonFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFindButtonFindButtonActionPerformed
        setFocusListener(this.newBookingFormPanel);

        this.nBListModel.clear();
        int roomNr = 0;
        try {
            roomNr = Integer.parseInt(this.newBookingFindRoomNRTextField.getText().trim());
        } catch (NumberFormatException e) {

        }
        ArrayList<Apartment> a = controller.findAvailableApartment(this.newBookingFindSearchFromTextField.getText(), Integer.parseInt(this.newBookingFindSearchNONTextField.getText()), this.newBookingFindSearchTypeComboBox.getSelectedItem().toString(), roomNr);

        if (a == null) {
            this.enableComponents(this, false);
            JOptionPane.showMessageDialog(this, "No available apartment", "", WIDTH);
            this.enableComponents(this, true);
            this.enableComponents(this.newBookingFormPanel, false);
            this.enableComponents(this.newBookingAvailablePanel, false);

        } else {
            for (int x = 0; x < a.size(); ++x) {
                this.nBListModel.addElement(a.get(x));
                this.enableComponents(this.newBookingAvailablePanel, true);
            }
        }

    }//GEN-LAST:event_newBookingFindButtonFindButtonActionPerformed
    private void newBookingFindButtonFindButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindButtonFindButtonMouseEntered
        this.newBookingFindButtonFindButton.setToolTipText("Press to search for available apartment");
    }//GEN-LAST:event_newBookingFindButtonFindButtonMouseEntered
    private void newBookingFindButtonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFindButtonBackButtonActionPerformed

        if (this.createCounter == 0) {
            cl.show(mainPage, "FrontPage");
            this.clearNewBookingFields();
            this.newBookingFindSearchFromTextField.setText("DD-MM-YY");

        } else {
            JOptionPane.showMessageDialog(this, "Save All Please", "", WIDTH);
        }
    }//GEN-LAST:event_newBookingFindButtonBackButtonActionPerformed
    private void newBookingFindButtonBackButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindButtonBackButtonMouseEntered
        this.newBookingFindButtonBackButton.setToolTipText("Press to go to Front Page");
    }//GEN-LAST:event_newBookingFindButtonBackButtonMouseEntered
    private void newBookingFindSearchTypeComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchTypeComboBoxMouseClicked
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_newBookingFindSearchTypeComboBoxMouseClicked
    private void newBookingFindSearchNONTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchNONTextFieldMouseClicked
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_newBookingFindSearchNONTextFieldMouseClicked
    private void newBookingFindSearchFromTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newBookingFindSearchFromTextFieldKeyTyped
        JTextField selectedTextField = this.newBookingFindSearchFromTextField; //== EDIT THIS
        String candidates = "1234567890";
        boolean hit = candidates.indexOf(evt.getKeyChar()) >= 0;
        if (hit) {
            int textLength = selectedTextField.getText().length();
            //== Controls "bindestreg"
            if (textLength == 2 || (textLength % 2 == 1 && textLength > 1) && textLength < 7) {
                selectedTextField.setText(selectedTextField.getText() + "-");
            }
            //== Controls maxlength
            if (textLength > 7) {
                char[] firstChars = selectedTextField.getText().toCharArray();
                selectedTextField.setText("");
                for (int i = 0; i < 7; i++) {
                    selectedTextField.setText(selectedTextField.getText() + firstChars[i]);
                }
            }
        }
    }//GEN-LAST:event_newBookingFindSearchFromTextFieldKeyTyped
    private void newBookingFindSearchFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFindSearchFromTextFieldActionPerformed
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_newBookingFindSearchFromTextFieldActionPerformed
    private void newBookingFindSearchFromTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchFromTextFieldMouseClicked
        this.newBookingFindSearchFromTextField.setText("");
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_newBookingFindSearchFromTextFieldMouseClicked
    private void listBookingPageButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBookingPageButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listBookingPageButtonMouseEntered
    private void listBookingPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingPageButtonActionPerformed
        cl.show(mainPage, "ListBooking");
    }//GEN-LAST:event_listBookingPageButtonActionPerformed
    private void listBookingRefreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingRefreshjButtonActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(Calendar.getInstance().getTime());
        String timeStamp = sdf.format(calendar.getTime());

        this.listBookingLastUpdatedjLabel.setText("Updated: " + timeStamp);
        this.controller.updateLists();
        this.lBlistModel.clear();
        ArrayList<Apartment> list = this.controller.getApartments();
        for (Apartment a : list) {
            this.lBlistModel.addElement(a);
        }

    }//GEN-LAST:event_listBookingRefreshjButtonActionPerformed
    private void listBookingUpListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingUpListButtonActionPerformed

        if (this.drawTodayFlag) {
            this.listBookingDrawingPanel.removeAll();
            this.listBookingDrawingPanel.add(this.drawToday);
            this.listBookingDrawingPanel.repaint();
            this.drawToday.previous();
        }
        if (this.drawMonthFlag) {
            this.listBookingDrawingPanel.removeAll();
            this.listBookingDrawingPanel.add(this.drawMonth);
            this.listBookingDrawingPanel.repaint();
            this.drawMonth.previous();
        }


    }//GEN-LAST:event_listBookingUpListButtonActionPerformed
    private void listBookingDownListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingDownListButtonActionPerformed

        if (this.drawTodayFlag) {
            this.listBookingDrawingPanel.removeAll();
            this.listBookingDrawingPanel.add(this.drawToday);
            this.listBookingDrawingPanel.repaint();
            this.drawToday.next();
        }
        if (this.drawMonthFlag) {
            this.listBookingDrawingPanel.removeAll();
            this.listBookingDrawingPanel.add(this.drawMonth);
            //this.listBookingDrawingPanel.repaint();
            this.drawMonth.next();
        }

    }//GEN-LAST:event_listBookingDownListButtonActionPerformed
    private void listBookingTodayjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingTodayjButtonActionPerformed
        this.drawMonth = new DrawMonth(jPanel2);

        this.drawTodayFlag = true;
        this.drawApartmentFlag = false;
        this.drawMonthFlag = false;
        this.listBookingDisplayTypejLabel.setText("Bookings for today");
        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawToday);
        this.listBookingDrawingPanel.repaint();
        this.drawToday.reset();
    }//GEN-LAST:event_listBookingTodayjButtonActionPerformed
    private void listBookingSearchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingSearchjButtonActionPerformed
        this.drawMonth = new DrawMonth(this.listBookingDrawingPanel);
        this.drawTodayFlag = false;
        this.drawApartmentFlag = false;
        this.drawMonthFlag = true;
        this.listBookingDrawingPanel.removeAll();
        this.drawMonth.initializeListAndMonth(this.controller.getBookingsBySpecificMonth(this.listBookingDatejTextField1.getText()), this.listBookingDatejTextField1.getText());
        this.listBookingDrawingPanel.add(this.drawMonth);
        this.listBookingDrawingPanel.repaint();
        this.drawMonth.reset();
    }//GEN-LAST:event_listBookingSearchjButtonActionPerformed
    private void listBookingBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingBackButtonActionPerformed
        this.cl.show(mainPage, "FrontPage");
        this.listBookingDrawingPanel.removeAll();
    }//GEN-LAST:event_listBookingBackButtonActionPerformed
    private void listBookingApartmentjListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBookingApartmentjListMouseClicked

        Apartment a = (Apartment) this.lBlistModel.getElementAt(this.listBookingApartmentjList.getSelectedIndex());

        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawApartment);
        this.listBookingDrawingPanel.repaint();
        this.drawApartment.setVisible(true);
    }//GEN-LAST:event_listBookingApartmentjListMouseClicked
    private void previousCustomerSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCustomerSearchButtonActionPerformed
        this.cBListModel.clear();
        ArrayList<Customer> clist = this.controller.searchForCustomers(this.previousCustomerSearchField.getText().toLowerCase());
        for (Customer c : clist) {
            this.cBListModel.addElement(c);
        }
    }//GEN-LAST:event_previousCustomerSearchButtonActionPerformed
    private void previousCustomerChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCustomerChooseButtonActionPerformed
        Customer c = (Customer) this.cBListModel.getElementAt(this.previousCustomerList.getSelectedIndex());
        setNewBookingCustomer(c);
        cl.show(mainPage, "NewBooking");
        this.cBListModel.clear();
        this.previousCustomerSearchField.setText("");
    }//GEN-LAST:event_previousCustomerChooseButtonActionPerformed
    private void previousCustomerCancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCustomerCancelbuttonActionPerformed
        cl.show(mainPage, "NewBooking");
        this.cBListModel.clear();
        this.previousCustomerSearchField.setText("");
    }//GEN-LAST:event_previousCustomerCancelbuttonActionPerformed
    private void listBookingDatejTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingDatejTextField1ActionPerformed

    }//GEN-LAST:event_listBookingDatejTextField1ActionPerformed
    private void listBookingDatejTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listBookingDatejTextField1KeyTyped
        JTextField selectedTextField = this.listBookingDatejTextField1; //== EDIT THIS
        String candidates = "1234567890";
        boolean hit = candidates.indexOf(evt.getKeyChar()) >= 0;
        if (hit) {
            int textLength = selectedTextField.getText().length();
            //== Controls "bindestreg"
            if (textLength == 2 || (textLength % 2 == 1 && textLength > 1) && textLength < 7) {
                selectedTextField.setText(selectedTextField.getText() + "-");
            }
            //== Controls maxlength
            if (textLength > 7) {
                char[] firstChars = selectedTextField.getText().toCharArray();
                selectedTextField.setText("");
                for (int i = 0; i < 7; i++) {
                    selectedTextField.setText(selectedTextField.getText() + firstChars[i]);
                }
            }
        }
    }//GEN-LAST:event_listBookingDatejTextField1KeyTyped
    private void listBookingDatejTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listBookingDatejTextField1FocusGained
        this.listBookingDatejTextField1.setText("");
    }//GEN-LAST:event_listBookingDatejTextField1FocusGained
    private void newBookingFormFirstTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newBookingFormFirstTextFieldFocusGained
        this.newBookingFormFirstTextField.setText("");
    }//GEN-LAST:event_newBookingFormFirstTextFieldFocusGained
    private void newBookingFormNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBookingFormNameTextFieldActionPerformed
    private void newBookingFindSearchNONTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newBookingFindSearchNONTextFieldFocusGained
        this.newBookingFindSearchNONTextField.setText("");
    }//GEN-LAST:event_newBookingFindSearchNONTextFieldFocusGained
    private void eBFormEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFormEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eBFormEmailTextFieldActionPerformed

    public void setFocusListener(JPanel panel) {
        for (int x = 0; x < panel.getComponentCount(); ++x) {
            if (panel.getComponent(x) instanceof JTextField) {
                JTextField f = (JTextField) panel.getComponent(x);
                f.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        f.setText("");
                    }

                });
            }

        }

    }

    private void setFullScreenSettings() {
        isFullScreen = device.isFullScreenSupported();
        if (!System.getProperty("os.name").startsWith("Mac")) {
            this.setExtendedState(Frame.MAXIMIZED_BOTH);
            dispose();
            setUndecorated(isFullScreen);
            this.setVisible(true);
        } else {
            if (isFullScreen) {
                setResizable(!isFullScreen);
                device.setFullScreenWindow(this);
                validate();

            } else {
                pack();
                setVisible(true);
            }
        }
    }

    /**
     * @param container
     * @param enable set true to enable components in container
     * @author Robert Elving
     */
    private void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }

    private void resetAllJTextFields(Container c) {
        for (Component component : c.getComponents()) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setText("");
            }
        }
    }

    public void setNewBookingCustomer(Customer c) {
        this.newBookingFormFirstTextField.setText(c.getFirst_name());
        this.newBookingFormCityTextField.setText(c.getCity());
        this.newBookingFormNameTextField.setText(c.getLast_name());
        this.newBookingFormPhoneTextField.setText(c.getPhone());
        this.newBookingFormStreetTextField.setText(c.getStreet());
        this.newBookingFormZipTextField.setText(c.getZipcode());
        this.newBookingFormEmailTextField.setText(c.getEmail());
        this.newBookingFormNatTextField.setText(c.getCountry());
        this.newBookingFindSearchNONTextField.setText("");
        this.newBookingFindSearchFromTextField.setText("");
    }

    public void clearNewBookingFields() {
        this.newBookingFormFirstTextField.setText("");
        this.newBookingFormADateTextField.setText("");
        this.newBookingFormAgenTextField.setText("");
        this.newBookingFormCityTextField.setText("");
        this.newBookingFormNOGTextField.setText("");
        this.newBookingFormNONTextField.setText("");
        this.newBookingFormNameTextField.setText("");
        this.newBookingFormNatTextField.setText("");
        this.newBookingFormPhoneTextField.setText("");
        this.newBookingFormRoomTextField.setText("");
        this.newBookingFormStreetTextField.setText("");
        this.newBookingFormZipTextField.setText("");
        this.newBookingFormEmailTextField.setText("");
        this.nBListModel.clear();
        this.newBookingFindSearchNONTextField.setText("");
        this.newBookingFindSearchFromTextField.setText("");
    }

    private void clearEditBookingsFields() {
        this.eBFormADateTextField.setText("");
        this.eBFormANRTextField.setText("");
        this.eBFormCityTextField.setText("");
        this.eBFormEmailTextField.setText("");
        this.eBFormFirstTextField.setText("");
        this.eBFormNOGTextField.setText("");
        this.eBFormNONTextField.setText("");
        this.eBFormNameTextField.setText("");
        this.eBFormNatTextField.setText("");
        this.eBFormPhoneTextField.setText("");
        this.eBFormStreetTextField.setText("");
        this.eBFormZipTextField.setText("");
    }

    private void setUpTextFields(Booking b, Customer c) {
        this.eBFormADateTextField.setText(b.getDate_from());
        this.eBFormANRTextField.setText("" + b.getA_num());
        this.eBFormCityTextField.setText(c.getCity());
        //this.eBFormCombo.setSelectedItem("");
        this.eBFormEmailTextField.setText(c.getEmail());
        this.eBFormFirstTextField.setText(c.getFirst_name());
        this.eBFormNOGTextField.setText("" + b.getNumber_of_guests());
        this.eBFormNONTextField.setText("" + b.getNum_of_nights());
        this.eBFormNameTextField.setText(c.getLast_name());
        this.eBFormNatTextField.setText(c.getCountry());
        this.eBFormPhoneTextField.setText(c.getPhone());
        this.eBFormStreetTextField.setText(c.getStreet());
        this.eBFormZipTextField.setText("" + c.getZipcode());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eBFindBookingNRTextField;
    private javax.swing.JButton eBFindButtonBackButton;
    private javax.swing.JButton eBFindButtonFindButton;
    private javax.swing.JTextField eBFindDateTextField;
    private javax.swing.JTextField eBFindNameTextField;
    private javax.swing.JPanel eBFindPanel;
    private javax.swing.JTextField eBFindRoomNrTextField;
    private javax.swing.JLabel eBFindTitleTitleLabel;
    private javax.swing.JTextField eBFormADateTextField;
    private javax.swing.JTextField eBFormANRTextField;
    private javax.swing.JButton eBFormButtonCancelButton;
    private javax.swing.JButton eBFormButtonSaveButton;
    private javax.swing.JTextField eBFormCityTextField;
    private javax.swing.JTextField eBFormEmailTextField;
    private javax.swing.JTextField eBFormFirstTextField;
    private javax.swing.JTextField eBFormNOGTextField;
    private javax.swing.JTextField eBFormNONTextField;
    private javax.swing.JTextField eBFormNameTextField;
    private javax.swing.JTextField eBFormNatTextField;
    private javax.swing.JPanel eBFormPanel;
    private javax.swing.JTextField eBFormPhoneTextField;
    private javax.swing.JTextField eBFormStreetTextField;
    private javax.swing.JTextField eBFormZipTextField;
    private javax.swing.JButton eBMAtchButtonDeleteButton;
    private javax.swing.JButton eBMatchButtonEditButton;
    private javax.swing.JList eBMatchList;
    private javax.swing.JPanel eBMatchPanel;
    private javax.swing.JLabel eBTitleTitleLabel;
    private javax.swing.JPanel editBookingPanel;
    private javax.swing.JButton frontPageEditBooking;
    private javax.swing.JButton frontPageExitButton;
    private javax.swing.JButton frontPageLogoutButton;
    private javax.swing.JButton frontPageNewBooking;
    private javax.swing.JPanel frontPagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList listBookingApartmentjList;
    private javax.swing.JButton listBookingBackButton;
    private javax.swing.JTextField listBookingDatejTextField1;
    private javax.swing.JLabel listBookingDisplayTypejLabel;
    private javax.swing.JButton listBookingDownListButton;
    private javax.swing.JPanel listBookingDrawingPanel;
    private javax.swing.JLabel listBookingLastUpdatedjLabel;
    private javax.swing.JButton listBookingPageButton;
    private javax.swing.JPanel listBookingPanel;
    private javax.swing.JButton listBookingPreviousListButton;
    private javax.swing.JButton listBookingRefreshjButton;
    private javax.swing.JButton listBookingSearchjButton;
    private javax.swing.JButton listBookingTodayjButton;
    private javax.swing.JButton listBookingUpListButton;
    private javax.swing.JButton listBookingnextListButton;
    private javax.swing.JPanel listOptionjPanel;
    private javax.swing.JPanel mainPage;
    private javax.swing.JPanel menuOptionsjPanel;
    private javax.swing.JList newBookingAvailList;
    private javax.swing.JLabel newBookingAvailTitleTitle;
    private javax.swing.JPanel newBookingAvailablePanel;
    private javax.swing.JButton newBookingFindButtonBackButton;
    private javax.swing.JButton newBookingFindButtonFindButton;
    private javax.swing.JPanel newBookingFindPanel;
    private javax.swing.JTextField newBookingFindRoomNRTextField;
    private javax.swing.JTextField newBookingFindSearchFromTextField;
    private javax.swing.JTextField newBookingFindSearchNONTextField;
    private javax.swing.JPanel newBookingFindSearchPanel;
    private javax.swing.JComboBox newBookingFindSearchTypeComboBox;
    private javax.swing.JLabel newBookingFormADateLabel;
    private javax.swing.JTextField newBookingFormADateTextField;
    private javax.swing.JTextField newBookingFormAgenTextField;
    private javax.swing.JPanel newBookingFormButtonPanel;
    private javax.swing.JTextField newBookingFormCityTextField;
    private javax.swing.JButton newBookingFormCreateButton;
    private javax.swing.JTextField newBookingFormEmailTextField;
    private javax.swing.JTextField newBookingFormFirstTextField;
    private javax.swing.JPanel newBookingFormGreyPanel;
    private javax.swing.JTextField newBookingFormNOGTextField;
    private javax.swing.JLabel newBookingFormNONLabel;
    private javax.swing.JTextField newBookingFormNONTextField;
    private javax.swing.JTextField newBookingFormNameTextField;
    private javax.swing.JTextField newBookingFormNatTextField;
    private javax.swing.JPanel newBookingFormPanel;
    private javax.swing.JTextField newBookingFormPhoneTextField;
    private javax.swing.JButton newBookingFormPreviousButton;
    private javax.swing.JLabel newBookingFormRoomLabel;
    private javax.swing.JTextField newBookingFormRoomTextField;
    private javax.swing.JTextField newBookingFormStreetTextField;
    private javax.swing.JTextField newBookingFormZipTextField;
    private javax.swing.JPanel newBookingPanel;
    private javax.swing.JLabel newBookingTitleTitle;
    private javax.swing.JButton previousCustomerCancelbutton;
    private javax.swing.JButton previousCustomerChooseButton;
    private javax.swing.JList previousCustomerList;
    private javax.swing.JPanel previousCustomerPanel;
    private javax.swing.JButton previousCustomerSearchButton;
    private javax.swing.JTextField previousCustomerSearchField;
    // End of variables declaration//GEN-END:variables
}
