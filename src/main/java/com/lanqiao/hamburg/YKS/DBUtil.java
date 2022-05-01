package com.lanqiao.hamburg.YKS;

//package com.xttblog.flower.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//数据库访问的工具类
public class DBUtil {

    static{
        //1.注册驱动程序--只执行一次即可
        //driverManager直接注册驱动程序，获取connection对象
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 微信号：codedq，dart996
    // _MAXOS
    // java 1.8
    // mysql 5.7
    // 微信群，

    public static Connection getConnection(){
        String url = "jdbc:mysql://39.108.193.41:3306/dart996?serverTimezone=UTC&characterEncoding=UTF-8&useSSL=false";
        String name = "root";
        String password = "Binqing31";
        Connection conn = null;
        try {
            //获取类型从而注册
            //Class.forName("com.mysql.jdbc.Driver");
            //获取Conncetion接口的实例，并不知道实现类，屏蔽实现的细节
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    //关闭操作：对所有打开的资源进行关闭
    public static void close(Connection conn, Statement st, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

