/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.funciones;

import java.util.ArrayList;
import login.formularios.LoginForm;
import login.formularios.RegistroForm;
import login.clases.Usuario;
import menu.clases.Menu;

public class LoginController {
    private LoginForm loginView;
    private RegistroForm registroView;

    public LoginController(LoginForm loginView, RegistroForm registroView) {
        this.loginView = loginView;
        this.registroView = registroView; 

    }
    

    public void accederButtonClicked() {
    String nombreUsuario = loginView.getNombreUsuario();
    String contrasena = loginView.getContrasena();
    Usuario usuarioEncontrado = buscarUsuario(nombreUsuario, contrasena);

        if (usuarioEncontrado != null) {
            loginView.mostrarMensaje("Inicio de sesión exitoso");
            loginView.setVisible(false);
            Menu menu = new Menu();
            menu.setVisible(true);
        } else {
            loginView.mostrarError("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private Usuario buscarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : RegistroController.listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

}


