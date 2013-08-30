<%-- 
    Document   : gestion
    Created on : Jul 24, 2013, 3:46:49 PM
    Author     : hector
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion Topicos</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script type="text/javascript" src="scripts/enviarPagina.js"></script>
        <script type="text/javascript" src="scripts/iniciarSesion.js"></script>
      <!--  <script  type="text/javascript" src="scripts/jquery-ui-1.10.3.custom.js"></script> -->
      <!--  <link rel="stylesheet" type="text/css" href="css/teg-theme/jquery-ui-1.10.3.custom.css">
       <link rel="stylesheet" type="text/css" href="styles/estilos-extras.css">
        <link rel="stylesheet" type="text/css" href="styles/general.css">
        <link rel="stylesheet" type="text/css" href="styles/dropdown.css"> -->
      
      
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
  <!--  <script>
            $(function() {
                $("a,li input[type=button]" )
                .button();
               
               
                });
  </script> -->
   
    </head>
    <body>
        <div id="contenido"  >
            <div class="container-fluid">
            <div id="main" class="row-fluid" >
                
        
        <!-- LO NUEVO -->
        <div id="menus" class="span12 navbar navbar-inverse navbar-static-top">
            <div class="navbar-inner">
                <a href="gestion.jsp" class="brand">Modulo Gestión:</a>
            <ul class="nav">
               
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuarios <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a id="crearUsuario" href="#">Crear</a></li>
                                <li><a id="modificarUsuario" href="#" >Modificar</a></li>
                                <li><a id="eliminarUsuario" href="#">Eliminar</a></li>
                                <li><a id="consultarUsuario" href="#">Consultar</a></li>
                            </ul>
                    
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Topicos <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a id="crearTopico"href="#">Crear</a></li>
                    <li><a id="modificarTopico"href="#">Modificar</a></li>
                    <li><a id="eliminarTopico"href="#">Eliminar</a></li>
                    <li><a id="consultarTopico"href="#">Consultar</a></li>
                </ul>
            </li>

            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Preguntas <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a id="crearPregunta"href="#">Crear</a></li>
                    <li><a id="modificarPregunta"href="#">Modificar</a></li>
                    <li><a id="eliminarPregunta"href="#">Eliminar</a></li>
                    <li><a id="consultarPregunta"href="#">Consultar</a></li>
                </ul>
            </li> 
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Aplicaciones <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a id="crearAplicacion" href="#">Crear</a></li>
                    <li><a id="modificarAplicacion" href="#">Modificar</a></li>
                    <li><a id="eliminarAplicacion" href="#">Eliminar</a></li>
                    <li><a id="consultarAplicacion" href="#">Consultar</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Ejecutables <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a id="crearEjecutable" href="#">Crear</a></li>
                    <li><a id="modificarEjecutable"href="#">Modificar</a></li>
                    <li><a id="eliminarEjecutable"href="#">Eliminar</a></li>
                    <li><a id="consultarEjecutable"href="#">Consultar</a></li>
                </ul>
            </li>
        
        
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Nodos <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a id="crearNodo" href="#">Crear</a></li>
                    <li><a id="modificarNodo"href="#">Modificar</a></li>
                    <li><a id="eliminarNodo"href="#">Eliminar</a></li>
                    <li><a id="consultarNodo"href="#">Consultar</a></li>
                </ul>
            </li>
            
</ul>
            </div>
        </div>
        </div>
                <div class="row-fluid">
                    <div class="span2">
                            <ul class="breadcrumb">
                                <li><a href="index.jsp">Index</a> <span class="divider">/</span></li>
                             <li class="active">Gestión</li>
                            </ul>
                    </div>
                      
                <div id="infoUsuario" class="span1 offset9" >
            
            <h1 class="pull-right">${sessionScope.nombre} ${sessionScope.apellido}</h1>
           
            <a href="#" class="btn pull-right">Desconectarse</a>
            
                </div>
            
        </div><!--<div class="row-fluid">
                <div id="opciones" class="span1" >
                        <a  href="index.jsp" class="btn">Regresar</a>
                      
                    </div> 
            </div>-->
            <div class="row-fluid">
              
                <div id="operaciones" class="span3 offset3" >
            
            <div id="resultado">
            </div>
        </div>
        
            
            
            </div>
            
            
            
            
        </div>
        </div>
            <div id="footer">
                <div class="container">
                    <p class="text-center">Realizado por: Héctor Félix Sam Colina. Universidad Cátolica Andrés Bello 2013.</p> 
                </div></div>
            
            
            
            
            
      <script type="text/javascript" src="scripts/application.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-affix.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-alert.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-button.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-carousel.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-collapse.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-dropdown.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-modal.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-popover.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-scrollspy.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-tab.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-tooltip.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-transition.js"></script>
      <script type="text/javascript" src="scripts/bootstrap-typeahead.js"></script>
      
    </body>
</html>
