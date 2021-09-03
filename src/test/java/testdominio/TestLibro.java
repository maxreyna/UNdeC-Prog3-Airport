package testdominio;

import dominio.Libro;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestLibro {
    @Order(1)
    @Test
    public void test01_crearLibro_sinErrores(){
        //arrange
        Libro l1 = Libro.instaciaLibro(1L,"1538-1113-5004-4","Las cronicas de miranda","Nicolas Chanampe",2019,"Espasa",220,200.00);

        //assert
        assertNotNull(l1);
    }
}
