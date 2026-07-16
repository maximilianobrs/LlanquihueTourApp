package data;

import model.*;
import interfaces.Registrable;


import java.io.*;
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

    public void cargarRecursos() {
        cargarClientes("resources/clientes.txt");
        cargarGuias("resources/guias.txt");
        cargarTours("resources/tours.txt");
        cargarVehiculos("resources/vehiculos.txt");

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

            reporte.append(etiqueta)
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
                }
                if (r instanceof Vehiculo) {
                    etiqueta = "Activo: ";
                }
                if (r instanceof Cliente) {
                    etiqueta = "Destinatario: ";
                }
                if (r instanceof Tour) {
                    etiqueta = "Servicio: ";
                }

                reporte.append(etiqueta)
                        .append(r.mostrarResumen())
                        .append("\n");
            }
        }

        return reporte.toString();
    }

    public void cargarClientes(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String rut = datos[3];
                String correo = datos[4];
                String telefono = datos[5];


                Contacto contacto = new Contacto(correo, telefono);
                Cliente nuevoCliente = new Cliente(codigo, nombre, edad, rut, contacto);
                registrarRecurso(nuevoCliente);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarGuias(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                String rut = datos[3];
                String correo = datos[4];
                String telefono = datos[5];
                String fechaIngreso = datos[6];
                String idioma = datos[7];
                int aniosExpe = Integer.parseInt(datos[8]);

                Contacto contacto = new Contacto(correo, telefono);
                GuiaTuristico nuevoGuia = new GuiaTuristico(codigo, nombre, edad, rut, contacto, fechaIngreso, idioma, aniosExpe);

                registrarRecurso(nuevoGuia);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarTours(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                String destino = datos[2];
                int precio = Integer.parseInt(datos[3]);

                Tour nuevoTour = new Tour(codigo, nombre, destino, precio);

                registrarRecurso(nuevoTour);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarVehiculos(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String codigo = datos[0];
                String patente = datos[1];
                String modelo = datos[2];
                int capacidad = Integer.parseInt(datos[3]);

                Vehiculo nuevoVehiculo = new Vehiculo(codigo, patente, modelo, capacidad);

                registrarRecurso(nuevoVehiculo);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarCliente() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/clientes.txt"));

            for (Registrable r : recursos) {
                if (r instanceof Cliente c) {
                    bw.write(
                            c.getCodigoCliente() + ";" +
                                    c.getNombre() + ";" +
                                    c.getEdad() + ";" +
                                    c.getRut() + ";" +
                                    c.getCorreo() + ";" +
                                    c.getTelefono()
                    );
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarGuia() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/guias.txt"));

            for (Registrable r : recursos) {
                if (r instanceof GuiaTuristico g) {
                    bw.write(
                            g.getCodigoGuia() + ";" +
                                    g.getNombre() + ";" +
                                    g.getEdad() + ";" +
                                    g.getRut() + ";" +
                                    g.getCorreo() + ";" +
                                    g.getTelefono() + ";" +
                                    g.getFechaDeIngreso() + ";" +
                                    g.getIdioma() + ";" +
                                    g.getExperiencia()
                    );
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarTour() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/tours.txt"));

            for (Registrable r : recursos) {
                if (r instanceof Tour t) {
                    String codigoGuia = "";
                    String codigoVehiculo = "";

                    if (t.getGuiaTuristico() != null) {
                        codigoGuia = t.getGuiaTuristico().getCodigoGuia();
                    }

                    if (t.getVehiculo() != null) {
                        codigoVehiculo = t.getVehiculo().getCodigoVehiculo();
                    }

                    bw.write(
                            t.getCodigoTour() + ";" +
                                    t.getNombre() + ";" +
                                    t.getDestino() + ";" +
                                    t.getPrecio() + ";" +
                                    codigoGuia + ";" +
                                    codigoVehiculo + ";" +
                                    t.getClientes()
                    );
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarVehiculo() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/vehiculos.txt"));

            for (Registrable r : recursos) {
                if (r instanceof Vehiculo v) {
                    bw.write(
                            v.getCodigoVehiculo() + ";" +
                                    v.getPatente() + ";" +
                                    v.getModelo() + ";" +
                                    v.getCapacidad()
                    );
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int contarPorTipo(Class tipo) {
        int contador = 0;

        for (Registrable r : recursos) {
            if (tipo.isInstance(r)) {
                contador++;
            }
        }

        return contador;
    }

    public List<Registrable> getRecursos() {
        return recursos;
    }
}
