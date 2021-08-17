package casosdeuso;

import dominio.Persona;
import exceptions.ExceptionPersonaExiste;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

public class GuardarPersonaCU {
    private IGuardarPersona iGuardarPersonaCU;
    private ILeerPersona iLeerPersonaCU;

    public GuardarPersonaCU(IGuardarPersona iGuardarPersona, ILeerPersona iLeerPersona) {
        this.iGuardarPersonaCU = iGuardarPersona;
        this.iLeerPersonaCU = iLeerPersona;
    }

    public boolean cargarPersona(Persona p1) throws ExceptionPersonaExiste {
        if(iLeerPersonaCU.buscarPersonaPorDni(p1.getDni())){
            throw new ExceptionPersonaExiste("La persona buscada ya se encuentra en la BD");
        }
        return iGuardarPersonaCU.guardarPersona(p1);
    }
}
