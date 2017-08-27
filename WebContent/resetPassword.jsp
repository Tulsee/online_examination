<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="resources/css/form.css">
</head>
<script>
    function myFunction() {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;
        if (pass1 != pass2) {
            alert("New password and Confirm password Do not Match");
            document.getElementById("pass1");
            document.getElementById("pass2");
        }
       
    }
</script>


<body background="natur.jpg">
	<form action="ResetPasswordController" method="post">
		<div class="box">
			<div class="first">
				<img src="resources/images/user-login-icon.png">
			</div>
			<h2>Reset Password</h2>

			<input type="password" placeholder="Current Password" name="pass"><br>
			<br> <input id="pass1" type="password" placeholder="New Password"
				name="newpass1"><br> <br> <input id="pass2"  type="password"
				placeholder="Retype New Password" name="newpass2"><br>
			<br> <input onclick="myFunction()" type="submit" value="Submit">
		</div>
	</form>

</body>
</html>