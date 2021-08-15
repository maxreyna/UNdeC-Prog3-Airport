package testdominio;

import dominio.Persona;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)

public class TestPersona {
    @Test
    public void CrearPersona_Sin_Errores(){
        //arrange
        Persona p1 = Persona.instaciaPersona(1,"Maximiliano","Reyna",1.80,92.0,3472512, LocalDate.of(1989,11,07));
        //act

        //assert
        assertNotNull(p1);

        //usar patron factory
    }
}
