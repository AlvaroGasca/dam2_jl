/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.funciones;

import java.util.ArrayList;
import login.formularios.LoginForm;
import login.formularios.RegistroForm;
import login.clases.Usuario;

public class LoginController {
    private LoginForm loginView;
    private RegistroForm registroView;
    private ArrayList<Usuario> listaUsuarios;

    public LoginController(LoginForm loginView, RegistroForm registroView) {
        this.loginView = loginView;
        this.registroView = registroView; 
        this.listaUsuarios = new ArrayList<>();

        loginView.addAccederListener(evt -> accederButtonClicked());
    }
    

    public void accederButtonClicked() {
    String nombreUsuario = loginView.getNombreUsuario();
    String contrasena = loginView.getContrasena();
    Usuario usuarioEncontrado = buscarUsuario(nombreUsuario, contrasena);

        if (usuarioEncontrado != null) {
            loginView.mostrarMensaje("Inicio de sesión exitoso");
        } else {
            loginView.mostrarError("Nombre de usuario o contraseña incorrectos.");
        }
    }

    private Usuario buscarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

}


