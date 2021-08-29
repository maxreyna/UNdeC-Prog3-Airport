package casosdeuso;

import repositorio.IBuscarAuto;

public class BuscarAutoCU {
    private IBuscarAuto iBuscarAuto;

    public BuscarAutoCU(IBuscarAuto iBuscarAuto) {
        this.iBuscarAuto = iBuscarAuto;
    }

    public boolean buscarAuto(String marca) {
        boolean autoEncontrado = iBuscarAuto.buscarAutoPorMarca(marca);
        return autoEncontrado;
    }
}
