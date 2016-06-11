/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique;

import utilidades.Fichero;

/**
 *
 * @author Miquel Port
 */
public class Boutique {
    
    public static Fichero miFichero;
    public static ListaPrendas misPrendas;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        miFichero = new Fichero ("boutique.xml");
        misPrendas = (ListaPrendas) miFichero.leer();
        if (misPrendas == null){
            misPrendas = new ListaPrendas();
            
        }
        
        MenuPrincipal m = new MenuPrincipal();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        
        
    }
    
}
