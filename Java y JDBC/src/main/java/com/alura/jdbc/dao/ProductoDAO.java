package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {

   final private Connection conexion;

    public ProductoDAO(Connection con) {
        this.conexion = con;
    }
    
    public void guardar(Producto producto) {
        try(conexion) {
            PreparedStatement statement;
                statement = conexion.prepareStatement(
                        "INSERT INTO PRODUCTO "
                        + "(nombre, descripcion, cantidad, categoria_id)"
                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
            try (statement) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setInt(3, producto.getCantidad());
                statement.setInt(4, producto.getCategoriaId());
    
                statement.execute();
    
                final ResultSet resultSet = statement.getGeneratedKeys();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        producto.setId(resultSet.getInt(1));
                        
                        System.out.println(String.format("Fue insertado el producto: %s", producto));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar() {
        List<Producto> resultado = new ArrayList<>();

        try(conexion) {
            final PreparedStatement statement = conexion.prepareStatement(
                    "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int eliminar(Integer id) {
        try(conexion) {
            final PreparedStatement statement = conexion.prepareStatement("DELETE FROM PRODUCTO WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        try(conexion) {
            final PreparedStatement statement = conexion.prepareStatement(
                    "UPDATE PRODUCTO SET "
                    + " NOMBRE = ?, "
                    + " DESCRIPCION = ?,"
                    + " CANTIDAD = ?"
                    + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, nombre);
                statement.setString(2, descripcion);
                statement.setInt(3, cantidad);
                statement.setInt(4, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar(Categoria categoria) {
        List<Producto> resultado = new ArrayList<>();

        try(conexion) {
            String sql = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD "
            + " FROM PRODUCTO WHERE CATEGORIA_ID = ?";
            System.out.println(sql);
            
            final PreparedStatement statement = conexion.prepareStatement(
                    sql);
    
            try (statement) {
                statement.setInt(1, categoria.getId());
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION"),
                                resultSet.getInt("CANTIDAD")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
