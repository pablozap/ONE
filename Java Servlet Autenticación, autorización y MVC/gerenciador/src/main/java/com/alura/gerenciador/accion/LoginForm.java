package com.alura.gerenciador.accion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginForm implements Accion{

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:formLogin.jsp";
    }
}
