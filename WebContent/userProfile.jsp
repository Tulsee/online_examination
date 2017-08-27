<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your  profile</title>
<jsp:include page="Navigation.jsp"></jsp:include>
</head>
<body bgcolor="#66e0ff"><div  style="height:20%; width:20%;margin-top:2%;margin-left:40%">
<img src="ProfilePic" height="100%" width="100%" alt="user Picture" >
</div>
<table align="center">

<tr><td style="background-color:green"><b>FirstName:</b></td><td style="background-color:skyblue"><c:out value="${user.firstName}"></c:out>
<tr><td style="background-color:green"><b>LastName:</b></td><td style="background-color:skyblue"><c:out value="${user.lastName}"></c:out>
<tr><td style="background-color:green"><b>UserName:</b></td><td style="background-color:skyblue"><c:out value="${user.userName}"></c:out>
<tr><td style="background-color:green"><b>DOB:</b></td><td style="background-color:skyblue"><c:out value="${user.dob}"></c:out>
<tr><td style="background-color:green"><b>Gender:</b></td><td style="background-color:skyblue"><c:out value="${user.gender}"></c:out>
<tr><td style="background-color:green"><b>Email:</b></td><td style="background-color:skyblue"><c:out value="${user.email}"></c:out>
<tr><td style="background-color:green"><b>Phone:</b></td><td style="background-color:skyblue"><c:out value="${user.phone}"></c:out>
<tr><td style="background-color:green"><b>Address:</b></td><td style="background-color:skyblue"><c:out value="${user.address}"></c:out>
<tr><td style="background-color:green"><b>Course:</b></td><td style="background-color:skyblue"><c:out value="${user.course}"></c:out>


</body>
</html>