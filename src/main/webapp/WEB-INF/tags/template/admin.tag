<?xml version="1.0" encoding="iso-8859-1"?>
<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="com.unipe.barros.studio.orh.controllers.UsuarioController"/>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
  <title>Studio RH</title>

  <!-- bootstrap -->
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">

  <link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>">
  <link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>">
  
  
  <link rel="stylesheet" href="<c:url value='/assets/css/datepicker.css'/>">
  <script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="<c:url value='//cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css'/>">
  <script type="text/javascript" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
  
  <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="/assets/js/bootstrap-datepicker.min.js"></script>
  
  <jsp:invoke fragment="extraStyles"/>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/home' />">Studio RH</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Colaborador <span class="caret"></span></a>						
						
						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							
							<li class="dropdown-submenu">	
							<a tabindex="0" href="#" class="dropdown-toggle" data-toggle="dropdown">F�rias<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									<li><a href="<c:url value='/ferias/gerenciar' />">Gerenciar</a></li>
									<li><a href="<c:url value='/ferias/novo-ferias' />">Novo</a></li>
									<li><a href="<c:url value='/ferias/list' />">Pesquisar</a></li>
									<li><a href="<c:url value='/ferias/list-visu' />">Visualizar</a></li>
									<li><a href="#">xxx</a></li>
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">xxx</li>
									<li><a href="#">xxx</a></li>
									<li><a href="#">xxx</a></li>
								</ul>
							</li>
							
							<li><a href="<c:url value='/usuario/novo-usuario' />">Novo</a></li>
							<li><a href="<c:url value='/usuario/list' />">Pesquisar</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">xxx</li>
							<li><a href="#">xxx</a></li>
							<li><a href="#">xxx</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Noticias <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/aviso/novo-aviso' />">Novo</a></li>
							<li><a href="<c:url value='/aviso/list' />">Pesquisar</a></li>
							<li><a href="<c:url value='/aviso/list-visu' />">Visualizar</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">xxx</li>
							<li><a href="#">xxx</a></li>
							<li><a href="#">xxx</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">F�rias <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/ferias/novo-ferias' />">Novo</a></li>
							<li><a href="<c:url value='/ferias/list' />">Pesquisar</a></li>
							<li><a href="<c:url value='/ferias/list-visu' />">Visualizar</a></li>
							<li><a href="#">xxx</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">xxx</li>
							<li><a href="#">xxx</a></li>
							<li><a href="#">xxx</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Treinamento <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/treinamento/novo-treinamento' />">Novo</a></li>
							<li><a href="<c:url value='/treinamento/list' />">Pesquisar</a></li>
							<li><a href="<c:url value='/treinamento/list-visu' />">Visualizar</a></li>
							<li><a href="#">xxx</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">xxx</li>
							<li><a href="#">xxx</a></li>
							<li><a href="#">xxx</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Faltas <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value='/falta/gerencia-falta' />">Gerenciar</a></li>
							<li><a href="<c:url value='/falta/novo-falta' />">Novo</a></li>
							<li><a href="<c:url value='/falta/list' />">Pesquisar</a></li>
							<li><a href="<c:url value='/falta/list-visu' />">Visualizar</a></li>
							<li><a href="#">xxx</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">xxx</li>
							<li><a href="#">xxx</a></li>
							<li><a href="#">xxx</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a
						href="<c:url value='/login/logout'></c:url>">Sair <span
							class="sr-only">(current)</span></a></li>
					<li><a href="../navbar-static-top/">Configuracoes</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<jsp:doBody />

	<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
	<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
	<jsp:invoke fragment="extraScripts" />

	</body>
</html>