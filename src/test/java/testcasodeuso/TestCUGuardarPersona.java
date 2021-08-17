package testcasodeuso;


import casosdeuso.GuardarPersonaCU;
import dominio.Persona;
import exceptions.ExceptionPersona;
import exceptions.ExceptionPersonaExiste;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUGuardarPersona {
    @Mock
    ILeerPersona iLeerPersona;
    @Mock
    IGuardarPersona iGuardarPersona;

    @Order(1)
    @Test
    public void test01_guardarPersona_personaNoExisteYEsGuardada() throws ExceptionPersona {
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));

        GuardarPersonaCU simularGuardarPersona = new GuardarPersonaCU(iGuardarPersona, iLeerPersona);
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(false);
        Mockito.when(iGuardarPersona.guardarPersona(p1)).thenReturn(true);

        //assert
        assertTrue(simularGuardarPersona.cargarPersona(p1));
    }

    @Order(2)
    @Test
    public void test02_guardarPersona_personaExiste_lanzaExceptionPersonaExiste() throws ExceptionPersona{

        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        GuardarPersonaCU simularGuardarPersona = new GuardarPersonaCU(iGuardarPersona, iLeerPersona);

        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(true);
        Mockito.verify(iGuardarPersona,Mockito.never()).guardarPersona(p1);

        //assert
        assertThrows(ExceptionPersonaExiste.class, () ->{
            simularGuardarPersona.cargarPersona(p1);
        });
    }

}
