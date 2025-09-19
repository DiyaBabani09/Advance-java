import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/avg")
public class Average extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int sum = (int) req.getAttribute("sum");
//        int Sum=Integer.parseInt(req.getParameter("sum"));
        res.setContentType("text/html");
        Double avg=sum/2.0;
        PrintWriter out=res.getWriter();
        out.print("sum is "+ sum);
        out.print("<br>");
        out.print("average is "+ avg);
    }
}
