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
public class TCPDadosCliente {
    public static void main(String[] args) {
        final String serverHost = "localhost";
        final int serverPort = 9999;

        try {
            Socket socket = new Socket(serverHost, serverPort);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            int roundsToWin = 3;
            int clientScore = 0;
            int serverScore = 0;

            while (clientScore < roundsToWin && serverScore < roundsToWin) {
                System.out.print("Adivina la suma de dos dados (2 a 12): ");
                int guess = Integer.parseInt(userInputReader.readLine());
                writer.println(guess);

                int serverResult = Integer.parseInt(reader.readLine());
                System.out.println("El servidor tiró: " + serverResult);

                if (guess == serverResult) {
                    System.out.println("¡Has ganado la ronda!");
                    clientScore++;
                } else {
                    System.out.println("El servidor ha ganado la ronda.");
                    serverScore++;
                }

                System.out.println("Puntuación actual - Cliente: " + clientScore + ", Servidor: " + serverScore);
            }

            writer.println(clientScore);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}