<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url value="/ctrl" var="linkController" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de cadastro</title>

<link rel="stylesheet" href="formAlteraCandidato.css">

<style>
body{
background-color: #FFFFFF;
box-sizing: border-box;
color: #000000;
}

form {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	box-shadow: 0 0 10px #ccc;
}

h1 {
	text-align: center;
}

input[type="text"], select {
	display: block;
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	font-size: 16px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 10px;
}

select {
	height: 40px;
}

input[type="submit"] {
	display: block;
	margin: 20px auto 0;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

form a.botao-voltar {
	padding: 10px 20px;
	background-color: #ccc;
	color: #000;
	text-decoration: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>

	<form action="${linkController}" method="post">

		<c:forEach items="${EntidadeDominio}" var="candidato">
		
		<h1>Editar cadastro</h1>
		
		
		
		<p><b>Cadastro realizado em:</b> ${candidato.dtCadastro}</p>
		
		<p>*Não é possível alterar cadastros com menos de um ano</p>
		
		
		<fieldset>
			<legend>Endereço</legend>
			<div>
			
				<input type="hidden" name="id" value="${candidato.id}" />
				<input type="hidden" name="dtCad" value="${candidato.dtCadastro}" /> <br>
				<label for="estado">Estado:</label> <select id="estado"
					name="estado" required>
					<option value="${candidato.endereco.cidade.estado.descricao}">${candidato.endereco.cidade.estado.descricao}</option>
					<option value="AC">AC</option>
					<option value="AL">AL</option>
					<option value="AP">AP</option>
					<option value="AM">AM</option>
					<option value="BA">BA</option>
					<option value="CE">CE</option>
					<option value="DF">DF</option>
					<option value="ES">ES</option>
					<option value="GO">GO</option>
					<option value="MA">MA</option>
					<option value="MT">MT</option>
					<option value="MS">MS</option>
					<option value="MG">MG</option>
					<option value="PA">PA</option>
					<option value="PB">PB</option>
					<option value="PR">PR</option>
					<option value="PE">PE</option>
					<option value="PI">PI</option>
					<option value="RJ">RJ</option>
					<option value="RN">RN</option>
					<option value="RS">RS</option>
					<option value="RO">RO</option>
					<option value="RR">RR</option>
					<option value="SC">SC</option>
					<option value="SP">SP</option>
					<option value="SE">SE</option>
					<option value="TO">TO</option>
				</select>
			</div>

			<div>
				<label for="cidade">Cidade:</label> <input type="text" id="cidade"
					name="cidade" value="${candidato.endereco.cidade.descricao}"
					required>
			</div>

			<div>
				<label for="cep">CEP:</label> <input type="text" id="cep" name="cep"
					value="${candidato.endereco.cep}" pattern="\d{5}-\d{3}"
					maxlength="9" required>
			</div>

			<div>
				<label for="logradouro">Logradouro:</label> <input type="text"
					id="logradouro" name="logradouro"
					value="${candidato.endereco.logradouro}" required>
			</div>

			<div>
				<label for="numero">Número:</label> <input type="text" id="numero"
					name="numero" value="${candidato.endereco.numero}" required>
			</div>

			<div>
				<label for="complemento">Complemento:</label> <input type="text"
					id="complemento" name="complemento"
					value="${candidato.endereco.complemento}">
			</div>

		</fieldset>

		<br>

		<fieldset>
			<legend>Filiação</legend>
			<div>

				<c:forEach items="${candidato.listaFiliacao}" var="filiacao">
		
				${filiacao.descricao}:<br>
					<input type="text" id = "${filiacao.descricao}" name="${filiacao.descricao}"
						value="${filiacao.nome}" />

				</c:forEach>

			</div>
		</fieldset>

		<br>

		<fieldset>
			<legend>Dados do Candidato</legend>

			<div>

				<label for="nome">Nome do candidato:</label> <input type="text"
					id="nome" name="nome" value="${candidato.nome}" required>
			</div>

		</fieldset>

		<br>
		<c:set var="contadorForEach" value="1" scope="page" />
		<c:set var="contadorElementosLista" value="0" scope="page" />

			<c:forEach items="${candidato.listadeTelefones}" var="telefone">

				<fieldset>
			<legend>Telefone ${contadorForEach}</legend>
			
				<input type="hidden" name="tel_id${contadorForEach}"
					value="${telefone.id}" />				

				<div>
					<input
						type="text" id="telefone${contadorForEach}"
						name="telefone${contadorForEach}" value="${telefone.numero}" pattern="\d{2} \d{4,5}-\d{4}"  maxlength="15">
				</div>

				<select id="tipo${contadorForEach}" name="tipo${contadorForEach}"
					required>
					<option value="${telefone.tipo}">${telefone.tipo}</option>
					<option value="Residencial">Residencial</option>
					<option value="Celular">Celular</option>
					<option value="Contato">Contato</option>
					
					<c:set var="contadorForEach" value="${contadorForEach + 1}"
						scope="page" />
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + 1}" scope="page" />
				</select>
				</fieldset>
				<br>
			</c:forEach>
			
			<fieldset>
			
			<legend>Curso</legend>
			
			<c:set var="contadorForEach" value="1" scope="page" />
			<c:set var="contadorElementosLista" value="0" scope="page" />
			
			<c:forEach items="${candidato.listadeMatriculas}" var="matricula">
			
			<div>
			<input type="hidden" name="id_matricula${contadorForEach}" value="${matricula.id}" /> 
			<select
				id="id_curso${contadorForEach}" name="id_curso${contadorForEach}">
				<option value="${matricula.curso.id}">${matricula.curso.nome}</option>
				<option value="1">Analise e Desenvolvimento de Sistemas</option>
				<option value="2">Agronegocio</option>
				<option value="3">Logistica</option>
				<option value="4">Recursos Humanos</option>
					<c:set var="contadorForEach" value="${contadorForEach + 1}"
						scope="page" />
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + 1}" scope="page" />	
				
			</select>
			</div>
			</c:forEach>

		</fieldset>


		<br> <input type="hidden" name="acao" value="AlterarCandidato">
		<input type="submit" /> <a
			href="/crud/ctrl?acao=CandidatoList" class="botao-voltar">Voltar</a>
	</c:forEach>
	
	</form>

</body>
</html>