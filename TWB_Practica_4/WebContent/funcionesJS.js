function newTitulacion(nombre){
		var posicion=document.getElementById("posicionActual");
 		var nuevaTabla = document.createElement('TABLE');
 		var LineaTr = document.createElement('TR');
   		var LineaTd=document.createElement('TD');
		var lbl=document.createElement('label');
 		var texto=document.createTextNode("Titulacion: ");
 		lbl.appendChild(texto);
 		LineaTd.appendChild(lbl);
 		LineaTr.appendChild(LineaTd);
 		LineaTd=document.createElement('TD');
		lbl=document.createElement('label');
 		texto=document.createTextNode("En pruebas");
 		lbl.appendChild(texto);
 		LineaTd.appendChild(lbl);
 		LineaTr.appendChild(LineaTd);
 		nuevaTabla.appendChild(LineaTr);
 		nuevaTabla.setAttribute("border","0");
 		posicion.appendChild(nuevaTabla);
	} 