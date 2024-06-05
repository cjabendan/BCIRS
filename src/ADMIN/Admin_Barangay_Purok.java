/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import USERS.User_Residents;
import USERS.User_Residents_Update;
import bcirs.login_form;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SCC-COLLEGE
 */
public class Admin_Barangay_Purok extends javax.swing.JFrame {

    
     DefaultListModel listModel = new DefaultListModel();
    
    /**
     * Creates new form admin_dashboard
     */
    public Admin_Barangay_Purok() {
        initComponents();
        list.setModel(listModel);
        searchField.setBorder(new EmptyBorder(0, 10, 0, 0));
        DefaultTableModel model = (DefaultTableModel) userTbl.getModel();
        displayData();
        purokCount();
         roundUPanel();
         roundUPanel1();
         roundUPanel2();
         roundUPanel3();
    }
    
    
    public void displayData() {
        
    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT r.r_id, r.r_lname, r.r_fname, "
                     + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                     + "r.r_sex, h.h_name "
                     + "FROM tbl_residents r "
                     + "JOIN tbl_household h ON r.h_id = h.h_id";
        ResultSet rs = dbc.getData(query);
        userTbl.setModel(DbUtils.resultSetToTableModel(rs));

        JTableHeader th = userTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc0 = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
        TableColumn tc4 = tcm.getColumn(4);
        TableColumn tc5 = tcm.getColumn(5);

        tc0.setHeaderValue("ID");
        tc1.setHeaderValue("Last Name");
        tc2.setHeaderValue("First Name");
        tc3.setHeaderValue("Age");
        tc4.setHeaderValue("Sex");
        tc5.setHeaderValue("Household");

      
        th.setDefaultRenderer(new CustomHeaderRenderer());
        th.repaint();

        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
    
          public ImageIcon resizeImage(ImageIcon originalIcon, int targetWidth, int targetHeight) {
        Image originalImage = originalIcon.getImage();

        // Calculate the appropriate height based on the aspect ratio
        int newHeight = getHeightFromWidth(originalImage, targetWidth);

        // Create a new BufferedImage with the desired dimensions
        BufferedImage resizedImage = new BufferedImage(targetWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        // Get the graphics context of the resized image
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, targetWidth, newHeight, null);

        // Convert the resized BufferedImage back to an ImageIcon
        return new ImageIcon(resizedImage);
}

// Function to calculate height from width maintaining aspect ratio
    public int getHeightFromWidth(Image image, int desiredWidth) {
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        return (int) ((double) desiredWidth / originalWidth * originalHeight);
    }

  
    
    
      private void roundUPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 15);
        rounded.setBounds(0, 0, 130, 80);
        
        tambis.setLayout(null); 
        tambis.add(rounded);
        tambis.repaint();
        tambis.revalidate();
       
  }
  
       private void roundUPanel1(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 15);
        rounded.setBounds(0, 0, 130, 80);
           
        mahogany.setLayout(null); 
        mahogany.add(rounded);
        mahogany.repaint();
        mahogany.revalidate();   
           
       }
   
       
         private void roundUPanel2(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 15);
        rounded.setBounds(0, 0, 130, 80);
           
         guyabano.setLayout(null); 
        guyabano.add(rounded);
        guyabano.repaint();
        guyabano.revalidate();
           
       } 
         
         
        private void roundUPanel3(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 15);
        rounded.setBounds(0, 0, 130, 80);
           
        ipil.setLayout(null); 
        ipil.add(rounded);
        ipil.repaint();
        ipil.revalidate();
        
           
       } 
        
       private void purokCount() {
           
    try {
        dbConnector dbc = new dbConnector();
     
   
    String queryTambis = "SELECT COUNT(*) AS ttl_tC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 1";
    String queryMahogany = "SELECT COUNT(*) AS ttl_mC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 2";
    String queryGuyabano = "SELECT COUNT(*) AS ttl_gC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 3";
    String queryIpilIpil = "SELECT COUNT(*) AS ttl_iC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 4";
    

        ResultSet rs1 = dbc.getData(queryTambis);
        ResultSet rs2 = dbc.getData(queryMahogany);
        ResultSet rs3 = dbc.getData(queryGuyabano);
        ResultSet rs4 = dbc.getData(queryIpilIpil);

        if (rs1.next()) {
            int totalt = rs1.getInt("ttl_tC");
            tambisC.setText(" "+ totalt);
        }

         if (rs2.next()) {
            int totalm = rs2.getInt("ttl_mC");
            mahoganyC.setText(" "+ totalm);
        }
         
         
         if (rs3.next()) {
            int totalg = rs3.getInt("ttl_gC");
            guyabanoC.setText(" "+ totalg);
        }
         
          if (rs4.next()) {
            int totali = rs4.getInt("ttl_iC");
            ipilC.setText(" "+ totali);
        }
              
        rs1.close();
        rs2.close();
        rs3.close();
        rs4.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

      
    Color Red = new Color(255,0,0);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    
    public void populateHouseholdComboBox(JComboBox<String> householdComboBox) {
    try {
        dbConnector dbc = new dbConnector();
        ResultSet rsHousehold = dbc.getData("SELECT h_name FROM tbl_household");

        Vector<String> householdNames = new Vector<>();
        householdNames.add("Select household");

        while (rsHousehold.next()) {
            householdNames.add(rsHousehold.getString("h_name"));
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(householdNames);
        householdComboBox.setModel(model);

        rsHousehold.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUp = new javax.swing.JPopupMenu();
        view = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        viewPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cancel1 = new javax.swing.JButton();
        household = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        ocu = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        stats1 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        purok = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dashPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        viewPane = new javax.swing.JPanel();
        purokPane = new javax.swing.JPanel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        logoff = new javax.swing.JPanel();
        logoffbg = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logsPane = new javax.swing.JPanel();
        settingsBg = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        settingsPane = new javax.swing.JPanel();
        mainDk = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        tambis = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tambisC = new javax.swing.JLabel();
        mahogany = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mahoganyC = new javax.swing.JLabel();
        guyabano = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        guyabanoC = new javax.swing.JLabel();
        ipil = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ipilC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        sa1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        list = new javax.swing.JList<>();
        searchField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();

        view.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye (1).png"))); // NOI18N
        view.setText(" View Data");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        popUp.add(view);

        editItem.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        editItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pen-circle (1).png"))); // NOI18N
        editItem.setText(" Edit Data");
        editItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemActionPerformed(evt);
            }
        });
        popUp.add(editItem);

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        viewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        viewPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 10));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 57, 77));
        jLabel12.setText("Name:");
        viewPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 57, 77));
        jLabel13.setText("Address:");
        viewPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 57, 77));
        jLabel14.setText("Resident ID:");
        viewPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(27, 57, 77));
        id.setText("Id number");
        viewPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, 30));

        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        imagePanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        viewPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 170));

        jPanel7.setBackground(new java.awt.Color(27, 57, 77));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(" View Resident Details");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        cancel1.setBackground(new java.awt.Color(255, 0, 0));
        cancel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel1.setForeground(new java.awt.Color(255, 255, 255));
        cancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel1.setBorder(null);
        cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel1MouseExited(evt);
            }
        });
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        jPanel7.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        viewPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        household.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        household.setForeground(new java.awt.Color(27, 57, 77));
        household.setText("Id number");
        viewPanel.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 57, 77));
        jLabel19.setText("Purok:");
        viewPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 57, 77));
        jLabel16.setText("Civil Status:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        stats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats.setForeground(new java.awt.Color(27, 57, 77));
        stats.setText("Occupation:");
        jPanel5.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        ocu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ocu.setForeground(new java.awt.Color(27, 57, 77));
        ocu.setText("ocu");
        jPanel5.add(ocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 57, 77));
        jLabel20.setText("Age:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 20));

        sex.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sex.setForeground(new java.awt.Color(27, 57, 77));
        sex.setText("sex");
        jPanel5.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, 20));

        dob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(27, 57, 77));
        dob.setText("User ID:");
        jPanel5.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 20));

        fullname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fullname.setForeground(new java.awt.Color(27, 57, 77));
        fullname.setText("User ID:");
        jPanel5.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 57, 77));
        jLabel17.setText("Date of Birth:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        age.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(27, 57, 77));
        age.setText("age");
        jPanel5.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 57, 77));
        jLabel18.setText("Sex:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, 20));

        address.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(27, 57, 77));
        address.setText("User ID:");
        jPanel5.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 20));

        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(27, 57, 77));
        status.setText("User ID:");
        jPanel5.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        stats1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats1.setForeground(new java.awt.Color(27, 57, 77));
        stats1.setText("Religion:");
        jPanel5.add(stats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 20));

        reg.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reg.setForeground(new java.awt.Color(27, 57, 77));
        reg.setText("reg");
        jPanel5.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, 20));

        viewPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 350, 170));

        type1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type1.setForeground(new java.awt.Color(27, 57, 77));
        type1.setText("User ID:");
        viewPanel.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, 20));

        purok.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        purok.setForeground(new java.awt.Color(27, 57, 77));
        purok.setText("Purok");
        viewPanel.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setText("House No:");
        viewPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 30));

        print.setBackground(new java.awt.Color(27, 57, 77));
        print.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Document Request");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        viewPanel.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 150, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        adm_nav.setBackground(new java.awt.Color(255, 255, 255));
        adm_nav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235), 2));
        adm_nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adm_nav.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 2, -1, 446));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 55, 77));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo_32PX.png"))); // NOI18N
        jLabel2.setText(" ARQUSTATS");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 180, 45));

        dashPane.setBackground(new java.awt.Color(255, 255, 255));
        dashPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout dashPaneLayout = new javax.swing.GroupLayout(dashPane);
        dashPane.setLayout(dashPaneLayout);
        dashPaneLayout.setHorizontalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        dashPaneLayout.setVerticalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(dashPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        dashC.setBackground(new java.awt.Color(255, 255, 255));
        dashC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashCMouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 55, 77));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dash_nF.png"))); // NOI18N
        jLabel3.setText(" Dashboard");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout dashCLayout = new javax.swing.GroupLayout(dashC);
        dashC.setLayout(dashCLayout);
        dashCLayout.setHorizontalGroup(
            dashCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashCLayout.setVerticalGroup(
            dashCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(dashC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 147, -1));

        viewC.setBackground(new java.awt.Color(255, 255, 255));
        viewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewCMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (4).png"))); // NOI18N
        jLabel5.setText(" Users");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout viewCLayout = new javax.swing.GroupLayout(viewC);
        viewC.setLayout(viewCLayout);
        viewCLayout.setHorizontalGroup(
            viewCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewCLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        viewCLayout.setVerticalGroup(
            viewCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        viewPane.setBackground(new java.awt.Color(255, 255, 255));
        viewPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout viewPaneLayout = new javax.swing.GroupLayout(viewPane);
        viewPane.setLayout(viewPaneLayout);
        viewPaneLayout.setHorizontalGroup(
            viewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        viewPaneLayout.setVerticalGroup(
            viewPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(viewPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        purokPane.setBackground(new java.awt.Color(27, 57, 77));
        purokPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purokPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purokPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout purokPaneLayout = new javax.swing.GroupLayout(purokPane);
        purokPane.setLayout(purokPaneLayout);
        purokPaneLayout.setHorizontalGroup(
            purokPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        purokPaneLayout.setVerticalGroup(
            purokPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(purokPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        purokC.setBackground(new java.awt.Color(255, 255, 255));
        purokC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purokCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purokCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purokCMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 55, 77));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house-building.png"))); // NOI18N
        jLabel6.setText(" Barangay");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout purokCLayout = new javax.swing.GroupLayout(purokC);
        purokC.setLayout(purokCLayout);
        purokCLayout.setHorizontalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purokCLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        purokCLayout.setVerticalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purokCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        logoff.setBackground(new java.awt.Color(255, 255, 255));
        logoff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoffMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffLayout = new javax.swing.GroupLayout(logoff);
        logoff.setLayout(logoffLayout);
        logoffLayout.setHorizontalGroup(
            logoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        logoffLayout.setVerticalGroup(
            logoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(logoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        logoffbg.setBackground(new java.awt.Color(255, 255, 255));
        logoffbg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoffbgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoffbgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoffbgMouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(57, 55, 77));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit (3).png"))); // NOI18N
        jLabel28.setText(" Log out");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffbgLayout = new javax.swing.GroupLayout(logoffbg);
        logoffbg.setLayout(logoffbgLayout);
        logoffbgLayout.setHorizontalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoffbgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logoffbgLayout.setVerticalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoffbgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        logs.setBackground(new java.awt.Color(255, 255, 255));
        logs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(57, 55, 77));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder-open.png"))); // NOI18N
        jLabel9.setText("  Logs");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logsLayout = new javax.swing.GroupLayout(logs);
        logs.setLayout(logsLayout);
        logsLayout.setHorizontalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logsLayout.setVerticalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        logsPane.setBackground(new java.awt.Color(255, 255, 255));
        logsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logsPaneLayout = new javax.swing.GroupLayout(logsPane);
        logsPane.setLayout(logsPaneLayout);
        logsPaneLayout.setHorizontalGroup(
            logsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        logsPaneLayout.setVerticalGroup(
            logsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(logsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        settingsBg.setBackground(new java.awt.Color(255, 255, 255));
        settingsBg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBgMouseExited(evt);
            }
        });
        settingsBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(57, 55, 77));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings (3).png"))); // NOI18N
        jLabel27.setText(" Settings");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        settingsBg.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 96, 38));

        dot.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dot.setForeground(new java.awt.Color(255, 0, 0));
        settingsBg.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 40, 20));

        adm_nav.add(settingsBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, -1));

        settingsPane.setBackground(new java.awt.Color(255, 255, 255));
        settingsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout settingsPaneLayout = new javax.swing.GroupLayout(settingsPane);
        settingsPane.setLayout(settingsPaneLayout);
        settingsPaneLayout.setHorizontalGroup(
            settingsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        settingsPaneLayout.setVerticalGroup(
            settingsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(settingsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 10, -1));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 450);

        mainDk.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambis.setBackground(new java.awt.Color(27, 57, 77));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TAMBIS");

        tambisC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tambisC.setForeground(new java.awt.Color(255, 255, 255));
        tambisC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambisC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        tambisC.setText(" 0");

        javax.swing.GroupLayout tambisLayout = new javax.swing.GroupLayout(tambis);
        tambis.setLayout(tambisLayout);
        tambisLayout.setHorizontalGroup(
            tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(tambisC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tambisLayout.setVerticalGroup(
            tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambisC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(tambis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 80));

        mahogany.setBackground(new java.awt.Color(27, 57, 77));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MAHOGANY");

        mahoganyC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mahoganyC.setForeground(new java.awt.Color(255, 255, 255));
        mahoganyC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mahoganyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        mahoganyC.setText(" 0");

        javax.swing.GroupLayout mahoganyLayout = new javax.swing.GroupLayout(mahogany);
        mahogany.setLayout(mahoganyLayout);
        mahoganyLayout.setHorizontalGroup(
            mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahoganyLayout.createSequentialGroup()
                .addGroup(mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(mahoganyC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mahoganyLayout.setVerticalGroup(
            mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahoganyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mahoganyC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(mahogany, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 130, 80));

        guyabano.setBackground(new java.awt.Color(27, 57, 77));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GUYABANO");

        guyabanoC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        guyabanoC.setForeground(new java.awt.Color(255, 255, 255));
        guyabanoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guyabanoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        guyabanoC.setText(" 0");

        javax.swing.GroupLayout guyabanoLayout = new javax.swing.GroupLayout(guyabano);
        guyabano.setLayout(guyabanoLayout);
        guyabanoLayout.setHorizontalGroup(
            guyabanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(guyabanoC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        guyabanoLayout.setVerticalGroup(
            guyabanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guyabanoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guyabanoC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(guyabano, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 130, 80));

        ipil.setBackground(new java.awt.Color(27, 57, 77));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IPIL-IPIL");

        ipilC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ipilC.setForeground(new java.awt.Color(255, 255, 255));
        ipilC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipilC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        ipilC.setText(" 0");

        javax.swing.GroupLayout ipilLayout = new javax.swing.GroupLayout(ipil);
        ipil.setLayout(ipilLayout);
        ipilLayout.setHorizontalGroup(
            ipilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(ipilC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ipilLayout.setVerticalGroup(
            ipilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ipilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipilC, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(ipil, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 130, 80));

        userTbl.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        userTbl.setGridColor(new java.awt.Color(136, 136, 136));
        userTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTblMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTblMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(userTbl);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png")));

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 450, 220));

        sa1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa1.setForeground(new java.awt.Color(27, 55, 77));
        sa1.setText("Residents");
        jPanel2.add(sa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 50));

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listMousePressed(evt);
            }
        });
        jLayeredPane1.add(list);
        list.setBounds(0, 0, 0, 0);

        jPanel3.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 130));

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchField.setHighlighter(null);
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchFieldMousePressed(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 30));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/member-search.png"))); // NOI18N
        jLabel22.setText(" Search resident");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 220, 220));

        mainDk.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainDkLayout = new javax.swing.GroupLayout(mainDk);
        mainDk.setLayout(mainDkLayout);
        mainDkLayout.setHorizontalGroup(
            mainDkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainDkLayout.setVerticalGroup(
            mainDkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(mainDk);
        mainDk.setBounds(180, 60, 720, 360);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Barangay, Pob. Ward II ");
        adm_header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 200, 60));

        cancel.setBackground(new java.awt.Color(27, 55, 77));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/undo-alt.png"))); // NOI18N
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        adm_header.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 30, 30));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 730, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseEntered
      dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashPaneMouseEntered

    private void dashPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseExited
      dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashPaneMouseExited

    private void viewPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseEntered

    private void viewPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
       dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        
    }//GEN-LAST:event_dashCMouseExited

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void purokPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseEntered
     //   purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokPaneMouseEntered

    private void purokPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseExited
    //    purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokPaneMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
        // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
      //   purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked
       Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewCMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
          viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
          viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       //Admin_Barangay ab = new Admin_Barangay();
      // ab.setVisible(true);
      // this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
       // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
       //  purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
            try {
             dbConnector dbc = new dbConnector();
             ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + sess.getUid() + "'");
            
             
             if (rs.next()) {
                 String code = rs.getString("u_code");

                 if (code.equals("")) {
                     dot.setText("•");
                 } else {
                     dot.setText("");
                 }
             }

             rs.close();
            
         } catch (SQLException ex) {
             System.out.println("Errors: " + ex.getMessage());
         }
         
       }
       
    }//GEN-LAST:event_formWindowActivated

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void purokCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseClicked
     //  Admin_Barangay ab = new Admin_Barangay();
     //  ab.setVisible(true);
    //   this.dispose();
    }//GEN-LAST:event_purokCMouseClicked

    private void logoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseEntered

    private void logoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Session sess = Session.getInstance();
        
        int userId = sess.getUid();
        
        logEvent(userId, "LOGOUT", "User logged out");

       
        login_form ads = new login_form();
        JOptionPane.showMessageDialog(null, "Log out successfully!");
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel28MouseExited

    private void logoffbgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffbgMouseClicked

    private void logoffbgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_logoffbgMouseEntered

    private void logoffbgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_logoffbgMouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Admin_Logs al = new Admin_Logs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        logsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        logsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        Admin_Logs al = new Admin_Logs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void logsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseEntered
        logsPane.setBackground(Panecolor);
    }//GEN-LAST:event_logsMouseEntered

    private void logsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseExited
        logsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_logsMouseExited

    private void logsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logsPaneMouseEntered

    private void logsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logsPaneMouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        Admin_Settings as = new Admin_Settings();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        settingsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        settingsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel27MouseExited

    private void settingsBgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsBgMouseClicked

    private void settingsBgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseEntered
        settingsPane.setBackground(Panecolor);
    }//GEN-LAST:event_settingsBgMouseEntered

    private void settingsBgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBgMouseExited
        settingsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_settingsBgMouseExited

    private void settingsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsPaneMouseEntered

    private void settingsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsPaneMouseExited

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTblMouseClicked

    private void userTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(userTbl, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_userTblMousePressed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        Admin_Barangay ab = new Admin_Barangay();
        ab.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_cancelActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed

        String rid = userTbl.getValueAt(userTbl.getSelectedRow(), 0).toString();

        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT r.*, h.h_name, p.p_name, "
            + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age "
            + "FROM tbl_residents r "
            + "JOIN tbl_household h ON r.h_id = h.h_id "
            + "JOIN tbl_purok p ON h.p_id = p.p_id "
            + "WHERE r.r_id = ?";
            PreparedStatement pst = dbc.connect.prepareStatement(query);
            pst.setString(1, rid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);
                image.setIcon(resizedIcon);

                id.setText(rs.getString("r_id"));
                fullname.setText(rs.getString("r_lname") + ", " + rs.getString("r_fname") + ", " + rs.getString("r_mname"));
                address.setText(rs.getString("r_address"));
                dob.setText(rs.getString("r_dob"));
                age.setText(rs.getString("r_age"));
                status.setText(rs.getString("r_civilstatus"));
                sex.setText(rs.getString("r_sex"));
                ocu.setText(rs.getString("r_occupation"));
                reg.setText(rs.getString("r_religion"));
                household.setText(rs.getString("h_name"));
                purok.setText(rs.getString("p_name"));
            }
            
            Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, viewPanel);
            dialog.setVisible(true);

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_viewActionPerformed

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed

        try {
            String rid = userTbl.getValueAt(userTbl.getSelectedRow(), 0).toString();

            dbConnector dbc = new dbConnector();
            String query = "SELECT r.*, h.h_name, p.p_name, "
            + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age "
            + "FROM tbl_residents r "
            + "JOIN tbl_household h ON r.h_id = h.h_id "
            + "JOIN tbl_purok p ON h.p_id = p.p_id "
            + "WHERE r.r_id = ?";

            PreparedStatement pst = dbc.connect.prepareStatement(query);
            pst.setString(1, rid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

                Admin_Residents_Update uru = new Admin_Residents_Update();

                uru.image.setIcon(resizedIcon);

                uru.id.setText(rs.getString("r_id"));
                uru.ln.setText(rs.getString("r_lname"));
                uru.fn.setText(rs.getString("r_fname"));
                uru.mn.setText(rs.getString("r_mname"));
                uru.address.setText(rs.getString("r_address"));

                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("r_dob"));
                uru.dob.setDate(date);

                uru.status.setSelectedItem(rs.getString("r_civilstatus"));
                uru.sex.setSelectedItem(rs.getString("r_sex"));
                uru.occupation.setText(rs.getString("r_occupation"));
                uru.religion.setText(rs.getString("r_religion"));

               
                uru.populateHouseholdComboBox(uru.household);

                String hName = rs.getString("h_name");
                uru.household.setSelectedItem(hName);

                uru.setVisible(true);
                this.dispose();
            }

            rs.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(User_Residents.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editItemActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

    }//GEN-LAST:event_printActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
       
         String fullName = list.getSelectedValue();
        String[] nameParts = fullName.split(",\\s*");

       
        if (nameParts.length != 3) {
            JOptionPane.showMessageDialog(null, "Invalid name format. The name should be in 'Lastname, Firstname, Middlename' format.");
            return;
        }

        String lastName = nameParts[0].trim();
        String firstName = nameParts[1].trim();
        String middleName = nameParts[2].trim();

       
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);

        dbConnector dbc = new dbConnector();

        String query = "SELECT r.*, h.h_name FROM tbl_residents r "
                     + "LEFT JOIN tbl_household h ON r.h_id = h.h_id "
                     + "WHERE r_fname = ? AND r_mname = ? AND r_lname = ?";

        try (PreparedStatement pst = dbc.connect.prepareStatement(query)) {
            pst.setString(1, firstName);
            pst.setString(2, middleName);
            pst.setString(3, lastName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

                Admin_Residents_Update uru = new Admin_Residents_Update();

                uru.image.setIcon(resizedIcon);
                uru.id.setText(rs.getString("r_id"));
                uru.ln.setText(rs.getString("r_lname"));
                uru.fn.setText(rs.getString("r_fname"));
                uru.mn.setText(rs.getString("r_mname"));
                uru.address.setText(rs.getString("r_address"));

                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("r_dob"));
                uru.dob.setDate(date);

                uru.status.setSelectedItem(rs.getString("r_civilstatus"));
                uru.sex.setSelectedItem(rs.getString("r_sex"));
                uru.occupation.setText(rs.getString("r_occupation"));
                uru.religion.setText(rs.getString("r_religion"));

              
                uru.populateHouseholdComboBox(uru.household);

                String hName = rs.getString("h_name");
                uru.household.setSelectedItem(hName);

                uru.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the selected name.");
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(User_Residents.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_listMouseClicked

    private void listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMousePressed

        String fullName = list.getSelectedValue();
        String[] nameParts = fullName.split(",\\s*");

        
        if (nameParts.length != 3) {
            JOptionPane.showMessageDialog(null, "Invalid name format. The name should be in 'Lastname, Firstname, Middlename' format.");
            return;
        }

        String lastName = nameParts[0].trim();
        String firstName = nameParts[1].trim();
        String middleName = nameParts[2].trim();

        
        System.out.println("First Name: " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name: " + lastName);

        dbConnector dbc = new dbConnector();

        String query = "SELECT r.*, h.h_name FROM tbl_residents r "
        + "LEFT JOIN tbl_household h ON r.h_id = h.h_id "
        + "WHERE r_fname = ? AND r_mname = ? AND r_lname = ?";

        try (PreparedStatement pst = dbc.connect.prepareStatement(query)) {
            pst.setString(1, firstName);
            pst.setString(2, middleName);
            pst.setString(3, lastName);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String imagePath = rs.getString("r_image");
                ImageIcon originalIcon = new ImageIcon(imagePath);
                ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

                Admin_Residents_Update uru = new Admin_Residents_Update();

                uru.image.setIcon(resizedIcon);
                uru.id.setText(rs.getString("r_id"));
                uru.ln.setText(rs.getString("r_lname"));
                uru.fn.setText(rs.getString("r_fname"));
                uru.mn.setText(rs.getString("r_mname"));
                uru.address.setText(rs.getString("r_address"));

                java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("r_dob"));
                uru.dob.setDate(date);

                uru.status.setSelectedItem(rs.getString("r_civilstatus"));
                uru.sex.setSelectedItem(rs.getString("r_sex"));
                uru.occupation.setText(rs.getString("r_occupation"));
                uru.religion.setText(rs.getString("r_religion"));

               
                uru.populateHouseholdComboBox(uru.household);

                String hName = rs.getString("h_name");
                uru.household.setSelectedItem(hName);

                uru.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the selected name.");
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(User_Residents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listMousePressed

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed

    }//GEN-LAST:event_searchFieldMousePressed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased

        listModel.removeAllElements();

        if (!searchField.getText().isEmpty()) {
            list.setSize(200, 130);

            dbConnector dbc = new dbConnector();

            try (PreparedStatement pst = dbc.connect.prepareStatement("SELECT r_lname, r_fname, r_mname FROM tbl_residents WHERE CONCAT(r_lname, ' ', r_fname, ' ', r_mname) LIKE ?")) {
                String name = searchField.getText();
                pst.setString(1, "%" + name + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String fullName = rs.getString("r_lname") + ", " + rs.getString("r_fname") + ", " + rs.getString("r_mname");
                    listModel.addElement(fullName);
                }

            } catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }

        } else {
            list.setSize(200, 0);
        }

    }//GEN-LAST:event_searchFieldKeyReleased

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked

    }//GEN-LAST:event_cancel1MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered

    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited

    }//GEN-LAST:event_cancel1MouseExited

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed

        Window window = SwingUtilities.getWindowAncestor(viewPanel);
        window.dispose();

    }//GEN-LAST:event_cancel1ActionPerformed

      public void logEvent(int userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
        pstmt.setString(2, event);
        pstmt.setInt(3, userId);
        pstmt.setString(4, description);

        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
      
    }
}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Barangay_Purok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    private javax.swing.JLabel age;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel1;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel dot;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JLabel fullname;
    private javax.swing.JPanel guyabano;
    private javax.swing.JLabel guyabanoC;
    private javax.swing.JLabel household;
    private javax.swing.JLabel id;
    public javax.swing.JLabel image;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel ipil;
    private javax.swing.JLabel ipilC;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel logsPane;
    private javax.swing.JPanel mahogany;
    private javax.swing.JLabel mahoganyC;
    public javax.swing.JDesktopPane mainDk;
    private javax.swing.JLabel ocu;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JButton print;
    private javax.swing.JLabel purok;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JLabel reg;
    private javax.swing.JLabel sa1;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel stats1;
    private javax.swing.JLabel status;
    private javax.swing.JPanel tambis;
    private javax.swing.JLabel tambisC;
    private javax.swing.JLabel type1;
    private javax.swing.JTable userTbl;
    private javax.swing.JMenuItem view;
    private javax.swing.JPanel viewC;
    private javax.swing.JPanel viewPane;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
