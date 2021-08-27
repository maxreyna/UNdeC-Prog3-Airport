package casosdeuso;

import dominio.Persona;
import exceptions.ExceptionPersona;
import exceptions.ExceptionPersonaAlturaIncorrecto;
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

    public boolean modificarPesoPersona(int dni,double nuevoPeso) throws ExceptionPersona {
        if (nuevoPeso<0){
            throw new ExceptionPersonaPesoIncorrecto("El peso no puede ser negativo");
        }
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.actualizarPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(int dni, double nuevaAltura) throws ExceptionPersona {
        if (nuevaAltura<0){
            throw new ExceptionPersonaAlturaIncorrecto("La altura no puede ser negativa");
        }
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.actualizarAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }
}
