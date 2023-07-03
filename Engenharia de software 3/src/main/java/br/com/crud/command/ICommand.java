package br.com.crud.command;

import br.com.crud.controller.Resultado;
import br.com.crud.modelo.EntidadeDominio;

public interface ICommand {
	
	public Resultado execute(EntidadeDominio entidade);

}
