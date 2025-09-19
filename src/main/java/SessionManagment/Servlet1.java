package SessionManagment;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session1")
public class Servlet1 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String username=req.getParameter("Name");
        PrintWriter out =res.getWriter();
        out.println("jfjf");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1><a href='Servlet3'>Go to Another page</a></h1>");
//create cookie
        HttpSession s=req.getSession();
        s.setAttribute("username",username);
//        out.println("</head>");
        out.println("</body>");
        out.print("</html>");



    }
}
