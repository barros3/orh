<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="cadastroFerias">
	<h1>Lançar Férias</h1>
	<div class="row">
		<div class="form-group col-md-3">
			<label class="control-label">Descrição</label>
			<form:input path="descricao" class="form-control" type="text"></form:input>
		</div>
		<div class="form-group col-md-3">
			<div class="date">
			<label class="control-label">Data Inicio</label>
				<div class="input-group input-append datePicker">
					<form:input path="dataInicio" type="date" class="form-control" name="date" pattern="dd-MM-yyyy"/>
					<span class="input-group-addon add-on">
					<span class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<form:errors path="dataInicio" cssStyle="color: red;"/>
			</div>
		</div>
		<div class="form-group col-md-3">
			<div class="date">
			<label class="control-label">Data Fim</label>
				<div class="input-group input-append datePicker">
					<form:input path="dataFim" type="date" class="form-control" name="date" pattern="dd-MM-yyyy"/>
					<span class="input-group-addon add-on">
					<span class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<form:errors path="dataFim" cssStyle="color: red;"/>
			</div>
		</div>
		<div class="form-group col-md-3">
			<div class="date">
			<label class="control-label">Data Pagamento</label>
				<div class="input-group input-append datePicker">
					<form:input path="dataPagamento" type="date" class="form-control" name="date" pattern="dd-MM-yyyy"/>
					<span class="input-group-addon add-on">
					<span class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<form:errors path="dataPagamento" cssStyle="color: red;"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-3">
			<label class="control-label">Valor</label>
			<form:input path="valor" class="form-control" rows="6" />
		</div>
		<div class="form-group col-md-3">
			<label class="control-label">Valor da Venda</label>
			<form:input path="valorVenda" class="form-control" rows="6" />
		</div>
		<div class="form-group col-md-3">
			<label class="control-label">Quantidade de Faltas</label>
			<form:input path="quantidadeDias" class="form-control" rows="6" />
		</div>
		<div class="form-group col-md-3">
		<label>Status de Férias</label>
			<div class="form-group">
			 <form:select path="statusFerias" class="form-group form-control" tabindex="1">
			    <form:option value="NONE">DEFINIR STATUS</form:option>
			    <form:option value="SOLICITADA">SOLICITADA</form:option>
			    <form:option value="ANDAMENTO">ANDAMENTO</form:option>
			    <form:option value="VENDIDA">VENDIDA</form:option>
			    <form:option value="AUTORIZADA">AUTORIZADA</form:option>
			  </form:select>
			</div>
	   	</div>
	</div>
	<div class="row">
		<div class="form-group col-md-12">
			<label class="control-label">Observações</label>
			<form:textarea path="observacao" class="form-control" rows="6"></form:textarea>
		</div>
	</div>
	<div class="main" style="margin: 7% 20% 0% 13%"></div>
</div>