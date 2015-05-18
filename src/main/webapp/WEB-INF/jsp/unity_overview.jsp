<%--
 * 
 * @author Shengzhao Li
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Unity</title>
</head>
<body>
<a href="../">Home</a>

<h3>Unity Overview</h3>

<div>
    User Info:
    <ul>
        <li>Guid: ${userDto.guid}</li>
        <li>Username: ${userDto.username}</li>
        <li>Email: ${userDto.email}</li>
        <li>Phone: ${userDto.phone}</li>
    </ul>
</div>
</body>
</html>