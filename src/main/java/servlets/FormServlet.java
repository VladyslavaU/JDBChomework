package servlets;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String age = request.getParameter("age");

            PrintWriter out = response.getWriter();
            out.println("The first name is: " + firstName);
            out.println("The last name is: " + lastName);
            out.println("The age is: " + age);

    }

}
