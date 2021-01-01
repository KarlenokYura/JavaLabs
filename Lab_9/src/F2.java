import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class F2 implements Filter {
    public F2() { }

    public void init(FilterConfig request) throws ServletException {
        System.out.println("F2: init");
    }

    public void destroy() {
        System.out.println("F2: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        if (req.getParameter("filter").equals("F2")) {
            System.out.println("F2: Stop JSP");
            resp.getWriter().println("F2: Stop JSP");
        }
        else {
            System.out.println("F2: doFilter");
            filterChain.doFilter(req, resp);
            System.out.println("F2: reDoFilter");
        }
    }
}