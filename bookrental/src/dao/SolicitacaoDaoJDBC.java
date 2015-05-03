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

public class SolicitacaoDaoJDBC extends SolicitacaoDao {

	private JDBCConnectionFactory connectionFactory = new JDBCConnectionFactory();

	@Override
	public void adiciona_(Solicitacao solicitacao) {
		Connection connection = connectionFactory.getConnection();
		String sql = "insert into solicitacao (exemplar, doador, receptor, mensagem) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, solicitacao.getExemplar().getId());
			stmt.setInt(2, solicitacao.getDoador().getNumUsp());
			stmt.setInt(3, solicitacao.getReceptor().getNumUsp());
			stmt.setString(4, solicitacao.getMensagem());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}

	@Override
	public void atualiza_(Solicitacao solicitacao) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update solicitacao set exemplar=?, doador=?, receptor=?, mensagem=?, solicitacaoDeferida=?, confirmaEntregaReceptor=?, confirmaEntregaDoador=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, solicitacao.getExemplar().getId());
			stmt.setInt(2, solicitacao.getDoador().getNumUsp());
			stmt.setInt(3, solicitacao.getReceptor().getNumUsp());
			stmt.setString(4, solicitacao.getMensagem());
			stmt.setBoolean(5, solicitacao.getSolicitacaoDeferida());
			stmt.setBoolean(6, solicitacao.getConfirmaEntregaReceptor());
			stmt.setBoolean(7, solicitacao.getConfirmaEntregaDoador());
			stmt.setInt(8, solicitacao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
	//mostra lista de solicitacoes do exemplar
	@Override
	public List<Solicitacao> buscaPorExemplar_(Exemplar exemplar){
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		
		try {
			stmt = connection.prepareStatement("SELECT (doador, receptor, mensagem) FROM solicitacao WHERE exemplar=?");
			/*stmt.setLong(1, exemplar.getLivro().getISBN());
			stmt.setInt(2, exemplar.getProprietario().getNumUsp());
			stmt.setString(3, exemplar.getFoto());*/
			stmt.setInt(1, exemplar.getId());
			ResultSet rs = stmt.executeQuery();

			UsuarioDao usuarioDao = new UsuarioDaoFactory().getInstance();
			
			if (rs.next()) {
				Solicitacao solicitacao = new Solicitacao();
				solicitacao.setId(rs.getInt("id"));
				solicitacao.setDoador(usuarioDao.buscaPorNumUsp(rs.getInt("doador")));
				solicitacao.setReceptor(usuarioDao.buscaPorNumUsp(rs.getInt("receptor")));
				solicitacao.setMensagem(rs.getString("mensagem"));
				
				solicitacoes.add(solicitacao);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
		return solicitacoes;
	}


	@Override
	public void remove_(Solicitacao solicitacao) {
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement("delete from solicitacao where id=?");
			stmt.setLong(1, solicitacao.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close(connection);
		}
	}
	
}
