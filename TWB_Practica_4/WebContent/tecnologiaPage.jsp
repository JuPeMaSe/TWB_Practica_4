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
<!-- 	<jsp:useBean id="loginBean" class= "com.mistrutswebapp.beans.LoginBean" scope="session"></jsp:useBean>
	<jsp:useBean id= "perfilBean" class="com.mistrutswebapp.beans.PerfilBean" scope="session"/>
	<jsp:useBean id= "titulacionBean" class="com.mistrutswebapp.beans.TitulacionBean" scope="session"/> -->
	<jsp:useBean id= "tecnologiaBean" class="com.mistrutswebapp.beans.TecnologiaBean" scope="session"/>
	<title>Crear perfil</title>
</head>
<body>
 	 
 	
 	<div id="content">
	
			<!-- el action tendrá que ir hacia processCrear -->
			<!--<html:form action="/processTecnologia" enctype="multipartform-data">-->
			<fieldset><legend>Tecnologías:</legend>
				<table>
					<tr>
						<td><label for="tecnologia_var">Tecnología:</label></td>
						 <td><html:select property="tecnologia_var" name="tecnologiaBean" multiple= "multiple">
							  	<c:forEach var="tecn"  items="${listaTecnologias}" >
						 		<c:set var="tecn_ID" scope="page" value= "${tecn.tecnologia_ID}"/>
						 		<html:option value="${tecn_ID}">${tecn.nombre_Tec}</html:option>					 
							</c:forEach> 
						 	</html:select></td>  
						<td><html:errors property="nombre_Tec" /></td>
					</tr>
				</table>
			</fieldset>
				
			<!--</html:form>-->
		
		
	</div>
	
</body>
</html:html>
</jsp:root>
