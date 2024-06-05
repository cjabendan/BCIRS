/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import bcirs.login_form;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import enhancer.CenterCellRenderer;
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import java.awt.Color;
import java.awt.Window;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SCC-COLLEGE
 */
public class User_Purok extends javax.swing.JFrame {

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
        hname.setBorder(new EmptyBorder(0,10,0,0));
        address.setBorder(new EmptyBorder(0,10,0,0));
    }

    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    
    public void displayData() {
     try {
         dbConnector dbc = new dbConnector();
         String query = "SELECT p.p_name, h.h_name, h.h_address, COUNT(r.r_id) AS total_residents " +
                        "FROM tbl_purok p " +
                        "JOIN tbl_household h ON p.p_id = h.p_id " +
                        "LEFT JOIN tbl_residents r ON h.h_id = r.h_id " +
                        "GROUP BY p.p_name, h.h_name, h.h_address " +
                        "ORDER BY h.h_id DESC";

         ResultSet rs = dbc.getData(query);
         house.setModel(DbUtils.resultSetToTableModel(rs));

         JTableHeader th = house.getTableHeader();
         TableColumnModel tcm = th.getColumnModel();

         TableColumn tc0 = tcm.getColumn(0); 
         TableColumn tc1 = tcm.getColumn(1); 
         TableColumn tc2 = tcm.getColumn(2);
         TableColumn tc3 = tcm.getColumn(3);

         tc0.setHeaderValue("Purok");
         tc1.setHeaderValue("Household");
         tc2.setHeaderValue("Address");
         tc3.setHeaderValue("Total Residents");

         
        th.setDefaultRenderer(new CustomHeaderRenderer());
        tc0.setCellRenderer(new CenterCellRenderer());
        tc1.setCellRenderer(new CenterCellRenderer());
        tc2.setCellRenderer(new CenterCellRenderer());
        tc3.setCellRenderer(new CenterCellRenderer());
        
         rs.close();
     } catch (SQLException ex) {
         System.out.println("Errors: " + ex.getMessage());
     }
}


    
      private void roundUPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 130, 130);
        
        tambis.setLayout(null); 
        tambis.add(rounded);
        tambis.repaint();
        tambis.revalidate();
       
  }
  
       private void roundUPanel1(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 130, 130);
           
        mahogany.setLayout(null); 
        mahogany.add(rounded);
        mahogany.repaint();
        mahogany.revalidate();   
           
       }
   
       
         private void roundUPanel2(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 130, 130);
           
         guyabano.setLayout(null); 
        guyabano.add(rounded);
        guyabano.repaint();
        guyabano.revalidate();
           
       } 
         
         
        private void roundUPanel3(){
       
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 30);
        rounded.setBounds(0, 0, 130, 130);
           
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
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dashPane = new javax.swing.JPanel();
        citizenPane = new javax.swing.JPanel();
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
        adm_header = new javax.swing.JPanel();
        sa = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        tambis = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tambisC = new javax.swing.JLabel();
        mahogany = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mahoganyC = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        guyabano = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        guyabanoC = new javax.swing.JLabel();
        ipil = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ipilC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        house = new javax.swing.JTable();
        sa1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        houseAdd.setBackground(new java.awt.Color(255, 255, 255));
        houseAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        houseAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        houseAdd.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 480, 20));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(27, 57, 77));
        jLabel33.setText("Address:");
        houseAdd.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 60, 20));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(27, 57, 77));
        jLabel34.setText("Purok:");
        houseAdd.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 70, 20));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(27, 57, 77));
        jLabel36.setText("Household:");
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

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 55, 77));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo_32PX.png"))); // NOI18N
        jLabel2.setText("ARQUISTATS");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 18, -1, 45));

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

        adm_nav.add(dashC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, -1));

        viewC.setBackground(new java.awt.Color(255, 255, 255));
        viewC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewCMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_nF.png"))); // NOI18N
        jLabel5.setText(" Residents");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewCLayout.setVerticalGroup(
            viewCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, -1));

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

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

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

        citizenPane.setBackground(new java.awt.Color(255, 255, 255));
        citizenPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                citizenPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                citizenPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout citizenPaneLayout = new javax.swing.GroupLayout(citizenPane);
        citizenPane.setLayout(citizenPaneLayout);
        citizenPaneLayout.setHorizontalGroup(
            citizenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        citizenPaneLayout.setVerticalGroup(
            citizenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(citizenPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

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

        adm_nav.add(purokPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

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

        adm_nav.add(reportsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

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

        adm_nav.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

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

        adm_nav.add(logoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

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

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

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

        adm_nav.add(settingsBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 140, -1));

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

        adm_nav.add(settingsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 10, -1));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 450);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sa.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa.setForeground(new java.awt.Color(27, 55, 77));
        sa.setText("Purok");
        adm_header.add(sa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 130, 60));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 730, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambis.setBackground(new java.awt.Color(27, 57, 77));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TAMBIS");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Resident");

        tambisC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tambisC.setForeground(new java.awt.Color(255, 255, 255));
        tambisC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambisC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        tambisC.setText(" 0");

        javax.swing.GroupLayout tambisLayout = new javax.swing.GroupLayout(tambis);
        tambis.setLayout(tambisLayout);
        tambisLayout.setHorizontalGroup(
            tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(tambisLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambisC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        tambisLayout.setVerticalGroup(
            tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addGroup(tambisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambisLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tambisC, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(tambis, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 130, 130));

        mahogany.setBackground(new java.awt.Color(27, 57, 77));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAHOGANY");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Resident");

        mahoganyC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mahoganyC.setForeground(new java.awt.Color(255, 255, 255));
        mahoganyC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mahoganyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        mahoganyC.setText(" 0");

        javax.swing.GroupLayout mahoganyLayout = new javax.swing.GroupLayout(mahogany);
        mahogany.setLayout(mahoganyLayout);
        mahoganyLayout.setHorizontalGroup(
            mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mahoganyLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mahoganyC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mahoganyLayout.setVerticalGroup(
            mahoganyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mahoganyLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(mahoganyC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(mahogany, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 130, 130));

        jButton7.setBackground(new java.awt.Color(27, 57, 77));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus (1).png"))); // NOI18N
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(27, 57, 77), 2, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 20, 20));

        guyabano.setBackground(new java.awt.Color(27, 57, 77));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GUYABANO");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Resident");

        guyabanoC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        guyabanoC.setForeground(new java.awt.Color(255, 255, 255));
        guyabanoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guyabanoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        guyabanoC.setText(" 0");

        javax.swing.GroupLayout guyabanoLayout = new javax.swing.GroupLayout(guyabano);
        guyabano.setLayout(guyabanoLayout);
        guyabanoLayout.setHorizontalGroup(
            guyabanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(guyabanoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(guyabanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guyabanoC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        guyabanoLayout.setVerticalGroup(
            guyabanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guyabanoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addComponent(guyabanoC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(guyabano, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 130, 130));

        ipil.setBackground(new java.awt.Color(27, 57, 77));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("IPIL-IPIL");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Resident");

        ipilC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ipilC.setForeground(new java.awt.Color(255, 255, 255));
        ipilC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipilC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users (2).png"))); // NOI18N
        ipilC.setText(" 0");

        javax.swing.GroupLayout ipilLayout = new javax.swing.GroupLayout(ipil);
        ipil.setLayout(ipilLayout);
        ipilLayout.setHorizontalGroup(
            ipilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ipilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(ipilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ipilC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ipilLayout.setVerticalGroup(
            ipilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ipilLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addComponent(ipilC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(ipil, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 130, 130));

        house.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(house);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 400, 150));

        sa1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        sa1.setForeground(new java.awt.Color(27, 55, 77));
        sa1.setText("Household");
        jPanel2.add(sa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, 60));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Building-rafiki (1) (1).png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 270, 220));

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane1);
        jDesktopPane1.setBounds(180, 60, 720, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        citizenPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        citizenPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

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

    private void citizenPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citizenPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_citizenPaneMouseEntered

    private void citizenPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citizenPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_citizenPaneMouseExited

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

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
       citizenPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
      citizenPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       User_Residents up = new User_Residents();
       up.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, houseAdd);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
    private javax.swing.JButton addHouse;
    public javax.swing.JTextField address;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    public javax.swing.JButton cancel3;
    private javax.swing.JPanel citizenPane;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    private javax.swing.JLabel dot;
    private javax.swing.JPanel guyabano;
    private javax.swing.JLabel guyabanoC;
    public javax.swing.JTextField hname;
    public javax.swing.JTable house;
    private javax.swing.JPanel houseAdd;
    private javax.swing.JPanel ipil;
    private javax.swing.JLabel ipilC;
    private javax.swing.JButton jButton7;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel mahogany;
    private javax.swing.JLabel mahoganyC;
    public javax.swing.JComboBox<String> purok;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JPanel reportsPane;
    private javax.swing.JLabel sa;
    private javax.swing.JLabel sa1;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JPanel tambis;
    private javax.swing.JLabel tambisC;
    private javax.swing.JPanel viewC;
    // End of variables declaration//GEN-END:variables
}
