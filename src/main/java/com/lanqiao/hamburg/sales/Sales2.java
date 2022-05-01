/*
 * Created by JFormDesigner on Sun May 01 16:46:18 CST 2022
 */

package com.lanqiao.hamburg.sales;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class Sales2 extends JPanel {
    public Sales2() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("ID");
        add(label1);
        label1.setBounds(new Rectangle(new Point(15, 10), label1.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u540d\u79f0");
        add(label3);
        label3.setBounds(new Rectangle(new Point(70, 10), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u65e5\u9500\u91cf");
        add(label4);
        label4.setBounds(new Rectangle(new Point(130, 10), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6708\u9500\u91cf");
        add(label5);
        label5.setBounds(new Rectangle(new Point(205, 10), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u5e74\u9500\u91cf");
        add(label6);
        label6.setBounds(new Rectangle(new Point(280, 10), label6.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
/*
    public static void main(String[] args) {
        new Sales2().setVisible(true);
    }
}
*/
}

