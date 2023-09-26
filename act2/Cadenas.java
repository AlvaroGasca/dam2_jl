/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alvarogasca
 */
public class Cadenas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce la cantidad de cadenas a generar:");
        int cantidadCadenas = sc.nextInt();
        
        Random random = new Random();
        int longitudMaxima = 20;
        
        for (int i = 0; i < cantidadCadenas; i++) {
            int longitud = random.nextInt(longitudMaxima) + 1; // Genera una longitud aleatoria entre 1 y 20
            
            StringBuilder cadena = new StringBuilder();
            for (int j = 0; j < longitud; j++) {
                char caracter = (char) (random.nextInt(26) + 'a'); // Genera un carácter aleatorio entre 'a' y 'z'
                cadena.append(caracter);
            }
            
            System.out.println("Cadena " + (i + 1) + ": " + cadena.toString());
        }
        
        sc.close();
    }
}
