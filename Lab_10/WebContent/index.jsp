<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Lab_10</title>
  </head>
  <body>
  <form method="get" action="DbServlet">
    <input type="submit" value="Statement">
  </form>
  <form method="post" action="DbServlet">
    <input type="text" name="name" placeholder="name">
    <input type="submit" value="PrepareStatement">
  </form>
  <form method="post" action="DbServlet">
    <input type="text" name="id" placeholder="id">
    <input type="submit" value="CallableStatement">
  </form>
  </body>
</html>
