import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Sss: Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get SSS Servlet");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Get SSS Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post SSS Servlet");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        String login = null;
        Principal usernamePrincipal = req.getUserPrincipal();
        if (usernamePrincipal != null)
            login = usernamePrincipal.getName();

        printWriter.println(login);
    }
}
