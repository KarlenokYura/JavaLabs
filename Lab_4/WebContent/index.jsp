<%@ page language="java" contentType="text/html;
 charset=ISO-8859-1" %>
<%@ page import="jspclass.* "%>
<html>
<head>
    <title>Lab_4 - JSP</title>
</head>
<body>
<%! Regimex time = new Regimex();%>

<%time.PrintHello(time.getHour());%>
<%time.ArrayDates(time.getDay(), time.getDayOfWeek(), time.getDayOfMonth(), time.getDate());%>
<%=time.getRc()%>

<hr/>

<table border="3">
    <tr>
    <th>Date</th>
    <th>Day Of Week</th>
    </tr>

<%
    for (int i = 0; i < time.getListDays().length; i++) {
        out.println("<tr>");
            out.println("<td>"+time.getListDays()[i][0]+"</td>");
            out.println("<td>"+time.getListDays()[i][1]+"</td>");
        out.println("</tr>");
    }
%>
</table>

<hr/>

<%if (time.getHour() > 0 && time.getHour() <= 5) {%>
    <%@ include file="night.jsp"%>
<%} else if (time.getHour() > 5 && time.getHour() < 12) {%>
    <%@ include file="morning.jsp"%>
<%} else if (time.getHour()>= 12 && time.getHour() <= 17) {%>
    <%@ include file="afternoon.jsp"%>
<%} else {%>
    <%@ include file="evening.jsp"%>
<%}%>

<hr/>

<%if (time.getHour() > 0 && time.getHour() <= 5) {%>
    <jsp:include page="night.jsp"></jsp:include>
<%} else if (time.getHour() > 5 && time.getHour() < 12) {%>
    <jsp:include page="morning.jsp"></jsp:include>
<%} else if (time.getHour()>= 12 && time.getHour() <= 17) {%>
    <jsp:include page="Afternoon"></jsp:include>
<%} else {%>
    <jsp:forward page="evening.jsp"></jsp:forward>
<%}%>

<hr/>

<%-- <%if (time.getHour() > 0 && time.getHour() <= 5) {%>
    <jsp:forward page="night.jsp"></jsp:forward>
<%} else if (time.getHour() > 5 && time.getHour() < 12) {%>
    <jsp:forward page="morning.jsp"></jsp:forward>
<%} else if (time.getHour()>= 12 && time.getHour() <= 17) {%>
    <jsp:forward page="Afternoon"></jsp:forward>
<%} else {%>
    <jsp:forward page="evening.jsp"></jsp:forward>
<%}%> --%>

<a href="Jjj">GET Jjj</a>

<hr/>

<form action="Jjj" method="post">
    <input type="submit" name="press" content="POST Jjj">
</form>
</body>