package URlRewriting;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out =res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

       String username=req.getParameter("username");
if(username!=null){
    out.print("<h1>welcome to new page"+ username+ "</h1>");

}else{
    out.print("No acces");
}

//        res.addCookie(c);
//        out.println("</head>");
        out.println("</body>");
        out.print("</html>");



    }
}

