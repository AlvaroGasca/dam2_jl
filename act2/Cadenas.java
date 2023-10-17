package act2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, proporciona la cantidad de cadenas a generar como argumento.");
            return;
        }

        int cantidadCadenas = Integer.parseInt(args[0]);
        Random random = new Random();
        int longitudMaxima = 20;

        for (int i = 0; i < cantidadCadenas; i++) {
            int longitud = random.nextInt(longitudMaxima) + 1;
            StringBuilder cadena = new StringBuilder();

            for (int j = 0; j < longitud; j++) {
                char caracter = (char) (random.nextInt(26) + 'a');
                cadena.append(caracter);
            }

            System.out.println("Cadena " + (i + 1) + ": " + cadena.toString());

            // Llama a la aplicación "Frecuencia" y guarda el resultado en un archivo
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "act2.Frecuencia");
                pb.redirectInput(ProcessBuilder.Redirect.INHERIT); // Permite que Frecuencia utilice la entrada estándar
                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); // Permite que Frecuencia utilice la salida estándar
                Process process = pb.start();
                BufferedWriter writer = new BufferedWriter(new FileWriter("resultado_cadena_" + i + ".txt"));
                writer.write(cadena.toString());
                writer.newLine();
                writer.close();
                process.waitFor(); // Espera a que Frecuencia termine
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
