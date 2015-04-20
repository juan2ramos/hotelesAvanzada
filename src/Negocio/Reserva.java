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
public class Reserva {

    private final String id;
    private final String fechaLLegada;
    private final String fechaSalida;
    private final String numeroHabitaciones;
    private final Ciudad ciudad;
    private final Hotel hotel;
    private Usuario usuario;

    static List<HashMap<String, Object>> listaReservas = null;

    public Reserva(String id, String fechaLLegada, String fechaSalida,String numeroHabitaciones,
            Ciudad ciudad, Hotel hotel, Usuario usuario) {
        this.id = id;
        this.fechaLLegada = fechaLLegada;
        this.fechaSalida = fechaSalida;
        this.numeroHabitaciones = numeroHabitaciones;
        this.ciudad = ciudad;
        this.hotel = hotel;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }
    
    public static List<HashMap<String, Object>> llenarReservas() {
        generateSql pSql = new generateSql();
        try {
            listaReservas = pSql.selectSql("select * from reserva");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaReservas;

    }

    public static void insertarReservas(String id, String fechaLLegada, String fechaSalida,String numeroHabitaciones,
            String ciudad, String hotel, String usuario) {
        generateSql pSql = new generateSql();

        try {
            pSql.selectSql("insert into `hoteles`.`reserva` "
                    + "( `fecha_salida`, `numero_habitaciones`, `fecha_llegada`,"
                    + " `id_usuario`, `id_ciudad`, `id_hotel`)"
                    + " values ( '"+fechaSalida+"', '"+numeroHabitaciones+"', '"+fechaLLegada+"', '"+usuario+"', '"+ciudad+"', '"+hotel+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return id;
    }

}
