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
    
    public boolean existe (Prendas p){
        return lista.contains(p);
    }

    public ArrayList<Prendas> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Prendas> lista) {
        this.lista = lista;
    }
     
    
    
    
}
