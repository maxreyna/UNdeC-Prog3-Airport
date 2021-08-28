package dominio;

import exceptions.*;

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

        if(altura <= 0 ){
            throw new ExceptionPersonaAlturaIncorrecto("Error: El campo altura no puede ser negativa y tampoco cero");
        }

        if (peso <= 0){
            throw new ExceptionPersonaPesoIncorrecto("Error: El campo peso no puede ser negativo y tampoco cero");
        }


        if (Integer.toString(dni).length() < 7){
            throw new ExceptionPersonaDniIncorrecto("Error: Numero de dni muy corto");
        }

        return new Persona( id, nombre, apellido, altura, peso, dni, fechaNac);
    }

    public String getDni() {
        return Integer.toString(dni);
    }

    public int getDniInt() {
        return dni;
    }

    private void setPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }

    public double getPeso() {
        return this.peso;
    }

    private void setAltura(double nuevaAltura) {
        this.altura=nuevaAltura;
    }

    public double getAltura() {
        return this.altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean actualizarDatos(Persona personaActualizada) {
        setNombre(personaActualizada.getNombre());
        setApellido(personaActualizada.getApellido());
        setAltura(personaActualizada.getAltura());
        setPeso(personaActualizada.getPeso());

        return true;
    }

    public void actualizarPeso(double pesoActualizado) throws ExceptionPersona {
        this.actualizarDatos(Persona.instaciaPersona(id,nombre,apellido,altura,pesoActualizado,dni,fechaNac));
    }

    public void actualizarAltura(double alturaActualizada) throws ExceptionPersona{
        this.actualizarDatos(Persona.instaciaPersona(id,nombre,apellido,alturaActualizada,peso,dni,fechaNac));
    }


    //aca programar la clase
    //agregar metodo instanciaPersona
}
