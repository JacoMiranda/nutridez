package br.com.fucapi.nutridez.util;

import br.com.fucapi.nutridez.usuario.PacienteDAO;
import br.com.fucapi.nutridez.usuario.PacienteDAOHibernate;
import br.com.fucapi.nutridez.usuario.UsuarioDAO;
import br.com.fucapi.nutridez.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;

	}
	
	public static PacienteDAO criarPacienteDAO() {
		PacienteDAOHibernate pacienteDAO = new PacienteDAOHibernate();
		pacienteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pacienteDAO;
	}	
	
	



}


