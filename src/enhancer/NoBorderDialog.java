/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancer;

import javax.swing.*;
import java.awt.*;

public class NoBorderDialog extends JDialog {
    public NoBorderDialog(Frame owner, Component viewPanel) {
        super(owner, "", true);
        setUndecorated(true); // Remove window border
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(owner); // Center dialog on parent frame
    }
}
