package br.com.crud.command;

import java.util.List;

import br.com.crud.controller.Resultado;
import br.com.crud.fachada.Fachada;
import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Filiacao;

public class ConsultarCommand implements ICommand{

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Fachada fac = new Fachada();
		
		 List<EntidadeDominio> listaCandidato = fac.consultar(entidade);
		 
		 Resultado rstd = new Resultado();
		 
		 rstd.setEntidades(listaCandidato);
		
		 rstd.setNextPage("forward:listaCandidato.jsp");
		 
		return rstd;
	}

	

}
