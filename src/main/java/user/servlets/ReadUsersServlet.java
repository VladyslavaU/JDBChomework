package user.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ReadUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init(ServletConfig config){
        try{
            ServletContext context = config.getServletContext();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword") );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users2");
            PrintWriter out = response.getWriter();
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>");
            out.println("First Name");
            out.print("</th>");
            out.print("<th>");
            out.println("Last Name");
            out.print("</th>");
            out.print("<th>");
            out.println("Age");
            out.print("</th>");
            out.print("</tr>");
            while(resultSet.next()){
                out.println("<tr>");
                out.println("<td>");
                out.print(resultSet.getString(1));
                out.println("</td>");
                out.println("<td>");
                out.print(resultSet.getString(2));
                out.println("</td>");
                out.println("<td>");
                out.print(resultSet.getString(4));
                out.println("</td>");
                out.println("</tr>");
            }
            out.print("</table>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
