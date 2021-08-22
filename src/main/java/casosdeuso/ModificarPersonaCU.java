package casosdeuso;

import dominio.Persona;
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

public class ModificarPersonaCU {
    private IModificarPersona iModificarPersona;
    private ITraerPersona iTraerPersona;

    public ModificarPersonaCU( ITraerPersona iTraerPersona, IModificarPersona iModificarPersona) {
        this.iModificarPersona = iModificarPersona;
        this.iTraerPersona = iTraerPersona;
    }

    public boolean modificarPesoPersona(int dni,double nuevoPeso) {
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.setPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }
}
