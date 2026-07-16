package app;

import data.GestorEntidades;
import model.Tour;
import model.GuiaTuristico;
import model.Vehiculo;
import model.Cliente;
import model.Contacto;
import java.util.ArrayList;

import ui.MiVentana;
import javax.swing.*;

/**
 * Clase principal del sistema.
 * Inicia la aplicación gráfica utilizando Java Swing.
 * @author Maxi
 */

public class Main {

    public static void main(String[] args) {

        // 1. Instanciar el gestor
        GestorEntidades gestor = new GestorEntidades();

        // 2. Crear Contactos para Guías y Clientes
        Contacto contactoGuia1 = new Contacto("carlos.guia@agencia.com", "+56911112222");
        Contacto contactoGuia2 = new Contacto("ana.guia@agencia.com", "+56933334444");
        Contacto contactoCli1 = new Contacto("juan.perez@email.com", "+56955556666");
        Contacto contactoCli2 = new Contacto("maria.g@email.com", "+56977778888");

        // 3. Crear Guías Turísticos
        GuiaTuristico guia1 = new GuiaTuristico(
                "Carlos Mendoza", 34, "12.345.678-9", contactoGuia1,
                "2023-03-15", "G001", "Español / Inglés", 6
        );
        GuiaTuristico guia2 = new GuiaTuristico(
                "Ana María Silva", 29, "18.765.432-1", contactoGuia2,
                "2025-01-10", "G002", "Español / Portugués", 3
        );

        // 4. Crear Vehículos
        Vehiculo vehiculo1 = new Vehiculo("V001", "HG-FD-88", "Mercedes Benz Sprinter", 15);
        Vehiculo vehiculo2 = new Vehiculo("V002", "Kj-RT-44", "Toyota Coaster", 25);

        // 5. Crear Clientes usando su jerarquía de Persona
        Cliente cliente1 = new Cliente("Juan Pérez", 45, "15.555.666-7", contactoCli1, "C001");
        Cliente cliente2 = new Cliente("María González", 31, "16.777.888-9", contactoCli2, "C002");

        // 6. Asignar Pasajeros a las listas de los Tours
        ArrayList<Cliente> pasajerosTour1 = new ArrayList<>();
        pasajerosTour1.add(cliente1);
        pasajerosTour1.add(cliente2);

        ArrayList<Cliente> pasajerosTour2 = new ArrayList<>();

        // 7. Crear los Tours conectando todas las instancias
        Tour tour1 = new Tour("T001", "Ruta del Vino Premium", "Valle de Colchagua", 45000, guia1, vehiculo1, pasajerosTour1);
        Tour tour2 = new Tour("T002", "Aventura Cordillera", "Cajón del Maipo", 35000, guia2, vehiculo2, pasajerosTour2);

        // 8. Cargar todas las entidades en el Gestor
        gestor.registrarRecurso(guia1);
        gestor.registrarRecurso(guia2);
        gestor.registrarRecurso(vehiculo1);
        gestor.registrarRecurso(vehiculo2);
        gestor.registrarRecurso(cliente1);
        gestor.registrarRecurso(cliente2);
        gestor.registrarRecurso(tour1);
        gestor.registrarRecurso(tour2);

        SwingUtilities.invokeLater(() -> {
            MiVentana ventana = new MiVentana( gestor);
            ventana.setVisible(true);
        });
    }
}