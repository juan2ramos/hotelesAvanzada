/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author juan2ramos
 */
public class Factoria implements ObjectsInterface{

    private static Factoria INSTANCE = null;

    public static Factoria getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Factoria();
        }
        return INSTANCE;
    }

    public ObjectsInterface crearObjetos(String nombre) {

        if (nombre.equals("HotelMgr")) {
            return (ObjectsInterface) HotelMgr.getInstance();
        }
        if (nombre.equals("CiudadMgr")) {

            return (ObjectsInterface) CiudadMgr.getInstance();
        }
        if (nombre.equals("HabitacionMgr")) {

            return (ObjectsInterface) HabitacionMgr.getInstance();
        }
        
        if (nombre.equals("ReservaMgr")) {

            return (ObjectsInterface) ReservaMgr.getInstance();
        }
        
        if (nombre.equals("UsuarioMgr")) {

            return (ObjectsInterface) UsuarioMgr.getInstance();
        }
        
        return null;
    }
}
