import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/submitforms")
public class Myservlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
              throws ServletException, IOException {
//        res.setContentType("text/html");
        String name = req.getParameter("name1");

        String email = req.getParameter("email1");
        PrintWriter out = res.getWriter();
        out.print("name is" + name);
        out.print("<br>");
        out.print("email is" + email);


    }
}