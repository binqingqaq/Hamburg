/*
 * Created by JFormDesigner on Wed May 04 16:46:41 CST 2022
 */

package com.lanqiao.hamburg.supply;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class Supply extends JPanel {


    public Supply() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        textField2 = new JTextField();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(tableModel);

        button3 = new

                JButton();

        button4 = new

                JButton();

        //======== this ========
        setLayout(null);

        add(textField1);
        textField1.setBounds(125, 5, 95, textField1.getPreferredSize().height);
        add(textField2);
        textField2.setBounds(125, 35, 95, textField2.getPreferredSize().height);


//������ʱ ��������
        int a = 0;
        int rows = table1.getRowCount();
        while (a<=rows-1) {
            String getdate = table1.getValueAt(a, 1).toString();
            int g = Integer.parseInt(getdate);
            if (g <= 40) {
                label3.setText("��Ʒ��治�㣡�뼰ʱ������������");
                break;
            } else {
                label3.setText("OK ���� ��Ʒ�����㣡");
            }
            a++;
        }
        //---- label1 ----
        label1.setText("  ��������Ʒid��");
        label2.setText("�����벹��������");
        
        
        add(label1);
        label1.setBounds(25, 10, 100, label1.getPreferredSize().height);
        add(label2);
        label2.setBounds(25, 40, 100, label2.getPreferredSize().height);
        add(label3);
        label3.setBounds(290, 40, 200, label3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("��ѯ");
        add(button1);
        button1.setBounds(new

                Rectangle(new Point(225, 5), button1.

                getPreferredSize()));


        button1.addActionListener(e -> {
            try {
                selectStock();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            tableModel = new DefaultTableModel(queryData1(),head){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            scrollPane1.setViewportView(table1);


        });


        //---- button2 ----
        button2.setText("ȫ��");

        add(button2);
        button2.setBounds(new
                Rectangle(new Point(385, 5),button2.
                getPreferredSize()));
        button2.addActionListener(e -> {
            tableModel = new DefaultTableModel(queryData(),head){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            scrollPane1.setViewportView(table1);
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        add(scrollPane1);
        scrollPane1.setBounds(25,60,495,195);

        //---- button3 ----
        button3.setText("����");

        add(button3);
        button3.setBounds(new

                Rectangle(new Point(305, 5),button3.

                getPreferredSize()));


        button3.addActionListener(e -> {

            int index1 = table1.getSelectedRow();//��ȡѡ����
            System.out.println(index1);

            String product_id= (String)table1.getValueAt(index1,2);
            int current_stock=(Integer)( table1.getValueAt(index1,1)) ;
            System.out.println(product_id);

            int stock=Integer.valueOf(textField2.getText());
            try {
                updateStock(product_id,stock,current_stock);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }



            tableModel = new DefaultTableModel(queryData(),head){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            scrollPane1.setViewportView(table1);
        });

        //---- button4 ----
        button4.setText("����");
        add(button4);
        button4.setBounds(new
                Rectangle(new Point(465, 5),button4.
                getPreferredSize()));
        setPreferredSize(new Dimension(565, 390));
        button4.addActionListener(e -> {
            try {
                selectStock1();
                System.out.println();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


            tableModel = new DefaultTableModel(queryData3(),head){
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            scrollPane1.setViewportView(table1);
        });
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }


    public static class ConnectionHandler {

        public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

        public static Connection getConn() throws SQLException {
        /*
        Ϊ�˱�֤OrderDaoImpl��StockDaoImpl�е�Connection��ͬһ�������������´���
         */
            Connection conn=threadLocal.get();
        /*
        null˵��ʲô��
         */
            if(conn==null){
                String user = "root";
                String dbPassword = "Binqing31";
                String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                conn = DriverManager.getConnection(url, user, dbPassword);
                threadLocal.set(conn);
            }
            return conn;
        }
        public static void closeConnection() throws SQLException {
            Connection conn=threadLocal.get();
            if(conn!=null){
                conn.close();
                threadLocal.remove();
            }
        }
    }


    private void selectStock()  throws  SQLException {
        try {
            Connection conn = ConnectionHandler.getConn();
            String product_id=textField1.getText();
            String sql2 = "SELECT * FROM item WHERE product_id="+"'"+product_id+"'";
            PreparedStatement pstmt1 = conn.prepareStatement(sql2);
            pstmt1.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("��ѯʧ��");
        }
    }


    private void selectStock1()  throws  SQLException {
        try {
            Connection conn = ConnectionHandler.getConn();

            String sql2 = "SELECT * FROM `item` ORDER BY stock ASC";

            PreparedStatement pstmt1 = conn.prepareStatement(sql2);
            pstmt1.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("��ѯʧ��");
        }
    }
//    private void selectStock2()  throws  SQLException {
//        try {
//
//
//            Connection conn = ConnectionHandler.getConn();
//
//            String sql2 = "SELECT stock FROM `item`";
//
//
//
//
//
//            PreparedStatement  pstmt1= conn.prepareStatement(sql2);
//            pstmt1.executeQuery();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new SQLException("��ѯʧ��");
//        }
//    }

    public void updateStock(String product_id, int stock,int current_stock) throws SQLException  {
        try {
            int sum = stock+current_stock;

            Connection conn = ConnectionHandler.getConn();
            //System.out.println("StockDaoImpl��"+conn.hashCode());
            String sql1="UPDATE item SET stock="+sum+"  WHERE product_id="+"'"+product_id+"'";
            PreparedStatement pstmt = conn.prepareStatement(sql1);

            // pstmt.setInt(1, stock);
            // pstmt.setString(2, product_id);

            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("������ʧ��");
        }
    }



    public  Object[][] queryData() {

        java.util.List<com.lanqiao.hamburg.Supply.Item_stock> list=new ArrayList<com.lanqiao.hamburg.Supply.Item_stock>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;//SQL������ƴSQL
        String sql = "SELECT * FROM item";
        System.out.println("����ִ�е�sql��" + sql);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //ÿѭ��һ�ξ���һ�����󣬰�����������������List��������ظ�����Set�����򲻿��ظ�����Map��key��value�ṹ��
                com.lanqiao.hamburg.Supply.Item_stock item_stock=new com.lanqiao.hamburg.Supply.Item_stock();
                item_stock.setId(rs.getInt(1));
                item_stock.setStock(rs.getInt(7));
                item_stock.setItem_id(rs.getString(2));
                list.add(item_stock);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //�ͷ���Դ�����ݿ����Ӻܰ���
            try {
                rs.close();
                stmt.close();
                conn.close();//������
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        data = new Object[list.size()][head.length];
        //�Ѽ���������ݷ���Obejct�����ά����
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getStock();
                data[i][2] = list.get(i).getItem_id();
            }
        }
        return data;
    }


    public Object[][] queryData1() {

        java.util.List<com.lanqiao.hamburg.Supply.Item_stock> list=new ArrayList<com.lanqiao.hamburg.Supply.Item_stock>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String product_id=textField1.getText();
        Statement stmt = null;//SQL������ƴSQL
        String sql2 = "SELECT * FROM item WHERE product_id="+"'"+product_id+"'";
        System.out.println("����ִ�е�sql��" + sql2);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                //ÿѭ��һ�ξ���һ�����󣬰�����������������List��������ظ�����Set�����򲻿��ظ�����Map��key��value�ṹ��
                com.lanqiao.hamburg.Supply.Item_stock item_stock=new com.lanqiao.hamburg.Supply.Item_stock();
                item_stock.setId(rs.getInt(1));
                item_stock.setStock(rs.getInt(7));
                item_stock.setItem_id(rs.getString(2));
                list.add(item_stock);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //�ͷ���Դ�����ݿ����Ӻܰ���
            try {
                rs.close();
                stmt.close();
                conn.close();//������
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head.length];
        //�Ѽ���������ݷ���Obejct�����ά����
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getStock();
                data[i][2] = list.get(i).getItem_id();
            }
        }
        return data;
    }



    public Object[][] queryData3() {

        java.util.List<com.lanqiao.hamburg.Supply.Item_stock> list=new ArrayList<com.lanqiao.hamburg.Supply.Item_stock>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;//SQL������ƴSQL
        String sql3 = "SELECT * FROM  item  ORDER BY stock ASC";
        System.out.println("����ִ�е�sql��" + sql3);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                //ÿѭ��һ�ξ���һ�����󣬰�����������������List��������ظ�����Set�����򲻿��ظ�����Map��key��value�ṹ��
                com.lanqiao.hamburg.Supply.Item_stock item_stock=new com.lanqiao.hamburg.Supply.Item_stock();
                item_stock.setId(rs.getInt(1));
                item_stock.setStock(rs.getInt(7));
                item_stock.setItem_id(rs.getString(2));
                list.add(item_stock);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //�ͷ���Դ�����ݿ����Ӻܰ���
            try {
                rs.close();
                stmt.close();
                conn.close();//������
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        data = new Object[list.size()][head.length];
        //�Ѽ���������ݷ���Obejct�����ά����
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getStock();
                data[i][2] = list.get(i).getItem_id();
            }
        }

        return data;

    }
    


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JTextField textField2;
    DefaultTableModel tableModel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"id","stock","product_id"};
    private Object[][] data = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}



