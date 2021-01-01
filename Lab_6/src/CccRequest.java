import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import bean.CBean;

public class CccRequest extends HttpServlet {
    public CBean cBean;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("CBean").equals("new")) {
            cBean = new CBean();
            req.setAttribute("atrCBean", cBean);
            System.out.println("new: " + req.getAttribute("atrCBean"));

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
            System.out.println("old: " + req.getAttribute("atrCBean"));
            cBean = (CBean) req.getAttribute("atrCBean");
            PrintWriter printWriter = resp.getWriter();
            if(cBean!=null){
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
            else {
                printWriter.println("Object is empty");
            }

        }
        req.getRequestDispatcher("CccRequest.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
