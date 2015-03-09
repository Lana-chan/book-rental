class Livro {
  private int id;
  private String titulo;
  private String autor;
  
  String toString() {
    reutrn id + ": " + this.titulo;
  }
  
  void carregaLivro(int id) throws Exception {
    FileInputStream fis = new FileInputStream(id + ".dat");
    // carregar arquivo
    byte[] bytes = 
  }
  
  void salvaLivro() throws Exception {
    FileOutputStream fos = new FileOutputStream(this.id + ".dat");
    // escrever arquivo
  }
  
   // construtores
  public Livro(int id, String titulo, String autor) {
    this.id = id;
    this.titulo = formata(titulo,50);
    this.autor = formata(autor,50);
  }
  
  public Livro(int id) {
    //apenas ID, carrega de arquivo
    carregaLivro(id);
  }
  
  // getters
  int getId() {
    return this.id;
  }
  
  String getTitulo() {
    return this.titulo;
  }
  
  String getAutor() {
    return this.autor;
  }
}

public class Rental {
  public static void main(String[] args) {
    Livro l1 = new Livro(1,"blah","autor");
    l1.salvaLivro();
    System.out.println(new Livro(1));
  }
  
  public String formata(String inp, int len) {
    String out = new String(len);
    if(inp.length() > len) {
      // truncar para len
    } else {
      // completar até len
    }
}