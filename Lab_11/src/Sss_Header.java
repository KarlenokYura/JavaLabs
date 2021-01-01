import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss_Header extends javax.servlet.http.HttpServlet implements  javax.servlet.Servlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x = Integer.parseInt(req.getHeader("Value-x"));
        int y = Integer.parseInt(req.getHeader("Value-y"));
        int z = x + y;
        resp.addIntHeader("Value-z", z);
    }
}


