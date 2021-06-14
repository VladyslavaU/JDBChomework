package servlets;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/enterInfo")
public class FormServlet extends GenericServlet {

    public void service(ServletRequest request, ServletResponse response) throws IOException {
        if (request.getParameter("firstName") != null && request.getParameter("lastName") != null &&
                request.getParameter("age") != null) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String age = request.getParameter("age");

            PrintWriter out = response.getWriter();
            out.println("The first name is: " + firstName);
            out.println("The last name is: " + lastName);
            out.println("The age is: " + age);
        }

    }
}
