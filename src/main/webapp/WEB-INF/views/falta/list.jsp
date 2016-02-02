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
  <div class="main col-md-12" style="margin:9% 0% 0% 11% !important">
	 <form:form class="navbar-form navbar-left" commandName="aviso" role="search" servletRelativeAction="/usuario/form-update" method="POST">
	     <div class="form-group">
	         <input type="text" class="form-control" name="titulo" placeholder="Titulo">
	     </div>
	     <button type="submit" class="btn btn-default">Pesquisar</button>
	 </form:form>
   	<table class="table table-condensed table-bordered table-striped table-hover">
   		  <thead>
            <tr>
            	<td>id</td>
             	<td>Titulo</td>
             	<td>Descricao</td>
            </tr>
           </thead>
           <tbody>
           <c:forEach items='${paginatedList}' var='object'>         		
            <tr>
				<td><a href="<c:url value='/aviso'/>/${object.id}">${object.id}</a></td>
             	<td>${object.titulo}</td>
             	<td>${object.descricao}</td>
             <td><a href="<c:url value='/aviso/remove'/>/${object.id}">Remove</a></td>
			</tr>
           </c:forEach>
           </tbody>
  	 </table>
        <a href="<c:url value='/aviso/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar Novo</a>
   </div>
</jsp:body>
</template:admin>
