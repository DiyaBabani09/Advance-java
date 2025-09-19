package URlRewriting;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hiddenss")
public class Servlet6 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String username=req.getParameter("Name");
        PrintWriter out =res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

//        out.println("<h1><a href='Servlet7'>Go to Another page</a></h1>");
        if(username==null){
            out.print("<h1>Not Exist</h1>");
        }
        else{
            //hidden form create
            out.println("<form action='Servlet7' method='get'>");
            out.println("<input type='hidden' name='username' value='" + username + "' />");

            // Additional input
            out.println("Enter your age: <input type='text' name='age' />");
            out.println("<input type='submit' value='Submit' />");
            out.println("</form>");

        }


        out.println("</head>");
        out.println("</body>");
        out.print("</html>");



    }
}
