/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Ciudad;
import Negocio.Habitacion;
import Negocio.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class HabitacionMgr {

    private final ArrayList<Habitacion> habitaciones = new ArrayList();
    private static HabitacionMgr INSTANCE = null;
    
    

    public static HabitacionMgr getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HabitacionMgr();
            INSTANCE.llenarHabitacion();
        }
        return INSTANCE;
    }

    @SuppressWarnings("empty-statement")
    private void llenarHabitacion() {

        List<HashMap<String, Object>> listaHabitacion = Habitacion.llenarHabitaciones();

        for (int i = 0; i < listaHabitacion.size(); i++) {
            String id = (String) listaHabitacion.get(i).get("id").toString();
            String nombre = (String) listaHabitacion.get(i).get("nombre");
            String valorDia = (String) listaHabitacion.get(i).get("valor_dia").toString();
            habitaciones.add(new Habitacion(id, nombre, Integer.parseInt(valorDia)));

        }
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList getHabitacionesPorHoteles(ArrayList<String> ids) {
        
        ArrayList<Habitacion> habitacionesHotel = new ArrayList();
        for (int i = 0; i < habitaciones.size(); i++) {
            for (int j = 0; j < ids.size(); j++) {
                if(habitaciones.get(i).getId().equals(ids.get(j))){
                    habitacionesHotel.add(habitaciones.get(i));
                    break;
                }          
            }

        }
        return habitacionesHotel;
    }
    public Habitacion getHabitacion(String id) {
        for (int i = 0; i < habitaciones.size(); i++) {

            if (habitaciones.get(i).getId().equals(id)) {
                return habitaciones.get(i);
            }
        }
        return null;
    }
}
