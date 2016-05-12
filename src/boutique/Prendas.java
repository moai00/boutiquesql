/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Prendas implements Serializable {

    private String codigo;
    private String descripcion;
    private String color;
    private String talla;
    private double preciocoste;
    private double precioventa;   
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Prendas() {
        codigo = "";
        descripcion = "";
        color = "";
        talla = "";

    }

    public Prendas(String codigo, String descripcion, String color, String talla, double preciocoste, double precioventa, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.color = color;
        this.talla = talla;
        this.preciocoste = preciocoste;
        this.precioventa = precioventa;
        this.stock = stock;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prendas other = (Prendas) obj;
        return codigo.equalsIgnoreCase(other.getCodigo());
    }
    
    

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public double getPreciocoste() {
        return preciocoste;
    }

    public void setPreciocoste(double preciocoste) {
        this.preciocoste = preciocoste;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
