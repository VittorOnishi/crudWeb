package br.crud.com.strategy;

import br.com.crud.modelo.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
