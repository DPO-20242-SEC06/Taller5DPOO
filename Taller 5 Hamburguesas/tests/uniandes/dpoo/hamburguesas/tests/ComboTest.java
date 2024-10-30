package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest
{
	
    private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;
    private ArrayList<ProductoMenu> items;

    @BeforeEach
    void setUp( ) throws Exception
    {
    	producto1=new ProductoMenu("hamburguesa", 10000);
    	producto2=new ProductoMenu("papas", 5000);
    	items= new ArrayList<ProductoMenu>();
    	items.add(producto1);
    	items.add(producto2);
        combo = new Combo("Combo Especial", 0.1, items);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testNombreCombo( )
    {
    	assertEquals("Combo Especial", combo.getNombre(), "el nombre no es el esperado"); 
    }
    @Test
    void testPrecioCombo( )
    {
    	assertEquals(13500, combo.getPrecio(), "el costo no es el esperado");
    }
    @Test
    void testGenerarFactura()
    {
    	String string= "Combo Combo Especial\n Descuento: 0.1\n            13500\n";
    	assertEquals(string, combo.generarTextoFactura(), "El texto no fue generado correctamente");
    }

}
