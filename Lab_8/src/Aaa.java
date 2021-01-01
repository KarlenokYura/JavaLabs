import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

public class Aaa extends HttpServlet {
    public Aaa() {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod pm = new PostMethod("http://localhost:8080" + req.getContextPath() + "/Bbb");


        pm.addRequestHeader("MyHeader1", "MyHeadetValue1");
        pm.addRequestHeader("MyHeader2", "MyHeadetValue2");
        pm.addRequestHeader("MyHeader3", "MyHeadetValue3");
        NameValuePair[] parms = { new NameValuePair("param1", "v1"),
                                    new NameValuePair("param2", "v2"),
                                    new NameValuePair("param3", "v3")};
        pm.addParameters(parms);
        httpClient.executeMethod(pm);
        
        if (pm.getStatusCode() == HttpStatus.SC_OK) {
            String body = pm.getResponseBodyAsString();
            StringBuilder stringBuilder = new StringBuilder();
            Header[] resHeaders = pm.getResponseHeaders();
            for (int i = 0; i < resHeaders.length; i++) {
                stringBuilder.append("<div>").append(resHeaders[i].getName()).append(": ").append(resHeaders[i].getValue()).append("</div>");
            }
            resp.getWriter().append("<div class='title-name'>Headers of Request</div>").append(body).append("<div class='title-name'>Headers of Response</div>").append(stringBuilder);
        }
        else{
            System.out.println("Sss:service:getStatusCode()=" + pm.getStatusCode());
        }
    }

}