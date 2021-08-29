package testcasodeuso;


import casosdeuso.BuscarAutoCU;
import dominio.Auto;
import exceptions.ExceptionAuto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarAuto;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

public class TestCULecturaAuto {
    @Mock
    IBuscarAuto iBuscarAuto;
    @Test
    @Order(1)

    public void test01_AutoExisteYEsLeido() throws ExceptionAuto {
        //arrange
        Auto a1 = Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6","5", "ab 123 cd", "2017");

        //act
        Mockito.when(iBuscarAuto.buscarAutoPorMarca("Peugeot")).thenReturn(true);
        BuscarAutoCU simularBusquedaAuto = new BuscarAutoCU(iBuscarAuto);

        //assert
        assertTrue(simularBusquedaAuto.buscarAuto("Peugeot"));
    }
}
