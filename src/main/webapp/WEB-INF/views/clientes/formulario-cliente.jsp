<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-4">
		<h1>Cadastro de Cliente</h1>
		<a href="/ProjetoWeb01/" class="btn btn-light">Página inicial</a>
		<hr>

		<div class="row">
			<div class="col-md-4">
				<form id="form-cadastro" action="cadastrar-cliente" method="post">
					<div class="mb-4">
						<label>Nome do Cliente:</label>
						<input path="cliente.nome"
							class="form-control" autocomplete="off"
							placeholder="Ex: João da Silva" />
					</div>

					<div class="mb-4">
						<label>Email:</label>
						<input path="cliente.email"
							class="form-control"
							autocomplete="off" placeholder="Ex: joaosilva@gmail.com" />
					</div>
					<div>
						<button type="submit" class="btn btn-success">Cadastrar Cliente</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<script src="resources/js/jquery-3.5.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>
</body>
</html>
