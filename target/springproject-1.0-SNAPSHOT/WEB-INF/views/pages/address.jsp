<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Form</title>
    </head>
    <body>
        <form:form modelAttribute="address" action="${pageContext.request.contextPath}/address/save" method="GET">
            <div>
                <label>City:</label>
                <form:input path="city" id="city" type="text" />

            </div>

            <div>
                <label>Street:</label>
                <form:input path="street" id="street" type="text" />
            </div>

            <div>
                <label>Number:</label>
                <form:input path="number" id="number" type="text" />
            </div>

            <div>
                <button type="submit">Save</button>
            </div>
        </form:form>

        <h1>List of Address</h1>
        <table>
            <tr>
                <td>City</td>
                <td>Street</td>
                <td>Number</td>
            </tr>

            <c:forEach items="${addresses}" var="address">
                <tr>
                    <td>${address.city}</td>
                    <td>${address.street}</td>
                    <td>${address.number}</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
