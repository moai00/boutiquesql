/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import boutique.ListaPrendas;
import boutique.Prendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class PrendaJDBC {

    private Connection conexion;
    
    
    

    public int totalPrendas() {
        int total = 0;
        conectar();
        if (conexion != null) {
            try {
                String query = "select count(*) from prendas";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()){
                total = rs.getInt(1);
                }
                rs.close();
                st.close();

            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }

        return total;
    }
    
    public ArrayList<String> colorDisponible(){
        ArrayList<String> colores = new ArrayList<>();
        conectar();
        if(conexion != null){
            try{
                String query = "select distinct color from prendas";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    
                    colores.add(rs.getString("color"));
                   
                }
                rs.close();
                st.close();
                }catch (SQLException ex){
                    System.out.println("Error en la consulta " + ex.getMessage());
            }finally {
                desconectar();
            }
        }
        return colores;
    }
    
    public boolean actualizarPrenda(Prendas p) {
        conectar();
        if (conexion != null) {
            try {
                String query = "update prendas set stock = " + p.getStock() +
                        " where codigo = '" + p.getCodigo() + "'";
                Statement st = conexion.createStatement();
                st.executeUpdate(query);
                
                st.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
    
    public ListaPrendas prendaColor(String color){
        ListaPrendas listaPrendas = new ListaPrendas();
        conectar();
        if (conexion != null){
            try {
                String query = "select * from prendas where color='" + color + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                Prendas prenda = new Prendas();
                prenda.setCodigo(rs.getString("codigo"));
                prenda.setDescripcion(rs.getString("descripcion"));
                prenda.setColor(rs.getString("color"));
                prenda.setTalla(rs.getString("talla"));
                prenda.setPreciocoste(rs.getDouble("preciocoste"));
                prenda.setPrecioventa(rs.getDouble("precioventa"));
                prenda.setStock(rs.getInt("stock"));
                listaPrendas.altaPrenda(prenda);
                }
                rs.close();
                st.close();
                
            }catch (SQLException ex){
                System.out.println("Error en la consulta " + ex.getMessage());
            }finally{
                desconectar();
            }
        }
       return listaPrendas; 
    } 
    
    public double valorTotal() {
        double total = 0;
        conectar();
        if (conexion != null) {
            try {
                String query = "select sum(precioventa*stock) from prendas";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()){
                total = rs.getInt(1);
                }
                rs.close();
                st.close();

            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }

        return total;
    }
    
    

    public ListaPrendas selectAllPrendas() {
        ListaPrendas listaPrendas = new ListaPrendas();
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from prendas";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Prendas prenda = new Prendas();
                    prenda.setCodigo(rs.getString("codigo"));
                    prenda.setDescripcion(rs.getString("descripcion"));
                    prenda.setColor(rs.getString("color"));
                    prenda.setTalla(rs.getString("talla"));
                    prenda.setPreciocoste(rs.getDouble("preciocoste"));
                    prenda.setPrecioventa(rs.getDouble("precioventa"));
                    prenda.setStock(rs.getInt("stock"));
                    listaPrendas.altaPrenda(prenda);
                    

                }
                rs.close();
                st.close();

            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }

        return listaPrendas;
    }

    public boolean existePrenda(String codigo) {
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from prendas where codigo='" + codigo + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                boolean existe = false;
                if (rs.next()) {
                    existe = true;
                }
                rs.close();
                st.close();
                return existe;

            } catch (SQLException ex) {
                System.out.println("Error al consultar" + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }

    public boolean insertarPrenda(Prendas prenda) {
        conectar();
        if (conexion != null) {
            try {
                String insert = "insert into prendas values (?,?,?,?,?,?,?)";
                PreparedStatement ps = conexion.prepareStatement(insert);
                ps.setString(1, prenda.getCodigo());
                ps.setString(2, prenda.getDescripcion());
                ps.setString(3, prenda.getColor());
                ps.setString(4, prenda.getTalla());
                ps.setDouble(5, prenda.getPreciocoste());
                ps.setDouble(6, prenda.getPrecioventa());
                ps.setInt(7, prenda.getStock());

                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al insertar" + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }

    }

    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/boutique";
            String usr = "root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, usr, password);

        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex.getMessage());
            conexion = null;
        }
    }

    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar" + ex.getMessage());
        }
    }

}
