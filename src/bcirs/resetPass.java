/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcirs;

import ADMIN.Admin_Settings;
import Extra_Frames.resetPass_C;
import bcirs.login_form;
import config.PasswordHasher;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
public class resetPass extends javax.swing.JFrame {

    /**
     * Creates new form resgiter_form
     */
    public resetPass() {
        initComponents();
          nps.setBorder(new EmptyBorder(0,10,0,0));
          cnps.setBorder(new EmptyBorder(0,10,0,0));
    }
    
    Color Red = new Color(255,0,0);
    Color Hover = new Color(0,102,255);
    Color Release = new Color(27,57,77);


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nps = new javax.swing.JPasswordField();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cnps = new javax.swing.JPasswordField();
        cBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(27, 55, 77));
        jPanel4.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Reset Password");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 60, 400, 47));

        jLabel11.setBackground(new java.awt.Color(234, 234, 234));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("Your new password must be different from previously used");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 420, 30));

        jPanel5.setBackground(new java.awt.Color(27, 55, 77));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_223PX.png"))); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 420));

        jLabel12.setBackground(new java.awt.Color(234, 234, 234));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 55, 77));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("password.");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 80, 30));

        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("jLabel3");
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 140, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(27, 57, 77));
        jLabel32.setText("New Password:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 190, 30));

        nps.setBackground(new java.awt.Color(242, 242, 242));
        nps.setBorder(null);
        jPanel2.add(nps, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 380, 30));

        a1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel2.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 240, 30));

        a2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel2.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 260, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 57, 77));
        jLabel31.setText("Confirm  Password:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 220, 30));

        cnps.setBackground(new java.awt.Color(242, 242, 242));
        cnps.setBorder(null);
        jPanel2.add(cnps, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 380, 30));

        cBt.setBackground(new java.awt.Color(27, 55, 77));
        cBt.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cBt.setForeground(new java.awt.Color(255, 255, 255));
        cBt.setText("Reset Password");
        cBt.setBorder(null);
        cBt.setBorderPainted(false);
        cBt.setOpaque(false);
        cBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cBtMouseExited(evt);
            }
        });
        cBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBtActionPerformed(evt);
            }
        });
        jPanel2.add(cBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 190, 33));

        jPanel4.add(jPanel2);
        jPanel2.setBounds(0, 0, 900, 420);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 900, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cBtMouseEntered
        cBt.setBackground(Hover);
    }//GEN-LAST:event_cBtMouseEntered

    private void cBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cBtMouseExited
        cBt.setBackground(Release);
    }//GEN-LAST:event_cBtMouseExited

    private void cBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBtActionPerformed

        a1.setText("");
        a2.setText("");

        dbConnector dbc = new dbConnector();
        PasswordHasher pH = new PasswordHasher();

        
        try {
            String query = "SELECT * FROM tbl_user WHERE u_id = '" + id.getText() + "'";
            ResultSet resultSet = dbc.getData(query);

            if (resultSet.next()) {
                if (nps.getText().isEmpty() || cnps.getText().isEmpty()) {
                    if (nps.getText().isEmpty()) {
                        a1.setText("Field required!");
                    }
                    if (cnps.getText().isEmpty()) {
                        a1.setText("Field required!");
                    }
                } else if (nps.getText().length() < 8) {
                    a2.setText("At least 8 characters");
                } else if (!nps.getText().equals(cnps.getText())) {
                    a1.setText("Password does not match!");
                    a2.setText("Password does not match!");
                } else {
                    String password = pH.hashPassword(nps.getText());
                    dbc.updateData("UPDATE tbl_user SET u_pass = '" + password + "' WHERE u_id = '" + id.getText() + "'");

                    // Log the password reset event
                    logEvent(id.getText(), "PASSWORD_RESET", "User password has been reset");

                    resetPass_C rpc = new resetPass_C();
                    rpc.setVisible(true);
                    this.dispose();
                }
            }

            resultSet.close();  // Ensure the ResultSet is closed

        } catch (SQLException ex) {
            System.out.println("" + ex);
        }

    }//GEN-LAST:event_cBtActionPerformed

      public void logEvent(String userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
        pstmt.setString(2, event);
        pstmt.setString(3, userId);
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
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new resetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JButton cBt;
    private javax.swing.JPasswordField cnps;
    public javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField nps;
    // End of variables declaration//GEN-END:variables
}