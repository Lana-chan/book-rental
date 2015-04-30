package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entidades.Exemplar;
import entidades.Livro;

public class ExemplarDaoJDBC extends ExemplarDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Exemplar exemplar) {
		Connection connection = connectionFactory.getConnection();
		String sql = "insert into exemplar (livro, disponivel, proprietario, historicoProprietario, solicitacoes, foto) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setObject(1, exemplar.getLivro());
			stmt.setBoolean(2, exemplar.getDisponivel());
			stmt.setObject(3, exemplar.getProprietario());
			stmt.setObject(4, exemplar.getHistoricoProprietario());
			stmt.setObject(5, exemplar.getSolicitacoes());
			stmt.setString(6, exemplar.getFoto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualiza_(Exemplar exemplar) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update livros set livro=?, disponivel=?, proprietario=?, historicoProprietario=?, solicitacoes=?, foto=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setObject(1, exemplar.getLivro());
			stmt.setBoolean(2,exemplar.getDisponivel());
			stmt.setObject(3, exemplar.getProprietario());
			stmt.setObject(4, exemplar.getHistoricoProprietario());
			stmt.setObject(5, exemplar.getSolicitacoes());
			stmt.setString(6, exemplar.getFoto());
			stmt.execute();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public Exemplar buscaPorExemplar_(Exemplar exemplar) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		Livro livro = null;
		try {
			stmt = connection.prepareStatement("select * from Exemplar where titulo=?");
			stmt.setString(1, exemplar);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				livro = new Livro();
				livro.setISBN(rs.getLong("ISBN"));
				livro.setTitulo(titulo);
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setAno(rs.getInt("ano"));
				livro.setEdicao(rs.getInt("edicao"));
				livro.setSinopse(rs.getString("sinopse"));
				livro.setNumPaginas(rs.getInt("numPaginas"));
				livro.setIdioma(rs.getString("idioma"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}

		return livro;
	}

	@Override
	public void remove_(Exemplar livro) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("delete from livros where titulo=?");
			stmt.setString(1, livro.getTitulo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public List<Exemplar> listaTodos() {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		LinkedList<Livro> livros = new LinkedList<Livro>();

		try {
			stmt = connection.prepareStatement("select * from livros");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro();
				livro.setISBN(rs.getLong("ISBN"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setAno(rs.getInt("ano"));
				livro.setEdicao(rs.getInt("edicao"));
				livro.setSinopse(rs.getString("sinopse"));
				livro.setNumPaginas(rs.getInt("numPaginas"));
				livro.setIdioma(rs.getString("idioma"));
				
				livros.add(livro);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}

		return livros;
	}
}
