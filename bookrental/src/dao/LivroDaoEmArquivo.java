package dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import entidades.Livro;
import util.StringUtils;

public class LivroDaoEmArquivo extends LivroDao {

	private static final int TAMANHO_CAMPO = 50;
	private static final char CARACTER_NULO = '*';
	private static final String ARQUIVO_DE_LIVROS = "Livros.dat";
	private byte[] bytes = new byte[TAMANHO_CAMPO];
	private RandomAccessFile raf;
	private HashMap<String, Long> mapaRegistroPonteiro = new HashMap<String, Long>();

	public LivroDaoEmArquivo() {
		abreFluxo();

		try {
			while (raf.getFilePointer() < raf.length() - 1L) {
				long ponteiro = raf.getFilePointer();
				Livro livro = leRegistro();
				mapaRegistroPonteiro.put(livro.getTitulo(), ponteiro);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		fechaFluxo();
	}

	private void fechaFluxo() {
		if (raf != null) {
			try {
				raf.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private void abreFluxo() {
		try {
			raf = new RandomAccessFile(new File(ARQUIVO_DE_LIVROS), "rw");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private void escreveCampo(String str) {
		try {
			raf.write(StringUtils.fillOrTruncate(str, TAMANHO_CAMPO, CARACTER_NULO).getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void escreveRegistro(Livro livro) {
		escreveCampo(livro.getTitulo());
		escreveCampo(livro.getAutor());
		escreveCampo(livro.getEditora());
	}

	private String leCampo() {
		try {
			raf.read(bytes);
			return new String(bytes).replaceAll("\\" + CARACTER_NULO, "");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Livro leRegistro() {
		Livro livro = new Livro();

		// l todos os campos
		livro.setTitulo(leCampo());
		livro.setAutor(leCampo());
		livro.setEditora(leCampo());
		return livro;
	}

	private void posicionaPonteiro(long posicao) {
		try {
			raf.seek(posicao);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Long posicionaPonteiroNoFinal() {
		try {
			raf.seek(raf.length());
			return raf.getFilePointer();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void adiciona_(Livro livro) {
		abreFluxo();
		mapaRegistroPonteiro.put(livro.getTitulo(), posicionaPonteiroNoFinal());
		escreveRegistro(livro);
		fechaFluxo();
	}

	@Override
	public Livro buscaPorTitulo_(String titulo) {
		Long ponteiroArquivo = mapaRegistroPonteiro.get(titulo);

		if (ponteiroArquivo == null) {
			return null;
		}

		abreFluxo();
		posicionaPonteiro(ponteiroArquivo);
		Livro livro = leRegistro();
		fechaFluxo();
		return livro;
	}

	@Override
	public void atualiza_(Livro livro) {
		throw new UnsupportedOperationException("Este DAO n‹o implementa a opera‹o atualiza.");
	}

	@Override
	public void remove_(Livro livro) {
		throw new UnsupportedOperationException("Este DAO n‹o implementa a opera‹o remove.");
	}

	@Override
	public List<Livro> listaTodos() {
		LinkedList<Livro> livros = new LinkedList<Livro>();
		abreFluxo();
		
		for(Long ponteiroArquivo: mapaRegistroPonteiro.values()) {
			posicionaPonteiro(ponteiroArquivo);
			livros.add(leRegistro());
		}
		
		fechaFluxo();
		return livros;
	}
}
