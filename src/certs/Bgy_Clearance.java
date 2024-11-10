/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certs;

import ADMIN.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author chris
 */
public class Bgy_Clearance extends javax.swing.JFrame {

    /**
     * Creates new form PrintUserDets
     */
    public Bgy_Clearance() {
        initComponents();
         date();
    }

     private void date() {
       
        Date d = new Date();
    
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd,yyyy");
        String dt = sdf.format(d);
        date.setText(dt);
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
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        page = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lable1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        purpose = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        purok2 = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lable6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        purok = new javax.swing.JLabel();
        lable10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lable9 = new javax.swing.JLabel();
        lable11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lable2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(27, 57, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Untitled design (2).png"))); // NOI18N
        page.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 120, 110));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OFFICE OF BARANGAY WARD II");
        page.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 530, 60));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("born on,");
        page.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 50, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 90, 20));

        lable.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable.setText("Upon the request of the resident for:");
        page.add(lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 170, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Untitled design (1).png"))); // NOI18N
        page.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 110));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Republic of the Philippines");
        page.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 530, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Region VII");
        page.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 530, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Province of Cebu, Minglanilla");
        page.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 530, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BARANGAY CLEARANCE");
        page.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 530, 70));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        page.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 260, 40));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 430, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Doc. Stamp:");
        page.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 80, 20));

        lable1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable1.setText("TO WHOM IT MAY CONCERN;");
        page.add(lable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(" barangay seal  and the signature/specimen of an authorized barangay official.");
        page.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 330, 40));

        purpose.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        purpose.setText("Resident purpose");
        page.add(purpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 190, 20));

        fullname.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        fullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname.setText("RESIDENT'S FULL NAME");
        page.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 170, -1));

        purok2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        purok2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purok2.setText("Purok Name");
        page.add(purok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 70, 20));

        dob.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        dob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dob.setText("date of birth");
        page.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 110, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText(", Poblacion Ward II,");
        page.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 90, 20));

        lable6.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable6.setText("ISSUED");
        page.add(lable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 40, 20));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("To certify further, the name mentioned above have no pending case or derogatory record in this barangay. ");
        page.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 440, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("this");
        page.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 20, 20));

        date.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("date issued");
        page.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 130, 20));

        purok.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        purok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purok.setText("Purok Name");
        page.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 90, -1));

        lable10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable10.setText("Pobalcion Ward II, Minglanilla, Cebu.");
        page.add(lable10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 160, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("at Purok");
        page.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 60, 20));

        age.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        age.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        age.setText("age");
        page.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 40, -1));

        age1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        age1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        age1.setText("years of age,");
        page.add(age1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 60, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(" and a bonified resident  of  Purok");
        page.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 160, -1));

        lable9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        lable9.setText("THIS IS TO CERTIFY");
        page.add(lable9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        lable11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable11.setText(", at Barangay");
        page.add(lable11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel22.setText("abiding citizen in this community.");
        page.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 140, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("that");
        page.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 20, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel25.setText(" He or She is know fto be of good moral character and a law");
        page.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 250, -1));

        lable2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lable2.setText("Minglanilla, Cebu.");
        page.add(lable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 20));

        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 260, 20));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Punong Barangay");
        page.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 260, 30));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("O.R No.");
        page.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 60, 20));

        jLabel29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 90, 20));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Date Issued:");
        page.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 80, 20));

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        page.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 90, 20));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("By the authority of the Punong Barangay:");
        page.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 530, 60));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Disclaimer: This document is prefilled for convenience purposes and is not considered official without the");
        page.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 450, 40));

        jPanel1.add(page, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 530, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Bgy_Clearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bgy_Clearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bgy_Clearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bgy_Clearance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Bgy_Clearance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel age;
    public javax.swing.JLabel age1;
    public javax.swing.JLabel date;
    public javax.swing.JLabel dob;
    public javax.swing.JLabel fullname;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lable;
    public javax.swing.JLabel lable1;
    public javax.swing.JLabel lable10;
    public javax.swing.JLabel lable11;
    public javax.swing.JLabel lable2;
    public javax.swing.JLabel lable6;
    public javax.swing.JLabel lable9;
    public javax.swing.JPanel page;
    public javax.swing.JLabel purok;
    public javax.swing.JLabel purok2;
    public javax.swing.JLabel purpose;
    // End of variables declaration//GEN-END:variables
}
