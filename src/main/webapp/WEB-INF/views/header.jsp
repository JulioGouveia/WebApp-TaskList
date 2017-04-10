<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Task List - Web Application</title>
	<c:url value="/resources/css/" var="context" />
	<link rel="stylesheet" href="${context }style.css">
	<link rel="stylesheet" href="${context }bootstrap.css">
	<link rel="stylesheet" href="${context }bootstrap-theme.css">
</head>
<body>

	<nav class="navbar navbar-default navbar-static-top">
	  <div class="container">
	  	<ul  class="nav navbar-nav">
	  		<li><a href="${s:mvcUrl('HAC#home').build() }" class="taskList navbar-text">Task List</a></li>
	   		<li><a href="${s:mvcUrl('LC#create').build() }" id="create">Create Account</a></li>
	   		<li><a href="${s:mvcUrl('LC#login').build() }" id="signIn">Sign In</a></li>
	   	</ul>
	  </div>
	</nav>
