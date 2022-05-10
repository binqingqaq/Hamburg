/*
 * Created by JFormDesigner on Fri Apr 29 14:44:50 CST 2022
 */
package com.lanqiao.hamburg.FoodManage;

import com.lanqiao.hamburg.FoodManage.impl.DishesManageImpl;
import com.lanqiao.hamburg.FoodManage.impl.GetDataFromDatabaseImpl;
import com.lanqiao.hamburg.FoodManage.impl.TableServiceImpl;
import com.lanqiao.hamburg.Interface.dao.DishesManageDAO;
import com.lanqiao.hamburg.Jform.AddItemForm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * @author Binqing
 * @类说明 餐品管理标签的面板JPanel
 * @date 2022/5/7
 */
public class FoodManagePanel extends JPanel {
    public FoodManagePanel() {
        initComponents();//面板的初始化，加载
    }

    /**
     * @方法说明 刷新table表格中所显示内容
     * @author Binqing
     * @date 2022/5/7 20:35
     * @param mark
     * 当mark=0，获取数据库item表的全部内容
     * 当mark=1，按照序号id筛选item表内容
     * 当mark=10~15，分别按商品种类：（堡卷主食，炸鸡烤鸡，休闲小吃，超值套餐，特饮，调料）筛选
     * @return void
     */
    public static void updateTable(int mark){
        GetDataFromDatabaseImpl gDFT = null;//
        if (mark>=10&&mark<=15) {
            if (mark == 10) {
                gDFT = new GetDataFromDatabaseImpl(mark, button6.getText());
            }else if (mark==11){
                gDFT = new GetDataFromDatabaseImpl(mark, button1.getText());

            }else if (mark==12){
                gDFT = new GetDataFromDatabaseImpl(mark, button2.getText());

            }else if (mark==13){
                gDFT = new GetDataFromDatabaseImpl(mark, button7.getText());

            }else if (mark==14){
                gDFT = new GetDataFromDatabaseImpl(mark, button3.getText());

            }else if (mark==15){
                gDFT = new GetDataFromDatabaseImpl(mark, button5.getText());
            }
        }
        if (mark==0){
            gDFT = new GetDataFromDatabaseImpl(mark);
        }

        if (mark==1){
            int id =Integer.valueOf(textField1.getText());
            gDFT = new GetDataFromDatabaseImpl(mark,id);
        }

        model = new DefaultTableModel(gDFT.getDataFromDatabase(),head);//获取默认表模型，数据和表头
        table1.setModel(model);//把模型传给table1
        new TableServiceImpl().tableOptimize(table1,head);//优化table1
        table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
        scrollPane2.setViewportView(table1);//设置视口视图
    }

    /**
     * @方法说明 初始化组件
     * @author Binqing
     * @date 2022/5/7 21:00
     * @param
     * @return void
     */
    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        GetDataFromDatabaseImpl gDFD = new GetDataFromDatabaseImpl(0);
        scrollPane2 = new JScrollPane();
         model = new DefaultTableModel(gDFD.getDataFromDatabase(), head);

         table1 = new JTable(model) {
            //重写方法，获取列的类，即：第七列返回的是图标类
            public Class getColumnClass(int column) {
                return (column == 7) ? Icon.class : Object.class;
            }
        };
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        textField1 = new JTextField();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setLayout(null);
        {
            new TableServiceImpl().tableOptimize(table1,head);
            table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
            scrollPane2.setViewportView(table1);
        }
        add(scrollPane2);
        scrollPane2.setBounds(0, 60, 800, 500);

        //---- button1 ----
        button1.setText("招牌全鸡");
        add(button1);
        button1.setBounds(new Rectangle(new Point(120, 35), button1.getPreferredSize()));
        button1.addActionListener(e->updateTable(11));

        //---- button2 ----
        button2.setText("美味小食");
        add(button2);
        button2.setBounds(new Rectangle(new Point(240, 35), button2.getPreferredSize()));
        button2.addActionListener(e->updateTable(12));

        //---- button3 ----
        button3.setText("缤纷饮品");
        add(button3);
        button3.setBounds(new Rectangle(new Point(480, 35), button3.getPreferredSize()));
        button3.addActionListener(e->updateTable(14));

        //---- button5 ----
        button5.setText("调料");
        add(button5);
        button5.setBounds(new Rectangle(new Point(600, 35), button5.getPreferredSize()));
        button5.addActionListener(e->updateTable(15));

        //---- button6 ----
        button6.setText("精选主食");
        add(button6);
        button6.setBounds(new Rectangle(new Point(0, 35), button6.getPreferredSize()));
        button6.addActionListener(e-> updateTable(10));

        //---- button7 ----
        button7.setText("超值套餐");
        add(button7);
        button7.setBounds(new Rectangle(new Point(360, 35), button7.getPreferredSize()));
        add(textField1);
        textField1.setBounds(115, 600, 155, 28);
        button7.addActionListener(e->updateTable(13));

        //---- button8 ----
        button8.setText("查询");
        add(button8);
        button8.setBounds(new Rectangle(new Point(300, 600), button8.getPreferredSize()));
        button8.addActionListener(e-> {
            new DishesManageImpl(textField1).seekDishes();
            if (!(textField1.getText().equals(""))){
                updateTable(1);
            }
        });

        //---- button9 ----
        button9.setText("新增");
        add(button9);
        button9.setBounds(new Rectangle(new Point(500, 600), button9.getPreferredSize()));
        button9.addActionListener(e->new AddItemForm().setVisible(true));

        //---- button10 ----
        button10.setText("删除");
        add(button10);
        button10.setBounds(new Rectangle(new Point(400, 600), button10.getPreferredSize()));
        button10.addActionListener(e->new DishesManageImpl(table1).deleteDishes());

        //---- button11 ----
        button11.setText("修改");
        add(button11);
        button11.setBounds(new Rectangle(new Point(600, 600), button11.getPreferredSize()));
        button11.addActionListener(e->{
            DishesManageDAO dml = new DishesManageImpl(table1);
            dml.modifyDishes();
        });

        //---- button12 ----
        button12.setText("显示全部");
        add(button12);
        button12.setBounds(new Rectangle(new Point(20, 600), button12.getPreferredSize()));
        button12.addActionListener(e-> updateTable(0));

        //---- label2 ----
        label2.setText("是兄弟就来砍我(#^.^#)");
        label2.setMaximumSize(new Dimension(600, 50));
        Font font=new Font("宋体",Font.BOLD,36);
        label2.setFont(font);
        label2.setForeground(Color.green);

        add(label2);
        label2.setBounds(240, -5, 600, 50);
        setPreferredSize(new Dimension(815, 595));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public static JScrollPane scrollPane2;
    public static String head[] = {"序号", "餐品编号", "餐品类别", "餐品名称", "原价", "优惠价","库存","图片"};
    public static JTable table1;
    public static DefaultTableModel model;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JButton button5;
    private static   JButton button6;
    private static   JButton button7;
    static JTextField textField1;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
