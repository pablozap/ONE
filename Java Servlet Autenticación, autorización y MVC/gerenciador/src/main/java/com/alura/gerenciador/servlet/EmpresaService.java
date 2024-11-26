package com.alura.gerenciador.servlet;

import com.alura.gerenciador.modelo.DB;
import com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/empresas")
public class EmpresaService extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empresa> empresas = new DB().getEmpresas();

        String valor = request.getHeader("Accept");
        if (valor.contains("xml")){
            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            String xml = xStream.toXML(empresas);
            response.setContentType("Application/xml");
            response.getWriter().println(xml);
        } else if (valor.contains("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(empresas);
            response.setContentType("Application/json");
            response.getWriter().println(json);
        } else {
            response.setContentType("Application/json");
            response.getWriter().println("{'message':'No content'}");
        }

    }
}
