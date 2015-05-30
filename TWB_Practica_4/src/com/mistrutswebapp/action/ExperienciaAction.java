package com.mistrutswebapp.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mistrutswebapp.beans.ExperienciaBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.beans.TecnologiaBean;
import com.mistrutswebapp.model.Experiencia;

public class ExperienciaAction extends Action{
	
	private static Log log = LogFactory.getLog(ExperienciaAction.class);
	private ExperienciaBean experienciaBean;
	private PerfilBean perfilBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		if (log.isInfoEnabled()) {
//			log.info("In ExperienciaAction");
//		}
		experienciaBean= (ExperienciaBean)form;
		HttpSession sesion = request.getSession();
		sesion.setAttribute("experienciaBean",experienciaBean);
		
//		String empresaValues[] = request.getParameterValues("empresa_var");
//		String cargoValues[] = request.getParameterValues("cargo_var");
//		String a_InicioValues[] = request.getParameterValues("a_Inicio_var");
//		String a_FinValues[] = request.getParameterValues("a_Fin_var");
		
		ArrayList<Experiencia> listaExp = new ArrayList<Experiencia>();		
		//for (int i =0; i< empresaValues.length;i ++){
//			Experiencia experiencia = new Experiencia();			
//			experiencia.setEmpresa(empresaValues[i]);
//			//System.out.println("En ExperienciaAction --> empresValues nº " +i+" "+ empresaValues [i]);
//			experiencia.setCargo(cargoValues[i]);
//			//System.out.println("En ExperienciaAction --> cargoValues nº "+i+" " + cargoValues [i]);
//			experiencia.setA_Inicio(Integer.parseInt(a_InicioValues[i]));
//			//System.out.println("En ExperienciaAction --> a_InicioValues nº "+i+" " + a_InicioValues [i]);
//			experiencia.setA_Fin(Integer.parseInt(a_FinValues[i]));
//			//System.out.println("En ExperienciaAction --> a_FinValues nº "+i+" " + a_FinValues [i]);
		if(!experienciaBean.getEmpresa().isEmpty()){
			Experiencia experiencia = new Experiencia();
			experiencia.setEmpresa(experienciaBean.getEmpresa());
			experiencia.setCargo(experienciaBean.getCargo());
			experiencia.setA_Inicio(experienciaBean.getA_Inicio());
			experiencia.setA_Fin(experienciaBean.getA_Fin());			
			listaExp.add(experiencia);
		}
		if(!listaExp.isEmpty()){
			perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
			perfilBean.setListaExp(listaExp);
		}
		
		
		return mapping.findForward("succes");
	}
}
