package testdominio;

import dominio.Persona;
import exceptions.ExceptionPersonaAlturaIncorrecto;
import exceptions.ExceptionPersonaAtributoNulo;
import exceptions.ExceptionPersonaDniIncorrecto;
import exceptions.ExceptionPersonaPesoIncorrecto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersona {
    @Test
    @Order(1)
    public void Test01_CrearPersona_Sin_Errores() throws ExceptionPersonaAtributoNulo, ExceptionPersonaAlturaIncorrecto, ExceptionPersonaPesoIncorrecto, ExceptionPersonaDniIncorrecto {
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,3472512, LocalDate.of(1989,11,7));
        //act

        //assert
        assertNotNull(p1);

        //usar patron factory
    }
    @Test
    @Order(2)
    public void test02_Persona_NombreNulo(){
        assertThrows(ExceptionPersonaAtributoNulo.class, () ->  Persona.instaciaPersona(2, null, "Reyna",1.80,92.0,34724517,LocalDate.of(1989,11,7))
        );

    }

    @Test
    @Order(3)
    public void test03_Persona_ApellidoNulo(){
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.instaciaPersona(3, "Maximiliano", null,1.80,92.0,34724517,LocalDate.of(1989,11,7))
        );
    }

    @Test
    @Order(4)
    public void test04_Persona_AlturaIncorrecta(){
        assertThrows(ExceptionPersonaAlturaIncorrecto.class, () -> Persona.instaciaPersona(4, "Maximiliano", "Reyna",-1.58,92.0,34724517,LocalDate.of(1989,11,7))
        );
    }

    @Test
    @Order(5)
    public void test05_Persona_AlturaIncorrecta(){
        assertThrows(ExceptionPersonaAlturaIncorrecto.class, () ->Persona.instaciaPersona(5, "Maximiliano", "Reyna",0,92.0,34724517,LocalDate.of(1989,11,7))
        );
    }

    @Test
    @Order(6)
    public void test06_Persona_PesoIncorrecta(){
        assertThrows(ExceptionPersonaPesoIncorrecto.class, () -> Persona.instaciaPersona(6, "Maximiliano", "Reyna",1.80,-92.0,34724517,LocalDate.of(1989,11,7))
        );
    }

    @Test
    @Order(7)
    public void test07_Persona_PesoIncorrecta(){
        assertThrows(ExceptionPersonaPesoIncorrecto.class, () -> Persona.instaciaPersona(7, "Maximiliano", "Reyna",1.80,0,34724517,LocalDate.of(1989,11,7))
        );
    }

    @Test
    @Order(8)
    public void test08_Persona_DniIncorrecto(){
        assertThrows(ExceptionPersonaDniIncorrecto.class, () ->Persona.instaciaPersona(8, "Maximiliano", "Reyna",1.80,92,347245,LocalDate.of(1989,11,7))
        );
    }

}
