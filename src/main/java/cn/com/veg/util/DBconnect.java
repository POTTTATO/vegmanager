package cn.com.veg.util;

import org.junit.Test;

import java.sql.*;

public class DBconnect {

//    public Connection getConn(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("1.成功进入Driver----");
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            System.out.println("error Driver");
//            e.printStackTrace();
//        }
//        //获取连接Connection
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowers?serverTimezone=UTC&characterEncoding=utf8&amp", "root", "baobao1007");
//            System.out.println("2.成功与数据库进行连接Connection------");
////            Statement stmt=conn.createStatement();
////            ResultSet rs=stmt.executeQuery("select * from users");
////            while(rs.next())
////            {
////                System.out.println(rs.getString("usr"));
////            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            System.out.println("error Connection");
//            e.printStackTrace();
//        }
//        return conn;
//    }
    public static Connection getConnection(){
        Connection con=null;
        String drive = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/flowers?characterEncoding=UTF-8";
        String username="root";
        String password="baobao1007";

        try{
            Class.forName(drive);
            con = DriverManager.getConnection(url,username,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    public static void release(Connection conn){
        if(conn!=null)
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    public static void release(PreparedStatement pstmt){

        if(pstmt!=null)
            try{
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    public static void release(ResultSet rs){

        if(rs!=null)
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }
}
