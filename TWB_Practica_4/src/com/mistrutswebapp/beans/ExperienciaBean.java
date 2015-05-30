package com.mistrutswebapp.beans;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ExperienciaBean extends ActionForm implements Serializable{
	private String empresa;
	private String cargo;
	private String strA_Inicio;
	private String strA_Fin;
	int a_Inicio;
	int a_Fin;
//	private String empresa_var[];
//	private String cargo_var[];
//	private int a_Inicio_var[];
//	private int a_Fin_var[];
//	private String strA_Inicio_var[];
//	private String strA_Fin_var[];

	
	
//
//	/**
//	 * @return the a_Inicio_var
//	 */
//	public int[] getA_Inicio_var() {
//		return a_Inicio_var;
//	}
//
//	/**
//	 * @param a_Inicio_var the a_Inicio_var to set
//	 */
//	public void setA_Inicio_var(int[] a_Inicio_var) {
//		this.a_Inicio_var = a_Inicio_var;
//	}
//
//	/**
//	 * @return the a_Fin_var
//	 */
//	public int[] getA_Fin_var() {
//		return a_Fin_var;
//	}
//
//	/**
//	 * @param a_Fin_var the a_Fin_var to set
//	 */
//	public void setA_Fin_var(int[] a_Fin_var) {
//		this.a_Fin_var = a_Fin_var;
//	}
//
//	/**
//	 * @return the strA_Inicio_var
//	 */
//	public String[] getStrA_Inicio_var() {
//		return strA_Inicio_var;
//	}
//
//	/**
//	 * @param strA_Inicio_var the strA_Inicio_var to set
//	 */
//	public void setStrA_Inicio_var(String[] strA_Inicio_var) {
//		this.strA_Inicio_var = strA_Inicio_var;
//	}
//
//	/**
//	 * @return the strA_Fin_var
//	 */
//	public String[] getStrA_Fin_var() {
//		return strA_Fin_var;
//	}
//
//	/**
//	 * @param strA_Fin_var the strA_Fin_var to set
//	 */
//	public void setStrA_Fin_var(String[] strA_Fin_var) {
//		this.strA_Fin_var = strA_Fin_var;
//	}

	/**
	 * @return the a_Inicio
	 */
	public int getA_Inicio() {
		return a_Inicio;
	}

	/**
	 * @param a_Inicio the a_Inicio to set
	 */
	public void setA_Inicio(int a_Inicio) {
		this.a_Inicio = a_Inicio;
	}

	/**
	 * @return the a_Fin
	 */
	public int getA_Fin() {
		return a_Fin;
	}

	/**
	 * @param a_Fin the a_Fin to set
	 */
	public void setA_Fin(int a_Fin) {
		this.a_Fin = a_Fin;
	}

	/**
	 * @return the strA_Inicio
	 */
	public String getStrA_Inicio() {
		return (""+a_Inicio);
	}

	/**
	 * @param strA_Inicio the strA_Inicio to set
	 */
	public void setStrA_Inicio(String strA_Inicio) {
		this.strA_Inicio = strA_Inicio;
		this.a_Inicio=Integer.parseInt(strA_Inicio);
	}

	/**
	 * @return the strA_Fin
	 */
	public String getStrA_Fin() {
		return (""+a_Fin);
	}

	/**
	 * @param strA_Fin the strA_Fin to set
	 */
	public void setStrA_Fin(String strA_Fin) {
		this.strA_Fin = strA_Fin;
		this.a_Fin=Integer.parseInt(strA_Fin);
	}

	
	
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
//
//	/**
//	 * @return the empresa_var
//	 */
//	public String[] getEmpresa_var() {
//		return empresa_var;
//	}
//	/**
//	 * @param empresa_var the empresa_var to set
//	 */
//	public void setEmpresa_var(String[] empresa_var) {
//		this.empresa_var = empresa_var;
//	}
//	/**
//	 * @return the cargo_var
//	 */
//	public String[] getCargo_var() {
//		return cargo_var;
//	}
//	/**
//	 * @param cargo_var the cargo_var to set
//	 */
//	public void setCargo_var(String[] cargo_var) {
//		this.cargo_var = cargo_var;
//	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if(!empresa.isEmpty()){
			if ((a_Inicio==0)|| (a_Inicio<1900) ||(a_Inicio>2016)){
				errors.add("a_Inicio", new ActionMessage("error.a_Inicio"));				
			}
			if((a_Fin ==0)|| (a_Fin<1900) ||(a_Fin>2016)){
				errors.add("a_Fin", new ActionMessage("error.a_Fin"));
			}
		}
		
		
		
//		if (empresa.isEmpty() && cargo.isEmpty()) {
//			// si la empresa está vacía y el cargo también, no deben almacenarse las fechas
//			if(!a_Inicio.isEmpty() || !a_Fin.isEmpty()){
//				errors.add("empresa",new ActionMessage("error.empresa"));
//			}
//
//		}
//
//		else if (empresa.isEmpty() && !cargo.isEmpty()) {
//
//			errors.add("empresa", new ActionMessage("error.empresa"));
//		} else if (!empresa.isEmpty() && cargo.isEmpty()) {
//			errors.add("cargo", new ActionMessage("error.cargo"));
//		}
//
//		else {
//
//			if (a_Inicio != null || !a_Inicio.equals("")) {
//				try {
//					Integer.parseInt(a_Inicio);
//				} catch (Exception e) {
//					errors.add("a_Inicio", new ActionMessage("error.a_Inicio"));
//				}
//
//			}
//			if (a_Fin != null || !a_Fin.equals("")) {
//				try {
//					Integer.parseInt(a_Fin);
//				} catch (Exception e) {
//					errors.add("a_Fin", new ActionMessage("error.a_Fin"));
//				}
//
//			}
//		}
		
		return errors;
	}
}
