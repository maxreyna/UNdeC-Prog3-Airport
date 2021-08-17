package casosdeuso;

import dominio.Persona;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

public class GuardarPersonaCU {
    private IGuardarPersona iGuardarPersonaCU;
    private ILeerPersona iLeerPersonaCU;

    public GuardarPersonaCU(IGuardarPersona iGuardarPersona, ILeerPersona iLeerPersona) {
        this.iGuardarPersonaCU = iGuardarPersona;
        this.iLeerPersonaCU = iLeerPersona;
    }

    public boolean cargarPersona(Persona p1) {
        if(iLeerPersonaCU.buscarPersonaPorDni(p1.getDni())){
            return false;
        }
        return iGuardarPersonaCU.guardarPersona(p1);
    }
}
