<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <script type="text/javascript" src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script> -->
<%-- <jsp:useBean id="usuarioBean" class="com.unipe.barros.studio.orh.controllers.UsuarioController"/> --%>
<div id="cadastroUsuario">
	<div class="dadosPessoais">
		<h1>Dados Pessoais</h1>
	<c:if test="${errorAoListar != null}">
		<div class="alert alert-danger">
		    ${errorAoListar}
		</div>
	</c:if>
		<div class="row">
			<div class="form-group col-md-4">
				<label class="control-label">Login</label>
				<form:input path="login" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">Senha</label>
				<form:input path="senha" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label>Permissao do Funcionario</label>
				<div class="form-group">
				 <form:select path="permissao" class="form-group form-control" tabindex="1">
				    <form:option value="NONE">SELECIONE CARGO</form:option>
				    <form:option value="FUNCIONARIO">FUNCIONARIO</form:option>
				    <form:option value="GERENTE">GERENTE</form:option>
				  </form:select>
				</div>
		   	</div>
		</div>
		<hr style="border: 1px; color: black">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="control-label">Nome</label>
				<form:input path="nome" class="form-control" type="text"></form:input>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-4">
				<label class="control-label">Celular</label>
				<form:errors parth="celular" />
				<br />
				<form:input path="celular" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">Telefone</label>
				<form:input path="telefone" class="form-control" type="text" />
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">E-mail</label>
				<div class="form-group input-group">
					<span class="input-group-addon input-group">@</span>
					<form:input path="email" type="text" placeholder="email@exemplo.com" class="form-control input-group"></form:input>
					<form:errors path="email" cssClass="error"></form:errors>
				</div>
			</div>
		</div>
		<%@include file="form-end.jsp"%>
		<div class="dadosProfissionais">
			<h1>Dados Profissionais</h1>
			<div class="row">
				<div class="form-group col-md-6">
					<label class="control-label">Matricula</label>
					<form:input path="matricula" class="form-control" type="text"></form:input>
				</div>
				<div class="form-group col-md-6">
					<div class="date">
					<label class="control-label">Data Admissao</label>
						<div class="input-group input-append datePicker">
							<form:input path="dataAdmissao" type="date" class="form-control" name="date" pattern="dd-MM-yyyy"/>
							<span class="input-group-addon add-on">
							<span class="glyphicon glyphicon-calendar"></span></span>
						</div>
						<form:errors path="dataAdmissao" cssStyle="color: red;"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="control-label">RG</label>
					<form:input path="rg" class="form-control" type="text"></form:input>
				</div>
				<div class="form-group col-md-4">
					<label class="control-label">CTPS</label>
					<form:input path="cpts" class="form-control" type="text"></form:input>
				</div>
				<div class="form-group col-md-4">
					<label class="control-label">CPF</label>
					<form:input path="cpf" placeholder="000.000.000 - 00" class="form-control" type="text"></form:input>
				</div>
			</div>
			<div class="main" style="margin: 7% 20% 0% 13%"></div>
		</div>
	</div>
</div>