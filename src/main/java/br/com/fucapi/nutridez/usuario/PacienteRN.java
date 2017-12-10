package br.com.fucapi.nutridez.usuario;

import java.util.List;

import br.com.fucapi.nutridez.util.DAOFactory;

public class PacienteRN {

	private PacienteDAO pacienteDAO;

	public PacienteRN() {
		this.pacienteDAO = DAOFactory.criarPacienteDAO();
	}

	public Paciente carregar(Integer codigo) {
		return this.pacienteDAO.carregar(codigo);
	}

	public void salvar(Paciente paciente) {
		Integer codigo = paciente.getCodigo();
		if (codigo == null || codigo == 0) {

			this.pacienteDAO.salvar(paciente);

		} else {
			this.pacienteDAO.atualizar(paciente);
		}
	}

	public void excluir(Paciente paciente) {
		this.pacienteDAO.excluir(paciente);
	}

	public List<Paciente> listar() {
		return this.pacienteDAO.listar();
	}

	
}
