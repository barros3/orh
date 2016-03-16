<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<form:form role="form" commandName="falta" servletRelativeAction="/falta/form-update/${falta.id}" method="POST">

		<%@include file="form-inputs.jsp"%>

		<div class="form-group col-md-9" style="text-align: right">
			<button type="submit" class="btn btn-lg btn-success"
				style="float: right">Confirmar Alteração</button>
		</div>

	</form:form>
</template:admin>
