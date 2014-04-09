/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Apartment;
import domain.Booking;
import domain.Controller;
import domain.Customer;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
    private int createCounter = 0;
    private int dateCounter = 0;
    private Apartment tempA = null;
    private HashMap<Booking, Customer> bcHM = null;

    private boolean isFullScreen = false;
    private GraphicsDevice device;
    private DisplayMode originalDM;
    public static int INDEX_WIDTH = 0;
    public static int INDEX_HEIGHT = 1;

    private DrawToday drawToday;
    private DrawMonth drawMonth;
    private DrawApartment drawApartment;
    
    
    /**
     * Creates new form CasablancaGUI
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
        this.cl = (CardLayout) (mainPage.getLayout());
        this.cl.addLayoutComponent(frontPagePanel, "FrontPage");
        this.cl.addLayoutComponent(newBookingPanel, "NewBooking");
        this.cl.addLayoutComponent(editBookingPanel, "EditBooking");
        this.cl.addLayoutComponent(listBookingPanel, "ListBooking");
        this.frontPageLogoutButton.setVisible(false);
        this.newBookingFormPreviousButton.setVisible(false);
        this.lBlistModel = new DefaultListModel();
        this.listBookingApartmentjList.setModel(lBlistModel);
        this.nBListModel = new DefaultListModel();
        this.newBookingAvailList.setModel(nBListModel);
        this.eBListModel = new DefaultListModel();
        this.eBMatchList.setModel(eBListModel);
        this.bcHM = new HashMap();
        this.drawToday = new DrawToday(this.listBookingDrawingPanel);
        this.drawMonth = new DrawMonth(this.listBookingDrawingPanel);
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
        newBookingFindSearchFromLabel = new javax.swing.JLabel();
        newBookingFindSearchNONLabel = new javax.swing.JLabel();
        newBookingFindSearchFromTextField = new javax.swing.JTextField();
        newBookingFindSearchNONTextField = new javax.swing.JTextField();
        newBookingFindSearchTypeComboBox = new javax.swing.JComboBox();
        newBookingFindSearchTypeLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        newBookingFindRoomNRTextField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        newBookingFindButtonBackButton = new javax.swing.JButton();
        newBookingFindButtonFindButton = new javax.swing.JButton();
        newBookingFindTitleTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        newBookingAvailablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newBookingAvailList = new javax.swing.JList();
        newBookingAvailTitleTitle = new javax.swing.JLabel();
        newBookingFormPanel = new javax.swing.JPanel();
        newBookingFormFirstLabel = new javax.swing.JLabel();
        newBookingFormFirstTextField = new javax.swing.JTextField();
        newBookingFormNameLabel = new javax.swing.JLabel();
        newBookingFormNameTextField = new javax.swing.JTextField();
        newBookingFormNOGLabel = new javax.swing.JLabel();
        newBookingFormNOGTextField = new javax.swing.JTextField();
        newBookingFormCityLabel = new javax.swing.JLabel();
        newBookingFormPhoneTextField = new javax.swing.JTextField();
        newBookingFormNatLabel = new javax.swing.JLabel();
        newBookingFormNatTextField = new javax.swing.JTextField();
        newBookingFormStreetLabel = new javax.swing.JLabel();
        newBookingFormPhoneLabel = new javax.swing.JLabel();
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
        jLabel32 = new javax.swing.JLabel();
        newBookingFormAgenLabel = new javax.swing.JLabel();
        newBookingFormAgenTextField = new javax.swing.JTextField();
        newBookingFormEmailLabel = new javax.swing.JLabel();
        newBookingFormEmailTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        newBookingFormZipTextField = new javax.swing.JTextField();
        newBookingFormTitleTitle = new javax.swing.JLabel();
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
        listBookingPreviousListButton = new javax.swing.JButton();
        listBookingNextListButton = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        editBookingPanel = new javax.swing.JPanel();
        eBFindPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        eBFindNameTextField = new javax.swing.JTextField();
        eBFindDateTextField = new javax.swing.JTextField();
        eBFindRoomNrTextField = new javax.swing.JTextField();
        eBFindBookingNRTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        eBFindTitleTitleLabel = new javax.swing.JLabel();
        eBFindButtonFindButton = new javax.swing.JButton();
        eBFindButtonBackButton = new javax.swing.JButton();
        eBMatchPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        eBMatchList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        eBMatchButtonEditButton = new javax.swing.JButton();
        eBMAtchButtonDeleteButton = new javax.swing.JButton();
        eBFormPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        eBFormADateTextField = new javax.swing.JTextField();
        eBFormNONTextField = new javax.swing.JTextField();
        eBFormANRTextField = new javax.swing.JTextField();
        eBFormCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        eBFormGrey = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        eBFormFirstTextField = new javax.swing.JTextField();
        eBFormNameTextField = new javax.swing.JTextField();
        eBFormNOGTextField = new javax.swing.JTextField();
        eBFormPhoneTextField = new javax.swing.JTextField();
        eBFormEmailTextField = new javax.swing.JTextField();
        eBFormCityTextField = new javax.swing.JTextField();
        eBFormStreetTextField = new javax.swing.JTextField();
        eBFormZipTextField = new javax.swing.JTextField();
        eBFormNatTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        eBFormButtonSaveButton = new javax.swing.JButton();
        eBFormButtonCancelButton = new javax.swing.JButton();
        eBTitleTitleLabel = new javax.swing.JLabel();

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
        newBookingFindSearchPanel.setMinimumSize(new java.awt.Dimension(340, 630));
        newBookingFindSearchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBookingFindSearchPanelMouseClicked(evt);
            }
        });

        newBookingFindSearchFromLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFindSearchFromLabel.setText("From:");

        newBookingFindSearchNONLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFindSearchNONLabel.setText("Nights*:");

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

        newBookingFindSearchTypeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFindSearchTypeLabel.setText("Type*:");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("Room nr:");

        jLabel26.setText("Only enter room nr if specific room requested.");

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

        newBookingFindTitleTitle.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        newBookingFindTitleTitle.setText("Find Apartment");

        javax.swing.GroupLayout newBookingFindSearchPanelLayout = new javax.swing.GroupLayout(newBookingFindSearchPanel);
        newBookingFindSearchPanel.setLayout(newBookingFindSearchPanelLayout);
        newBookingFindSearchPanelLayout.setHorizontalGroup(
            newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFindSearchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(105, 105, 105))
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newBookingFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFindSearchPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFindSearchFromLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newBookingFindSearchFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFindSearchPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFindSearchNONLabel)
                                .addGap(18, 18, 18)
                                .addComponent(newBookingFindSearchNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFindSearchTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newBookingFindSearchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(newBookingFindTitleTitle))
                    .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newBookingFindRoomNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newBookingFindSearchPanelLayout.setVerticalGroup(
            newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindSearchPanelLayout.createSequentialGroup()
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFindSearchFromLabel)
                    .addComponent(newBookingFindSearchFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFindSearchNONLabel)
                    .addComponent(newBookingFindSearchNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFindSearchTypeLabel)
                    .addComponent(newBookingFindSearchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(newBookingFindRoomNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newBookingFindTitleTitle)
                .addGap(68, 68, 68)
                .addGroup(newBookingFindSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jLabel2.setText("1. Enter search criterias in fields below.");

        jLabel23.setText("2. Press \"Find\" and select apartment if any.");

        jLabel24.setText("3. Fill out Form and press \"Create Booking\".");

        javax.swing.GroupLayout newBookingFindPanelLayout = new javax.swing.GroupLayout(newBookingFindPanel);
        newBookingFindPanel.setLayout(newBookingFindPanelLayout);
        newBookingFindPanelLayout.setHorizontalGroup(
            newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                .addComponent(newBookingFindSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newBookingFindPanelLayout.setVerticalGroup(
            newBookingFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(25, 25, 25)
                .addComponent(newBookingFindSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 573, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newBookingAvailTitleTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        newBookingAvailablePanelLayout.setVerticalGroup(
            newBookingAvailablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingAvailablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingAvailTitleTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );

        newBookingFormPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        newBookingFormPanel.setMaximumSize(new java.awt.Dimension(9999, 9999));
        newBookingFormPanel.setMinimumSize(new java.awt.Dimension(340, 0));
        newBookingFormPanel.setPreferredSize(new java.awt.Dimension(340, 200));

        newBookingFormFirstLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormFirstLabel.setText("First Name*:");

        newBookingFormFirstTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormFirstTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormFirstTextFieldActionPerformed(evt);
            }
        });

        newBookingFormNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormNameLabel.setText("Family Name*:");

        newBookingFormNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormNOGLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormNOGLabel.setText("Number of Guests*:");

        newBookingFormNOGTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormCityLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormCityLabel.setText("City*:");

        newBookingFormPhoneTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormNatLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormNatLabel.setText("Nationality*: ");

        newBookingFormNatTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormStreetLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormStreetLabel.setText("Street*:");

        newBookingFormPhoneLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormPhoneLabel.setText("Phone*:");

        newBookingFormCityTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormStreetTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormCreateButton.setText("Create");
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

        newBookingFormADateLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormADateLabel.setText("Arrival Date:");

        newBookingFormNONLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormNONLabel.setText("Number of Nights:");

        newBookingFormRoomLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
                            .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newBookingFormNONLabel)
                                    .addComponent(newBookingFormRoomLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newBookingFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newBookingFormRoomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                                .addComponent(newBookingFormADateLabel)
                                .addGap(48, 48, 48)
                                .addComponent(newBookingFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        newBookingFormGreyPanelLayout.setVerticalGroup(
            newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormGreyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormADateLabel)
                    .addComponent(newBookingFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormNONLabel)
                    .addComponent(newBookingFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newBookingFormGreyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormRoomLabel)
                    .addComponent(newBookingFormRoomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel32.setText("*Required Fields");

        javax.swing.GroupLayout newBookingFormButtonPanelLayout = new javax.swing.GroupLayout(newBookingFormButtonPanel);
        newBookingFormButtonPanel.setLayout(newBookingFormButtonPanelLayout);
        newBookingFormButtonPanelLayout.setHorizontalGroup(
            newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                .addGroup(newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newBookingFormCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        newBookingFormButtonPanelLayout.setVerticalGroup(
            newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingFormGreyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newBookingFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormPreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        newBookingFormAgenLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormAgenLabel.setText("Agency:");

        newBookingFormAgenTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newBookingFormAgenTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBookingFormAgenTextFieldActionPerformed(evt);
            }
        });

        newBookingFormEmailLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newBookingFormEmailLabel.setText("Email*:");

        newBookingFormEmailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("ZipCode:");

        newBookingFormZipTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newBookingFormTitleTitle.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        newBookingFormTitleTitle.setText("Booking Form");

        javax.swing.GroupLayout newBookingFormPanelLayout = new javax.swing.GroupLayout(newBookingFormPanel);
        newBookingFormPanel.setLayout(newBookingFormPanelLayout);
        newBookingFormPanelLayout.setHorizontalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newBookingFormPhoneLabel)
                            .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newBookingFormPanelLayout.createSequentialGroup()
                                    .addComponent(newBookingFormNOGLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(newBookingFormNOGTextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newBookingFormPanelLayout.createSequentialGroup()
                                    .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newBookingFormNatLabel)
                                        .addComponent(jLabel1)
                                        .addComponent(newBookingFormAgenLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newBookingFormNatTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newBookingFormAgenTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newBookingFormPanelLayout.createSequentialGroup()
                                    .addComponent(newBookingFormNameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newBookingFormTitleTitle)
                                        .addComponent(newBookingFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                    .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookingFormPanelLayout.createSequentialGroup()
                                                .addComponent(newBookingFormEmailLabel)
                                                .addGap(51, 51, 51))
                                            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                                .addComponent(newBookingFormCityLabel)
                                                .addGap(62, 62, 62)))
                                        .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                                            .addComponent(newBookingFormStreetLabel)
                                            .addGap(49, 49, 49)))
                                    .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(newBookingFormCityTextField)
                                        .addComponent(newBookingFormEmailTextField)
                                        .addComponent(newBookingFormPhoneTextField)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                        .addComponent(newBookingFormFirstLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(newBookingFormButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        newBookingFormPanelLayout.setVerticalGroup(
            newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newBookingFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newBookingFormTitleTitle)
                .addGap(11, 11, 11)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormFirstLabel)
                    .addComponent(newBookingFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormNameLabel)
                    .addComponent(newBookingFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormNOGLabel)
                    .addComponent(newBookingFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormEmailLabel)
                    .addComponent(newBookingFormEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormCityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormStreetLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(newBookingFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormNatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormNatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBookingFormAgenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBookingFormAgenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(newBookingFormButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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
                .addGap(12, 12, 12)
                .addComponent(newBookingTitleTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newBookingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newBookingFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(newBookingFindPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(newBookingAvailablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPage.add(newBookingPanel, "card3");

        listBookingPanel.setMinimumSize(new java.awt.Dimension(1024, 720));

        menuOptionsjPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menuOptionsjPanel.setMaximumSize(new java.awt.Dimension(200, 32767));
        menuOptionsjPanel.setMinimumSize(new java.awt.Dimension(200, 100));
        menuOptionsjPanel.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel34.setText("Bookings Today");

        listBookingTodayjButton.setText("Show Today");
        listBookingTodayjButton.setMaximumSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.setMinimumSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.setPreferredSize(new java.awt.Dimension(120, 30));
        listBookingTodayjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingTodayjButtonActionPerformed(evt);
            }
        });

        jLabel35.setText("Search by months");

        listBookingDatejTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        listBookingDatejTextField1.setText("DD-MM-YY");
        listBookingDatejTextField1.setMinimumSize(new java.awt.Dimension(120, 30));
        listBookingDatejTextField1.setPreferredSize(new java.awt.Dimension(120, 30));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuOptionsjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuOptionsjPanelLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuOptionsjPanelLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(41, 41, 41))))
            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listBookingTodayjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listBookingDatejTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(menuOptionsjPanelLayout.createSequentialGroup()
                        .addGroup(menuOptionsjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listBookingBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listBookingSearchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        listBookingDrawingPanelLayout.setVerticalGroup(
            listBookingDrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        listBookingDisplayTypejLabel.setText("Display");

        listBookingRefreshjButton.setText("Refresh");
        listBookingRefreshjButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingRefreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingRefreshjButtonActionPerformed(evt);
            }
        });

        listBookingLastUpdatedjLabel.setText("last updated");

        listBookingPreviousListButton.setText("previous");
        listBookingPreviousListButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingPreviousListButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingPreviousListButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingPreviousListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingPreviousListButtonActionPerformed(evt);
            }
        });

        listBookingNextListButton.setText("Next");
        listBookingNextListButton.setMaximumSize(new java.awt.Dimension(100, 30));
        listBookingNextListButton.setMinimumSize(new java.awt.Dimension(100, 30));
        listBookingNextListButton.setPreferredSize(new java.awt.Dimension(100, 30));
        listBookingNextListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingNextListButtonActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(listBookingDisplayTypejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(listBookingLastUpdatedjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(listOptionjPanelLayout.createSequentialGroup()
                        .addComponent(listBookingPreviousListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listBookingNextListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(listBookingPreviousListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listBookingNextListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Booking nr:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Date:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Room nr:");

        jLabel27.setText("1. Enter Search Criterias in fields below.");

        jLabel28.setText("2. Press \"Find\" and select Booking required.");

        jLabel29.setText("3. Edit/Delete as needed.");

        jLabel18.setText("All fields are optional, fill at least one.");

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
                                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)))
                            .addGroup(eBFindPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFindPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(eBFindBookingNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(eBFindPanelLayout.createSequentialGroup()
                                        .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(54, 54, 54)
                                        .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(eBFindDateTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(eBFindNameTextField)
                                            .addComponent(eBFindRoomNrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(eBFindPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFindPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(eBFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eBFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        eBFindPanelLayout.setVerticalGroup(
            eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eBFindTitleTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(eBFindBookingNRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(eBFindNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(eBFindDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(eBFindRoomNrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eBFindPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(eBFindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFindButtonBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBFindButtonFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jScrollPane2)
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

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Arrival Date*:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Number of nights*:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Apartment type*:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Apartment Number*:");

        eBFormCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double", "Family" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Booking Form");

        eBFormGrey.setMaximumSize(new java.awt.Dimension(456, 446));
        eBFormGrey.setMinimumSize(new java.awt.Dimension(456, 446));
        eBFormGrey.setPreferredSize(new java.awt.Dimension(456, 446));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("First name*:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Family name*:");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Number of guests*:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Phone*:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Email*:");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("City*:");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Street*:");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Zip Code*:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Country*:");

        jLabel30.setText("*Required Fields");

        javax.swing.GroupLayout eBFormGreyLayout = new javax.swing.GroupLayout(eBFormGrey);
        eBFormGrey.setLayout(eBFormGreyLayout);
        eBFormGreyLayout.setHorizontalGroup(
            eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormGreyLayout.createSequentialGroup()
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eBFormGreyLayout.createSequentialGroup()
                        .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22))
                        .addGap(26, 26, 26)
                        .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eBFormNatTextField)
                            .addComponent(eBFormZipTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormStreetTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormCityTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormEmailTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormPhoneTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormNOGTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(eBFormFirstTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel30))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        eBFormGreyLayout.setVerticalGroup(
            eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormGreyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(eBFormFirstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(eBFormNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(eBFormNOGTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(eBFormPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(eBFormEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(eBFormCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(eBFormStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(eBFormZipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormGreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(eBFormNatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout eBFormPanelLayout = new javax.swing.GroupLayout(eBFormPanel);
        eBFormPanel.setLayout(eBFormPanelLayout);
        eBFormPanelLayout.setHorizontalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel5))
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(eBFormCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 153, Short.MAX_VALUE)
                                    .addComponent(eBFormNONTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eBFormADateTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eBFormANRTextField))))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(eBFormPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBFormGrey, javax.swing.GroupLayout.PREFERRED_SIZE, 324, Short.MAX_VALUE)
                            .addGroup(eBFormPanelLayout.createSequentialGroup()
                                .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eBFormButtonCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        eBFormPanelLayout.setVerticalGroup(
            eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eBFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(eBFormADateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(eBFormNONTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(eBFormCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(eBFormANRTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(eBFormGrey, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(eBFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBFormButtonSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eBFormButtonCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(eBFindPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(eBMatchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(eBFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        mainPage.add(editBookingPanel, "card4");

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
        this.enableComponents(this.eBFormGrey, true);

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
        boolean status = controller.updateBooking(b, Integer.parseInt(this.eBFormANRTextField.getText()), this.eBFormADateTextField.getText(), Integer.parseInt(this.eBFormNONTextField.getText()), b.getPrice(), bcHM.get(b), this.eBFormFirstTextField.getText(), this.eBFormNameTextField.getText(), this.eBFormEmailTextField.getText(), this.eBFormPhoneTextField.getText(), this.eBFormNatTextField.getText(), this.eBFormCityTextField.getText(), this.eBFormZipTextField.getText(), this.eBFormStreetTextField.getText());
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
        this.enableComponents(this.eBFormGrey, false);
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

    private void newBookingFormAgenTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormAgenTextFieldActionPerformed
        //not supported
    }//GEN-LAST:event_newBookingFormAgenTextFieldActionPerformed

    private void newBookingFormNONTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormNONTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBookingFormNONTextFieldActionPerformed

    private void newBookingFormADateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormADateTextFieldActionPerformed
        //not supported
    }//GEN-LAST:event_newBookingFormADateTextFieldActionPerformed

    private void newBookingFormPreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormPreviousButtonActionPerformed
        // TODO add your handling code here:
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

    private void newBookingFormFirstTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBookingFormFirstTextFieldActionPerformed
        //not supported
    }//GEN-LAST:event_newBookingFormFirstTextFieldActionPerformed

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

        this.nBListModel.clear();

        int roomNr = 0;

        try {
            roomNr = Integer.parseInt(this.newBookingFindRoomNRTextField.getText());
        } catch (Exception e) {
            e.printStackTrace();
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
        ArrayList<Apartment> list = this.controller.getApartments();
        for (Apartment a : list) {
            this.lBlistModel.addElement(a);
        }
    }//GEN-LAST:event_listBookingPageButtonActionPerformed

    private void listBookingRefreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingRefreshjButtonActionPerformed
        this.listBookingLastUpdatedjLabel.setText("Updated 1 minute ago");


    }//GEN-LAST:event_listBookingRefreshjButtonActionPerformed

    private void listBookingPreviousListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingPreviousListButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listBookingPreviousListButtonActionPerformed

    private void listBookingNextListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingNextListButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listBookingNextListButtonActionPerformed

    private void listBookingTodayjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingTodayjButtonActionPerformed
        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawToday);
        this.listBookingDrawingPanel.repaint();
        this.drawToday.setVisible(true);
    }//GEN-LAST:event_listBookingTodayjButtonActionPerformed

    private void listBookingSearchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingSearchjButtonActionPerformed
        this.listBookingDrawingPanel.removeAll();
        this.listBookingDrawingPanel.add(this.drawMonth);
        this.listBookingDrawingPanel.repaint();
        this.drawMonth.setVisible(true);
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

    public void paintCalenderBorder(Graphics page) {
    }

    private void setFullScreenSettings() {
        isFullScreen = device.isFullScreenSupported();
        if (!System.getProperty("os.name").startsWith("Mac")) {
            dispose();
            setUndecorated(isFullScreen);
        }
        setResizable(!isFullScreen);
        if (isFullScreen) {
            device.setFullScreenWindow(this);
            validate();
        } else {
            pack();
            setVisible(true);
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
        this.eBFormCombo.setSelectedItem("");
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
    private javax.swing.JComboBox eBFormCombo;
    private javax.swing.JTextField eBFormEmailTextField;
    private javax.swing.JTextField eBFormFirstTextField;
    private javax.swing.JPanel eBFormGrey;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listBookingApartmentjList;
    private javax.swing.JButton listBookingBackButton;
    private javax.swing.JTextField listBookingDatejTextField1;
    private javax.swing.JLabel listBookingDisplayTypejLabel;
    private javax.swing.JPanel listBookingDrawingPanel;
    private javax.swing.JLabel listBookingLastUpdatedjLabel;
    private javax.swing.JButton listBookingNextListButton;
    private javax.swing.JButton listBookingPageButton;
    private javax.swing.JPanel listBookingPanel;
    private javax.swing.JButton listBookingPreviousListButton;
    private javax.swing.JButton listBookingRefreshjButton;
    private javax.swing.JButton listBookingSearchjButton;
    private javax.swing.JButton listBookingTodayjButton;
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
    private javax.swing.JLabel newBookingFindSearchFromLabel;
    private javax.swing.JTextField newBookingFindSearchFromTextField;
    private javax.swing.JLabel newBookingFindSearchNONLabel;
    private javax.swing.JTextField newBookingFindSearchNONTextField;
    private javax.swing.JPanel newBookingFindSearchPanel;
    private javax.swing.JComboBox newBookingFindSearchTypeComboBox;
    private javax.swing.JLabel newBookingFindSearchTypeLabel;
    private javax.swing.JLabel newBookingFindTitleTitle;
    private javax.swing.JLabel newBookingFormADateLabel;
    private javax.swing.JTextField newBookingFormADateTextField;
    private javax.swing.JLabel newBookingFormAgenLabel;
    private javax.swing.JTextField newBookingFormAgenTextField;
    private javax.swing.JPanel newBookingFormButtonPanel;
    private javax.swing.JLabel newBookingFormCityLabel;
    private javax.swing.JTextField newBookingFormCityTextField;
    private javax.swing.JButton newBookingFormCreateButton;
    private javax.swing.JLabel newBookingFormEmailLabel;
    private javax.swing.JTextField newBookingFormEmailTextField;
    private javax.swing.JLabel newBookingFormFirstLabel;
    private javax.swing.JTextField newBookingFormFirstTextField;
    private javax.swing.JPanel newBookingFormGreyPanel;
    private javax.swing.JLabel newBookingFormNOGLabel;
    private javax.swing.JTextField newBookingFormNOGTextField;
    private javax.swing.JLabel newBookingFormNONLabel;
    private javax.swing.JTextField newBookingFormNONTextField;
    private javax.swing.JLabel newBookingFormNameLabel;
    private javax.swing.JTextField newBookingFormNameTextField;
    private javax.swing.JLabel newBookingFormNatLabel;
    private javax.swing.JTextField newBookingFormNatTextField;
    private javax.swing.JPanel newBookingFormPanel;
    private javax.swing.JLabel newBookingFormPhoneLabel;
    private javax.swing.JTextField newBookingFormPhoneTextField;
    private javax.swing.JButton newBookingFormPreviousButton;
    private javax.swing.JLabel newBookingFormRoomLabel;
    private javax.swing.JTextField newBookingFormRoomTextField;
    private javax.swing.JLabel newBookingFormStreetLabel;
    private javax.swing.JTextField newBookingFormStreetTextField;
    private javax.swing.JLabel newBookingFormTitleTitle;
    private javax.swing.JTextField newBookingFormZipTextField;
    private javax.swing.JPanel newBookingPanel;
    private javax.swing.JLabel newBookingTitleTitle;
    // End of variables declaration//GEN-END:variables
}
