import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class F3 implements Filter {
    public F3() { }

    public void init(FilterConfig request) throws ServletException {
        System.out.println("F3: init");
    }

    public void destroy() {
        System.out.println("F3: destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        if (req.getParameter("filter").equals("F3")) {
            System.out.println("F3: Stop");
            resp.getWriter().println("F3: Stop");
        } else {
            System.out.println("F3: doFilter");
            filterChain.doFilter(req, resp);
            System.out.println("F3: reDoFilter");
        }
    }
}
