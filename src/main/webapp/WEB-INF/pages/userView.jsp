<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head><title>Hello world</title>
 </head>
 <body>
     <h1>Hello ${user.name}, How are you?</h1>
     <img src="<c:url value="static/img/avatar/${user.name}.png" />"
 </body>
</html>
