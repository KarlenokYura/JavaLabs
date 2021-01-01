import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class urln  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("urln");

        PrintWriter printWriter = resp.getWriter();

        if (param.equals("1")) {
            resp.sendRedirect(getServletContext().getInitParameter("URL1"));
        } else if (param.equals("2")) {
            resp.sendRedirect(getServletContext().getInitParameter("URL2"));
        } else{
            printWriter.println("parameter URL not found");
        }

    }
}
