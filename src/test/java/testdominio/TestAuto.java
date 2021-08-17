package testdominio;


import dominio.Auto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAuto {
    @Test
    @Order(1)
    public void Test01_Auto(){
        Auto a1 = Auto.instanciaAuto("Peugeot", "Allure", "Blanco", "1.6", "ab 123 cd", "2017");
        assertNotNull(a1);
    }

}
