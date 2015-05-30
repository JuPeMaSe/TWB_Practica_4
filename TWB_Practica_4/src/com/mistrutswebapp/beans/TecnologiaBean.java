package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class TecnologiaBean extends ValidatorForm implements Serializable{	
	private static final long serialVersionUID = 1L;
	private int tecnologia_ID;
	private String nombre_Tec;
	private String tecnologia_var[];
	
	public TecnologiaBean(){
		super();
	}
	
	/**
	 * @return the tecnologia_var
	 */
	public String[] getTecnologia_var() {
		return tecnologia_var;
	}

	/**
	 * @param tecnologia_var the tecnologia_var to set
	 */
	public void setTecnologia_var(String[] tecnologia_var) {
		this.tecnologia_var = tecnologia_var;
	}

	public int getTecnologia_ID() {
		return tecnologia_ID;
	}
	public void setTecnologia_ID(int tecnologia_ID) {
		this.tecnologia_ID = tecnologia_ID;
	}
	public String getNombre_Tec() {
		return nombre_Tec;
	}
	public void setNombre_Tec(String nombre_Tec) {
		this.nombre_Tec = nombre_Tec;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		
		//Aquí hay que implementar todos los posibles fallos del formulario
		//complementado en WebContent/WEN-INF/classes/ApplicationResources.properties
		//las distintas etiquetas error.loquesea = mensaje a aparecer
		//Si no hay errores, este método devolverá null, con lo que el formulario
		//se considerará correcto y el servidor pasará al Action
		
		return errors;
	}

}