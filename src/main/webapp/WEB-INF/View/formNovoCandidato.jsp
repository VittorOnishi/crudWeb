
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/ctrl" var="linkController" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de candidatos</title>
</head>
<style>
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

.botao-pesquisar {
	background-color: #4CAF50;
	color: white;
	padding: 8px 16px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 10px;
}
</style>
</head>
<body>
<body>

	<form action="${linkController}" method="post">


		<h1>Cadastro de candidato</h1>

		<fieldset>
			<legend>Endereço</legend>
			<div>
				<label for="estado">Estado:</label> <select id="estado"
					name="estado" required>
					<option value="" disabled selected>Selecione um estado</option>
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
					name="cidade" placeholder="Digite a cidade" required>
			</div>

			<div>
				<label for="cep">CEP:</label> <input type="text" id="cep" name="cep" pattern="\d{5}-\d{3}"
					maxlength="9" placeholder="Digite o CEP (00000-000)" required>
			</div>

			<div>
				<label for="logradouro">Logradouro:</label> <input type="text"
					id="logradouro" name="logradouro" placeholder="Digite o logradouro" required>
			</div>

			<div>
				<label for="numero">Número:</label> <input type="text" id="numero"
					name="numero" placeholder="Digite o número" required>
			</div>

			<div>
				<label for="complemento">Complemento:</label> <input type="text"
					id="complemento" name="complemento"
					placeholder="Digite o complemento">
			</div>
		</fieldset>

		<br>

		<fieldset>
			<legend>Filiação</legend>
			<div>
				<label for="nomeDoPai">Filiação paterna:</label> <input type="text"
					id="nomeDoPai" name="nomeDoPai" placeholder="Digite o nome do pai">
			</div>

			<div>
				<label for="nomeDaMae">Filiação materna:*</label> <input type="text"
					id="nomeDaMae" name="nomeDaMae" placeholder="Digite o nome da mãe"
					required>
			</div>
		</fieldset>

		<br>

		<fieldset>
			<legend>Dados do Candidato</legend>

			<div>
				<label for="nome">Nome do candidato:*</label> <input type="text"
					id="nome" name="nome" placeholder="Digite o nome do candidato"
					required>
			</div>

		</fieldset>

		<br>

		<fieldset>
			<legend>Telefone 1 *</legend>
			<div>
			
		 <input type="text"
					id="telefone1" name="telefone1"
					placeholder="Digite um número de telefone (00 0000-0000)" pattern="\d{2} \d{4,5}-\d{4}" maxlength="15" required>
			</div>
			<div>
				 <select id="tipo1"
				name="tipo1" required>
				<option value="" disabled selected>Selecione um tipo </option>
				<option value="Residencial">Residencial</option>
				<option value="Celular">Celular</option>
				<option value="Contato">Contato</option>
			</select>
			</div>
			</fieldset>
				
				<br>
				
			<fieldset>
			<legend>Telefone 2</legend>
			<div>
			 <input type="text"
					id="telefone2" name="telefone2"
					placeholder="Digite um número de telefone (00 0000-0000)" pattern="\d{2} \d{4,5}-\d{4}" maxlength="15">
			</div>
			<div>
				<select id="tipo2"
				name="tipo2">
				<option value=""disabled selected>Selecione um tipo</option>
				<option value="Residencial">Residencial</option>
				<option value="Celular">Celular</option>
				<option value="Contato">Contato</option>
			</select>
			</div>
			</fieldset>

			<br>

			<fieldset>
			<legend>Telefone 3</legend>
			<div>
				
			 <input type="text"
					id="telefone3" name="telefone3"
					placeholder="Digite um número de telefone (00 0000-0000)" pattern="\d{2} \d{4,5}-\d{4}"  maxlength="15">
			</div>
			<div>
			 <select id="tipo3"
				name="tipo3">
				<option value=""disabled selected>Selecione um tipo</option>
				<option value="Residencial">Residencial</option>
				<option value="Celular">Celular</option>
				<option value="Contato">Contato</option>
			</select>
			</div>
		</fieldset>

		<br>

		<fieldset>
			<legend>Seleção de Curso</legend>
			<c:set var="contadorForEach" value="1" scope="page" />
			<c:set var="contadorElementosLista" value="0" scope="page" />

			<label for="curso">Selecione até 3 cursos:</label>
			
			<div>
			<input type="hidden" name="descricao1" value="1ª opção" /> 
			<select
				id="id_curso1" name="id_curso1" required>
				<option value="" disabled selected>1ª opçao *</option>
				<c:forEach items="${Cursos}" var="curso">
					<option value="${curso.id}">${curso.nome}</option>
					<c:set var="contadorForEach" value="${contadorForEach + 1}"
						scope="page" />
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + 1}" scope="page" />	
				</c:forEach>
			</select>
			</div>
			
			<div>
			<input type="hidden" name="descricao2" value="2ª opção" /> 
			   <select
				id="id_curso2" name="id_curso2">
				<option value= "" disabled selected>2ª opçao</option>
				<c:forEach items="${Cursos}" var="curso">
					<option value="${curso.id}">${curso.nome}</option>
					<c:set var="contadorForEach" value="${contadorForEach + 1}"
						scope="page" />
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + 1}" scope="page" />	
				</c:forEach>
			</select>
			</div>
			
			<div>
			<input type="hidden" name="descricao3" value="3ª opção" /> 
			  <select
				id="id_curso3" name="id_curso3">
				<option value= "" disabled selected>3ª opçao</option>
				<c:forEach items="${Cursos}" var="curso">
					<option value="${curso.id}">${curso.nome}</option>
					<c:set var="contadorForEach" value="${contadorForEach + 1}"
						scope="page" />
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + 1}" scope="page" />	
				</c:forEach>
			</select>
			</div>

		</fieldset>
		<br> <input type="hidden" name="acao" value="CadastrarCandidato">

		<input type="submit" /> 
		
		<a
			href="/crud/ctrl?acao=CandidatoList"
			class="botao-pesquisar">Pesquisar Candidato</a>
	</form>

</body>
</html>