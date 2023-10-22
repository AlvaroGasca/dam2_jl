/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.funciones;

import java.util.ArrayList;
import login.formularios.RegistroForm;
import login.clases.Usuario;
import login.formularios.LoginForm;

public class RegistroController {
    private RegistroForm registroView;
    public static final ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public RegistroController(RegistroForm registroView) {
        this.registroView = registroView;
        registroView.setRegistroController(this);
    }

    public void guardarButtonClicked() {
        String nombreUsuario = registroView.getNombreUsuario();
        String contrasena = registroView.getContrasena();

        if (!nombreUsuario.isEmpty() && !contrasena.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
            agregarUsuario(nuevoUsuario);
            registroView.mostrarMensaje("Usuario registrado correctamente");
            registroView.setVisible(false);
            LoginForm lg = new LoginForm();
            lg.setVisible(true);
        } else {
            registroView.mostrarError("Por favor, ingrese un nombre de usuario y una contraseña.");
        }
    }

    private void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
}


