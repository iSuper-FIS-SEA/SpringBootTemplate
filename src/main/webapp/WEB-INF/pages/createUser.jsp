<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
   <title>User</title>
 </head>
 <body>
   <h2>User Form</h2>
      <form:form method="POST" action="user/save" enctype="multipart/form-data">
          Name: <input type="text" name="name"><br />
          Email: <input type="text" name="email"><br />
          image upload: <input type="file" name="imagefile"><br />
          <input type="submit" value="Create">
      </form:form>
 </body>
</html>
