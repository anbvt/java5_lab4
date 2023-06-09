<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container">
	<table class="table mt-3">
		<tr class="bg-warning mt-3">
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${cart.items}">
			<tr>
				<form action="/cart/update/${item.id}" method="post">
					<input type="hidden" name="id" value="${item.id}">
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td><input name="qty" value="${item.qty}"
						onblur="this.form.submit()" style="width: 50px;"></td>
					<td>${item.price * item.qty}</td>
					<td><a href="/cart/remove/${item.id}">Remove</a></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	<p class="float-end">
		<a class="btn btn-danger" href="/cart/clear">Clear Cart</a>
		<a class="btn btn-primary" href="/">Add more</a>
	</p>
</body>
</html>