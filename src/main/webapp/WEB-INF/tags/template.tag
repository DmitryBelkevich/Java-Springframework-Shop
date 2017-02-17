<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" var="fontAwesomeCss" />
<spring:url value="/resources/css/sticky-footer-navbar.css" var="stickyFooterNavbarCss" />
<spring:url value="/resources/css/styles_scrollup.css" var="scrollUpCss" />
<spring:url value="/resources/css/main.css" var="mainCss" />

<spring:url value="https://code.jquery.com/jquery-3.1.1.min.js" var="jQuery" />
<spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/js/jquery.scrollUp.min.js" var="scrollUpJs" />
<spring:url value="/resources/js/main.js" var="mainJs" />

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="Windows-1251">
		<title>Java Shop</title>
		
		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${fontAwesomeCss}" rel="stylesheet" />
		<link href="${stickyFooterNavbarCss}" rel="stylesheet" />
		<link href="${scrollUpCss}" rel="stylesheet" />
		<link href="${mainCss}" rel="stylesheet" />
		
		<script type="text/javascript" src="${jQuery}"
			integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  			crossorigin="anonymous"
  		></script>
		<script type="text/javascript" src="${bootstrapJs}"></script>
		<script type="text/javascript" src="${scrollUpJs}"></script>
		<script type="text/javascript" src="${mainJs}"></script>
		
		<link href="/resources/images/ico/favicon.ico" rel="shortcut icon">
	</head>
	<body>
		
		<nav class="navbar navbar-default" role="navigation">
			<div class="container">
				
				<div class="navbar-header">
	      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/" />'>Java-Shop</a>
				</div>
				
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
							<a href="<spring:url value="/" />">
								<i class="fa fa-home" aria-hidden="true"></i>
								 <spring:message code="label.main" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/product/list" />">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i>
								 <spring:message code="label.products" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/product_category/list" />">
								<i class="fa fa-list" aria-hidden="true"></i>
								 <spring:message code="label.categories" />
							</a>
						</li>
						<li>
							<a href="<spring:url value="/user/login" />">
								<i class="fa fa-sign-in" aria-hidden="true"></i>
								 <spring:message code="label.login" />
							</a>
						</li>
					</ul>
					
					<form action='<spring:url value="/logout" />' method="POST" class="navbar-form navbar-left" role="form">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button type="submit" class="btn btn-info">
							<i class="fa fa-sign-out" aria-hidden="true"></i>
							 <spring:message code="label.logout" />
						</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-globe" aria-hidden="true"></i>
								 <spring:message code="label.language" /> <b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href='<spring:url value="?lang=en" />'>en</a></li>
								<li><a href='<spring:url value="?lang=ru" />'>ru</a></li>
							</ul>
						</li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-user-circle-o" aria-hidden="true"></i>
								 <spring:message code="label.other" /> <b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href='<spring:url value="/other/time" />'>time</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
				
			</div><!-- /.container-fluid -->
		</nav>
		
		<div class="container">
			<div class="row">
				
				<div style="display: none;">
					${username}
					<a href='<spring:url value="/admin"></spring:url>'>
						<i class="fa fa-lock" aria-hidden="true"></i> admin
					</a>
					<a href='<spring:url value="/cart"></spring:url>'>
						<i class="fa fa-shopping-cart" aria-hidden="true"></i> cart
					</a>
					<a href='<spring:url value="/cabinet"></spring:url>'>
						<i class="fa fa-user" aria-hidden="true"></i> cabinet
					</a>
					log in/log out/registration
				</div>
				
				<jsp:doBody />
			</div>
		</div>
		
		<footer class="footer">
			<div class="container">
				<div class="row">
					<p class="text-muted">Copyright © 2017 Website created by: Dmitry Belkevich, e-mail: harleydav@mail.ru</p>
				</div>
			</div>
		</footer>
		
	</body>
</html>