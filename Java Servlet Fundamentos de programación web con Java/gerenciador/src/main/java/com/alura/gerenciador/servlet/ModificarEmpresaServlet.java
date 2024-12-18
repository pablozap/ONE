package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/modificarEmpresa")
public class ModificarEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("empresa modificada");

        String nombreEmpresa = request.getParameter("nombre");
        String paramFechaAbertura = request.getParameter("fecha");
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);

        Date fechaAbertura;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaAbertura = sdf.parse(paramFechaAbertura);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
        DB db = new DB();
        Empresa empresa = db.buscarEmpresaPorId(id);
        empresa.setNombre(nombreEmpresa);
        empresa.setFechaAbertura(fechaAbertura);
        response.sendRedirect("listaEmpresas");
    }
}
