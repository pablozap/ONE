package com.alura.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filtro de Autorizacion");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String parametroAccion = request.getParameter("accion");

        HttpSession session = request.getSession();

        boolean esUnUsuarioNoLogueado = (session.getAttribute("loginUsuario") == null);
        boolean esUnaAccionProtegida = !(parametroAccion.equals("Login") || parametroAccion.equals("LoginForm"));
        if (esUnUsuarioNoLogueado && esUnaAccionProtegida){
            response.sendRedirect("entrada?accion=LoginForm");
            return;
        }
        chain.doFilter(request, response);
    }
}
