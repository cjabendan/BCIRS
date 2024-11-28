
package ADMIN;

import USERS.User_Purok;
import bcirs.login_form;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.PanelPrinter;
import config.Session;
import config.dbConnector;
import enhancer.CenterCellRenderer;
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
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
public class Archived_Residents extends javax.swing.JFrame {

DefaultListModel listModel = new DefaultListModel();

    public Archived_Residents() {
        initComponents();
        displayData();
        searchField.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(Color.GRAY), // Optional: if you want a line border
        BorderFactory.createEmptyBorder(0, 10, 0, 0) ));
        DefaultTableModel model = (DefaultTableModel) userTbl.getModel();
    }
 
   public void displayData() {
    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT r_id, r_fname, r_lname, r_status FROM tbl_residents WHERE r_status IN ('Archived')"
                + "ORDER BY r_id DESC";
        
        ResultSet rs = dbc.getData(query);
        userTbl.setModel(DbUtils.resultSetToTableModel(rs));
        
        JTableHeader th = userTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        
        TableColumn tc = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
 
        
        tc.setHeaderValue("ID");
        tc1.setHeaderValue("First Name");
        tc2.setHeaderValue("Last Name");
        tc3.setHeaderValue("Status");
        
        
          CenterCellRenderer centerRenderer = new CenterCellRenderer();
            for (int i = 0; i < tcm.getColumnCount(); i++) {
                tcm.getColumn(i).setCellRenderer(centerRenderer);
            }
        
        
        tc3.setCellRenderer(new StatusCellRenderer());
        th.setDefaultRenderer(new CustomHeaderRenderer());

        
        
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

    Color Red = new Color(255,0,0);
    Color White = new Color(255,255,255);
    Color BlueBT = new Color(89,182,255);
    Color MainC = new Color(27,55,77);
   
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
        Unarchive = new javax.swing.JMenuItem();
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
        confirm = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        ACCOUNT_NAME = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cancelBT = new javax.swing.JButton();
        yesBT = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        household = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        ocu = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        stats1 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        type1 = new javax.swing.JLabel();
        purok = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        adm_header = new javax.swing.JPanel();
        cancel2 = new javax.swing.JButton();
        d = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        export = new javax.swing.JButton();
        d1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();

        view.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye (1).png"))); // NOI18N
        view.setText(" View Data");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        popUp.add(view);

        Unarchive.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        Unarchive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pen-circle (1).png"))); // NOI18N
        Unarchive.setText(" Unarchive");
        Unarchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnarchiveActionPerformed(evt);
            }
        });
        popUp.add(Unarchive);

        exportData.setBackground(new java.awt.Color(255, 255, 255));
        exportData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        exportData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        exportData.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 470, 10));

        jPanel6.setBackground(new java.awt.Color(27, 57, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText(" Archived Users Data");
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

        confirm.setBackground(new java.awt.Color(255, 255, 255));
        confirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        confirm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        confirm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 420, 10));

        ACCOUNT_NAME.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ACCOUNT_NAME.setForeground(new java.awt.Color(89, 182, 255));
        ACCOUNT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACCOUNT_NAME.setText("SAMPLE");
        confirm.add(ACCOUNT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 420, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Are you sure you want to unarchive user?");
        confirm.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 420, 20));

        cancelBT.setBackground(new java.awt.Color(255, 255, 255));
        cancelBT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancelBT.setForeground(new java.awt.Color(27, 57, 77));
        cancelBT.setText("Cancel");
        cancelBT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        cancelBT.setBorderPainted(false);
        cancelBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelBTMouseExited(evt);
            }
        });
        cancelBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTActionPerformed(evt);
            }
        });
        confirm.add(cancelBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 110, 30));

        yesBT.setBackground(new java.awt.Color(27, 57, 77));
        yesBT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        yesBT.setForeground(new java.awt.Color(255, 255, 255));
        yesBT.setText("Confirm");
        yesBT.setBorderPainted(false);
        yesBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yesBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yesBTMouseExited(evt);
            }
        });
        yesBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBTActionPerformed(evt);
            }
        });
        confirm.add(yesBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 110, 30));

        jPanel7.setBackground(new java.awt.Color(27, 57, 77));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("NOTICE");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        confirm.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        viewPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        viewPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        viewPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 550, 10));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 57, 77));
        jLabel10.setText("Name:");
        viewPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 60, 20));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 57, 77));
        jLabel11.setText("Address:");
        viewPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 57, 77));
        jLabel13.setText("Resident ID:");
        viewPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(27, 57, 77));
        id.setText("Id number");
        viewPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, 30));

        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        imagePanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        viewPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 170));

        jPanel9.setBackground(new java.awt.Color(27, 57, 77));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" View Resident Details");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

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
        jPanel9.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        viewPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        household.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        household.setForeground(new java.awt.Color(27, 57, 77));
        household.setText("Id number");
        viewPanel.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 30));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(27, 57, 77));
        jLabel29.setText("Purok:");
        viewPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 40, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 57, 77));
        jLabel4.setText("Civil Status:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 20));

        stats.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stats.setForeground(new java.awt.Color(27, 57, 77));
        stats.setText("Occupation:");
        jPanel4.add(stats, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

        ocu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ocu.setForeground(new java.awt.Color(27, 57, 77));
        ocu.setText("ocu");
        jPanel4.add(ocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, 20));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(27, 57, 77));
        jLabel30.setText("Age:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 30, 20));

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

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 57, 77));
        jLabel15.setText("Date of Birth:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 20));

        age.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        age.setForeground(new java.awt.Color(27, 57, 77));
        age.setText("age");
        jPanel4.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 57, 77));
        jLabel12.setText("Sex:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 60, 20));

        address.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        address.setForeground(new java.awt.Color(27, 57, 77));
        address.setText("User ID:");
        jPanel4.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 20));

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

        purok.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        purok.setForeground(new java.awt.Color(27, 57, 77));
        purok.setText("Purok");
        viewPanel.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 57, 77));
        jLabel31.setText("House No:");
        viewPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 30));

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

        adm_header.setBackground(new java.awt.Color(27, 57, 77));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel2.setBackground(new java.awt.Color(255, 255, 255));
        cancel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel2.setForeground(new java.awt.Color(255, 255, 255));
        cancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/undo-alt (1).png"))); // NOI18N
        cancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel2MouseExited(evt);
            }
        });
        cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel2ActionPerformed(evt);
            }
        });
        adm_header.add(cancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 30, 30));

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d.setForeground(new java.awt.Color(204, 204, 204));
        d.setText("See and manage your archived residents data here.");
        adm_header.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Archived Residents");
        adm_header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jPanel1.add(adm_header);
        adm_header.setBounds(0, 0, 1190, 70);

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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 1130, 420);

        export.setBackground(new java.awt.Color(27, 57, 77));
        export.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        export.setForeground(new java.awt.Color(255, 255, 255));
        export.setText("EXPORT");
        export.setBorder(null);
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        jPanel1.add(export);
        export.setBounds(330, 80, 70, 30);

        d1.setBackground(new java.awt.Color(244, 244, 244));
        d1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        d1.setForeground(new java.awt.Color(27, 57, 77));
        d1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info (2).png"))); // NOI18N
        d1.setText(" You may download the system's archived data here.");
        jPanel1.add(d1);
        d1.setBounds(20, 80, 310, 30);

        jPanel2.setBackground(new java.awt.Color(27, 57, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search_1.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(773, 80, 30, 30);

        searchField.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        searchField.setForeground(new java.awt.Color(204, 204, 204));
        searchField.setText(" Search resident....");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchField.setHighlighter(null);
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
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
        jPanel1.add(searchField);
        searchField.setBounds(810, 80, 340, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
          Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
       
         
       }
      
    }//GEN-LAST:event_formWindowActivated

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

    private void cancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseClicked

    }//GEN-LAST:event_cancel2MouseClicked

    private void cancel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseEntered
        
    }//GEN-LAST:event_cancel2MouseEntered

    private void cancel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel2MouseExited
       
    }//GEN-LAST:event_cancel2MouseExited

    private void cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel2ActionPerformed

        User_Purok up = new User_Purok();
        up.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_cancel2ActionPerformed

    private void userTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userTblMouseClicked

    private void userTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTblMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(userTbl, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_userTblMousePressed

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excelActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed

  Session sess = Session.getInstance();

    if (nameField.getText().isEmpty()) {
        a1.setText("File name required");
        return;
    }

    String name = nameField.getText() + ".pdf";
    String location = System.getProperty("user.home") + "/Documents/";

    try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT u_id, u_fname, u_lname, u_email, u_usn FROM tbl_user WHERE u_status = 'Archived'";
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

        document.add(pdfPTable);
        document.close();

        Window window = SwingUtilities.getWindowAncestor(exportData);
        window.dispose();
        JOptionPane.showMessageDialog(null, "Successfully Generated");
        nameField.setText("");

        int userID = sess.getUid();
        logEvent(userID, "EXPORT_USERS_DATA", "Admin exported archived user data to PDF: " + name);

    } catch (DocumentException | FileNotFoundException e) {
        System.err.println(e);
    } catch (SQLException ex) {
        System.out.println("" + ex);
    }

    }//GEN-LAST:event_pdfActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(exportData);
        window.dispose();
    }//GEN-LAST:event_cancel1ActionPerformed

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseExited

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseClicked

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed

        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, exportData);
        dialog.setVisible(true);

    }//GEN-LAST:event_exportActionPerformed

    private void UnarchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnarchiveActionPerformed
       
        int rowIndex = userTbl.getSelectedRow();
        String userId = userTbl.getValueAt(rowIndex, 0).toString(); 
         
        Object[] options = {};
        
        
         try{
                dbConnector dbc = new dbConnector();
                TableModel tbl = userTbl.getModel();
                ResultSet rs = dbc.getData("SELECT * FROM tbl_residents WHERE r_id = '"+userId+"'");
            
                if(rs.next()){
         
                     ACCOUNT_NAME.setText(rs.getString("r_fname") + " " + rs.getString("r_lname"));             
               
            }
                 
            }catch(SQLException ex){
                System.out.println(""+ex);
            }                
        
        NoBorderDialog dialog = new NoBorderDialog(null, confirm);
        dialog.setVisible(true);
    }//GEN-LAST:event_UnarchiveActionPerformed

    private void cancelBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBTMouseEntered

    }//GEN-LAST:event_cancelBTMouseEntered

    private void cancelBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBTMouseExited

    }//GEN-LAST:event_cancelBTMouseExited

    private void cancelBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTActionPerformed
        Window window = SwingUtilities.getWindowAncestor(confirm);
        window.dispose();
    }//GEN-LAST:event_cancelBTActionPerformed

    private void yesBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseEntered
        yesBT.setBackground(BlueBT);
    }//GEN-LAST:event_yesBTMouseEntered

    private void yesBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseExited
        yesBT.setBackground(MainC);
    }//GEN-LAST:event_yesBTMouseExited

    private void yesBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBTActionPerformed

        Session sess = Session.getInstance();

        int adminID = sess.getUid();
        
        dbConnector dbc = new dbConnector();
        String stats = "Active";

        int rowIndex = userTbl.getSelectedRow();

        String sql = "UPDATE tbl_residents SET r_status = ? WHERE r_id = ?";

        try (PreparedStatement pst = dbc.connect.prepareStatement(sql)) {
    
            String userId = userTbl.getValueAt(rowIndex, 0).toString(); 

            pst.setString(1, stats);
            pst.setString(2, userId);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                Window window = SwingUtilities.getWindowAncestor(confirm);
                window.dispose();
                JOptionPane.showMessageDialog(null, "User data unarchived.");

                logEvent(adminID, "USER_UNARCHIVED", "User: "+userId+" data is unarchived by admin");
                    
                displayData();

            } else {
                JOptionPane.showMessageDialog(null, "No records found to delete.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }

    }//GEN-LAST:event_yesBTActionPerformed

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

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

    }//GEN-LAST:event_printActionPerformed

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        if (searchField.getText().equals(" Search resident....")){
            searchField.setText("");
            searchField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        if (searchField.getText().equals("")){
            searchField.setText(" Search resident....");
            searchField.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMousePressed

    }//GEN-LAST:event_searchFieldMousePressed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased

        try {
            dbConnector dbc = new dbConnector();
            String searchText = searchField.getText().trim();
            String query;

            if (searchText.isEmpty()) {
                 query = "SELECT r_id, r_fname, r_lname, r_status " 
             + "FROM tbl_residents "
             + "WHERE r_status = 'Archived' "
             + "ORDER BY r_id DESC";
                  displayData();
            } else {
               query = "SELECT r_id, r_fname, r_lname, r_status " 
             + "FROM tbl_residents "
             + "WHERE r_status = 'Archived' "
             + "AND (r_lname LIKE '%" + searchText + "%' "
             + "OR r_fname LIKE '%" + searchText + "%' "
             + "OR r_id LIKE '%" + searchText + "%') "
             + "ORDER BY r_id DESC";
                
                ResultSet rs = dbc.getData(query);
                userTbl.setModel(DbUtils.resultSetToTableModel(rs));
            }

            // Set table headers
        
        JTableHeader th = userTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        
        TableColumn tc = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
 
        
        tc.setHeaderValue("ID");
        tc1.setHeaderValue("First Name");
        tc2.setHeaderValue("Last Name");
        tc3.setHeaderValue("Status");
        
        
          CenterCellRenderer centerRenderer = new CenterCellRenderer();
            for (int i = 0; i < tcm.getColumnCount(); i++) {
                tcm.getColumn(i).setCellRenderer(centerRenderer);
            }
        
        
        tc3.setCellRenderer(new StatusCellRenderer());
        th.setDefaultRenderer(new CustomHeaderRenderer());


        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    
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
                new Archived_Residents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ACCOUNT_NAME;
    private javax.swing.JMenuItem Unarchive;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel address;
    private javax.swing.JPanel adm_header;
    private javax.swing.JLabel age;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel1;
    public javax.swing.JButton cancel2;
    private javax.swing.JButton cancelBT;
    private javax.swing.JPanel confirm;
    public javax.swing.JLabel d;
    public javax.swing.JLabel d1;
    private javax.swing.JLabel dob;
    private javax.swing.JButton excel;
    private javax.swing.JButton export;
    private javax.swing.JPanel exportData;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel household;
    private javax.swing.JLabel id;
    public javax.swing.JLabel image;
    private javax.swing.JPanel imagePanel;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel ocu;
    private javax.swing.JButton pdf;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JButton print;
    private javax.swing.JLabel purok;
    private javax.swing.JLabel reg;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel sex;
    private javax.swing.JLabel stats;
    private javax.swing.JLabel stats1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel type1;
    private javax.swing.JTable userTbl;
    private javax.swing.JMenuItem view;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JButton yesBT;
    // End of variables declaration//GEN-END:variables
}
