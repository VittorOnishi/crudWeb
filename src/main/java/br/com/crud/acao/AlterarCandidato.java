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
//public class AlterarCandidato implements Acao {
//
//	@Override
//	public String executa(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//	
//		Fachada fac = new Fachada();
//		
//		String paramId1 = request.getParameter("id");
//		Integer cnd_id = Integer.valueOf(paramId1);
//		
//		ArrayList<Filiacao> listaFiliacao = new ArrayList<>();
//
//		System.out.println("Alterando dados do candidato " + cnd_id);
//
//
//		Estado estado = new Estado(request.getParameter("estado"));
//		Cidade cidade = new Cidade(estado, request.getParameter("cidade"));
//		Endereco endereco = new Endereco(request.getParameter("logradouro"), request.getParameter("numero"),
//				request.getParameter("complemento"), request.getParameter("cep"), cidade);
//		
//		Filiacao paterna = new Filiacao(request.getParameter("Filiacao paterna"), "Pai");
//		listaFiliacao.add(paterna);
//		
//		Filiacao materna = new Filiacao(request.getParameter("Filiacao materna"), "Mae");
//		listaFiliacao.add(materna);
//		
//		Candidato candidato = new Candidato(request.getParameter("nome"), endereco, listaFiliacao);
//		candidato.setId(cnd_id);
//		
//		if(request.getParameter("id_curso1") != null 
//				&& !request.getParameter("id_curso1").equals("")){
//			Curso curso1 = new Curso(Integer.valueOf(request.getParameter("id_curso1")));
//			curso1.setDescricao(request.getParameter("descricao1"));
//			candidato.setListadeCursos(curso1);
//		}
//		
//		if(request.getParameter("id_curso2") != null 
//				&& !request.getParameter("id_curso2").equals("")){
//			Curso curso2 = new Curso(Integer.valueOf(request.getParameter("id_curso2")));
//			curso2.setDescricao(request.getParameter("descricao2"));
//			candidato.setListadeCursos(curso2);
//	}
//		
//	
//		if(request.getParameter("id_curso3") != null 
//				&& !request.getParameter("id_curso3").equals("")){
//			Curso curso3 = new Curso(Integer.valueOf(request.getParameter("id_curso3")));
//			curso3.setDescricao(request.getParameter("descricao3"));
//			
//			candidato.setListadeCursos(curso3);
//	}
//		
//		if(request.getParameter("telefone1") != null && !request.getParameter("telefone1").equals("") 
//				&& request.getParameter("tipo1") != null && !request.getParameter("tipo1").equals("") 
//				&& !request.getParameter("tel_id1").equals("")
//				&& request.getParameter("tel_id1") != null){
//			Telefone tel1 = new Telefone(request.getParameter("telefone1"), request.getParameter("tipo1"));
//			tel1.setId(Integer.valueOf(request.getParameter("tel_id1")));
//			candidato.setListadeTelefones(tel1);
//		}
//		
//		if(request.getParameter("telefone2") != null && !request.getParameter("telefone2").equals("") 
//				&& request.getParameter("tipo2") != null && !request.getParameter("tipo2").equals("") 
//				&& !request.getParameter("tel_id2").equals("")
//				&& request.getParameter("tel_id2") != null){
//			Telefone tel2 = new Telefone(request.getParameter("telefone2"), request.getParameter("tipo2"));
//			tel2.setId(Integer.valueOf(request.getParameter("tel_id2")));
//			candidato.setListadeTelefones(tel2);
//		}
//		
//		if(request.getParameter("telefone3") != null && !request.getParameter("telefone3").equals("") 
//				&& request.getParameter("tipo3") != null && !request.getParameter("tipo3").equals("") 
//				&& !request.getParameter("tel_id3").equals("")
//				&& request.getParameter("tel_id3") != null){
//			Telefone tel3 = new Telefone(request.getParameter("telefone3"), request.getParameter("tipo3"));
//			tel3.setId(Integer.valueOf(request.getParameter("tel_id3")));
//			candidato.setListadeTelefones(tel3);
//		}
//
//		// Alterando
//		String msg = fac.alterar(candidato);
//		
//		System.out.println(msg + " teste em alterar");
//
//		return "redirect:controller?acao=ListaCandidatoPage";
//	}
//
//}
