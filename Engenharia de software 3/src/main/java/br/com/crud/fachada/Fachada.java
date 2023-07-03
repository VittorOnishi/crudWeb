package br.com.crud.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.crud.dao.CandidatoDAO;
import br.com.crud.dao.CursoDAO;
import br.com.crud.dao.IDAO;
import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.Curso;
import br.com.crud.modelo.EntidadeDominio;
import br.crud.com.strategy.GerarDataCad;
import br.crud.com.strategy.IStrategy;
import br.crud.com.strategy.ValidaFiliacao;
import br.crud.com.strategy.ValidarCursos;
import br.crud.com.strategy.ValidarDadosObrigatorios;
import br.crud.com.strategy.ValidarDataAlteracao;
import br.crud.com.strategy.ValidarTelefones;

public class Fachada implements IFachada {
	
	private Map<String, Map<String, List<IStrategy>>> mainMap;
	
	 private Map<String, List<IStrategy>> mapaRNS;
		
		private Map<String, IDAO> daos;
		
		public Fachada() {
			
			mainMap = new HashMap<String, Map<String, List<IStrategy>>>();
			
			mapaRNS = new HashMap<String, List<IStrategy>>();
			
			daos = new HashMap<String, IDAO>();
			
			ValidaFiliacao vFiliacao = new ValidaFiliacao();
			GerarDataCad vDataCad = new GerarDataCad();
			ValidarTelefones vTel = new ValidarTelefones();
			ValidarCursos vCrs = new ValidarCursos();
			ValidarDadosObrigatorios vObg = new ValidarDadosObrigatorios();
			
			List<IStrategy> rnsCandidatoSalvar = new ArrayList<IStrategy>();
			
			rnsCandidatoSalvar.add(vFiliacao);
			rnsCandidatoSalvar.add(vDataCad);
			rnsCandidatoSalvar.add(vTel);
			rnsCandidatoSalvar.add(vCrs);
			rnsCandidatoSalvar.add(vObg);
			
			ValidarDataAlteracao vDataAlt = new ValidarDataAlteracao();
			
			List<IStrategy> rnsCandidatoAlterar = new ArrayList<IStrategy>();
			
			rnsCandidatoAlterar.add(vDataAlt);
			rnsCandidatoAlterar.add(vFiliacao);
			rnsCandidatoAlterar.add(vCrs);
			rnsCandidatoAlterar.add(vTel);
			rnsCandidatoAlterar.add(vObg);
			
			
			mapaRNS.put("SALVAR", rnsCandidatoSalvar);
			mapaRNS.put("ALTERAR", rnsCandidatoAlterar);
			
			mainMap.put(Candidato.class.getName(), mapaRNS);
			//mapaRNS.put(Funcionario.class.getName(), rnsFuncionario);
			
			daos.put(Candidato.class.getName(), new CandidatoDAO());
			daos.put(Curso.class.getName(), new CursoDAO());
			daos.put(EntidadeDominio.class.getName(), new CandidatoDAO());
		
			
		}

		@Override
		public String salvar(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("SALVAR");
			StringBuilder msgs = new StringBuilder();
			
			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null) {
					msgs.append(msg);
				}			
			}
			
			if(msgs.length()==0) {
				IDAO dao = daos.get(nmClasse);
				try {
					dao.salvar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				return msgs.toString();
			}
			return null;
		}

		@Override
		public String excluir(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			
				IDAO dao = daos.get(nmClasse);
				try {
					dao.excluir(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return null;
		}

		@Override
		public String alterar(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("ALTERAR");
			StringBuilder msgs = new StringBuilder();
			
			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null) {
					System.out.println(msgs.append(msg));
				}			
			}
			
			if(msgs.length()==0) {
				IDAO dao = daos.get(nmClasse);
				try {
					dao.alterar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				return msgs.toString();
			}
			return null;
		}

		@Override
		public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			List<EntidadeDominio> lista = new ArrayList<>();
			
				IDAO dao = daos.get(nmClasse);
				try {
					lista = dao.consultar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return lista;
		}
		

}//vemsermuralis@muralis.com.br - teste/dev
