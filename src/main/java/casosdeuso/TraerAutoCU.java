package casosdeuso;

import dominio.Auto;
import repositorio.ITraerAuto;

public class TraerAutoCU {
    private ITraerAuto iTraerAuto;

    public TraerAutoCU(ITraerAuto iTraerAuto) {
        this.iTraerAuto = iTraerAuto;
    }

    public Auto traerAuto(String patente) {
        Auto autoEncontrado = iTraerAuto.dameAutoSegunPatente(patente);
        return autoEncontrado;
    }
}
