<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.CBean" %>

<html>
<head>
    <title>Lab_7</title>
</head>
<body>
<%
    CBean cBean = (CBean)request.getAttribute("atrCBean");
    if(cBean!=null){
        out.println("value 1 = " + cBean.getValue1());
        out.println("<br/>value 2 = " + cBean.getValue2());
        out.println("<br/>value 3 = " + cBean.getValue3());
    }
    else {
        out.println("Object is empty");
    }

%>
</body>
</html>