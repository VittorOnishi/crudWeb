package br.com.crud.strategy;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;

public class ValidarDadosObrigatorios implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Candidato candidato = (Candidato) entidade;
		
		if(candidato.getNome().equals("")
				|| candidato.getNome() == null 
				|| candidato.getEndereco().getCidade().getEstado().getDescricao().equals("")
				|| candidato.getEndereco().getCidade().getEstado().getDescricao() == null
				|| candidato.getEndereco().getCidade().getDescricao().equals("")
				|| candidato.getEndereco().getCidade().getDescricao() == null
				|| candidato.getEndereco().getCep().equals("")
				|| candidato.getEndereco().getCep() == null
				|| candidato.getEndereco().getLogradouro().equals("")
				|| candidato.getEndereco().getLogradouro() == null
				|| candidato.getEndereco().getNumero().equals("")
				|| candidato.getEndereco().getNumero() == null) {
			
			return "Dados obrigatorios invalidos\n";
			
			
		}
		
		return null;
	}

}
