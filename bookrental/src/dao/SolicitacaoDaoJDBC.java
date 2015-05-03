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
	public void adiciona_(Solicitacao soliciatcao) {
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
	public void atualiza_(Solicitacao solicitacao) {
		Connection connection = connectionFactory.getConnection();
		String sql = "update solicitacao set proprietario=? where ISBN=?";
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
	
	//mostra lista de solicitacoes do exemplar
	@Override
	public List<Solicitacao> buscaPorExemplar_(Exemplar exemplar){
		Connection connection = new JDBCConnectionFactory().getConnection();
		PreparedStatement stmt;
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		
		try {
			stmt = connection.prepareStatement("SELECT (doador, receptor, mensagem) FROM Solicitacoes WHERE exemplar="+
									"(SELECT id FROM exemplar WHERE livro=?, proprietario=?, foto=?)");
			stmt.setLong(1, exemplar.getLivro().getISBN());
			stmt.setInt(2, exemplar.getProprietario().getNumUsp());
			stmt.setString(3, exemplar.getFoto());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Solicitacao solicitacao = new Solicitacao();
				solicitacao.getDoador().setNumUsp(rs.getInt("doador"));;
				solicitacao.getReceptor().setNumUsp(rs.getInt("receptor"));
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