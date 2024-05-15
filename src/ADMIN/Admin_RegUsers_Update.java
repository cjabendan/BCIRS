/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import Log_in.login_form;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
public class Admin_RegUsers_Update extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public Admin_RegUsers_Update() {
        initComponents();
        uID.setBorder(new EmptyBorder(0,10,0,0));
        fn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        mail.setBorder(new EmptyBorder(0,10,0,0));
        usn.setBorder(new EmptyBorder(0,10,0,0));
    }
    
    Color Red = new Color(255,0,0);
    Color BlueBT = new Color(89,182,255);
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
   
    public boolean dupCheck(){
        
        dbConnector dbc = new dbConnector();
        
        try{
            
            String query = "SELECT * FROM tbl_user  WHERE u_usn = '" + usn.getText() + "' OR u_email = '" + mail.getText() + "'";
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
        
          public boolean updateCheck(){
        
        dbConnector dbc = new dbConnector();
        
        try{
            
            String query = "SELECT * FROM tbl_user WHERE (u_usn = '" + usn.getText() 
                    + "' OR u_email = '" + mail.getText() 
                    + "') AND u_id != '" + uID.getText() + "'";
    
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ACCOUNT_NAME = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        yesBT = new javax.swing.JButton();
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
        jPanel5 = new javax.swing.JPanel();
        lbl = new javax.swing.JLabel();
        admin_name1 = new javax.swing.JLabel();
        admin_usn = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logsPane = new javax.swing.JPanel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        mainDk = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        st = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        uID = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        usn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        mail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        remove = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        addProfile = new javax.swing.JButton();
        adm_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();

        confirmDel.setBackground(new java.awt.Color(27, 55, 77));
        confirmDel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        confirmDel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 420, 10));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exclamation (1).png"))); // NOI18N
        jLabel15.setText(" NOTICE ");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        confirmDel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        ACCOUNT_NAME.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ACCOUNT_NAME.setForeground(new java.awt.Color(89, 182, 255));
        ACCOUNT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACCOUNT_NAME.setText("SAMPLE");
        confirmDel.add(ACCOUNT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 420, 30));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Are you sure you want to delete user:");
        confirmDel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 420, 20));

        yesBT.setBackground(new java.awt.Color(89, 182, 255));
        yesBT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        yesBT.setForeground(new java.awt.Color(255, 255, 255));
        yesBT.setText("YES");
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
        confirmDel.add(yesBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 80, -1));

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

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 55, 77));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo_32PX.png"))); // NOI18N
        jLabel2.setText("ARQUSTATS");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 17, -1, 45));

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

        adm_nav.add(dashPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 78, -1, -1));

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

        adm_nav.add(dashC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 78, 147, -1));

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

        adm_nav.add(viewC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, -1, -1));

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

        adm_nav.add(viewPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 125, -1, -1));

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

        adm_nav.add(purokPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 172, -1, -1));

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
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        purokCLayout.setVerticalGroup(
            purokCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, purokCLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 172, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl.setFont(new java.awt.Font("Yu Gothic UI", 0, 15)); // NOI18N
        lbl.setForeground(new java.awt.Color(27, 55, 77));
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/circle-user (3).png"))); // NOI18N
        jPanel5.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        admin_name1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        admin_name1.setForeground(new java.awt.Color(27, 55, 77));
        admin_name1.setText("Admin name");
        jPanel5.add(admin_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, 20));

        admin_usn.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        admin_usn.setForeground(new java.awt.Color(100, 115, 122));
        admin_usn.setText("username");
        jPanel5.add(admin_usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 90, 30));

        adm_nav.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 330, 176, 53));

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

        adm_nav.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

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

        adm_nav.add(logsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        jToggleButton2.setBackground(new java.awt.Color(27, 55, 77));
        jToggleButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 10)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit (2).png"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        adm_nav.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 30, 30));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings (3).png"))); // NOI18N
        jLabel12.setText(" Settings");
        adm_nav.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 80, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(0, -10, 180, 450);

        mainDk.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        st.setBackground(new java.awt.Color(245, 246, 248));
        st.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        st.setForeground(new java.awt.Color(100, 115, 122));
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Active", "Pending" }));
        st.setBorder(null);
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });
        jPanel3.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 190, 24));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 55, 77));
        jLabel13.setText("Status");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, 20));

        update.setBackground(new java.awt.Color(27, 55, 77));
        update.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update Data");
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
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 140, 30));

        delete.setBackground(new java.awt.Color(27, 55, 77));
        delete.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trash.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 30, 30));

        uID.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        uID.setForeground(new java.awt.Color(27, 55, 77));
        uID.setText("id");
        jPanel3.add(uID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 80, 20));

        jPanel6.setBackground(new java.awt.Color(27, 55, 77));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 50));

        usn.setBackground(new java.awt.Color(245, 246, 248));
        usn.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        usn.setForeground(new java.awt.Color(100, 115, 122));
        usn.setBorder(null);
        usn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usnActionPerformed(evt);
            }
        });
        jPanel3.add(usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 190, 24));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setText("Username");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 60, 20));

        fn.setBackground(new java.awt.Color(245, 246, 248));
        fn.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        fn.setForeground(new java.awt.Color(100, 115, 122));
        fn.setBorder(null);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 190, 24));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("First Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("Authorization ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 70, 20));

        ut.setBackground(new java.awt.Color(245, 246, 248));
        ut.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        ut.setForeground(new java.awt.Color(100, 115, 122));
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Admin", "User" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel3.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 190, 24));

        mail.setBackground(new java.awt.Color(245, 246, 248));
        mail.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        mail.setForeground(new java.awt.Color(100, 115, 122));
        mail.setBorder(null);
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        jPanel3.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 190, 24));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("Email");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 40, 20));

        ln.setBackground(new java.awt.Color(245, 246, 248));
        ln.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        ln.setForeground(new java.awt.Color(100, 115, 122));
        ln.setBorder(null);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 190, 24));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setText("Last Name");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, 20));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 55, 77));
        jLabel17.setText("Account ID:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 80, 20));

        jPanel7.setBackground(new java.awt.Color(245, 246, 248));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        remove.setBackground(new java.awt.Color(255, 0, 0));
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/circle-xmark.png"))); // NOI18N
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel7.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 30));
        jPanel7.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 170));

        addProfile.setBackground(new java.awt.Color(255, 255, 255));
        addProfile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addProfile.setText("Edit Profile");
        addProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfileActionPerformed(evt);
            }
        });
        jPanel7.add(addProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 240));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 0, 681, 344));

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

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText(" Registered User Settings");

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

        javax.swing.GroupLayout adm_headerLayout = new javax.swing.GroupLayout(adm_header);
        adm_header.setLayout(adm_headerLayout);
        adm_headerLayout.setHorizontalGroup(
            adm_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adm_headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        adm_headerLayout.setVerticalGroup(
            adm_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adm_headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adm_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
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
            admin_name1.setText(sess.getFname());
            admin_usn.setText(sess.getUsername());
       }
      
        
    }//GEN-LAST:event_formWindowActivated

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
          if(fn.getText().isEmpty() || ln.getText().isEmpty() || mail.getText().isEmpty() 
                || usn.getText().isEmpty() || ut.getSelectedIndex() == 0 || st.getSelectedIndex() == 0)
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
                + "', u_type = '" + ut.getSelectedItem()
                + "', u_status = '" + st.getSelectedItem() + "',u_image = '" + destination + "' WHERE u_id = '" + uID.getText() + "'");
        
        
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
            Admin_RegUsers ru = new Admin_RegUsers();
            ru.setVisible(true);
            this.dispose();
        
        }
          
    }//GEN-LAST:event_updateActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        Object[] options = {};
    
       JOptionPane.showOptionDialog(null, confirmDel, "",
       JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
      
    }//GEN-LAST:event_deleteActionPerformed

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(Red);         
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(MainC);
    }//GEN-LAST:event_deleteMouseExited

    private void yesBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBTActionPerformed
    
   dbConnector dbc = new dbConnector();
    
     String sql = "DELETE FROM tbl_user WHERE u_id = ?";
     
        try (PreparedStatement pst = dbc.connect.prepareStatement(sql)) {
        pst.setString(1, uID.getText()); 
        int rowsAffected = pst.executeUpdate(); 
        
    if (rowsAffected > 0) {
        Window window = SwingUtilities.getWindowAncestor(confirmDel);
        window.dispose();
        JOptionPane.showMessageDialog(null, "User deleted successfully!");
        Admin_RegUsers u = new Admin_RegUsers();
        u.setVisible(true);
        this.dispose();
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
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        Admin_RegUsers ru = new Admin_RegUsers();
        ru.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void yesBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseEntered
       yesBT.setBackground(Red);
    }//GEN-LAST:event_yesBTMouseEntered

    private void yesBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBTMouseExited
        yesBT.setBackground(BlueBT);
    }//GEN-LAST:event_yesBTMouseExited

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

    private void usnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usnActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        addProfile.setText("Add user profile");
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
                    addProfile.setText("Edit Profile");
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }

    }//GEN-LAST:event_addProfileActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        login_form ads = new login_form();

        JOptionPane.showMessageDialog(null,"Log out successfully!");
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_RegUsers_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_RegUsers_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_RegUsers_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_RegUsers_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_RegUsers_Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ACCOUNT_NAME;
    public javax.swing.JButton addProfile;
    private javax.swing.JPanel adm_header;
    private javax.swing.JPanel adm_nav;
    private javax.swing.JLabel admin_name1;
    private javax.swing.JLabel admin_usn;
    public javax.swing.JButton cancel;
    private javax.swing.JPanel confirmDel;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    public javax.swing.JButton delete;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JLabel lbl;
    public javax.swing.JTextField ln;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel logsPane;
    public javax.swing.JTextField mail;
    private javax.swing.JDesktopPane mainDk;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JButton remove;
    public javax.swing.JComboBox<String> st;
    public javax.swing.JLabel uID;
    public javax.swing.JButton update;
    public javax.swing.JTextField usn;
    public javax.swing.JComboBox<String> ut;
    private javax.swing.JPanel viewC;
    private javax.swing.JPanel viewPane;
    private javax.swing.JButton yesBT;
    // End of variables declaration//GEN-END:variables
}
