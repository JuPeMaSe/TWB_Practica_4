package com.mistrutswebapp.beans;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;

public class ResultadoConsultaBean extends ValidatorForm implements Serializable{
	private int oculto;
	private int var_Profile;
	private String accion;
	private String mostrar;

	/**
	 * @return the mostrar
	 */
	public String getMostrar() {
		return mostrar;
	}

	/**
	 * @param mostrar the mostrar to set
	 */
	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the var_Profile
	 */
	public int getVar_Profile() {
		return var_Profile;
	}

	/**
	 * @param var_Profile the var_Profile to set
	 */
	public void setVar_Profile(int var_Profile) {
		this.var_Profile = var_Profile;
	}

	/**
	 * @return the oculto
	 */
	public int getOculto() {
		return oculto;
	}

	/**
	 * @param oculto the oculto to set
	 */
	public void setOculto(int oculto) {
		this.oculto = oculto;
	}

}
