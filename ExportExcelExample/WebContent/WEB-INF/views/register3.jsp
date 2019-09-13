<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script src="scripts/jquery-1.6.4.js"></script>
<script src="scripts/validations2.js"></script>
<script type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
 
 
 
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>

</head>
<body>

		<center><h2>Add Employee Data2</h2></center>
		<form:form  method="POST" action="/ExportExcelExample/register2.html" autocomplete="off"
								modelAttribute="EmployeeModel">
	   		<table align="center" border="1">
			    <tr>
			        <td><form:label path="empId"></form:label></td>
			        <td>
			        	<form:hidden path="empId" value="${employeeBean.empId}" 	         
			        	readonly="true"  id="employeeId" />
			       </td>
			    </tr>
			     
			    <tr>
			        <td><form:label path="empName">Employee Name:</form:label></td>
			        <td>
			        	<form:input path="empName" value="${employeeBean.empName}" 
			         	placeholder="Enter name" id="empNameId"  autofocus="autofocus" 
			        	onblur="eNameValidation('empNameId','empNameErr')"/>
			        	<span style="color:red;" id="empNameErr"> </span>
			        </td>				<!-- value field stores the value given as input -->
			    </tr>
			    
			    <tr>
			        <td><form:label path="empDob">Employee DOB:</form:label></td>
			        <td>
			        	<form:input type="text" path="empDob"  value="${employeeBean.empDob}" 
			         		placeholder="Enter Date Of birth" id="empDobId"
			         		onchange="empDobValidation('empDobId','empDobIdErr')"/>
			        	<span style="color:red;" id="empDobIdErr"> </span>
			        </td>				<!-- value field stores the value given as input -->
			    </tr>
			    
			    <tr>
			        <td><form:label path="empGender">Employee Gender:</form:label></td>
			        <td>
			        	<form:select path="empGender" value="${employeeBean.empGender}"
			        		id="empGenderId" onblur="empGenderValidation('empGenderId','empGenderErr')">
			        		<form:option value="">Select</form:option>
			        		<form:option value="Male">Male</form:option>
			        		<form:option value="Female">Female</form:option>	
			        		<form:option value="others">Others</form:option>
			        	</form:select>
			        	<span style="color:red;" id="empGenderErr"></span>
			        </td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="empPass">Employee Password:</form:label></td>
			        <td>
			        	<form:password path="empPass" value="${employeeBean.empPass}"  
			        	id="empPassId" placeholder="Enter password" 
			        	onblur="empPassValidation('empPassId','empPassErr')"/>
			        	<span style="color: red;" id="empPassErr"></span>
			        </td>			<!-- form:password=>encrypts the text to ***-->
			    </tr>
			    
			    <tr>
			        <td><form:label path="empCfPass">Confirm Password:</form:label></td>
			        <td>
			        	<form:password path="empCfPass"  value="${employeeBean.empCfPass}" 
			        	placeholder="Re-Enter password" id="empCfPassId"
			        	onblur="empCfPassValidation('empCfPassId','empCfPassErr','empPassId')"/>
			        	<span style="color: red;" id="empCfPassErr"></span>			        
			        </td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="empPhno">Employee Phone Number:</form:label></td>
                    <td>
                    	<form:input path="empPhno"  value="${employeeBean.empPhno}" 
                    	placeholder="Enter Phone number" id="empPhnoId" maxlength="10"
                    	onblur="empPhnoValidation('empPhnoId','empPhnoErr')"/>
                    	<span style="color: red;" id="empPhnoErr"></span>
                    </td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="empAge">Employee Age:</form:label></td>
                    <td>
                    	<form:input path="empAge"  value="${employeeBean.empAge}" 
                    	placeholder="Enter Age" id="empAgeId"  maxlength="2"
                    	onblur="empAgeValidation('empAgeId','empAgeErr')"/>
                    	<span style="color: red;" id="empAgeErr"></span>
                    </td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="empAddr">Employee Address:</form:label></td>
                    <td>
                    	<form:input path="empAddr"  value="${employeeBean.empAddr}"  
                    	placeholder="Enter Address" id="empAddrId"
                    	onblur="empAddrValidation('empAddrId','empAddrErr')"/>
                    	<span style="color: red;" id="empAddrErr"></span>
                    </td>
			    </tr>
			    
			    <tr>
			      <td colspan="2">
			      	<input align="middle" type="submit" value="SUBMIT" id="submit"/>
			      	<input  type="reset" value="RESET">
			      </td>
		      </tr>
		      
			</table>
			<center><span style="color: red;" id="emptyErr"></span></center>
		</form:form>
		<h1 align="center"><span style="color: green;"> ${success}</span></h1>
		
	<c:if test="${!empty al}"><!-- if loop -->
	<center><h2>List of Employees</h2></center>
	
	<table align="center" border="1" class="GridOne">
	
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Dob</th>
			<th>Employee Gender</th>
			<th>Employee PhoneNumber</th>
			<th>Employee Age</th>
			<th>Employee Address</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${al}" var="alt"><!-- for each loop -->
			<tr>
				<td><c:out value="${alt.empId}"/></td>
				<td><c:out value="${alt.empName}"/></td>
				<td><c:out value="${alt.empDob}"/></td>
				<td><c:out value="${alt.empGender}"/></td>
				<td><c:out value="${alt.empPhno}"/></td>
				<td><c:out value="${alt.empAge}"/></td>
				<td><c:out value="${alt.empAddr}"/></td>
				<td align="center"><a href="edit.html?id=${alt.empId}">Edit</a>
				<td><a href="delete.html?id=${alt.empId}">Delete</a>
			</tr>
		</c:forEach>
		
	</table>
</c:if>
<h1 align="center"><a href="index.jsp">Home</a></h1>	
	
</body>
</html>