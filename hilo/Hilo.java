/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilo;

/**
 *
 * @author alvarogasca
 */
public class Hilo extends Thread{
    public void run() {
        System.out.println("Hola Mundo desde el hilo " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Hilo thread = new Hilo();
            thread.start();
        }
    }
}


