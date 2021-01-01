import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*; 
import javax.servlet.http.*;

public class Ggg extends HttpServlet implements Servlet 
{	
	public Ggg() 
	{
		super();
		System.out.println("Ggg:constructor");
	}
	
	public void init(ServletConfig sc) throws ServletException 
	{
		super.init();
		System.out.println("Ggg:init");
	}
	
	public void destroy() 
	{
		super.destroy();
		System.out.println("Ggg:destroy");
	}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
			 System.out.println("Ggg:doGet:fistname=" + firstname + ", lastname=" + lastname); 
			 rs.setContentType("text/html"); 
			 PrintWriter pw = rs.getWriter(); 
			 pw.println("<html> " 
			 +"<body> "
			 +"<br>Ggg:doGet:firstname=" + firstname 
			 +"<br>Ggg:doGet:lastname=" + lastname 
			 +"</body>" 
			 +"</html>"); 
			 pw.close(); 
			 
			 //RequestDispatcher rd = null;
			 //String params = "firstname=" + firstname + "&" + "lastname=" + lastname; 
			 //rd = rq.getRequestDispatcher("/main.html"); 
			 //rd.forward(rq, rs);
			 
			 //rs.sendRedirect("http://localserver:8080/Lab_3/main.html");
	} 
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
			 System.out.println("Ggg:doPost:fistname=" + firstname + ", lastname=" + lastname + "&method=Post"); 
			 rs.setContentType("text/html"); 
			 PrintWriter pw = rs.getWriter(); 
			 pw.println("<html> " 
			 +"<body> "
			 +"<br>Ggg:doPost:firstname=" + firstname 
			 +"<br>Ggg:doPost:lastname=" + lastname 
			 +"</body>" 
			 +"</html>"); 
			 pw.close(); 
	} 
} 