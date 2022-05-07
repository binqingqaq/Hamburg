
package com.lanqiao.hamburg.Supply;

import studentManage.dao.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Select extends Box {
    final int WIDTH=850;
    final int HEIGHT=600;

    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;
    private Model sm = null;
    private JScrollPane jsp = null;
    private JTable resultTb = null;

    //垂直布局
    public Select(){
        super(BoxLayout.Y_AXIS);
        //组装视图

        JPanel btnPanel = new JPanel();
        Color color = new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel jLabel = new JLabel("请输入姓名：");
        JTextField jTextField = new JTextField(5);
        JButton jButton = new JButton("查询");
        JButton jButton1 = new JButton("全部");
        JLabel jLabel1 = new JLabel("按");
        Choice select = new Choice();
        select.add("学号");
        select.add("年龄");
        select.add("总分");
        select.add("语文成绩");
        select.add("数学成绩");
        JButton jButton2 = new JButton("排序");

        btnPanel.add(jLabel);
        btnPanel.add(jTextField);
        btnPanel.add(jButton);
        btnPanel.add(jButton1);
        btnPanel.add(jLabel1);
        btnPanel.add(select);
        btnPanel.add(jButton2);
        this.add(btnPanel);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //查询
                //获取输入学生的姓名
                String name = jTextField.getText().trim();
                if(name.length() != 0) {
                    //姓名输入有效时，执行查询
                    //定义参数
                    String sql = "select * from stu where stuName like ?";
                    String []paras = {"%"+name+"%"};
                    //更新模型
                    jtableUpdate(sql, paras);
                } else {
                    //姓名为空时，设置提醒
                    JOptionPane.showMessageDialog(new Menu().jFrame, "姓名输入不能为空");
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //全部显示
                String sql = "select * from stu";
                jtableUpdate(sql, null);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //排序
                String paiXu = select.getSelectedItem();
                if(paiXu.equals("学号")) {
                    //定义参数
                    String sql = "select * from stu order by stuId desc";
                    String []paras = {};
                    //更新模型
                    jtableUpdate(sql, paras);
                } else if(paiXu.equals("总分")){
                    String sql = "select * from stu order by stuCount desc";
                    String []paras = {};
                    jtableUpdate(sql,paras);
                } else if(paiXu.equals("年龄")){
                    String sql = "select * from stu order by stuAge desc";
                    String []paras = {};
                    jtableUpdate(sql,paras);
                } else if(paiXu.equals("语文成绩")){
                    String sql = "select * from stu order by stuChinese desc";
                    String []paras = {};
                    jtableUpdate(sql,paras);
                }else if(paiXu.equals("数学成绩")){
                    String sql = "select * from stu order by stuMath desc";
                    String []paras = {};
                    jtableUpdate(sql,paras);
                }
            }
        });
        sm = new Model();
        String sql = "select * from stu";
        sm.queryStu(sql, null);
        resultTb = new JTable(sm);
        jsp = new JScrollPane(resultTb);
        this.add(jsp);
    }


    //更新JTable内数据
    public void jtableUpdate(String sql, String[] paras)
    {
        //创建模型
        sm = new Model();
        sm.queryStu(sql, paras);
        //更新显示
        resultTb.setModel(sm);
    }

}