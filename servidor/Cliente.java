/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author alvarogasca
 */
public class Cliente {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int puerto = 12345;

        try (
            Socket socket = new Socket(host, puerto);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                output.println(userInputLine);

                if ("*".equals(userInputLine)) {
                    break; 
                }

                String response = input.readLine();
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
