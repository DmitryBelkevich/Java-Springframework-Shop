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
		show();
		setInterval('show()', 1000);
	});
	
	function show() {
		$.ajax({
			url: "<spring:url value='/other/getCurrentTime' />",
			cache: false,
			success: function(data) {
				$("#content").html("<h1>" + data + "</h1>");
			}
		});
	}
</script>

<div id="content"></div>

</t:template>