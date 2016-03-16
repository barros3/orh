<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="cadastroFalta">
	<h1>Cadastrar Falta</h1>
	<div class="row">
		<div class="form-group col-md-3">
			<label class="control-label">Data Ínício</label>
			<form:input path="dataInicio" class="form-control datepicker" type="date"></form:input>
		</div>
		<div class="form-group col-md-3">
			<label class="control-label">Data Fim</label>
			<form:input path="dataFim" class="form-control datepicker" type="date"></form:input>
		</div>
		<div class="form-group col-md-3">
			<label class="control-label">Quantidades de dias</label>
			<form:input path="quatidadeFalta" onclick="FALSE" class="form-control" rows="6"></form:input>
		</div>
		<div class="form-group col-md-3">
			<label class="control-label">Foi Justificado?</label>
			<form:checkbox path="foiJustificado" class="form-control" rows="6"></form:checkbox>
		</div>
	</div>
	<div class="row">	
		<div class="form-group col-md-6">
			<label class="control-label">Descrição da Falta?</label>
			<form:textarea path="descricaoJustificativa" class="form-control" rows="6"></form:textarea>
		</div>
	</div>
	<div class="main" style="margin: 7% 20% 0% 13%"></div>
</div>