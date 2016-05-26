/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaPrendas implements Serializable{
    
    private ArrayList<Prendas> lista;
    
    public ListaPrendas(){
        lista = new ArrayList<>();
    }
    
    public void altaPrenda(Prendas p){
        lista.add(p);
    }
    
    public int cantidad(){
        return lista.size();
    }
    
    public double valorPrendas(){
        double total = 0;
        
        
        for (Prendas p : lista){
            total += p.getPreciocoste()* (double)p.getStock();
        }
        
        
        return total;
    }
    
    public boolean existe (Prendas p){
        return lista.contains(p);
    }

    public ArrayList<Prendas> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Prendas> lista) {
        this.lista = lista;
    }
    
    //lista de prendas por color
    public ArrayList<String> color(){
        ArrayList<String> col = new ArrayList<>();
        
        for (Prendas p : lista){
            if (!col.contains(p.getColor())){
                col.add(p.getColor());
            }
        }
        
        return col;
    }
    
    
    //devuelve las prendas de un color
    public ListaPrendas prendasPorColor(String color ){
        
        ListaPrendas prendasColor = new ListaPrendas();
        for (Prendas p : lista){
            if (color.equalsIgnoreCase(p.getColor())){
                prendasColor.altaPrenda(p);
            }
        }
        
        return prendasColor;
    }
    
    
    public void bajaPrenda (Prendas p){
        lista.remove(p);
    }
   
     
    
    
    
}
