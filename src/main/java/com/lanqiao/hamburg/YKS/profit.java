/*
 * Created by JFormDesigner on Sat Apr 30 15:34:52 CST 2022
 */

package com.lanqiao.hamburg.YKS;



import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class profit extends JPanel {
    public profit() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u65e5");
        add(label1);
        label1.setBounds(180, 55, 35, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5468");
        add(label2);
        label2.setBounds(260, 55, 20, label2.getPreferredSize().height);

        //---- textField1 ----
        textField1.setText("\u6708");
        add(textField1);
        textField1.setBounds(335, 50, 30, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u9009\u62e9\u65e5\u671f");
        add(label3);
        label3.setBounds(new Rectangle(new Point(85, 55), label3.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
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
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
