/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act2;

import java.util.Scanner;

/**
 *
 * @author alvarogasca
 */
public class Frecuencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[] vocales = new int[5];
        System.out.println("Introduce una palabra");
        String palabra = sc.nextLine();
        
        for(int i=0; i<palabra.length();i++){
            char letra = palabra.charAt(i);
            switch(letra){
                case 'a':
                    vocales[0]++;
                    break;
                case 'e':
                    vocales[1]++;
                    break;
                case 'i':
                    vocales[2]++;
                    break;
                case 'o':
                    vocales[3]++;
                    break;
                case 'u':
                    vocales[4]++;
                    break;
                default:
                    break;
            }
        }
        
        for(int i=0; i<vocales.length; i++){
            System.out.println(vocales[i] + "");
        }
        sc.close();
    }
    
}
