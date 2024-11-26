package com.alura.jdbc.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class ProductoController {

    private ProductoDAO productoDao;
    
    public ProductoController() {
        var factory = new ConnectionFactory();
        this.productoDao = new ProductoDAO(factory.recuperaConexion());
    }

    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        return productoDao.modificar(nombre, descripcion, cantidad, id);
    }

    public int eliminar(Integer id) {
        return productoDao.eliminar(id);
    }

    public List<Producto> listar() {
        return productoDao.listar();
    }

    public void guardar(Producto producto){
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        productoDAO.guardar(producto);
    }



    public List<Producto> listar(Categoria categoria) {
        return productoDao.listar(categoria);
    }

}
