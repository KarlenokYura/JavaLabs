import java.io.IOException;
import java.io.PrintWriter;

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
	
	//protected void service(HttpServletRequest rq, HttpServletResponse rs)
	//		throws ServletException, IOException 
	//{
	//	System.out.println("Sss:service:"+rq.getMethod() + "\n\r, Sss:service: " + rq.getRequestURL());
	//	rs.setContentType("text/html");
	//	PrintWriter pw = rs.getWriter();
	//	pw.println("Sss:service: " + rq.getMethod() + "\n\r, Sss:service: " + rq.getRequestURL());
	//}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
			 System.out.println("Sss:doGet:fistname=" + firstname + ", lastname=" + lastname); 
			 rs.setContentType("text/html"); 
			 PrintWriter pw = rs.getWriter(); 
			 pw.println("<html> " 
			 +"<body> "
			 +"<br>Sss:doGet:firstname=" + firstname 
			 +"<br>Sss:doGet:lastname=" + lastname 
			 +"</body>" 
			 +"</html>"); 
			 pw.close(); 
	} 
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
			 System.out.println("Sss:doPost:fistname=" + firstname + ", lastname=" + lastname); 
			 rs.setContentType("text/html"); 
			 PrintWriter pw = rs.getWriter(); 
			 pw.println("<html> " 
			 +"<body> "
			 +"<br>Sss:doPost:firstname=" + firstname 
			 +"<br>Sss:doPost:lastname=" + lastname 
			 +"</body>" 
			 +"</html>"); 
			 pw.close(); 
	} 
} 