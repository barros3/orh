<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<div class="container">
		<form:form role="form" commandName="aviso"
			servletRelativeAction="/aviso/save" method="POST">
			<%@include file="form-inputs.jsp"%>
			<div class="row">
				<div class="form-group col-md-12" style="text-align: right">
					<button type="submit" class="btn btn-lg btn-success"
						style="float: right">
						<span class="glyphicon glyphicon-plus-sign"></span>Salvar
					</button>
				</div>
			</div>

		</form:form>
	</div>
</template:admin>
