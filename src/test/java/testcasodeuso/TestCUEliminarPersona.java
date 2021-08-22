package testcasodeuso;

import casosdeuso.BuscarPersonaCU;
import dominio.Persona;
import exceptions.ExceptionPersona;
import exceptions.ExceptionPersonaNoEncontrada;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IEliminarPersona;
import repositorio.ILeerPersona;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class TestCUEliminarPersona {
    @Mock
    IEliminarPersona iEliminarPersona;
    @Mock
    ILeerPersona iLeerPersona;

    @Order(1)
    @Test


    public void test01_EliminarPersona_PersonaSeEliminaCorrectamente() throws ExceptionPersona {
        //arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iLeerPersona,iEliminarPersona);

        //act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(true);
        Mockito.when(iEliminarPersona.darBajaPersona("34724517")).thenReturn(true);


        //assert
        assertTrue(simulacro.darDeBajaPersona("34724517"));
    }


    @Order(2)
    @Test

    public void test02_EliminarPersona_EliminarPersonaFallido() throws ExceptionPersona {
        //arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iLeerPersona,iEliminarPersona);

        //act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(true);
        Mockito.when(iEliminarPersona.darBajaPersona("34724517")).thenReturn(false);


        //assert
        assertFalse(simulacro.darDeBajaPersona("34724517"));
    }

    @Order(3)
    @Test

    public void test03_EliminarPersona_PersonaNoEncontrada() throws ExceptionPersona {
        //arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iLeerPersona,iEliminarPersona);

        //act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("34724517")).thenReturn(false);
        Mockito.verify(iEliminarPersona,Mockito.never()).darBajaPersona("34724517");


        //assert
        assertThrows(ExceptionPersonaNoEncontrada.class,()->{
            simulacro.darDeBajaPersona("34724517");
        });
    }


}
