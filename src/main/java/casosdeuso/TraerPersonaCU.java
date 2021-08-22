package casosdeuso;

import dominio.Persona;
import exceptions.ExceptionPersonaNoEncontrada;
import repositorio.ITraerPersona;

public class TraerPersonaCU {
    private ITraerPersona iTraerPersona;

    public TraerPersonaCU(ITraerPersona iTraerPersona) {
        this.iTraerPersona = iTraerPersona;
    }

    public Persona traerPersona(int dniBuscado) throws ExceptionPersonaNoEncontrada {
        Persona personaEncontrada = iTraerPersona.damePersonaSegunDni(dniBuscado);
        if(personaEncontrada == null){
            throw new ExceptionPersonaNoEncontrada("La persona buscada no se encuentra en la BD");
        }
        return personaEncontrada;
    }
}
