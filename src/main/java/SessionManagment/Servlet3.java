package SessionManagment;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        PrintWriter out =res.getWriter();
        out.println("<head>");
        out.println("<html>");
        res.setContentType("text/html");
//        String username=req.getParameter("Name");
        out.println("</head>");
        out.println("<body>");


//        req.getSession();
        HttpSession s=req.getSession(false);
        boolean f =false;
        String name="";
        if(s==null){
            s.invalidate();
            out.print("<h1>Session  is null<h1>");
            out.print("<h1>no user are exit </h1>");
            return;
        }
        else {
            String tname = (String) s.getAttribute("username");
            if (tname!=null) {
                out.println("<h2>Welcome back, " + tname+ "   " + "!</h2>");
            }else {
                out.println("<p>No username in session. Please <a href='Servlet2'>login</a>.</p>");
            }

        }


        out.println("</body>");
        out.print("</html>");



    }
}
