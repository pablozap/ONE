package com.alura.gerenciador.servlet;

import com.alura.gerenciador.accion.Accion;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filtro del Controlador");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

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

        if (nombre != null) {
            String[] tipoYDireccion = nombre.split(":");
            if (tipoYDireccion[0].equals("forward")){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/View/" + tipoYDireccion[1]);
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect(tipoYDireccion[1]);
            }
        }


    }
}
