<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix = "spring" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>AJAX TEST</title>
		<spring:url var = "urlJQuery" value ="/resources/js/jquery-3.4.1.min.js"/>
		<script src="${urlJQuery}"></script>
	</head>
	<body>
	<h1>AJAX TEST</h1>
		<script type="text/javascript">
			$(document).ready(function(){
				//alert("JQuery is Ready and Integrated");
				$("#getServerTime").click(function() {
					//alert("Getting Time From Server");
					$.ajax({
							url : 'ajaxTestTime',
							success : function(response){
									$("#serverTime").html(response);
								}
						});
				});
			});
		</script>
		
		<button id="getServerTime">Get Server Time</button><br>
		<p id="serverTime">Time: </p>
	</body>
</html>