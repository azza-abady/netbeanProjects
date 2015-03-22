<%-- 
    Document   : index
    Created on : Mar 4, 2015, 6:05:51 PM
    Author     : azza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <sql:setDataSource var="snapshot" driver="oracle.jdbc.driver.OracleDriver"
                           url="jdbc:oracle:thin:@localhost:1521:xe"
                           user="azza"  password="aza"/>
        <sql:query dataSource="${snapshot}" var="result">
            SELECT Ename,Job,sal from Emp
        </sql:query>

        <table border="1" width="100%">
            <tr>
                <th>Emp name</th>
                <th>Job</th>
                <th>Sal</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.Ename}"/></td>
                    <td><c:out value="${row.Job}"/></td>
                    <td><c:out value="${row.sal}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
