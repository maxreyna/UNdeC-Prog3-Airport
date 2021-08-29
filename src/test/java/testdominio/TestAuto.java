package testdominio;


import dominio.Auto;
import exceptions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestAuto {

    @Test
    @Order(1)
    public void Test01_Auto() throws ExceptionAuto{
        Auto a1 = Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6", "5","ab 123 cd", "2017");
        assertNotNull(a1);
    }

    @Test
    @Order(2)
    public void test02_Auto_atributosNulos() throws ExceptionAuto{
        assertThrows(ExceptionAutoMarcaNulo.class, ()-> Auto.instanciaAuto(1,null, "Allure", "Blanco", "1.6", "5","ab 123 cd", "2017"));
        assertThrows(ExceptionAutoModeloNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", null, "Blanco", "1.6", "5","ab 123 cd", "2017"));
        assertThrows(ExceptionAutoColorNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", "Allure", null, "1.6", "5","ab 123 cd", "2017"));
        assertThrows(ExceptionAutoCilindradaNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", null, "5","ab 123 cd", "2017"));
        assertThrows(ExceptionAutoPuertaNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6", null,"ab 123 cd", "2017"));
        assertThrows(ExceptionAutoPatenteNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6", "5",null, "2017"));
        assertThrows(ExceptionAutoAnioNulo.class, ()-> Auto.instanciaAuto(1,"Peugeot", "Allure", "Blanco", "1.6", "5","ab 123 cd", null));
    }

}
