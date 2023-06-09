<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container col-lg-5 col-md-7 col-sm-12 mt-5 bg-light"
		style="min-height: 0px; border: 1px solid rgba(0, 0, 0, 0.515); border-radius: 15px;">
		<div class="tab-content mt-5 mb-5 mx-5">
			<div class="tab-pane fade show active" id="pills-login"
				role="tabpanel" aria-labelledby="tab-login">
				<form action="/account/login" method="post">
					<h1 class="mb-4">LOGIN</h1>
					<div class="form-outline mb-4">
						<label class="form-label" for="loginName">Username</label> <input
							type="text" name="username" id="loginName" class="form-control" />
					</div>

					<div class="form-outline mb-4">
						<label class="form-label" for="loginPassword">Password</label> <input
							type="password" name="password" id="loginPassword"
							class="form-control" />
					</div>

					<div class="row mb-4">
						<div class="col-md-6">
							<div class="form-check mb-3 mb-md-0">
								<input class="form-check-input" type="checkbox" value="true"
									name="remember" id="loginCheck" checked /> <label
									class="form-check-label" for="loginCheck"> Remember me
								</label>
							</div>
						</div>
					</div>

					<button type="submit"
						class="btn btn-outline-primary btn-block mb-4">Sign in</button>

				</form>
			</div>
		</div>
	</div>
	<!-- 
	<form action="/account/login" method="post">
		<input name="username"> <input name="password"> <input
			type="checkbox" name="remember" value="true">
		<button>Login</button>
	</form>
	 -->
</body>
</html>