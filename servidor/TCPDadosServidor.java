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
public class TCPDadosServidor {
    public static void main(String[] args) {
        final int serverPort = 9999;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Servidor esperando conexiones en el puerto " + serverPort);

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            int roundsToWin = 3;
            int clientScore = 0;
            int serverScore = 0;

            while (clientScore < roundsToWin && serverScore < roundsToWin) {
                int dice1 = (int) (Math.random() * 6) + 1;
                int dice2 = (int) (Math.random() * 6) + 1;
                int serverResult = dice1 + dice2;

                writer.println(serverResult);

                int clientGuess = Integer.parseInt(reader.readLine());
                System.out.println("Cliente adivinó: " + clientGuess);

                if (clientGuess == serverResult) {
                    System.out.println("El cliente ha ganado la ronda.");
                    clientScore++;
                } else {
                    System.out.println("¡Has ganado la ronda!");
                    serverScore++;
                }

                System.out.println("Puntuación actual - Cliente: " + clientScore + ", Servidor: " + serverScore);
            }

            int clientFinalScore = Integer.parseInt(reader.readLine());
            System.out.println("Puntuación final - Cliente: " + clientFinalScore + ", Servidor: " + serverScore);

            if (clientFinalScore > serverScore) {
                System.out.println("¡El cliente ha ganado el juego!");
            } else if (clientFinalScore < serverScore) {
                System.out.println("¡El servidor ha ganado el juego!");
            } else {
                System.out.println("¡El juego ha terminado en empate!");
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}