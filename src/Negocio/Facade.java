/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author juan2ramos
 */
public class Facade {

    public static Facade INSTANCE;
    
    
    

    /**
     * constructor
     */

    public Facade() {
      
    
    }
    public static Facade getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Facade();
        }
        return INSTANCE;
    }

    public ArrayList getCiclictas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
        
}
