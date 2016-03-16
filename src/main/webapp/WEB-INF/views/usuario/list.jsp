<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<template:admin>
	<jsp:attribute name="extraStyles">
		<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
	</jsp:attribute>
	<jsp:attribute name="extraScripts">
		<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
	</jsp:attribute>
	<jsp:body>
	<c:if test="${errorAoListar != null}">
		<div class="alert alert-danger">
		    ${errorAoListar}
		</div>
	</c:if>
		<div class="container">
			<h1>Lista de Funcionários</h1>
			<div class="form col-md-12 table-responsive">
			<h1 style="font-style: italic;"> Pesquisar...</h1>
				<form:form class="navbar-form navbar-left" commandName="usuario" role="search" servletRelativeAction="/usuario/listPesquisa" method="GET">
					<div class="form-group">
					    <input type="text" class="form-control" name="nome" placeholder="Nome"/>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" name="matricula" placeholder="Matricula"/>
					</div>
					<div class="form-group">
					    <input type="text" class="form-control" name="cpf" placeholder="CPF"/>
					</div>
					<button type="submit" class="btn btn-default">Buscar</button>
				</form:form>
			</div>
			<div class="form col-md-12">
				<div class="row" align="right">
					<a href="<c:url value='/usuario/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar Novo</a>
				</div>
			</div>
		    <div class="form col-md-12 table-responsive">
				<div class="row">
				 	<table class="table table-hover table-striped">
		          		  <thead>
					          <tr>
					          	<td>id</td>
					           	<td>Nome</td>
					           	<td>Matricula</td>
					          </tr>
				         </thead>
		                  <tbody>
		                  <c:forEach items='${paginatedList}' var='object'>         		
							  <tr>
								<td><a href="<c:url value='/usuario'/>/${object.id}">${object.id}</a></td>
							  	<td>${object.nome}</td>
							  	<td>${object.matricula}</td>
						        <td><a href="<c:url value='/usuario/remove'/>/${object.id}">Remover</a></td>
							</tr>
		                  </c:forEach>
		                  </tbody>
		          	</table>
<%-- 			  	<template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/usuario"/> --%>
	        	</div>
	   		</div>
		</div>
	</jsp:body>
</template:admin>