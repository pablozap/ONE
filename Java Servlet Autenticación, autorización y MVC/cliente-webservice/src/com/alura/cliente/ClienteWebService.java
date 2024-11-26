package com.alura.cliente;

import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

public class ClienteWebService {
    public static void main(String[] args) {
        String contenido = null;
        try {
            contenido = Request.post("http://localhost:8080/gerenciador_war_exploded/empresas").addHeader("Accept", "Application/json").execute().returnContent().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(contenido);
    }
}
