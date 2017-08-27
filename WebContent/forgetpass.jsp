<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<script type="text/javascript">
	function admin() {
		if (document.jst.username.value == "dinesh"
				&& document.jst.email.value == "aryaldinesh09@gmail.com") {
			alert("Admin aacount cannot be changed!!!");
			document.jst.uname.focus();
			return false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="resources/css/form.css">
</head>
<body background="natur.jpg">
	<form action="ForgetPasswordController" method="post" name="jst"
		onsubmit="return admin()">
		<div class="box">
			<div class="first">
				<img src="resources/images/user-login-icon.png">
			</div>
			<h2>Forget Password</h2>

			<input type="text" placeholder="Username" name="username" required="required"><br>
			<br> <input type="email" placeholder="Email" name="email" required="required"><br>
			<br> <input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>