<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Form</title>
</head>
<body>
	<form:form modelAttribute="product" action="/product/save" method="GET">
		<div>
			<label>Product Name:</label>
			<form:input path="productName" id="productName" type="text" />

		</div>

		<div>
			<label>Product Price</label>
			<form:input path="productPrice" id="productPrice" type="text" />
		</div>

		<div>
			<button type="submit">Save</button>
		</div>
	</form:form>
</body>
</html>