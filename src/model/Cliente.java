package model;

import interfaces.Registrable;

public class Cliente extends Persona implements Registrable {
    private String codigoCliente;

    public Cliente() {
    }

    public Cliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente(String nombre, int edad, String rut, Contacto contacto, String codigoCliente) {
        super(nombre, edad, rut, contacto);
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public String mostrarResumen(){
        return "cliente";
    }
}
