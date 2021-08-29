package casosdeuso;

import repositorio.IBuscarAuto;

public class BuscarAutoCU {
    private  IBuscarAuto iBuscarAuto;

    public BuscarAutoCU(IBuscarAuto iBuscarAuto) {
        this.iBuscarAuto = iBuscarAuto;
    }

    public boolean buscarAuto(String marca) {
        return iBuscarAuto.buscarAutoPorMarca(marca);
    }
}
