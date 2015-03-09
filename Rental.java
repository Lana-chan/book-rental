class Livro {
  private int id;
  private String titulo;
  private String autor;
  
  void carregaLivro() throws Exception {
    FileInputStream fis = new FileInputStream(id + ".dat");
    // carregar arquivo
  }
  
  void salvaLivro() throws Exception {
    FileOutputStream fos = new FileOutputStream(id + ".dat");
    // escrever arquivo
  }
  
  void setLivro(int id, String titulo, String autor) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
  }
}

public class Rental {
  public static void main(String[] args) {
  
  }
}