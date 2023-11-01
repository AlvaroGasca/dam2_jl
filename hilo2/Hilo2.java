/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilo2;

/**
 *
 * @author alvarogasca
 */
public class Hilo2 {
    static class PinThread extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("PIN");
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PonThread extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("PON");
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PinThread pinThread = new PinThread();
        PonThread ponThread = new PonThread();

        pinThread.start();
        ponThread.start();
    }
}


