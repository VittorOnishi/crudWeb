package br.com.crud.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.EntidadeDominio;

public class RemoveCandidato implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("Removendo candidato");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntidadeDominio entDom = new EntidadeDominio();
		
		entDom.setId(id);
		
		Fachada fac = new Fachada();
		
		fac.excluir(entDom);


		return "redirect:controller?acao=ListaCandidatoPage";

	}

}
