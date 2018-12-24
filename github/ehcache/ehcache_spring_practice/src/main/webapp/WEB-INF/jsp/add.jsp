<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.xhj.practice.ehcache.domain.Customer"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="./resources/css/design.css" />
<script src="./resources/js/script.js"></script>

<title>添加顾客</title>
</head>
<body>
	<section>
		<article>
			<header>
				<h2>添加一个顾客</h2>
			</header>
			<form:form modelAttribute="premierFormulaire" method="POST"
				action="${pageContext.request.contextPath}/save">
				<table>
					<tr>
						<td>Id:</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" /></td>
					</tr>

				</table>
			</form:form>
		</article>
	</section>
</body>