
package enhancer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public CustomHeaderRenderer() {
        setOpaque(true);
        setBackground(new Color(27, 57, 77)); // Header background color
        setForeground(Color.WHITE);           // Header text color
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(new Font("Dialog", Font.BOLD, 12)); // Set font if needed
        setHorizontalAlignment(JLabel.CENTER);     // Center align the header text
        return this;
    }
}

