package com.lanqiao.hamburg.MySaleShow.controller.Frame;

import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/14 4:00
 */
public class Job15_14 extends JFrame {
    public Job15_14() throws HeadlessException {
        Job1514 job1514 = new Job1514();
        job1514.setBackground(Color.WHITE);
        add(job1514);
    }
    public static void main(String[] args) {
        Job15_14 frame = new Job15_14();
        frame.setTitle("测试报表");
        frame.setSize(500, 200);// job15
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class Job1514 extends JPanel {
        int HEIGHT = 250;
        int offsetY = 14;
        Font font = new Font("Times", Font.PLAIN, 14);
        //传入购物车的结果集
        @Override
        protected void paintComponent(Graphics g) {
            ResultSet rs = null;
            java.sql.Statement stmt = null;
            try {
                Connection conn = ConnectionHandler.getConn();
                String sql = "select * from ShopCar";
                conn = ConnectionHandler.getConn();
                stmt =conn.createStatement();
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    super.paintComponent(g);
                    HEIGHT = (int) (getHeight());
                    int width = getWidth();
                    int w80 = (int) (width * 0.8);
                    int w20 = (int) (width * 0.2);
                    int uw = w80 / 4;
                    int gap = w20 / 5;

                    int bottom = getHeight() - 20;
                    int rectH = (int) (HEIGHT * 0.2);
                    String str;
                    g.setFont(font);

                    g.setColor(Color.RED);
                    g.fillRect(gap, bottom - rectH, uw, rectH);
                    g.setColor(Color.BLACK);
                    str = "Project -- 20%";
                    g.drawString(str, gap, bottom - rectH - offsetY);

                    int x1, x2, y1, y2;
                    x1 = gap / 2;
                    y1 = bottom;
                    x2 = width - gap / 2;
                    y2 = y1;
                    g.setColor(Color.BLACK);
                    g.drawLine(x1, y1, x2, y2);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}

