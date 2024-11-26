package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModificarEmpresa implements Accion{

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreEmpresa = request.getParameter("nombre");
        Integer id = Integer.valueOf(request.getParameter("id"));
        Date fechaAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaAbertura = sdf.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        DB db = new DB();
        Empresa empresa = db.buscarEmpresaPorId(id);
        empresa.setNombre(nombreEmpresa);
        empresa.setFechaAbertura(fechaAbertura);
        System.out.println("Empresa modificada " + id);
        return "redirect:entrada?accion=ListaEmpresas";
    }
}
