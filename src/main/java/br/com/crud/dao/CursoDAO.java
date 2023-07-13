package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.crud.modelo.Curso;
import br.com.crud.modelo.EntidadeDominio;

public class CursoDAO extends AbstractDAO implements IDAO {

	public CursoDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
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

		Curso curso = (Curso) entidade;

		ArrayList<EntidadeDominio> listaDeCursos = new ArrayList<>();

		StringBuilder sql = new StringBuilder();

		sql.append("Select * from cursos ");

		openConnection();

		try (PreparedStatement st = con.prepareStatement(sql.toString())) {

			st.execute();

			try (ResultSet rs = st.getResultSet()) {

					while (rs.next()) {

						curso = new Curso(rs.getString("crs_nome"));
						curso.setId(rs.getInt("crs_id"));

						listaDeCursos.add(curso);

					}

			}

		} catch (SQLException ex) {
			System.err.println("Erro ao listar curso " + ex);
		}

		return listaDeCursos;
	}

}
