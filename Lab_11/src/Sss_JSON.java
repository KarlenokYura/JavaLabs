import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/sss_json")
public class Sss_JSON extends HttpServlet {
    static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n = Integer.parseInt(req.getHeader("XRand-N"));
        System.out.println(n);
        resp.setContentType("text/json");
        PrintWriter w = resp.getWriter();
        StringBuilder s = new StringBuilder("{\"X\":[");
        for (int i = 0; i < 10; i++) {
            s.append("{\"randValue\":").append((int) ((Math.random() - 0.5)*n)).append("}").append((i < 9) ? "," : " ");
        }
        s.append("]}");
        System.out.println(s);
        w.println(s);
    }
}
