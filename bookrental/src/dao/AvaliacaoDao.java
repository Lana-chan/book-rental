package dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Avaliacao;
import entidades.Exemplar;
import entidades.Usuario;

public abstract class AvaliacaoDao {
	public AvaliacaoDao() {
		
	}

	//adiciona avaliacoes ao banco
	public void adiciona(Avaliacao avaliacao) {
		if (avaliacao == null) {
			throw new IllegalArgumentException("Par�metro avaliacao n�o pode ser nulo.");
		}

		adiciona_(avaliacao);
	}
	protected abstract void adiciona_(Avaliacao avaliacao);
	
	//Atualiza a Avaliacao
	public void atualiza(Avaliacao avaliacao) {
		if (avaliacao == null) {
			throw new IllegalArgumentException("Par�metro avaliacao n�o pode ser nulo.");
		}
		
		if (avaliacao.getId() == 0) {
			throw new IllegalArgumentException("Avalia��o n�o possui ID.");
		}

		atualiza_(avaliacao);
	}
	protected abstract void atualiza_(Avaliacao avaliacao);

	//Remove avaliacao
	public void remove(Avaliacao avaliacao) {
		if (avaliacao == null) {
			throw new IllegalArgumentException("Par�metro avaliacao n�o pode ser nulo.");
		}

		if (avaliacao.getId() == 0) {
			throw new IllegalArgumentException("Avalia��o n�o possui ID.");
		}

		remove_(avaliacao);
	}
	protected abstract void remove_(Avaliacao avaliacao);

	//Busca por receptor
	public List<Avaliacao> buscaPorReceptor(Usuario receptor) {
		if (receptor == null) {
			throw new IllegalArgumentException("Par�metro receptor n�o pode ser nulo.");
		}
		
		if (receptor.getNumUsp() == 0) {
			throw new IllegalArgumentException("Exemplar n�o possui NumUSP.");
		}

		return buscaPorReceptor_(receptor.getNumUsp());
	}
	protected abstract List<Avaliacao> buscaPorReceptor_(int receptor);

}
