/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import ADMIN.Archived_Residents;
import bcirs.login_form;
import certs.Bgy_Clearance;
import certs.Bgy_Indigency;
import certs.Bgy_Residency;
import certs.Bgy_Senior;
import certs.Bgy_Solo_parent;
import config.PanelPrinter;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import enhancer.CenterCellRenderer;
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author SCC-COLLEGE
 */
public class User_Purok extends javax.swing.JFrame {
    
       DefaultListModel listModel = new DefaultListModel();
    
    /**
     * Creates new form admin_dashboard
     */
    public User_Purok() {
        initComponents(); 
         roundUPanel();
         roundUPanel1();
         roundUPanel2();
         roundUPanel3();
         displayData();
         purokCount();
        list.setModel(listModel);
        searchField.setBorder(new EmptyBorder(0, 10, 0, 0));
         DefaultTableModel model = (DefaultTableModel) userTbl.getModel();
        hname.setBorder(new EmptyBorder(0,10,0,0));
        address.setBorder(new EmptyBorder(0,10,0,0));
    }

    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    
    JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.home")));
    File selectedFile;
    Workbook workbook;
    Connection connect;

    public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT r.r_id, r.r_lname, r.r_fname, "
                     + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                     + "r.r_sex, h.h_name "
                     + "FROM tbl_residents r "
                     + "JOIN tbl_household h ON r.h_id = h.h_id "
                     + "WHERE r.r_status = 'Active' "
                     + "ORDER BY r.r_id DESC";
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

    
      private void roundUPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 20);
        rounded.setBounds(0, 0, 145, 130);
        
        tambis.setLayout(null); 
        tambis.add(rounded);
        tambis.repaint();
        tambis.revalidate();
       
  }
  
       private void roundUPanel1(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 20);
        rounded.setBounds(0, 0, 145, 130);
           
        mahogany.setLayout(null); 
        mahogany.add(rounded);
        mahogany.repaint();
        mahogany.revalidate();   
           
       }
   
       
         private void roundUPanel2(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 20);
        rounded.setBounds(0, 0, 145, 130);
           
         guyabano.setLayout(null); 
        guyabano.add(rounded);
        guyabano.repaint();
        guyabano.revalidate();
           
       } 
         
         
        private void roundUPanel3(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 20);
        rounded.setBounds(0, 0, 145, 130);
           
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
            "WHERE p.p_id = 1 and r.r_status = 'Active'";
    String queryMahogany = "SELECT COUNT(*) AS ttl_mC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 2 and r.r_status = 'Active'";
    String queryGuyabano = "SELECT COUNT(*) AS ttl_gC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 3 and r.r_status = 'Active'";
    String queryIpilIpil = "SELECT COUNT(*) AS ttl_iC FROM tbl_residents r " +
            "JOIN tbl_household h ON r.h_id = h.h_id " +
            "JOIN tbl_purok p ON h.p_id = p.p_id " +
            "WHERE p.p_id = 4 and r.r_status = 'Active'";
    

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

    public class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == 1 && value != null) { // Assuming h_id is in the second column (index 1)
                value = "HL" + value.toString();
                setText(value.toString());
            }

            return c;
        }
    }
    
             public void setDateAutomatically(Bgy_Solo_parent bsp) {
            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Format the day of the month
            int dayOfMonth = currentDate.getDayOfMonth();
            String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
            String dayString = dayOfMonth + dayOfMonthSuffix;

            // Format the month
            String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            // Format the year
            int year = currentDate.getYear();

            // Combine them into the desired format
            String formattedDate = dayString + " day of " + month + " " + year;

            // Set the date text field
            bsp.date.setText(formattedDate);
        }

        private String getDayOfMonthSuffix(final int day) {
            if (day >= 11 && day <= 13) {
                return "th";
            }
            switch (day % 10) {
                case 1: return "st";
                case 2: return "nd";
                case 3: return "rd";
                default: return "th";
            }
        }

    
        public void setDateAutomatically1(Bgy_Senior bs) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bs.date.setText(formattedDate);
       }

        public void setDateAutomatically2(Bgy_Clearance bc) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bc.date.setText(formattedDate);
       }
        
           public void setDateAutomatically3(Bgy_Indigency bi) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           bi.date.setText(formattedDate);
       }

          public void setDateAutomatically4(Bgy_Residency br) {
           // Get the current date
           LocalDate currentDate = LocalDate.now();

           // Format the day of the month
           int dayOfMonth = currentDate.getDayOfMonth();
           String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);
           String dayString = dayOfMonth + dayOfMonthSuffix;

           // Format the month
           String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

           // Format the year
           int year = currentDate.getYear();

           // Combine them into the desired format
           String formattedDate = dayString + " day of " + month + " " + year;

           // Set the date text field
           br.date.setText(formattedDate);
       }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        houseAdd = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cancel3 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        addHouse = new javax.swing.JButton();
        purok = new javax.swing.JComboBox<>();
        address = new javax.swing.JTextField();
        hname = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        popUp = new javax.swing.JPopupMenu();
        view = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        viewPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        household = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        ocu = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        address1 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        stats1 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        purok1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        exportData = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();
        a4 = new javax.swing.JLabel();
        viewPanel1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        id1 = new javax.swing.JLabel();
        imagePanel1 = new javax.swing.JPanel();
        image1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        cancel1 = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        household1 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        stats2 = new javax.swing.JLabel();
        ocu1 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        sex1 = new javax.swing.JLabel();
        dob1 = new javax.swing.JLabel();
        fullname1 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        address2 = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        stats3 = new javax.swing.JLabel();
        reg1 = new javax.swing.JLabel();
        type2 = new javax.swing.JLabel();
        purok2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dashPane = new javax.swing.JPanel();
        purokPane = new javax.swing.JPanel();
        reportsPane = new javax.swing.JPanel();
        logs = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logoff = new javax.swing.JPanel();
        logoffbg = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        settingsBg = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        settingsPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tambis = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tambisC = new javax.swing.JLabel();
        mahogany = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mahoganyC = new javax.swing.JLabel();
        guyabano = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        guyabanoC = new javax.swing.JLabel();
        ipil = new javax.swing.JPanel();
        ipilC = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        list = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        sa2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sa = new javax.swing.JLabel();

        houseAdd.setBackground(new java.awt.Color(255, 255, 255));
        houseAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        houseAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        houseAdd.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 480, 20));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(27, 57, 77));
        jLabel33.setText("Address");
        houseAdd.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 60, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(27, 57, 77));
        jLabel34.setText("Purok");
        houseAdd.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 70, 20));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(27, 57, 77));
        jLabel36.setText("Household");
        houseAdd.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 20));

        jPanel6.setBackground(new java.awt.Color(27, 57, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel3.setBackground(new java.awt.Color(255, 0, 0));
        cancel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel3.setForeground(new java.awt.Color(255, 255, 255));
        cancel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel3.setBorder(null);
        cancel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel3MouseExited(evt);
            }
        });
        cancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel3ActionPerformed(evt);
            }
        });
        jPanel6.add(cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 30, 30));

        jLabel37.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Register New Household");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        houseAdd.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        addHouse.setBackground(new java.awt.Color(27, 57, 77));
        addHouse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addHouse.setForeground(new java.awt.Color(255, 255, 255));
        addHouse.setText("Register");
        addHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouseActionPerformed(evt);
            }
        });
        houseAdd.add(addHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 30));

        purok.setBackground(new java.awt.Color(245, 246, 248));
        purok.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        purok.setForeground(new java.awt.Color(100, 115, 122));
        purok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Select", "Tambis", "Mahogany", "Guyabano", "Ipil-Ipil" }));
        purok.setBorder(null);
        purok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purokActionPerformed(evt);
            }
        });
        houseAdd.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 170, 24));

        address.setBackground(new java.awt.Color(245, 246, 248));
        address.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        address.setForeground(new java.awt.Color(100, 115, 122));
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        houseAdd.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 230, 24));

        hname.setBackground(new java.awt.Color(245, 246, 248));
        hname.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        hname.setForeground(new java.awt.Color(100, 115, 122));
        hname.setBorder(null);
        hname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hnameActionPerformed(evt);
            }
        });
        houseAdd.add(hname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, 24));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 55, 77));
        jLabel31.setText(" Household cannot be edited nor be deleted once registered.");
        houseAdd.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, 20));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(27, 55, 77));
        jLabel35.setText("Note: ");
        houseAdd.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a1.setText("*");
        houseAdd.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, 30));

        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a2.setText("*");
        houseAdd.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 140, 30));

        a3.setForeground(new java.awt.Color(255, 0, 0));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a3.setText("*");
        houseAdd.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 30));

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
        viewPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 10));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 57, 77));
        jLabel16.setText("Name:");
        viewPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 57, 77));
        jLabel17.setText("Address:");
        viewPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 57, 77));
        jLabel18.setText("Resident ID:");
        viewPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

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

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText(" View Resident Details");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel.setBorder(null);
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
        jPanel7.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        viewPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        household.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        household.setForeground(new java.awt.Color(27, 57, 77));
        household.setText("Id number");
        viewPanel.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 57, 77));
        jLabel20.setText("Purok:");
        viewPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setText("Civil Status:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        stats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats.setForeground(new java.awt.Color(27, 57, 77));
        stats.setText("Occupation:");
        jPanel4.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        ocu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ocu.setForeground(new java.awt.Color(27, 57, 77));
        ocu.setText("ocu");
        jPanel4.add(ocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, 20));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(27, 57, 77));
        jLabel22.setText("Age:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 20));

        sex.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sex.setForeground(new java.awt.Color(27, 57, 77));
        sex.setText("sex");
        jPanel4.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, 20));

        dob.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dob.setForeground(new java.awt.Color(27, 57, 77));
        dob.setText("User ID:");
        jPanel4.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 20));

        fullname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fullname.setForeground(new java.awt.Color(27, 57, 77));
        fullname.setText("User ID:");
        jPanel4.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 20));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(27, 57, 77));
        jLabel23.setText("Date of Birth:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        age.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(27, 57, 77));
        age.setText("age");
        jPanel4.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(27, 57, 77));
        jLabel24.setText("Sex:");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, 20));

        address1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address1.setForeground(new java.awt.Color(27, 57, 77));
        address1.setText("User ID:");
        jPanel4.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 20));

        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(27, 57, 77));
        status.setText("User ID:");
        jPanel4.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        stats1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats1.setForeground(new java.awt.Color(27, 57, 77));
        stats1.setText("Religion:");
        jPanel4.add(stats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 20));

        reg.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reg.setForeground(new java.awt.Color(27, 57, 77));
        reg.setText("reg");
        jPanel4.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, 20));

        viewPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 350, 170));

        type1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type1.setForeground(new java.awt.Color(27, 57, 77));
        type1.setText("User ID:");
        viewPanel.add(type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, 20));

        purok1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        purok1.setForeground(new java.awt.Color(27, 57, 77));
        purok1.setText("Purok");
        viewPanel.add(purok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(27, 57, 77));
        jLabel25.setText("House No:");
        viewPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 30));

        exportData.setBackground(new java.awt.Color(255, 255, 255));
        exportData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        exportData.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 320, 10));

        jPanel8.setBackground(new java.awt.Color(27, 57, 77));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users-alt.png"))); // NOI18N
        jLabel29.setText(" Residents Data");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 60));

        exportData.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 60));
        exportData.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 290, 30));

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Download reports as:");
        exportData.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 290, 30));

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(27, 57, 77));
        jLabel38.setText("File name:");
        exportData.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        pdf.setBackground(new java.awt.Color(255, 102, 102));
        pdf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pdf.setForeground(new java.awt.Color(255, 255, 255));
        pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file-pdf.png"))); // NOI18N
        pdf.setText(" PDF");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        exportData.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 110, 30));

        a4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 0, 0));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a4.setText("*");
        exportData.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 190, 20));

        viewPanel1.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        viewPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        viewPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 10));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(27, 57, 77));
        jLabel40.setText("Name:");
        viewPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 20));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(27, 57, 77));
        jLabel41.setText("Address:");
        viewPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 20));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(27, 57, 77));
        jLabel42.setText("Resident ID:");
        viewPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        id1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id1.setForeground(new java.awt.Color(27, 57, 77));
        id1.setText("Id number");
        viewPanel1.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, 30));

        imagePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        imagePanel1.add(image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        viewPanel1.add(imagePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 170));

        jPanel9.setBackground(new java.awt.Color(27, 57, 77));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText(" View Resident Details");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

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
        jPanel9.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        edit.setBackground(new java.awt.Color(27, 57, 77));
        edit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pencil.png"))); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel9.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 30, 30));

        viewPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        household1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        household1.setForeground(new java.awt.Color(27, 57, 77));
        household1.setText("Id number");
        viewPanel1.add(household1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 30));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(27, 57, 77));
        jLabel44.setText("Purok:");
        viewPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 30));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(27, 57, 77));
        jLabel45.setText("Civil Status:");
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        stats2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats2.setForeground(new java.awt.Color(27, 57, 77));
        stats2.setText("Occupation:");
        jPanel10.add(stats2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        ocu1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ocu1.setForeground(new java.awt.Color(27, 57, 77));
        ocu1.setText("ocu");
        jPanel10.add(ocu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, 20));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(27, 57, 77));
        jLabel46.setText("Age:");
        jPanel10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 20));

        sex1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sex1.setForeground(new java.awt.Color(27, 57, 77));
        sex1.setText("sex");
        jPanel10.add(sex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 70, 20));

        dob1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dob1.setForeground(new java.awt.Color(27, 57, 77));
        dob1.setText("User ID:");
        jPanel10.add(dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, 20));

        fullname1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fullname1.setForeground(new java.awt.Color(27, 57, 77));
        fullname1.setText("User ID:");
        jPanel10.add(fullname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 20));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(27, 57, 77));
        jLabel47.setText("Date of Birth:");
        jPanel10.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        age1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age1.setForeground(new java.awt.Color(27, 57, 77));
        age1.setText("age");
        jPanel10.add(age1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(27, 57, 77));
        jLabel48.setText("Sex:");
        jPanel10.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, 20));

        address2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address2.setForeground(new java.awt.Color(27, 57, 77));
        address2.setText("User ID:");
        jPanel10.add(address2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 20));

        status1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status1.setForeground(new java.awt.Color(27, 57, 77));
        status1.setText("User ID:");
        jPanel10.add(status1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        stats3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats3.setForeground(new java.awt.Color(27, 57, 77));
        stats3.setText("Religion:");
        jPanel10.add(stats3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 20));

        reg1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reg1.setForeground(new java.awt.Color(27, 57, 77));
        reg1.setText("reg");
        jPanel10.add(reg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, 20));

        viewPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 350, 170));

        type2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type2.setForeground(new java.awt.Color(27, 57, 77));
        type2.setText("User ID:");
        viewPanel1.add(type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, 20));

        purok2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        purok2.setForeground(new java.awt.Color(27, 57, 77));
        purok2.setText("Purok");
        viewPanel1.add(purok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 30));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(27, 57, 77));
        jLabel49.setText("House No:");
        viewPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 30));

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

        dashC.setBackground(new java.awt.Color(255, 255, 255));
        dashC.addMouseListener(new java.awt.event.MouseAdapter() {
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dash_F.png"))); // NOI18N
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

        adm_nav.add(dashC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, -1));

        purokC.setBackground(new java.awt.Color(255, 255, 255));
        purokC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purokCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purokCMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 55, 77));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house-building.png"))); // NOI18N
        jLabel6.setText(" Purok");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
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
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        purokCLayout.setVerticalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purokCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adm_nav.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 393, 179, -1));

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

        adm_nav.add(dashPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

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

        adm_nav.add(purokPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        reportsPane.setBackground(new java.awt.Color(255, 255, 255));
        reportsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout reportsPaneLayout = new javax.swing.GroupLayout(reportsPane);
        reportsPane.setLayout(reportsPaneLayout);
        reportsPaneLayout.setHorizontalGroup(
            reportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        reportsPaneLayout.setVerticalGroup(
            reportsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(reportsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder-open (1).png"))); // NOI18N
        jLabel9.setText(" Reports");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logsLayout.setVerticalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

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

        adm_nav.add(logoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

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

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

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
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings (4).png"))); // NOI18N
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

        adm_nav.add(settingsBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 140, -1));

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

        adm_nav.add(settingsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 10, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 55, 77));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mini_logo-removebg-preview (1).png"))); // NOI18N
        jLabel2.setText("Purok Link");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 12, 180, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambis.setBackground(new java.awt.Color(27, 57, 77));
        tambis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TAMBIS");
        tambis.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 145, -1));

        tambisC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tambisC.setForeground(new java.awt.Color(255, 255, 255));
        tambisC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambisC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        tambisC.setText(" 0");
        tambis.add(tambisC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 145, 58));

        jPanel2.add(tambis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 145, 130));

        mahogany.setBackground(new java.awt.Color(27, 57, 77));
        mahogany.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAHOGANY");
        mahogany.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 145, -1));

        mahoganyC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mahoganyC.setForeground(new java.awt.Color(255, 255, 255));
        mahoganyC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mahoganyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        mahoganyC.setText(" 0");
        mahogany.add(mahoganyC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 145, 47));

        jPanel2.add(mahogany, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 145, 130));

        guyabano.setBackground(new java.awt.Color(27, 57, 77));
        guyabano.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GUYABANO");
        guyabano.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 145, -1));

        guyabanoC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        guyabanoC.setForeground(new java.awt.Color(255, 255, 255));
        guyabanoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guyabanoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        guyabanoC.setText(" 0");
        guyabano.add(guyabanoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 145, 49));

        jPanel2.add(guyabano, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 145, 130));

        ipil.setBackground(new java.awt.Color(27, 57, 77));
        ipil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ipilC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ipilC.setForeground(new java.awt.Color(255, 255, 255));
        ipilC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipilC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        ipilC.setText(" 0");
        ipil.add(ipilC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 145, 48));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("IPIL-IPIL");
        ipil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 145, -1));

        jPanel2.add(ipil, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 145, 130));

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 270, 30));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/member-search.png"))); // NOI18N
        jLabel14.setText(" Search resident");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        list.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jLayeredPane1.add(list);
        list.setBounds(0, 0, 0, 0);

        jPanel3.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 270, 400));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 290, 490));

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
        jScrollPane2.setViewportView(userTbl);


        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 620, 310));

        sa2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa2.setForeground(new java.awt.Color(27, 55, 77));
        sa2.setText("All Residents ");
        jPanel2.add(sa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 50));

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Import residents");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 145, 30));

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add resident");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 145, 30));

        jButton4.setBackground(new java.awt.Color(27, 55, 77));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText(" Archived Residents");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 145, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(190, 50, 980, 510);

        sa.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa.setForeground(new java.awt.Color(27, 55, 77));
        sa.setText("Purok Data");
        jPanel1.add(sa);
        sa.setBounds(210, 0, 130, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
        dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashCMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
       // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
      //  purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
     
          try{
          dbConnector dbc = new dbConnector();
           ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'");
           
           if(rs.next()){
               
                String code = rs.getString("u_code");
                if(code.equals("")){
                    dot.setText("•");
                }else{
                     dot.setText("");
                }
           }
           
           }catch(SQLException ex){
                 System.out.println(""+ex);
         
        }
              
       }
    }//GEN-LAST:event_formWindowActivated

    private void dashPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseEntered
        dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashPaneMouseEntered

    private void dashPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashPaneMouseExited

    private void purokPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseEntered
        purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokPaneMouseEntered

    private void purokPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseExited
        purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokPaneMouseExited

    private void reportsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsPaneMouseEntered

    private void reportsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsPaneMouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        User_Reports ur = new User_Reports();
        ur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        reportsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        reportsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        
    }//GEN-LAST:event_logsMouseClicked

    private void logsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseEntered
         reportsPane.setBackground(Panecolor);
    }//GEN-LAST:event_logsMouseEntered

    private void logsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseExited
        reportsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_logsMouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
     // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
    //  purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void logoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseEntered

    private void logoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        login_form ads = new login_form();

        JOptionPane.showMessageDialog(null,"Log out successfully!");
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        user_dashboard uds = new user_dashboard();
        uds.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
         dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
         dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        User_Settings as = new User_Settings();
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

    private void cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseClicked

    }//GEN-LAST:event_cancel3MouseClicked

    private void cancel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseEntered

    }//GEN-LAST:event_cancel3MouseEntered

    private void cancel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseExited

    }//GEN-LAST:event_cancel3MouseExited

    private void cancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel3ActionPerformed

        Window window = SwingUtilities.getWindowAncestor(houseAdd);
        window.dispose();

    }//GEN-LAST:event_cancel3ActionPerformed

    private void addHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHouseActionPerformed

       Session sess = Session.getInstance();
        
        int userID = sess.getUid();
       
        a1.setText("");
        a2.setText("");
        a3.setText("");

        if(hname.getText().isEmpty() || address.getText().isEmpty() || purok.getSelectedIndex() == 0){
            if (hname.getText().isEmpty()) {
                a1.setText("*");
            }
            if (address.getText().isEmpty()) {
                a2.setText("*");
            }
            if (purok.getSelectedIndex() == 0) {
                a3.setText("*");
            }
        } else {
            dbConnector dbc = new dbConnector();

            try {
               
                String query = "INSERT INTO tbl_household (h_name, h_address, p_id) VALUES (?, ?, ?)";
                PreparedStatement pst = dbc.connect.prepareStatement(query);

                
                pst.setString(1, hname.getText());
                pst.setString(2, address.getText());
                pst.setInt(3, purok.getSelectedIndex());

               
                int rowsInserted = pst.executeUpdate(); 

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Household Registered Successfully!");

                   logEvent(userID, "NEW_HOUSEHOLD", "Household: "+hname.getText()+" is added by user.");
                    
                    Window window = SwingUtilities.getWindowAncestor(houseAdd);
                    window.dispose();
                    
                    hname.setText("");
                    address.setText("");
                    purok.setSelectedIndex(0);
                    
                    
                    
                    displayData();
                    purokCount();
                } else {
                    JOptionPane.showMessageDialog(null, "Error registering household.");
                }

              
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Database Error: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_addHouseActionPerformed

    private void purokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purokActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void hnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hnameActionPerformed

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed

    }//GEN-LAST:event_searchFieldMousePressed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased

        listModel.removeAllElements();

        if (!searchField.getText().isEmpty()) {
            list.setSize(270, 400);

            dbConnector dbc = new dbConnector();

            try (PreparedStatement pst = dbc.connect.prepareStatement("SELECT r_lname, r_fname, r_mname FROM tbl_residents WHERE CONCAT(r_lname, ' ', r_fname, ' ', r_mname) LIKE ?"
                + "AND (r_status = 'Active')")){

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

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTblMouseClicked

    private void userTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(userTbl, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_userTblMousePressed

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
                fullname.setText(rs.getString("r_fname") + " " + rs.getString("r_mname") + " " + rs.getString("r_lname"));
                address.setText(rs.getString("r_address"));
                dob.setText(rs.getString("r_dob"));
                age.setText(rs.getString("r_age"));
                status.setText(rs.getString("r_civilstatus"));
                sex.setText(rs.getString("r_sex"));
                ocu.setText(rs.getString("r_occupation"));
                reg.setText(rs.getString("r_religion"));
                household.setText(rs.getString("h_name"));
                purok1.setText(rs.getString("p_name"));
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

                User_Residents_Update uru = new User_Residents_Update();

                uru.image.setIcon(resizedIcon);

                uru.id.setText(rs.getString("r_id"));
                uru.ln.setText(rs.getString("r_lname"));
                uru.fn.setText(rs.getString("r_fname"));
                uru.mn.setText(rs.getString("r_mname"));
                uru.address.setText(rs.getString("r_address"));
                uru.ACCOUNT_NAME.setText(rs.getString("r_fname") + " " + rs.getString("r_lname"));
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

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered

    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited

    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        Window window = SwingUtilities.getWindowAncestor(viewPanel);
        window.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed

    }//GEN-LAST:event_pdfActionPerformed

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseExited

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(viewPanel1);
        window.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        dbConnector dbc = new dbConnector();
        String rid = id1.getText();

        try{

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

                User_Residents_Update uru = new User_Residents_Update();

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

                // Populate the JComboBox and set the selected item
                uru.populateHouseholdComboBox(uru.household);

                String hName = rs.getString("h_name");
                uru.household.setSelectedItem(hName);

                Window window = SwingUtilities.getWindowAncestor(viewPanel1);
                window.dispose();
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
    }//GEN-LAST:event_editActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Session sess = Session.getInstance();

    int userID = sess.getUid();

    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        selectedFile = fileChooser.getSelectedFile();

    dbConnector dbc = new dbConnector();

    try {
        workbook = new XSSFWorkbook(selectedFile);
        Sheet sheet = workbook.getSheetAt(0);
        int newResidentsCount = 0;

        try (PreparedStatement pst = dbc.connect.prepareStatement(
                "INSERT INTO tbl_residents(r_lname, r_fname, r_mname, r_address, r_sex, r_dob, "
                + "r_civilstatus, r_occupation, r_religion, h_id, r_image, r_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
                Statement.RETURN_GENERATED_KEYS)) {

            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next(); 
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            while (iterator.hasNext()) {
                Row row = iterator.next();

                for (int i = 0; i < 9; i++) {
                    if (row.getCell(i) == null) {
                        System.out.println("Cell " + i + " in row " + row.getRowNum() + " is null.");
                    }
                }

                pst.setString(1, row.getCell(0).getStringCellValue());
                pst.setString(2, row.getCell(1).getStringCellValue());
                pst.setString(3, row.getCell(2).getStringCellValue());
                pst.setString(4, row.getCell(3).getStringCellValue());
                pst.setString(5, row.getCell(4).getStringCellValue());

                java.util.Date date = row.getCell(5).getDateCellValue();
                String formattedDate = dateFormat.format(date);
                pst.setString(6, formattedDate);

                pst.setString(7, row.getCell(6).getStringCellValue());
                pst.setString(8, row.getCell(7).getStringCellValue());
                pst.setString(9, row.getCell(8).getStringCellValue());
                pst.setDouble(10, row.getCell(9).getNumericCellValue());
                pst.setString(11, "src/u_default/blank_pfp.jpg");
                pst.setString(12, "Active");

                pst.executeUpdate();
                newResidentsCount++;

                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int newResidentId = generatedKeys.getInt(1);
                    logEvent(userID, "IMPORT_NEW_RESIDENT", "Resident ID: " + newResidentId + " is added by user.");
                }
            }

            String updateQuery = "UPDATE tbl_barangay SET b_population = b_population + ? WHERE b_id = ?";
            PreparedStatement updatePst = dbc.connect.prepareStatement(updateQuery);
            updatePst.setInt(1, newResidentsCount);
            updatePst.setInt(2, 1001); 
            updatePst.executeUpdate();
            updatePst.close();

            JOptionPane.showMessageDialog(null, "Successfully Imported!");
            displayData();
        } catch (Exception e) {
            System.out.println(e);
        }
    } catch (IOException | InvalidFormatException e) {
        System.out.println(e);
    }
    }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
            String fullName = list.getSelectedValue();

        if (fullName == null || fullName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No name selected. Please select a name from the list.");
            return;
        }

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

        String query = "SELECT r.*, h.h_name, p.p_name, "
        + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age "
        + "FROM tbl_residents r "
        + "LEFT JOIN tbl_household h ON r.h_id = h.h_id "
        + "JOIN tbl_purok p ON h.p_id = p.p_id "
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
                image1.setIcon(resizedIcon);

                id1.setText(rs.getString("r_id"));
                fullname1.setText(rs.getString("r_lname") + " " + rs.getString("r_fname") + " " + rs.getString("r_mname"));
                address1.setText(rs.getString("r_address"));
                dob1.setText(rs.getString("r_dob"));
                age1.setText(rs.getString("r_age"));
                status1.setText(rs.getString("r_civilstatus"));
                sex1.setText(rs.getString("r_sex"));
                ocu1.setText(rs.getString("r_occupation"));
                reg1.setText(rs.getString("r_religion"));
                household1.setText(rs.getString("h_name"));
                purok1.setText(rs.getString("p_name"));
            }

            Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, viewPanel1);
            dialog.setVisible(true);

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_listMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        User_Residents_Add as = new User_Residents_Add();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Archived_Residents as = new Archived_Residents();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(User_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Purok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Purok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JButton addHouse;
    public javax.swing.JTextField address;
    private javax.swing.JLabel address1;
    private javax.swing.JLabel address2;
    private javax.swing.JPanel adm_nav;
    private javax.swing.JLabel age;
    private javax.swing.JLabel age1;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel1;
    public javax.swing.JButton cancel3;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel dob1;
    private javax.swing.JLabel dot;
    private javax.swing.JButton edit;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JPanel exportData;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel fullname1;
    private javax.swing.JPanel guyabano;
    private javax.swing.JLabel guyabanoC;
    public javax.swing.JTextField hname;
    private javax.swing.JPanel houseAdd;
    private javax.swing.JLabel household;
    private javax.swing.JLabel household1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id1;
    public javax.swing.JLabel image;
    public javax.swing.JLabel image1;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagePanel1;
    private javax.swing.JPanel ipil;
    private javax.swing.JLabel ipilC;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel mahogany;
    private javax.swing.JLabel mahoganyC;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel ocu;
    private javax.swing.JLabel ocu1;
    private javax.swing.JButton pdf;
    private javax.swing.JPopupMenu popUp;
    public javax.swing.JComboBox<String> purok;
    private javax.swing.JLabel purok1;
    private javax.swing.JLabel purok2;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JLabel reg;
    private javax.swing.JLabel reg1;
    private javax.swing.JPanel reportsPane;
    private javax.swing.JLabel sa;
    private javax.swing.JLabel sa2;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel sex1;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel stats1;
    private javax.swing.JLabel stats2;
    private javax.swing.JLabel stats3;
    private javax.swing.JLabel status;
    private javax.swing.JLabel status1;
    private javax.swing.JPanel tambis;
    private javax.swing.JLabel tambisC;
    private javax.swing.JLabel type1;
    private javax.swing.JLabel type2;
    private javax.swing.JTable userTbl;
    private javax.swing.JMenuItem view;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JPanel viewPanel1;
    // End of variables declaration//GEN-END:variables
}
