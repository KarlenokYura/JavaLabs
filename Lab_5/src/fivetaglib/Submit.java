package fivetaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Submit extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<input type = \"submit\" value = \"OK\" />";
            out.print(in);
            in = "<br><input type = \"submit\" value = \"Cancel\" />";
            out.print(in);
        } catch (IOException e) {
            System.out.println("fivetaglib.Submit: " + e);
        }
        return SKIP_BODY;
    }
}
