package br.crud.com.strategy;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Filiacao;

public class ValidaFiliacao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Candidato candidato = (Candidato) entidade;
		
		
		for(Filiacao filiacao : candidato.getListaFiliacao()) {
			
		
			if(filiacao.getNome().isEmpty() && filiacao.getDescricao().equals("Pai")) {
				filiacao.setNome("DESCONHECIDO");
				
			}
			
			if(filiacao.getNome().isEmpty() || filiacao.getNome() == null && filiacao.getDescricao().equals("Mae")) {
				
				return "O nome da mae não pode estar vazio.\n";
				
			}
			
		}
				
			return null;
	}

}
