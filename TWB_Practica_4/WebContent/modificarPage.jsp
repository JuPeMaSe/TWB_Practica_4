<?xml version="1.0" encoding="UTF-8"?>
<!-- File: home.jsp -->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"	
   xmlns:html="http://struts.apache.org/tags-html" 	
    xmlns:bean="http://struts.apache.org/tags-bean"	
    xmlns:c="http://java.sun.com/jstl/core_rt"
   version="2.0">
<jsp:directive.page contentType="text/html"/>   
<jsp:output omit-xml-declaration="false"
 doctype-root-element="html"
 doctype-public="-//W3C//DTD XHTML 1.1//EN" 
 doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" />
 <html:html xhtml="true">
<head>
	<link href="threeregion.css" rel="stylesheet" type="text/css" />
	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<title>Modificar Perfil</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
  	<div id="content">   		
	    <h1>Seleccione el perfil a modificar</h1>
  		<html:form action="/mostrarPerfilModificar" enctype="multipart/form-data" > 
			<c:forEach var="perfil" items="${listaPerfiles}">
			<fieldset><legend>Perfil del usuario: ${perfil.user_ID } </legend>
			<table>
			<tr><td>
				<fieldset><legend>Perfil</legend>	
					<table border="1">
						<tr><!-- <th>profile_ID</th> -->
						<th>Dirección</th><th>Localidad</th><th>Provincia</th><th>Pais</th>
						<th>Me gusta</th><th>PDF</th><th>Fotografia</th>
						<!-- <th>user_ID</th>-->
						</tr>
	 					<tr>
	 					<!-- <td>${perfil.profile_ID}</td> -->
	 					<td>${perfil.direccion}</td>
	 					<td>${perfil.localidad}</td>
	 					<td>${perfil.provincia}</td>
	 					<td>${perfil.pais}</td>
	 					<td>${perfil.cont_MeGusta}</td>
	 					<td>${perfil.pdf}</td>
	 					<td>${perfil.fotografia}</td>
	 					<!-- <td>${perfil.user_ID}</td> -->
	 					</tr>	 					
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
 						<tr><!-- <th>exp_ID</th><th>profile_ID</th> -->
 						<th>Empresa</th><th>Cargo</th><th>Fecha Inicio</th><th>Fecha Fin</th></tr>
 						<tr><!-- <td>${expe.exp_ID}</td>
 							<td>${expe.profile_ID}</td> -->
	 						<td>${expe.empresa}</td>
	 						<td>${expe.cargo}</td>
	 						<td>${expe.a_Inicio}</td>
	 						<td>${expe.a_Fin}</td>
	 					</tr>	 		
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
	 								<tr><th>Tecnología:</th><td>${tecnol.nombre_Tec}</td></tr>
	 							</c:if>
	 						</c:forEach>
	 					</c:forEach>
	 				</table>
	 			</fieldset>
	 			</td></tr>
	 			
	 			<tr align="center">
	 			<td colspan="2">
	 			<table>
	 				<td><html:submit property="accion" value="Modificar Perfil: ${perfil.profile_ID}"></html:submit> </td>
	 				
	 			</table>
	 			</td>
	 			</tr>
 			</table> 
 			</fieldset>	 
		</c:forEach> 
		<p></p>
		<html:submit property = "accion" value ="Salir"></html:submit>
		<p></p>
	 </html:form> 
	<p></p>
	<html:link action="home"><bean:message key="tohome.link" /></html:link>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html:html>
</jsp:root>
