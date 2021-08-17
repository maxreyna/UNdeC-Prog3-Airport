package casosdeuso;

import dominio.Persona;
import repositorio.ILeerPersona;

public class BuscarPersonaCU {
    private ILeerPersona iLeerPersonaCU;

    public BuscarPersonaCU(ILeerPersona iLeerPersona) {
        this.iLeerPersonaCU = iLeerPersona;
    }

    public boolean buscarPersona(String dniPersonaBuscada) {
        boolean personaEncontrada = iLeerPersonaCU.buscarPersonaPorDni(dniPersonaBuscada);

        return personaEncontrada;
    }
}
