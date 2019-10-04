<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>

<spring:url var = "urlLogout" value ="/logout"/>
<spring:url var = "urlRegister" value ="/registration"/>

<spring:if test="${sessionScope.loggedInUserId==null}">
	<!-- User Not Yet Logged In : Guest Menu-->
	<div class="wrap-logintest">
		<div class="menubar topBotomBordersIn">
		  <a href = "#" >HOME</a>
		  <a href = "#" >LOGIN</a>
		  <a href = "${urlRegister}" >REGISTER</a>
		  <a href = "#" >ABOUT</a>
		  <a href = "#" >HELP</a>
		</div>
	</div>
</spring:if>

<spring:if test="${sessionScope.loggedInUserId != null && sessionScope.loggedInUserRole == 1}">
	<!-- Admin User Logged In : Admin Menu -->
	<div class="wrap-logintest">
		<div class="menubar topBotomBordersIn">
		  <a href = "#" >HOME</a>
		  <a href = "#" >USER LIST</a>
		  <a href = "${urlLogout}" >LOGOUT</a>
		</div>
	</div>
</spring:if>

<spring:if test="${sessionScope.loggedInUserId != null && sessionScope.loggedInUserRole == 2}">
	<!-- General User Logged In : User Menu -->
	<div class="wrap-logintest">
		<div class="menubar topBotomBordersIn">
		  <a href = "#" >HOME</a>
		  <a href = "#" >ADD CONTACT</a>
		  <a href = "#" >CONTACT LIST</a>
		  <a href = "${urlLogout}" >LOGOUT</a>
		</div>
	</div>
</spring:if>