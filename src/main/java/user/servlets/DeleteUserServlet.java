package user.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/DeleteServlet")

public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "123123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("delete from users2 where email='"+email+"'");
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.print("<H1>User Deleted</H1>");
            } else {
                out.print("<H1>Invalid User</H1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
