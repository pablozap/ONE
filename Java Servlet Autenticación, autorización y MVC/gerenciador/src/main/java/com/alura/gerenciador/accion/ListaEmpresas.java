package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Accion {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Listando Empresas");
        DB baseDeDatos = new DB();
        List<Empresa> listaEmpresas = baseDeDatos.getEmpresas();

        request.setAttribute("empresas", listaEmpresas);
        return "forward:listaEmpresas.jsp";
    }
}
