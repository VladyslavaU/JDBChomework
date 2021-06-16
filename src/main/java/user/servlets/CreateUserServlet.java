package user.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/addServlet")

public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init() {
        try {
            System.out.println("init()");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "123123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String sql = "INSERT INTO user(firstName,lastName, age, email) VALUES(?,?,?,?)";

        try (Connection conn = this.connection;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3,age);
            pstmt.setString(4,email);
            pstmt.executeUpdate();
      //  try {
         //   Statement statement = connection.createStatement();
            //int result = statement.executeUpdate("insert into user values('" + firstName + "','" + lastName + "','" + age + "','" + email + "')");
         //   int result = statement.executeUpdate("insert into user values('firstName', 'lastName','age', 'email')");
            PrintWriter out = response.getWriter();
           // if (result > 0) {
                out.print("<H1>User Created</H1>");
         //   } else {
            //    out.print("<H1>Error Creating the User</H1>");
       //     }
        } catch (SQLException e) {
     //       e.printStackTrace();
        }
   // } catch (SQLException throwables) {
    //        throwables.printStackTrace();
        }


        public void destroy() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
