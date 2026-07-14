package app;
import ui.MiVentana;

import javax.swing.*;

/**
 * Clase principal del sistema.
 * Inicia la aplicación gráfica utilizando Java Swing.
 * @author Maxi
 */

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MiVentana ventana = new MiVentana();
            ventana.setVisible(true);
        });
    }
}