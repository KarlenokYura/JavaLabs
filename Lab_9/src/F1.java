import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class F1 implements Filter {
    public F1() { }

    public void init(FilterConfig request) throws ServletException {
        System.out.println("F1: init");
    }

    public void destroy() {
        System.out.println("F1: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        if (req.getParameter("filter").equals("F1")) {
            System.out.println("F1: Stop");
            resp.getWriter().println("F1: Stop");
        } else {
            System.out.println("F1: doFilter");
            filterChain.doFilter(req, resp);
            System.out.println("F1: reDoFilter");
        }
    }
}