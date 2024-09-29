
package ADMIN;

import bcirs.login_form;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.PanelPrinter;
import config.Session;
import config.dbConnector;
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import enhancer.StatusCellRenderer;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author SCC-COLLEGE
 */
public class Admin_RegUsers extends javax.swing.JFrame {

DefaultListModel listModel = new DefaultListModel();

    public Admin_RegUsers() {
        initComponents();
        displayData();
        list.setModel(listModel);
        searchField.setBorder(new EmptyBorder(0,10,0,0));
        DefaultTableModel model = (DefaultTableModel) userTbl.getModel();
    }
 
   public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT u_id, u_fname, u_lname, u_type, u_status FROM tbl_user WHERE u_status IN ('Active', 'Pending')";
        ResultSet rs = dbc.getData(query);
        userTbl.setModel(DbUtils.resultSetToTableModel(rs));
        
        JTableHeader th = userTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        
        TableColumn tc = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
        TableColumn tc4 = tcm.getColumn(4);
        
        tc.setHeaderValue("ID");
        tc1.setHeaderValue("First Name");
        tc2.setHeaderValue("Last Name");
        tc3.setHeaderValue("Roles");
        tc4.setHeaderValue("Status");
        
        // Apply the custom renderer to the status column
        tc4.setCellRenderer(new StatusCellRenderer());
        th.setDefaultRenderer(new CustomHeaderRenderer());

        
        
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}


    
   
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    Color G = new Color(0,245,39);
    Color O = new Color(255,202,51);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    
   public ImageIcon resizeImage(ImageIcon originalIcon, int targetWidth, int targetHeight) {
        Image originalImage = originalIcon.getImage();

        
        int newHeight = getHeightFromWidth(originalImage, targetWidth);

        
        BufferedImage resizedImage = new BufferedImage(targetWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, targetWidth, newHeight, null);

        
        return new ImageIcon(resizedImage);
}


    public int getHeightFromWidth(Image image, int desiredWidth) {
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        return (int) ((double) desiredWidth / originalWidth * originalHeight);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUp = new javax.swing.JPopupMenu();
        view = new javax.swing.JMenuItem();
        editItem = new javax.swing.JMenuItem();
        viewPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        umail = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        exportData = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cancel1 = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();
        a1 = new javax.swing.JLabel();
        excel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dashPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        viewPane = new javax.swing.JPanel();
        purokPane = new javax.swing.JPanel();
        purokC = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        logsPane = new javax.swing.JPanel();
        logoff = new javax.swing.JPanel();
        logoffbg = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        settingsBg = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        settingsPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        export = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        list = new javax.swing.JList<>();
        searchField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 57, 77));
        jLabel4.setText("Status:");
        viewPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 80, 20));
        viewPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 470, 20));

        stats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats.setForeground(new java.awt.Color(27, 57, 77));
        stats.setText("User ID:");
        viewPanel.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 70, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(27, 57, 77));
        jLabel9.setText("Name:");
        viewPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 60, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 57, 77));
        jLabel10.setText("User:");
        viewPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 57, 77));
        jLabel11.setText("Email:");
        viewPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 60, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 57, 77));
        jLabel12.setText("User ID:");
        viewPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 50, 20));

        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(27, 57, 77));
        id.setText("Id number");
        viewPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        fullname.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fullname.setForeground(new java.awt.Color(27, 57, 77));
        fullname.setText("User ID:");
        viewPanel.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 170, 20));

        username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        username.setForeground(new java.awt.Color(27, 57, 77));
        username.setText("User ID:");
        viewPanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 170, 20));

        umail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        umail.setForeground(new java.awt.Color(27, 57, 77));
        umail.setText("User ID:");
        viewPanel.add(umail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 170, 20));

        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        imagePanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        viewPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 170));

        jPanel5.setBackground(new java.awt.Color(27, 57, 77));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 30, 30));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" View User Details");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        viewPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 57, 77));
        jLabel15.setText("Role:");
        viewPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 80, 20));

        type.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        type.setForeground(new java.awt.Color(27, 57, 77));
        type.setText("User ID:");
        viewPanel.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 70, 20));

        print.setBackground(new java.awt.Color(27, 57, 77));
        print.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file-download.png"))); // NOI18N
        print.setText(" EXPORT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        viewPanel.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 120, 30));

        exportData.setBackground(new java.awt.Color(255, 255, 255));
        exportData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        exportData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        exportData.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 470, 10));

        jPanel6.setBackground(new java.awt.Color(27, 57, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText(" System Users Data");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 50));

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
        jPanel6.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 30, 30));

        exportData.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, -1));
        exportData.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 290, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Download reports as:");
        exportData.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 290, 40));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 57, 77));
        jLabel18.setText("File name:");
        exportData.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 20));

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
        exportData.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 110, 30));

        a1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a1.setText("*");
        exportData.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 190, 20));

        excel.setBackground(new java.awt.Color(38, 154, 56));
        excel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excel.setForeground(new java.awt.Color(255, 255, 255));
        excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/file-pdf.png"))); // NOI18N
        excel.setText(" EXCEL");
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        exportData.add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 110, 30));

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
        adm_nav.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 2, -1, 446));

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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png"))); // NOI18N
        jLabel5.setText(" Users");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
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

        viewPane.setBackground(new java.awt.Color(27, 55, 77));
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

        purokPane.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel6.setForeground(new java.awt.Color(27, 55, 77));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/barangay_nF.png"))); // NOI18N
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
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        purokCLayout.setVerticalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purokCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

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

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(57, 55, 77));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder-open.png"))); // NOI18N
        jLabel13.setText("  Logs");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logsLayout = new javax.swing.GroupLayout(logs);
        logs.setLayout(logsLayout);
        logsLayout.setHorizontalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logsLayout.setVerticalGroup(
            logsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(57, 55, 77));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit (3).png"))); // NOI18N
        logout.setText(" Log out");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffbgLayout = new javax.swing.GroupLayout(logoffbg);
        logoffbg.setLayout(logoffbgLayout);
        logoffbgLayout.setHorizontalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoffbgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logoffbgLayout.setVerticalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoffbgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

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

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 55, 77));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mini_logo-removebg-preview (1).png"))); // NOI18N
        jLabel2.setText("PurokSync");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 12, 180, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 55, 77));
        jLabel19.setText(" Registered users");
        adm_header.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 60));

        jButton2.setBackground(new java.awt.Color(27, 57, 77));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/box.png"))); // NOI18N
        jButton2.setText(" View Archived Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        adm_header.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 170, 30));

        export.setBackground(new java.awt.Color(27, 57, 77));
        export.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        export.setForeground(new java.awt.Color(255, 255, 255));
        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cloud-download-alt.png"))); // NOI18N
        export.setText(" Export all users data");
        export.setBorder(null);
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        adm_header.add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 270, 30));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, -10, 990, 70);

        userTbl.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 60, 650, 480);

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listMousePressed(evt);
            }
        });
        jLayeredPane1.add(list);
        list.setBounds(0, 0, 0, 0);

        jPanel3.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 390));

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
        jPanel3.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 30));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/member-search.png"))); // NOI18N
        jLabel8.setText(" Search user");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(870, 60, 270, 480);

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

    private void dashPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseEntered
      dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashPaneMouseEntered

    private void dashPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPaneMouseExited
      dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
       dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_dashCMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        admin_dashboard ads = new admin_dashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked
        admin_dashboard ads = new admin_dashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
         dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void viewPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseExited

    private void viewPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
        purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
        purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void purokPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseExited
        purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokPaneMouseExited

    private void purokPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseEntered
        purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokPaneMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited

    }//GEN-LAST:event_viewCMouseExited

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
  
    }//GEN-LAST:event_viewCMouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
      purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
       Admin_Barangay ab = new Admin_Barangay();
       ab.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void purokCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseClicked
        
       Admin_Barangay ab = new Admin_Barangay();
       ab.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_purokCMouseClicked

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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void userTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMousePressed
           if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(userTbl, evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_userTblMousePressed

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTblMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
     
        String uid = userTbl.getValueAt(userTbl.getSelectedRow(), 0).toString();

        try {
             dbConnector dbc = new dbConnector();
             TableModel tbl = userTbl.getModel();
             ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + uid + "'");

             if (rs.next()) {
           
              String imagePath = rs.getString("u_image");

              ImageIcon originalIcon = new ImageIcon(imagePath);
              
              ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

              image.setIcon(resizedIcon);

              id.setText(rs.getString("u_id"));
              fullname.setText(rs.getString("u_fname") + " " + rs.getString("u_lname"));
              username.setText(rs.getString("u_usn"));
              umail.setText(rs.getString("u_email"));
              type.setText(rs.getString("u_type"));
              
              String as = rs.getString("u_status");
              if(as.equals("Active")){
                  stats.setForeground(G);
                  stats.setText(""+as);
              }else{
                  stats.setForeground(O);
                  stats.setText(""+as);
              }
              
             }
         
                        
            Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, viewPanel);
            dialog.setVisible(true);

          
            }catch(SQLException ex){
                System.out.println(""+ex);
            }                    
          
    }//GEN-LAST:event_viewActionPerformed

    private void editItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemActionPerformed
        
        int rowIndex = userTbl.getSelectedRow();
        
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select an item.");
        }else{
           
            try{
                dbConnector dbc = new dbConnector();
                TableModel tbl = userTbl.getModel();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+tbl.getValueAt(rowIndex, 0)+"'");
            
                if(rs.next()){
                    
                     Admin_RegUsers_Update ru = new Admin_RegUsers_Update();
                     ru.uID.setText(""+rs.getInt("u_id"));
                     ru.fn.setText(""+rs.getString("u_fname"));
                     ru.ln.setText(""+rs.getString("u_lname"));
                     ru.usn.setText(""+rs.getString("u_usn"));
                     ru.mail.setText(""+rs.getString("u_email"));
                     ru.ut.setSelectedItem(""+rs.getString("u_type"));
                     ru.st.setSelectedItem(""+rs.getString("u_status"));
                     ru.ACCOUNT_NAME.setText(rs.getString("u_fname") + " " + rs.getString("u_lname"));
                     ru.image.setIcon(ru.ResizeImage(rs.getString("u_image"), null, ru.image));
                     ru.oldpath = rs.getString("u_image");
                     ru.path = rs.getString("u_image");
                     ru.destination = rs.getString("u_image");
                     ru.setVisible(true);
                     this.dispose();
                
                if(rs.getString("u_image").isEmpty()){
                    ru.addProfile.setText(" Add profile");
                    ru.remove.setEnabled(false);
                }
            }
                 
            }catch(SQLException ex){
                System.out.println(""+ex);
            }                
        }      
        
         
    }//GEN-LAST:event_editItemActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
       
      listModel.removeAllElements();

        if(!searchField.getText().equals("")){
            list.setSize(250,390);

            dbConnector dbc = new dbConnector();

            try(PreparedStatement pst = dbc.connect.prepareStatement("SELECT * FROM tbl_user WHERE (u_fname LIKE ? OR u_lname LIKE ?) "
                    + "AND (u_status = 'Pending' OR u_status = 'Active')")){

                String name = searchField.getText();
                pst.setString(1, "%" + name + "%");
                pst.setString(2, "%" + name + "%");
                ResultSet rs = pst.executeQuery();

                while(rs.next()){
                    listModel.addElement(rs.getString("u_fname") + " " + rs.getString("u_lname"));
                }

            } catch(SQLException ex){
                System.out.println("Errors: " + ex.getMessage());
            }

        } else {
            list.setSize(200, 0);
        }


    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed

    }//GEN-LAST:event_searchFieldMousePressed

    private void listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMousePressed
         
        String fullName = list.getSelectedValue();
        String[] nameParts = fullName.trim().split("\\s+");
        
 
        int lastNameStartIndex = -1;
        for (int i = 0; i < nameParts.length; i++) {
            if (nameParts[i].equalsIgnoreCase("Delos") ||
                nameParts[i].equalsIgnoreCase("Dela") ||
                nameParts[i].equalsIgnoreCase("Del") ||
                nameParts[i].equalsIgnoreCase("San") ||   
                nameParts[i].equalsIgnoreCase("Santo") || 
                nameParts[i].equalsIgnoreCase("La") || 
                nameParts[i].equalsIgnoreCase("Santa")    
                    ) {
                lastNameStartIndex = i;
                break;
            }
        }

        // If no last name identifier is found, default to the last part as the last name
        if (lastNameStartIndex == -1) {
            lastNameStartIndex = nameParts.length - 1;
        }

        String firstName = String.join(" ", Arrays.copyOfRange(nameParts, 0, lastNameStartIndex));
        String lastName = String.join(" ", Arrays.copyOfRange(nameParts, lastNameStartIndex, nameParts.length));
        
        
        dbConnector dbc = new dbConnector();

        try (PreparedStatement pst = dbc.connect.prepareStatement("SELECT * FROM tbl_user WHERE u_fname = ? AND u_lname = ?")) {
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            ResultSet rs = pst.executeQuery();    

      
            if (rs.next()) {
                Admin_RegUsers_Update ru = new Admin_RegUsers_Update();
                ru.uID.setText(String.valueOf(rs.getInt("u_id")));
                ru.fn.setText(rs.getString("u_fname"));
                ru.ln.setText(rs.getString("u_lname"));
                ru.usn.setText(rs.getString("u_usn"));
                ru.mail.setText(rs.getString("u_email"));
                ru.ut.setSelectedItem(rs.getString("u_type"));
                ru.st.setSelectedItem(rs.getString("u_status"));
                ru.ACCOUNT_NAME.setText(rs.getString("u_fname") + " " + rs.getString("u_lname"));
                ru.image.setIcon(ru.ResizeImage(rs.getString("u_image"), null, ru.image));
                ru.oldpath = rs.getString("u_image");
                ru.path = rs.getString("u_image");
                ru.destination = rs.getString("u_image");
                ru.setVisible(true);
                this.dispose();
                
                if(rs.getString("u_image").isEmpty()){
                    ru.addProfile.setText(" Add profile");
                    ru.remove.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }

    }//GEN-LAST:event_listMousePressed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       Admin_Logs al = new Admin_Logs();
       al.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
      logsPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
      logsPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel13MouseExited

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

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
       Admin_Logs al = new Admin_Logs();
       al.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_logsMouseClicked

    private void logoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseEntered

    private void logoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        Session sess = Session.getInstance();
        
        int userId = sess.getUid();
        
        logEvent(userId, "LOGOUT", "User logged out");

       
        login_form ads = new login_form();
        JOptionPane.showMessageDialog(null, "Log out successfully!");
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_logoutMouseExited

    private void logoffbgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffbgMouseClicked

    private void logoffbgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_logoffbgMouseEntered

    private void logoffbgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_logoffbgMouseExited

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        
        JPanel myPanel = new JPanel();
         Session sess = Session.getInstance();
  
         try {
             dbConnector dbc = new dbConnector();
             ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + id.getText() + "'");

             if (rs.next()) {
              PrintUserDets pud = new PrintUserDets(); 
              String imagePath = rs.getString("u_image");

              ImageIcon originalIcon = new ImageIcon(imagePath);
              
              ImageIcon resizedIcon = resizeImage(originalIcon, 170, 170);

              pud.image.setIcon(resizedIcon);

              pud.uid.setText(rs.getString("u_id"));
              pud.fullname.setText(rs.getString("u_fname") + " " + rs.getString("u_lname"));
              pud.username.setText(rs.getString("u_usn"));
              pud.umail.setText(rs.getString("u_email"));
              pud.type.setText(rs.getString("u_type"));
              
              String as = rs.getString("u_status");
             
                  stats.setText(""+as);
                  
                PanelPrinter pPrint = new PanelPrinter(pud.page);
                pPrint.printPanel();
                
            int userID = sess.getUid();
            
            logEvent(userID, "EXPORT_USER_DATA", "Admin exported User: "+id.getText()+" data.");
                
             }
             
            Window window = SwingUtilities.getWindowAncestor(viewPanel);
            window.dispose();
         
            }catch(SQLException ex){
                System.out.println(""+ex);
            }                    

    }//GEN-LAST:event_printActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        
         Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, exportData);
            dialog.setVisible(true);
            
    }//GEN-LAST:event_exportActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
     
     Session sess = Session.getInstance();

    if(nameField.getText().isEmpty()){
    a1.setText("File name required");
    
    return;
}
       String name = nameField.getText() + ".pdf";
       String location = System.getProperty("user.home") + "/Documents/";

            if(nameField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please name the pdf first to generate");
            return;
        }

        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT u_id, u_fname, u_lname, u_email, u_usn FROM tbl_user";
            ResultSet resultSet = dbc.getData(query);

            
            com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A5.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(location + name));
            document.open();

            PdfPTable pdfPTable = new PdfPTable(5);

            pdfPTable.addCell("ID");
            pdfPTable.addCell("Firstname");
            pdfPTable.addCell("Lastname");
            pdfPTable.addCell("Email");
            pdfPTable.addCell("Username");
    
    if (resultSet.next()) {
        
        do {
       
            pdfPTable.addCell(resultSet.getString("u_id"));
            pdfPTable.addCell(resultSet.getString("u_fname"));
            pdfPTable.addCell(resultSet.getString("u_lname"));
            pdfPTable.addCell(resultSet.getString("u_email"));
            pdfPTable.addCell(resultSet.getString("u_usn"));
            
         

        } while (resultSet.next());
    }
            // Check if the result set has data and process the first row
            if (resultSet.next()) {
                do {
                    // Retrieve each column by name and add to the table
                    pdfPTable.addCell(resultSet.getString("u_id"));
                    pdfPTable.addCell(resultSet.getString("u_fname"));
                    pdfPTable.addCell(resultSet.getString("u_lname"));
                    pdfPTable.addCell(resultSet.getString("u_email"));
                    pdfPTable.addCell(resultSet.getString("u_usn"));
                } while (resultSet.next()); 
                
            }


            document.add(pdfPTable);
            document.close();
            Window window = SwingUtilities.getWindowAncestor(exportData);
            window.dispose();
            JOptionPane.showMessageDialog(null, "Successfully Generated");
            nameField.setText("");
            
            int userID = sess.getUid();
            
            logEvent(userID, "EXPORT_USERS_DATA", "Admin exported all system user data to PDF: " + name);
            
        } catch (DocumentException | FileNotFoundException e) {
            System.err.println(e);
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }//GEN-LAST:event_pdfActionPerformed

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

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excelActionPerformed

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
        Window window = SwingUtilities.getWindowAncestor(exportData);
        window.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Archived_Users au = new Archived_Users();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
       
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_RegUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel1;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    private javax.swing.JLabel dot;
    private javax.swing.JMenuItem editItem;
    private javax.swing.JButton excel;
    private javax.swing.JButton export;
    private javax.swing.JPanel exportData;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel id;
    public javax.swing.JLabel image;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel logsPane;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton pdf;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JButton print;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel type;
    private javax.swing.JLabel umail;
    private javax.swing.JTable userTbl;
    private javax.swing.JLabel username;
    private javax.swing.JMenuItem view;
    private javax.swing.JPanel viewC;
    private javax.swing.JPanel viewPane;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
