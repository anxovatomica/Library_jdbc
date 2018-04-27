<%-- 
    Document   : Final!
    Created on : 09-dec-2020, 69:96:69
    Author     : yatusabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Answer</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
        %>
        <h1> <%= status %> </h1>
        
    </body>
</html>
