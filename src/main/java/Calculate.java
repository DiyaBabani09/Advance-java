import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTML;
import java.io.IOException;
@WebServlet("/add")
public class Calculate extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int a=Integer.parseInt(req.getParameter("x"));
        int b=Integer.parseInt(req.getParameter("y"));
        int add=a+b;
        req.setAttribute("sum",add);
        RequestDispatcher r=req.getRequestDispatcher("avg");
        r.forward(req,res);

        // 2 way by redierect
//        res.sendRedirect("avg?sum="+add);
    }
}
