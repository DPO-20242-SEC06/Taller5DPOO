package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Pedido;

public class TestPedido
{
	private String nombreCliente;
	private String direccionCliente;
    private ProductoMenu producto1;
    private Pedido pedido;

    @BeforeEach
    void setUp( ) throws Exception
    {

    	nombreCliente="Juan";
    	direccionCliente="Carrera 11D";
        producto1 = new ProductoMenu( "hamburguesa", 10000 );
        pedido = new Pedido(nombreCliente, direccionCliente);
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testidpedido( )
    {
    	assertEquals(1, pedido.getIdPedido(), "el id no es esperado");
    }
    @Test
    void testGetNombre( )
    {
    	assertEquals("Juan", pedido.getNombreCliente(), "El nombre no es el esperado");
    }    
    
    @Test
    void testAgregarProducto()
    {
    	pedido.agregarProducto(producto1);
    	int cantidad=pedido.cantidadProductos();
    	assertEquals(1, cantidad, "no es el tamaño correcto");
    }
    @Test
    void testGetPrecioTotal( )
    {
    	pedido.agregarProducto(producto1);
    	assertEquals(11900, pedido.getPrecioTotalPedido(), "El precio no es el esperado");
    }
    @Test
    void testGenerarFactura()
    {
    	pedido.agregarProducto(producto1);
    	String string1="Cliente: Juan\nDirección: Carrera 11D\n----------------\n";
    	String string2=producto1.generarTextoFactura();
    	String string3="----------------\nPrecio Neto:  10000\nIVA:          1900\nPrecio Total: 11900\n";
    	String stringcompleto=string1+string2+string3;
    	assertEquals(stringcompleto, pedido.generarTextoFactura(),"Texto no esperado");
    }

}