<%@ page
	language="java"
	contentType="text/html; charset=Windows-1251"
	pageEncoding="Windows-1251"
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:template>

<h1>admin/users</h1>

<table class="table table-striped table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<th>#</th>
			<th>id</th>
			<th>username</th>
			<th>password</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user" varStatus="count">
			<tr>
				<td>${count.index+1}</td>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>#</td>
				<td>#</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</t:template>