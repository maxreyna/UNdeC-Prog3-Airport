package casosdeuso;

import repositorio.ILeerAuto;

public class BuscarAutoCU {
    private ILeerAuto iLeerAuto;

    public BuscarAutoCU(ILeerAuto iLeerAuto) {
        this.iLeerAuto = iLeerAuto;
    }

    public boolean buscarAuto(String marca) {
        boolean autoEncontrado = iLeerAuto.buscarAutoPorMarca(marca);
        return autoEncontrado;
    }
}
