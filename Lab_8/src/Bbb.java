import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bbb extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        Enumeration<String> paramsNames = req.getParameterNames();
        StringBuilder stringBuilder = new StringBuilder();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            stringBuilder.append("<div>").append(headerName).append(": ").append(req.getHeader(headerName)).append("</div>");
        }
        
        while (paramsNames.hasMoreElements()) {
            String paramName = paramsNames.nextElement();
            stringBuilder.append("<div>").append(paramName).append(": ").append(req.getParameter(paramName)).append("</div>");
        }

        resp.setHeader("MyHeaderResponse1", "MyHeadetValue1");
        resp.setHeader("MyHeaderResponse2", "MyHeadetValue2");
        resp.getWriter().println(stringBuilder);
    }
}
