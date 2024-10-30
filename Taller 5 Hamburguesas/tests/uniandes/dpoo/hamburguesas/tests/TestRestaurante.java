package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import uniandes.dpoo.hamburguesas.excepciones.*;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import uniandes.dpoo.hamburguesas.mundo.Pedido;

public class TestRestaurante
{
	private Restaurante restaurante;
    @BeforeEach
    void setUp( ) throws Exception
    {
    	restaurante=new Restaurante();
    }

    @AfterEach
    void tearDown( ) throws Exception
    {
    }

    @Test
    void testIniciarPedido() throws YaHayUnPedidoEnCursoException
    {
    	assertNull(restaurante.getPedidoEnCurso(), "Ya hay un pedido en curso");
    	restaurante.iniciarPedido("Juan", "Carrera 11D");
    	assertNotNull(restaurante.getPedidoEnCurso(), "No deberia porque ya se inicio");
    }
    @Test
    void testCerrarYGuardarPedido() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException
    {
    	restaurante.iniciarPedido("JUAN", "CARRERA 11D");
    	restaurante.cerrarYGuardarPedido();
    	assertNull(restaurante.getPedidoEnCurso(), "Deberia ser Null por lo que ya se cerro");
    }
    @Test
    void testCerrarPedidosSinIniciar() 
    {
    	assertThrows(NoHayPedidoEnCursoException.class, restaurante::cerrarYGuardarPedido);
    }
    @Test
    void testGetPedidos() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException
    {
    	restaurante.iniciarPedido("Juan", "CEDITROS");
    	restaurante.cerrarYGuardarPedido();
    	restaurante.iniciarPedido("Mateo", "CEDITROS");
    	restaurante.cerrarYGuardarPedido();
    	restaurante.iniciarPedido("Juan Di", "CEDITROS");
    	restaurante.cerrarYGuardarPedido();
    	restaurante.iniciarPedido("Berni", "CEDITROS");
    	restaurante.cerrarYGuardarPedido();
    	ArrayList<Pedido> pedidosCerrados=restaurante.getPedidos();
    	assertEquals(4, pedidosCerrados.size(), "La cantidad es incorrecta");
    }
    
    @Test
    void testCargaInformacionRestaurante() throws HamburguesaException, IOException
    {
    	File archivoIngredientes = new File("data/ingredientes.txt");
    	File archivoMenu=new File("data/menu.txt");
    	File archivoCombos=new File("data/combos.txt");
    	
    	restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
    	assertEquals(15, restaurante.getIngredientes().size(), "No se cargo la totalidad de ingredientes.");
        assertEquals(22, restaurante.getMenuBase().size(), "No se cargo la totalidad de productos del menu.");
        assertEquals(4, restaurante.getMenuCombos().size(), "No se cargo la totalidad de combos.");
        
    }
    @Test
    public void testGetMenuBase() throws HamburguesaException, IOException {
        restaurante.cargarInformacionRestaurante(new File("data/ingredientes.txt"), new File("data/menu.txt"), new File("data/combos.txt"));
        assertNotNull(restaurante.getMenuBase());
        assertFalse(restaurante.getMenuBase().isEmpty());
    }

    @Test
    public void testGetMenuCombos() throws HamburguesaException, IOException {
        restaurante.cargarInformacionRestaurante(new File("data/ingredientes.txt"), new File("data/menu.txt"), new File("data/combos.txt"));
        assertNotNull(restaurante.getMenuCombos());
        assertFalse(restaurante.getMenuCombos().isEmpty());
    }

    @Test
    public void testGetIngredientes() throws HamburguesaException, IOException {
        restaurante.cargarInformacionRestaurante(new File("data/ingredientes.txt"), new File("data/menu.txt"), new File("data/combos.txt"));
        assertNotNull(restaurante.getIngredientes());
        assertFalse(restaurante.getIngredientes().isEmpty());
    }
    
}