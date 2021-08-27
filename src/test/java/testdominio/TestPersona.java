package testdominio;

import dominio.Persona;
import exceptions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersona {
    @Order(1)
    @Test
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

    @Test
    @Order(9)
    public void actualizarPersona_SeModificanDatosPersona() throws ExceptionPersona {
        Persona estaPersona = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,92.0,37724517, LocalDate.of(1997,11,7));
        Persona personaActualizada = Persona.instaciaPersona(1,"Jessica","Rojas",1.78,60,37724517, LocalDate.of(1997,11,7));

        assertTrue(estaPersona.actualizarDatos(personaActualizada));
        assertEquals(personaActualizada.getNombre(),estaPersona.getNombre());
        assertEquals(personaActualizada.getApellido(),estaPersona.getApellido());
        assertEquals(personaActualizada.getAltura(),estaPersona.getAltura());
        assertEquals(personaActualizada.getPeso(),estaPersona.getPeso());

    }

    @Test
    @Order(10)
    public void actulizarPeso_PesoSeActulizaCorrectamente()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));
        //act
        p1.actualizarPeso(92.0);

        //assert
        assertEquals(92.0,p1.getPeso());
    }

    @Test
    @Order(11)
    public void actualizarAltura_LaAlturaSeActualizaCorrectamente()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));
        //act
        p1.actualizarAltura(1.82);
        //assert
        assertEquals(1.82,p1.getAltura());
    }

    @Test
    @Order(12)
    public void actulizarPeso_PesoNegativo_ExcepctionPesoErroneo()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));

        //assert
        assertThrows(ExceptionPersonaPesoIncorrecto.class,() -> p1.actualizarPeso(-92.0));
    }

    @Test
    @Order(13)
    public void actulizarPeso_PesoCero_ExcepctionPesoErroneo()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));

        //assert
        assertThrows(ExceptionPersonaPesoIncorrecto.class,() -> p1.actualizarPeso(0.0));
    }

    @Test
    @Order(14)
    public void actulizarAltura_AlturaNegativa_ExceptionAlturaErronea()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));

        //assert
        assertThrows(ExceptionPersonaAlturaIncorrecto.class,() -> p1.actualizarAltura(-1.80));
    }

    @Test
    @Order(15)
    public void actulizarAltura_AlturaCero_ExcepctionAlturaErroneo()throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,94.0,37724517, LocalDate.of(1997,11,7));

        //assert
        assertThrows(ExceptionPersonaAlturaIncorrecto.class,() -> p1.actualizarAltura(0.0));
    }

}
