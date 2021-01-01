import javax.mail.*;
import javax.mail.search.FlagTerm;
import javax.mail.search.NotTerm;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ReadEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = Session.getDefaultInstance(new Properties());
		try {
			Store store = session.getStore("imaps");
			store.connect(getServletContext().getInitParameter("ImapHost"),
	                Integer.parseInt(getServletContext().getInitParameter("ImapPort")),
	                getServletContext().getInitParameter("MailLogin"),
	                getServletContext().getInitParameter("MailPassword"));
	        Folder inbox = store.getFolder("INBOX");
	        inbox.open(Folder.READ_ONLY);
	        Message[] messages = inbox.getMessages();
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter printWriter = response.getWriter();
	        printWriter.println("Count: "+ messages.length);
	        printWriter.println("<br/>");
	        for ( Message message : messages ) {
	        	printWriter.println("<br/>");
	            printWriter.println("SendDate: "+ message.getSentDate() + ", ");
	            printWriter.println("Subject: "+ message.getSubject() + ", ");
	            printWriter.println("Content: "+ message.getContent());
	        }
	        printWriter.flush();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}