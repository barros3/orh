<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<template:admin>
	<jsp:attribute name="extraStyles">
<link rel="stylesheet"
			href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
	<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
	<jsp:body>
		<div class="container">
			<h1>Lista de Funcionários - Falta</h1>
		  	<div class="main col-md-12">
				 <form:form class="navbar-form navbar-left" commandName="falta" role="search" servletRelativeAction="/usuario/list" method="GET">
		    	     <div class="form-group">
				         <input type="text" class="form-control" name="Matrícula" placeholder="Matrícula">
				     </div>
				     <button type="submit" class="btn btn-default">Pesquisar</button>
				 </form:form>
			</div>
		   	<div class="form col-md-12 table-responsive">
				<div class="row">
					<table class="table table-hover table-striped">
		   		  		<thead>
				            <tr>
				            	<td>id</td>
				             	<td>Matrícula</td>
				             	<td>Nome</td>
				             	<td>Quantidade de Faltas</td>
				            </tr>
		           		</thead>
			           <tbody>
			           		<c:forEach items='${paginatedList}' var='object'>         		
			            		<tr>
									<td><a href="<c:url value='/falta'/>/${object.id}">${object.id}</a></td>
					             	<td>${object.matricula}</td>
					             	<td>${object.nome}</td>
					             	<td>${object.quatidadeFalta}</td>
			             		<td>
			             			<a	href="<c:url value='/falta/remove'/>/${object.id}">Remove</a></td>
								</tr>
			           		</c:forEach>
			           </tbody>
		  	 	   </table>
		  	 	</div>
		  	 </div>
		  	 <div class="form col-md-12">
				<div class="row" align="right">
	        		<a href="<c:url value='/falta/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar Novo</a>
	        	</div>
	        </div>
		</div>
	</jsp:body>
</template:admin>
