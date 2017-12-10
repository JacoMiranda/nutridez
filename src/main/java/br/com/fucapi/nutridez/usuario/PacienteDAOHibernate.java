package br.com.fucapi.nutridez.usuario;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PacienteDAOHibernate implements PacienteDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Paciente paciente) {
		this.session.saveOrUpdate(paciente);
	}

	public void atualizar(Paciente paciente) {

		this.session.update(paciente);
	}

	public void excluir(Paciente paciente) {
		this.session.delete(paciente);
	}

	public Paciente carregar(Integer codigo) {
		return (Paciente) this.session.get(Paciente.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listar() {
		return this.session.createCriteria(Paciente.class).list();
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	
}
