package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NuevaEmpresa implements Accion{
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombreEmpresa = request.getParameter("nombre");
        String paramFechaAbertura = request.getParameter("fecha");

        Date fechaAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaAbertura = sdf.parse(paramFechaAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(nombreEmpresa);
        empresa.setFechaAbertura(fechaAbertura);

        DB baseDeDatos = new DB();
        baseDeDatos.agregarEmpresa(empresa);
        System.out.println("nueva empresa registrada");

        return "redirect:entrada?accion=ListaEmpresas";
    }
}
