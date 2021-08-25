package testcasodeuso;

import casosdeuso.TraerAutoCU;
import casosdeuso.TraerPersonaCU;
import dominio.Auto;
import exceptions.ExceptionAuto;
import exceptions.ExceptionAutoNoEncontrado;
import exceptions.ExceptionPersona;
import exceptions.ExceptionPersonaNoEncontrada;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ITraerAuto;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class TestCUTraerAuto {
    @Mock
    ITraerAuto iTraerAuto;
    @Order(1)
    @Test
    public void test01_autoExisteYEsTraido() throws ExceptionAutoNoEncontrado {
        Auto a1 = Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6", "ab 123 cd", "2018");
        TraerAutoCU simulacion = new TraerAutoCU(iTraerAuto);

        //act
        Mockito.when(iTraerAuto.dameAutoSegunPatente("ab 123 cd")).thenReturn(a1);

        //assert
        assertEquals(a1,simulacion.traerAuto("ab 123 cd"));
    }

    @Order(2)
    @Test
    public void test02_autoNoExisteExcepcionAutoNoEncontrado() throws ExceptionAuto {
        TraerAutoCU simular = new TraerAutoCU(iTraerAuto);

        //act
        Mockito.when(iTraerAuto.dameAutoSegunPatente("ab 123 cd")).thenReturn(null);

        //assert
        assertThrows(ExceptionAutoNoEncontrado.class, ()->{
            simular.traerAuto("ab 123 cd");
        });
    }
}
