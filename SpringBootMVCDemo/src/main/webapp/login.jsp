<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<style type="text/css">
	.error{
		color:red;
	}
	</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">NorthernTrust</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="register">Register</a>
        </li>
      </ul>

    </div>
  </div>
</nav>
	<div class="container">

		<h1>Login</h1>
		<div class="error">${error}</div>
		<form action="login" method="POST">
		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Email
				</label> <input type="email" class="form-control"
				name="email" value=" sia@test.com "
				id="formGroupExampleInput2" placeholder="Email">
		</div>
		<div class="mb-3">
			<label for="formGroupExampleInput2" class="form-label">Password
				</label> <input type="password" class="form-control"
				name="password" value="sia123"
				id="formGroupExampleInput2" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>

