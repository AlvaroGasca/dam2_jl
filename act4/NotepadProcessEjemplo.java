/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act4;

import java.io.IOException;

/**
 *
 * @author alvarogasca
 */
public class NotepadProcessEjemplo {
    
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            Process process = pb.start();

            System.out.println("El proceso del Bloc de notas ha sido iniciado.");

            if (process.isAlive()) {
                System.out.println("El proceso del Bloc de notas está en ejecución antes de la pausa.");
            } else {
                System.out.println("El proceso del Bloc de notas no está en ejecución antes de la pausa.");
            }

            Thread.sleep(20000); 

            if (process.isAlive()) {
                System.out.println("El proceso del Bloc de notas está en ejecución después de la pausa.");
            } else {
                System.out.println("El proceso del Bloc de notas no está en ejecución después de la pausa.");
            }

            process.destroy();

            if (process.isAlive()) {
                System.out.println("El proceso del Bloc de notas todavía está en ejecución después de destroy().");
            } else {
                System.out.println("El proceso del Bloc de notas se ha cerrado correctamente después de destroy().");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
