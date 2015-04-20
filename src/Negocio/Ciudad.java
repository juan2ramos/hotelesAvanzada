/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import static Negocio.Hotel.listaHoteles;
import bd.generateSql;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Principal;

/**
 *
 * @author juan2ramos
 */
public class Ciudad {

    private String id;
    private String name;
    static List<HashMap<String, Object>> listaCiudades = null;
    
    public Ciudad(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<HashMap<String, Object>> llenarCiudades() {
        generateSql pSql = new generateSql();

        try {
            listaCiudades = pSql.selectSql("select * from ciudad");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCiudades;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
