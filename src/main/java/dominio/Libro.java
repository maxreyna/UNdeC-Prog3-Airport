package dominio;

public class Libro {
    private long id;
    private String ISBN;
    private String titulo;
    private String autor;
    private int anioEdicion;
    private String editorial;
    private int paginas;
    private double precio;

    public static Libro instaciaLibro(long id, String ISBN, String titulo, String autor, int anioEdicion, String editorial, int paginas, double precio) {
        return new Libro(id,ISBN,titulo,autor,anioEdicion,editorial,paginas,precio);
    }

    private Libro(Long id, String ISBN, String titulo, String autor, int anioEdicion, String editorial, int paginas, double precio) {
        this.id = id;
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
        this.editorial = editorial;
        this.paginas = paginas;
        this.precio = precio;
    }
}
