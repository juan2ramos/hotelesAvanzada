/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Ciudad;
import Negocio.Habitacion;
import Negocio.Hotel;
import Negocio.Reserva;
import Negocio.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class ReservaMgr {

    private final ArrayList<Reserva> reservas = new ArrayList();
    private static ReservaMgr INSTANCE = null;

    public static ReservaMgr getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ReservaMgr();
            INSTANCE.llenarReserva();
        }
        return INSTANCE;
    }
    private void llenarReserva(){
        
        List<HashMap<String, Object>> listaReserva = Reserva.llenarReservas();
        
        for (int i = 0; i < listaReserva.size(); i++) {    
            String id = (String) listaReserva.get(i).get("id").toString();
            String fechaLlegada = (String) listaReserva.get(i).get("fecha_llegada").toString();
            String fechaSalida = (String) listaReserva.get(i).get("fecha_salida").toString();
            String numeroHabitaciones = (String) listaReserva.get(i).get("numero_habitaciones").toString();
            
            String idHotel = (String) listaReserva.get(i).get("id_hotel").toString();
            String idUsuario = (String) listaReserva.get(i).get("id_usuario").toString();
            String idCiudad = (String) listaReserva.get(i).get("id_ciudad").toString();
            
            Hotel hotel = HotelMgr.getInstance().getHotel(idHotel);
            Ciudad ciudad = CiudadMgr.getInstance().getCiudad(idCiudad);
            Usuario usuario = UsuarioMgr.getInstance().getUsuario(idUsuario);
       
            reservas.add(new Reserva(id,fechaLlegada,fechaSalida,numeroHabitaciones,ciudad,hotel,usuario));
                
        }
    }
    public void crearReserva(Ciudad ciudad,Hotel hotel,Habitacion habitacion, String Nuhabitaciones,
            String llegada,String salida,String nombres,String apellidos,String documento,String telefono){
            
            Usuario usuario =  UsuarioMgr.getInstance().crearUsuario(nombres, apellidos, documento, telefono);
            Integer idReserva = Integer.parseInt(reservas.get(reservas.size() - 1).getId()) + 1;
            Reserva.insertarReservas(idReserva.toString(),llegada,salida,Nuhabitaciones,ciudad.getId(),hotel.getId(),usuario.getId());
            reservas.add(new Reserva(idReserva.toString(),llegada,salida,Nuhabitaciones,ciudad,hotel,usuario));
            
    }
    public ArrayList<Reserva> buscarReserva(String cedula){
        ArrayList<Reserva> reservasPorUsuario = new ArrayList();
        
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().getDocumento().equals(cedula)) {
                reservasPorUsuario.add(reserva);
                System.out.print("jsjsj");
            }
        }
        return reservasPorUsuario;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
  
    
    
    

}
