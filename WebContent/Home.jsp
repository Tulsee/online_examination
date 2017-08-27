<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/slide.css" type="text/css">

<jsp:include page="Navigation.jsp"/>
</head>
<body bgcolor="#66e0ff">

<div class="allcontain">
<h2>Welcome to Online Examination center</h2>
<div class="slideshow-container">

<div class="mySlides fade">
  <img src="resources/images/exam5.png" style="width:100% height:70% ">
</div>

<div class="mySlides fade">
  <img src="resources/images/exam6.png" style="width:100% height:70% " >
</div>

<div class="mySlides fade">
  <img src="resources/images/exam3.png" style="width:100% height:70% ">
</div>
<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span>
</div>
</div>
<div class="sidemenu">
<div class="dropdown">
  <span><u>Rules</u></span>
  <div class="dropdown-content">
  <ul>
    <li>you can select only one option.</li>
 
    </ul>
  </div>
</div>
<br><br><br>
<div class="dropdown">
  <span><u>GuideLine</u></span>
  <div class="dropdown-content">
  <ul>
  <li>Questions would be related to your faculty that you chose during registration. </li>
    <li>You would be given multiple choice questions.</li>
    <li>In order to select your answer,just mark one of the given options.</li>
    <li>Try to complete all answer in the time limit.</li>
    </ul>
  </div>
</div>
<br><br><br>
<div class="dropdown">
  <span><u>Marking</u></span>
  <div class="dropdown-content">
    <ul>
    <li>Each question will have 4 options.</li>
    <li>Each question will carry 1 marks.</li>
    <li>There are total 100 questions.</li>
    <li>There is no system of negative marking.</li>
    </ul>
  </div>
  </div>
  <br><br><br>
  <div class="dropdown">
  <span><u>Result</u></span>
  <div class="dropdown-content">
     <ul>
    <li>Your result will be sent to your email.
    So,Please make sure that you provide 
    your valid email address.</li>
    </ul>
  </div>
</div>


</div>
<br>
<div class="forbtn">
<a href="ExamController"><input type="button" value="Start Examination" id="btn"></a>


</div>
<form action="FeedbackController" method="post">
<div class="botom">
<button>Submit</button>
<div class="fdbck">
<textarea rows="9" cols="40" placeholder="feedback area!!!!!!!!!!!!!!!!!!" name="infeedbck" required="required"></textarea>
</div>
<c:if test="${! empty feedbacks }">
<div class="fdbcklive">
<textarea rows="9" cols="40" readonly="readonly" placeholder="feedback from other users" name="dispfeedback"> <c:forEach items="${feedbacks}" var="fdk">
-><c:out value="${fdk.feedback}"></c:out> </c:forEach></textarea>
</div>
</c:if>
</div>
</form>

<script src="resources/javaScript/slide.js"></script>
</div>
</body>
</html>
