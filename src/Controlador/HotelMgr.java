/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Hotel;
import java.util.ArrayList;

/**
 *
 * @author juan2ramos
 */
public class HotelMgr {
    private ArrayList<Hotel> hoteles = new ArrayList();
    
    public void addHotel(Hotel hotel) {
        this.hoteles.add(hotel);
    }
    
    public ArrayList<Hotel> getCiclista() {
        return hoteles;
        
    }

    public boolean eliminar(Hotel hotel) {
        this.hoteles.remove(hotel);
        return true;
    }
}
