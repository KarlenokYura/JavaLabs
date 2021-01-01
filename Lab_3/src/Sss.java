import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.*; 
import javax.servlet.http.*;

public class Sss extends HttpServlet implements Servlet 
{	
	public Sss() 
	{
		super();
		System.out.println("Sss:constructor");
	}
	
	public void init(ServletConfig sc) throws ServletException 
	{
		super.init();
		System.out.println("Sss:init");
	}
	
	public void destroy() 
	{
		super.destroy();
		System.out.println("Sss:destroy");
	}
	
	protected void service(HttpServletRequest rq, HttpServletResponse rs)
			throws ServletException, IOException 
	{
		rs.setContentType("text/html"); 
		PrintWriter pw = rs.getWriter(); 
		pw.println(sendGggRequest(rq.getMethod())); 
		pw.close();
	}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			String firstname = rq.getParameter("firstname"); 
			String lastname = rq.getParameter("lastname"); 
			System.out.println("Sss:doGet:fistname=" + firstname + ", lastname=" + lastname); 
			//rs.setContentType("text/html"); 
			//PrintWriter pw = rs.getWriter(); 
			//pw.println("<html> " 
			//+"<body> "
			//+"<br>Ggg:doGet:firstname=" + firstname 
			//+"<br>Ggg:doGet:lastname=" + lastname 
			//+"</body>" 
			//+"</html>"); 
			//pw.close(); 
			
			//RequestDispatcher rd = null;
			String params = "firstname=" + firstname + "&" + "lastname=" + lastname; 
			//rd = rq.getRequestDispatcher("/Ggg?" + params);  //1
			//rd = rq.getRequestDispatcher("/main.html"); //2
			//rd.forward(rq, rs);
			
			rs.sendRedirect("http://localserver:8080/Lab_3/Ggg?" + params);
			//rs.sendRedirect("http://localserver:8080/Lab_3/main.html");
	} 
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
			 System.out.println("Sss:doPost:fistname=" + firstname + ", lastname=" + lastname); 
			 
//			 rs.setContentType("text/html"); 
//			 PrintWriter pw = rs.getWriter(); 
//			 pw.println("<html> " 
//			 +"<body> "
//			 +"<br>Sss:doPost:firstname=" + firstname 
//			 +"<br>Sss:doPost:lastname=" + lastname 
//			 +"</body>" 
//			 +"</html>"); 
//			 pw.close(); 
			 
			 //RequestDispatcher rd = null;
			 String params = "firstname=" + firstname + "&" + "lastname=" + lastname; 
			 //rd = rq.getRequestDispatcher("/Ggg?" + params);  //1
			 //rd = rq.getRequestDispatcher("/main.html"); //2
			 //rd.forward(rq, rs);
			 
			 rs.sendRedirect("http://localserver:8080/Lab_3/Ggg?" + params);
			 //rs.sendRedirect("http://localserver:8080/Lab_3/main.html");
			 
	} 
	
	private String sendGggRequest(String method) throws IOException {
        if (method == null) {
            return "No method parameter has been provided";
        }

        URL endpoint = new URL("http://localserver:8080/Lab_3//Ggg?firstname=YURA&lastname=KARLENOK&method=" + method);
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