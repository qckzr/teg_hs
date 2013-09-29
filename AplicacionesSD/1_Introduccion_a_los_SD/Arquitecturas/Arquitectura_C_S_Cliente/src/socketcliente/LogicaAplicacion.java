/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketcliente;

import Libreria.LibreriaMensajes;
import Libreria.Mensaje;

/**
 *
 * @author sam
 */
public class LogicaAplicacion {

    private LibreriaMensajes libreriaMensajes;
    private int puertoAgente;
    private DatosAplicacion datosAplicacion;
    private String ipAppSocketServidor;

    public LogicaAplicacion(LibreriaMensajes libreriaMensajes, DatosAplicacion datosAplicacion,int puertoAgente, String ipAppSocketServidor) {
        this.libreriaMensajes = libreriaMensajes;
        this.datosAplicacion = datosAplicacion;
        this.puertoAgente = puertoAgente;
        this.ipAppSocketServidor = ipAppSocketServidor;
    }
    
    public boolean verificarMensajeRecibido(Mensaje mensaje){
        
        switch (mensaje.getMensaje()){
            case "aplicacion": 
                if (libreriaMensajes.enviarMensaje(datosAplicacion.getNombreAplicacion(),"localhost", puertoAgente))
                    return true;
                break;
            case "nodo":
                if (libreriaMensajes.enviarMensaje(datosAplicacion.getNumeroNodoAplicacion(),"localhost",puertoAgente))
                    return true;
                break;
            default:{
                
                System.out.println("Se ha recibido el mensaje: \""+mensaje.getMensaje()+"\" proveniente del host: "+mensaje.getIpOrigen());
                libreriaMensajes.enviarMensaje("Se ha recibido el mensaje: \""+mensaje.getMensaje()+"\" proveniente del host: "+mensaje.getIpOrigen());
                if (!mensaje.getIpOrigen().contentEquals(ipAppSocketServidor))
                    enviarMensajeServidor(mensaje);
                else{
                    System.out.println("Fue una respuesta del servidor"); 
                    libreriaMensajes.enviarMensaje("Fue una respuesta del servidor");
                }
            }
        };
        return false;
    }
    
    public boolean enviarMensajeServidor(Mensaje mensajeRecibido){
        if (libreriaMensajes.enviarMensaje(mensajeRecibido.getMensaje(),ipAppSocketServidor))
            return true;
            
        else 
            return false;
        
        
    }
    
     
     
    public void enviarId(String ipServidor){
        libreriaMensajes.enviarMensaje("id<"+datosAplicacion.getIdProceso(),ipServidor);
    }
    
}
