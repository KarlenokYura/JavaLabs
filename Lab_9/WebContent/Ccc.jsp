<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.CBean" %>

<html>
<head>
    <title>Lab_6</title>
</head>
<body>
    <%
        CBean cBean = (CBean)this.getServletConfig().getServletContext().getAttribute("atrCBean");
        out.println("value 1 = " + cBean.getValue1());
        out.println("<br/>value 2 = " + cBean.getValue2());
        out.println("<br/>value 3 = " + cBean.getValue3());
    %>
</body>
</html>