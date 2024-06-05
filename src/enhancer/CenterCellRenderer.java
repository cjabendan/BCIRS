package enhancer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CenterCellRenderer extends DefaultTableCellRenderer {
    public CenterCellRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }
}
