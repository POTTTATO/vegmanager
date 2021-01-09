package cn.com.veg.servlet;

import cn.com.veg.entity.User;
import cn.com.veg.util.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user = new User();
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");

        try {
            String sql = "select * from users where usr = ? and pwd = ?;";

            DBconnect conn = new DBconnect();
            Connection connection = conn.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,usr);
            statement.setString(2,pwd);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                System.out.println("登陆成功");
                request.setAttribute("remind","登陆成功");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                System.out.println("登陆失败");
                request.setAttribute("remind","登陆失败");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }

    }


}
