package dao;

import util.Propriedades;

public class AvaliacaoDaoFactory {

	private String nomeClasseDAO;

	public AvaliacaoDaoFactory() {
		nomeClasseDAO = new Propriedades().getPropriedade("avaliacaoDao");
	}

	public AvaliacaoDao getInstance() {
		try {
			return (AvaliacaoDao) Class.forName(nomeClasseDAO).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
