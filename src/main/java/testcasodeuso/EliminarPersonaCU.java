package testcasodeuso;

import exceptions.ExceptionPersonaNoEncontrada;
import repositorio.IEliminarPersona;
import repositorio.ILeerPersona;

public class EliminarPersonaCU {
    private ILeerPersona iLeerPersona;
    private IEliminarPersona iEliminarPersona;

    public EliminarPersonaCU(ILeerPersona iLeerPersona, IEliminarPersona iEliminarPersona) {
        this.iLeerPersona = iLeerPersona;
        this.iEliminarPersona = iEliminarPersona;
    }

    public boolean darDeBajaPersona(String dniPersonaAEliminar) throws ExceptionPersonaNoEncontrada {
        if(!iLeerPersona.buscarPersonaPorDni(dniPersonaAEliminar)){
            throw new ExceptionPersonaNoEncontrada("La persona no se encuentra en la BD");
        }
        return iEliminarPersona.darBajaPersona(dniPersonaAEliminar);
    }
}
