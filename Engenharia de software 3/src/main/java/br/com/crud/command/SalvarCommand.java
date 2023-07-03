package br.com.crud.command;

import br.com.crud.controller.Resultado;
import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.EntidadeDominio;

public class SalvarCommand implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Fachada fac = new Fachada();
		
		Resultado rstd = new Resultado();
		
		rstd.setMsg(fac.salvar(entidade));
		
		rstd.setNextPage("forward:listaCandidato.jsp");
		
		return rstd;
	}

	

}
