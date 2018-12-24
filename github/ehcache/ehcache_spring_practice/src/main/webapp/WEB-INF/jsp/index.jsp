<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.xhj.practice.ehcache.domain.Customer"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="./resources/css/design.css" />
<script src="./resources/js/script.js"></script>
<title>ehcache demo</title>
</head>
<body>
	<section>
		<header>
			<h2>演示使用ehcache缓存</h2>
		</header>
		<article>
			<p>项目主页，可以看到ehcache中的所有顾客，并可以在ehcache中添加旅客和删除所有顾客</p>
		</article>
	</section>
	<section id="main">
		<header>
			<h2>在ehcache中管理旅客</h2>
		</header>
		<article>
			<table>
				<tr>
					<td><a href="${pageContext.request.contextPath}/add">新增旅客</a></td>
					<td><a href="${pageContext.request.contextPath}/clearCache">删除所有旅客</a></td>
				</tr>
			</table>

			<table>
				<tr>
					<caption style="caption-side: bottom">在ehcache中的顾客</caption>
				<thead>
					<th>Id</th>
					<th>Name</th>
					<th>Address</th>
				</thead>
				</tr>
				<%
					List<Customer> lst = (List<Customer>) request
							.getAttribute("customers");
					if (null != lst) {
						for (Customer c : lst) {
							out.println("<tr>");

							out.println("<td>");
							out.println(c.getId());
							out.println("</td>");
							out.println("<td>");
							out.println(c.getName());
							out.println("</td>");
							out.println("<td>");
							out.println(c.getAddress());
							out.println("</td>");

							out.println("</tr>");
						}
					}
				%>
			</table>
		</article>
	</section>
</body>
</html>
