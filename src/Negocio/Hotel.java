/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Controlador.CiudadMgr;
import Controlador.HabitacionMgr;
import bd.generateSql;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Principal;

/**
 *
 * @author juan2ramos
 */
public class Hotel {

    private String id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Ciudad ciudad;
    private List<Habitacion> habitaciones;

    static List<HashMap<String, Object>> listaHoteles = null;

    public Hotel(String id, String nombre, String telefono, String direccion, String idCiudad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = CiudadMgr.getInstance().getCiudad(idCiudad);
        this.habitaciones = habitaciones();
    }

    public static List<HashMap<String, Object>> llenarHoteles() {
        generateSql pSql = new generateSql();
        try {
            listaHoteles = pSql.selectSql("select * from hoteles");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaHoteles;

    }

    public String getId() {
        return id;
    }
    
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    
    private List<Habitacion> habitaciones() {
        generateSql pSql = new generateSql();
        ArrayList ids = new ArrayList();
        List<HashMap<String, Object>> lista = null;
        try {
            lista = pSql.selectSql("SELECT tipo_habitacion.id FROM hoteles "
                    + "INNER JOIN hotel_habitaciones ON hoteles.id = hotel_habitaciones.id_hotel "
                    + "INNER JOIN tipo_habitacion ON tipo_habitacion.id = hotel_habitaciones.id_tipo_habitaciones"
                    + " WHERE id_hotel = " + this.id);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < lista.size(); i++) {
            String idHabitacion = (String) lista.get(i).get("id").toString();
            ids.add(idHabitacion);
        }
        return HabitacionMgr.getInstance().getHabitacionesPorHoteles(ids);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
