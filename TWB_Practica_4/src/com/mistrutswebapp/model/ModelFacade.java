package com.mistrutswebapp.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mistrutswebapp.beans.PerfilBean;
import com.mistrutswebapp.beans.UsuarioBean;
import com.mistrutswebapp.dao.PerfilDAO;
import com.mistrutswebapp.dao.UsuarioDAO;

public class ModelFacade {
	private static Log log = LogFactory.getLog(ModelFacade.class);
	/**
	 * Crea un perfil y lo guarda en la BD a partir de los datos introducidos
	 * en el formulario y obtenidos del bean PerfilBean
	 * @param perfilBean
	 * @return Perfil
	 */
	public static Perfil crearPerfil(PerfilBean perfilBean){
		Perfil perfil= new Perfil();
		//Experiencia experiencia = new Experiencia();
		ArrayList<Experiencia> listaExp = new ArrayList<Experiencia>();
		try {
			//pasamos las propiedades del PerfilBean al Perfil
			PropertyUtils.copyProperties(perfil,  perfilBean);
			//PropertyUtils.copyProperties(experiencia, experienciaBean);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			log.error(e.getMessage());
		}	
		//completamos las propiedades que faltan del perfil
		perfil.setCont_MeGusta(0);
		perfil.setUser_ID(perfilBean.getUser_ID());
		//añade una referencia única al perfil para poder ser identificado
		perfil.setReference(ReferenceGenerator.getReference(perfilBean.getUser_ID()));
		
		//escribimos el perfil en la base de datos
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.crearPerfil(perfil);
		
		//Añadimos las titulacione, tecnologías y experiencias
		int intProfile_ID = perfilDAO.getProfile_ID(perfil);		
		perfilDAO.addTitulacion(intProfile_ID, perfil);
		perfilDAO.addTecnologia(intProfile_ID, perfil);		
		listaExp = perfilBean.getListaExp();
		for(int i=0;i<listaExp.size();i++){
			perfilDAO.addExperiencia(intProfile_ID, listaExp.get(i));
		}
			
		return perfil;
	}
	
	
	/**
	 * Crea un usuario y lo guarda en la BD a partir de los datos introducidos
	 * en el formulario y obtenidos del bean UsuarioBean
	 * @param usuarioBean
	 * @return Usuario
	 */
	public static Usuario crearUsuario(UsuarioBean usuarioBean) {
		Usuario usuario =new Usuario();
		try{
			PropertyUtils.copyProperties(usuario, usuarioBean);
			//log.info("copy propertues usuario apellidos== "+ usuario.getApellidos());
		}catch(IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e){
		    log.error(e.getMessage());
		   // return null;
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.crearUsuario(usuario);
		
		return usuario;
	}
	
	/**
	 * Devuelve una colección con los usuarios registrados en la BD y que
	 * cumplen con la condición expresada en whereClause
	 * @param whereClause
	 * @return Collection<Usuario>
	 */
	public static Collection<Usuario> getUsuarios(String whereClause){
		// if no 'where' clause string is passed in, create an empty string
		  if(whereClause == null){
			  whereClause = new String();
		  }
		  UsuarioDAO udao = new UsuarioDAO();
		  Collection<Usuario> usuarioCollection = udao.leerUsuarios(whereClause);
		  return usuarioCollection;
	}
	
	/**
	 * Devuelve una colección con los perfiles que se encuentran registrados en la BD y que
	 * cumplen con la condición expresada en whereClause
	 * @param whereClause
	 * @return Collection<Perfil>
	 */
	public static Collection<Perfil> getPerfiles(String whereClause){
		// if no 'where' clause string is passed in, create an empty string
		  if(whereClause == null){
			  whereClause = new String();
		  }
		  PerfilDAO pdao = new PerfilDAO();
		  Collection<Perfil> perfilCollection = pdao.leerPerfiles(whereClause);
		  return perfilCollection;
	}
	
	/**
	 * Modificación del método getPerfiles
	 */

	public static Collection<Perfil> getPerfiles(String strPerfil, String strTitu, String strTecn, String strExpe){
		 if(strPerfil == null){
			  strPerfil = new String();
		  }
		 if(strTitu == null){
			  strTitu = new String();
		  }
		 if(strTecn == null){
			  strTecn = new String();
		  }
		 if(strExpe == null){
			  strExpe = new String();
		  }
		  PerfilDAO pdao = new PerfilDAO();
		  Collection<Perfil> perfilCollection = pdao.leerPerfiles(strPerfil, strTitu, strTecn, strExpe);
		  return perfilCollection;
		
	}
	
	public static void eliminarPerfilesUsuario(String user_ID){
		PerfilDAO pdao= new PerfilDAO();
		pdao.eliminarPerfilesUsuario(user_ID);
	}
	
	
	
	public static void eliminarPerfil(int profile_ID){		 
		 PerfilDAO pdao = new PerfilDAO();
		 pdao.eliminarPerfil(profile_ID);
		 
		 
		 }
	
	
	public static void eliminarUsuario(String user_ID){
		UsuarioDAO udao = new UsuarioDAO();
		udao.eliminarUsuario(user_ID);
	}

	public static void addMegusta(int intProfile_ID){
		PerfilDAO pdao= new PerfilDAO();
		pdao.addMegusta(intProfile_ID);
	}

	
	public static void modificarPerfil(PerfilBean perfilBean){
		PerfilDAO pdao = new PerfilDAO();
		Perfil perfil = new Perfil();
		try {
			PropertyUtils.copyProperties(perfil,perfilBean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pdao.modificarPerfil(perfil);
	}
}
