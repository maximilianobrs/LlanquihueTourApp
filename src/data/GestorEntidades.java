package data;

import model.*;
import interfaces.Registrable;


import java.io.*;
import java.util.ArrayList;


import java.util.List;


/**
 * Gestiona el registro, carga, búsqueda y almacenamiento de los recursos
 * de la agencia turística.
 *
 * @author Maxim
 */

public class GestorEntidades {
    List<Registrable> recursos = new ArrayList<>();

    /**
     * Registra un nuevo recurso en la colección de recursos.
     *
     * @param recurso recurso que será agregado al sistema.
     */
    public void registrarRecurso(Registrable recurso) {
        recursos.add(recurso);
    }

    /**
     * Carga todos los recursos almacenados en los archivos de texto
     * de clientes, guías, vehículos y tours.
     */
    public void cargarRecursos() {
        cargarClientes("resources/clientes.txt");
        cargarGuias("resources/guias.txt");
        cargarVehiculos("resources/vehiculos.txt");
        cargarTours("resources/tours.txt");
    }

    /**
     * Genera un reporte con todos los recursos registrados,
     * indicando su tipo y su información resumida.
     *
     * @return cadena con el reporte completo.
     */
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

    /**
     * Obtiene un reporte con todos los tours registrados.
     *
     * @return cadena con la información de los tours.
     */
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

    /**
     * Obtiene un reporte con todos los clienetes registrados.
     *
     * @return cadena con la información de los clientes.
     */
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

    /**
     * Obtiene un reporte con todos los guias registrados.
     *
     * @return cadena con la información de los guias.
     */
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

    /**
     * Obtiene un reporte con todos los vehiculos registrados.
     *
     * @return cadena con la información de los vehiculos.
     */
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

    /**
     * Busca recursos cuyo resumen contenga el texto indicado.
     *
     * @param parametro texto utilizado para realizar la búsqueda.
     * @return recursos encontrados que coinciden con el criterio.
     */
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

    /**
     * Carga los clientes desde un archivo de texto.
     *
     * @param rutaArchivo ruta del archivo que contiene los clientes.
     */
    public void cargarClientes(String rutaArchivo) {

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                String codigo = datos[0];
                String nombre = datos[1];
                String rut = datos[2];
                String correo = datos[3];
                String telefono = datos[4];

                Contacto contacto = new Contacto(correo, telefono);
                Cliente nuevoCliente = new Cliente(codigo, nombre, rut, contacto);
                registrarRecurso(nuevoCliente);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga los guias desde un archivo de texto.
     *
     * @param rutaArchivo ruta del archivo que contiene los guias.
     */
    public void cargarGuias(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                String codigo = datos[0];
                String nombre = datos[1];
                String rut = datos[2];
                String correo = datos[3];
                String telefono = datos[4];
                String fechaIngreso = datos[5];
                String idioma = datos[6];


                Contacto contacto = new Contacto(correo, telefono);
                GuiaTuristico nuevoGuia = new GuiaTuristico(codigo, nombre, rut, contacto, fechaIngreso, idioma);

                registrarRecurso(nuevoGuia);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga los tours desde un archivo de texto.
     *
     * @param rutaArchivo ruta del archivo que contiene los tours.
     */
    public void cargarTours(String rutaArchivo) {

        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                String codigo = datos[0];
                String nombre = datos[1];
                int precio = Integer.parseInt(datos[2]);
                String guia = datos[3];
                String vehiculo = datos[4];
                String[] clientes = datos[5].split(",", -1);

                Tour nuevoTour = new Tour(codigo, nombre, precio);

                if (!guia.isEmpty()) {
                    for (Registrable r : recursos) {
                        if (r instanceof GuiaTuristico g && g.getCodigoGuia().equals(guia)) {
                            nuevoTour.setGuiaTuristico(g);
                        }
                    }
                }

                if (!vehiculo.isEmpty()) {
                    for (Registrable r : recursos) {
                        if (r instanceof Vehiculo v && v.getCodigoVehiculo().equals(vehiculo)) {
                            nuevoTour.setVehiculo(v);
                        }
                    }
                }

                if (!datos[5].isEmpty()) {
                    for (String codigoCliente : clientes) {
                        for (Registrable r : recursos) {
                            if (r instanceof Cliente c && c.getCodigoCliente().equals(codigoCliente)) {
                                nuevoTour.agregarCliente(c);
                            }
                        }
                    }
                }

                registrarRecurso(nuevoTour);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga los vehiculos desde un archivo de texto.
     *
     * @param rutaArchivo ruta del archivo que contiene los vehiculos.
     */
    public void cargarVehiculos(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) return;

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
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

    /**
     * Guarda todos los clientes registrados en el archivo correspondiente.
     */
    public void guardarCliente() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/clientes.txt"));

            for (Registrable r : recursos) {
                if (r instanceof Cliente c) {
                    bw.write(
                            c.getCodigoCliente() + ";" +
                                    c.getNombre() + ";" +
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

    /**
     * Guarda todos los guias registrados en el archivo correspondiente.
     */
    public void guardarGuia() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/guias.txt"));

            for (Registrable r : recursos) {
                if (r instanceof GuiaTuristico g) {
                    bw.write(
                            g.getCodigoGuia() + ";" +
                                    g.getNombre() + ";" +
                                    g.getRut() + ";" +
                                    g.getCorreo() + ";" +
                                    g.getTelefono() + ";" +
                                    g.getCargo() + ";" +
                                    g.getIdioma()
                    );
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Guarda todos los tours registrados en el archivo correspondiente.
     */
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

                    StringBuilder codigosClientes = new StringBuilder();

                    for (Cliente c : t.getClientes()) {
                        if (codigosClientes.length() > 0) {
                            codigosClientes.append(",");
                        }
                        codigosClientes.append(c.getCodigoCliente());
                    }
                    System.out.println(codigoGuia);
                    System.out.println(codigoVehiculo);
                    bw.write(
                            t.getCodigoTour() + ";" +
                                    t.getNombre() + ";" +
                                    t.getPrecio() + ";" +
                                    codigoGuia + ";" +
                                    codigoVehiculo + ";" +
                                    codigosClientes
                    );
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Guarda todos los vehiculos registrados en el archivo correspondiente.
     */
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

    /**
     * Cuenta la cantidad de recursos que pertenecen a un tipo específico.
     *
     * @param tipo clase del recurso que se desea contar.
     * @return cantidad de recursos encontrados.
     */
    public int contarPorTipo(Class tipo) {
        int contador = 0;

        for (Registrable r : recursos) {
            if (tipo.isInstance(r)) {
                contador++;
            }
        }

        return contador;
    }

    /**
     * Verifica si un RUT ya se encuentra registrado en el sistema.
     *
     * @param rut RUT que se desea comprobar.
     * @return true si el RUT existe; false en caso contrario.
     */
    public Boolean existeRut(String rut) {
        for (Registrable r : recursos) {
            if (r instanceof Cliente c && c.getRut().equals(rut)) {
                return true;
            }
            if (r instanceof GuiaTuristico g && g.getRut().equals(rut)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de recursos registrados.
     *
     * @return lista de recursos del sistema.
     */
    public List<Registrable> getRecursos() {
        return recursos;
    }
}
