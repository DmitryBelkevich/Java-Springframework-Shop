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

<div class="panel panel-default">
	<div class="panel-body">
		
		<form action='<spring:url value="/auth" />' method="POST" role="form">
			<div class="form-group">
				<label for="inputUsername">Username</label>
				<input type="text" class="form-control" id="inputUsername" name="username" placeholder="Username" />
			</div>
			
			<div class="form-group">
				<label for="inputPassword">Password</label>
				<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password" />
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-default">log in</button>
			</div>
			
			<div class="checkbox">
				<label>
					<input type="checkbox" name="_spring_security_remember_me" checked="checked" />
					Remember me
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</label>
			</div>
		</form>
		
		<c:if test="${param.error == 'incorrectLoginPassword'}">
			<div class="alert alert-danger">
				<p>Incorrect login or password. Try again</p>
			</div>
		</c:if>
		
		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				<p>You have been logged out</p>
			</div>
		</c:if>
		
	</div>
</div>

</t:template>