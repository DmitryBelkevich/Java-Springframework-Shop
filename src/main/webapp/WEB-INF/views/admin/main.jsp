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

<h1>Admin Page</h1>

<ul>
	<li><a href='<spring:url value="/admin/roles" />'>Roles</a></li>
	<li><a href='<spring:url value="/admin/users" />'>Users</a></li>
	<li><a href='<spring:url value="/product/list" />'>Products</a></li>
	<li><a href='<spring:url value="/product_category/list" />'>Product Categories</a></li>
</ul>

</t:template>