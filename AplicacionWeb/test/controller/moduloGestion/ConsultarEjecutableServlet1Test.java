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
public class ConsultarEjecutableServlet1Test {
    
    public ConsultarEjecutableServlet1Test() {
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
     * Test of enviarInformacion method, of class ConsultarEjecutableServlet1.
     */
    @Test
    public void testEnviarInformacion() {
        System.out.println("enviarInformacion");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ConsultarEjecutableServlet1 instance = new ConsultarEjecutableServlet1();
        boolean expResult = false;
        boolean result = instance.enviarInformacion(request, response);
        assertEquals(expResult, result);
    }

    
    
}