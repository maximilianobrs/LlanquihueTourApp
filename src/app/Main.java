package app;

import ui.MiVentana;
import javax.swing.*;
import data.GestorEntidades;

/**
 * Clase principal del sistema.
 * Carga la informacion al gestor desde los archivos txt
 * Inicia la aplicación gráfica utilizando Java Swing.
 * @author Maxim
 */
public class Main {

    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        gestor.cargarRecursos();
        SwingUtilities.invokeLater(() -> {
            MiVentana ventana = new MiVentana(gestor);
            ventana.setVisible(true);
        });
    }
}