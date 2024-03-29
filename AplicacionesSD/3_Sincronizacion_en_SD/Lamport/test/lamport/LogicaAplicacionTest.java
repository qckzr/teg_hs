/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lamport;

import Libreria.LibreriaMensajes;
import Libreria.Mensaje;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hectorsam
 */
public class LogicaAplicacionTest {
    
    public LogicaAplicacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of evaluarMarca method, of class LogicaAplicacion.
     */
    @Test
    public void testEvaluarMarca() {
        System.out.println("evaluarMarca");
        String marcaRecibida = "+10";
        LibreriaMensajes libreriaMensajes = new LibreriaMensajes(true);
        libreriaMensajes.agregarIpDestino("localhost");
        LogicaAplicacion instance = LogicaAplicacion.getInstancia(libreriaMensajes,
                new DatosAplicacion("1","1"),1337,"192.168.1.192","");
        boolean expResult = true;
        boolean result = instance.evaluarMarca(marcaRecibida);
        assertEquals(expResult, result);
    }

    /**
     * Test of enviarMarca method, of class LogicaAplicacion.
     */
    @Test
    public void testEnviarMarca_String() {
        System.out.println("enviarMarca");
        String marcaActual = "1337";
        LibreriaMensajes libreriaMensajes = new LibreriaMensajes(true);
        libreriaMensajes.agregarIpDestino("localhost");
        LogicaAplicacion instance = LogicaAplicacion.getInstancia(libreriaMensajes,
                new DatosAplicacion("1", "1"),1337,"192.168.1.192","");
        
        boolean expResult = true;
        boolean result = instance.enviarMarca(marcaActual);
        assertEquals(expResult, result);
    }

    /**
     * Test of enviarMarca method, of class LogicaAplicacion.
     */
    @Test
    public void testEnviarMarca_0args() {
        System.out.println("enviarMarca");
        LibreriaMensajes libreriaMensajes = new LibreriaMensajes(true);
        libreriaMensajes.agregarIpDestino("localhost");
        LogicaAplicacion instance = LogicaAplicacion.getInstancia(libreriaMensajes,
                new DatosAplicacion("1", "1"),1337,"192.168.1.192","");
        
        boolean expResult = false;
        boolean result = instance.enviarMarca();
        assertEquals(expResult, result);
    }
    
}
