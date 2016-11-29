<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="providerApp">

<head>
<link rel="stylesheet" href="resources/css/style.css"/>
<script src="resources/js/lib/angular.js"></script>
<script src="resources/js/lib/angular-route.js"></script>
<script src="resources/js/providerApp.js"></script>
<script src="resources/js/providerSearchController.js"></script>

<title>PROVIDER MANAGEMENT</title>
</head>

<body ng-app="providerSearchApp">

	<div ng-view></div>
</body>


</html> 
