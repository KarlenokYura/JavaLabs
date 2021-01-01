<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@page %>
<html>
<head>
    <title>Afternoon</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter("logs\\stdout.txt"));
    writer.write("Afternoon");
    writer.append("\n");
    writer.close();
%>
<h1>Afternoon</h1>
</body>
</html>
