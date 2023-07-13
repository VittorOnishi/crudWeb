package br.com.crud.command;

import br.com.crud.controller.Resultado;
import br.com.crud.modelo.EntidadeDominio;

public class CandidatoList implements ICommand{

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		rstd.setNextPage("forward:listaCandidato.jsp");
		
		return rstd;
	}
	

}
