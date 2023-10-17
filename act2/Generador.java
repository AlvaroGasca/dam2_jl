package act2;

import java.util.Scanner;

public class Generador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadInstancias = 10;

        for (int i = 0; i < cantidadInstancias; i++) {
            System.out.println("Instancia " + (i + 1));
            System.out.println("Introduce la cantidad de cadenas a generar:");
            int cantidadCadenas = sc.nextInt();
            Cadenas.main(new String[]{String.valueOf(cantidadCadenas)});
            System.out.println("--------------");
        }

        sc.close();
    }
}
