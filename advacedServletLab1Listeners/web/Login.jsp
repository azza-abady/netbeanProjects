<%-- 
    Document   : index
    Created on : Mar 3, 2015, 10:02:29 AM
    Author     : azza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Style-1.css">
        <title>Advanced servlet Lab1</title>
    </head>
    <body>
        <form action="LoginServlet" class="form-container" method="post">
            <div class="form-title"><h2>Sign in</h2></div>
            <div class="form-title">Name</div>
            <input class="form-field" type="text" name="userName" /><span id="vlidFname"></span><br />
            <div class="form-title">Password</div>
            <input class="form-field" type="password" name="userPass"  /><br />
            
            <div class="submit-container">
                <input class="submit-button" type="submit" value="Submit"/>
            </div>
        </form>
    </body>
</html>
