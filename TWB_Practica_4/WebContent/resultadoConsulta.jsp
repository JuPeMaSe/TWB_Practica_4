<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
     xmlns:c="http://java.sun.com/jstl/core_rt"
     xmlns:fn="http://java.sun.com/jsp/jstl/functions"
   version="2.0">
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
<html:html xhtml="true">
<head>
	<meta http-equiv="Content-Type" content="text/html" />
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<title>Resultado de Consulta</title>
	
	<script languaje="javascript" type="text/javascript">
		function bttnMostrar(variable){
			alert(variable);
			var varAccion= document.getElementByName("mostrar");
			//varAccion.setAttribute("value",""+variable);
			//request.setAttribute("value", variable);
			request.setAttribute("variable", variable);
// 			var requestAction=document.createElement('request');
		
// 			requestAction.setAttribute("name",variable);
			
// 			document.forms[resultadoConsulta].submit();
			
// 	  		txtAction.type='text';
// 	  		txtAction.setAttribute("name","txtProfile_ID");
			
		}
	
	</script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	 	 
	<!-- <div id="content"> --> 
	<html:form action="/mostrarPerfilSelected" enctype="multipartform-data">
	 	<h1>Resultado de la Consulta</h1>
	 	
	 	
	<!--  	<c:forEach var="usuario" items="${listaUsuarios}">
	 		<fieldset><LEGEND>Usuario:</LEGEND>
	 		<table border="1">
	 				<tr><td>user_ID</td><td>${usuario.user_ID}</td><td> </td>
	 				<td>contraseña</td><td>${usuario.password}</td></tr>
	 				<tr><td>nombre</td><td>${usuario.nombre}</td><td> </td>
	 				<td>apellidos</td><td>${usuario.apellidos}</td></tr>
	 				<tr><td>tfno</td><td>${usuario.tfno}</td><td> </td>
	 				<td>email</td><td>${usuario.email}</td></tr>
	 				<tr><td>userType</td><td>${usuario.userType}</td><td></td><td></td></tr>
	 		
	 		</table>
	 		
	 		
	 		</fieldset>
	 	
	 	</c:forEach> -->
	<c:choose>
	<c:when test="${empty listaPerfiles}">
	 		<h3> Ninguna coincidencia encontrada para su consulta</h3>
	</c:when>
	<c:otherwise>	 	
		<c:forEach var="perfil" items="${listaPerfiles}">
			<fieldset><legend>Perfil del usuario: ${perfil.user_ID } </legend>
			<!--<html:button property="mostrar" onclick="parent.location='mostrarPerfilSeleccionado.jsp'">Mostrar Perfil</html:button>-->
			<table>
			<tr><td>
				<fieldset><legend>Perfil</legend>	
					<table border="1">
						<tr><th>profile_ID</th><th>dirección</th><th>localidad</th><th>provincia</th><th>pais</th>
						<th>Me gusta</th><th>pdf(url)</th><th>fotografia</th><th>user_ID</th></tr>
	 		<!-- 			<tr><td>profile_ID</td><td>${perfil.profile_ID}</td><td> </td>
	 						<td>dirección</td><td>${perfil.direccion}</td></tr>
	 					<tr><td>localidad</td><td>${perfil.localidad}</td><td> </td>
	 						<td>provincia</td><td>${perfil.provincia}</td></tr>
	 					<tr><td>pais</td><td>${perfil.pais}</td><td> </td>
	 						<td>cont_MeGusta</td><td>${perfil.cont_MeGusta}</td></tr>
	 					<tr><td>pdf (url)</td><td>${perfil.pdf}</td><td> </td>
	 						<td>fotografia</td><td>${perfil.fotografia}</td></tr>
	 					<tr><td>user_ID</td><td>${perfil.user_ID}</td></tr>  -->
	 					<tr><td>${perfil.profile_ID}</td>
	 					<td>${perfil.direccion}</td>
	 					<td>${perfil.localidad}</td>
	 					<td>${perfil.provincia}</td>
	 					<td>${perfil.pais}</td>
	 					<td>${perfil.cont_MeGusta}</td>
	 					<td>${perfil.pdf}</td>
	 					<td>${perfil.fotografia}</td>
	 					<td>${perfil.user_ID}</td></tr>
	 					
	 				</table>
 				</fieldset>
 				</td>
 				<td>
 				
 				<fieldset><legend>Titulaciones: </legend>
 					<table>
 						<c:forEach var="titu" items="${perfil.listaTit}">
 							<!-- <tr><td>titulacion_ID</td><td>${titu}</td></tr>  -->
 							<c:forEach var="titula" items="${listaTitulaciones}">
	 							<c:if test="${titula.titulacion_ID == titu}">
	 								<tr><th>Titulación: </th><td>${titula.nombre_Tit}</td></tr>
	 							</c:if>
	 						</c:forEach>
 						</c:forEach>
 					</table>
 				</fieldset> 				
 				
 				</td></tr>
 			<!-- </table> -->
 			<!-- <table> -->
 			<tr><td> 				
 				<fieldset><legend>Experiencia: </legend>
 					<c:forEach var="expe" items="${perfil.listaExp}">
 						<table border="1">
 						<tr><th>exp_ID</th><th>profile_ID</th><th>empresa</th><th>cargo</th><th>a_Inicio</th><th>a_Fin</th></tr>
 						<tr><td>${expe.exp_ID}</td>
 							<td>${expe.profile_ID}</td>
	 						<td>${expe.empresa}</td>
	 						<td>${expe.cargo}</td>
	 						<td>${expe.a_Inicio}</td>
	 						<td>${expe.a_Fin}</td></tr>
	 			<!-- 		<tr><td>exp_ID</td><td>${expe.exp_ID}</td><td> </td><td>profile_ID</td><td>${expe.profile_ID}</td></tr>
	 						<tr><td>empresa</td><td>${expe.empresa}</td> <td></td>
	 							<td>cargo</td><td>${expe.cargo}</td></tr>
	 						<tr><td>a_Inicio</td><td>${expe.a_Inicio}</td> <td></td>
	 							<td>a_Fin</td><td>${expe.a_Fin}</td></tr> -->
	 						
	 					</table>
	 				</c:forEach>
 				</fieldset> 						
 				</td>
 				<td>	
	 			<fieldset><legend>Tecnologías: </legend>
	 				<table>
	 					<c:forEach var="tecn" items="${perfil.listaTec}">
	 						<!-- <tr><td>tecnologia_ID</td><td>${tecn}</td></tr>  -->
	 						<c:forEach var="tecnol" items="${listaTecnologias}">
	 							<c:if test="${tecnol.tecnologia_ID == tecn}">
	 								<tr><th>Tecnología: </th><td>${tecnol.nombre_Tec}</td></tr>
	 							</c:if>
	 						</c:forEach>
	 					</c:forEach>
	 				</table>
	 			</fieldset>
	 			</td></tr>
	 			
	 			<tr align="center">
	 			<td colspan="2">
	 			<table>
	 				<td><html:submit property="mostrar" value="Mostrar Perfil: ${perfil.profile_ID}"></html:submit> </td>
	 				<td>   *   *   *   </td>
	 				<td><html:submit property="accion" value="Me gusta: ${perfil.profile_ID}"></html:submit></td>
	 			</table>
	 			</td>
	 			</tr>
 			</table> 
 			
 				<!--  <p align="center"><html:button property="bttnMostrar" onclick="parent.location='mostrarPerfilSeleccionado.jsp'">Mostrar Perfil</html:button></p>-->
 				<!--<html:submit property="mostrar" value="Mostrar Perfil: ${perfil.profile_ID }" onclick="bttnMostrar(${perfil.profile_ID })"></html:submit>-->
 				<!-- 	<html:submit property="accion" value="${perfil.profile_ID }"></html:submit> -->
 				<!-- <html:submit property="accion" value="borrar"></html:submit>	 -->	
 						
 			</fieldset>
 					
							 
		</c:forEach> 
	</c:otherwise>
	</c:choose>
	</html:form>
	<!-- <html:text property="var_Profile"></html:text> -->
		<p></p>
		<p align="center"><html:button property="atras" onclick="parent.location='consultaPage.jsp'">Nueva Consulta</html:button></p>
		<p align="center"><html:link action="home"><bean:message key="tohome.link" /></html:link> </p>
		
		
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>