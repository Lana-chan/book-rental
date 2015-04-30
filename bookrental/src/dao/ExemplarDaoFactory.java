package dao;

import util.Propriedades;

public class ExemplarDaoFactory {

	private String nomeClasseDAO;

	public ExemplarDaoFactory() {
		nomeClasseDAO = new Propriedades().getPropriedade("exemplarDao");
	}

	public ExemplarDao getInstance() {
		try {
			return (ExemplarDao) Class.forName(nomeClasseDAO).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
