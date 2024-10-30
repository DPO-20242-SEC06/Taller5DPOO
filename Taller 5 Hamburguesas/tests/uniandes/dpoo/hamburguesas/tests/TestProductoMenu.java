package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class TestProductoMenu
{
    private ProductoMenu producto1;

    @BeforeEach
    void setUp( ) throws Exception
    {
        producto1 = new ProductoMenu( "hamburguesa", 10000 );
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testNombreProducto( )
    {
    	assertEquals("hamburguesa", producto1.getNombre(), "el nombre no es el esperado"); 
    }
    @Test
    void testPrecioProducto( )
    {
    	assertEquals(10000, producto1.getPrecio(), "el costo no es el esperado");
    }
    @Test
    void testGenerarFactura () {
        assertEquals("hamburguesa\n            10000\n", producto1.generarTextoFactura(), "El texto esta mal generado");
    }


}
