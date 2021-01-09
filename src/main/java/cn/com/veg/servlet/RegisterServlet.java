package cn.com.veg.servlet;

import cn.com.veg.entity.User;
import cn.com.veg.util.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("注册的用户名为："+request.getParameter("usr"));

        User user = new User();
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");

        user.setUsr(usr);
        user.setPwd(pwd);

        try{
            String sql = "select id from users where usr = ?;";
            DBconnect conn = new DBconnect();
            Connection connection = conn.getConnection();
//            System.out.println(user.getUsr());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,usr);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                System.out.println("用户已存在");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }else {
                String sql1 = "insert into users (usr,pwd) values(?,?)";
                statement=connection.prepareStatement(sql1);
                statement.setString(1,usr);
                statement.setString(2,pwd);

                int result = statement.executeUpdate();
                if(result == 1){
                    System.out.println("注册成功："+usr);
                    request.setAttribute("remind","注册成功");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }else {
                    System.out.println("注册失败");
                    request.getRequestDispatcher("/register").forward(request,response);
                }
            }
            rs.close();
            statement.close();
            connection.close();
        }catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
