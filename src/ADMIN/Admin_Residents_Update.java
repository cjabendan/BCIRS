/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import USERS.*;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SCC-COLLEGE
 */
    public class Admin_Residents_Update extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public Admin_Residents_Update() {
        initComponents();
        fn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        mn.setBorder(new EmptyBorder(0,10,0,0));
        ln.setBorder(new EmptyBorder(0,10,0,0));
        hname1.setBorder(new EmptyBorder(0,10,0,0));
        address2.setBorder(new EmptyBorder(0,10,0,0));
        address.setBorder(new EmptyBorder(0,10,0,0));
        occupation.setBorder(new EmptyBorder(0,10,0,0));
        religion.setBorder(new EmptyBorder(0,10,0,0));
    }
    
   
    Color Red = new Color(255,0,0);
    Color BlueBT = new Color(89,182,255);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
   
public String destination = "";
public String path = "";
public String oldpath = "";

File selectedFile;

public int FileExistenceChecker(String path) {
    File file = new File(path);
    String fileName = file.getName();
    Path filePath = Paths.get("src/r_images", fileName);
    boolean fileExists = Files.exists(filePath);
    return fileExists ? 1 : 0;
}

public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();
        return (int) ((double) desiredWidth / originalWidth * originalHeight);
    } catch (IOException ex) {
        System.out.println("No image found!");
    }
    return -1;
}

public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = (ImagePath != null) ? new ImageIcon(ImagePath) : new ImageIcon(pic);
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());
    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}

public void imageUpdater(String existingFilePath, String newFilePath) {
    File existingFile = new File(existingFilePath);
    File newFile = new File(newFilePath);

    // Ensure the new image is always stored in r_images
    String destinationFolder = "src/r_images/";
    File destinationFile = new File(destinationFolder, newFile.getName());

    try {
        // Create r_images folder if it doesn't exist
        File destinationDir = new File(destinationFolder);
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        // If the existing file is from u_default, don't delete it
        if (existingFile.getPath().contains("u_default")) {
            Files.copy(newFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("New image added successfully to r_images.");
        } else {
            // If the existing file is already in r_images, replace it
            if (existingFile.exists()) {
                Files.copy(newFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                existingFile.delete(); // Delete the old image in r_images
                System.out.println("Image updated successfully in r_images.");
            } else {
                // If no existing file, copy the new one to r_images
                Files.copy(newFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image added to r_images.");
            }
        }
    } catch (IOException e) {
        System.out.println("Error while updating the image: " + e.getMessage());
    }
}

 
    public void populateHouseholdComboBox(JComboBox<String> householdComboBox) {
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rsHousehold = dbc.getData("SELECT h_name FROM tbl_household");

            Vector<String> householdNames = new Vector<>();
            householdNames.add("Select household");

            while (rsHousehold.next()) {
                householdNames.add(rsHousehold.getString("h_name"));
            }

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(householdNames);
            householdComboBox.setModel(model);

            rsHousehold.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
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
        ACCOUNT_NAME = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cancelBT = new javax.swing.JButton();
        yesBT = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        houseAdd = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cancel3 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        addHouse = new javax.swing.JButton();
        purok1 = new javax.swing.JComboBox<>();
        address2 = new javax.swing.JTextField();
        hname1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        a12 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        houseAdd1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cancel4 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        hs4 = new javax.swing.JLabel();
        addHouse1 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        household = new javax.swing.JComboBox<>();
        a19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        addProfile = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        a7 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        a9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox<>();
        hs = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        occupation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mn = new javax.swing.JTextField();
        a3 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        religion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        a8 = new javax.swing.JLabel();
        hs1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        house = new javax.swing.JLabel();
        hs2 = new javax.swing.JLabel();
        hs3 = new javax.swing.JLabel();

        confirmDel.setBackground(new java.awt.Color(255, 255, 255));
        confirmDel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        confirmDel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        confirmDel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 420, 10));

        ACCOUNT_NAME.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ACCOUNT_NAME.setForeground(new java.awt.Color(89, 182, 255));
        ACCOUNT_NAME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACCOUNT_NAME.setText("SAMPLE");
        confirmDel.add(ACCOUNT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 420, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 57, 77));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Are you sure you want to archive resident?");
        confirmDel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 420, 20));

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

        jPanel5.setBackground(new java.awt.Color(27, 57, 77));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("NOTICE");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        confirmDel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

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
        jLabel36.setText("Household Name");
        houseAdd.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 20));

        jPanel8.setBackground(new java.awt.Color(27, 57, 77));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel8.add(cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 30, 30));

        jLabel37.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Register New Household");
        jPanel8.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        houseAdd.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        addHouse.setBackground(new java.awt.Color(27, 57, 77));
        addHouse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addHouse.setForeground(new java.awt.Color(255, 255, 255));
        addHouse.setText("Register Household");
        addHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouseActionPerformed(evt);
            }
        });
        houseAdd.add(addHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 170, 30));

        purok1.setBackground(new java.awt.Color(245, 246, 248));
        purok1.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        purok1.setForeground(new java.awt.Color(100, 115, 122));
        purok1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Tambis", "Mahogany", "Guyabano", "Ipil-Ipil", "Minsinitas", "Tugas", "Lubi" }));
        purok1.setBorder(null);
        purok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purok1ActionPerformed(evt);
            }
        });
        houseAdd.add(purok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 170, 24));

        address2.setBackground(new java.awt.Color(245, 246, 248));
        address2.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        address2.setForeground(new java.awt.Color(100, 115, 122));
        address2.setBorder(null);
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });
        houseAdd.add(address2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 230, 24));

        hname1.setBackground(new java.awt.Color(245, 246, 248));
        hname1.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        hname1.setForeground(new java.awt.Color(100, 115, 122));
        hname1.setBorder(null);
        hname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hname1ActionPerformed(evt);
            }
        });
        houseAdd.add(hname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, 24));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(27, 55, 77));
        jLabel31.setText(" Household cannot be edited nor be deleted once registered.");
        houseAdd.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 320, 20));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(27, 55, 77));
        jLabel35.setText("Note: ");
        houseAdd.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        a11.setForeground(new java.awt.Color(255, 0, 0));
        a11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a11.setText("*");
        houseAdd.add(a11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, 30));

        a12.setForeground(new java.awt.Color(255, 0, 0));
        a12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a12.setText("*");
        houseAdd.add(a12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 140, 30));

        a13.setForeground(new java.awt.Color(255, 0, 0));
        a13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a13.setText("*");
        houseAdd.add(a13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 30));

        houseAdd1.setBackground(new java.awt.Color(255, 255, 255));
        houseAdd1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        houseAdd1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        houseAdd1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 370, 20));

        jPanel9.setBackground(new java.awt.Color(27, 57, 77));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel4.setBackground(new java.awt.Color(255, 0, 0));
        cancel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cancel4.setForeground(new java.awt.Color(255, 255, 255));
        cancel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cross-small.png"))); // NOI18N
        cancel4.setBorder(null);
        cancel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel4MouseExited(evt);
            }
        });
        cancel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel4ActionPerformed(evt);
            }
        });
        jPanel9.add(cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Update Household");
        jPanel9.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 50));

        houseAdd1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

        hs4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hs4.setForeground(new java.awt.Color(27, 55, 77));
        hs4.setText("Household");
        houseAdd1.add(hs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 220, 30));

        addHouse1.setBackground(new java.awt.Color(27, 57, 77));
        addHouse1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addHouse1.setForeground(new java.awt.Color(255, 255, 255));
        addHouse1.setText("Update Household");
        addHouse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHouse1ActionPerformed(evt);
            }
        });
        houseAdd1.add(addHouse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 150, 30));

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(27, 55, 77));
        jLabel43.setText(" Household cannot be edited nor be deleted once registered.");
        houseAdd1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 310, 20));

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(27, 55, 77));
        jLabel44.setText("Note: ");
        houseAdd1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        household.setBackground(new java.awt.Color(245, 246, 248));
        household.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        household.setForeground(new java.awt.Color(100, 115, 122));
        household.setBorder(null);
        household.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                householdActionPerformed(evt);
            }
        });
        houseAdd1.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 310, 35));

        a19.setForeground(new java.awt.Color(255, 0, 0));
        a19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a19.setText("*");
        houseAdd1.add(a19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 170, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 235, 235)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add.setBackground(new java.awt.Color(27, 55, 77));
        Add.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Update data");
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
        jPanel3.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, 140, 33));

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
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 470, 30, 33));

        addProfile.setBackground(new java.awt.Color(255, 255, 255));
        addProfile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-image (1).png"))); // NOI18N
        addProfile.setText(" Edit Profile");
        addProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfileActionPerformed(evt);
            }
        });
        jPanel3.add(addProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 170, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 57, 77));
        jLabel19.setText("Resident ID:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, 30));

        id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(27, 57, 77));
        id.setText("Id number");
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 70, 30));

        jPanel7.setBackground(new java.awt.Color(245, 246, 248));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel7.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 170));

        jPanel6.setBackground(new java.awt.Color(27, 55, 77));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Update resident information");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 40));

        d.setBackground(new java.awt.Color(244, 244, 244));
        d.setFont(new java.awt.Font("Yu Gothic UI", 0, 11)); // NOI18N
        d.setForeground(new java.awt.Color(204, 204, 204));
        d.setText("Resident's purok address will be automatically set for every household. ");
        jPanel6.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, 50));

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
        jPanel6.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 33, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 70));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(27, 55, 77));
        jLabel12.setText("Last Name");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 100, 40));

        a1.setForeground(new java.awt.Color(255, 0, 0));
        a1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 140, 40));

        a4.setForeground(new java.awt.Color(255, 0, 0));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 140, 40));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("Address");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 80, 40));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 55, 77));
        jLabel7.setText("Date of Birth ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 150, 40));

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

        a7.setForeground(new java.awt.Color(255, 0, 0));
        a7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 140, 40));

        dob.setBackground(new java.awt.Color(255, 255, 255));
        dob.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 270, 35));

        a9.setForeground(new java.awt.Color(255, 0, 0));
        a9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 140, 40));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("Sex");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 80, 40));

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

        hs.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hs.setForeground(new java.awt.Color(27, 55, 77));
        hs.setText("Register to new household?");
        hs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hsMousePressed(evt);
            }
        });
        jPanel3.add(hs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 170, 40));

        a10.setForeground(new java.awt.Color(255, 0, 0));
        a10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 100, 40));

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

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 55, 77));
        jLabel15.setText("Occupation");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 100, 40));

        a5.setForeground(new java.awt.Color(255, 0, 0));
        a5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 140, 40));

        a2.setForeground(new java.awt.Color(255, 0, 0));
        a2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 140, 40));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(27, 55, 77));
        jLabel13.setText("First Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 100, 40));

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

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("Middle Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 100, 40));

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

        a3.setForeground(new java.awt.Color(255, 0, 0));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 140, 40));

        a6.setForeground(new java.awt.Color(255, 0, 0));
        a6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, 120, 40));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 55, 77));
        jLabel16.setText("Religion");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 100, 40));

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

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 55, 77));
        jLabel14.setText("Civil Status");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 160, 40));

        status.setBackground(new java.awt.Color(245, 246, 248));
        status.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        status.setForeground(new java.awt.Color(100, 115, 122));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Single", "Married", "Widowed", "Separated" }));
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel3.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 270, 35));

        a8.setForeground(new java.awt.Color(255, 0, 0));
        a8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 140, 40));

        hs1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hs1.setForeground(new java.awt.Color(27, 55, 77));
        hs1.setText(" Update Household");
        hs1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hs1MousePressed(evt);
            }
        });
        jPanel3.add(hs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 130, 40));

        jPanel2.setBackground(new java.awt.Color(245, 246, 248));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        house.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        house.setForeground(new java.awt.Color(100, 115, 122));
        jPanel2.add(house, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 35));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 270, 35));

        hs2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hs2.setForeground(new java.awt.Color(27, 55, 77));
        hs2.setText("Household");
        jPanel3.add(hs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 70, 40));

        hs3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        hs3.setForeground(new java.awt.Color(27, 55, 77));
        hs3.setText("or");
        jPanel3.add(hs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 20, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 20, 1120, 520);

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
        || sex.getSelectedIndex() == 0 || status.getSelectedIndex() == 0 ) {

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
    } else {
        
      try {
        dbConnector dbc = new dbConnector();
        String query = "SELECT r_image FROM tbl_residents WHERE r_id = '" + id.getText() + "'";
        ResultSet rs = dbc.getData(query);

        if (rs.next()) {
            oldpath = rs.getString("r_image");
            System.out.println("Old path set to: " + oldpath);
        } else {
            System.out.println("No record found for the given resident ID.");
        }

        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }  
        
        
      if (destination.isEmpty()) {
            destination = oldpath; 
        } else {
           
            if (!oldpath.equals(path)) {
                imageUpdater(oldpath, path);
            }
        }
         
         dbConnector dbc = new dbConnector();
         dbc.updateData("UPDATE tbl_residents SET "
             + "r_lname = '" + ln.getText() + "', "
             + "r_fname = '" + fn.getText() + "', "
             + "r_mname = '" + mn.getText() + "', "
             + "r_address = '" + address.getText() + "', "
             + "r_sex = '" + sex.getSelectedItem() + "', "
             + "r_dob = '" + new SimpleDateFormat("yyyy-MM-dd").format(dob.getDate()) + "', "
             + "r_civilstatus = '" + status.getSelectedItem() + "', "
             + "r_occupation = '" + occupation.getText() + "', "
             + "r_religion = '" + religion.getText() + "', "
             + "h_id = (SELECT h_id FROM tbl_household WHERE h_name = '" + house.getText() + "'), "
             + "r_image = '" + destination + "' "
             + "WHERE r_id = '" + id.getText() + "'");

        
         logEvent(userID, "EDITED RESIDENT DATA", "Resident ID: " + id.getText() + " data is updated by user: " + userID + ".");

        
         JOptionPane.showMessageDialog(null, "Data Updated Successfully!");

        
         Admin_Barangay ru = new Admin_Barangay();
         ru.setVisible(true);
         this.dispose();

    }

    }//GEN-LAST:event_AddActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(Red);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(MainC);
    }//GEN-LAST:event_deleteMouseExited

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         
        Object[] options = {};
            NoBorderDialog dialog = new NoBorderDialog(null, confirmDel);
            dialog.setVisible(true);


    }//GEN-LAST:event_deleteActionPerformed

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
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_addProfileActionPerformed

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
        
        String sql = "UPDATE tbl_residents SET r_status = ? WHERE r_id = ?";

        try (PreparedStatement pst = dbc.connect.prepareStatement(sql)) {

            pst.setString(1, stats);
            pst.setString(2, id.getText());
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                Window window = SwingUtilities.getWindowAncestor(confirmDel);
                window.dispose();
                JOptionPane.showMessageDialog(null, "User data archived.");
                
               logEvent(userID, "RESIDENT_ARCHIVED", "Resident ID: "+id.getText()+" data is archived by admin.");
                
                User_Purok u = new User_Purok();
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

       Admin_Barangay au = new Admin_Barangay();
       au.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_cancelActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void occupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_occupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_occupationActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void mnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnActionPerformed

    private void religionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_religionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_religionActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

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

    if (hname1.getText().isEmpty() || address2.getText().isEmpty() || purok1.getSelectedIndex() == 0) {
        if (hname1.getText().isEmpty()) {
            a1.setText("*");
        }
        if (address2.getText().isEmpty()) {
            a2.setText("*");
        }
        if (purok1.getSelectedIndex() == 0) {
            a3.setText("*");
        }
    } else {
        dbConnector dbc = new dbConnector();

        try {
            // Insert into tbl_household
            String query = "INSERT INTO tbl_household (h_name, h_address, p_id) VALUES (?, ?, ?)";
            PreparedStatement pst = dbc.connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, hname1.getText());
            pst.setString(2, address2.getText());
            pst.setInt(3, purok1.getSelectedIndex());

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                
                // Retrieve the generated h_id
                ResultSet generatedKeys = pst.getGeneratedKeys();
                int newHouseholdId = 0;
                if (generatedKeys.next()) {
                    newHouseholdId = generatedKeys.getInt(1);
                }

               
                String residentId = id.getText();

                // Insert into tbl_resident
                String residentQuery = "UPDATE tbl_residents SET h_id = ? WHERE r_id = ?";
                PreparedStatement residentPst = dbc.connect.prepareStatement(residentQuery);
                residentPst.setInt(1, newHouseholdId);
                residentPst.setString(2, residentId);

                int residentUpdated = residentPst.executeUpdate();

                if (residentUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Household Registered Successfully and Resident Updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Household Registered, but Resident Update Failed.");
                }

                logEvent(userID, "NEW_HOUSEHOLD", "Household: " + hname1.getText() + " is added by user.");

                house.setText(hname1.getText());
                
                Window window = SwingUtilities.getWindowAncestor(houseAdd);
                window.dispose();

                hname1.setText("");
                address2.setText("");
                purok1.setSelectedIndex(0);

                residentPst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Error registering household.");
            }

            pst.close();

        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_addHouseActionPerformed

    private void purok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purok1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purok1ActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void hname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hname1ActionPerformed

    private void hsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hsMousePressed
        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, houseAdd);
        dialog.setVisible(true);
    }//GEN-LAST:event_hsMousePressed

    private void cancel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseClicked

    private void cancel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseEntered

    private void cancel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4MouseExited

    private void cancel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel4ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(houseAdd1);
        window.dispose();
    }//GEN-LAST:event_cancel4ActionPerformed

    private void addHouse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHouse1ActionPerformed
        Session sess = Session.getInstance();
    int userID = sess.getUid();

    // Clear error markers
    a19.setText("");

    if (household.getSelectedItem() == null || id.getText().isEmpty()) {
        if (household.getSelectedItem() == null) {
            a19.setText("*");
        }
        JOptionPane.showMessageDialog(null, "Please select a household and ensure Resident ID is filled.");
        return;
    }

    dbConnector dbc = new dbConnector();

    try {
        // Get selected household details
        String selectedHousehold = household.getSelectedItem().toString(); // Assumes this dropdown contains household names
        int selectedHouseholdId = getHouseholdIdByName(selectedHousehold, dbc); // Helper function to fetch h_id by name

        if (selectedHouseholdId == 0) {
            JOptionPane.showMessageDialog(null, "Household not found.");
            return;
        }

        // Get Resident ID from the text field
        String residentId = id.getText();

        // Update tbl_residents with the selected h_id
        String residentQuery = "UPDATE tbl_residents SET h_id = ? WHERE r_id = ?";
        PreparedStatement residentPst = dbc.connect.prepareStatement(residentQuery);
        residentPst.setInt(1, selectedHouseholdId);
        residentPst.setString(2, residentId);

        int rowsUpdated = residentPst.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Resident's household updated successfully!");

            // Update the `house` text field to reflect the new household name
            house.setText(selectedHousehold);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to update Resident's household. Check Resident ID.");
        }

        residentPst.close();

    } catch (SQLException ex) {
        System.out.println("Database Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_addHouse1ActionPerformed

    private int getHouseholdIdByName(String householdName, dbConnector dbc) {
    int householdId = 0;
    try {
        String query = "SELECT h_id FROM tbl_household WHERE h_name = ?";
        PreparedStatement pst = dbc.connect.prepareStatement(query);
        pst.setString(1, householdName);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            householdId = rs.getInt("h_id");
        }

        rs.close();
        pst.close();
    } catch (SQLException ex) {
        System.out.println("Error fetching household ID: " + ex.getMessage());
    }
    return householdId;
}

    
    private void hs1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hs1MousePressed
        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, houseAdd1);
        dialog.setVisible(true);
    }//GEN-LAST:event_hs1MousePressed

    private void householdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_householdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_householdActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_Residents_Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ACCOUNT_NAME;
    public javax.swing.JButton Add;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JLabel a13;
    private javax.swing.JLabel a19;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JButton addHouse;
    private javax.swing.JButton addHouse1;
    public javax.swing.JButton addProfile;
    public javax.swing.JTextField address;
    public javax.swing.JTextField address2;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel3;
    public javax.swing.JButton cancel4;
    private javax.swing.JButton cancelBT;
    private javax.swing.JPanel confirmDel;
    public javax.swing.JLabel d;
    public javax.swing.JButton delete;
    public com.toedter.calendar.JDateChooser dob;
    public javax.swing.JTextField fn;
    public javax.swing.JTextField hname1;
    public javax.swing.JLabel house;
    private javax.swing.JPanel houseAdd;
    private javax.swing.JPanel houseAdd1;
    public javax.swing.JComboBox<String> household;
    public javax.swing.JLabel hs;
    public javax.swing.JLabel hs1;
    public javax.swing.JLabel hs2;
    public javax.swing.JLabel hs3;
    public javax.swing.JLabel hs4;
    public javax.swing.JLabel id;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mn;
    public javax.swing.JTextField occupation;
    public javax.swing.JComboBox<String> purok1;
    public javax.swing.JTextField religion;
    public javax.swing.JComboBox<String> sex;
    public javax.swing.JComboBox<String> status;
    private javax.swing.JButton yesBT;
    // End of variables declaration//GEN-END:variables
}
