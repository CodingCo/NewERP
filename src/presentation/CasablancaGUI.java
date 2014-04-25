package presentation;

import Exception.BookingException;
import Exception.DateException;
import Exception.NameException;
import Exception.RoomException;
import domain.Apartment;
import domain.Booking;
import domain.Controller;
import domain.Customer;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Simon & Robert
 */
public class CasablancaGUI extends javax.swing.JFrame {

    private final CardLayout cl;
    private final Controller controller;
    private final DefaultListModel nBListModel;
    private final DefaultListModel eBListModel;
    private final DefaultListModel lBlistModel;
    private final DefaultListModel cBListModel;
    private final GraphicsDevice device;

    private Customer tmpCustomer = null;
    private Apartment temporaryApartment = null;
    private HashMap<Booking, Customer> bookingsFoundHashMap = null;

    private boolean drawTodayFlag = false;
    private boolean drawMonthFlag = false;
    private boolean drawApartmentFlag = false;
    private boolean isFullScreen = true;
    private boolean previousCustomerFlag = false;

    public static int INDEX_WIDTH = 0;
    public static int INDEX_HEIGHT = 0;
    
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

        this.lBlistModel = new DefaultListModel();
        this.listBookingApartmentjList.setModel(lBlistModel);
        this.nBListModel = new DefaultListModel();
        this.newBookingAvailList.setModel(nBListModel);
        this.eBListModel = new DefaultListModel();
        this.eBMatchList.setModel(eBListModel);
        this.cBListModel = new DefaultListModel();
        this.previousCustomerList.setModel(cBListModel);

        this.bookingsFoundHashMap = new HashMap();
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
        newBookingFormCountryTextField = new javax.swing.JTextField();
        newBookingFormCityTextField = new javax.swing.JTextField();
        newBookingFormStreetTextField = new javax.swing.JTextField();
        newBookingFormButtonPanel = new javax.swing.JPanel();
        newBookingFormSubmitButton = new javax.swing.JButton();
        newBookingFormPreviousButton = new javax.swing.JButton();
        newBookingFormGreyPanel = new javax.swing.JPanel();
        newBookingFormADateLabel = new javax.swing.JLabel();
        newBookingFormNONLabel = new javax.swing.JLabel();
        newBookingFormRoomLabel = new javax.swing.JLabel();
        newBookingFormADateTextField = new javax.swing.JTextField();
        newBookingFormNONTextField = new javax.swing.JTextField();
        newBookingFormRoomTextField = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        newBookingPriceTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        newBookingFormAgenTextField = new javax.swing.JTextField();
        newBookingFormEmailTextField = new javax.swing.JTextField();
        newBookingFormZipTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        eBFindButtonFindButton = new javax.swing.JButton();
        eBFindButtonBackButton = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
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
        eBFormButtonClearButton = new javax.swing.JButton();
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
        jLabel39 = new javax.swing.JLabel();
        ebFormPriceTextField = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
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

        listBookingPageButton.setText("List Booking");
        listBookingPageButton.setToolTipText("go to booking list page");
        listBookingPageButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listBookingPageButton.setMaximumSize(new java.awt.Dimension(150, 50));
        listBookingPageButton.setMinimumSize(new java.awt.Dimension(150, 50));
        listBookingPageButton.setPreferredSize(new java.awt.Dimension(150, 50));
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
                .addComponent(frontPageExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(148, 148, 148)
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
        newBookingFindSearchFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newBookingFindSearchFromTextFieldKeyTyped(evt);
            }
        });

        newBookingFindSearchNONTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
                .addContainerGap()
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addGap(216, 216, 216))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(newBookingFindButtonFindButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newBookingFindRoomNRTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newBookingFindSearchFromTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(newBookingFindButtonBackButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newBookingFindSearchTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFindSearchNONTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        newBookingFormNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormNOGTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormPhoneTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormCountryTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormCityTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormStreetTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormSubmitButton.setText("Submit");
        newBookingFormSubmitButton.setMaximumSize(new java.awt.Dimension(150, 30));
        newBookingFormSubmitButton.setMinimumSize(new java.awt.Dimension(150, 30));
        newBookingFormSubmitButton.setPreferredSize(new java.awt.Dimension(150, 30));
        newBookingFormSubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingFormSubmitButtonMouseEntered(evt);
            }
        });
        newBookingFormSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormSubmitButtonActionPerformed(evt);
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

        newBookingFormNONTextField.setEditable(false);
        newBookingFormNONTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormRoomTextField.setEditable(false);
        newBookingFormRoomTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingPriceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingPriceTextField.setEnabled(false);

        jLabel30.setText("Price:");

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
                            .addComponent(newBookingFormADateLabel)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingPriceTextField, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(newBookingPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        newBookingFormButtonPanelLayout.setVerticalGroup(
            newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        newBookingFormAgenTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormEmailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormZipTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel1.setText("Optional fields");

        jLabel32.setText("Number of guests");

        jLabel13.setText("First name");

        jLabel14.setText("Last name");

        jLabel15.setText("Phone number");

        jLabel16.setText("Email address");

        jLabel17.setText("Postal / zip code");

        jLabel19.setText("Travel agency");

        jLabel20.setText("City");

        jLabel21.setText("Street address");

        jLabel22.setText("Country");

        javax.swing.GroupLayout newBookingFormPanelLayout = new javax.swing.GroupLayout(newBookingFormPanel);
        newBookingFormPanel.setLayout(newBookingFormPanelLayout);
        newBookingFormPanelLayout.setHorizontalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFormNameTextField)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newBookingFormEmailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormPhoneTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newBookingFormPanelLayout.createSequentialGroup()
                                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newBookingFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(newBookingFormCountryTextField))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormNOGTextField))
                        .addContainerGap())
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFormAgenTextField)
                                .addContainerGap())))
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(217, 217, 217))))
        );
        newBookingFormPanelLayout.setVerticalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newBookingFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormAgenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        listBookingnextListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingnextListButtonActionPerformed(evt);
            }
        });

        listBookingPreviousListButton.setText("Previous");
        listBookingPreviousListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingPreviousListButtonActionPerformed(evt);
            }
        });

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
                        .addComponent(listBookingLastUpdatedjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(listBookingLastUpdatedjLabel))
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

        eBFindNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        eBFindDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        eBFindDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eBFindDateTextFieldKeyTyped(evt);
            }
        });

        eBFindRoomNrTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        eBFindBookingNRTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel27.setText("Find booking by entering a search criteria. All  ");

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

        jLabel45.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel45.setText("Booking start date must be in DD-MM-YY");

        javax.swing.GroupLayout eBFindPanelLayout = new javax.swing.GroupLayout(eBFindPanel);
        eBFindPanel.setLayout(eBFindPanelLayout);
        eBFindPanelLayout.setHorizontalGroup(
            eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eBFindNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eBFindDateTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eBFindRoomNrTextField)
                    .addComponent(eBFindBookingNRTextField)
                    .addGroup(eBFindPanelLayout.createSequentialGroup()
                        .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel18)
                            .addComponent(jLabel7)
                            .addComponent(jLabel28)
                            .addComponent(eBFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eBFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel27)
                            .addComponent(jLabel44)
                            .addComponent(jLabel5)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        eBFindPanelLayout.setVerticalGroup(
            eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(63, 63, 63)
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
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
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
        jScrollPane2.setViewportView(eBMatchList);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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

        eBFormNONTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                eBFormNONTextFieldFocusLost(evt);
            }
        });

        eBFormANRTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                eBFormANRTextFieldFocusLost(evt);
            }
        });
        eBFormANRTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                eBFormANRTextFieldKeyTyped(evt);
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

        eBFormButtonClearButton.setText("Clear");
        eBFormButtonClearButton.setMaximumSize(new java.awt.Dimension(100, 30));
        eBFormButtonClearButton.setMinimumSize(new java.awt.Dimension(100, 30));
        eBFormButtonClearButton.setPreferredSize(new java.awt.Dimension(100, 30));
        eBFormButtonClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eBFormButtonClearButtonMouseEntered(evt);
            }
        });
        eBFormButtonClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBFormButtonClearButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("Arrival date");

        jLabel29.setText("Number of nights");

        jLabel46.setText("Apartment number");

        jLabel3.setText("First name");

        jLabel10.setText("Last name");

        jLabel11.setText("Number of guests");

        jLabel12.setText("Phone number");

        jLabel47.setText("Email address");

        jLabel48.setText("City");

        jLabel49.setText("Street address");

        jLabel50.setText("postal / zip code");

        jLabel51.setText("Country");

        jLabel39.setText("Price:");

        ebFormPriceTextField.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel40.setText("Optional");

        javax.swing.GroupLayout eBFormPanelLayout = new javax.swing.GroupLayout(eBFormPanel);
        eBFormPanel.setLayout(eBFormPanelLayout);
        eBFormPanelLayout.setHorizontalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(eBFormNONTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eBFormANRTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 54, Short.MAX_VALUE))
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(eBFormNOGTextField)
                                    .addComponent(ebFormPriceTextField))
                                .addContainerGap())))
                    .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addComponent(eBFormButtonClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 230, Short.MAX_VALUE))
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addComponent(eBFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormNatTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormADateTextField)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eBFormFirstTextField)
                                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 70, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(eBFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(eBFormPhoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormEmailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormStreetTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormCityTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, eBFormPanelLayout.createSequentialGroup()
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel50))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        eBFormPanelLayout.setVerticalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ebFormPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormANRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormNatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eBFormButtonClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                        .addComponent(previousCustomerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(previousCustomerSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(previousCustomerCancelbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(previousCustomerChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousCustomerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousCustomerSearchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(previousCustomerChooseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previousCustomerCancelbutton)
                .addContainerGap())
        );

        javax.swing.GroupLayout previousCustomerPanelLayout = new javax.swing.GroupLayout(previousCustomerPanel);
        previousCustomerPanel.setLayout(previousCustomerPanelLayout);
        previousCustomerPanelLayout.setHorizontalGroup(
            previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousCustomerPanelLayout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addGroup(previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(previousCustomerPanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel37)))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        previousCustomerPanelLayout.setVerticalGroup(
            previousCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(previousCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(72, 72, 72)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
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
        this.ebFormPriceTextField.setEnabled(false);
        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        Customer c = this.bookingsFoundHashMap.get(b);
        setUpTextFields(b, c);

    }//GEN-LAST:event_eBMatchButtonEditButtonActionPerformed
    private void eBFindButtonFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFindButtonFindButtonActionPerformed
        this.bookingsFoundHashMap.clear();
        this.eBListModel.clear();
        clearEditBookingsFields();
        enableComponents(this.eBFormPanel, false);

        try {
            String name = this.eBFindNameTextField.getText().trim();
            String date = this.eBFindDateTextField.getText().trim();
            String bNum = this.eBFindBookingNRTextField.getText().trim();
            String aNum = this.eBFindRoomNrTextField.getText().trim();
            int apartmentNumber = 0;
            int bookingNumber = 0;

            if (!name.isEmpty()) {
                InputCheck.nameCheck(name);
            }
            if (!date.isEmpty()) {
                InputCheck.dateFormatCheck(date);
            }
            if (!bNum.isEmpty()) {
                bookingNumber = InputCheck.bookingNrCheck(bNum);
            }
            if (!aNum.isEmpty()) {
                apartmentNumber = InputCheck.apartmentCheck(aNum);
            }

            bookingsFoundHashMap = controller.findBookings(bookingNumber, name, date, apartmentNumber);

            if (bookingsFoundHashMap.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Booking Found", "", WIDTH);
            } else {
                for (Booking b : bookingsFoundHashMap.keySet()) {
                    this.eBListModel.addElement(b);
                }
                this.enableComponents(this.eBMatchPanel, true);
            }
        } catch (NameException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "", WIDTH);
        } catch (DateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        } catch (BookingException exx) {
            JOptionPane.showMessageDialog(this, exx.getMessage(), "", WIDTH);
        } catch (RoomException exxx) {
            JOptionPane.showMessageDialog(this, exxx.getMessage(), "", WIDTH);
        } catch (Exception exxxx) {
            JOptionPane.showMessageDialog(this, exxxx.getMessage(), "", WIDTH);
        }


    }//GEN-LAST:event_eBFindButtonFindButtonActionPerformed
    private void eBFormButtonSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFormButtonSaveButtonActionPerformed
        try {
            Booking b = (Booking) eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
            Customer c = (Customer) bookingsFoundHashMap.get(b);
            String anum = this.eBFormANRTextField.getText();
            String date = this.eBFormADateTextField.getText();
            String numNights = this.eBFormNONTextField.getText();
            String firstName = this.eBFormFirstTextField.getText();
            String lastName = this.eBFormNameTextField.getText();
            String phone = this.eBFormPhoneTextField.getText();
            String email = this.eBFormEmailTextField.getText();
            String price = this.ebFormPriceTextField.getText();
            String country = this.eBFormNatTextField.getText();
            String city = this.eBFormCityTextField.getText();
            String street = this.eBFormStreetTextField.getText();
            String zipcode = this.eBFormZipTextField.getText();
            int apartmentNumber = InputCheck.apartmentCheck(anum);
            int numberOfNights = InputCheck.nightsCheck(numNights);
            double bookingPrice = Double.parseDouble(price);
            int guests = InputCheck.editApartmentTypeCheck(this.eBFormNOGTextField.getText(), apartmentNumber);

            InputCheck.dateFormatCheck(date);
            InputCheck.timeDateCheck(date);
            InputCheck.nightsCheck(numNights);
            InputCheck.nameCheck(firstName);
            InputCheck.nameCheck(lastName);
            InputCheck.phoneCheck(phone);
            InputCheck.emailCheck(email);
            InputCheck.streetAddressCheck(street);

            controller.updateBooking(b, apartmentNumber, date, numberOfNights, bookingPrice, c, firstName, lastName, phone, email, country, city, zipcode, street, guests);

            this.clearEditBookingsFields();
            this.eBListModel.clear();
            this.enableComponents(this.eBMatchPanel, false);
            this.enableComponents(this.eBFormPanel, false);
            JOptionPane.showMessageDialog(this, "Booking Updated", "", WIDTH);
        } catch (BookingException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "", WIDTH);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        } finally {
            controller.updateLists();
        }


    }//GEN-LAST:event_eBFormButtonSaveButtonActionPerformed
    private void eBMAtchButtonDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBMAtchButtonDeleteButtonActionPerformed
        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        try {
            controller.deleteBooking(b.getB_id());
            JOptionPane.showMessageDialog(this, "Booking Deleted", "", WIDTH);
        } catch (BookingException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "", WIDTH);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        }
        this.clearEditBookingsFields();
        this.eBListModel.clear();
    }//GEN-LAST:event_eBMAtchButtonDeleteButtonActionPerformed
    private void eBFormButtonClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBFormButtonClearButtonActionPerformed
        this.clearEditBookingsFields();
        this.enableComponents(this.eBFormPanel, false);
        this.enableComponents(this.eBMatchPanel, false);
    }//GEN-LAST:event_eBFormButtonClearButtonActionPerformed
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
    private void eBFormButtonClearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eBFormButtonClearButtonMouseEntered
        this.eBFormButtonClearButton.setToolTipText("Press to Cancel Changes");
    }//GEN-LAST:event_eBFormButtonClearButtonMouseEntered
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
    private void newBookingFormPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormPreviousButtonActionPerformed
        cl.show(mainPage, "PreviousCustomer");
        
        
    }//GEN-LAST:event_newBookingFormPreviousButtonActionPerformed
    private void newBookingFormPreviousButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFormPreviousButtonMouseEntered
        this.newBookingFormPreviousButton.setToolTipText("Press to load Previous Customer");
    }//GEN-LAST:event_newBookingFormPreviousButtonMouseEntered
    private void newBookingFormSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormSubmitButtonActionPerformed

        try {
            String firstName = this.newBookingFormFirstTextField.getText().trim();
            String lastName = this.newBookingFormNameTextField.getText().trim();
            String phone = this.newBookingFormPhoneTextField.getText().trim();
            String email = this.newBookingFormEmailTextField.getText().trim();
            String country = this.newBookingFormCountryTextField.getText().trim();
            String city = this.newBookingFormCityTextField.getText().trim();
            String street = this.newBookingFormStreetTextField.getText().trim();
            String travelAgency = this.newBookingFormAgenTextField.getText().trim();
            String zipcode = this.newBookingFormZipTextField.getText().trim();
            String date = this.newBookingFormADateTextField.getText().trim();
            int price = Integer.parseInt(this.newBookingPriceTextField.getText());
            int numberOfNights = Integer.parseInt(this.newBookingFormNONTextField.getText());
            Apartment a = (Apartment) nBListModel.getElementAt(this.newBookingAvailList.getSelectedIndex());

            InputCheck.nameCheck(firstName);
            InputCheck.nameCheck(lastName);
            InputCheck.phoneCheck(phone);
            InputCheck.emailCheck(email);
            InputCheck.custInfoCheck(city);
            InputCheck.custInfoCheck(country);
            InputCheck.streetAddressCheck(street);
            
            int guests = InputCheck.guestCheck(this.newBookingFormNOGTextField.getText(), a.getType());
            if(!this.previousCustomerFlag){
            tmpCustomer = this.controller.newCustomer(firstName, lastName, phone, email, country, city, zipcode, street);
            }else{
                tmpCustomer.setFirst_name(firstName);
                tmpCustomer.setLast_name(lastName);
                tmpCustomer.setPhone(phone);
                tmpCustomer.setEmail(email);
                tmpCustomer.setCountry(country);
                tmpCustomer.setCity(city);
                tmpCustomer.setStreet(street);
                tmpCustomer.setZipcode(zipcode);
                
            }
            this.controller.newBooking(tmpCustomer, a.getA_num(), date, numberOfNights, travelAgency, guests, price, tmpCustomer.getFirst_name(), tmpCustomer.getLast_name(), tmpCustomer.getPhone());
            this.previousCustomerFlag = false;
            this.tmpCustomer = null;
            this.enableComponents(this, false);
            this.enableComponents(this, true);
            this.enableComponents(this.newBookingFormPanel, false);
            this.enableComponents(this.newBookingFormButtonPanel, true);
            this.enableComponents(this.newBookingFormGreyPanel, false);
            this.enableComponents(this.newBookingAvailablePanel, false);
            this.clearNewBookingFields();
            JOptionPane.showMessageDialog(this, "Booking created", "", WIDTH);

        } catch (RoomException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "", WIDTH);
        } catch (BookingException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        } catch (NameException exx) {
            JOptionPane.showMessageDialog(this, exx.getMessage(), "", WIDTH);
        } catch (Exception exxx) {
            JOptionPane.showMessageDialog(this, exxx.getMessage(), "", WIDTH);
        }


    }//GEN-LAST:event_newBookingFormSubmitButtonActionPerformed
    private void newBookingFormSubmitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFormSubmitButtonMouseEntered
        this.newBookingFormSubmitButton.setToolTipText("Press to Create Booking");
    }//GEN-LAST:event_newBookingFormSubmitButtonMouseEntered
    private void newBookingAvailablePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingAvailablePanelMouseEntered
        this.newBookingAvailablePanel.setToolTipText("Select Apartment");
    }//GEN-LAST:event_newBookingAvailablePanelMouseEntered
    private void newBookingAvailListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingAvailListMouseClicked

        Apartment a = (Apartment) nBListModel.getElementAt(this.newBookingAvailList.getSelectedIndex());
        int price = 0;
        try {
            price = Integer.parseInt(this.newBookingFindSearchNONTextField.getText()) * a.getPrice();
        } catch (NumberFormatException ex) {
        }
        this.newBookingFormADateTextField.setText(this.newBookingFindSearchFromTextField.getText());
        this.newBookingFormNONTextField.setText(this.newBookingFindSearchNONTextField.getText());
        this.newBookingFormRoomTextField.setText("" + a.getA_num());
        this.newBookingPriceTextField.setText("" + price);
        this.enableComponents(this.newBookingFormPanel, true);
        this.enableComponents(this.newBookingFormGreyPanel, false);
    }//GEN-LAST:event_newBookingAvailListMouseClicked
    private void newBookingFindSearchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchPanelMouseClicked

    }//GEN-LAST:event_newBookingFindSearchPanelMouseClicked
    private void newBookingFindButtonFindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFindButtonFindButtonActionPerformed

        this.nBListModel.clear();
        int apartmentNumber = 0;
        int numNights = 0;
        ArrayList<Apartment> a = null;
        String date = this.newBookingFindSearchFromTextField.getText();
        String numberOfNights = this.newBookingFindSearchNONTextField.getText();
        String selectedItem = this.newBookingFindSearchTypeComboBox.getSelectedItem().toString();
        String anum = this.newBookingFindRoomNRTextField.getText();

        try {
            if (!anum.trim().isEmpty()) {
                apartmentNumber = InputCheck.apartmentCheck(anum);
            }
        } catch (RoomException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        }
        try {
            InputCheck.dateFormatCheck(date);
            InputCheck.timeDateCheck(date);
            numNights = InputCheck.nightsCheck(numberOfNights);
            a = controller.findAvailableApartment(date, numNights, selectedItem, apartmentNumber);
            if (a.isEmpty()) {
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
        } catch (BookingException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "", WIDTH);
        } catch (DateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", WIDTH);
        } catch (Exception exx) {

        }
    }//GEN-LAST:event_newBookingFindButtonFindButtonActionPerformed
    private void newBookingFindButtonFindButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindButtonFindButtonMouseEntered
        this.newBookingFindButtonFindButton.setToolTipText("Press to search for available apartment");
    }//GEN-LAST:event_newBookingFindButtonFindButtonMouseEntered
    private void newBookingFindButtonBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFindButtonBackButtonActionPerformed

        cl.show(mainPage, "FrontPage");
        this.clearNewBookingFields();
        this.newBookingFindSearchFromTextField.setText("DD-MM-YY");

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
    private void newBookingFindSearchFromTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBookingFindSearchFromTextFieldMouseClicked
        this.newBookingFindSearchFromTextField.setText("");
        this.enableComponents(this.newBookingAvailablePanel, false);
        this.enableComponents(this.newBookingFormPanel, false);
    }//GEN-LAST:event_newBookingFindSearchFromTextFieldMouseClicked
    private void listBookingPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingPageButtonActionPerformed
        cl.show(mainPage, "ListBooking");
        ArrayList<Apartment> list = this.controller.getApartments();
        for (Apartment a : list) {
            this.lBlistModel.addElement(a);
        }
    }//GEN-LAST:event_listBookingPageButtonActionPerformed
    private void listBookingRefreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingRefreshjButtonActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(Calendar.getInstance().getTime());
        String timeStamp = sdf.format(calendar.getTime());
        this.listBookingLastUpdatedjLabel.setText("Updated: " + timeStamp);
        this.controller.updateLists();

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
            this.drawMonth.up();
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
            this.listBookingDrawingPanel.repaint();
            this.drawMonth.down();
        }

    }//GEN-LAST:event_listBookingDownListButtonActionPerformed
    private void listBookingTodayjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingTodayjButtonActionPerformed
        this.drawTodayFlag = true;
        this.drawApartmentFlag = false;
        this.drawMonthFlag = false;
        this.drawToday = new DrawToday(this.listBookingDrawingPanel, this.controller.getBookingsToDay());
        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawToday);
        this.listBookingDrawingPanel.repaint();
        this.drawToday.reset();

    }//GEN-LAST:event_listBookingTodayjButtonActionPerformed
    private void listBookingSearchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingSearchjButtonActionPerformed
        this.drawTodayFlag = false;
        this.drawApartmentFlag = false;
        this.drawMonthFlag = true;
        this.drawMonth = new DrawMonth(this.listBookingDrawingPanel);
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
        this.drawTodayFlag = false;
        this.drawApartmentFlag = false;
        this.drawMonthFlag = true;
        this.drawApartment = new DrawApartment(this.listBookingDrawingPanel);
        Apartment a = (Apartment) this.lBlistModel.getElementAt(this.listBookingApartmentjList.getSelectedIndex());
        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawApartment);
        this.listBookingDrawingPanel.repaint();

    }//GEN-LAST:event_listBookingApartmentjListMouseClicked
    private void previousCustomerSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCustomerSearchButtonActionPerformed
        this.cBListModel.clear();
        ArrayList<Customer> clist = this.controller.searchForCustomers(this.previousCustomerSearchField.getText().toLowerCase());
        for (Customer c : clist) {
            this.cBListModel.addElement(c);
        }
    }//GEN-LAST:event_previousCustomerSearchButtonActionPerformed
    private void previousCustomerChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousCustomerChooseButtonActionPerformed
        tmpCustomer  = (Customer) this.cBListModel.getElementAt(this.previousCustomerList.getSelectedIndex());
        setNewBookingCustomer(tmpCustomer);
        cl.show(mainPage, "NewBooking");
        this.previousCustomerFlag = true;
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
    private void listBookingnextListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingnextListButtonActionPerformed
        if (this.drawMonthFlag) {
            this.drawMonth = new DrawMonth(this.listBookingDrawingPanel);
            this.listBookingDatejTextField1.setText(this.drawMonth.nextMonth(this.listBookingDatejTextField1.getText()));
            this.listBookingDrawingPanel.removeAll();
            this.drawMonth.initializeListAndMonth(this.controller.getBookingsBySpecificMonth(this.listBookingDatejTextField1.getText()), this.listBookingDatejTextField1.getText());
            this.listBookingDrawingPanel.add(this.drawMonth);
            this.listBookingDrawingPanel.repaint();
        }

    }//GEN-LAST:event_listBookingnextListButtonActionPerformed
    private void listBookingPreviousListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingPreviousListButtonActionPerformed
        if (this.drawMonthFlag) {
            this.drawMonth = new DrawMonth(this.listBookingDrawingPanel);
            this.listBookingDatejTextField1.setText(this.drawMonth.previousMonth(this.listBookingDatejTextField1.getText()));
            this.listBookingDrawingPanel.removeAll();
            this.drawMonth.initializeListAndMonth(this.controller.getBookingsBySpecificMonth(this.listBookingDatejTextField1.getText()), this.listBookingDatejTextField1.getText());
            this.listBookingDrawingPanel.add(this.drawMonth);
            this.listBookingDrawingPanel.repaint();
        }

    }//GEN-LAST:event_listBookingPreviousListButtonActionPerformed
    private void eBFindDateTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eBFindDateTextFieldKeyTyped
        JTextField selectedTextField = this.eBFindDateTextField; //== EDIT THIS
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
    }//GEN-LAST:event_eBFindDateTextFieldKeyTyped
    private void eBFormANRTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eBFormANRTextFieldKeyTyped
        this.eBFormNOGTextField.setText("");
    }//GEN-LAST:event_eBFormANRTextFieldKeyTyped
    private void eBFormNONTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eBFormNONTextFieldFocusLost
        Booking b = (Booking) this.eBListModel.getElementAt(this.eBMatchList.getSelectedIndex());
        try {
            if (!this.eBFormNONTextField.getText().trim().isEmpty()) {
                int nights = Integer.parseInt(this.eBFormNONTextField.getText());
                int price = InputCheck.priceCheck(b.getA_num()) * nights;
                this.ebFormPriceTextField.setText("" + price);
            }

        } catch (RoomException ex) {
        }
    }//GEN-LAST:event_eBFormNONTextFieldFocusLost
    private void eBFormANRTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eBFormANRTextFieldFocusLost

        try {
            if (!this.eBFormNONTextField.getText().trim().isEmpty()) {
                int nights = Integer.parseInt(this.eBFormNONTextField.getText());
                int anum = Integer.parseInt(this.eBFormANRTextField.getText());
                int price = InputCheck.priceCheck(anum) * nights;
                this.ebFormPriceTextField.setText("" + price);
            }

        } catch (RoomException ex) {
        }
    }//GEN-LAST:event_eBFormANRTextFieldFocusLost

    /**
     * Calculates the window size based on system preferences.
     *
     * @author Simon
     */
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
        this.newBookingFormCountryTextField.setText(c.getCountry());
        this.newBookingFindSearchNONTextField.setText("");
        this.newBookingFindSearchFromTextField.setText("");
    }

    public void clearNewBookingFields() {
        this.newBookingPriceTextField.setText("");
        this.newBookingFormFirstTextField.setText("");
        this.newBookingFormADateTextField.setText("");
        this.newBookingFormAgenTextField.setText("");
        this.newBookingFormCityTextField.setText("");
        this.newBookingFormNOGTextField.setText("");
        this.newBookingFormNONTextField.setText("");
        this.newBookingFormNameTextField.setText("");
        this.newBookingFormCountryTextField.setText("");
        this.newBookingFormPhoneTextField.setText("");
        this.newBookingFormRoomTextField.setText("");
        this.newBookingFormStreetTextField.setText("");
        this.newBookingFormZipTextField.setText("");
        this.newBookingFormEmailTextField.setText("");
        this.newBookingFindSearchNONTextField.setText("");
        this.newBookingFindSearchFromTextField.setText("");
        this.nBListModel.clear();
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
        this.ebFormPriceTextField.setText("");
    }

    private void setUpTextFields(Booking b, Customer c) {
        this.eBFormADateTextField.setText(b.getDate_from());
        this.eBFormANRTextField.setText("" + b.getA_num());
        this.eBFormCityTextField.setText(c.getCity());
        this.ebFormPriceTextField.setText("" + b.getPrice());
        this.eBFormEmailTextField.setText(c.getEmail());
        this.eBFormFirstTextField.setText(c.getFirst_name());
        this.eBFormNOGTextField.setText("" + b.getNumber_of_guests());
        this.eBFormNONTextField.setText("" + b.getNum_of_nights());
        this.eBFormNameTextField.setText(c.getLast_name());
        this.eBFormNatTextField.setText(c.getCountry());
        this.eBFormPhoneTextField.setText(c.getPhone());
        this.eBFormStreetTextField.setText(c.getStreet());
        if (c.getZipcode() != null) {
            this.eBFormZipTextField.setText("" + c.getZipcode());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eBFindBookingNRTextField;
    private javax.swing.JButton eBFindButtonBackButton;
    private javax.swing.JButton eBFindButtonFindButton;
    private javax.swing.JTextField eBFindDateTextField;
    private javax.swing.JTextField eBFindNameTextField;
    private javax.swing.JPanel eBFindPanel;
    private javax.swing.JTextField eBFindRoomNrTextField;
    private javax.swing.JTextField eBFormADateTextField;
    private javax.swing.JTextField eBFormANRTextField;
    private javax.swing.JButton eBFormButtonClearButton;
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
    private javax.swing.JTextField ebFormPriceTextField;
    private javax.swing.JPanel editBookingPanel;
    private javax.swing.JButton frontPageEditBooking;
    private javax.swing.JButton frontPageExitButton;
    private javax.swing.JButton frontPageNewBooking;
    private javax.swing.JPanel frontPagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JLabel jLabel45;
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
    private javax.swing.JTextField newBookingFormCountryTextField;
    private javax.swing.JTextField newBookingFormEmailTextField;
    private javax.swing.JTextField newBookingFormFirstTextField;
    private javax.swing.JPanel newBookingFormGreyPanel;
    private javax.swing.JTextField newBookingFormNOGTextField;
    private javax.swing.JLabel newBookingFormNONLabel;
    private javax.swing.JTextField newBookingFormNONTextField;
    private javax.swing.JTextField newBookingFormNameTextField;
    private javax.swing.JPanel newBookingFormPanel;
    private javax.swing.JTextField newBookingFormPhoneTextField;
    private javax.swing.JButton newBookingFormPreviousButton;
    private javax.swing.JLabel newBookingFormRoomLabel;
    private javax.swing.JTextField newBookingFormRoomTextField;
    private javax.swing.JTextField newBookingFormStreetTextField;
    private javax.swing.JButton newBookingFormSubmitButton;
    private javax.swing.JTextField newBookingFormZipTextField;
    private javax.swing.JPanel newBookingPanel;
    private javax.swing.JTextField newBookingPriceTextField;
    private javax.swing.JLabel newBookingTitleTitle;
    private javax.swing.JButton previousCustomerCancelbutton;
    private javax.swing.JButton previousCustomerChooseButton;
    private javax.swing.JList previousCustomerList;
    private javax.swing.JPanel previousCustomerPanel;
    private javax.swing.JButton previousCustomerSearchButton;
    private javax.swing.JTextField previousCustomerSearchField;
    // End of variables declaration//GEN-END:variables
}
