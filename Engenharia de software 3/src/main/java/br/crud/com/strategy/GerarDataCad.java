package br.crud.com.strategy;

import java.time.LocalDate;

import br.com.crud.modelo.EntidadeDominio;

public class GerarDataCad implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		entidade.setDtCadastro(LocalDate.now());
		
		return null;
	}

}
