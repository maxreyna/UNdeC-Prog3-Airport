package casosdeuso;

import dominio.Persona;
import exceptions.ExceptionPersonaPesoIncorrecto;
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

public class ModificarPersonaCU {
    private IModificarPersona iModificarPersona;
    private ITraerPersona iTraerPersona;

    public ModificarPersonaCU( ITraerPersona iTraerPersona, IModificarPersona iModificarPersona) {
        this.iModificarPersona = iModificarPersona;
        this.iTraerPersona = iTraerPersona;
    }

    public boolean modificarPesoPersona(int dni,double nuevoPeso) throws ExceptionPersonaPesoIncorrecto {
        if (nuevoPeso<0){
            throw new ExceptionPersonaPesoIncorrecto("El peso no puede ser negativo");
        }
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.setPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(int dni, double nuevaAltura) {
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.setAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }
}