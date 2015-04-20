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
public class Habitacion {

    static List<HashMap<String, Object>> listaHabitaciones = null;
    
    private String id;
    private String nombre;
    private int valorDia;

    public Habitacion(String id,String nombre, int valorDia) {
        this.id = id;
        this.nombre = nombre;
        this.valorDia = valorDia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorDia() {
        return valorDia;
    }

    public void setValorDia(int valorDia) {
        this.valorDia = valorDia;
    }

    @Override
    public String toString() {
        return this.nombre; //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
    public static List<HashMap<String, Object>> llenarHabitaciones() {
        generateSql pSql = new generateSql();

        try {
            listaHabitaciones = pSql.selectSql("select * from tipo_habitacion");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaHabitaciones;

    }
}
