package model;

import interfaces.Registrable;

import java.util.ArrayList;

public class Tour implements Registrable {
    private String codigoTour;
    private String nombre;
    private String destino;
    private int precio;

    private GuiaTuristico guiaTuristico;
    private ArrayList<Cliente> clientes;

    public Tour() {
        clientes = new ArrayList<>();
    }

    public Tour(String codigoTour, String nombre, String destino, int precio) {
        this.codigoTour = codigoTour;
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.clientes = new ArrayList<>();
    }

    public Tour(String codigoTour, String nombre, String destino, int precio, GuiaTuristico guiaTuristico, ArrayList<Cliente> clientes) {
        this.codigoTour = codigoTour;
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.guiaTuristico = guiaTuristico;
        this.clientes = clientes;
    }

    public String getCodigoTour() {
        return codigoTour;
    }

    public void setCodigoTour(String codigoTour) {
        this.codigoTour = codigoTour;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public GuiaTuristico getGuiaTuristico() {
        return guiaTuristico;
    }

    public void setGuiaTuristico(GuiaTuristico guiaTuristico) {
        this.guiaTuristico = guiaTuristico;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String mostrarResumen(){
        return "Tour | " + "Codigo: " + getCodigoTour() +" | " + "Nombre: " + getNombre() + " | " + "Destino: " + getDestino() + " | " + "Precio: " + getPrecio();
    }
}
