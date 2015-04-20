/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Ciudad;
import Negocio.Hotel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class HotelMgr {

    private ArrayList<Hotel> hoteles = new ArrayList();
    private static HotelMgr INSTANCE = null;

    public static HotelMgr getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HotelMgr();
            INSTANCE.llenarHoteles();
        }
        return INSTANCE;
    }
    private void llenarHoteles(){
        
        List<HashMap<String, Object>> listaHoteles = Hotel.llenarHoteles();
        
        for (int i = 0; i < listaHoteles.size(); i++) {    
            String id = (String) listaHoteles.get(i).get("id").toString();
            String nombre = (String) listaHoteles.get(i).get("nombre");
            String direccion = (String) listaHoteles.get(i).get("direccion");
            String telefono = (String) listaHoteles.get(i).get("telefono");
            String idCiudad = (String) listaHoteles.get(i).get("id_ciudad").toString();
            hoteles.add(new Hotel(id,nombre, direccion, telefono, idCiudad));
                
        }
    }
    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }
    
    public ArrayList<Hotel> getHotelesPorCiudad(Ciudad ciudad) {
        
        
        ArrayList<Hotel> hotelesCiudad = new ArrayList();
        for (int i = 0; i < hoteles.size(); i++) {
            if(hoteles.get(i).getCiudad().equals(ciudad)){
                hotelesCiudad.add(hoteles.get(i));
                
            }
        }
        return hotelesCiudad;
    }
    public Hotel getHotel(String id) {
        for (int i = 0; i < hoteles.size(); i++) {
            
            if(hoteles.get(i).getId().equals(id))
                return hoteles.get(i);
        }
        return null;
    }
    
    
    
    

}
