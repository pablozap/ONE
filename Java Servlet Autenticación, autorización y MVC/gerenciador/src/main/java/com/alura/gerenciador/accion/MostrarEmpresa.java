package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MostrarEmpresa implements Accion{
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println("Mostrando Empresa " + id);
        DB db = new DB();
        Empresa emp = db.buscarEmpresaPorId(id);
        System.out.println(emp.getNombre());
        request.setAttribute("empresa", emp);
        return "forward:formModificarEmpresa.jsp";

    }
}
