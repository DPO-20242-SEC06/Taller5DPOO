package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;

public class TestProductoAjustado
{
    private ProductoMenu producto1;
    private ProductoAjustado ajustado;
    Ingrediente queso;
    Ingrediente cebolla;

    @BeforeEach
    void setUp( ) throws Exception
    {
        producto1 = new ProductoMenu( "hamburguesa", 10000 );
        ajustado= new ProductoAjustado(producto1);
        queso = new Ingrediente("Queso", 1500);
        cebolla = new Ingrediente("Cebolla", 2000);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testNombre( )
    {
    	assertEquals("hamburguesa", ajustado.getNombre(), "el costo no es el esperado");
    }
    @Test
    void testPrecioProducto( )
    {
    	ajustado.agregarIngrediente(queso);
    	assertEquals(11500, ajustado.getPrecio(), "el costo no es el esperado");
    }
    
    @Test
    void testEliminarIngrediente() {
        ajustado.eliminarIngrediente(cebolla);
        assertEquals(1, ajustado.cantidadEliminados(), "No se conto bien el eliminados");
    }
    @Test
    void testAgregarIngrediente() {
        ajustado.agregarIngrediente(queso);
        assertEquals(1, ajustado.cantidadAgregados(), "No se conto bien el eliminados");
    }
    
    @Test
    void testGenerarFactura()
    {
    	assertEquals("hamburguesa            10000\n", ajustado.generarTextoFactura(), "El texto no es correcto");
    }
    
    @Test
    void testGenerarTextoFacturaConIngredientesEliminados() {
        ajustado.eliminarIngrediente(cebolla);
        assertEquals("hamburguesa    -Cebolla            10000\n", ajustado.generarTextoFactura(), "El texto no es correcto con los productos eliminados");
    }
    @Test
    void testGenerarTextoFacturaConIngredientesagregados() {
        ajustado.agregarIngrediente(queso);
        assertEquals("hamburguesa    +Queso                1500            11500\n", ajustado.generarTextoFactura(), "El texto no es correcto con los productos agregados");
    }
    

}

