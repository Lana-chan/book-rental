package entidades;

public class Avaliacao {
	
	private int id;
	private int nota;
	private String comentario;
	private Usuario critico;
	private Usuario receptor;
	
	public Avaliacao(int nota, String comentario, Usuario critico, Usuario receptor){
		setNota(nota);
		setComentario(comentario);
		setCritico(critico);
		setReceptor(receptor);
	}
	
	
	public Avaliacao() {
		// TODO Auto-generated constructor stub
	}

	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	public int getId() {return this.id;}
	
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Usuario getCritico() {
		return critico;
	}

	public void setCritico(Usuario critico) {
		this.critico = critico;
	}
	
	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
}