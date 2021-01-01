import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*; 
import javax.servlet.http.*;

public class Sss extends HttpServlet implements Servlet 
{	
	public Sss() 
	{
		super();
	}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
			 throws ServletException, IOException {
			 String firstname = rq.getParameter("firstname"); 
			 String lastname = rq.getParameter("lastname"); 
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
} 