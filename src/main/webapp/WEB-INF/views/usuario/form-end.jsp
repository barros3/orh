<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<div class="row">
	<div class="form-group col-md-8">
		<label class="control-label">Rua</label>
		<form:input path="endereco.rua" class="form-control" type="text"></form:input>
	</div>
	<div class="form-group col-md-4">
		<label class="control-label">Numero</label>
		<form:input path="endereco.numero" class="form-control" type="text"></form:input>
	</div>
</div>
<div class="row">
	<div class="form-group col-md-4">
		<label class="control-label">CEP</label>
		<form:input path="endereco.cep" class="form-control" type="text"></form:input>
	</div>
	<div class="form-group col-md-4">
		<label class="control-label">Bairro</label>
		<form:input path="endereco.bairro" class="form-control" type="text"></form:input>
	</div>
	<div class="form-group col-md-4">
		<label class="control-label">Cidade</label>
		<form:input path="endereco.cidade" class="form-control" type="text"></form:input>
	</div>
</div>
<div class="row">
	<div class="form-group col-md-6">
		<label class="control-label">Estado</label>
		<form:input path="endereco.estado" class="form-control" type="text"></form:input>
	</div>
	<div class="form-group col-md-6">
		<label class="control-label">Pais</label>
		<form:input path="endereco.pais" class="form-control" type="text"></form:input>
	</div>
</div>