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
            return Printable.NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) graphics;

        // Set up bond paper size (8.5 x 11 inches)
        Paper paper = new Paper();
        double width = 8.5 * 72; // 8.5 inches converted to points
        double height = 11 * 72; // 11 inches converted to points
        paper.setSize(width, height);
        paper.setImageableArea(72, 72, width - 144, height - 144); // one-inch margin on all sides
        pageFormat.setPaper(paper);

        // Set page orientation
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        // Calculate scaling
        double panelWidth = 530; // Your JPanel width
        double panelHeight = 630; // Your JPanel height
        double scaleX = pageFormat.getImageableWidth() / panelWidth;
        double scaleY = pageFormat.getImageableHeight() / panelHeight;
        double scale = Math.min(scaleX, scaleY);

        // Calculate the position to center the panel
        double xOffset = (pageFormat.getImageableWidth() - panelWidth * scale) / 2;
        double yOffset = (pageFormat.getImageableHeight() - panelHeight * scale) / 2;

        // Adjust for top and bottom margins to reduce excessive spacing
        double topMarginAdjustment = 0.5 * 72; // 0.5 inch top margin
        double bottomMarginAdjustment = 0.5 * 72; // 0.5 inch bottom margin

        // Translate and scale the graphics context
        g2d.translate(pageFormat.getImageableX() + xOffset, pageFormat.getImageableY() + yOffset - topMarginAdjustment);
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
