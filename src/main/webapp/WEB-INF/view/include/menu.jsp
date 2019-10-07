<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>

<spring:url var = "urlLogout" value ="/logout"/>
<spring:url var = "urlRegister" value ="/registration"/>
<spring:url var = "urlHome" value = "/"/>

<spring:url var = "urlUserAddContact" value ="/user/contactForm"/>
<spring:url var = "urlUserHome" value ="/user/dashboard"/>
<spring:url var = "urlUserContactList" value ="/user/contactList"/>

<spring:url var = "urlAdminHome" value ="/admin/dashboard"/>
<spring:url var = "urlAdminUsersList" value ="/admin/usersList"/>

<spring:if test="${sessionScope.loggedInUserId==null}">
	<!-- User Not Yet Logged In : Guest Menu-->
	<div class="wrap-logintest">
		<div class="menubar topBotomBordersIn">
		  <a href = "${urlHome}" >HOME</a>
		  <a href = "${urlHome}" >LOGIN</a>
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
		  <a href = "${urlAdminHome}" >HOME</a>
		  <a href = "${urlAdminUsersList}" >USER LIST</a>
		  <a href = "${urlLogout}" >LOGOUT</a>
		</div>
	</div>
</spring:if>

<spring:if test="${sessionScope.loggedInUserId != null && sessionScope.loggedInUserRole == 2}">
	<!-- General User Logged In : User Menu -->
	<div class="wrap-logintest" style = "margin: 0px 0px 75px 0px; height: 90px;">
		<div class="menubar topBotomBordersIn">
		  <a href = "${urlUserHome}" >HOME</a>
		  <a href = "${urlUserAddContact}" >ADD CONTACT</a>
		  <a href = "${urlUserContactList}" >CONTACT LIST</a>
		  <a href = "${urlLogout}" >LOGOUT</a>
		</div>
	</div>
</spring:if>