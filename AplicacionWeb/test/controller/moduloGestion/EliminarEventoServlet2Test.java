/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.moduloGestion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class EliminarEventoServlet2Test {
    
    public EliminarEventoServlet2Test() {
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
     * Test of obtenerInformacion method, of class EliminarEventoServlet2.
     */
    @Test
    public void testObtenerInformacion() {
        System.out.println("obtenerInformacion");
        HttpServletRequest request = null;
        EliminarEventoServlet2 instance = new EliminarEventoServlet2();
        boolean expResult = false;
        boolean result = instance.obtenerInformacion(request);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ejecutarQuery method, of class EliminarEventoServlet2.
     */
    @Test
    public void testEjecutarQuery() {
        System.out.println("ejecutarQuery");
        HttpServletRequest request = null;
        EliminarEventoServlet2 instance = new EliminarEventoServlet2();
        boolean expResult = false;
        boolean result = instance.ejecutarQuery(request);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of enviarInformacion method, of class EliminarEventoServlet2.
     */
    @Test
    public void testEnviarInformacion() {
        System.out.println("enviarInformacion");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        EliminarEventoServlet2 instance = new EliminarEventoServlet2();
        boolean expResult = false;
        boolean result = instance.enviarInformacion(request, response);
        assertEquals(expResult, result);
        
    }

    
    
}
