import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Livro {
	private long id;
	private String autor; // deveria ser uma lista de autores
	private String titulo;
	private int paginas;
	private long ISBN;
	private double peso;
	private double largura;
	private double altura;
	private double profundidade;
	private int ano;
	private String editora; // deveria ser um objeto Editora contendo infos da editora
	//private String pais;
	//private String idioma;

	public Livro(long id, String autor, String titulo, String editora) {
		super();
		this.id = id;
		setAutor(autor);
		setTitulo(titulo);
		setEditora(editora);
	}

	// carrega o objeto Livro do arquivo "id.dat"
	public Livro(long id) throws Exception {	
		try {
			BufferedWriter arq = new FileReader(id + ".txt");
			
			String linha = arq.readLine();
            this.autor = new String(linha);

			linha = arq.readLine();
			this.titulo = new String(linha);

			linha = arq.readLine();
			this.editora = new String(linha);
			
            arq.close();
        } catch (IOException e) {
            System.err.println("D: não creio que deu erro D:");
        }
	}

	// completa com espaços em branco até completar 50 caracteres
	private String formata(String str) {
		StringBuffer buff = new StringBuffer(str);
		while (buff.length() < 50) {
			buff.append(" ");
		}

		return buff.toString();
	}

	public long getId() { return id; }
	
	public void setId(long id) { this.id = id; }

	public String getAutor() { return autor; }

	// dentro do setter já formata
	public void setAutor(String autor) { this.autor = formata(autor); }

	public String getTitulo() { return titulo; }

	// dentro do setter já formata
	public void setTitulo(String titulo) { this.titulo = formata(titulo); }

	public String getEditora() { return editora; }

	// dentro do setter já formata
	public void setEditora(String editora) { this.editora = formata(editora); }

	
	// salva o objeto livro em um arquivo texto "id.txt"
	void salvaTxt() throws Exception {
		Writer arq = new BufferedWriter(new OutputStreamWriter(
					 new FileOutputStream(id + ".txt"), "utf-8"));
		arq.write(autor);
		arq.write(titulo);
		arq.write(editora);
		arq.close();
	}

	// sobrecrevemos o método "toString" para imprimir o objeto Livro no console
	@Override
	public String toString() {
		return "Autor: " + this.autor + "\n" + "Título: " + this.titulo + "\n" + "Editora: " + this.editora + "\n";
	}

	// método "main" para testar nosso código
	public static void main(String[] args) throws Exception {
		Livro l1 = new Livro(1, "Paulo Coelho", "Brida", "Editora Abril");
		Livro l2 = new Livro(2, "Paulo Coelho", "O Alquimista", "Editora Abril");
		Livro l3 = new Livro(3, "Paulo Coelho", "Diário de um mago", "Editora Abril");

		// salva os 3 objetos do tipo Livro em seus respectivos arquivos
		l1.salvaTxt();
		l2.salvaTxt();
		l3.salvaTxt();

		// lê cada arquivo salvo anteriormente e carrega o respectivo objeto
		// Livro na memória, para logo em seguida implimi-lo no console
		System.out.println(new Livro(1));
		System.out.println(new Livro(2));
		System.out.println(new Livro(3));
	}

	/*
	 * EXERCÍCIO PARA A PRÓXIMA AULA:
	 * 
	 * + incluir campos de outros tipos (que não sejam Strings) na classe Livro (edição, número de páginas, etc...)
	 * 
	 * + reescrever os métodos de acesso a arquivos utilizando arquivos de texto
	 * ao invés de arquivos binários
	 * 
	 * - reescrever os métodos de acesso a arquivos utilizando as classes
	 * ObjectInputStream e ObjectOutputStream
	 * 
	 * - fazer uma crítica a esta classe Livro, do ponto de vista de Orientação
	 * a Objetos. Pense em qual seria a forma "ideal" de implementar essas
	 * mesmas funcionalidades, porém favorecendo a organização, reuzabilidade,
	 * baixo acoplamento, facilidade de manutenção, etc...
	 */

}
