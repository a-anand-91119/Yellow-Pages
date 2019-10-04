<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri ="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Yellow Pages - User Registration</title>
	
	<spring:url var = "urlImage" value ="/resources/images/img-01.png"/>
	<spring:url var = "urlRegister" value ="/register"/>
	
	<spring:url var = "urlFavicon" value ="/resources/images/icons/favicon.ico"/>
	<spring:url var = "urlBootstrap" value ="/resources/vendor/bootstrap/css/bootstrap.min.css"/>
	<spring:url var = "urlFontAwesome" value ="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<spring:url var = "urlAnimate" value ="/resources/vendor/animate/animate.css"/>
	<spring:url var = "urlHamburgers" value ="/resources/vendor/css-hamburgers/hamburgers.min.css"/>
	<spring:url var = "urlSelect2" value ="/resources/vendor/select2/select2.min.css"/>
	<spring:url var = "urlUtil" value ="/resources/css/util.css"/>
	<spring:url var = "urlMain" value ="/resources/css/main.css"/>
	
	<spring:url var = "urlMainJs" value ="/resources/js/main.js"/>
	<spring:url var = "urlTiltJquery" value ="/resources/vendor/tilt/tilt.jquery.min.js"/>
	<spring:url var = "urlSelect2Js" value ="/resources/vendor/select2/select2.min.js"/>
	<spring:url var = "urlBootstrapJs" value ="/resources/vendor/bootstrap/js/bootstrap.min.js"/>
	<spring:url var = "urlPopperJs" value ="/resources/vendor/bootstrap/js/popper.js"/>
	<spring:url var = "urlJqueryMin" value ="/resources/vendor/jquery/jquery-3.2.1.min.js"/>
	<spring:url var = "urlSmartAlert" value ="/resources/vendor/sweetalert2/sweetalert2.all.min.js"/>
	<spring:url var = "urlSmartAlertPolyfill" value ="https://cdn.jsdelivr.net/npm/promise-polyfill"/>
	
	<link rel="icon" type="image/png" href="${urlFavicon}"/>
	<link rel="stylesheet" type="text/css" href="${urlBootstrap}">
	<link rel="stylesheet" type="text/css" href="${urlFontAwesome}">
	<link rel="stylesheet" type="text/css" href="${urlAnimate}">
	<link rel="stylesheet" type="text/css" href="${urlHamburgers}">
	<link rel="stylesheet" type="text/css" href="${urlSelect2}">
	<link rel="stylesheet" type="text/css" href="${urlUtil}">
	<link rel="stylesheet" type="text/css" href="${urlMain}">
	
	<script src="${urlSmartAlert}"></script>
	<script src="${urlSmartAlertPolyfill}"></script>
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			<!-- MENU BAR -->
			<jsp:include page="include/menu.jsp"/>
			<!-- MENU BAR -->
			
			<!-- BODY -->
				<div class="login100-pic js-tilt" data-tilt>     
					 <img src="${urlImage}" alt="IMG">
				</div>

				<form:form class="login100-form validate-form" action="${urlRegister}" modelAttribute="registrationCommand">
					<span class="login100-form-title">
						User Registration
					</span>
					<spring:if test="${errorMessage != null}">
						<script>
							Swal.fire({
							  type: 'error',
							  title: 'Oops... Login Failed',
							  text: '${errorMessage}',
							  footer: '<a href>Why do I have this issue?</a>'
							});
						</script>
					</spring:if>
					
					<div class="wrap-input100 validate-input" data-validate = "Login Username is required">
						<form:input class="input100" type="text" name="text" placeholder="Username" path="user.userLoginName"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<form:password class="input100" name="pass" placeholder="Password" path="user.userPassword"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Full Name is required">
						<form:input class="input100" type="text" name="text" placeholder="Name" path="user.userName"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Phone Number is required">
						<form:input class="input100" type="text" name="text" placeholder="Phone Number" path="user.userPhoneNumber"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter Valid Email Address (asd@asd.com)">
						<form:input class="input100" type="text" name="text" placeholder="Email Address" path="user.userEmailAddress"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Address is required">
						<form:textarea class="input100" type="text" name="text" placeholder="Address" path="user.userAddress"/>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-address-card " aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Submit
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
						<a class="txt2" href="#">
							Username / Password?
						</a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="#">
							Create New Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form:form>
				
			<!-- BODY -->
				
			<!-- FOOTER -->
			<jsp:include page="include/footer.jsp"/>
			<!-- FOOTER -->
			</div>
		</div>
	</div>
	
	<script src="${urlJqueryMin}"></script>
	<script src="${urlPopperJs}"></script>
	<script src="${urlBootstrapJs}"></script>
	<script src="${urlSelect2Js}"></script>
	<script src="${urlTiltJquery}"></script>
	
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
	<script src="${urlMainJs}"></script>
</body>
</html>