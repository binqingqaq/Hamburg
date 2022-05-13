package com.lanqiao.hamburg.Jform;/*
 * Created by JFormDesigner on Fri Apr 29 19:27:41 CST 2022
 */



import com.lanqiao.hamburg.Discount.DiscountForm;
import com.lanqiao.hamburg.FoodManage.FoodManagePanel;
import com.lanqiao.hamburg.MySaleShow.controller.Panel.MySalse;
import com.lanqiao.hamburg.Tools.MyTabbedPaneUI;
import com.lanqiao.hamburg.Supply.Supply;
import com.lanqiao.hamburg.manage.Manage;


import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;


/**
 * @author Binqing
 * @类说明 天天华莱士管理系统主界面窗口
 * @date 2022/5/7
 */
public class MainForm extends JFrame {
    public MainForm() throws SQLException {
        //初始化加载内容
        initComponents();
    }
    /**
     * @方法说明 初始化组件
     * @author Binqing
     * @date 2022/5/7 20:46
     * @param
     * @return void
     */

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        //label1 = new JLabel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭，程序退出
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        //setUndecorated(true);// 把边框去了，优化的效果能看的更明显

        Font font=new Font("宋体",Font.BOLD,12);
        tabbedPane1.setFont(font);//设置选项卡式窗格字体的样式
        tabbedPane1.setUI(new MyTabbedPaneUI());
        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);

            //======== panel1 ========
            {
                panel1 = new Manage();
                panel1.setLayout(null);
                //panel1.add(label1);
                //label1.setBounds(new Rectangle(new Point(245, 70), label1.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7528\u6237\u4fe1\u606f\u7ba1\u7406", panel1);

            //======== panel2 ========
            /**
             *给页签面板添加页签标题和内容
             */
            FoodManagePanel foodManagePanel = new FoodManagePanel();
            tabbedPane1.addTab("\u83dc\u54c1\u7ba1\u7406", foodManagePanel);

            //======== panel3 ========


            Supply supply = new Supply();
            tabbedPane1.addTab("\u83dc\u54c1\u4f9b\u5e94",supply);

            //======== panel4 ========
            //---------菜品销售与微信支付---------
            MySalse mySalse = new MySalse(this); //传入当前窗体对象便于控制窗体
            tabbedPane1.addTab("\u83dc\u54c1\u9500\u552e", mySalse);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8ba2\u5355\u4e2d\u5fc3", panel5);

            //======== panel6 ========
            {
                panel6 = new DiscountForm();
                panel6.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u6d3b\u52a8\u4f18\u60e0", panel6);

            //======== panel7 ========
            {
                panel7.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel7.getComponentCount(); i++) {
                        Rectangle bounds = panel7.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel7.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel7.setMinimumSize(preferredSize);
                    panel7.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5546\u54c1\u9500\u91cf", panel7);

            //======== panel8 ========
            {

                panel8.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("利润统计", panel8);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 5, 1000, 700);

        setTitle("天天华莱士管理系统界面");
        //contentPane.setPreferredSize(new Dimension(1000, 700));
        setSize(1000, 700);//设置窗口的大小
        setLocationRelativeTo(null);//设置窗口在屏幕中的位置
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );//窗口关闭，程序退出
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
