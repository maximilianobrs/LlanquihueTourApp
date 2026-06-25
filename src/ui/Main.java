package ui;
import data.GestorServicios;

public class Main {
    public static void main(String[] args) {

        int contador = 1;

        GestorServicios servicio = new GestorServicios();


        System.out.println("\n==== CARGANDO DATOSS DE SERVICIO ====");
        do {
            System.out.println("Cargando servicios...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            contador++;
        } while (contador <= 3);
        System.out.println("=== TERMINADO CARGA DE DATOS ===\n");

        servicio.crearServicios();


    }
}
