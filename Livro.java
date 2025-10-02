package Biblioteca;

public class Livro implements Emprestavel {
    private String codigo;
    private String titulo;
    private String autor;
    private String status;

    public Livro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.status = "DISPONÍVEL";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void emprestar(Usuario u) {
        if ("DISPONÍVEL".equals(status)) {
            status = "EMPRESTADO";
        } else {
            System.out.println("Livro já emprestado.");
        }
    }

    @Override
    public void devolver() {
        status = "DISPONÍVEL";
    }
}
