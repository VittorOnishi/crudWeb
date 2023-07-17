package br.com.crud.strategy;

import java.time.LocalDate;
import java.time.Period;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;

public class ValidarDataAlteracao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Candidato candidato = (Candidato) entidade;
		
		System.out.println("Data de cadastro:" + candidato.getDtCadastro());
		
		if(candidato.getDtCadastro()!= null) {
			
			LocalDate dataAtual = LocalDate.now();
			
			Period periodo = Period.between(candidato.getDtCadastro(), dataAtual);
			
			boolean passouUmAno = periodo.getYears() >= 1;

	        if (passouUmAno == false) {
	        	
	        	return "Ainda não se passou um ano após a data anterior.\n";
	        	
	        } 
		
	        
		}
		
		return null;
	}
		
		
	}
	

