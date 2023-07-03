package br.crud.com.strategy;

import java.util.ArrayList;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Filiacao;
import br.com.crud.modelo.Matricula;

public class ValidarCursos implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Candidato candidato = (Candidato) entidade;
			
		
			if(candidato.getListadeMatriculas().size() > 3) {
			
			return "A candidatura não pode exceder 3 cursos.\n";
				
			}else if(candidato.getListadeMatriculas().size() < 1) {
				
				
				return "Candidatura a cursos inválida.\n";
				
			}
			
				
			return null;
	}

}
