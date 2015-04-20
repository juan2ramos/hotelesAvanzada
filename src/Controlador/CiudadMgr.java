/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Ciudad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author juan2ramos
 */
public class CiudadMgr {

    private final ArrayList<Ciudad> ciudades = new ArrayList();
    private static CiudadMgr INSTANCE = null;

    public static CiudadMgr getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CiudadMgr();
            INSTANCE.llenarCiudad();
        }
        return INSTANCE;
    }
    @SuppressWarnings("empty-statement")
    private void llenarCiudad(){
        
        List<HashMap<String, Object>> listaHoteles = Ciudad.llenarCiudades();
        
        for (int i = 0; i < listaHoteles.size(); i++) {   
            String id = (String) listaHoteles.get(i).get("id").toString();
            String nombre = (String) listaHoteles.get(i).get("nombre");;
            ciudades.add(new Ciudad(id,nombre));

        }
    }
    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
    public Ciudad getCiudad(String id) {
        for (int i = 0; i < ciudades.size(); i++) {
            
            if(ciudades.get(i).getId().equals(id))
                return ciudades.get(i);
        }
        return null;
    }    
}
