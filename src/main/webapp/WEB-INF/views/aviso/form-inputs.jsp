<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="main" style="margin:13% 20% 0% 13%">
<h1>Novo Aviso</h1>
	<div class="row">
		<div class="form-group col-md-4">
			<label class="control-label" >Titulo</label>
			<form:input path="titulo" class="form-control" type="text"></form:input>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-12" >
			<label class="control-label">Descricao</label>
			<form:textarea path="descricao" class="form-control" rows="6"></form:textarea>
		</div>
	</div>
	<div class="main" style="margin:7% 20% 0% 13%">
	
	</div>
</div>