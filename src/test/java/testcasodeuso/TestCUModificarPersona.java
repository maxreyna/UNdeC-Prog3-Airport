package testcasodeuso;

import casosdeuso.ModificarPersonaCU;

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
    public void test01_modificarDatosPersona_SeModificanSusDatosCorrectamente() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.actualizarPeso(92.0);
        Mockito.when(iModificarPersona.modificarPeso(p1)).thenReturn(true);
        //assert

        assertTrue(simulacro.modificarPesoPersona(34724517,92.0));

    }
    @Order(2)
    @Test

    public void test02_modificarPesoPersona_cambioDePesoFallido() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.actualizarPeso(92.0);
        Mockito.when(iModificarPersona.modificarPeso(p1)).thenReturn(false);
        //assert

        assertFalse(simulacro.modificarPesoPersona(34724517,92.0));

    }

    @Order(3)
    @Test

    public void test03_modificarPesoPersona_cambioDePesoNegativo_Exception() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarPeso(p1);
        //assert
        assertThrows(ExceptionPersonaPesoIncorrecto.class,() ->{
            simulacro.modificarPesoPersona(34724517,-94);
        });
    }

    @Order(4)
    @Test
    public void test04_modificarAlturaPersona_SeModificaAlturaCorrectamente() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.actualizarAltura(1.82);
        Mockito.when(iModificarPersona.modificarAltura(p1)).thenReturn(true);
        //assert

        assertTrue(simulacro.modificarAlturaPersona(34724517,1.82));

    }

    @Order(5)
    @Test
    public void test05_modificarAlturaPersona_cambioDeAlturaFallido() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        p1.actualizarAltura(1.82);
        Mockito.when(iModificarPersona.modificarAltura(p1)).thenReturn(false);
        //assert

        assertFalse(simulacro.modificarAlturaPersona(34724517,1.82));

    }

    @Order(6)
    @Test

    public void test06_modificarAlturaPersona_alturaNegativa_Exception() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(p1);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarAltura(p1);
        //assert
        assertThrows(ExceptionPersonaAlturaIncorrecto.class,() ->{
            simulacro.modificarAlturaPersona(34724517,-1.82);
        });

    }

    @Order(7)
    @Test

    public void test07_modificarPesoPersona_noExistePersona_Exception() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(null);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarPeso(p1);
        //assert
        assertThrows(ExceptionPersonaNoEncontrada.class,() ->{
            simulacro.modificarPesoPersona(34724517,94);
        });
    }

    @Order(8)
    @Test

    public void test08_modificarAlturaPersona_PersonaNoExiste_Exception() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,34724517, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(34724517)).thenReturn(null);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarAltura(p1);
        //assert
        assertThrows(ExceptionPersonaNoEncontrada.class,() ->{
            simulacro.modificarAlturaPersona(34724517,1.82);
        });

    }

    @Order(9)
    @Test
    public void test09_modificarPesoPersona_dniErroneo_ExceptionPersonaDniErroneo() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,347245176, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.verify(iTraerPersona,Mockito.never()).damePersonaSegunDni(347245176);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarPeso(p1);
        //assert
        assertThrows(ExceptionPersonaDniIncorrecto.class,() ->{
            simulacro.modificarPesoPersona(347245176,94);
        });
    }

    @Order(10)
    @Test
    public void test10_modificarAlturaPersona_dniErroneo_ExceptionPersonaDniErroneo() throws ExceptionPersona{
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,347245176, LocalDate.of(1989,11,07));
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //act
        Mockito.verify(iTraerPersona,Mockito.never()).damePersonaSegunDni(347245176);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarPeso(p1);
        //assert
        assertThrows(ExceptionPersonaDniIncorrecto.class,() ->{
            simulacro.modificarPesoPersona(347245176,94);
        });
    }

    @Order(11)
    @Test
    public void test11_modificarDatosPersona_DatosSeModificanCorrectamente() throws ExceptionPersona{
        //arrange
        Persona estaPersona = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,92.0,37724517, LocalDate.of(1997,11,7));
        Persona personaActualizada = Persona.instaciaPersona(1,"Jessica","Rojas",1.78,60,37724517, LocalDate.of(1997,11,7));

        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);

        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(personaActualizada.getDniInt())).thenReturn(estaPersona);
        estaPersona.actualizarDatos(personaActualizada);
        Mockito.when(iModificarPersona.modificarDatos(estaPersona)).thenReturn(true);

        //assert
        assertTrue(simulacro.modificarDatosPersona(personaActualizada));
    }

    @Order(12)
    @Test
    public void test12_modificarDatosPersona_DatosNoSeModificanCorrectamente_FalloBD() throws ExceptionPersona{
        //arrange
        Persona estaPersona = Persona.instaciaPersona(1,"Santiago","Chanampe",1.80,92.0,37724517, LocalDate.of(1997,11,7));
        Persona personaActualizada = Persona.instaciaPersona(1,"Jessica","Rojas",1.78,60,37724517, LocalDate.of(1997,11,7));

        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);

        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(personaActualizada.getDniInt())).thenReturn(estaPersona);
        estaPersona.actualizarDatos(personaActualizada);
        Mockito.when(iModificarPersona.modificarDatos(estaPersona)).thenReturn(false);

        //assert
        assertFalse(simulacro.modificarDatosPersona(personaActualizada));
    }

    @Order(13)
    @Test
    public void test13_modificarDatosPersona_PersonaNoExiste_ExceptionPersonaNoEncontrada() throws ExceptionPersona{
        //arrange
        Persona personaActualizada = Persona.instaciaPersona(1,"Jessica","Rojas",1.78,60,37724517, LocalDate.of(1997,11,7));

        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);

        //act
        Mockito.when(iTraerPersona.damePersonaSegunDni(personaActualizada.getDniInt())).thenReturn(null);
        Mockito.verify(iModificarPersona,Mockito.never()).modificarDatos(personaActualizada);
        //assert
        assertThrows(ExceptionPersonaNoEncontrada.class,() -> simulacro.modificarDatosPersona(personaActualizada));
    }

}


