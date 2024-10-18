/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

import ADMIN.*;
import static ADMIN.Admin_RegUsers_Update.email;
import static ADMIN.Admin_RegUsers_Update.usname;
import bcirs.login_form;
import config.Session;
import config.dbConnector;
import enhancer.NoBorderDialog;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
public class User_Settings_Account extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public User_Settings_Account() {
        initComponents();
       fn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        mail.setBorder(new EmptyBorder(0,10,0,0));
        usn.setBorder(new EmptyBorder(0,10,0,0));
    }
  
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    Color Red = new Color(255,0,0);
    Color BlueBT = new Color(89,182,255);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
      public String destination = "";
   File selectedFile;
   public String path;
   public String oldpath;
    
   public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/u_images", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    }

   public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
           
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
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
    
   public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
   
   public boolean updateCheck(){
        
        dbConnector dbc = new dbConnector();
        Session sess = Session.getInstance();
        
        try{
            
            String query = "SELECT * FROM tbl_user WHERE (u_usn = '" + usn.getText() 
                    + "' OR u_email = '" + mail.getText() 
                    + "') AND u_id != '" + sess.getUid() + "'";
    
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
             
                email = resultSet.getString("u_email");
                if(email.equals(mail.getText())){
                    JOptionPane.showMessageDialog(null,"Email is Already Used!");
                    mail.setText("");
                }
                
                usname = resultSet.getString("u_usn");
                if(usname.equals(usn.getText())){
                    JOptionPane.showMessageDialog(null,"Username is Already Used!");
                    usn.setText("");
                }
                
                return true;
                
            }else{
                return false;
            }
            
        }catch(SQLException ex){
            
            System.out.println(""+ex);
            return false;
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

        confirmDel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cancelBT = new javax.swing.JButton();
        yesBT = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        adm_nav = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        accPane = new javax.swing.JPanel();
        dashC = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewC = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        secPane = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        sessUsn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        adm_header = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        d = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        remove = new javax.swing.JButton();
        addProfile = new javax.swing.JButton();
        fn = new javax.swing.JTextField();
        usn = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        confirmDel.setBackground(new java.awt.Color(255, 255, 255));
        confirmDel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        confirmDel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        confirmDel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 420, 10));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("of your account?");
        confirmDel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 420, 70));

        cancelBT.setBackground(new java.awt.Color(255, 255, 255));
        cancelBT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancelBT.setForeground(new java.awt.Color(27, 57, 77));
        cancelBT.setText("Cancel");
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
        confirmDel.add(cancelBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 110, 30));

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
        confirmDel.add(yesBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 110, 30));

        jPanel8.setBackground(new java.awt.Color(27, 57, 77));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("NOTICE");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        confirmDel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(27, 57, 77));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Do you want to confirm the deletion");
        confirmDel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 420, 50));

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

        accPane.setBackground(new java.awt.Color(27, 57, 77));
        accPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout accPaneLayout = new javax.swing.GroupLayout(accPane);
        accPane.setLayout(accPaneLayout);
        accPaneLayout.setHorizontalGroup(
            accPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        accPaneLayout.setVerticalGroup(
            accPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(accPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (1).png"))); // NOI18N
        jLabel3.setText(" Account");
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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
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
        viewC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lock (1).png"))); // NOI18N
        jLabel5.setText(" Security");
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
        viewC.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 0, 85, 38));

        dot.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dot.setForeground(new java.awt.Color(255, 0, 0));
        viewC.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 30, 20));

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        secPane.setBackground(new java.awt.Color(255, 255, 255));
        secPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                secPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                secPaneMouseExited(evt);
            }
        });

        javax.swing.GroupLayout secPaneLayout = new javax.swing.GroupLayout(secPane);
        secPane.setLayout(secPaneLayout);
        secPaneLayout.setHorizontalGroup(
            secPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        secPaneLayout.setVerticalGroup(
            secPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        adm_nav.add(secPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Settings");
        adm_nav.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, 50));

        sessUsn.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        sessUsn.setForeground(new java.awt.Color(204, 204, 204));
        sessUsn.setText("@");
        adm_nav.add(sessUsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 80, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/angle-small-left.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        adm_nav.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        adm_header.setBackground(new java.awt.Color(255, 255, 255));
        adm_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(27, 55, 77));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d.setForeground(new java.awt.Color(204, 204, 204));
        d.setText("See and manage your information like your username or email addrerss.");
        jPanel3.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 50));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Account Settings");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 40));

        adm_header.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 60));

        jPanel1.add(adm_header);
        adm_header.setBounds(180, 0, 990, 60);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 30, 30));

        addProfile.setBackground(new java.awt.Color(255, 255, 255));
        addProfile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-image (1).png"))); // NOI18N
        addProfile.setText(" Edit Profile");
        addProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfileActionPerformed(evt);
            }
        });
        jPanel5.add(addProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, 30));

        fn.setBackground(new java.awt.Color(245, 246, 248));
        fn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        fn.setForeground(new java.awt.Color(100, 115, 122));
        fn.setBorder(null);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel5.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 270, 30));

        usn.setBackground(new java.awt.Color(245, 246, 248));
        usn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        usn.setForeground(new java.awt.Color(100, 115, 122));
        usn.setBorder(null);
        usn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usnActionPerformed(evt);
            }
        });
        jPanel5.add(usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 270, 30));

        mail.setBackground(new java.awt.Color(245, 246, 248));
        mail.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        mail.setForeground(new java.awt.Color(100, 115, 122));
        mail.setBorder(null);
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        jPanel5.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 270, 30));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("Email");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 60, 40));

        ln.setBackground(new java.awt.Color(245, 246, 248));
        ln.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        ln.setForeground(new java.awt.Color(100, 115, 122));
        ln.setBorder(null);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel5.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 270, 30));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 55, 77));
        jLabel12.setText("Last Name");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, 20));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setText("Username");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, 20));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 55, 77));
        jLabel13.setText("First Name");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 32, -1, 30));

        jPanel7.setBackground(new java.awt.Color(245, 246, 248));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel7.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 170, 170));

        update.setBackground(new java.awt.Color(27, 55, 77));
        update.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Save ");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel5.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 100, 30));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        cancel.setForeground(new java.awt.Color(27, 57, 77));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel5.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 100, 30));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(210, 140, 910, 310);

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 55, 77));
        jLabel17.setText("Edit your personal details");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(210, 80, 280, 60);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete Account");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(27, 57, 77), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(950, 493, 170, 40);

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
       
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           sessUsn.setText("@"+sess.getUsername());
           int id = sess.getUid();
          
           try{
           dbConnector dbc = new dbConnector();
           ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'");
           
           if(rs.next()){
               
               fn.setText(rs.getString("u_fname"));
               ln.setText(rs.getString("u_lname"));
               usn.setText(rs.getString("u_usn"));
               mail.setText(rs.getString("u_email"));
               image.setIcon(ResizeImage(rs.getString("u_image"), null, image));
               oldpath = rs.getString("u_image");
               path = rs.getString("u_image");
               destination = rs.getString("u_image");
               
               
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
                destination = "src/u_images/" + selectedFile.getName();
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

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void usnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usnActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
            
            User_Settings ru = new User_Settings();
            ru.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        Session sess = Session.getInstance(); 
        
        if(fn.getText().isEmpty() || ln.getText().isEmpty() || mail.getText().isEmpty() 
                || usn.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null,"All fields are required!");
            
        }
            else if(updateCheck()){
            
            System.out.println("Duplicate Exist!");
            
        }
        else{
             
        dbConnector dbc = new dbConnector();
        
        dbc.updateData("UPDATE tbl_user SET u_fname = '" + fn.getText() + "', u_lname = '" + ln.getText()
                + "', u_email = '" + mail.getText() + "', u_usn = '" + usn.getText()
                + "',u_image = '" + destination + "' WHERE u_id = '" + sess.getUid() + "'");
        
        
        if(destination.isEmpty()){
            File existingFile = new File(oldpath);
            if(existingFile.exists()){
                existingFile.delete();
            }
        }else{
            if(!(oldpath.equals(path))){
                imageUpdater(oldpath,path);
            }
                
        }
        
            JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            Admin_Settings as = new Admin_Settings();
            as.setVisible(true);
            this.dispose();
        
        }
          
    }//GEN-LAST:event_updateActionPerformed

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited

    }//GEN-LAST:event_dashCMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered

    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked

    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited

    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void accPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseExited

    }//GEN-LAST:event_accPaneMouseExited

    private void accPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accPaneMouseEntered

    }//GEN-LAST:event_accPaneMouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        User_Security as = new User_Security();
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        secPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked

    }//GEN-LAST:event_viewCMouseClicked

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        secPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        secPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void secPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseEntered

    private void secPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_secPaneMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        user_dashboard ads = new user_dashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void cancelBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBTMouseEntered

    }//GEN-LAST:event_cancelBTMouseEntered

    private void cancelBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBTMouseExited

    }//GEN-LAST:event_cancelBTMouseExited

    private void cancelBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTActionPerformed
        Window window = SwingUtilities.getWindowAncestor(confirmDel);
        window.dispose();
    }//GEN-LAST:event_cancelBTActionPerformed

    private void yesBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseEntered
        yesBT.setBackground(Red);
    }//GEN-LAST:event_yesBTMouseEntered

    private void yesBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseExited
        yesBT.setBackground(MainC);
    }//GEN-LAST:event_yesBTMouseExited

    private void yesBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBTActionPerformed

        dbConnector dbc = new dbConnector();
        String stats = "Archived";

        Session sess = Session.getInstance();

        int userID = sess.getUid();

        String sql = "UPDATE tbl_user SET u_status = ? WHERE u_id = ?";

        try (PreparedStatement pst = dbc.connect.prepareStatement(sql)) {

            pst.setString(1, stats);
            pst.setInt(2, userID);
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                Window window = SwingUtilities.getWindowAncestor(confirmDel);
                window.dispose();
                JOptionPane.showMessageDialog(null, "User data archived.");

                logEvent(userID, "USER ACCOUNT DELETED", "USER ID: "+userID+" has deleted their account.");

                login_form u = new login_form();
                u.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No records found to delete.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_yesBTActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, confirmDel);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(User_Settings_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Settings_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Settings_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Settings_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new User_Settings_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accPane;
    public javax.swing.JButton addProfile;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    public javax.swing.JButton cancel;
    private javax.swing.JButton cancelBT;
    private javax.swing.JPanel confirmDel;
    public javax.swing.JLabel d;
    private javax.swing.JPanel dashC;
    private javax.swing.JLabel dot;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mail;
    public javax.swing.JButton remove;
    private javax.swing.JPanel secPane;
    public javax.swing.JLabel sessUsn;
    public javax.swing.JButton update;
    public javax.swing.JTextField usn;
    private javax.swing.JPanel viewC;
    private javax.swing.JButton yesBT;
    // End of variables declaration//GEN-END:variables
}
