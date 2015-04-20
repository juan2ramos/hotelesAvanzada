/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Ciudad;
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
public class UsuarioMgr {

    private final ArrayList<Usuario> usuarios = new ArrayList();
    private static UsuarioMgr INSTANCE = null;

    public static UsuarioMgr getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UsuarioMgr();
            INSTANCE.llenarUsuario();
        }
        return INSTANCE;
    }

    private void llenarUsuario() {

        List<HashMap<String, Object>> listaUsuario = Usuario.llenarUsuarios();

        for (int i = 0; i < listaUsuario.size(); i++) {

            String id = (String) listaUsuario.get(i).get("id").toString();
            String nombre = (String) listaUsuario.get(i).get("nombre").toString();
            String apellido = (String) listaUsuario.get(i).get("apellido").toString();
            String documento = (String) listaUsuario.get(i).get("documento").toString();
            String telefono = (String) listaUsuario.get(i).get("telefono").toString();

            usuarios.add(new Usuario(id, nombre, apellido, documento, telefono));

        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario crearUsuario(String nombre, String apellido, String documento, String telefono) {
        Usuario usuario = buscarUsuario(documento);
        if (usuario == null) {
            Integer idUsuario = Integer.parseInt(usuarios.get(usuarios.size() - 1).getId()) + 1;
            Usuario usuarioNuevo = new Usuario(idUsuario.toString(), nombre, apellido, documento, telefono);
            usuarios.add(usuarioNuevo);
            Usuario.insertarUsuarios(idUsuario.toString(), nombre, apellido, documento, telefono);
            return usuarioNuevo;
        }
        return usuario;
    }

    public Usuario buscarUsuario(String documento) {
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getId().equals(documento)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Usuario getUsuario(String id) {
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getId().equals(id)) {
                return usuarios.get(i);
            }
        }
        return null;
    }
}
