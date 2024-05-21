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
    // Set page format to bond paper (8.5 x 11 inches)
    pageFormat.setOrientation(PageFormat.PORTRAIT);
    pageFormat.setPaper(new Paper());
    Paper paper = pageFormat.getPaper();
    double width = 8.5 * 72; // 8.5 inches converted to points (1 inch = 72 points)
    double height = 11 * 72; // 11 inches converted to points
    paper.setSize(width, height);
    paper.setImageableArea(0, 0, width, height);
    pageFormat.setPaper(paper);

    // Translate graphics context to center of the page with one-inch top margin
    double panelWidth = panelToPrint.getPreferredSize().getWidth();
    double panelHeight = panelToPrint.getPreferredSize().getHeight();
    double xOffset = (pageFormat.getImageableWidth() - panelWidth) / 2;
    double yOffset = pageFormat.getImageableY() + 72; // One-inch margin at the top
    g2d.translate(pageFormat.getImageableX() + xOffset, yOffset);

    // Make sure the panel is fully rendered before printing
    panelToPrint.printAll(graphics);

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

    
    
