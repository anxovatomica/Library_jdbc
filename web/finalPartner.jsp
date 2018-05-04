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
            String loan = (String) request.getAttribute("loan");
            String back = (String) request.getAttribute("back");
        %>
        <h1> <%= status %> </h1>
        <a href="<%= back %>" target="_blank">Go Back</a>
        <a href="<%= loan %>" target="_blank">New Loan</a>
    </body>
</html>
