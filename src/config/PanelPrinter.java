package config;

import java.awt.*;
import java.awt.print.*;
import javax.swing.JPanel;

public class PanelPrinter implements Printable {

    private JPanel panelToPrint;

    public PanelPrinter(JPanel panelToPrint) {
        this.panelToPrint = panelToPrint;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;  // Return NO_SUCH_PAGE if more than one page is requested
        }
        
        Graphics2D g2d = (Graphics2D) graphics;

        // Set up bond paper size (8.5 x 11 inches)
        Paper paper = new Paper();
        double width = 8.5 * 72;  // 8.5 inches converted to points
        double height = 11 * 72; // 11 inches converted to points
        paper.setSize(width, height);
        
        // Remove the one-inch margins to fit the panel
        paper.setImageableArea(0, 0, width, height); // No margins at all
        
        pageFormat.setPaper(paper);

        // Set page orientation (portrait or landscape)
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        // Calculate scaling
        double panelWidth = panelToPrint.getWidth(); // Use actual panel size
        double panelHeight = panelToPrint.getHeight(); // Use actual panel size
        double scaleX = pageFormat.getImageableWidth() / panelWidth;
        double scaleY = pageFormat.getImageableHeight() / panelHeight;
        double scale = Math.min(scaleX, scaleY); // Use the smaller scale factor to maintain aspect ratio

        // Calculate the position to center the panel on the page
        double xOffset = (pageFormat.getImageableWidth() - panelWidth * scale) / 2;
        double yOffset = (pageFormat.getImageableHeight() - panelHeight * scale) / 2;

        // Translate and scale the graphics context
        g2d.translate(pageFormat.getImageableX() + xOffset, pageFormat.getImageableY() + yOffset);
        g2d.scale(scale, scale);

        // Print the panel
        panelToPrint.printAll(g2d);

        return Printable.PAGE_EXISTS;
    }

    public void printPanel() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
