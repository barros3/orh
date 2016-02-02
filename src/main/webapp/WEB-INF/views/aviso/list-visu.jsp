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
   	<table class="table table-condensed table-bordered table-striped table-hover">
   		  <thead>
            <tr>
             	<td>Titulo</td>
             	<td>Descricao</td>
            </tr>
           </thead>
           <tbody>
           <c:forEach items='${paginatedList}' var='object'>         		
            <tr>
             	<td>${object.titulo}</td>
             	<td>${object.descricao}</td>
			</tr>
           </c:forEach>
           </tbody>
  	 </table>
   </div>
</jsp:body>
</template:admin>
