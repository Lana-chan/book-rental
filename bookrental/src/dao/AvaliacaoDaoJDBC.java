package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Avaliacao;

public class AvaliacaoDaoJDBC extends AvaliacaoDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Avaliacao avaliacao) {
		Connection connection = connectionFactory.getConnection();
		String sql = "insert into avaliacao (nota, comentario, critico, receptor) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getComentario());
			stmt.setInt(3, avaliacao.getCritico().getNumUsp());
			stmt.setInt(4, avaliacao.getReceptor().getNumUsp());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualiza_(Avaliacao avaliacao) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update avaliacao set nota=?, comentario=?, critico=?, receptor=?, where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, avaliacao.getNota());
			stmt.setString(2, avaliacao.getComentario());
			stmt.setInt(3, avaliacao.getCritico().getNumUsp());
			stmt.setInt(4, avaliacao.getReceptor().getNumUsp());
			stmt.setInt(5, avaliacao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
	//mostra avaliacoes recebidas por alguem
	@Override
	public List<Avaliacao> buscaPorReceptor_(int receptor){
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		
		try {
			stmt = connection.prepareStatement("SELECT (nota, comentario, critico) FROM solicitacao WHERE receptor=?");
			/*stmt.setLong(1, exemplar.getLivro().getISBN());
			stmt.setInt(2, exemplar.getProprietario().getNumUsp());
			stmt.setString(3, exemplar.getFoto());*/
			stmt.setInt(1, receptor);
			ResultSet rs = stmt.executeQuery();

			UsuarioDao usuarioDao = new UsuarioDaoFactory().getInstance();
			
			if (rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setComentario(rs.getString("comentario"));
				avaliacao.setCritico(usuarioDao.buscaPorNumUsp(rs.getInt("critico")));
				avaliacao.setReceptor(usuarioDao.buscaPorNumUsp(receptor));
				
				avaliacoes.add(avaliacao);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
		return avaliacoes;
	}


	@Override
	public void remove_(Avaliacao avaliacao) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("delete from avaliacao where id=?");
			stmt.setInt(1, avaliacao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
}
