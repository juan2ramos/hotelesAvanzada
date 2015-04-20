/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author juan2ramos
 */
public class Facade {

    public static Facade INSTANCE;
    private final HotelMgr hotelMgr;
    private final CiudadMgr ciudadMgr;
    private final HabitacionMgr habitacionMgr;
    private final ReservaMgr reservaMgr;
    private final UsuarioMgr usuarioMgr;

    public Facade() {
        hotelMgr = (HotelMgr) Factoria.getInstance().crearObjetos("HotelMgr");
        ciudadMgr = (CiudadMgr) Factoria.getInstance().crearObjetos("CiudadMgr");
        habitacionMgr = (HabitacionMgr) Factoria.getInstance().crearObjetos("HabitacionMgr");
        
        reservaMgr = (ReservaMgr) Factoria.getInstance().crearObjetos("ReservaMgr");
        usuarioMgr = (UsuarioMgr) Factoria.getInstance().crearObjetos("UsuarioMgr");

    }

    public static Facade getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Facade();
        }
        return INSTANCE;
    }

}
