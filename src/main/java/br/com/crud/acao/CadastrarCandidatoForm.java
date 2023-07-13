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
//import br.com.crud.modelo.Curso;
//import br.com.crud.modelo.EntidadeDominio;
//
//public class CadastrarCandidatoForm implements Acao {
//
//	@Override
//	public String executa(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		
//		Curso crs = new Curso(null, null);
//		
//		Fachada fac = new Fachada();
//		
//		List<EntidadeDominio> listaDeCursos = fac.consultar(crs); 
//		
//		request.setAttribute("cursos", listaDeCursos);
//		
//		return "forward:formNovoCandidato.jsp";
//	}
//
//}
