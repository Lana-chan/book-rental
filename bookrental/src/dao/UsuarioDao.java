package dao;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Usuario;

public abstract class UsuarioDao {

	final Collator comparadorDeStrings = Collator.getInstance();

	public UsuarioDao() {
		// Isto Ž para ignorar os acentos nas compara�›es de Strings
		comparadorDeStrings.setStrength(Collator.NO_DECOMPOSITION);
	}

	public void adiciona(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario não pode ser nulo.");
		}

		if (usuario.getNumUsp() == 0) {
			throw new IllegalArgumentException("Não é possivel adicionar um usuario sem NUSP.");
		}

		if (buscaPorNumUsp(usuario.getNumUsp()) != null) {
			throw new IllegalArgumentException("Já existe um usuario com o NUSP " + usuario.getNumUsp()
					+ " na base de dados.");
		}

		adiciona_(usuario);
	}

	protected abstract void adiciona_(Usuario usuario);

	public void atualiza(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario não pode ser nulo.");
		}

		if (usuario.getNumUsp() == 0) {
			throw new IllegalArgumentException("Não é possível atualizar um usuario sem NUSP.");
		}

		if (buscaPorNumUsp(usuario.getNumUsp()) == null) {
			throw new IllegalArgumentException("Não existe usuario com o NUSP " + usuario.getNumUsp() + " na base de dados.");
		}

		atualiza_(usuario);
	}

	protected abstract void atualiza_(Usuario usuario);

	public Usuario buscaPorNumUsp(int numero) {
		if (numero == 0) {
			throw new IllegalArgumentException("Parâmetro NUSP não pode ser nulo.");
		}

		return buscaPorNumUsp_(numero);
	}

	protected abstract Usuario buscaPorNumUsp_(int numero);

	public void remove(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Parâmetro usuario não pode ser nulo.");
		}

		if (usuario.getNumUsp() == 0) {
			throw new IllegalArgumentException("Não é possível remover um usuario sem NUSP.");
		}

		if (buscaPorNumUsp(usuario.getNumUsp()) == null) {
			throw new IllegalArgumentException("Não existe usuario com o NUSP " + usuario.getNumUsp() + " na base de dados.");
		}

		remove_(usuario);
	}

	protected abstract void remove_(Usuario usuario);

	public List<Usuario> listaTodosOrdenandoPorNome() {
		List<Usuario> usuarios = listaTodos();

		Collections.sort(usuarios, new Comparator<Usuario>() {

			@Override
			public int compare(Usuario o1, Usuario o2) {
				return comparadorDeStrings.compare(o1.getNome(), o2.getNome());
			}
		});

		return usuarios;
	}

	public List<Usuario> listaTodosOrdenandoPorNumUsp() {
		List<Usuario> usuarios = listaTodos();

		Collections.sort(usuarios, new Comparator<Usuario>() {

			@Override
			public int compare(Usuario o1, Usuario o2) {
				return o1.getNumUsp() - o2.getNumUsp();
			}
		});

		return usuarios;
	}

	public abstract List<Usuario> listaTodos();
}
