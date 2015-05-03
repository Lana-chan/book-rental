package dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entidades.Solicitacao;
import entidades.Exemplar;
import entidades.Usuario;

public abstract class SolicitacaoDao {
	public SolicitacaoDao() {
		
	}

	//adiciona solicitacaoes ao banco
	public void adiciona(Solicitacao solicitacao) {
		if (solicitacao == null) {
			throw new IllegalArgumentException("Par�metro solicitacao n�o pode ser nulo.");
		}

		adiciona_(solicitacao);
	}
	protected abstract void adiciona_(Solicitacao solicitacao);
	
	//Atualiza a Solicitacao
	public void atualiza(Solicitacao solicitacao) {
		if (solicitacao == null) {
			throw new IllegalArgumentException("Par�metro solicitacao n�o pode ser nulo.");
		}
		
		if (solicitacao.getId() == 0) {
			throw new IllegalArgumentException("Solicita��o n�o possui ID.");
		}

		atualiza_(solicitacao);
	}
	protected abstract void atualiza_(Solicitacao solicitacao);

	//Remove solicitacao
	public void remove(Solicitacao solicitacao) {
		if (solicitacao == null) {
			throw new IllegalArgumentException("Par�metro solicitacao n�o pode ser nulo.");
		}

		if (solicitacao.getId() == 0) {
			throw new IllegalArgumentException("Solicita��o n�o possui ID.");
		}

		remove_(solicitacao);
	}
	protected abstract void remove_(Solicitacao solicitacao);

	//Busca por exemplar
	public List<Solicitacao> buscaPorExemplar(Exemplar exemplar) {
		if (exemplar == null) {
			throw new IllegalArgumentException("Par�metro exemplar n�o pode ser nulo.");
		}
		
		if (exemplar.getId() == 0) {
			throw new IllegalArgumentException("Exemplar n�o possui ID.");
		}

		return buscaPorExemplar_(exemplar);
	}
	protected abstract List<Solicitacao> buscaPorExemplar_(Exemplar exemplar);

}
