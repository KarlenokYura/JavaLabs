<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" import="choise.* " %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Index</h1>
  <%
    String d = (String) config.getServletContext().getInitParameter("docDir");
    Choise ch = new Choise(d, "docx");
    String ll = null;
    for (int i = 0; i < ch.list.length; i++) {
      ll = ch.list[i];
  %>
  <a href="Sss?file=<%=ll%>"> <%=ll%> </a>
  <br>
  <%}%>
  </body>
</html>