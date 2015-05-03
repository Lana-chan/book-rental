package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Exemplar;
import entidades.Solicitacao;
import entidades.Usuario;

public class ExemplarDaoJDBC extends ExemplarDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Exemplar exemplar) {
		Connection connection = connectionFactory.getConnection();
		String sql = "insert into exemplar (proprietario) values (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, exemplar.getLivro().getISBN());
			stmt.setBoolean(2, exemplar.getDisponivel());
			stmt.setObject(3, exemplar.getProprietario().getNumUsp());
			stmt.setString(4, exemplar.getFoto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualizaProprietario_(Exemplar exemplar) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update livros set proprietario=? where ISBN=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setObject(1, exemplar.getProprietario().getNumUsp());
			stmt.setObject(2, exemplar.getLivro().getISBN());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
	public void atualizaDisponibilidade_(Exemplar exemplar, Boolean disponivel) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update livros set disponivel=? where ISBN=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setObject(1, disponivel);
			stmt.setObject(2, exemplar.getLivro().getISBN());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	//busca por Titulo
	@Override
	public Exemplar buscaPorTitulo_(String titulo) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		Exemplar livro = null;
		try {
			stmt = connection.prepareStatement("select (livro, disponivel, proprietario, foto) from Exemplar where titulo=? and disponivel=?");
			stmt.setString(1, titulo);
			stmt.setBoolean(2, true);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				livro = new Exemplar();
				livro.getLivro().setISBN(rs.getInt("livro"));
				livro.setDisponivel(true);
				livro.getProprietario().setNumUsp(rs.getInt("proprietario"));
				livro.setFoto(rs.getString("foto"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
		Exemplar dummy = new Exemplar();
		return dummy;
	}
		
	
	@Override
	public List<Exemplar> listaTodos(Usuario usuario) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Exemplar> exemplares = new ArrayList<Exemplar>();

		try {
			stmt = connection.prepareStatement("select (livro, disponivel, proprietario, foto) from Exemplar where proprietario=?");
			stmt.setInt(1, usuario.getNumUsp());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Exemplar exemplar = new Exemplar();
				exemplar.getLivro().setISBN(rs.getLong("livro"));;
				exemplar.setDisponivel(rs.getBoolean("disponivel"));
				exemplar.getProprietario().setNumUsp(rs.getInt("proprietario"));
				exemplar.setFoto(rs.getString("foto"));
				exemplares.add(exemplar);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
		return exemplares;
	}
	
	


	@Override
	public void remove_(Exemplar exemplar) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("delete from exemplares where ISBN=?");
			stmt.setLong(1, exemplar.getLivro().getISBN());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
}
