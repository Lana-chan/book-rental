package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Usuario;
import entidades.Unidade;

public class UsuarioDaoJDBC extends UsuarioDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Usuario usuario) {
		Connection connection = connectionFactory.getConnection();
		String sql = "INSERT INTO usuarios (numUsp, nome, unidade, email, foto, colecao, reputacao) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumUsp());
			stmt.setString(2, usuario.getNome());
			//stmt.setInt(3, usuario.getUnidade());
			//transforme Unidade para integer antes -erin
			stmt.setString(4, usuario.getEmail());
			//stmt.setInt(5, usuario.getFoto());
			//não estamos fazendo foto, certo? -erin
			//stmt.setList(6, usuario.getColecao()); //lista exemplar
			//stmt.setList(7, usuario.getReputacao()); //lista avaliacao
			//setlist não existe -- pesquisar como guardar ArrayList<Object>() em SQL com JDBC -erin
			//método Usuario.getReputacao() não existe, criar? -erin
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
			//stmt.setInt(3, usuario.getUnidade());
			stmt.setInt(3, usuario.getUnidade().getValue());
			stmt.setString(4, usuario.getEmail());
			//stmt.setString(5, usuario.getFoto());
			//stmt.setList(6, usuario.getColecao()); //lista exemplar
			//stmt.setList(7, usuario.getReputacao()); //lista avaliacao
			//setlist não existe -- pesquisar como guardar ArrayList<Object>() em SQL com JDBC -erin
			//método Usuario.getReputacao() não existe, criar? -erin
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public Usuario buscaPorNumUsp_(int numUsp) {
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
				usuario.setUnidade(Unidade.fromInt(rs.getInt("unidade")));
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

	@Override
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

	@Override
	public List<Usuario> listaTodos() {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			stmt = connection.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario = new Usuario();
				usuario.setNumUsp(rs.getInt("numUsp"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUnidade(Unidade.fromInt(rs.getInt("unidade")));
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

		return usuarios;
	}
}
