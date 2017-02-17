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
		
		<h3>Product</h3>
		
		<form:form action="${action}" method="POST" commandName="product" role="form">
			
			<div class="form-group" style="display: none;">
				<form:label path="id" for="InputId">Id</form:label>
				<form:input path="id" class="form-control" id="InputId" placeholder="id" />
			</div>
			
			<div class="form-group">
				<form:label path="title" for="InputId">Title</form:label>
				<form:input path="title" class="form-control" id="InputTitle" placeholder="title" />
			</div>
			
			<div class="form-group">
				<form:label path="description" for="InputDescription">Description</form:label>
				<form:textarea path="description" class="form-control" id="InputDescription" placeholder="description" />
			</div>
			
			<div class="form-group">
				<form:label path="count" for="InputCount">Count</form:label>
				<form:input path="count" class="form-control" id="InputCount" placeholder="count" />
			</div>
			
			<div class="form-group">
				<form:label path="price" for="InputPrice">Price</form:label>
				<form:input path="price" class="form-control" id="InputPrice" placeholder="price" />
			</div>
			
			<div class="form-group">
				<form:label path="productCategory.id" for="InputProductCategoryId">Product Category</form:label>
				 
				<form:select path="productCategory.id" id="InputProductCategoryId" class="form-control">
					<form:option value="0" label="--- Select ---" class="form-control" />
					<form:options items="${productCategories}" itemValue="id" itemLabel="title" class="form-control" />
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-default"><i class="fa fa-plus" aria-hidden="true"></i> save</button>
			
		</form:form>
		
	</div>
</div>

</t:template>