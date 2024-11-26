package com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.List;

public class DB {
	
	private static final List<Empresa> listaEmpresas = new ArrayList<>();
	private static final List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer llaveSecuencial = 1;
	static {
		Empresa empresa = new Empresa();
		empresa.setId(llaveSecuencial++);
		empresa.setNombre("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNombre("Caelum");
		empresa2.setId(llaveSecuencial++);
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);

		Usuario user1 = new Usuario();
		user1.setLogin("juan");
		user1.setPassword("0000");
		Usuario user2 = new Usuario();
		user2.setLogin("pablo");
		user2.setPassword("0001");

		listaUsuarios.add(user1);
		listaUsuarios.add(user2);
	}

	public void agregarEmpresa(Empresa empresa) {
		empresa.setId(DB.llaveSecuencial++);
		DB.listaEmpresas.add(empresa);

	}
	
	public List<Empresa> getEmpresas(){
		return DB.listaEmpresas;
	}

	public void eliminarEmpresa(Integer id) {
		for (Empresa empresa: listaEmpresas) {
			if (empresa.getId() == id){
				listaEmpresas.remove(empresa);
				break;
			}

		}
	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa:listaEmpresas) {
			if (empresa.getId() == id){
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String password) {
		for (Usuario usuario: listaUsuarios) {
			if (usuario.esIgual(login, password)){
				return usuario;
			}
		}
		return null;
	}
}
