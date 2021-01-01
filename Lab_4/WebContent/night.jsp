<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@page %>
<html>
<head>
    <title>Night</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter("logs\\stdout.txt"));
    writer.write("Night");
    writer.append("\n");
    writer.close();
%>
<h1>Night</h1>
</body>
</html>
