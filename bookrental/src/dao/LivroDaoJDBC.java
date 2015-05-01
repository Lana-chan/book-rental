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
		String sql = "insert into livro (ISBN, titulo,autor,editora, ano, edicao, sinopse, numPaginas, idioma) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, livro.getISBN());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutor());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAno());
			stmt.setInt(6, livro.getEdicao());
			stmt.setString(7, livro.getSinopse());
			stmt.setInt(8, livro.getNumPaginas());
			stmt.setString(9, livro.getIdioma());
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
		String sql = "update livro set autor = ?, editora = ?, editora = ?, ano = ?, edicao = ?, sinopse = ?, numPaginas = ?, idioma = ? where titulo = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, livro.getISBN());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAutor());
			stmt.setString(4, livro.getEditora());
			stmt.setInt(5, livro.getAno());
			stmt.setInt(6, livro.getEdicao());
			stmt.setString(7, livro.getSinopse());
			stmt.setInt(8, livro.getNumPaginas());
			stmt.setString(9, livro.getIdioma());
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
			stmt = connection.prepareStatement("select * from livro where titulo=?");
			stmt.setString(1, titulo);
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
	public void remove_(Livro livro) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("delete from livro where titulo=?");
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
			stmt = connection.prepareStatement("select * from livro");
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
