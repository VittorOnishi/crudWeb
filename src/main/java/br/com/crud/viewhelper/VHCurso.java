package br.com.crud.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.Curso;
import br.com.crud.modelo.EntidadeDominio;

public class VHCurso implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		String acao = request.getParameter("acao");
		Curso crs = null;
		
		if(acao.equals("CadastrarCandidatoForm") || acao.equals("ExibeCandidato")){
			
			crs = new Curso(null);
			
			return crs;
		}
		
		
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {


		request.setAttribute("Cursos", entDom);

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

}
