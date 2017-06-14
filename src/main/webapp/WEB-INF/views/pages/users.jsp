<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Form</title>
</head>
<body>
	<h1>Hello, ${user.firstName}</h1>
        
        <c:choose>
            <c:when test="${user.id > 0}">
                <c:set var="formMethod" value="PUT"></c:set>
                <c:url var="formAction" value="/user/${user.id}"></c:url>
            </c:when>
            <c:otherwise>
                <c:set var="formMethod" value="POST"></c:set>
                <c:url var="formAction" value="/user"></c:url>
            </c:otherwise>
        </c:choose>
        
        
	<form:form modelAttribute="user"
		action="${formAction}" method="${formMethod}">
		<div>
			<label>Name:</label>
			<form:input path="firstName" id="firstName" type="text" />

		</div>

		<div>
			<label>Last Name:</label>
			<form:input path="lastName" id="lastName" type="text" />
		</div>

		<div>
			<label>CPF:</label>
			<form:input path="cpf" id="cpf" type="text" />
		</div>

		<div>
			<button type="submit">Save</button>
		</div>
	</form:form>

	<h1>List of User</h1>
	<table>
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>CPF</td>
		</tr>
		
		<c:forEach items="${users}" var="user">
			<tr>
                                <td>${user.id}</td>
				<td>${user.lastName}</td>
				<td>${user.firstName}</td>
				<td>${user.cpf}</td>
                                <td><a href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>