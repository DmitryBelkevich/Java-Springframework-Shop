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

<script>
	$(document).ready(function() {
		$("button[type=button]").click(function() {
			var product = {
				id : $("#InputId").val(),
				title : $("#InputTitle").val()
			};
			
			$.ajax({
				<c:if test="${action == 'add'}">
					url : "<spring:url value='/product_category/addAjax' />",
				</c:if>
				<c:if test="${action == 'update'}">
					url : "<spring:url value='/product_category/edit/updateAjax' />",
				</c:if>
				contentType : "application/json; charset=UTF-8",
				data : JSON.stringify(product),
				type : "POST",
				success : function(data) {
					window.location = "<spring:url value='/product_category/list' />"
				},
				error : function(xhr, status, errorThrown) {
					alert("adding failed with status: " + status + ". " + errorThrown);
				}
			});
		});
	});
</script>

<div class="panel panel-default">
	<div class="panel-body">
		
		<h3>Product Category</h3>
		
		<form:form action="${action}" method="POST" commandName="productCategory" role="form">
			
			<div class="form-group" style="display: none;">
				<form:label path="id" for="InputId">Id</form:label>
				<form:input path="id" class="form-control" id="InputId" placeholder="id" />
			</div>
			
			<div class="form-group">
				<form:label path="title" for="InputId">Title</form:label>
				<form:input path="title" class="form-control" id="InputTitle" placeholder="title" />
			</div>
			
			<button type="submit" class="btn btn-default"><i class="fa fa-plus" aria-hidden="true"></i> save</button>
			<button type="button" class="btn btn-default"><i class="fa fa-plus" aria-hidden="true"></i> save (Ajax)</button>
			
		</form:form>
		
	</div>
</div>

</t:template>