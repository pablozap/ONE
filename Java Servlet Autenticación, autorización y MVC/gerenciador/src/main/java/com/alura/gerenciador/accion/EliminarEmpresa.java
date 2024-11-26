package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EliminarEmpresa implements Accion{
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println("Eliminando Empresa " + id);
        DB db = new DB();
        db.eliminarEmpresa(id);
        return "redirect:entrada?accion=ListaEmpresas";
    }
}
