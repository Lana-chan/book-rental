package dao;

import util.Propriedades;

public class SolicitacaoDaoFactory {

	private String nomeClasseDAO;

	public SolicitacaoDaoFactory() {
		nomeClasseDAO = new Propriedades().getPropriedade("solicitacaoDao");
	}

	public SolicitacaoDao getInstance() {
		try {
			return (SolicitacaoDao) Class.forName(nomeClasseDAO).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
