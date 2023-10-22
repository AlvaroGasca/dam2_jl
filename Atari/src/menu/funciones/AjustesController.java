/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu.funciones;

import login.clases.Usuario;

import menu.clases.Ajustes;

/**
 *
 * @author alvarogasca
 */
public class AjustesController {
    private Ajustes vista;
    private Usuario usuario;

    public AjustesController(Ajustes vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
        cargarInformacionUsuario();
    }

    private void cargarInformacionUsuario() {
        Usuario usuario = obtenerUsuario();  // Reemplaza con la forma real de obtener el usuario
        String nombreActual = usuario.getNombreUsuario();
        String contrasenaActual = usuario.getContrasena();

        // Establecer los valores actuales en los campos de texto
        setNombreUsuario(nombreActual);
        setContrasena(contrasenaActual);
    }

    private void guardarButtonClicked() {
        String nuevoNombreUsuario = vista.getNombreUsuario();
        String nuevaContrasena = vista.getContrasena();

        usuario.setNombreUsuario(nuevoNombreUsuario);
        usuario.setContrasena(nuevaContrasena);
        
    }

    public void setNombreUsuario(String nuevoNombre) {
        vista.setNombreUsuario(nuevoNombre);
    }

    public void setContrasena(String nuevaContrasena) {
        vista.setContrasena(nuevaContrasena);
    }

    public String getNombreUsuarioActual() {
        return usuario.getNombreUsuario();
    }

    public String getContrasenaActual() {
        return usuario.getContrasena();
    }
    
    private Usuario obtenerUsuario() {
        return new Usuario(usuario.getNombreUsuario(),usuario.getContrasena());
    }

}
