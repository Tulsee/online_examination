<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
<script type="text/javascript">
	function validateForm() {
		if (document.jst.use_name.value == "") {
			alert("Username should not be left blank");
			document.jst.uname.focus();
			return false;
		}

	}
</script>
<link rel="stylesheet" href="resources/css/rgistrationform.css">
</head>
<body background="natur.jpg">

	<div class="logindiv">
		<div class="firstimg">
		<img src="resources/images/e-exam.png">
	</div>
		<div class="login">
			<form action="LoginController" method="post" name="jst" onsubmit="return validateForm()">
				<table>
					<tr>
						<td>UserName</td>
						<td>Password</td>
						<td></td>
					</tr>
					<tr>
						<td><input type="text" name="use_name" size="15px" required="required"></td>
						<td><input type="password" name="pass" size="15px" required="required"></td>
						<td><input type="submit" value="Login"></td>
					</tr>
					<tr>
			
						<td><a href="forgetpass.jsp"><small>Forget Password?</small></a></td>
						
					</tr>
				</table>
			</form>
		</div>
	</div >
	<div class="secondDiv">
		<form action="NewUser" method="post" enctype="multipart/form-data">
			<table class="table1" cellpadding="5">
				<tr>
					<td></td>
					<td>
						<div class="secondimg">
							<img src="resources/images/registrationlogo4.jpg">
						</div>
					</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="First_Name" required="required"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_Name" required="required" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="user_Name" required="required"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><select name="day"><option value="1">Day</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option></select> 
							<select name="month"><option value="1">month</option>
							<option value="1">Jan</option>
							<option value="2">Feb</option>
							<option value="3">Mar</option>
							<option value="4">April</option>
							<option value="5">May</option>
							<option value="6">June</option>
							<option value="7">July</option>
							<option value="8">Aug</option>
							<option value="9">Sep</option>
							<option value="10">Oct</option>
							<option value="11">Nov</option>
							<option value="12">Dec</option>
					</select> <select name="years"><option value="1">years</option>
							<option value="1990">1990</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
							<option value="1998">1998</option>
							<option value="1999">1999</option>
							<option value="2000">2000</option>
							<option value="2001">2001</option>
							<option value="2002">2002</option>
							<option value="2003">2003</option>
							<option value="2004">2004</option>
							<option value="2005">2005</option>
							<option value="2006">2006</option>
							<option value="2007">2007</option>
							<option value="2008">2008</option>
							<option value="2009">2009</option>
							<option value="2010">2010</option>
							<option value="2011">2011</option>
							<option value="2012">2012</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
					</select></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="radio" value="Male"
						checked="checked" /> Male<input type="radio" name="radio"
						value="Female" /> Female</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="mail" required="required" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="number" name="phone" required="required" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" required="required" /></td>
				</tr>
				<tr>
					<td>Courses<br>Aplied For
					</td>
					<td><input type="radio" name="radio1" value="BE"
						checked="checked">BE<input type="radio"
						name="radio1" value="MBBS">MBBS<input type="radio"
						name="radio1" value="B.Sc">BSC<br> <input
						type="radio" name="radio1" value="BBA">BBA</td>
				</tr>
				<tr>
					<td>Choose your<br> Image
					</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div>
							<input type="submit" value="Submit">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>