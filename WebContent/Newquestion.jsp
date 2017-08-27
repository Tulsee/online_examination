<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/CSS">
input{
background-color: #e0e0d1
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin area</title>
</head>
<body bgcolor="skyblue">
<h1>Welcome admin,you can add new questions here!!!</h1>
<h3>Please,be sure you enter correct Questions and answers</h3>
<form action="QuestController" method="post">
<div style="margin-left:20%">
	<b>Faculty</b><select required="required" name="faculty">
	<option >           </option>
	<option>BE</option>
	<option>BSC</option>
	<option>BBA</option>
	<option>MBBS</option>
	
	
	</select><br>
	<input type="text" size="70%" name="Question" placeholder="Please enter question here!!"><br><br>
	<input type="text" size="70%" name="opt1" placeholder="option 1"><br><br>
	<input type="text" size="70%" name="opt2" placeholder="option 2"><br><br>
    <input type="text" size="70%" name="opt3" placeholder="option 3"><br><br>
	<input type="text" size="70%" name="opt4" placeholder="option 4"><br><br>
	<input type="text" size="70%" name="correct" placeholder="Correct answer"><br><br>
	<input type="submit" value="Submit">
	</div>
	</form>
</body>
</html>