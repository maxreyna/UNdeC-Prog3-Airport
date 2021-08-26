package dominio;

import exceptions.ExceptionPersonaAlturaIncorrecto;
import exceptions.ExceptionPersonaAtributoNulo;
import exceptions.ExceptionPersonaDniIncorrecto;
import exceptions.ExceptionPersonaPesoIncorrecto;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

public class Persona {


    private int id;
    private String nombre;
    private String apellido;
    private double altura;
    private double peso;
    private int dni;
    private LocalDate fechaNac;

    public Persona(int id, String nombre, String apellido, double altura, double peso, int dni, LocalDate fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    public static Persona instaciaPersona(int id, String nombre, String apellido, double altura, double peso, int dni, LocalDate fechaNac) throws ExceptionPersonaAtributoNulo, ExceptionPersonaAlturaIncorrecto, ExceptionPersonaPesoIncorrecto, ExceptionPersonaDniIncorrecto {
        if(nombre == null || apellido == null ){
            throw new ExceptionPersonaAtributoNulo("Error: Los campos nombre, apellido, no pueden ser nulos");
        }

        if(altura < 0 ){
            throw new ExceptionPersonaAlturaIncorrecto("Error: La altura no puede ser negativa");
        }

        if(altura == 0 ){
            throw new ExceptionPersonaAlturaIncorrecto("Error: La altura no puede ser cero");
        }

        if (peso < 0){
            throw new ExceptionPersonaPesoIncorrecto("Error: El peso no puede ser negativo");
        }

        if (peso == 0){
            throw new ExceptionPersonaPesoIncorrecto("Error: El peso no puede ser cero");
        }

        if (Integer.toString(dni).length() < 7){
            throw new ExceptionPersonaDniIncorrecto("Error: Numero de dni muy corto");
        }

        return new Persona( id, nombre, apellido, altura, peso, dni, fechaNac);
    }

    public String getDni() {
        return Integer.toString(dni);
    }

    public void setPeso(double nuevoPeso) throws ExceptionPersonaPesoIncorrecto {
        this.peso = nuevoPeso;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setAltura(double nuevaAltura) {
        this.altura=nuevaAltura;
    }

    public double getAltura() {
        return this.altura;
    }


    //aca programar la clase
    //agregar metodo instanciaPersona
}
