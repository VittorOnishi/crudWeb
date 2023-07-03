package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crud.controller.Conexao;
import br.com.crud.modelo.Candidato;
import br.com.crud.modelo.Curso;
import br.com.crud.modelo.EntidadeDominio;

public class CursoDAO implements IDAO {
	
	private Connection con = null;

	@Override
	public void salvar(EntidadeDominio entidade)throws SQLException{
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {

		ResultSet rs = null;
		PreparedStatement st = null;
		
		Curso curso = (Curso) entidade;
		
		ArrayList<EntidadeDominio> listaDeCursos = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("Select * from cursos ");
		

		try {
			
			con = new Conexao().getConnection();
			st = con.prepareStatement(sql.toString());
			rs = st.executeQuery();

			if (rs != null) {

				while (rs.next()) {
					
				  curso = new Curso(rs.getString("crs_nome"));
				  curso.setId(rs.getInt("crs_id"));
				  
				  listaDeCursos.add(curso);
						
				  }

				}

		} catch (SQLException ex) {
			System.err.println("Erro ao listar curso " + ex);
		} finally {
			if (rs != null) {
				st.close();
			}
		}

		return listaDeCursos;
	}

}
