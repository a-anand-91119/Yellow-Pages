<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri ="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Yellow Pages - Contact List</title>
	
	<spring:url var = "urlImage" value ="/resources/images/img-01.png"/>
	<spring:url var = "urlContactSearch" value ="/user/searchContact"/>
	<spring:url var = "urlBulkDeleteContact" value ="/user/bulkDeleteContact"/>
	
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
			<div class="wrap-login100" style = "width: 60%; ">
			<!-- MENU BAR -->
			<jsp:include page="include/menu.jsp"/>
			<!-- MENU BAR -->
			<spring:if test="${param.action eq 'save'}">
						<script>
						Swal.fire({
							  type: 'success',
							  title: 'Contact Saved Successfully!',
							  showConfirmButton: true,
							  footer: 'You Can See All Your Contacts In Contact List'
							})
						</script>
			</spring:if>
			
			<spring:if test="${param.action eq 'delete'}">
						<script>
						Swal.fire({
							  type: 'success',
							  title: 'Contact Deleted Successfully!',
							  showConfirmButton: true,
							  footer: 'You Can See The Updated List The In Contact List'
							})
						</script>
			</spring:if>
			
			
			<spring:if test="${empty contactList}">
						<script>
						Swal.fire({
							  type: 'error',
							  title: 'Oops... No Contacts Found',
							  text: 'Please Create A Contact Before You Can See Them',
							  footer: '<a href>Why do I have this issue?</a>'
							});
						</script>
			</spring:if>
			<!-- BODY -->
			
				<span class="login100-form-title" style = "padding-bottom: 30px;">
						All Contacts
				</span>
				
				<div class="login100-pic js-tilt" data-tilt style = "width: 35%; float: left;">     
					 <img src="${urlImage}" alt="IMG">
				</div> 
				
				
				<div style = "width: 65%;" >
				
				<form:form class="validate-form" action="${urlContactSearch}" style=" margin-bottom: 10px;" modelAttribute="searchCommand">
					<div style= "margin: auto;">
						<div style = "width: 63%; float: left; margin: auto;">
							<div class="wrap-input100 validate-input" data-validate = "Enter A Search Parameter To Search" style = "width: 70%; float: left;">
									<form:input class="input100" type="text" name="text" placeholder="Enter Search Text" path="searchText"/>
									<span class="focus-input100"></span>
									<span class="symbol-input100">
										<i class="fa fa-search" aria-hidden="true"></i>
									</span>
							</div>
							<div class="container-login100-form-btn" style = "width: 30%; float: right;">
								<button class="login100-form-btn" style="margin-left: 5px;">
									Search
								</button>
							</div>
						</div>
						<div class="container-login100-form-btn" style = "width: 35%; float: right;">
								<button class="login100-form-btn2" form="deleteForm">
									Delete Selected Contacts
								</button>
						</div>
					</div>
				</form:form>
				
				<div class="scrollabletable">
					<form id="deleteForm" action="${urlBulkDeleteContact}">
						<spring:forEach items="${contactList}" var = "contact" varStatus = "contactData">
							<%@ include file="cards/card.jsp"%>
						</spring:forEach>
					</form>
				</div>
				</div>
				
				
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