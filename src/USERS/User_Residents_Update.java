/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USERS;

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
    public class User_Residents_Update extends javax.swing.JFrame {

    /**
     * Creates new form admin_dashboard
     */
    public User_Residents_Update() {
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
    Color BlueBT = new Color(89,182,255);
    Color MainC = new Color(27,55,77);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    
 //  public String destination = "";
  // File selectedFile;
  // public String path;
 //  public String oldpath;

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
            System.out.println("Error occurred while updating the image: " + e);
        }
    } else {
        try {
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error on update!");
        }
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        addProfile = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
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
        household = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
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
        cancel = new javax.swing.JButton();

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
        jPanel3.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 140, 33));

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
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 430, 30, 33));

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
        jPanel3.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 30, 30));

        addProfile.setBackground(new java.awt.Color(255, 255, 255));
        addProfile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        addProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-image (1).png"))); // NOI18N
        addProfile.setText(" Edit Profile");
        addProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfileActionPerformed(evt);
            }
        });
        jPanel3.add(addProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 130, 30));

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
        jPanel6.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 50));

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

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setText("Household");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 90, 40));

        a10.setForeground(new java.awt.Color(255, 0, 0));
        a10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 130, 40));

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
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Select", "Single", "Married", "Widowed", "Separated" }));
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
               
              
 
           }

           rs.close();
                      
           }catch(SQLException ex){
                 System.out.println(""+ex);
         
        }
              
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

        String imagePathToUpdate = (destination == null || destination.isEmpty()) ? oldpath : destination;

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
            + "h_id = (SELECT h_id FROM tbl_household WHERE h_name = '" + household.getSelectedItem().toString() + "'), "
            + "r_image = '" + imagePathToUpdate + "' "
            + "WHERE r_id = '" + id.getText() + "'");


            if (!(oldpath.equals(path))) {
                imageUpdater(oldpath, path);
            }

        logEvent(userID, "IMPORT_NEW_RESIDENT", "Resident ID: " +  id.getText() + " data is updated by user.");

        JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
        User_Residents ru = new User_Residents();
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
        String stats = "Archive";

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
                
               logEvent(userID, "RESIDENT_ARCHIVED", "Resident ID: "+id.getText()+" data is archived by user.");
                
                User_Residents u = new User_Residents();
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

        User_Residents au = new User_Residents ();
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

    private void householdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_householdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_householdActionPerformed

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
            java.util.logging.Logger.getLogger(User_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Residents_Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new User_Residents_Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ACCOUNT_NAME;
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
    public javax.swing.JButton cancel;
    private javax.swing.JButton cancelBT;
    private javax.swing.JPanel confirmDel;
    public javax.swing.JLabel d;
    public javax.swing.JButton delete;
    public com.toedter.calendar.JDateChooser dob;
    public javax.swing.JTextField fn;
    public javax.swing.JComboBox<String> household;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mn;
    public javax.swing.JTextField occupation;
    public javax.swing.JTextField religion;
    public javax.swing.JButton remove;
    public javax.swing.JComboBox<String> sex;
    public javax.swing.JComboBox<String> status;
    private javax.swing.JButton yesBT;
    // End of variables declaration//GEN-END:variables
}
