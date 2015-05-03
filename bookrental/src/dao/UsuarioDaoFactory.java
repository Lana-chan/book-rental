package dao;

import util.Propriedades;

public class UsuarioDaoFactory {

	private String nomeClasseDAO;

	public UsuarioDaoFactory() {
		nomeClasseDAO = new Propriedades().getPropriedade("usuarioDao");
	}

	public UsuarioDao getInstance() {
		try {
			return (UsuarioDao) Class.forName(nomeClasseDAO).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
