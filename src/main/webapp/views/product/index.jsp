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
<body>
	<div class="container my-3">
		<div class="row">
			<c:forEach var="item" items="${items}">
				<div class="col-lg-3 col-md-6 col-sm-6 col-6 mt-3 px-1">
					<div class="card" style="width: 300px;">
						<div class="card-header p-0">
							<img src="/views/img/${item.img}" style="height: 300px;" class="card-img-top" alt="...">
						</div>
						<div class="card-body">
							<p class="card-text">${item.name}</p>
							<h5 class="card-title">${item.price}</h5>
							<a href="/cart/add/${item.id}" class="btn btn-outline-primary">Add
								To Cart</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>