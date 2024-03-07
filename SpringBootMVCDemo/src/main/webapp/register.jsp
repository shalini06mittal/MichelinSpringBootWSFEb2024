
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">EMS</a>
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
          <a class="nav-link" href="regsiter">Register</a>
        </li>
      </ul>

    </div>
  </div>
</nav>
	<div class="container">
		<h1>Register Customer</h1>
		<form action="register" method="post">
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Email
				</label> <input type="email" class="form-control" name="email"
					id="formGroupExampleInput2" placeholder="Email">
</div>
<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Name
				</label> <input type="text" class="form-control" name="ename"
					id="formGroupExampleInput2" placeholder="Name">
			</div>
<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Phone
				</label> <input type="text" class="form-control" name="phone"
					id="formGroupExampleInput2" placeholder="Phone">
			</div>
<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Password
				</label> <input type="password" class="form-control" name="password"
					id="formGroupExampleInput2" placeholder="Password">
			</div>

			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>
</body>
</html>
