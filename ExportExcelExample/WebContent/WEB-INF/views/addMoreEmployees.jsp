<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">List Employees</h1>
<h3 align="center"><a href="register2">Add More Employee</a></h3>

<c:if test="${!empty al}">
	<table align="center" border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Address</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${al}" var="alt">
			<tr>
				<td><c:out value="${alt.empId}"/></td>
				<td><c:out value="${alt.empName}"/></td>
				<td><c:out value="${alt.empPhno}"/></td>
				<td><c:out value="${alt.empAge}"/></td>
				<td><c:out value="${alt.empAddr}"/></td>
				<td align="center"><a href="edit.html?id=${alt.empId}">Edit</a> </td> 
				<td> <a href="delete.html?id=${alt.empId}">Delete</a></td>	
			</tr>
		</c:forEach>
		
	</table>
</c:if>
<h1 align="center"><a href="index.jsp">Home</a></h1>
<h2 align="right"><a href="/ExportExcelExample/export.html">EXPORT TO EXCEL</a></h2>
<h2 align="right"><a href="/ExportExcelExample/downloadPDF1.html">EXPORT TO PDF</a></h2>
</body>
</html>