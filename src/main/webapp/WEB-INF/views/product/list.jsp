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

<h1>Product list</h1>

<table class="table table-striped table-bordered table-hover table-condensed">
	<thead>
		<tr>
			<td>#</td>
			<th>Id</th>
			<th>Title</th>
			<th>Description</th>
			<th>Count</th>
			<th>Price</th>
			<th>Category Title</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products}" var="product" varStatus="count">
			<tr>
				<td>${count.index+1}</td>
				<td>${product.id}</td>
				<td>${product.title}</td>
				<td>${product.description}</td>
				<td>${product.count}</td>
				<td>${product.price}</td>
				<td>${product.productCategory.title}</td>
				<td>
					<a href='<spring:url value="/product/edit/${product.id}" />'><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
				</td>
				<td>
					<a href='<spring:url value="/product/delete/${product.id}" />'><i class="fa fa-trash-o" aria-hidden="true"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p>
	<a href='<spring:url value="new" />'>
		<button type="submit" class="btn btn-default"><i class="fa fa-plus" aria-hidden="true"></i> add</button>
	</a>
</p>

<c:if test="${param.error == 'incorrectParams'}">
	<div class="alert alert-danger">
		<p>Incorrect parameters. Try again</p>
	</div>
</c:if>

</t:template>