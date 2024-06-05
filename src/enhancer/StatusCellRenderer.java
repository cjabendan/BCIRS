/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancer;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StatusCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null) {
            String status = value.toString();
            if ("Active".equalsIgnoreCase(status)) {
                cellComponent.setForeground(new Color(0, 128, 0)); // Darker green
            } else if ("Pending".equalsIgnoreCase(status)) {
                cellComponent.setForeground(new Color(255, 140, 0)); // Darker orange
            } else {
                cellComponent.setForeground(Color.BLACK); // Default color
            }
        }

        return cellComponent;
    }
}

