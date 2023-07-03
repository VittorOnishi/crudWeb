package br.com.crud.command;

import java.util.List;

import br.com.crud.controller.Resultado;
import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.viewhelper.VHCandidato;

public class FormCadastro implements ICommand{

	@Override
	public Resultado execute(EntidadeDominio entidade) {
	
		Fachada fac = new Fachada();
		
		List<EntidadeDominio> listaDeCursos = fac.consultar(entidade); 
		
		Resultado rstd = new Resultado();
		 
		 rstd.setEntidades(listaDeCursos);
		
		 rstd.setNextPage("forward:formNovoCandidato.jsp");
		 
		return rstd;
	}

}
