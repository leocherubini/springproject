<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Form</title>
</head>
<body>
	<h1>Hello, ${user.firstName}</h1>
    <a href="${pageContext.request.contextPath}/user?myLocale=pt_BR">Portuguese</a>
	<a href="${pageContext.request.contextPath}/user?myLocale=en_US">English</a>

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
        
        <sec:authorize access="hasRole('ADMIN')">
        
        
        <div class="container">
            
            <form:form modelAttribute="user"
                    action="${formAction}" method="${formMethod}" class="col-sm-6">
                    <div class="form-group row">
                            <label>Name:</label>
                            <form:input class="form-control" path="firstName" id="firstName" type="text" />
                    </div>

                    <div class="form-group row">
                            <label>Last Name:</label>
                            
                            <form:input class="form-control" path="lastName" id="lastName" type="text" />
                    </div>

                    <div class="form-group row">
                            <label>CPF:</label>
                            <form:input class="form-control" path="cpf" id="cpf" type="text" />
                    </div>
                    
                    <div class="form-group row">
                            <label><spring:message code="user.username" /></label>
                            <form:input class="form-control" path="username" id="username" type="text" />
                    </div>
                    
                    <div class="form-group row">
                            <label><spring:message code="user.password" /></label>
                            <form:input class="form-control" path="password" id="password" type="password" />
                    </div>
                    
                    <div class="form-group row">
                            <label>Profile</label>
                            <form:select items="${profiles}" path="userProfiles" multiple="true"></form:select>
                    </div>

                    <div class="form-group row">
                        <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i>
Save</button>
                    </div>
            </form:form>
            
        </div>
        </sec:authorize>

	<h1>List of User</h1>
        <table class="table">
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>CPF</td>
                        <th></th>
                        <th></th>
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