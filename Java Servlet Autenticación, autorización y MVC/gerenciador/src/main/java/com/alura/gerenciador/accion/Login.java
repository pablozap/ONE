package com.alura.gerenciador.accion;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login implements Accion{

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("Login y parametros recibidos:" + login + ":" + password);
        DB db = new DB();
        Usuario usuario = db.existeUsuario(login, password);
        if (usuario!=null) {
            System.out.println("Existe el usuario");
            HttpSession session = request.getSession();
            session.setAttribute("loginUsuario", usuario);
            return "redirect:entrada?accion=ListaEmpresas";
        }else {
            return "redirect:entrada?accion=LoginForm";
        }
    }
}
