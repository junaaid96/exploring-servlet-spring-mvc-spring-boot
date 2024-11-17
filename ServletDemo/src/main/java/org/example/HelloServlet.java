package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    //this will be called when user send the request.
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In Service!");

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("Hello World!");
    }
}
