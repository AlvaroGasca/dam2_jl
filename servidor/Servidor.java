/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alvarogasca
 */
public class Servidor {

    public static void main(String[] args) {
        int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Conexión establecida con el cliente.");

            try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String inputLine;
                while ((inputLine = input.readLine()) != null) {
                    System.out.println("Mensaje recibido: " + inputLine);

                    String response = inputLine.toUpperCase();

                    output.println(response);

                    if ("*".equals(inputLine)) {
                        break;  
                    }
                }
            }

            System.out.println("Cerrando conexión con el cliente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
