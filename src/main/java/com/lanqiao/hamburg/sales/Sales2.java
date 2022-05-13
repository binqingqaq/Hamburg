/*
 * Created by JFormDesigner on Sun May 01 16:46:18 CST 2022
 */

package com.lanqiao.hamburg.sales;

import com.lanqiao.hamburg.enti.Orde;
import com.lanqiao.hamburg.enti.Sale;
import java.awt.*;
import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class Sales2<CalendarTest> extends JPanel {
    public Sales2() {
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        JButton button4 = new JButton();

        //======== this ========
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);
        add(scrollPane1);
        scrollPane1.setBounds(0, 5, 395, 195);

        //---- button1 ----
        button1.setText("日销量排序");
        add(button1);
        button1.setBounds(new Rectangle(new Point(90, 270), button1.getPreferredSize()));
        button1.addActionListener(
                (e)-> {
                    a = 1;
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                    add(scrollPane1);
                }
        );
        //---- button2 ----
        button2.setText("月销量排序");
        add(button2);
        button2.setBounds(new Rectangle(new Point(195, 270), button2.getPreferredSize()));
        button2.addActionListener(
                (e)-> {
                    a = 2;
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                    add(scrollPane1);
                }
        );
        //---- button3 ----
        button3.setText("年销量排序");
        add(button3);
        button3.setBounds(new Rectangle(new Point(295, 270), button3.getPreferredSize()));
        button3.addActionListener(
                (e)-> {
                    a = 3;
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                    add(scrollPane1);
                }
        );

        button4.setText("刷新数据");
        add(button4);
        button4.setBounds(new Rectangle(new Point(5, 270), button4.getPreferredSize()));
        button4.addActionListener(
                (e)-> {
                    {
                        scrollPane1.setViewportView(table1);
                    }

                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase1(), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                    add(scrollPane1);
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


    public Object[][] getDataFromDatabase1() {

        java.util.List<Sale> list = new ArrayList<Sale>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;
        Statement stmt4 = null;
        Statement stmt5 = null;
        Statement stmt6 = null;
        String sql;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;
        ResultSet rs5 = null;
        ResultSet rs6 = null;

        int test [] =new int[20];
        String test0 [] =new String[20];
        int test1 [] =new int[6];
        String test2 [] =new String[6];
        int test3 [] =new int[6];
        int test4 [] =new int[6];
        int test5 [] =new int[6];
        int num [] =new int[6];

        Calendar c = Calendar.getInstance();
        int y=c.get(Calendar.YEAR);//年
        int M = c.get(Calendar.MONTH)+1;//月,注意这里要加1,计算机第一个月从0开始
        int d = c.get(Calendar.DATE);//日
        String year = y+"";
        String month = (M<10?"0":"")+M;
        String daily = (d<10?"0":"")+d;

        try {
            String sql1="SELECT * FROM Sale";
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs= stmt.executeQuery(sql1);
            test[0]=0;
            while (rs.next()) {
                test1[test[0]]=rs.getInt(1);
                test2[test[0]]=rs.getString(2);
                test3[test[0]]=rs.getInt(3);
                test4[test[0]]=rs.getInt(4);
                test5[test[0]]=rs.getInt(5);
                test[0]++;
            }


            String sql2 = "SELECT order_time,amount FROM order_info WHERE transaction_id='"+test2[0]+"'";
            stmt2 = conn.createStatement();
            rs2= stmt2.executeQuery(sql2);
            test5[0]=0;
            test4[0]=0;
            test3[0]=0;
            while (rs2.next()){
                test0[0]=rs2.getString(1).substring(0, 4);
                test0[1]=rs2.getString(1).substring(5, 7);
                test0[2]=rs2.getString(1).substring(8, 10);
                num[0]=rs2.getInt(2);
                if(test0[0].equals(year)){
                    test5[0]=test5[0]+num[0];
                    if(test0[1].equals(month)){
                        test4[0]=test4[0]+num[0];
                        if(test0[2].equals(daily)){
                            test3[0]=test3[0]+num[0];
                        }
                    }
                }
            }


            String sql3 = "SELECT order_time,amount FROM order_info WHERE transaction_id='"+test2[1]+"'";
            stmt3 = conn.createStatement();
            rs3= stmt3.executeQuery(sql3);
            test5[1]=0;
            test4[1]=0;
            test3[1]=0;
            while (rs3.next()){
                test0[3]=rs3.getString(1).substring(0, 4);
                test0[4]=rs3.getString(1).substring(5, 7);
                test0[5]=rs3.getString(1).substring(8, 10);
                num[1]=rs3.getInt(2);
                if(test0[3].equals(year)){
                    test5[1]=test5[1]+num[1];
                    if(test0[4].equals(month)){
                        test4[1]=test4[1]+num[1];
                        if(test0[5].equals(daily)){
                            test3[1]=test3[1]+num[1];
                        }
                    }
                }
            }


            String sql4 = "SELECT order_time,amount FROM order_info WHERE transaction_id='"+test2[2]+"'";
            stmt4 = conn.createStatement();
            rs4= stmt4.executeQuery(sql4);
            test5[2]=0;
            test4[2]=0;
            test3[2]=0;
            while (rs4.next()){
                test0[6]=rs4.getString(1).substring(0, 4);
                test0[7]=rs4.getString(1).substring(5, 7);
                test0[8]=rs4.getString(1).substring(8, 10);
                num[2]=rs4.getInt(2);
                if(test0[6].equals(year)){
                    test5[2]=test5[2]+num[2];
                    if(test0[7].equals(month)){
                        test4[2]=test4[2]+num[2];
                        if(test0[8].equals(daily)){
                            test3[2]=test3[2]+num[2];
                        }
                    }
                }
            }

            String sql5 = "SELECT order_time,amount FROM order_info WHERE transaction_id='"+test2[3]+"'";
            stmt5 = conn.createStatement();
            rs5= stmt5.executeQuery(sql5);
            test5[3]=0;
            test4[3]=0;
            test3[3]=0;
            while (rs5.next()){
                test0[9]=rs5.getString(1).substring(0, 4);
                test0[10]=rs5.getString(1).substring(5, 7);
                test0[11]=rs5.getString(1).substring(8, 10);
                num[3]=rs5.getInt(2);
                if(test0[9].equals(year)){
                    test5[3]=test5[3]+num[3];
                    if(test0[10].equals(month)){
                        test4[3]=test4[3]+num[3];
                        if(test0[11].equals(daily)){
                            test3[3]=test3[3]+num[3];
                        }
                    }
                }
            }

            String sql6 = "SELECT order_time,amount FROM order_info WHERE transaction_id='"+test2[4]+"'";
            stmt6 = conn.createStatement();
            rs6= stmt6.executeQuery(sql6);
            test5[4]=0;
            test4[4]=0;
            test3[4]=0;
            while (rs6.next()){
                test0[12]=rs6.getString(1).substring(0, 4);
                test0[13]=rs6.getString(1).substring(5, 7);
                test0[14]=rs6.getString(1).substring(8, 10);
                num[4]=rs6.getInt(2);
                if(test0[12].equals(year)){
                    test5[4]=test5[4]+num[4];
                    if(test0[13].equals(month)){
                        test4[4]=test4[4]+num[4];
                        if(test0[14].equals(daily)){
                            test3[4]=test3[4]+num[4];
                        }
                    }
                }
            }


            String sql10 = "UPDATE Sale SET `year`=(case WHEN ID=1 THEN "+test5[0]+" WHEN ID=2 THEN "+test5[1]+" WHEN ID=3 THEN "+test5[2]+" WHEN ID=4 THEN "+test5[3]+" WHEN ID=5 THEN "+test5[4]+" END)";
            PreparedStatement pstmt=conn.prepareStatement(sql10);
            pstmt.executeUpdate();

            String sql11 = "UPDATE Sale SET `month`=(case WHEN ID=1 THEN "+test4[0]+" WHEN ID=2 THEN "+test4[1]+" WHEN ID=3 THEN "+test4[2]+" WHEN ID=4 THEN "+test4[3]+" WHEN ID=5 THEN "+test4[4]+" END)";
            PreparedStatement pstmt1=conn.prepareStatement(sql11);
            pstmt1.executeUpdate();

            String sql12 = "UPDATE Sale SET `daily`=(case WHEN ID=1 THEN "+test3[0]+" WHEN ID=2 THEN "+test3[1]+" WHEN ID=3 THEN "+test3[2]+" WHEN ID=4 THEN "+test3[3]+" WHEN ID=5 THEN "+test3[4]+" END)";
            PreparedStatement pstmt2=conn.prepareStatement(sql12);
            pstmt2.executeUpdate();


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



        if(a==1){
            sql = "SELECT * FROM Sale ORDER BY daily DESC";
        }
        else if(a==2){
            sql = "SELECT * FROM Sale ORDER BY month DESC";
        }
        else if(a==3){
            sql = "SELECT * FROM Sale ORDER BY year DESC";
        }
        else{
            sql = "SELECT * FROM Sale ";}

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setID(rs.getInt(1));
                sale.setTitle(rs.getString(2));
                sale.setDaily(rs.getInt(3));
                sale.setMonth(rs.getInt(4));
                sale.setYear(rs.getInt(5));

                list.add(sale);


            }
            /*for (Sale sale1 : list) {
                System.out.println(sale1.getTitle());
            }*/


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

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getID();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getDaily();
                data[i][3] = list.get(i).getMonth();
                data[i][4] = list.get(i).getYear();

            }
        }
        return data;
    }

    public Object[][] getDataFromDatabase() {

        java.util.List<Sale> list = new ArrayList<Sale>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql;
        ResultSet rs = null;
        try {
            String sql1="SELECT * FROM Sale";
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
             rs= stmt.executeQuery(sql1);

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



        if(a==1){
             sql = "SELECT * FROM Sale ORDER BY daily DESC";
        }
        else if(a==2){
             sql = "SELECT * FROM Sale ORDER BY month DESC";
        }
        else if(a==3){
             sql = "SELECT * FROM Sale ORDER BY year DESC";
        }
        else{
             sql = "SELECT * FROM Sale ";}

        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setID(rs.getInt(1));
                sale.setTitle(rs.getString(2));
                sale.setDaily(rs.getInt(3));
                sale.setMonth(rs.getInt(4));
                sale.setYear(rs.getInt(5));
                list.add(sale);

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

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getID();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getDaily();
                data[i][3] = list.get(i).getMonth();
                data[i][4] = list.get(i).getYear();

            }
        }
        return data;
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private String head[] = {"ID", "商品名称", "日销量", "月销量", "年销量"};
    private Object[][] data = null;
    private int a;


}
