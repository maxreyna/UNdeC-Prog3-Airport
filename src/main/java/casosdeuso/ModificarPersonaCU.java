package casosdeuso;

import dominio.Persona;
import exceptions.*;
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
        if(Integer.toString(dni).length() > 8){
            throw new ExceptionPersonaDniIncorrecto("Error: DNI incorrecto");
        }

        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);

        if(personaAModificar == null){
            throw new ExceptionPersonaNoEncontrada("La persona buscada no existe");
        }
        personaAModificar.actualizarPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(int dni, double nuevaAltura) throws ExceptionPersona {

        if(Integer.toString(dni).length() > 8){
            throw new ExceptionPersonaDniIncorrecto("Error: DNI incorrecto");
        }

        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        if(personaAModificar == null){
            throw new ExceptionPersonaNoEncontrada("La persona buscada no existe en la BD");
        }
        personaAModificar.actualizarAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }
}
