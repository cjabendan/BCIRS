/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
    public class User_Residents_Add extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public User_Residents_Add() {
        initComponents();
        fn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        mn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        address.setBorder(new EmptyBorder(0,10,0,0));
        occupation.setBorder(new EmptyBorder(0,10,0,0));
        religion.setBorder(new EmptyBorder(0,10,0,0));
    }
    
   
    Color Red = new Color(255,0,0);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
      public static String email, usname;
      
      public String destination = "";
      File selectedFile;
      public String path;
      public String oldpath;
      
    
   public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/r_images", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    }

   public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
   
   public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
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
        adm_header = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        d = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        addProfile = new javax.swing.JButton();
        a5 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        household = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        mn = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        a7 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        occupation = new javax.swing.JTextField();
        a10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        a8 = new javax.swing.JLabel();
        religion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        a9 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 730, 50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add.setBackground(new java.awt.Color(27, 55, 77));
        Add.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add Resident");
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel3.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 420, 140, 33));

        jPanel6.setBackground(new java.awt.Color(27, 55, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d.setForeground(new java.awt.Color(204, 204, 204));
        d.setText("Resident's purok address will be automatically set for every household. ");
        jPanel6.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 50));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("New resident");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setText("Household");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 90, 40));

        ln.setBackground(new java.awt.Color(245, 246, 248));
        ln.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        ln.setForeground(new java.awt.Color(100, 115, 122));
        ln.setBorder(null);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 270, 35));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("Middle Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 100, 40));

        sex.setBackground(new java.awt.Color(245, 246, 248));
        sex.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        sex.setForeground(new java.awt.Color(100, 115, 122));
        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Select", "Male", "Female" }));
        sex.setBorder(null);
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        jPanel3.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 270, 35));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setText("Date of Birth ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 150, 40));

        jPanel7.setBackground(new java.awt.Color(245, 246, 248));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel7.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 190));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 190));

        remove.setBackground(new java.awt.Color(27, 57, 77));
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/circle-xmark.png"))); // NOI18N
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 30, 30));

        addProfile.setBackground(new java.awt.Color(255, 255, 255));
        addProfile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-image (1).png"))); // NOI18N
        addProfile.setText(" Add Profile");
        addProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfileActionPerformed(evt);
            }
        });
        jPanel3.add(addProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 130, 30));

        a5.setForeground(new java.awt.Color(255, 0, 0));
        a5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a5.setText("*");
        jPanel3.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 140, 40));

        a6.setForeground(new java.awt.Color(255, 0, 0));
        a6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a6.setText("*");
        jPanel3.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 140, 40));

        a4.setForeground(new java.awt.Color(255, 0, 0));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a4.setText("*");
        jPanel3.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 140, 40));

        a3.setForeground(new java.awt.Color(255, 0, 0));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a3.setText("*");
        jPanel3.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 100, 110, 40));

        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a1.setText("*");
        jPanel3.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 110, 40));

        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a2.setText("*");
        jPanel3.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 140, 40));

        dob.setBackground(new java.awt.Color(255, 255, 255));
        dob.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 270, 35));

        household.setBackground(new java.awt.Color(245, 246, 248));
        household.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        household.setForeground(new java.awt.Color(100, 115, 122));
        household.setBorder(null);
        household.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                householdActionPerformed(evt);
            }
        });
        jPanel3.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 270, 35));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("Sex");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 80, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("Address");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 80, 40));

        address.setBackground(new java.awt.Color(245, 246, 248));
        address.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        address.setForeground(new java.awt.Color(100, 115, 122));
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel3.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 270, 35));

        mn.setBackground(new java.awt.Color(245, 246, 248));
        mn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        mn.setForeground(new java.awt.Color(100, 115, 122));
        mn.setBorder(null);
        mn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnActionPerformed(evt);
            }
        });
        jPanel3.add(mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 270, 35));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 55, 77));
        jLabel12.setText("Last Name");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 100, 40));

        a7.setForeground(new java.awt.Color(255, 0, 0));
        a7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a7.setText("*");
        jPanel3.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 40));

        fn.setBackground(new java.awt.Color(245, 246, 248));
        fn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        fn.setForeground(new java.awt.Color(100, 115, 122));
        fn.setBorder(null);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 270, 35));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 55, 77));
        jLabel13.setText("First Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 100, 40));

        status.setBackground(new java.awt.Color(245, 246, 248));
        status.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        status.setForeground(new java.awt.Color(100, 115, 122));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Select", "Single", "Married", "Widowed", "Separated" }));
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel3.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 270, 35));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 55, 77));
        jLabel14.setText("Civil Status");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 160, 40));

        occupation.setBackground(new java.awt.Color(245, 246, 248));
        occupation.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        occupation.setForeground(new java.awt.Color(100, 115, 122));
        occupation.setBorder(null);
        occupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                occupationActionPerformed(evt);
            }
        });
        jPanel3.add(occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 270, 35));

        a10.setForeground(new java.awt.Color(255, 0, 0));
        a10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a10.setText("*");
        jPanel3.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 130, 40));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 55, 77));
        jLabel15.setText("Occupation");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 100, 40));

        a8.setForeground(new java.awt.Color(255, 0, 0));
        a8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a8.setText("*");
        jPanel3.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 140, 40));

        religion.setBackground(new java.awt.Color(245, 246, 248));
        religion.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        religion.setForeground(new java.awt.Color(100, 115, 122));
        religion.setBorder(null);
        religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                religionActionPerformed(evt);
            }
        });
        jPanel3.add(religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 270, 35));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 55, 77));
        jLabel16.setText("Religion");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 100, 40));

        a9.setForeground(new java.awt.Color(255, 0, 0));
        a9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a9.setText("*");
        jPanel3.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 140, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 60, 1120, 480);

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
        jPanel1.add(cancel);
        cancel.setBounds(1106, 20, 33, 30);

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    Session sess = Session.getInstance();
       
   try {
    dbConnector dbc = new dbConnector();
    ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'");
    ResultSet rs1 = dbc.getData("SELECT h_name FROM tbl_household");
  

    if(rs.next()){
       
        Vector<String> householdIDs = new Vector<>();
 
        
        householdIDs.add("Select household");  
       
        while(rs1.next()) {
            householdIDs.add(rs1.getString("h_name"));
        }
        
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(householdIDs);
        household.setModel(model);
        

        rs.close();
        rs1.close();
    }
} catch(SQLException ex) {
    System.out.println(""+ex);
}

    }//GEN-LAST:event_formWindowActivated

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMouseClicked

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed

        
    Session sess = Session.getInstance();

    int userID = sess.getUid();    
        
    a1.setText("");
    a2.setText("");
    a3.setText("");
    a4.setText("");
    a5.setText("");
    a6.setText("");
    a7.setText("");
    a8.setText("");
    a9.setText("");
    a10.setText("");

    if (ln.getText().isEmpty() || fn.getText().isEmpty() || mn.getText().isEmpty() 
        || address.getText().isEmpty() || occupation.getText().isEmpty() 
        || religion.getText().isEmpty() || dob.getDate() == null
        || sex.getSelectedIndex() == 0 || status.getSelectedIndex() == 0 
        || household.getSelectedIndex() == 0) {

        if (ln.getText().isEmpty()) {
            a1.setText("*");
        }
        if (fn.getText().isEmpty()) {
            a2.setText("*");
        }
        if (mn.getText().isEmpty()) {
            a3.setText("*");
        }
        if (address.getText().isEmpty()) {
            a4.setText("*");
        } 
        if (occupation.getText().isEmpty()) {
            a5.setText("*");
        }  
        if (religion.getText().isEmpty()) {
            a6.setText("*");
        }
        if (dob.getDate() == null) {
            a7.setText("*");
        }
        if (sex.getSelectedIndex() == 0) {
            a8.setText("*");
        }
        if (status.getSelectedIndex() == 0) {
            a9.setText("*");
        }
        if (household.getSelectedIndex() == 0) {
            a10.setText("*");
        }

    } else {

        dbConnector dbc = new dbConnector();

        String imageDestination = (selectedFile != null) ? destination : "src/u_default/blank_pfp.jpg";
        String selectedHousehold = household.getSelectedItem().toString();

        if (selectedHousehold.equals("Select household")) {
            a10.setText("Select a valid household");
        } else {
            try {
                String query = "SELECT h_id FROM tbl_household WHERE h_name = ?";
                PreparedStatement pst = dbc.connect.prepareStatement(query);
                pst.setString(1, selectedHousehold);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    int householdId = rs.getInt("h_id");

                    try (PreparedStatement insertPst = dbc.connect.prepareStatement(
                        "INSERT INTO tbl_residents (r_lname, r_fname, r_mname, r_address, r_sex, r_dob, r_civilstatus, r_occupation, r_religion, h_id, r_image, r_status) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                        insertPst.setString(1, ln.getText());
                        insertPst.setString(2, fn.getText());
                        insertPst.setString(3, mn.getText());
                        insertPst.setString(4, address.getText());
                        insertPst.setString(5, sex.getSelectedItem().toString());
                        insertPst.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(dob.getDate()));
                        insertPst.setString(7, status.getSelectedItem().toString());
                        insertPst.setString(8, occupation.getText());
                        insertPst.setString(9, religion.getText());
                        insertPst.setInt(10, householdId);
                        insertPst.setString(11, imageDestination);
                        insertPst.setString(12, "Active");

                        int rowsInserted = insertPst.executeUpdate();
                        
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                            if (generatedKeys.next()) {
                                int newResidentId = generatedKeys.getInt(1);
                                logEvent(userID, "IMPORT_NEW_RESIDENT", "Resident ID: " + newResidentId + " is added by user.");
                            }
                        
                        if (rowsInserted > 0) {
                            if (selectedFile != null) {
                                try {
                                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                                } catch (IOException ex) {
                                    System.out.println("Insert Image Error: " + ex);
                                }
                            }


                            String updateQuery = "UPDATE tbl_barangay SET b_population = b_population + 1 WHERE b_id = ?";
                            PreparedStatement updatePst = dbc.connect.prepareStatement(updateQuery);
                            updatePst.setInt(1, 1001);
                            updatePst.executeUpdate();
                            updatePst.close();

                            JOptionPane.showMessageDialog(null, "Resident Registered Successfully!");
                            User_Residents au = new User_Residents();
                            au.setVisible(true);
                            this.dispose();
                        } else {
                            System.out.println("Error inserting data");
                        }

                    } catch (SQLException ex) {
                        System.out.println("Database Error: " + ex.getMessage());
                    }

                } else {
                    a10.setText("Invalid Household Selection");
                }

                rs.close();
                pst.close();

            } catch (SQLException ex) {
                System.out.println("Database Error: " + ex.getMessage());
            }
        }
    }

    }//GEN-LAST:event_AddActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

       User_Residents au = new User_Residents ();
       au.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_cancelActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        remove.setBackground(Red);
    }//GEN-LAST:event_removeMouseEntered

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        remove.setBackground(MainC);
    }//GEN-LAST:event_removeMouseExited

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        addProfile.setText(" Add profile");
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void addProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProfileActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/r_images/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
                    addProfile.setText(" Edit Profile");
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_addProfileActionPerformed

    private void householdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_householdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_householdActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void mnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void occupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationActionPerformed

    private void religionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_religionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_religionActionPerformed

     public void logEvent(int userId, String event, String description) {
   
        dbConnector dbc = new dbConnector();
        PreparedStatement pstmt = null;
        
    try {
     

        String sql = "INSERT INTO tbl_logs (l_timestamp, l_event, u_id, l_description) VALUES (?, ?, ?, ?)";
        pstmt = dbc.connect.prepareStatement(sql);
        pstmt.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
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
            java.util.logging.Logger.getLogger(User_Residents_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Residents_Add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    public javax.swing.JButton addProfile;
    public javax.swing.JTextField address;
    private javax.swing.JPanel adm_header;
    public javax.swing.JButton cancel;
    public javax.swing.JLabel d;
    private com.toedter.calendar.JDateChooser dob;
    public javax.swing.JTextField fn;
    public javax.swing.JComboBox<String> household;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mn;
    public javax.swing.JTextField occupation;
    public javax.swing.JTextField religion;
    public javax.swing.JButton remove;
    public javax.swing.JComboBox<String> sex;
    public javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
