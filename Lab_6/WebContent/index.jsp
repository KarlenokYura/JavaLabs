<%@page contentType="text/html; ISO-8859-1" language="java" info="" %>
<html>
<head>
    <title>Lab_6</title>
</head>
<body>
    <h1>Lab_6</h1>

    <h3>Tasks 1-3</h3>
    <form action="urln" method="post">
        <input type="text" title="urln" name="urln"/>
        <input type="submit" value="Ok">
    </form>

    <h3>Tasks 4-10</h3>
    <form action="Ccc" method="get">
        <input type="text" name="value1" placeholder="Value1"/><br/>
        <input type="text" name="value2" placeholder="Value2"/><br/>
        <input type="text" name="value3" placeholder="Value3"/><br/>
        New <input type="radio" name="CBean" value="new" placeholder="New" title=""/><br/>
        Old <input type="radio" name="CBean" value="old" placeholder="Old" title=""/><br/>
        <button type="submit">click</button>
    </form>
    <hr>

    <h1>Lab_7</h1>

    <h3>Request</h3>
    <form action="CccRequest" method="get">
        <input type="text" name="value1" placeholder="Value1"/><br/>
        <input type="text" name="value2" placeholder="Value2"/><br/>
        <input type="text" name="value3" placeholder="Value3"/><br/>
        New <input type="radio" name="CBean" value="new" placeholder="New" title=""/><br/>
        Old <input type="radio" name="CBean" value="old" placeholder="Old" title=""/><br/>
        <button type="submit">click</button>
    </form>

    <h3>Session</h3>
    <form action="CccSession" method="get">
        <input type="text" name="value1" placeholder="Value1"/><br/>
        <input type="text" name="value2" placeholder="Value2"/><br/>
        <input type="text" name="value3" placeholder="Value3"/><br/>
        New <input type="radio" name="CBean" value="new" placeholder="New" title=""/><br/>
        Old <input type="radio" name="CBean" value="old" placeholder="Old" title=""/><br/>
        <button type="submit">click</button>
    </form>
</body>
</html>