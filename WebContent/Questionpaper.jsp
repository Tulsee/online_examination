<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.ans {
	display:inline-block;
	margin-right:6%;
	background-color:fuchsia;
	
}
.Ques p{
	
	padding:.25%;
	display:inline-block;

}
.container{
	border-bottom:1px solid;
	padding-bottom:1%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question paper</title>
</head>
<body bgcolor="skyblue">

<h2>Select the correct answer for the following questions!</h2>
<form action="ResultController" method="post">
 <c:forEach items="${questions}" var="quest">
 <div class="container">

<div class="Ques"><p><c:out value="${quest.question}"></c:out><p></div><br>
<div class="ans"><input type="radio" name="${quest.question}" value="${quest.option1}" required="required"><c:out value="${quest.option1}" ></c:out></div>
<div class="ans"><input type="radio"  name="${quest.question}"  value="${quest.option2}" required="required"><c:out value="${quest.option2}"></c:out></div>
<div class="ans"><input type="radio" name="${quest.question}" value="${quest.option3}" required="required"><c:out value="${quest.option3}"></c:out></div>
<div class="ans"><input type="radio" name="${quest.question}" value="${quest.option4}" required="required"><c:out value="${quest.option4}"></c:out></div><br>

</div>
</c:forEach>
<input type="submit">
</form>
</body>
</html>