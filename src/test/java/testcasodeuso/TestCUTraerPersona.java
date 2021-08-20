package testcasodeuso;

import casosdeuso.TraerPersonaCU;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ITraerPersona;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class TestCUTraerPersona {
    @Mock
    ITraerPersona iTraerPersona;
    @Order(1)
    @Test
    public void test01_personaExisteYEsTraida() throws ExceptionPersonaAtributoNulo, ExceptionPersonaDniIncorrecto, ExceptionPersonaAlturaIncorrecto, ExceptionPersonaPesoIncorrecto {
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        TraerPersonaCU simular = new TraerPersonaCU(iTraerPersona);

        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni("34724517")).thenReturn(p1);

        //assert
        assertEquals(p1,simular.traerPersona("34724517"));
    }


}
