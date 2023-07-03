//package br.com.crud.acao;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.crud.fachada.Fachada;
//import br.com.crud.modelo.Candidato;
//import br.com.crud.modelo.Cidade;
//import br.com.crud.modelo.Curso;
//import br.com.crud.modelo.Endereco;
//import br.com.crud.modelo.Estado;
//import br.com.crud.modelo.Filiacao;
//import br.com.crud.modelo.Telefone;
//
//public class CadastrarCandidato implements Acao {
//
//	public String executa(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//
//		System.out.println("Cadastrando novo Candidato");
//		
//		ArrayList<Filiacao> listaFiliacao = new ArrayList<>();
//		
//		Fachada fac = new Fachada();
//
//		Estado estado = new Estado(request.getParameter("estado"));
//		Cidade cidade = new Cidade(estado, request.getParameter("cidade"));
//		Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("numero"),
//				request.getParameter("complemento"), request.getParameter("cep"), cidade);
//		
//		Filiacao paterna = new Filiacao(request.getParameter("nomeDoPai"), "Pai");
//		listaFiliacao.add(paterna);
//		
//		Filiacao materna = new Filiacao(request.getParameter("nomeDaMae"), "Mae");
//		listaFiliacao.add(materna);
//		
//		Candidato candidato = new Candidato(request.getParameter("nome"), endereco, listaFiliacao);
//		
//		if(request.getParameter("id_curso1") != null 
//				&& !request.getParameter("id_curso1").equals("")){
//			System.out.println("Entrou no idcurso1");
//			Curso curso1 = new Curso(Integer.valueOf(request.getParameter("id_curso1")));
//			curso1.setDescricao(request.getParameter("descricao1"));
//			candidato.setListadeCursos(curso1);
//		}
//		
//		if(request.getParameter("id_curso2") != null 
//				&& !request.getParameter("id_curso2").equals("")){
//			System.out.println("Entrou no idcurso2");			Curso curso2 = new Curso(Integer.valueOf(request.getParameter("id_curso2")));
//			curso2.setDescricao(request.getParameter("descricao2"));
//			candidato.setListadeCursos(curso2);
//	}
//	
//		if(request.getParameter("id_curso3") != null 
//				&& !request.getParameter("id_curso3").equals("")){
//			Curso curso3 = new Curso(Integer.valueOf(request.getParameter("id_curso3")));
//			curso3.setDescricao(request.getParameter("descricao3"));
//			candidato.setListadeCursos(curso3);
//	}
//		
//		if(request.getParameter("telefone1") != null && !request.getParameter("telefone1").equals("") 
//				&& request.getParameter("tipo1") != null && !request.getParameter("tipo1").equals("")){
//			Telefone tel1 = new Telefone(request.getParameter("telefone1"), request.getParameter("tipo1"));
//			candidato.setListadeTelefones(tel1);
//		}
//		
//		if(request.getParameter("telefone2") != null && !request.getParameter("telefone2").trim().equals("") 
//				&& request.getParameter("tipo2") != null && !request.getParameter("tipo2").trim().equals("")){
//			Telefone tel2 = new Telefone(request.getParameter("telefone2"), request.getParameter("tipo2"));
//			candidato.setListadeTelefones(tel2);
//		}
//		
//		if(request.getParameter("telefone3") != null && !request.getParameter("telefone3").trim().equals("") 
//				&& request.getParameter("tipo3") != null && !request.getParameter("tipo3").trim().equals("")){
//			Telefone tel3 = new Telefone(request.getParameter("telefone3"), request.getParameter("tipo3"));
//			candidato.setListadeTelefones(tel3);
//		}
//		
//		fac.salvar(candidato);
//
//		return "redirect:controller?acao=ListaCandidatoPage";
//
//	}
//}
