import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import bean.CBean;


public class Ccc extends HttpServlet {
    public CBean cBean;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("atrCBean", cBean);
        System.out.println("init " +servletContext.getAttribute("atrCBean"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("CBean").equals("new")) {
            cBean = new CBean();
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("atrCBean", cBean);
            System.out.println("new: " + servletContext.getAttribute("atrCBean"));

            String param1 = req.getParameter("value1"),
                    param2 = req.getParameter("value2"),
                    param3 = req.getParameter("value3");

            if (!param1.equals("")) {
                cBean.setValue1(param1);
            }
            if (!param2.equals("")) {
                cBean.setValue2(param2);
            }
            if (!param3.equals("")) {
                cBean.setValue3(param3);
            }
        } else if (req.getParameter("CBean").equals("old")){
            ServletContext servletContext = getServletContext();
            System.out.println("old: " + servletContext.getAttribute("atrCBean"));
            cBean = (CBean) servletContext.getAttribute("atrCBean");

            String  param1 = req.getParameter("value1"),
                    param2 = req.getParameter("value2"),
                    param3 = req.getParameter("value3");

            System.out.println(param1);
            if (param1 != null && !param1.equals("")) {
                cBean.setValue1(param1);
            }
            if (param2 != null && !param2.equals("")) {
                cBean.setValue2(param2);
            }
            if (param3 != null && !param3.equals("")) {
                cBean.setValue3(param3);
            }
        }
        if(req.getParameter("filter").equals("JSPpsge")){
            req.getRequestDispatcher("Ccc.jsp?filter=JSP").forward(req, resp);
        }else{
            req.getRequestDispatcher("Ccc.jsp").forward(req, resp);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
