package com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class DB {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
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
}
