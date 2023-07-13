package br.com.crud.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;

public class ListarCandidato implements Acao {
	

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("Listando candidatos");
		
		String nome = request.getParameter("pesquisaNome");
			
			Candidato cnd = new Candidato(nome);
		    
		    Fachada fac = new Fachada();
		    
		    List<EntidadeDominio> listaCandidato = fac.consultar(cnd);
		    
			request.setAttribute("candidatos", listaCandidato);	
			
			return "forward:listaCandidato.jsp";
		

	}
	
	

}
