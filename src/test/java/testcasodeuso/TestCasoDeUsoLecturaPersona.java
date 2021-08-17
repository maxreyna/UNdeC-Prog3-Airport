package testcasodeuso;

import casosdeuso.BuscarPersonaCU;
import dominio.Persona;
import exceptions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ILeerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class TestCasoDeUsoLecturaPersona {
    @Mock
    ILeerPersona iLeerPersona;
    @Order(1)
    @Test

    public void Test01_PersonaExisteYEsLeida() throws ExceptionPersona {
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        //act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(true);
        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(iLeerPersona);
        //assert
        assertTrue(simularBusqueda.buscarPersona("34724517"));
    }

    @Order(2)
    @Test
    public void Test02_BusquedaPersona_PersonaNoExiste() throws ExceptionPersona {
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        //act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(false);
        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(iLeerPersona);

        //assert
        assertFalse(simularBusqueda.buscarPersona("34724517"));
    }
}
