package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entidades.Livro;

public class LivroDaoJDBC extends LivroDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Livro livro) {
		Connection connection = connectionFactory.getConnection();
		String sql = "insert into livros (titulo,autor,editora) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualiza_(Livro livro) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update livros set autor = ?, editora = ? where titulo = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livro.getAutor());
			stmt.setString(2, livro.getEditora());
			stmt.setString(3, livro.getTitulo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public Livro buscaPorTitulo_(String titulo) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		Livro livro = null;
		try {
			stmt = connection.prepareStatement("select * from livros where titulo=?");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				livro = new Livro();
				livro.setTitulo(titulo);
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
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
	public void remove_(Livro livro) {
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
	public List<Livro> listaTodos() {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		LinkedList<Livro> livros = new LinkedList<Livro>();

		try {
			stmt = connection.prepareStatement("select * from livros");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
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