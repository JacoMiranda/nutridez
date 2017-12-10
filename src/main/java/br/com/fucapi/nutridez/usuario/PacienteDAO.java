package br.com.fucapi.nutridez.usuario;

import java.util.List;

public interface PacienteDAO {

	public void salvar(Paciente paciente);

	public void atualizar(Paciente paciente);

	public void excluir(Paciente paciente);

	public Paciente carregar(Integer codigo);

	public List<Paciente> listar();


}
