package testcasodeuso;

import repositorio.IEliminarPersona;
import repositorio.ILeerPersona;

public class EliminarPersonaCU {
    private ILeerPersona iLeerPersona;
    private IEliminarPersona iEliminarPersona;

    public EliminarPersonaCU(ILeerPersona iLeerPersona, IEliminarPersona iEliminarPersona) {
        this.iLeerPersona = iLeerPersona;
        this.iEliminarPersona = iEliminarPersona;
    }

    public boolean darDeBajaPersona(String dniPersonaAEliminar) {
        if(!iLeerPersona.buscarPersonaPorDni(dniPersonaAEliminar))
            return false;
        return iEliminarPersona.darBajaPersona(dniPersonaAEliminar);
    }
}
