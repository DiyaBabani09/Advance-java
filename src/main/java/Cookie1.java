import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class Cookie1 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
res.setContentType("text/html");
        String username=req.getParameter("Name");
        PrintWriter out =res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

out.println("<h1><a href='Servlet2'>Go to Another page</a></h1>");
//create cookie
        Cookie c=new Cookie("username",username);
        res.addCookie(c);
//        out.println("</head>");
        out.println("</body>");
        out.print("</html>");



    }
}
