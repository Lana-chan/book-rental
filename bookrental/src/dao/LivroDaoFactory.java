package dao;

import util.Propriedades;

public class LivroDaoFactory {

	private String nomeClasseDAO;

	public LivroDaoFactory() {
		nomeClasseDAO = new Propriedades().getPropriedade("livroDao");
	}

	public LivroDao getInstance() {
		try {
			return (LivroDao) Class.forName(nomeClasseDAO).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
