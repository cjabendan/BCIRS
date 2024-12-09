/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import bcirs.login_form;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import config.RoundPanel;
import config.Session;
import config.dbConnector;
import enhancer.GradientPanel;
import enhancer.NoBorderDialog;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Christian James Abendan
 */
public class Admin_Barangay_Charts extends javax.swing.JFrame {

    
    DefaultListModel listModel = new DefaultListModel();
   
    
    public Admin_Barangay_Charts() {
        initComponents();
        barangayPanel();
        countDis();
        ex();
    }
    
     private void barangayPanel(){
      
        RoundPanel rounded = new RoundPanel(new Color(27, 57, 77), 10);
        rounded.setBounds(0, 0, 370, 280);
        
        barangayPanel.setLayout(null); 
        barangayPanel.add(rounded);
        barangayPanel.repaint();
        barangayPanel.revalidate();
          
  }
     
    
     private void ex(){
        GradientPanel gradientPanel = new GradientPanel();
        ex.setLayout(new BorderLayout());

       ex.add(gradientPanel);
      
         ex.repaint();
         ex.revalidate();
     }
     
     
     
 private void countDis() {
    try {
        dbConnector dbc = new dbConnector();

      String query = "SELECT " +
               "(SELECT COUNT(*) FROM tbl_household) AS total_household_count, " +
               "(SELECT COUNT(*) FROM tbl_residents WHERE r_sex = 'Male' AND r_status = 'Active') AS total_male, " +
               "(SELECT COUNT(*) FROM tbl_residents WHERE r_sex = 'Female' AND r_status = 'Active') AS total_female, " +
               "(SELECT COUNT(*) FROM tbl_residents WHERE r_status = 'Archived') AS total_archived, " +
               "(SELECT COUNT(*) FROM tbl_reports WHERE inc_status = 'Open') AS total_reps, " +
               "(SELECT COUNT(*) FROM tbl_residents " +
               " WHERE TIMESTAMPDIFF(YEAR, r_dob, CURDATE()) BETWEEN 0 AND 12 AND r_status = 'Active') AS total_children, " +
               "(SELECT COUNT(*) FROM tbl_residents " +
               " WHERE TIMESTAMPDIFF(YEAR, r_dob, CURDATE()) BETWEEN 13 AND 19 AND r_status = 'Active') AS total_teenagers, " +
               "(SELECT COUNT(*) FROM tbl_residents " +
               " WHERE TIMESTAMPDIFF(YEAR, r_dob, CURDATE()) BETWEEN 20 AND 59 AND r_status = 'Active') AS total_adults, " +
               "(SELECT COUNT(*) FROM tbl_residents " +
               " WHERE TIMESTAMPDIFF(YEAR, r_dob, CURDATE()) >= 60 AND r_status = 'Active') AS total_seniors";


        ResultSet rs = dbc.getData(query);

        if (rs.next()) {
            int totalHousehold = rs.getInt("total_household_count");
            int totalMale = rs.getInt("total_male");
            int totalFemale = rs.getInt("total_female");
            int totalArchived = rs.getInt("total_archived");
            int totalReps = rs.getInt("total_reps");
            int totalChildren = rs.getInt("total_children");
            int totalTeenagers = rs.getInt("total_teenagers");
            int totalAdults = rs.getInt("total_adults");
            int totalSeniors = rs.getInt("total_seniors");

            
            
           DecimalFormat formatter = new DecimalFormat("#,###");

            // Set text fields with formatted values
          
            male.setText(formatter.format(totalMale));
            fem.setText(formatter.format(totalFemale));
            populationCount.setText(formatter.format(totalMale + totalFemale));
            children.setText(formatter.format(totalChildren));   // Update for children
            teenagers.setText(formatter.format(totalTeenagers)); // Update for teenagers
            adults.setText(formatter.format(totalAdults));       // Update for adults
            seniors.setText(formatter.format(totalSeniors));     // Update for seniors
            
            /*
            ttl_household.setText(" " + totalHousehold);
          
            arch.setText(" " + totalArchived);
            reps.setText(" " + totalReps);
           
           
                */
            // showBarChart( totalAdults, totalTeenagers, totalChildren, totalSeniors);
             showPieChart( totalAdults, totalTeenagers, totalChildren, totalSeniors);
        }

        rs.close(); // Close the result set
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
/*
private void showBarChart(
    int totalAdults, 
    int totalTeenagers, 
    int totalChildren, 
    int totalSeniors
) {
    // Create the dataset
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Populate the dataset with the data
    dataset.setValue(totalAdults, "Count", "Adults");
    dataset.setValue(totalTeenagers, "Count", "Teens");
    dataset.setValue(totalChildren, "Count", "Children");   
    dataset.setValue(totalSeniors, "Count", "Seniors");

    // Create the chart
    JFreeChart chart = ChartFactory.createBarChart(
        "", // Title
        "",           // Category Axis Label
        "",              // Value Axis Label
        dataset,              // Dataset
        PlotOrientation.VERTICAL,
        false,                // Legend
        true,                 // Tooltips
        false                 // URLs
    );

    // Customize the plot
    CategoryPlot categoryPlot = chart.getCategoryPlot();
    categoryPlot.setRangeGridlinePaint(Color.LIGHT_GRAY); // Enable gridlines
    categoryPlot.setBackgroundPaint(Color.WHITE);
    
     categoryPlot.getRangeAxis().setVisible(false);

    // Customize the renderer
      BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
    
    // Assign the new color (1B374D) to each category
    Color barColor = new Color(27, 55, 77);  // The color you requested
    renderer.setSeriesPaint(0, barColor);     // Adults (20-59)
    renderer.setSeriesPaint(1, barColor);     // Teenagers (13-19)
    renderer.setSeriesPaint(2, barColor);     // Children (0-12)
    renderer.setSeriesPaint(3, barColor);     // Seniors (60+)

    // Adjust the bar width (slimmer bars)
    renderer.setMaximumBarWidth(.10); // Set the width to be slimmer

   
    // Add the chart to the PanelChart
    ChartPanel barChartPanel = new ChartPanel(chart);
    barChartPanel.setPreferredSize(new Dimension(PanelChart.getWidth(), PanelChart.getHeight()));

    PanelChart.removeAll();
    PanelChart.add(barChartPanel, BorderLayout.CENTER);
    PanelChart.validate();
}
*/
private void showPieChart(
       int totalAdults, 
       int totalTeenagers, 
       int totalChildren, 
         int totalSeniors
) {
    // Create the dataset for Pie chart
    DefaultPieDataset dataset = new DefaultPieDataset();

    // Populate the dataset with the data
    dataset.setValue("Adults (20-59)", totalAdults);
    dataset.setValue("Teenagers (13-19)", totalTeenagers);
    dataset.setValue("Children (0-12)", totalChildren);   
    dataset.setValue("Seniors (60+)", totalSeniors);

    // Create the Pie chart
    JFreeChart chart = ChartFactory.createPieChart(
        "", // Title
        dataset,               // Dataset
        false,                  // Show legend
        true,                   // Show tooltips
        false                   // No URLs
    );

    // Remove the legend after chart creation
    chart.removeLegend();
    
    // Customize the plot to remove the dataset labels
    PiePlot plot = (PiePlot) chart.getPlot();

    // Set the colors for the sections
    plot.setSectionPaint("Adults (20-59)", new Color(27,159,247));  // Deep Blue
    plot.setSectionPaint("Teenagers (13-19)", new Color(255, 87, 51));  // Orange-Red
    plot.setSectionPaint("Children (0-12)", new Color(102, 205, 170)); // Medium Aquamarine
    plot.setSectionPaint("Seniors (60+)",new Color(255, 255, 102)); // Light Gray

    // Remove the section outlines (borders around the sections)
    plot.setSectionOutlineStroke(new BasicStroke(0));

    // Remove the outline (border) around the pie chart
    plot.setOutlineStroke(new BasicStroke(0));  // Remove the border around the whole pie chart

    // Hide the dataset values in the pie chart (i.e., the labels for each section)
    plot.setLabelGenerator(null);  // Remove labels from the pie chart slices

    // Set the background color of the plot to white
    plot.setBackgroundPaint(Color.WHITE);

    // Remove any border from the ChartPanel
    ChartPanel pieChartPanel = new ChartPanel(chart);
    pieChartPanel.setPreferredSize(new Dimension(PieChart.getWidth(), PieChart.getHeight()));
    
    // Set the background to transparent and remove borders
    pieChartPanel.setBorder(BorderFactory.createEmptyBorder());
    pieChartPanel.setBackground(Color.WHITE);

    PieChart.removeAll();
    PieChart.add(pieChartPanel, BorderLayout.CENTER);
    PieChart.validate();
}

 
     
    Color Panecolor = new Color(242,242,242);
    Color PaneNcolor = new Color(255,255,255);
    
    Color darktxt = new Color(27,57,77);
    Color Bluetxt = new Color(89,182,255);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        download = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        cancel3 = new javax.swing.JButton();
        print2 = new javax.swing.JButton();
        dl = new javax.swing.JComboBox<>();
        a3 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        download1 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        cancel4 = new javax.swing.JButton();
        print3 = new javax.swing.JButton();
        dl1 = new javax.swing.JComboBox<>();
        a5 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
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
        logoff = new javax.swing.JPanel();
        logoffbg = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        logs = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logsPane = new javax.swing.JPanel();
        settingsBg = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        dot = new javax.swing.JLabel();
        settingsPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        barangayPanel = new javax.swing.JPanel();
        housePanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        male = new javax.swing.JLabel();
        housePanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fem = new javax.swing.JLabel();
        housePanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        fem1 = new javax.swing.JLabel();
        populationCount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PieChart = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ex = new javax.swing.JPanel();
        senp = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        seniors = new javax.swing.JLabel();
        childp = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        children = new javax.swing.JLabel();
        adultp = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        adults = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        teenp = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        teenagers = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        download.setBackground(new java.awt.Color(255, 255, 255));
        download.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        download.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        download.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 380, 10));

        jPanel11.setBackground(new java.awt.Color(27, 57, 77));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Download Residents Data");
        jPanel11.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

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
        jPanel11.add(cancel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        download.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 50));

        print2.setBackground(new java.awt.Color(27, 57, 77));
        print2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print2.setForeground(new java.awt.Color(255, 255, 255));
        print2.setText("GENERATE");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });
        download.add(print2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 30));

        dl.setBackground(new java.awt.Color(245, 246, 248));
        dl.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        dl.setForeground(new java.awt.Color(27, 57, 77));
        dl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "All Residents", "Tambis Residents", "Mahogany Residents", "Guyabano Residents", "Ipil-ipil Residents", "Minsinitas Residents", "Tugas Residents", "Lubi Residents" }));
        dl.setBorder(null);
        dl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlActionPerformed(evt);
            }
        });
        download.add(dl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, 30));

        a3.setForeground(new java.awt.Color(255, 0, 0));
        a3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a3.setText("*");
        download.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 30, 30));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(27, 57, 77));
        jLabel43.setText("Select data to download");
        download.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));

        a4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 0, 0));
        a4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a4.setText("*");
        download.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, 20));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(27, 57, 77));
        jLabel32.setText("File name:");
        download.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 20));
        download.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 320, 30));

        download1.setBackground(new java.awt.Color(255, 255, 255));
        download1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        download1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        download1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 380, 10));

        jPanel12.setBackground(new java.awt.Color(27, 57, 77));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Download Residents Data");
        jPanel12.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

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
        jPanel12.add(cancel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        download1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 50));

        print3.setBackground(new java.awt.Color(27, 57, 77));
        print3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        print3.setForeground(new java.awt.Color(255, 255, 255));
        print3.setText("GENERATE");
        print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print3ActionPerformed(evt);
            }
        });
        download1.add(print3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 110, 30));

        dl1.setBackground(new java.awt.Color(245, 246, 248));
        dl1.setFont(new java.awt.Font("Yu Gothic UI", 0, 10)); // NOI18N
        dl1.setForeground(new java.awt.Color(27, 57, 77));
        dl1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "All Residents", "Tambis Residents", "Mahogany Residents", "Guyabano Residents", "Ipil-ipil Residents", "Minsinitas Residents", "Tugas Residents", "Lubi Residents" }));
        dl1.setBorder(null);
        dl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dl1ActionPerformed(evt);
            }
        });
        download1.add(dl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, 30));

        a5.setForeground(new java.awt.Color(255, 0, 0));
        a5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a5.setText("*");
        download1.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 30, 30));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(27, 57, 77));
        jLabel46.setText("Select data to download");
        download1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, 30));

        a6.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        a6.setForeground(new java.awt.Color(255, 0, 0));
        a6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        a6.setText("*");
        download1.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 200, 20));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(27, 57, 77));
        jLabel47.setText("File name:");
        download1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, 20));
        download1.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 320, 30));

        download.add(download1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dash_F.png"))); // NOI18N
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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 55, 77));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/users_F.png"))); // NOI18N
        jLabel5.setText(" Users");
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

        viewPane.setBackground(new java.awt.Color(255, 255, 255));
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

        purokPane.setBackground(new java.awt.Color(27, 57, 77));
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
        jLabel6.setForeground(new java.awt.Color(57, 55, 77));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/house-building.png"))); // NOI18N
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

        adm_nav.add(purokC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

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

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(57, 55, 77));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit (3).png"))); // NOI18N
        jLabel28.setText(" Log out");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout logoffbgLayout = new javax.swing.GroupLayout(logoffbg);
        logoffbg.setLayout(logoffbgLayout);
        logoffbgLayout.setHorizontalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoffbgLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        logoffbgLayout.setVerticalGroup(
            logoffbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoffbgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        adm_nav.add(logoffbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder-open (1).png"))); // NOI18N
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
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings (4).png"))); // NOI18N
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
        jLabel2.setText("Purok Link");
        adm_nav.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 12, 180, 50));

        jPanel1.add(adm_nav);
        adm_nav.setBounds(-10, -10, 190, 580);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(27, 55, 77));
        jLabel11.setText("Population Breakdown");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(200, 340, 350, 50);

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
        cancel.setBounds(1110, 20, 33, 30);

        barangayPanel.setBackground(new java.awt.Color(27, 55, 77));
        barangayPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        housePanel1.setBackground(new java.awt.Color(255, 255, 255));
        housePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(27, 57, 77));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Male Resident");
        housePanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        male.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        male.setForeground(new java.awt.Color(27, 57, 77));
        male.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        male.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/avatar.png"))); // NOI18N
        male.setText(" 0");
        housePanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 70));

        barangayPanel.add(housePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 90));

        housePanel2.setBackground(new java.awt.Color(255, 255, 255));
        housePanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(27, 57, 77));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Female Resident");
        housePanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        fem.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        fem.setForeground(new java.awt.Color(27, 57, 77));
        fem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem.setText(" 0");
        housePanel2.add(fem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 70));

        housePanel3.setBackground(new java.awt.Color(255, 255, 255));
        housePanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(27, 57, 77));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Female Resident");
        housePanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        fem1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        fem1.setForeground(new java.awt.Color(27, 57, 77));
        fem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/woman-avatar.png"))); // NOI18N
        fem1.setText(" 0");
        housePanel3.add(fem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 30));

        housePanel2.add(housePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 110, 70));

        barangayPanel.add(housePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 150, 90));

        populationCount.setFont(new java.awt.Font("SansSerif", 1, 62)); // NOI18N
        populationCount.setForeground(new java.awt.Color(255, 255, 255));
        populationCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        populationCount.setText(" 0");
        barangayPanel.add(populationCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 370, 140));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total Population");
        barangayPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        jPanel1.add(barangayPanel);
        barangayPanel.setBounds(200, 60, 370, 280);

        jPanel2.setBackground(new java.awt.Color(27, 55, 77));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 57, 77)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 55, 77)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PieChart.setLayout(new java.awt.BorderLayout());
        jPanel3.add(PieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 210));

        jPanel5.setBackground(new java.awt.Color(27, 159, 247));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 50, 20));

        jPanel6.setBackground(new java.awt.Color(102, 205, 170));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 50, -1));

        jPanel7.setBackground(new java.awt.Color(255, 87, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 50, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 50, -1));

        jLabel1.setBackground(new java.awt.Color(27, 55, 77));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 55, 77));
        jLabel1.setText("Seniors");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 110, 20));

        jLabel4.setBackground(new java.awt.Color(27, 55, 77));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 55, 77));
        jLabel4.setText("Adult");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 110, 20));

        jLabel8.setBackground(new java.awt.Color(27, 55, 77));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(27, 55, 77));
        jLabel8.setText("Children");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 110, 20));

        jLabel10.setBackground(new java.awt.Color(27, 55, 77));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(27, 55, 77));
        jLabel10.setText("Teenagers");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 110, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 560, 230));

        jLabel7.setBackground(new java.awt.Color(27, 55, 77));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Resident Classification");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(580, 60, 560, 280);

        ex.setPreferredSize(new java.awt.Dimension(120, 130));
        ex.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        senp.setBackground(new java.awt.Color(255, 255, 255));
        senp.setLayout(null);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile-user (1)_1.png"))); // NOI18N
        senp.add(jLabel13);
        jLabel13.setBounds(140, 40, 64, 70);

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(27, 55, 77));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("COUNT");
        senp.add(jLabel30);
        jLabel30.setBounds(0, 20, 110, 40);

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(27, 55, 77));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("SENIORS");
        senp.add(jLabel21);
        jLabel21.setBounds(0, 0, 120, 40);

        seniors.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        seniors.setForeground(new java.awt.Color(27, 55, 77));
        seniors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seniors.setText(" 0");
        senp.add(seniors);
        seniors.setBounds(0, 50, 120, 70);

        ex.add(senp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 220, 120));

        childp.setBackground(new java.awt.Color(255, 255, 255));
        childp.setLayout(null);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile-user (2).png"))); // NOI18N
        childp.add(jLabel24);
        jLabel24.setBounds(140, 40, 64, 70);

        jLabel29.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(27, 55, 77));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("COUNT");
        childp.add(jLabel29);
        jLabel29.setBounds(0, 20, 110, 40);

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(27, 55, 77));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("CHILDREN");
        childp.add(jLabel20);
        jLabel20.setBounds(0, 0, 130, 40);

        children.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        children.setForeground(new java.awt.Color(27, 55, 77));
        children.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        children.setText(" 0");
        childp.add(children);
        children.setBounds(0, 50, 120, 70);

        ex.add(childp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 220, 120));

        adultp.setBackground(new java.awt.Color(255, 255, 255));
        adultp.setLayout(null);

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(27, 55, 77));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("COUNT");
        adultp.add(jLabel19);
        jLabel19.setBounds(0, 20, 110, 40);

        adults.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        adults.setForeground(new java.awt.Color(27, 55, 77));
        adults.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adults.setText(" 0");
        adultp.add(adults);
        adults.setBounds(0, 50, 120, 70);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile-user.png"))); // NOI18N
        adultp.add(jLabel22);
        jLabel22.setBounds(140, 40, 64, 70);

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(27, 55, 77));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ADULTS ");
        adultp.add(jLabel25);
        jLabel25.setBounds(0, 0, 120, 40);

        ex.add(adultp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 120));

        teenp.setBackground(new java.awt.Color(255, 255, 255));
        teenp.setLayout(null);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile-user (1).png"))); // NOI18N
        teenp.add(jLabel23);
        jLabel23.setBounds(130, 40, 64, 70);

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(27, 55, 77));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("COUNT");
        teenp.add(jLabel26);
        jLabel26.setBounds(0, 20, 110, 40);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(27, 55, 77));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("TEENAGERS");
        teenp.add(jLabel15);
        jLabel15.setBounds(0, 0, 140, 40);

        teenagers.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        teenagers.setForeground(new java.awt.Color(27, 55, 77));
        teenagers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teenagers.setText(" 0");
        teenp.add(teenagers);
        teenagers.setBounds(0, 50, 110, 70);

        ex.add(teenp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 210, 120));

        jPanel1.add(ex);
        ex.setBounds(200, 390, 940, 160);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 55, 77));
        jLabel14.setText("Barangay, Pob. Ward II | Analytics Report");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(200, 0, 350, 60);

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DOWNLOAD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1020, 350, 120, 30);

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

    private void viewPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseEntered

    private void viewPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaneMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewPaneMouseExited

    private void dashCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseEntered
       dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_dashCMouseEntered

    private void dashCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseExited
        
    }//GEN-LAST:event_dashCMouseExited

    private void viewCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseEntered
        viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_viewCMouseEntered

    private void viewCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseExited
        viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_viewCMouseExited

    private void purokPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseEntered
     //   purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokPaneMouseEntered

    private void purokPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokPaneMouseExited
    //    purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokPaneMouseExited

    private void purokCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseEntered
        // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_purokCMouseEntered

    private void purokCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseExited
      //   purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_purokCMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void viewCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewCMouseClicked
       Admin_RegUsers vtbl = new Admin_RegUsers();
        vtbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewCMouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        dashPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
          viewPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
          viewPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       //Admin_Barangay ab = new Admin_Barangay();
      // ab.setVisible(true);
      // this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
       // purokPane.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
       //  purokPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      Session sess = Session.getInstance();
       
       if(sess.getUid() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Log in First! ","Notice", JOptionPane.ERROR_MESSAGE);
            login_form lgf = new login_form();
            lgf.setVisible(true);
            this.dispose();
       }else{
           
            try {
             dbConnector dbc = new dbConnector();
             ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + sess.getUid() + "'");
            
             
             if (rs.next()) {
                 String code = rs.getString("u_code");

                 if (code.equals("")) {
                     dot.setText("•");
                 } else {
                     dot.setText("");
                 }
             }

             rs.close();
            
         } catch (SQLException ex) {
             System.out.println("Errors: " + ex.getMessage());
         }
         
       }
       
    }//GEN-LAST:event_formWindowActivated

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        dashPane.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel3MouseExited

    private void dashCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashCMouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashCMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        admin_dashboard ad = new admin_dashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void purokCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokCMouseClicked
 
    }//GEN-LAST:event_purokCMouseClicked

    private void logoffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseEntered

    private void logoffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffMouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Session sess = Session.getInstance();
        
        int userId = sess.getUid();
        
        logEvent(userId, "LOGOUT", "User logged out");

       
        login_form ads = new login_form();
        JOptionPane.showMessageDialog(null, "Log out successfully!");
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_jLabel28MouseExited

    private void logoffbgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoffbgMouseClicked

    private void logoffbgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseEntered
        logoff.setBackground(Panecolor);
    }//GEN-LAST:event_logoffbgMouseEntered

    private void logoffbgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoffbgMouseExited
        logoff.setBackground(PaneNcolor);
    }//GEN-LAST:event_logoffbgMouseExited

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

    private void logsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsMouseClicked
        Admin_Logs al = new Admin_Logs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logsMouseClicked

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

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(Red);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(MainC);
    }//GEN-LAST:event_cancelMouseExited

    Color Red = new Color(255,0,0);
    Color MainC = new Color(27,55,77);
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        Admin_Barangay ru = new Admin_Barangay();
        ru.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Object[] options = {};
        NoBorderDialog dialog = new NoBorderDialog(null, download);
        dialog.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cancel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseClicked

    private void cancel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseEntered

    private void cancel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel3MouseExited

    private void cancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel3ActionPerformed
        Window window = SwingUtilities.getWindowAncestor(download);
        window.dispose();
    }//GEN-LAST:event_cancel3ActionPerformed

    private void print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2ActionPerformed

        Session sess = Session.getInstance();

        int userID = sess.getUid();

        a3.setText("");
        a4.setText("");

        if (dl.getSelectedIndex() == 0 || nameField.getText().isEmpty()) {
            a3.setText("*");
            a4.setText("*");
            JOptionPane.showMessageDialog(null, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = nameField.getText() + ".pdf";
            String location = System.getProperty("user.home") + "/Documents/";

            try {
                dbConnector dbc = new dbConnector();

                String selectedCategory = dl.getSelectedItem().toString(); // Assume a dropdown
                String query;

                switch (selectedCategory) {
                    case "All Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Tambis Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Tambis' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Mahogany Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Mahogany' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Guyabano Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Guyabano' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Ipil-ipil Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r.civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Ipil-ipil' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Minsinitas Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Minsinitas' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Tugas Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Tugas' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    case "Lubi Residents":
                    query = "SELECT r.r_id, r.r_fname, r.r_mname, r.r_lname, "
                    + "YEAR(CURDATE()) - YEAR(r.r_dob) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(r.r_dob, '%m%d')) AS r_age, "
                    + "r.r_sex, r.r_civilstatus, r.r_occupation, p.p_name AS r_purok "
                    + "FROM tbl_residents r "
                    + "JOIN tbl_household h ON r.h_id = h.h_id "
                    + "JOIN tbl_purok p ON h.p_id = p.p_id "
                    + "WHERE p.p_name = 'Lubi' AND r.r_status != 'Archived' "
                    + "ORDER BY r.r_lname ASC";
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Invalid selection!");
                    return;
                }

                ResultSet resultSet = dbc.getData(query);

                com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A5.rotate());
                PdfWriter.getInstance(document, new FileOutputStream(location + name));
                document.open();

                PdfPTable pdfPTable = new PdfPTable(9); // Adjusted to 9 columns (removed Actions column)
                pdfPTable.setWidthPercentage(100); // Make table width span the entire page
                pdfPTable.setSpacingBefore(10f);
                pdfPTable.setSpacingAfter(10f);
                Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
                PdfPCell cell;

                // Add table headers with design improvements
                String[] headers = {"ID", "FIRST", "MIDDLE", "LAST", "AGE", "SEX", "CS", "OCC.", "PUROK"};

                float[] columnWidths = {15f, 20f, 20f, 20f, 15f, 15f, 20f, 20f, 20f}; // Adjust these values to fit the columns properly
                pdfPTable.setWidths(columnWidths);

                // Loop through each header and set cell properties
                for (String header : headers) {
                    cell = new PdfPCell(new Phrase(header, headerFont));
                    cell.setBackgroundColor(BaseColor.DARK_GRAY);  // Set background color for headers
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Center align the text
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Vertically center the text
                    cell.setPadding(20f); // Set padding for header to fit better
                    cell.setNoWrap(true); // Disable text wrapping for the header
                    pdfPTable.addCell(cell);
                }

                // Populate table with data from ResultSet
                while (resultSet.next()) {
                    pdfPTable.addCell(resultSet.getString("r_id"));
                    pdfPTable.addCell(resultSet.getString("r_fname"));
                    pdfPTable.addCell(resultSet.getString("r_mname"));
                    pdfPTable.addCell(resultSet.getString("r_lname"));
                    pdfPTable.addCell(resultSet.getString("r_age"));
                    pdfPTable.addCell(resultSet.getString("r_sex"));
                    pdfPTable.addCell(resultSet.getString("r_civilstatus"));
                    pdfPTable.addCell(resultSet.getString("r_occupation"));
                    pdfPTable.addCell(resultSet.getString("r_purok"));
                }

                // Add the table to the document
                document.add(pdfPTable);
                document.close();

                JOptionPane.showMessageDialog(null, "Download Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                Window window = SwingUtilities.getWindowAncestor(download);
                window.dispose();

                // Log the event
                logEvent(userID, "RESIDENT_DOCUMENT_DOWNLOAD", "Data: " + selectedCategory + " is downloaded by user.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_print2ActionPerformed

    private void dlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4ActionPerformed

    private void print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print3ActionPerformed

    private void dl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dl1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Barangay_Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Barangay_Charts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin_Barangay_Charts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PieChart;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JPanel adm_nav;
    private javax.swing.JPanel adultp;
    private javax.swing.JLabel adults;
    private javax.swing.JPanel barangayPanel;
    public javax.swing.JButton cancel;
    public javax.swing.JButton cancel3;
    public javax.swing.JButton cancel4;
    private javax.swing.JPanel childp;
    private javax.swing.JLabel children;
    private javax.swing.JPanel dashC;
    private javax.swing.JPanel dashPane;
    public javax.swing.JComboBox<String> dl;
    public javax.swing.JComboBox<String> dl1;
    private javax.swing.JLabel dot;
    private javax.swing.JPanel download;
    private javax.swing.JPanel download1;
    private javax.swing.JPanel ex;
    private javax.swing.JLabel fem;
    private javax.swing.JLabel fem1;
    private javax.swing.JPanel housePanel1;
    private javax.swing.JPanel housePanel2;
    private javax.swing.JPanel housePanel3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel logoff;
    private javax.swing.JPanel logoffbg;
    private javax.swing.JPanel logs;
    private javax.swing.JPanel logsPane;
    private javax.swing.JLabel male;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nameField1;
    private javax.swing.JLabel populationCount;
    private javax.swing.JButton print2;
    private javax.swing.JButton print3;
    private javax.swing.JPanel purokC;
    private javax.swing.JPanel purokPane;
    private javax.swing.JLabel seniors;
    private javax.swing.JPanel senp;
    private javax.swing.JPanel settingsBg;
    private javax.swing.JPanel settingsPane;
    private javax.swing.JLabel teenagers;
    private javax.swing.JPanel teenp;
    private javax.swing.JPanel viewC;
    private javax.swing.JPanel viewPane;
    // End of variables declaration//GEN-END:variables
}
