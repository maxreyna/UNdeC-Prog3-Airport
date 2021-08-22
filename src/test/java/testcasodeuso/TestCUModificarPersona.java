package testcasodeuso;

import casosdeuso.ModificarPersonaCU;
import casosdeuso.TraerPersonaCU;
import dominio.Persona;
import exceptions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class TestCUModificarPersona{
    @Mock
    ITraerPersona iTraerPersona;
    @Mock
    IModificarPersona iModificarPersona;

    @Order(1)
    @Test
    public void test01_modificarPersona_SeModificanSusDatosCorrectamente() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.setPeso(92.0);
        Mockito.when(iModificarPersona.modificarPeso(p1)).thenReturn(true);
        //assert
        assertEquals(92.0,p1.getPeso());
        assertTrue(simulacro.modificarPesoPersona(34724517,92.0));

    }
    @Order(2)
    @Test

    public void test02_modificarPersona_cambioDePesoFallido() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.setPeso(92.0);
        Mockito.when(iModificarPersona.modificarPeso(p1)).thenReturn(false);
        //assert
        assertEquals(92.0,p1.getPeso());
        assertFalse(simulacro.modificarPesoPersona(34724517,92.0));

    }

}


