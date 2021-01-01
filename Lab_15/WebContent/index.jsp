<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <form action="MailServlet" method="post">
    <p>Mail: <input type="text" name="mail"></p>
    <p>Message: <input type="text" name="message"></p>
    <p><input type="submit"></p>
  </form>
  <a href="ReadEmail">Read message</a>
  </body>
</html>