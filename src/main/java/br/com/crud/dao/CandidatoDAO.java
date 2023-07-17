package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.Cidade;
import br.com.crud.modelo.Curso;
import br.com.crud.modelo.Endereco;
import br.com.crud.modelo.EntidadeDominio;
import br.com.crud.modelo.Estado;
import br.com.crud.modelo.Filiacao;
import br.com.crud.modelo.Matricula;
import br.com.crud.modelo.Pessoa;
import br.com.crud.modelo.Telefone;

public class CandidatoDAO extends AbstractDAO implements IDAO {

	public CandidatoDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	public void salvar(EntidadeDominio entidade) throws SQLException {

		Pessoa pessoa = (Pessoa) entidade;
		Candidato candidato = (Candidato) pessoa;
		StringBuilder sql = new StringBuilder();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		openConnection();
		con.setAutoCommit(false);

		sql.append("INSERT INTO candidatos(cnd_nome, cnd_filiacao_pat,");
		sql.append("cnd_filiacao_mat, cnd_logradouro, cnd_numero, cnd_complemento,");
		sql.append("cnd_cep, cnd_cidade, cnd_estado, cnd_datacad)");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		try {
			
		st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			st.setString(1, candidato.getNome());

			for (Filiacao filiacao : candidato.getListaFiliacao()) {
				if (filiacao.getDescricao().equals("Pai")) {
					st.setString(2, filiacao.getNome());
				} else if (filiacao.getDescricao().equals("Mae")) {
					st.setString(3, filiacao.getNome());
				}
			}
			st.setString(4, candidato.getEndereco().getLogradouro());
			st.setString(5, candidato.getEndereco().getNumero());
			st.setString(6, candidato.getEndereco().getComplemento());
			st.setString(7, candidato.getEndereco().getCep());
			st.setString(8, candidato.getEndereco().getCidade().getDescricao());
			st.setString(9, candidato.getEndereco().getCidade().getEstado().getDescricao());
			st.setObject(10, candidato.getDtCadastro());
			st.execute();
			
			
			rs = st.getGeneratedKeys();
				while (rs.next()) {
					int idCandidato = 0;

					idCandidato = rs.getInt(1);
					candidato.setId(idCandidato);

					salvarTelefone(candidato);

					salvarMatricula(candidato);

				}
			
			con.commit();

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void salvarTelefone(Candidato candidato) throws SQLException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO telefones (tel_numero, tel_tipo, ");
		sql.append("candidatos_cnd_id) VALUES (?, ?, ?)");

		try {
			
			st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			for (Telefone telefone : candidato.getListadeTelefones()) {

				st.setString(1, telefone.getNumero());
				st.setString(2, telefone.getTipo());
				st.setInt(3, candidato.getId());

				st.execute();

				rs = st.getGeneratedKeys();
				int tel_id = 0;
				
				while(rs.next()) {
					tel_id = rs.getInt(1);
				telefone.setId(tel_id);
				}

			}

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void salvarMatricula(Candidato candidato) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO matricula(candidatos_cnd_id, cursos_crs_id)");
		sql.append(" VALUES (?, ?)");
		PreparedStatement st = null;
		

		try {
			
			 st = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			for (Matricula mat : candidato.getListadeMatriculas()) {

				st.setInt(1, candidato.getId());
				st.setInt(2, mat.getCurso().getId());
				st.execute();
			}

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public ArrayList<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {

		Candidato candidato = (Candidato) entidade;
		Endereco endereco = null;
		Cidade cidade = null;
		Estado estado = null;
		
		PreparedStatement st = null;
		ResultSet rs = null;

		ArrayList<EntidadeDominio> listaDeCandidatos = new ArrayList<>();
		ArrayList<Telefone> listaDeTelefones = new ArrayList<>();
		ArrayList<Filiacao> listaDeFiliacao = new ArrayList<>();
		ArrayList<Matricula> listaDeMatriculas = new ArrayList<>();

		StringBuilder sql = new StringBuilder();

		sql.append(
				"Select cnd_estado, cnd_cidade, cnd_logradouro, cnd_numero, cnd_complemento, cnd_cep, cnd_nome, cnd_datacad, cnd_id  from candidatos where");

		if (candidato.getNome() != null) {
			sql.append(" cnd_nome like ? order by cnd_nome;");
		} 
		
		if (candidato.getId() != null) {
			sql.append(" cnd_id = ? order by cnd_id;");
		}
		
		openConnection();

		try{
			
			st = con.prepareStatement(sql.toString());
			
			if (candidato.getNome() != null && !candidato.getNome().isEmpty()) {
				st.setString(1, "%" + candidato.getNome() + "%");
			} 
			if (candidato.getId() != null) {
				System.out.println(candidato.getId());
				st.setInt(1, candidato.getId());
			}

			st.executeQuery();
			rs = st.getResultSet(); 
			
			while (rs.next()) {

					estado = new Estado(rs.getString("cnd_estado"));

					cidade = new Cidade(estado, rs.getString("cnd_cidade"));

					endereco = new Endereco(rs.getString("cnd_logradouro"), rs.getString("cnd_numero"),
							rs.getString("cnd_complemento"), rs.getString("cnd_cep"), cidade);

					candidato = new Candidato(rs.getString("cnd_nome"), endereco);

					candidato.setDtCadastro(rs.getDate("cnd_datacad").toLocalDate());

					candidato.setId(rs.getInt("cnd_id"));
					
					listaDeTelefones = consultarTelefones(candidato);

					for (Telefone tel : listaDeTelefones) {

						candidato.setListadeTelefones(tel);

					}

					listaDeMatriculas = consultarMatricula(candidato);

					for (Matricula mat : listaDeMatriculas) {

						candidato.setListadeMatriculas(mat);

					}

					listaDeFiliacao = consultarFiliacao(candidato);

					for (Filiacao fil : listaDeFiliacao) {

						candidato.setListaFiliacao(fil);

					}

					listaDeCandidatos.add(candidato);
					
					
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return listaDeCandidatos;
	}

	public ArrayList<Filiacao> consultarFiliacao(Candidato candidato) throws SQLException {

		Filiacao paterna = null;
		Filiacao materna = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("Select cnd_filiacao_pat, cnd_filiacao_mat from candidatos where cnd_id = ?");

		ArrayList<Filiacao> listaDeFiliacao = new ArrayList<>();

		st = con.prepareStatement(sql.toString());
		
			st.setInt(1, candidato.getId());

			st.executeQuery();
			
			rs = st.getResultSet();

				while (rs.next()){

					paterna = new Filiacao(rs.getString("cnd_filiacao_pat"), "Filiacao paterna");
					listaDeFiliacao.add(paterna);

					materna = new Filiacao(rs.getString("cnd_filiacao_mat"), "Filiacao materna");
					listaDeFiliacao.add(materna);
				}

		return listaDeFiliacao;
	}

	public ArrayList<Telefone> consultarTelefones(Candidato candidato) throws SQLException {

		Telefone telefone = null;
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("Select * from telefones where candidatos_cnd_id = ? order by candidatos_cnd_id;");

		ArrayList<Telefone> listaDeTelefones = new ArrayList<>();

		st = con.prepareStatement(sql.toString());

			st.setInt(1, candidato.getId());
			
			st.executeQuery();

			rs = st.getResultSet(); 

			while (rs.next()){

				telefone = new Telefone(rs.getString("tel_numero"), rs.getString("tel_tipo"));
				telefone.setId(rs.getInt("tel_id"));

				listaDeTelefones.add(telefone);

			}
			
		return listaDeTelefones;	
	}

	public ArrayList<Matricula> consultarMatricula(Candidato candidato) throws SQLException {

		Curso curso = null;
		Matricula mat = null;
		
		ResultSet rs = null;
		PreparedStatement st = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mat_id, crs_id, crs_nome from cursos inner join matricula ");
		sql.append("on crs_id = cursos_crs_id where candidatos_cnd_id = ?;");

		ArrayList<Matricula> listaDeMatriculas = new ArrayList<>();
		
		st = con.prepareStatement(sql.toString());

			st.setInt(1, candidato.getId());
			
			st.executeQuery();

			rs = st.getResultSet();

			while (rs.next()) {

				curso = new Curso(rs.getString("crs_nome"));
				curso.setId(rs.getInt("crs_id"));
				mat = new Matricula(curso);
				mat.setId(rs.getInt("mat_id"));

				listaDeMatriculas.add(mat);

			}
		
		return listaDeMatriculas;
	}

	public void alterar(EntidadeDominio entidade) throws SQLException {
		
		openConnection();
		Candidato candidato = (Candidato) entidade;
		
		PreparedStatement st = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("update candidatos set cnd_nome=?, cnd_filiacao_pat=?, cnd_filiacao_mat=?, cnd_logradouro=?, cnd_numero=?");
		sql.append(", cnd_complemento=?, cnd_cep=?, cnd_cidade=?, cnd_estado=? where cnd_id=?");

			con.setAutoCommit(false);
			
		try {
				
			st = con.prepareStatement(sql.toString());
				
			st.setString(1, candidato.getNome());

			for (Filiacao filiacao : candidato.getListaFiliacao()) {
				if (filiacao.getDescricao().equals("Pai")) {
					st.setString(2, filiacao.getNome());
				} else if (filiacao.getDescricao().equals("Mae")) {
					st.setString(3, filiacao.getNome());
				}
			}

			st.setString(4, candidato.getEndereco().getLogradouro());
			st.setString(5, candidato.getEndereco().getNumero());
			st.setString(6, candidato.getEndereco().getComplemento());
			st.setString(7, candidato.getEndereco().getCep());
			st.setString(8, candidato.getEndereco().getCidade().getDescricao());
			st.setString(9, candidato.getEndereco().getCidade().getEstado().getDescricao());
			st.setInt(10, candidato.getId());
			alterarTelefone(candidato);
			alterarMatricula(candidato);
			st.executeUpdate();	
			con.commit();
			
		}catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e.printStackTrace();
				}
				e.printStackTrace();			
			}finally{
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	public void alterarTelefone(Candidato candidato) throws SQLException {

		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("update telefones set tel_numero=?, tel_tipo=?");
		sql.append(" where tel_id=? and candidatos_cnd_id=?");

		try {
			for (Telefone telefone : candidato.getListadeTelefones()) {

				st = con.prepareStatement(sql.toString());
				st.setString(1, telefone.getNumero());
				st.setString(2, telefone.getTipo());
				st.setInt(3, telefone.getId());
				st.setInt(4, candidato.getId());
				st.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback executado em alterar matricula");
			con.rollback();
		}

	}

	public void alterarMatricula(Candidato candidato) throws SQLException {

		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("update matricula set cursos_crs_id=?");
		sql.append(" where mat_id=?");
		try {

			for (Matricula mat : candidato.getListadeMatriculas()) {

				st = con.prepareStatement(sql.toString());
				st.setInt(1, mat.getCurso().getId());
				st.setInt(2, mat.getId());
				st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Rollback executado em alterar matricula");
			con.rollback();
		}

	}

	public void excluir(EntidadeDominio entidade) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from candidatos where cnd_id=?");
		PreparedStatement st = null;
		openConnection();
		
		try {
			con.setAutoCommit(false);
			st = con.prepareStatement(sql.toString());
			st.setInt(1, entidade.getId());
			excluirTelefone(entidade);
			excluirMatricula(entidade);
			st.execute();
			con.commit();
			
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}		

	public void excluirTelefone(EntidadeDominio entidade) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from telefones where candidatos_cnd_id=?");
		PreparedStatement st = null;
		
		try {
			st = con.prepareStatement(sql.toString());
			st.setInt(1, entidade.getId());
			st.execute();
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void excluirMatricula(EntidadeDominio entidade) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from matricula where candidatos_cnd_id=?");
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql.toString());
			st.setInt(1, entidade.getId());
			st.execute();
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
