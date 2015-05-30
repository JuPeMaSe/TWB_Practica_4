package com.mistrutswebapp.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.mistrutswebapp.beans.LoginBean;
import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.model.Experiencia;


public class CrearAction extends Action {
	private static Log log = LogFactory.getLog(CrearAction.class);
	private PerfilBean perfilBean;
	private LoginBean loginBean;
//	private TitulacionBean titulacionBean;
//	private TecnologiaBean tecnologiaBean;
//	private ExperienciaBean experienciaBean;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		perfilBean = (PerfilBean)form;
		HttpSession sesion = request.getSession();
		loginBean = (LoginBean)sesion.getAttribute("loginBean");
		
		//System.out.println("CrearAction - opcionSelec --> "+ sesion.getAttribute("opcionSelec"));

		//System.out.println("Tamaño lista --> "+perfilBean.getListaTit().size());
		String accion = perfilBean.getAccion();
		System.out.println("CrearAction. accion --> "+ accion);
		//return mapping.findForward("succes");
		if(accion.substring(0,13).equals("Eliminar Titu")){
			int intClave = Integer.parseInt(accion.substring(20));
			ArrayList<Integer>listaProv = new ArrayList<Integer>();
			listaProv=perfilBean.getListaTit();				 
			System.out.println("eliminar titulación --> litaProv.size = "+perfilBean.getListaTit().size());
			for (int i=0;i<listaProv.size();i++){
				if(listaProv.get(i)==intClave){						
					listaProv.remove(i);
				}
			}
			perfilBean.setListaTit(listaProv);
			return mapping.findForward("refresh");				 
		}
		
		if(accion.substring(0,13).equals("Nueva Titulac")){
			int Titu = perfilBean.getTitulacion_ID();
			if (Titu!=0){
				perfilBean.addTit(Titu);
			}
//			System.out.println("pulsado Nueva Titu--> " +perfilBean.getTitulacion_ID());
			return mapping.findForward("refresh");
		}
		
		if(accion.substring(0,13).equals("Eliminar Tecn")){			 
			 int intClave = Integer.parseInt(accion.substring(20));
			 ArrayList<Integer>listaProv = new ArrayList<Integer>();
			 listaProv=perfilBean.getListaTec();
			 for (int i=0;i<perfilBean.getListaTec().size();i++){
				 System.out.println("eliminar Tecnologia for " + i);
				 if(perfilBean.getListaTec().get(i)==intClave){
					 listaProv.remove(i);
				 }
			 }
			 perfilBean.setListaTec(listaProv);
			 return mapping.findForward("refresh");
		 }
		
		if(accion.substring(0,13).equals("Nueva Tecnolo")){
			 int Tecn = perfilBean.getTecnologia_ID();
			 if(Tecn!=0){
				 perfilBean.addTec(Tecn);
			 }
//			 System.out.println("pulsado Nueva Titu--> " +perfilBean.getTitulacion_ID());
			 return mapping.findForward("refresh");
		}
		
		if(accion.substring(0,13).equals("Eliminar Expe")){
			int intClave = Integer.parseInt(accion.substring(20));
			 ArrayList<Experiencia>listaProv = new ArrayList<Experiencia>();
			 listaProv=perfilBean.getListaExp();
			 System.out.println("eliminar experiencia --> litaProv.size = "+perfilBean.getListaExp().size());
			 for (int i=0;i<perfilBean.getListaExp().size();i++){
				 if(perfilBean.getListaExp().get(i).getExp_ID()==intClave){
					 listaProv.remove(i);
				 }
			 }
			 
			 perfilBean.setListaExp(listaProv);
			 return mapping.findForward("refresh");
		 }
		 
		if(accion.substring(0,13).equals("Nueva Experie")){
//			if(!mpmb.getEmpresa().isEmpty()){
//				 String empresa = mpmb.getEmpresa();
//				 String cargo = mpmb.getCargo();
//				 int a_Inicio = mpmb.getA_Inicio();
//				 int a_Fin = mpmb.getA_Fin();
			if(!perfilBean.getEmpresa().isEmpty()){
				 String empresa = perfilBean.getEmpresa();
				 String cargo = perfilBean.getCargo();
				 int a_Inicio = perfilBean.getA_Inicio();
				 int a_Fin = perfilBean.getA_Fin();
				 Experiencia expe = new Experiencia();
				 expe.setEmpresa(empresa);
				 expe.setCargo(cargo);
				 expe.setA_Inicio(a_Inicio);
				 expe.setA_Fin(a_Fin);
				 expe.setProfile_ID(perfilBean.getProfile_ID());
				 expe.setExp_ID(perfilBean.getListaExp().size()+1);
				 perfilBean.getListaExp().add(expe);
				 System.out.println("pulsado Nueva Exp size()--> "+ perfilBean.getListaExp().size());	
				 //mpmb.resetExper();
				 //perfilBean.resetExper();
			}
			 
			 return mapping.findForward("refresh");
		}

		
//		
//		
////		if(accion.substring(0,13).equals("Eliminar Expe")){
////			perfilBean.setEmpresa("");
////			perfilBean.setCargo("");
////			perfilBean.setA_Fin(0);
////			perfilBean.setA_Inicio(0);
////			if(perfilBean.getListaExp().size()>0){
////				perfilBean.setListaExp(null);
////			}
//////			 System.out.println("eliminar Experiencia " + accion.substring(20));
//////			 int intClave = Integer.parseInt(accion.substring(20));
//////			 ArrayList<Experiencia>listaProv = new ArrayList<Experiencia>();
//////			 listaProv=perfilBean.getListaExp();
//////			 for (int i=0;i<listaProv.size();i++){
//////				 if(listaProv.get(i).getExp_ID()==intClave){
//////					 listaProv.remove(i);
//////				 }
//////			 }
//////			 perfilBean.setListaExp(listaProv);
////			 return mapping.findForward("refresh");
////		 }
//		
//		ArrayList<Integer> listaTit = new ArrayList<Integer>();
//		if(perfilBean.getListaTit()==null){
//			listaTit.add(0);
////		}else{
////			String titValues[] = request.getParameterValues("titulacion_var");
////			for (int i =0; i< titValues.length;i ++){
////				int t = Integer.parseInt(titValues[i]);
////				listaTit.add(t);
////			}
//			
//			perfilBean.setListaTit(listaTit);
//		}
//		
////		if(request.getParameterValues("titulacion_var")==null){
////			listaTit.add(0);
////		}else{
////			String titValues[] = request.getParameterValues("titulacion_var");
////			for (int i =0; i< titValues.length;i ++){
////				int t = Integer.parseInt(titValues[i]);
////				listaTit.add(t);
////			}
////		}
//		//perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
//	
////		
////		
////		 System.out.print("PerfilBean --> "+ perfilBean.getProfile_ID());
////		 System.out.print(" \\ "+ perfilBean.getPais());
////		 System.out.print(" \\ "+ perfilBean.getProvincia());
////		 System.out.print(" \\ "+ perfilBean.getLocalidad());
////		 System.out.print(" \\ "+ perfilBean.getDireccion());
////		 System.out.print(" \\ "+ perfilBean.getPdf());
////		 System.out.print(" \\ "+ perfilBean.getFotografia());
////		// System.out.print(" \\ "+ perfilBean.getListaTit().toString());
////		 System.out.println(" \\ "+ perfilBean.getUser_ID());
////		// System.out.print("ModificarBean --> "+ mpmb.getProfile_ID());
////		
//		 
//		
//		perfilBean.setUser_ID(loginBean.getUser_ID());
//		//ModelFacade.crearPerfil(perfilBean);
//		// sesion.setAttribute("perfilBean", perfilBean);
//		 
//			
//			for(int i=0; i<listaTit.size();i++){
//				 System.out.println("ListaTit titulacion_ID --> "+listaTit.get(i));
////				 System.out.print(" \\ "+ titulacionBean.getNombre_Tit());
////				 System.out.print(" \\ "+ titulacionBean.getTitulacion_var()[i]);
////				 System.out.println(" \\ "+ titulacionBean.getPage());
//			}
//			
////			tecnologiaBean=(TecnologiaBean) sesion.getAttribute("tecnologiaBean");
////			tecnologiaBean.setTecnologia_var(request.getParameterValues("tecnologia_var"));
//			ArrayList<Integer> listaTec = new ArrayList<Integer>();	
//			if(perfilBean.getListaTec()==null){
//				listaTec.add(0);
////			}else{
////				String tecValues[] = request.getParameterValues("tecnologia_var");
////				for (int i =0; i< tecValues.length;i ++){
////					int t = Integer.parseInt(tecValues[i]);
////					listaTec.add(t);
////				}
//				perfilBean.setListaTec(listaTec);
//			}
////			if(request.getParameterValues("tecnologia_var")==null){
////				listaTec.add(0);
////			}else{
////				String tecValues[] = request.getParameterValues("tecnologia_var");
////				for (int i =0; i< tecValues.length;i ++){
////					int t = Integer.parseInt(tecValues[i]);
////					listaTec.add(t);
////				}
////			}
//			
//			//perfilBean = (PerfilBean)sesion.getAttribute("perfilBean");
//		
//			
//			for(int i=0; i<listaTec.size();i++){
//				 System.out.println("ListaTec tecnologia_ID --> "+listaTec.get(i));
////				 System.out.print(" \\ "+ titulacionBean.getNombre_Tit());
////				 System.out.print(" \\ "+ tecnologiaBean.getTecnologia_var()[i]);
////				 System.out.println(" \\ "+ titulacionBean.getPage());
//			}
//			
////			experienciaBean = (ExperienciaBean) sesion.getAttribute("experienciaBean");
////			String empresaValues[] = request.getParameterValues("empresa_var");
////			String cargoValues[] = request.getParameterValues("cargo_var");
////			String a_InicioValues[] = request.getParameterValues("a_Inicio_var");
////			String a_FinValues[] = request.getParameterValues("a_Fin_var");
//			
//			ArrayList<Experiencia> listaExp = new ArrayList<Experiencia>();		
//			//for (int i =0; i< empresaValues.length;i ++){
////				Experiencia experiencia = new Experiencia();			
////				experiencia.setEmpresa(empresaValues[i]);
////				//System.out.println("En ExperienciaAction --> empresValues nº " +i+" "+ empresaValues [i]);
////				experiencia.setCargo(cargoValues[i]);
////				//System.out.println("En ExperienciaAction --> cargoValues nº "+i+" " + cargoValues [i]);
////				experiencia.setA_Inicio(Integer.parseInt(a_InicioValues[i]));
////				//System.out.println("En ExperienciaAction --> a_InicioValues nº "+i+" " + a_InicioValues [i]);
////				experiencia.setA_Fin(Integer.parseInt(a_FinValues[i]));
////				//System.out.println("En ExperienciaAction --> a_FinValues nº "+i+" " + a_FinValues [i]);
//			if(!perfilBean.getEmpresa().isEmpty()){
//				Experiencia experiencia = new Experiencia();
//				experiencia.setEmpresa(perfilBean.getEmpresa());
//				experiencia.setCargo(perfilBean.getCargo());
//				experiencia.setA_Inicio(perfilBean.getA_Inicio());
//				experiencia.setA_Fin(perfilBean.getA_Fin());			
//				listaExp.add(experiencia);
//			}
//			if(!listaExp.isEmpty()){
//				perfilBean.setListaExp(listaExp);
//			}
//			
//			
//			
//			
//			//sesion.setAttribute("experienciaBean",experienciaBean);
//			//sesion.setAttribute("tecnologiaBean", tecnologiaBean);
//			//sesion.setAttribute("titulacionBean", titulacionBean);
//			sesion.setAttribute("perfilBean", perfilBean);
		 
		
		if(accion.substring(0,13).equals("Eliminar Foto")){			
			perfilBean.setFotografia("");
			 return mapping.findForward("refresh");
		 }
		
		
		if(accion.substring(0,13).equals("Nueva Fotogra")){
			//Me guarda el archivo en la dirección que el servlet tiene definida en su contexto
			 FileOutputStream outputStream = null;
			 FormFile formFileFoto = null;
			 String path="";
			 formFileFoto = perfilBean.getFotografia_file();
			 if(formFileFoto != null && !formFileFoto.getFileName().equals("")) {  
				  try { 
				     path = getRepositoryPath() +  formFileFoto.getFileName();
					  System.out.println("File will be uploaded to this path: " + path);
					  perfilBean.setFotografia(formFileFoto.getFileName());
				     outputStream = new FileOutputStream(new File(path));
				     outputStream.write(formFileFoto.getFileData());				  
				  } catch(Exception exception) {
				   System.out.println(exception);
				  }finally {
				      if (outputStream != null) {
				          try {
							outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				      }
				  }
				  System.out.println("The file " + formFileFoto.getFileName() + " was uploaded successfully.");
			 }
			 return mapping.findForward("refresh");
		}
		
		

		if(accion.substring(0,13).equals("Eliminar Arch")){			
			perfilBean.setPdf("");
			 return mapping.findForward("refresh");
		 }
		
		if(accion.substring(0,13).equals("Nuevo Archivo")){
			 FileOutputStream outputStream = null;
			 FormFile formFilePdf = null;
			 String path="";
			 formFilePdf = perfilBean.getPdf_file();
			 if(formFilePdf != null && !formFilePdf.getFileName().equals("")) {  
				  try { 
				     path = getRepositoryPath() +  formFilePdf.getFileName();
					  System.out.println("File will be uploaded to this path: " + path);
					  perfilBean.setPdf(formFilePdf.getFileName());
				     outputStream = new FileOutputStream(new File(path));
				     outputStream.write(formFilePdf.getFileData());
				  
				  } catch(Exception exception) {
				   System.out.println(exception);
				  }finally {
				      if (outputStream != null) {
				          try {
							outputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				      }
				  }
				  System.out.println("The file " + formFilePdf.getFileName() + " was uploaded successfully.");
			 }	
			 return mapping.findForward("refresh");
		}
		
		
//		//Me guarda el archivo en la dirección que el servlet tiene definida en su contexto
//		 FileOutputStream outputStream = null;
//		 FormFile formFileFoto = null;
//		 FormFile formFilePdf = null;
//		 String path="";
//		 formFileFoto = perfilBean.getFotografia_file();
//		 formFilePdf = perfilBean.getPdf_file();
//		 if(formFileFoto != null && !formFileFoto.getFileName().equals("")) {  
//			  try { 
//			     path = getRepositoryPath() +  formFileFoto.getFileName();
//				  System.out.println("File will be uploaded to this path: " + path);
//				  perfilBean.setFotografia(formFileFoto.getFileName());
//			     outputStream = new FileOutputStream(new File(path));
//			     outputStream.write(formFileFoto.getFileData());
//			  
//			  } catch(Exception exception) {
//			   System.out.println(exception);
//			  }finally {
//			      if (outputStream != null) {
//			          try {
//						outputStream.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			      }
//			  }
//			  System.out.println("The file " + formFileFoto.getFileName() + " was uploaded successfully.");
//		 }
//		 if(formFilePdf != null && !formFilePdf.getFileName().equals("")) {  
//			  try { 
//			     path = getRepositoryPath() +  formFilePdf.getFileName();
//				  System.out.println("File will be uploaded to this path: " + path);
//				  perfilBean.setPdf(formFilePdf.getFileName());
//			     outputStream = new FileOutputStream(new File(path));
//			     outputStream.write(formFilePdf.getFileData());
//			  
//			  } catch(Exception exception) {
//			   System.out.println(exception);
//			  }finally {
//			      if (outputStream != null) {
//			          try {
//						outputStream.close();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//			      }
//			  }
//			  System.out.println("The file " + formFilePdf.getFileName() + " was uploaded successfully.");
//		 }
		 perfilBean.setUser_ID(loginBean.getUser_ID());
		 sesion.setAttribute("perfilBean", perfilBean);
		return mapping.findForward("succes");
	}
//		/**
//		 * This path where the file will be uploaded is put in a method to allow
//		 * classes extending to be able to override it.
//		 * @return
//		 */
		private String getRepositoryPath(){
			return getServlet().getServletContext().getRealPath("")+"/";
		}
//		
}
