package br.com.crud.command;

import br.com.crud.controller.Resultado;
import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.EntidadeDominio;

public class ExibirCommand implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Fachada fac = new Fachada();

		Resultado rstd = new Resultado();

		rstd.setEntidades(fac.consultar(entidade));
		
		rstd.setNextPage("forward:formAlteraCandidato.jsp");
		
		return rstd;
	}

	
	

}
