/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuido;

import Libreria.LibreriaMensajes;

/**
 *
 * @author sam
 */
public class Distribuido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LibreriaMensajes libreriaMensajes = new LibreriaMensajes();
        DatosAplicacion datosAplicacion = new DatosAplicacion(args[0],args[1]);//args[0] = nombreApp, args[1] = numeroNodo
        libreriaMensajes.agregarIpDestino(args[2]); //args[2] ip del servidor central
        LogicaAplicacion logicaAplicacion = new LogicaAplicacion(libreriaMensajes, datosAplicacion, Integer.valueOf(args[3]));
        logicaAplicacion.enviarId(args[2]);
        logicaAplicacion.getNodosSistema().add(args[4]);
        logicaAplicacion.getNodosSistema().add(args[5]);
        logicaAplicacion.getNodosSistema().add(args[6]);
        EscucharClientes escucharMensajes = new EscucharClientes(logicaAplicacion, libreriaMensajes);
        escucharMensajes.start();
    }
}
