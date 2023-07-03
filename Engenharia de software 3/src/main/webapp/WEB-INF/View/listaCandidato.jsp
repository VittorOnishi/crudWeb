<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.crud.modelo.Candidato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Java Standard Taglib</title>

	<style>
form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 20px;
}

form input[type="text"] {
  padding: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  border: 2px solid #ccc;
  border-radius: 4px;
}

form input[type="submit"] {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 4px;
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

/* Estilo para a tabela */
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 15px;
  margin-bottom: 25px;
}

table th {
  background-color: #4CAF50;
  color: #fff;
  text-align: left;
  padding: 10px;
}

table td, table th {
  border: 1px solid #ddd;
  padding: 10px;
  border: none;
}

table tr:nth-child(even) {
  background-color: #f2f2f2;
}

table a.botao-editar{
  padding: 5px 10px;
  background-color: #4CAF50;
  color: #fff;
  text-decoration: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

table a.botao-excluir {
  padding: 5px 10px;
  background-color: #f44336;
  color: #fff;
  text-decoration: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

	</style>
</head>

<body>
	<form>
		<br> <br> Insira o nome do candidato:
		<input type="text" name="pesquisaNome" required/>
		<input type="hidden" name="acao" value="ListarCandidato">
		<input type="submit" /> <br> <br>
		<br>
		<a href="/crud/ctrl?acao=CadastrarCandidatoForm"
			class="botao-voltar">Voltar</a>
	</form>

	<table>
		<tr>
			<th colspan="5">Informações do candidato</th>
			
		</tr>
		
		<c:forEach items="${EntidadeDominio}" var="candidato">
			<tr><td>
				<p><b>Nome:</b> ${candidato.nome}</p>
				
				<c:forEach items="${candidato.listaFiliacao}" var="filiacao">
		
						<p><b>${filiacao.descricao}:</b> ${filiacao.nome}</p> 

				</c:forEach>
				
				<a href="/crud/ctrl?acao=ExibeCandidato&id=${candidato.id}"
					class="botao-editar">Editar</a>
				
				<a href="/crud/ctrl?acao=RemoveCandidato&id=${candidato.id}"
					class="botao-excluir">Excluir</a>
				
				</td>
				
				<td>
				<p><b>Endereço:</b> ${candidato.endereco.logradouro}, ${candidato.endereco.numero}</p>
				<p><b>Cep:</b> ${candidato.endereco.cep}, <b>Cidade:</b> ${candidato.endereco.cidade.descricao} - ${candidato.endereco.cidade.estado.descricao}</p>
				</td>
				
				<td>
		
				<p><b>Telefones Cadastrados:</b><c:forEach items="${candidato.listadeTelefones}" var="telefone">
		
						 <p>${telefone.numero} - ${telefone.tipo}</p> 

				</c:forEach></p>
				</td>
				
				<td>
				<p><b>Cursos Escolhidos: </b><c:forEach items="${candidato.listadeMatriculas}" var="matricula">
		
						 <p>${matricula.curso.nome}</p> 

				</c:forEach></p>
				
			
          
          </td>
          
			</tr>

		</c:forEach>
				
	</table>
	
</html>



