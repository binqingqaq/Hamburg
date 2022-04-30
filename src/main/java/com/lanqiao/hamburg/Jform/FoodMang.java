/*
 * Created by JFormDesigner on Sat Apr 30 12:52:20 CST 2022
 */

package com.lanqiao.hamburg.Jform;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class FoodMang extends JPanel {
    public FoodMang() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table2 = new JTable();

        //======== this ========
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table2);
        }
        add(scrollPane1);
        scrollPane1.setBounds(new Rectangle(new Point(195, 175), scrollPane1.getPreferredSize()));

        setPreferredSize(new Dimension(815, 595));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
