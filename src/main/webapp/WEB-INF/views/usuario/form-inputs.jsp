<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<script type="text/javascript" src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
<%-- <jsp:useBean id="usuarioBean" class="com.unipe.barros.studio.orh.controllers.UsuarioController"/> --%>
<div id="cadastroUsuario">
	<div class="dadosPessoais" >
	<h1>Dados Pessoais</h1>
		<div class="row">
			<div class="form-group col-md-4">
				<label class="control-label" >Login</label>
				<form:input path="login" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label class="control-label" >Senha</label>
				<form:input path="senha" class="form-control" type="text"></form:input>
			</div>
<!-- 			<div class="form-group col-md-4"> -->
<!-- 				<label>Permissao do Funcionario</label> -->
<!-- 				<div class="formRight"> -->
<%-- 				 <form:select path="permissao" data-placeholder="Tipo do Funcionario" class="chzn-select width-100 form-control" tabindex="8"> --%>
<!-- 				    <option value=""></option> -->
<!-- 				    <option>FUNCIONARIO</option> -->
<!-- 				    <option>GERENTE</option> -->
<%-- 				  </form:select> --%>
<!-- 				</div> -->
<!-- 		   	</div> -->
		</div>
	<hr style="border:1px; color:black">
	<div class="row">
		<div class="form-group col-md-12">
			<label class="control-label" >Nome</label>
			<form:input path="nome" class="form-control" type="text"></form:input>
		</div>
	</div>
		<div class="row">
			<div class="form-group col-md-4">
				<label class="control-label" >Celular</label>
				<form:input path="celular" class="form-control" type="text"></form:input>
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">Telefone</label> 
				<input class="form-control" type="text">
			</div>
			<div class="form-group col-md-4">
				<label class="control-label">E-mail</label> 
				<div class="form-group input-group" id="valida">
					<span class="input-group-addon input-group">@</span>
					<form:input path="email" onblur="validacaoEmail(valida.email)" type="text" placeholder="email@exemplo.com" class="form-control input-group"></form:input>
				</div>
			</div>
		</div>
		<%@include file="form-end.jsp" %>
		<div class="dadosProfissionais">
			<h1>Dados Profissionais</h1>
			<div class="row">
				<div class="form-group col-md-6">
					<label class="control-label" >Matricula</label>
					<form:input path="matricula" class="form-control" type="text"></form:input>
				</div>
				<div class="form-group col-md-6">
					<label class="control-label">Data Admissao</label> 
					<div class="form-group input-group date">
						<span class="input-group-addon">
			                    <span class="glyphicon glyphicon-calendar"></span>
			                </span>
						<form:input path="dataAdmissao" id="validaData" placeholder="dd/MM/aaaa hh:mm::ss" type="text" class="form-control"></form:input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label class="control-label" >RG</label>
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
			<div class="main" style="margin:7% 20% 0% 13%">
			
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    // When the document is ready
    $(document).ready(function () {
        
        $('#dataAdmissao').datepicker({
            format: "dd/mm/yyyy hh:mm:ss"
        });  
    
    });
</script>