package casosdeuso;

import dominio.Auto;
import exceptions.ExceptionAutoNoEncontrado;
import exceptions.ExceptionPersonaNoEncontrada;
import repositorio.ITraerAuto;

public class TraerAutoCU {
    private ITraerAuto iTraerAuto;

    public TraerAutoCU(ITraerAuto iTraerAuto) {
        this.iTraerAuto = iTraerAuto;
    }

    public Auto traerAuto(String patente) throws ExceptionAutoNoEncontrado {
        Auto autoEncontrado = iTraerAuto.dameAutoSegunPatente(patente);
        if(autoEncontrado == null){
            throw new ExceptionAutoNoEncontrado("El auto buscado no se encuentra en la BD");
        }
        return autoEncontrado;
    }
}
