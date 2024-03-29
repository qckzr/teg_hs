/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.moduloGestion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConexionBD;

/**
 * Clase que permite modificar un pregunta de la base de datos a través del
 * módulo de gestión.
 * @author Héctor Sam
 */
@WebServlet(name = "ModificarPreguntaServlet2", urlPatterns = {"/ModificarPreguntaServlet2"})
public class ModificarPreguntaServlet2 extends HttpServlet {

    private ConexionBD conexionBD = new ConexionBD();
    private String enunciado;
    private String topico;
    private String id;
    private ResultSet pregunta;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            obtenerInformacion(request);
            ejecutarQuery(request);
            enviarInformacion(request, response);
        } finally {            
            out.close();
        }
    }
    
    /**
     * Método que permite obtener la información correspondiente a una pregunta.
     * @param request La petición HTTP con el id de la pregunta.
     * @return True si la información fue obtenida. False en caso contrario.
     */
    public boolean obtenerInformacion(HttpServletRequest request){
        if (request != null) {
            
            conexionBD = new ConexionBD();
            enunciado = request.getParameter("enunciado");
            topico = request.getParameter("topicos");
            id = request.getParameter("id");
            return true;
             
        }
        return false;
    }
    
    /**
     * Método que permite ejecutar el query con la información perteneciente
     * a una pregunta.
     * @param request La petición HTTP con la información del usuario.
     * @return True si la información fue obtenida. False en caso contrario.
     */
    public boolean ejecutarQuery(HttpServletRequest request){
        ResultSet respuestas;
        String respuesta;
        String opcion;
        if (request != null) {
            try {
               pregunta = conexionBD.consultarRegistro("SELECT ENUNCIADO,"
                       + "ID_TOPICO FROM PREGUNTAS WHERE ID="+id);
                if (!pregunta.getString(1).contentEquals(enunciado)) {
                    conexionBD.ejecutarQuery("UPDATE PREGUNTAS "
                            + "SET ENUNCIADO='"+enunciado+"' WHERE ID="+id);
                }
                if (!pregunta.getString(2).contentEquals(topico)) {
                    conexionBD.ejecutarQuery("UPDATE PREGUNTAS "
                            + "SET ID_TOPICO="+topico+" WHERE ID="+id);
                }
                respuestas = conexionBD.consultar("SELECT ID "
                        + "FROM RESPUESTAS WHERE ID_PREGUNTA="+id);
                for (int i = 1; i <= 4; i++) {
                    respuesta = request.getParameter("respuesta"+i);
                    opcion = request.getParameter("checkbox"+i);
                    conexionBD.ejecutarQuery("UPDATE RESPUESTAS "
                            + "SET OPCION='"+respuesta+"' "
                            + "WHERE ID="+request.getParameter("idRespuesta"+i));
                    conexionBD.ejecutarQuery("UPDATE RESPUESTAS "
                            + "SET CORRECTA="+opcion+" "
                            + "WHERE ID="+request.getParameter("idRespuesta"+i));
                
                }
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ModificarUsuarioServlet2.
                        class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    /**
     * Método que permite enviar la información correspondiente de la pregunta
     * a modificar..
     * @param request La petición HTTP que contendrá la información.
     * @param response La respuesta HTTP donde se redirigirá la información.
     * @return True si la información fue enviada. False en caso contrario.
     */
    public boolean enviarInformacion (HttpServletRequest request,
            HttpServletResponse response){
        RequestDispatcher dispatcher; 
        if ((request != null) && (response != null) ){
            try {
                
                request.setAttribute("mensaje","Pregunta Modificada");
                dispatcher = request.getRequestDispatcher("/respuesta.jsp");
                dispatcher.forward(request, response);
                conexionBD.desconectar();
                return true;
             } catch (ServletException ex) {
                 Logger.getLogger(CrearEjecutableServlet.class.getName()).
                         log(Level.SEVERE, null, ex);
                 return false;
             } catch (IOException ex) {
                 Logger.getLogger(CrearEjecutableServlet.class.getName()).
                         log(Level.SEVERE, null, ex);
                 return false;
             } 
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
