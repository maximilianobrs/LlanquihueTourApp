package data;

import model.*;
import interfaces.Registrable;
import java.util.ArrayList;

/**
 * Gestiona el registro de recursos de la agencia.
 * Permite almacenar entidades y generar reportes.
 * @author Maxi
 */

public class GestorEntidades {
    ArrayList<Registrable> recursos = new ArrayList<>();

    public void registrarRecurso(Registrable recurso){
        recursos.add(recurso);
    }

    public String generarReporte() {
        String reporte = "";

        for (Registrable r : recursos) {

            if (r instanceof GuiaTuristico) {
                reporte += "Personal: ";
            }

            if (r instanceof Vehiculo) {
                reporte += "Activo: ";
            }

            if (r instanceof Cliente) {
                reporte += "Destinatario: ";
            }

            if (r instanceof Tour) {
                reporte += "Servicio: ";
            }

            reporte += r.mostrarResumen() + "\n";
        }

        return reporte;
    }

    public ArrayList<Registrable> getRecursos() {
        return recursos;
    }
}
