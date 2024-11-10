
package USERS;

import ADMIN.*;
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
import enhancer.CustomHeaderRenderer;
import enhancer.NoBorderDialog;
import enhancer.StatusCellRenderer;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
public class Archived_Reports extends javax.swing.JFrame {

DefaultListModel listModel = new DefaultListModel();

    public Archived_Reports() {
        initComponents();
        displayData();
    
        DefaultTableModel model = (DefaultTableModel) repTbl.getModel();
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
    
    public void displayData() { 
    try {
        dbConnector dbc = new dbConnector();
       
        // Update SQL query to include `inc_id`
        String query = "SELECT inc_id, inc_type, inc_date_time, inc_reported_by, inc_status "
                     + "FROM tbl_reports "
                     + "WHERE inc_status = 'Closed' " 
                     + "ORDER BY inc_id DESC";

        ResultSet rs = dbc.getData(query);

        // Set the ResultSet to the table model
        repTbl.setModel(DbUtils.resultSetToTableModel(rs));

        // Access table header to modify column names
        JTableHeader th = repTbl.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        
        // Add headers for each column
        TableColumn tc0 = tcm.getColumn(0);
        TableColumn tc1 = tcm.getColumn(1);
        TableColumn tc2 = tcm.getColumn(2);
        TableColumn tc3 = tcm.getColumn(3);
        TableColumn tc4 = tcm.getColumn(4);

        // Set custom column headers
        tc0.setHeaderValue("Incident ID");
        tc1.setHeaderValue("Report Type");
        tc2.setHeaderValue("Incident Date & Time");
        tc3.setHeaderValue("Reported By");
        tc4.setHeaderValue("Status");

        // Apply custom header renderer if needed (optional)
        th.setDefaultRenderer(new CustomHeaderRenderer());
        th.repaint();

        // Center the content in each column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tc0.setCellRenderer(centerRenderer);  // Center Incident ID
        tc1.setCellRenderer(centerRenderer);  // Center Report Type
        tc2.setCellRenderer(centerRenderer);  // Center Incident Date & Time
        tc3.setCellRenderer(centerRenderer);  // Center Reported By
        tc4.setCellRenderer(new StatusCellRenderer());  // Custom renderer for Status column

        
        repTbl.removeColumn(tc0);
        // Close ResultSet after use
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

  
  class StatusCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Get the default cell rendering component
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Center the content
        setHorizontalAlignment(SwingConstants.CENTER);

        // Check the value of the status and set text color accordingly
        if (value != null) {
            String status = value.toString();
            if ("Open".equalsIgnoreCase(status)) {
                cell.setForeground(Color.RED);  // Set text color to red for "Open"
            } else if ("Closed".equalsIgnoreCase(status)) {
                cell.setForeground(Color.GREEN);  // Set text color to green for "Closed"
            } else {
                cell.setForeground(Color.BLACK);  // Default color if status is neither "Open" nor "Closed"
            }
        }

        return cell;
    }
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUp = new javax.swing.JPopupMenu();
        view = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        adm_header = new javax.swing.JPanel();
        cancel2 = new javax.swing.JButton();
        d = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        repTbl = new javax.swing.JTable();
        d1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        view.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/eye (1).png"))); // NOI18N
        view.setText(" View Data");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        popUp.add(view);

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
        d.setText("See and manage your archived reports here.");
        adm_header.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Archived Incident Reports");
        adm_header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 50));

        jPanel1.add(adm_header);
        adm_header.setBounds(0, 0, 1190, 70);

        repTbl.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        repTbl.setGridColor(new java.awt.Color(136, 136, 136));
        repTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repTblMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                repTblMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(repTbl);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png")));

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 800, 420);

        d1.setBackground(new java.awt.Color(244, 244, 244));
        d1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        d1.setForeground(new java.awt.Color(27, 57, 77));
        d1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info (2).png"))); // NOI18N
        d1.setText(" You may download each archived reports.");
        jPanel1.add(d1);
        d1.setBounds(20, 80, 310, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/File searching-pana (2).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(840, 330, 290, 220);

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
     
             
     int rowIndex = repTbl.getSelectedRow();
    
     String lid = repTbl.getModel().getValueAt(rowIndex, 0).toString();
     
   try {
       dbConnector dbc = new dbConnector();
       TableModel tbl = repTbl.getModel();

       
       ResultSet rs = dbc.getData("SELECT * FROM tbl_reports WHERE inc_id = '" +lid+ "'");

       if (rs.next()) {
          
           User_Reports_Arch_View ru = new User_Reports_Arch_View(); 
           ru.id.setText(rs.getString("inc_id"));
           ru.i_t1.setText(rs.getString("inc_type"));
           ru.i_dt1.setText(rs.getString("inc_date_time"));
           ru.i_l1.setText(rs.getString("inc_loc"));
           ru.i_p1.setText(rs.getString("inc_involvedpersons"));
           ru.i_n1.setText(rs.getString("inc_narrative"));
           ru.i_rb1.setText(rs.getString("inc_reported_by"));
           ru.i_rt1.setText(rs.getString("inc_received_by"));
           ru.i_s1.setText(rs.getString("inc_status"));   
           ru.setVisible(true);
           this.dispose();
       }
       
       
   } catch (SQLException ex) {
       // Print any SQL errors to the console for debugging
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

        User_Reports up = new User_Reports();
        up.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_cancel2ActionPerformed

    private void repTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_repTblMouseClicked

    private void repTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repTblMousePressed
        if (SwingUtilities.isRightMouseButton(evt)) {
            popUp.show(repTbl, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_repTblMousePressed

    
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
                new Archived_Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adm_header;
    public javax.swing.JButton cancel2;
    public javax.swing.JLabel d;
    public javax.swing.JLabel d1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JTable repTbl;
    private javax.swing.JMenuItem view;
    // End of variables declaration//GEN-END:variables
}
