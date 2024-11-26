package com.alura.gerenciador.servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoreoFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filtro de Monitoreo");
        long antes = System.currentTimeMillis();
        String accion = request.getParameter("accion");
        chain.doFilter(request, response);
        long despues = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de  " + accion + ": " + (despues-antes));
    }
}
