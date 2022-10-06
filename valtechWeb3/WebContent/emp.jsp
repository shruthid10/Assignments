<%@page import="com.valtech.dao.Employee"%>
<%@page import="com.valtech.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% //Employee e=(Employee)request.getAttribute("e");
    EmployeeDAO dao = new EmployeeDAO();
    int id = Integer.parseInt(request.getParameter("empid"));
    Employee e =dao.getEmployee(id);
    //Employee e2 =dao.getEmployee(1);
    String prev = "empCtrl?empid="+dao.getPreviousId(id);
    String next = "empCtrl?empid="+dao.getNextId(id);
     String first = "empCtrl?empid="+dao.getFirstId(id);
    String last = "empCtrl?empid="+dao.getLastId(id);
    %>
    
<table>
<tr>
<td>Id</td><td><%= e.getId() %></td>
</tr>
<tr>
<td>Name</td><td><%= e.getName() %></td>
</tr>
<tr>
<td>Age</td><td><%= e.getAge() %></td>
</tr>
<tr>
<td>Gender</td><td><%= e.getGender() %></td>
</tr>
<tr>
<td>Salary</td><td><%= e.getSalary() %></td>
</tr>
<tr>
        <td><a href=<%=prev %>>Previous</a></td>
        <td><a href=<%=next %>>Next</a></td>
        <td><a href=<%=first %>>first</a></td>
        <td><a href=<%=last %>>last</a></td>
    </tr>


</table>
</body>
</html>