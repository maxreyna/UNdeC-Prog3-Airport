package casosdeuso;

import dominio.Persona;
import repositorio.ITraerPersona;

public class TraerPersonaCU {
    private ITraerPersona iTraerPersona;

    public TraerPersonaCU(ITraerPersona iTraerPersona) {
        this.iTraerPersona = iTraerPersona;
    }

    public Persona traerPersona(String dniBuscado) {
        Persona personaEncontrada = iTraerPersona.damePersonaSegunDni(dniBuscado);
        return personaEncontrada;
    }
}
