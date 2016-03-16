<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<script type="text/javascript"
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
<%-- <jsp:useBean id="usuarioBean" class="com.unipe.barros.studio.orh.controllers.UsuarioController"/> --%>
<div id="cadastroTreinamento">
	<div class="treinamento">
		<h1>Adicionar Treinamento</h1>
		<div class="row">
			<div class="form-group col-md-5">
				<label class="control-label">Tema</label>
				<form:input path="tema" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">Palestrante</label>
				<form:input path="palestrante" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-1">
				<label class="control-label">Vagas</label>
				<form:input path="quantidadeVagas" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-2">
				<label>Status de Treinamento</label>
				<div class="form-group">
				 <form:select path="statusVagasDisponiveis" class="form-group form-control" tabindex="1">
				    <form:option value="NONE"> </form:option>
				    <form:option value="DISPONIVEL">DISPONIVEL</form:option>
				    <form:option value="LOTADO">LOTADOR</form:option>
				  </form:select>
				</div>
		   	</div>
		</div>
		<div class="row">
			<div class="form-group col-md-5">
				<label class="control-label">Local</label>
				<form:input path="local" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-1">
				<label class="control-label">Sala</label>
				<form:input path="local" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-2">
				<label class="control-label">Hora</label>
				<form:input path="hora" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<div class="date">
				<label class="control-label">Dia</label>
					<div class="input-group input-append datePicker">
						<form:input path="dataTreinamento" type="date" class="form-control" name="date" pattern="dd-MM-yyyy"/>
						<span class="input-group-addon add-on">
						<span class="glyphicon glyphicon-calendar"></span></span>
					</div>
	<%-- 				<form:errors path="dataFim" cssStyle="color: red;"/> --%>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="control-label">Descrição</label>
				<form:textarea path="descricao" class="form-control" type="text" rows="4" cols="100"></form:textarea>
			</div>
		</div>
	</div>
</div>