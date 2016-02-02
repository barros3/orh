<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:login>
	<div class="main" style="margin:15% 36% 0% 36% !important">
	<img alt="" src="">
		<form:form class="form-signin" modelAttribute="usuario" method="POST" servletRelativeAction="/login/autenticar">
			<h1 style="text-align: center"><b>Studio RH</b></h1>
			<th>
 		    <h5 class="form-signin-heading">Login</h5>
		    <form:input path="login" cssClass="form-control" placeholder="Login"></form:input>
		    <h5 class="form-signin-heading">Senha</h5>
		    <form:password path="senha" cssClass="form-control" placeholder="Senha"></form:password>
		    <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form:form>
	</div>
</template:login>