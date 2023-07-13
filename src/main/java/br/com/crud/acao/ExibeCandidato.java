//package br.com.crud.acao;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.crud.fachada.Fachada;
//import br.com.crud.modelo.Candidato;
//import br.com.crud.modelo.Curso;
//import br.com.crud.modelo.EntidadeDominio;
//
//public class ExibeCandidato implements Acao {
//	
//	@Override
//	public String executa(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//        
//		System.out.println("Mostrando dados do candidato " + request.getParameter("id"));
//
//		String paramId = request.getParameter("id");
//		int id = Integer.valueOf(paramId);
//		
//		Fachada fac = new Fachada();
//		Candidato cnd = new Candidato(id);
//		
//		List<EntidadeDominio> listaCandidato = fac.consultar(cnd);
//		    
//		for(EntidadeDominio candidato : listaCandidato) {
//			
//			request.setAttribute("candidato", candidato);
//			
//		}
//		
//        Curso crs = new Curso(null, null);
//		
//		List<EntidadeDominio> listaDeCursos = fac.consultar(crs); 
//		
//		request.setAttribute("cursos", listaDeCursos);
//		
//		
//		return "forward:formAlteraCandidato.jsp";
//	}
//
//}
