package br.crud.com.strategy;

import java.util.ArrayList;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Telefone;

public class ValidarTelefones implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Candidato candidato = (Candidato) entidade;
		
		if(candidato.getListadeTelefones().size() > 3 || candidato.getListadeTelefones().size() < 1) {
			 
			 return "Telefones inválidos.\n";
		 }
		
		for(Telefone tel : candidato.getListadeTelefones()) {
			
			String telefone = tel.getNumero().replaceAll("[^0-9]", "");
			
			 if(telefone.length() < 10 || telefone.length() > 11) {
				
				return "Telefone " + tel.getNumero() + "invalido.\n";

			}
		}
			 
			 
		
		return null;
	}

	
	}
