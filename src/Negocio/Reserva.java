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
    private final Habitacion habitacion;
    private Usuario usuario;
    private String estado ;

    static List<HashMap<String, Object>> listaReservas = null;

    public Reserva(String id, String fechaLLegada, String fechaSalida,String numeroHabitaciones,
            Ciudad ciudad, Hotel hotel, Usuario usuario, Habitacion habitacion, String estado) {
        this.id = id;
        this.fechaLLegada = fechaLLegada;
        this.fechaSalida = fechaSalida;
        this.numeroHabitaciones = numeroHabitaciones;
        this.ciudad = ciudad;
        this.hotel = hotel;
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.estado = estado;
    }
    public String getId() {
        return id;
    }
    public String getFechaLLegada(){
        return fechaLLegada;
    }
    public String getFechaSalida(){
        return fechaLLegada;
    }
    public String getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public Hotel getHotel() {
        return hotel;
    }

    public Habitacion getHabitacion() {
        return habitacion;
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

 
            String sql = "insert into `hoteles`.`reserva` "
                    + "( `fecha_salida`, `numero_habitaciones`, `fecha_llegada`,"
                    + " `id_usuario`, `id_ciudad`, `id_hotel`)"
                    + " values ( '"+fechaSalida+"', '"+numeroHabitaciones+"', '"+fechaLLegada+"', '"+usuario+"', '"+ciudad+"', '"+hotel+"')";
            System.out.println(sql);
            pSql.update(sql);
    }
    public static void actualizarReserva(String id) {
        generateSql pSql = new generateSql();

 
            String sql = "update `hoteles`.`reserva` set `estado`='1' where `id`='" + id + "' ";
            System.out.println(sql);
            pSql.update(sql);
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public String getEstado() {
        return estado;
    }
    
    @Override
    public String toString() {
        return fechaLLegada;
    }

}
