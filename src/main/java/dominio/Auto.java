package dominio;

public class Auto {
    private String marca;
    private String modelo;
    private String color;
    private String cilindrada;
    private String patente;
    private String anio;

    public Auto(String marca, String modelo, String color, String cilindrada, String patente, String anio) {
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.cilindrada=cilindrada;
        this.patente=patente;
        this.anio=anio;
    }


    public static Auto instanciaAuto(String marca, String modelo, String color, String cilindrada, String patente, String anio) {
        return new Auto(marca, modelo, color, cilindrada, patente, anio);
    }
}
