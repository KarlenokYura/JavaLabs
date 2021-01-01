import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class L1 implements ServletContextListener{

    // Public constructor is required by servlet spec
    public L1() {
    }
    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ss = sce.getServletContext();
        System.out.println("L1:contextInitialized");
        System.out.println("L1:serverInfo="+ss.getServerInfo());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ss = sce.getServletContext();
        System.out.println("L1:contextDestroyed");
    }
}
