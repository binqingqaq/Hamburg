/*
 * Created by JFormDesigner on Tue May 10 18:21:04 CST 2022
 */

package com.lanqiao.hamburg.manage;
import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.entity.Item;
import com.lanqiao.hamburg.entity.User;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.lanqiao.hamburg.manage.JudgePower;
/**
 * @author 1
 */
public class Manage extends JPanel {
    public Manage() {
        JudgePower judgePower = new JudgePower();
        pow_id=judgePower.select();
        pow = judgePower.judge(pow_id);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        textField1 = new JTextField();

        /*
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);
        移动至刷新*/
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //======== this ========
        JPanel contentPane = new JPanel();

        setLayout(null);

        //======== scrollPane1 ========
        {
            //scrollPane1.setViewportView(table1);移动至刷新
            refresh();
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 815, 300);
        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        //搜索框
        textField1 = new JTextField();
        add(textField1);
        textField1.setBounds(20, 350, 130, 30);
        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        add(button1);
        button1.setBounds(new Rectangle(new Point(300, 350), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
                    if(pow==1) {
                        int rowNo =data.length-1;//获取所选的行号
                        int user_id = (int) table1.getValueAt(rowNo, 0)+1;
                        String user_name = null;
                        String user_key = null;
                        int user_power = 0;
                        User user = new User(user_id, user_name, user_key, user_power);
                        UpdateUser updateUser = new UpdateUser(user,0,this);
                        updateUser.setVisible(true);
                    }
                }
        );
        //---- button2 ----
        button2.setText("\u4fee\u6539");
        add(button2);
        button2.setBounds(new Rectangle(new Point(400, 350), button2.getPreferredSize()));
        button2.addActionListener(
                (e)->{
                    if(pow==1) {
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        int user_id = (int) table1.getValueAt(rowNo, 0);
                        String user_name = (String) table1.getValueAt(rowNo, 1);
                        String user_key = (String) table1.getValueAt(rowNo, 2);
                        int user_power = (int) table1.getValueAt(rowNo, 3);
                        User user = new User(user_id, user_name, user_key, user_power);
                        UpdateUser updateUser = new UpdateUser(user,1,this);
                        updateUser.setVisible(true);
                    }
                }
        );
        //---- button3 ----
        button3.setText("\u5220\u9664");
        add(button3);
        button3.setBounds(new Rectangle(new Point(500, 350), button3.getPreferredSize()));
        button3.addActionListener(
                (e)->{
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        int user_id = (int) table1.getValueAt(rowNo, 0);
                        String user_name = (String) table1.getValueAt(rowNo, 1);
                        String user_key = (String) table1.getValueAt(rowNo, 2);
                        int user_power = (int) table1.getValueAt(rowNo, 3);
                        User user = new User(user_id, user_name, user_key, user_power);
                    try {
                        delete(user);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
        );
        button4.setText("查询");
        add(button4);
        button4.setBounds(new Rectangle(new Point(200, 350), button4.getPreferredSize()));
        button4.addActionListener(
            (e) -> {
                if(pow==1) {
                DefaultTableModel tableModel = new DefaultTableModel(getSelectedDataFromDatabase(), head) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };


                table1.setModel(tableModel);
                scrollPane1.setViewportView(table1);
            }
        }
        );
        button5.setText("刷新");
        add(button5);
        button5.setBounds(new Rectangle(new Point(600, 350), button5.getPreferredSize()));
        button5.addActionListener(
                (e) -> {
                    refresh();
                }
        );
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
    public Object[][] getDataFromDatabase() {

        java.util.List<User> list = new ArrayList<>();
        Connection conn = null;
        String dbuser = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql = "SELECT * FROM user";
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, dbuser, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_key(rs.getString(3));
                user.setUser_power(rs.getInt(4));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];
        if(pow==0){
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = 404;
                    data[i][1] = "您不是管理员";
                    data[i][2] = "没有权限查看";
                    data[i][3] = 0;
                }
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getUser_id();
                    data[i][1] = list.get(i).getUser_name();
                    data[i][2] = list.get(i).getUser_key();
                    data[i][3] = list.get(i).getUser_power();
                }
            }
        }
        return data;
    }
    //删除功能
    public void delete(User user) throws SQLException {
        if(pow==1) {
            System.out.println("删除中...");
            Connection conn = null;
            String dbuser = "root";
            String dbPassword = "Binqing31";
            String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            PreparedStatement stmt = null;
            String sql = "DELETE FROM user WHERE user_id=? and user_name=? and user_key=? and user_power=?;";
            try {
                conn = DriverManager.getConnection(url, dbuser, dbPassword);
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, user.getUser_id());
                stmt.setString(2, user.getUser_name());
                stmt.setString(3, user.getUser_key());
                stmt.setInt(4, user.getUser_power());
                stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {

                    stmt.close();
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            refresh();
        }
    }



    //查询功能
    public Object[][] getSelectedDataFromDatabase(){

            java.util.List<User> list = new ArrayList<>();
            Connection conn = null;
            String dbuser = "root";
            String dbPassword = "Binqing31";
            String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Statement stmt = null;
            String keyword=textField1.getText();
            //int intkeyword=Integer.parseInt(keyword);
            String sql = "SELECT * FROM user WHERE user_name='"+keyword+"' or user_key='"+keyword+"'";
            ResultSet rs = null;
            try {
                conn = DriverManager.getConnection(url, dbuser, dbPassword);
                stmt = conn.createStatement();
                System.out.println(sql);
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    User user = new User();
                    user.setUser_id(rs.getInt(1));
                    user.setUser_name(rs.getString(2));
                    user.setUser_key(rs.getString(3));
                    user.setUser_power(rs.getInt(4));
                    list.add(user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
 //                   rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            // 把集合的数据（商品信息）转换成二维数组
            data = new Object[list.size()][head.length];
            if (pow == 0) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < head.length; j++) {
                        data[i][0] = 404;
                        data[i][1] = "您不是管理员";
                        data[i][2] = "没有权限查看";
                        data[i][3] = 0;
                    }
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < head.length; j++) {
                        data[i][0] = list.get(i).getUser_id();
                        data[i][1] = list.get(i).getUser_name();
                        data[i][2] = list.get(i).getUser_key();
                        data[i][3] = list.get(i).getUser_power();
                    }
                }
            }
            return data;

    }

    //刷新模块
    public void refresh(){
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        table1.setModel(tableModel);
        scrollPane1.setViewportView(table1);

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private String head[] = {"id", "用户名", "用户密码", "权限"};
    private Object[][] data = null;
    private int pow_id;
    private int pow;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        Frame frame=new Frame();
        frame.add(new Manage(),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
