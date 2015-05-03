package entidades;

public class Avaliacao {
	
	private static final long serialVersionUID = 1L;
	private int nota;
	private String comentario;
	private Usuario critico;
	
	public Avaliacao(){
		
	}
	
	public Avaliacao(int nota, String comentario, Usuario critico){
		setNota(nota);
		setComentario(comentario);
		setCritico(critico);
	}
	
	
	/*-------------------------------------------------------------------------------
	 * Getters e Setters
	 *------------------------------------------------------------------------------*/
	
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
}