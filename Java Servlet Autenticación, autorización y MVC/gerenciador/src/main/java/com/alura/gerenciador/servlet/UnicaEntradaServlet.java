package com.alura.gerenciador.servlet;

import com.alura.gerenciador.accion.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String parametroAccion = request.getParameter("accion");
        String nombreDeClase = "com.alura.gerenciador.accion." + parametroAccion;
        Class clase;
        String nombre;
        try {
            clase = Class.forName(nombreDeClase);
            Object obj = clase.newInstance();
            Accion accion = (Accion) obj;
            nombre = accion.ejecutar(request, response);
            System.out.println(nombre);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("No se encuentra la pagina");
            throw new ServletException(e);
        }
        String[] tipoYDireccion;
        if (nombre != null) {
            tipoYDireccion = nombre.split(":");
            if (tipoYDireccion[0].equals("forward")){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/View/" + tipoYDireccion[1]);
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect(tipoYDireccion[1]);
            }
        }
    }
}
