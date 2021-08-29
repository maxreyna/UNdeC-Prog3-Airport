package testcasodeuso;


import casosdeuso.BuscarAutoCU;
import dominio.Auto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ILeerAuto;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

public class TestCULecturaAuto {
    @Mock
    ILeerAuto iLeerAuto;
    @Test
    @Order(1)

    public void test01_AutoExisteYEsLeido(){
        //arrange
        Auto a1 = Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6","5", "ab 123 cd", "2017");

        //act
        Mockito.when(iLeerAuto.buscarAutoPorMarca("Peugeot")).thenReturn(true);
        BuscarAutoCU simularBusquedaAuto = new BuscarAutoCU(iLeerAuto);

        //assert
        assertTrue(simularBusquedaAuto.buscarAuto("Peugeot"));
    }
}
