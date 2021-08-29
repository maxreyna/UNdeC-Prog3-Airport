package dominio;

import exceptions.*;

public class Auto {
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private String cilindrada;
    private String puerta;
    private String patente;
    private String anio;

    public Auto(int id, String marca, String modelo, String color, String cilindrada,String puerta, String patente, String anio) {
        this.id = id;
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.cilindrada=cilindrada;
        this.puerta = puerta;
        this.patente=patente;
        this.anio=anio;
    }


    public static Auto instanciaAuto(int id, String marca, String modelo, String color, String cilindrada,String puerta, String patente, String anio) throws ExceptionAuto {
        if  (marca.equals("") || modelo.equals("") || cilindrada.equals("") || puerta.equals("") || patente.equals("") || anio.equals("") )
            throw new ExceptionAutoAtributoVacio("Error: Solo el campo color puede estar vacio ");
        if (marca == null)
            throw new ExceptionAutoMarcaNulo("Error: El campo marca no debe ser nulo");
        if (modelo == null)
            throw new ExceptionAutoModeloNulo("Error: El campo modelo no debe ser nulo");
        if (color == null)
            throw new ExceptionAutoColorNulo("Error: El campo color no debe ser nulo");
        if (cilindrada == null)
            throw new ExceptionAutoCilindradaNulo("Error: El campo cilindrada no debe ser nulo");
        if (puerta == null)
            throw new ExceptionAutoPuertaNulo("Error: El campo puerta no debe ser nulo");
        if (patente == null)
            throw new ExceptionAutoPatenteNulo("Error: El campo patente no debe ser nulo");
        if (anio == null)
            throw new ExceptionAutoAnioNulo("Error: El campo anio no debe ser nulo");
        return new Auto(id,marca, modelo, color, cilindrada,puerta, patente, anio);
    }
}
