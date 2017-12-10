package br.com.fucapi.nutridez.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fucapi.nutridez.usuario.Paciente;
import br.com.fucapi.nutridez.usuario.PacienteRN;

@ManagedBean(name = "pacienteBean")
@RequestScoped
public class PacienteBean {
	private Paciente paciente = new Paciente();
	private List<Paciente> lista;
	private String destinoSalvarPaciente;

	public String novo() {
		this.destinoSalvarPaciente = "pacientesucesso";
		this.paciente = new Paciente();
		return "/restrito/cadastrarPaciente";
	}

	public String salvar() {
		
		PacienteRN pacienteRN = new PacienteRN();
		pacienteRN.salvar(this.paciente);

		return "/publico/pacientesucesso";
	}
	public String salvarPaciente() {

		PacienteRN pacienteRN = new PacienteRN();
		pacienteRN.salvar(this.paciente);

		return "/restrito/atenderPaciente";
	}

  public boolean isEditando() {
	  return this.paciente.getCodigo() !=null;
  }
	public String editar() {

		return "/restrito/cadastrarPaciente";
	}
	public String editarPaciente() {

		return "/restrito/editarPacienteAtendido";
	}

	public String excluir() {
		PacienteRN pacienteRN = new PacienteRN();
		pacienteRN.excluir(this.paciente);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.paciente.isAtivo())
			this.paciente.setAtivo(false);
		else
			this.paciente.setAtivo(true);

		PacienteRN pacienteRN = new PacienteRN();
		pacienteRN.salvar(this.paciente);
		return null;
	}

	public List<Paciente> getLista() {
		if (this.lista == null) {
			PacienteRN pacienteRN = new PacienteRN();
			this.lista = pacienteRN.listar();
		}
		return this.lista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDestinoSalvarPaciente() {
		return destinoSalvarPaciente;
	}

	public void setDestinoSalvarPaciente(String destinoSalvarPaciente) {
		this.destinoSalvarPaciente = destinoSalvarPaciente;
	}

	public void setLista(List<Paciente> lista) {
		this.lista = lista;
	}

	
}