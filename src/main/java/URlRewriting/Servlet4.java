package URlRewriting;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/url")
public class Servlet4 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String username=req.getParameter("Name");
        PrintWriter out =res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1><a href='Servlet2'>Go to Another page</a></h1>");
        if(username==null){
            out.print("<h1>Not Exist</h1>");
        }
        else{
            String url = res.encodeURL("Servlet5?username=" + username);
            out.println("<h3>Hi " + username + ", click below to continue:</h3>");
            out.println("<a href='" + url + "'>Go to Welcome Page</a>");
        }
;
   out.println("</head>");
        out.println("</body>");
        out.print("</html>");



    }
}
