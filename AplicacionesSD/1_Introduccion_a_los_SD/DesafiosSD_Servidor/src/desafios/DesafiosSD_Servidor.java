/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desafios;

import Libreria.LibreriaMensajes;

/**
 *
 * @author sam
 */
public class DesafiosSD_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("javax.net.ssl.keyStore","/home/pi/Desktop/certificadoSSL");  
        System.setProperty("javax.net.ssl.keyStorePassword","password");
        LibreriaMensajes libreriaMensajes = new LibreriaMensajes();
        DatosAplicacion datosAplicacion = new DatosAplicacion(args[0],args[1]);//args[0] = nombreApp, args[1] = numeroNodo
        libreriaMensajes.agregarIpDestino(args[2]); //args[2] ip del servidor central
        LogicaAplicacion logicaAplicacion = LogicaAplicacion.getInstance(libreriaMensajes, datosAplicacion, Integer.valueOf(args[3]));
        logicaAplicacion.enviarId(args[2]);
        EscucharClientes escucharMensajes = new EscucharClientes(logicaAplicacion, libreriaMensajes);
        escucharMensajes.start();
    }
}
