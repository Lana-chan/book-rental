package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import entidades.Usuario;

public class UsuarioDaoJDBC extends LivroDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Usuario usuario) {
		Connection connection = connectionFactory.getConnection();
		String sql = "INSERT INTO usuarios (numUsp, nome, unidade, email, foto, colecao, reputacao) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumUsp());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getUnidade());
			stmt.setString(4, usuario.getEmail());
			stmt.setInt(5, usuario.getFoto());
			stmt.setList(6, usuario.getColecao()); //lista exemplar
			stmt.setList(7, usuario.getReputacao()); //lista avaliacao
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualiza_(Usuario usuario) {
		Connection connection = connectionFactory.getConnection();
		String sql = "UPDATE usuarios numUsp=?, nome=?, unidade=?, email=?, foto=?, colecao=?, reputacao=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumUsp());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getUnidade());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getFoto());
			stmt.setList(6, usuario.getColecao()); //lista exemplar
			stmt.setList(7, usuario.getReputacao()); //lista avaliacao
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	//@Override
	public Usuario buscaPorUsuario_(int numUsp) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		Usuario usuario = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM usuario WHERE numUsp=?");
			stmt.setInt(1, numUsp);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setNumUsp(numUsp);
				usuario.setNome(rs.getString("nome"));
				usuario.setUnidade(rs.getEnum("unidade"));
				usuario.setEmail(rs.getString("email"));
				//usuario.setFoto(rs.getString("foto"));
				//usuario.setReputacao(rs.getString("idioma"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}

		return usuario;
	}

	//@Override
	public void remove_(Usuario usuario) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM usuario WHERE numUsp=?");
			stmt.setInt(1, usuario.getNumUsp());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	//@Override
	public List<Usuario> listaTodos() {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

		try {
			stmt = connection.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario = new Usuario();
				usuario.setNumUsp(numUsp);
				usuario.setNome(rs.getString("nome"));
				usuario.setUnidade(rs.getEnum("unidade"));
				usuario.setEmail(rs.getString("email"));
				//usuario.setFoto(rs.getString("foto"));
				//usuario.setReputacao(rs.getString("idioma"));
				
				usuarios.add(usuario);
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
