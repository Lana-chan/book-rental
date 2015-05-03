package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import entidades.Unidade;
import entidades.Exemplar;
import entidades.Avaliacao;

public class UsuarioDaoJDBC extends UsuarioDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Usuario usuario) {
		Connection connection = connectionFactory.getConnection();
		String sql = "INSERT INTO usuarios (numUsp, nome, unidade, email, foto) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumUsp());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getUnidade().getValue());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getFoto());

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
		String sql = "UPDATE usuarios numUsp=?, nome=?, unidade=?, email=?, foto=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumUsp());
			stmt.setString(2, usuario.getNome());
			stmt.setInt(3, usuario.getUnidade().getValue());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getFoto());

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
				usuario.setFoto(rs.getString("foto"));
				
				ExemplarDao exemplarDao = new ExemplarDaoFactory().getInstance();
				List<Exemplar> colecao = exemplarDao.listaTodos(numUsp);
				//usuario.setColecao(colecao);
				//ExemplarDao avaliacaoDao = new AvaliacaoDaoFactory().getInstance();
				//List<Avaliacao> reputacao = avaliacaoDao.buscaPorUsuario(usuario);
				//usuario.setReputacao(colecao);
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

			ExemplarDao exemplarDao = new ExemplarDaoFactory().getInstance();
			//ExemplarDao AvaliacaoDao = new AvaliacaoDaoFactory().getInstance();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario = new Usuario();
				usuario.setNumUsp(rs.getInt("numUsp"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUnidade(Unidade.fromInt(rs.getInt("unidade")));
				usuario.setEmail(rs.getString("email"));
				usuario.setFoto(rs.getString("foto"));
				//usuario.set
				//List<Exemplar> colecao = exemplarDao.buscaPorUsuario(usuario);
				//usuario.setColecao(colecao);
				//List<Avaliacao> reputacao = avaliacaoDao.buscaPorUsuario(usuario);
				//usuario.setReputacao(colecao);
				
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
	
	
	public List<Avaliacao> listaReputacao(Usuario user) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Avaliacao> reputacao = new ArrayList<Avaliacao>();

		try {
			stmt = connection.prepareStatement("select (nota) from Exemplar where receptor=?");
			stmt.setInt(1, user.getNumUsp());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Avaliacao nota = new Avaliacao();
				nota.setNota(rs.getInt("nota"));
				reputacao.add(nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
		return reputacao;
	}
	
	
}
