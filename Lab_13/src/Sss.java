import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
        System.out.println("Sss: Init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String docDir = getServletContext().getInitParameter("docDir");
        System.out.println(docDir);
        if (request.getParameter("file") != null) {
            Logger logger = Logger.getLogger("com.anexinet.sample");
            logger.info(request.getParameter("file"));
            File file = new File(docDir+"\\"+request.getParameter("file"));
            response.setContentType("application/msword");
            response.addHeader("Content-Disposition", "attachment; filename="+ file.getName());
            response.setContentLength((int) file.length());

            FileInputStream in = new FileInputStream(file);
            BufferedInputStream buf = new BufferedInputStream(in);
            ServletOutputStream out = response.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1)
                out.write(readBytes);
        }
    }
}
