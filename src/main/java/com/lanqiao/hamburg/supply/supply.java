/*
 * Created by JFormDesigner on Sun May 01 14:37:26 CST 2022
 */

package com.lanqiao.hamburg.supply;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class supply extends JPanel {
    public supply() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u83dc\u54c1\u4f9b\u5e94");
        add(label1);
        label1.setBounds(new Rectangle(new Point(190, 20), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(new Rectangle(new Point(30, 55), textField1.getPreferredSize()));

        setPreferredSize(new Dimension(400, 620));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
