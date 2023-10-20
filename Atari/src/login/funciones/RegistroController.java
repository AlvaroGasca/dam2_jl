/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.funciones;

import java.util.ArrayList;
import login.formularios.RegistroForm;
import login.clases.Usuario;

public class RegistroController {
    private RegistroForm registroView;
    private ArrayList<Usuario> listaUsuarios;

    public RegistroController(RegistroForm registroView) {
        this.registroView = registroView;
        this.listaUsuarios = new ArrayList<>();
        registroView.setRegistroController(this);
        registroView.addGuardarListener(evt -> guardarButtonClicked());
    }

    public void guardarButtonClicked() {
        String nombreUsuario = registroView.getNombreUsuario();
        String contrasena = registroView.getContrasena();

        if (!nombreUsuario.isEmpty() && !contrasena.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
            agregarUsuario(nuevoUsuario);
            registroView.mostrarMensaje("Usuario registrado correctamente");
        } else {
            registroView.mostrarError("Por favor, ingrese un nombre de usuario y una contraseña.");
        }
    }

    private void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
}


