package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/mostrarEmpresa")
public class MostrarEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        DB db = new DB();
        Empresa emp = db.buscarEmpresaPorId(id);
        System.out.println(emp.getNombre());
        request.setAttribute("empresa", emp);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formModificarEmpresa.jsp");
        requestDispatcher.forward(request, response);
    }
}
