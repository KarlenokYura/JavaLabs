import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jjj extends HttpServlet {

    private Calendar calendar = Calendar.getInstance();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Jjj:init");
    }
    
    @Override
	protected void service(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException 
	{
		rs.setContentType("text/html"); 
		PrintWriter pw = rs.getWriter(); 
		pw.println(sendGggRequest(rq.getMethod())); 
		pw.close();
	}
	

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Jjj:doGet");
        RequestDispatcher rd = null;
        if (hour > 0 && hour <= 5)
            //resp.sendRedirect("night.jsp");
        	rd = req.getRequestDispatcher("night.jsp");
        else if (hour > 5 && hour < 12)
            //resp.sendRedirect("morning.jsp");
        	rd = req.getRequestDispatcher("morning.jsp");
        else if (hour >= 12 && hour <= 17)
            //resp.sendRedirect("afternoon.jsp");
        	rd = req.getRequestDispatcher("afternoon.jsp");
        else
            //resp.sendRedirect("evening.jsp");
        	rd = req.getRequestDispatcher("evening.jsp");
		rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Jjj:doPost");
        RequestDispatcher rd = null;
        if (hour > 0 && hour <= 5)
            //resp.sendRedirect("night.jsp");
        	rd = req.getRequestDispatcher("night.jsp");
        else if (hour > 5 && hour < 12)
            //resp.sendRedirect("morning.jsp");
        	rd = req.getRequestDispatcher("morning.jsp");
        else if (hour >= 12 && hour <= 17)
            //resp.sendRedirect("afternoon.jsp");
        	rd = req.getRequestDispatcher("afternoon.jsp");
        else
            //resp.sendRedirect("evening.jsp");
        	rd = req.getRequestDispatcher("evening.jsp");
		rd.forward(req, resp);
    }
    
    private String sendGggRequest(String method) throws IOException {
        if (method == null) {
            return "No method parameter has been provided";
        }
        System.out.println("Jjj:do" + method);
        URL endpoint = new URL("http://localserver:8080/Lab_4/night.jsp");
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        connection.setRequestMethod(method.toUpperCase());

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String chunk;
        StringBuilder content = new StringBuilder();
        while ((chunk = in.readLine()) != null) {
            content.append(chunk);
        }
        in.close();

        return content.toString();
    }
}

