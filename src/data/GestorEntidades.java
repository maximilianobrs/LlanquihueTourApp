package data;

import model.*;
import interfaces.Registrable;


import java.util.ArrayList;


import java.util.List;


/**
 * Gestiona el registro de recursos de la agencia.
 * Permite almacenar entidades y generar reportes.
 *
 * @author Maxi
 */

public class GestorEntidades {
    List<Registrable> recursos = new ArrayList<>();

    public void registrarRecurso(Registrable recurso) {
        recursos.add(recurso);
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {

            String etiqueta = "";

            if (r instanceof GuiaTuristico) {
                etiqueta = "Personal: ";
            } else if (r instanceof Vehiculo) {
                etiqueta = "Activo: ";
            } else if (r instanceof Cliente) {
                etiqueta = "Destinatario: ";
            } else if (r instanceof Tour) {
                etiqueta = "Servicio: ";
            }

            reporte.append(r.registrar())
                    .append("\n")
                    .append(etiqueta)
                    .append(r.mostrarResumen())
                    .append("\n");
        }

        return reporte.toString();
    }

    public String getTours() {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {
            if (r instanceof Tour) {
                reporte.append("Servicio: ")
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public String getClientes() {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {
            if (r instanceof Cliente) {
                reporte.append("Destinatario: ")
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public String getGuias() {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {
            if (r instanceof GuiaTuristico) {
                reporte.append("Personal: ")
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public String getVehiculos() {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {
            if (r instanceof Vehiculo) {
                reporte.append("Activo: ")
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public String getBuscar(String parametro) {
        StringBuilder reporte = new StringBuilder();

        for (Registrable r : recursos) {

            if (r.mostrarResumen().toLowerCase().contains(parametro.toLowerCase())) {

                String etiqueta = "";

                if (r instanceof GuiaTuristico) {
                    etiqueta = "Personal: ";
                } else if (r instanceof Vehiculo) {
                    etiqueta = "Activo: ";
                } else if (r instanceof Cliente) {
                    etiqueta = "Destinatario: ";
                } else if (r instanceof Tour) {
                    etiqueta = "Servicio: ";
                }

                reporte.append(etiqueta)
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public List<Registrable> getRecursos() {
        return recursos;
    }
}
