/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import static Negocio.Habitacion.listaHabitaciones;
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
public class Usuario {
    
    static List<HashMap<String, Object>> listaUsuarios = null;
    
    private String id ;
    private String nombre ;
    private String apellido ;
    private String documento ;
    private String  telefono;
    
    public Usuario(String id,String nombre ,String apellido ,String documento, String telefono ) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido; //To change body of generated methods, choose Tools | Templates.
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getId() {
        return id;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public static List<HashMap<String, Object>> llenarUsuarios() {
        generateSql pSql = new generateSql();

        try {
            listaUsuarios = pSql.selectSql("select * from usuarios");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuarios;

    }
    public static void insertarUsuarios(String id,String nombre ,String apellido ,String documento, String telefono) {
        generateSql pSql = new generateSql();

     
            String sql = "insert into `hoteles`.`usuarios` ( "
                    + "`documento`, `id`, `apellido`, `nombre`, `telefono`) values ( "
                    + "'" + documento + "', '"+ id +"', '" + apellido + "', '" + nombre + "', '"+ telefono + "');";
            
            System.out.println(sql);
            pSql.update(sql);
        

    }
}
