import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String username=req.getParameter("Name");
        PrintWriter out =res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1><a href='Servlet2'>Go to Another page</a></h1>");
//        req.getCookies();
        Cookie c[]= req.getCookies();
        boolean f =false;
        String name="";
        if(c==null){
            out.print("Cookie is null");
            out.print("User are new browser");
            return;
        }
        else{
            for(Cookie c1:c){
                String tname=c1.getName();
                if(tname.equals("username")){
                    f=true;
                    name=c1.getValue();
                }

            }

        }
        if(f==true){
            out.print("<h1>hello "+  name+ "</h1>");
        }

        out.println("</body>");
        out.print("</html>");



    }
}
