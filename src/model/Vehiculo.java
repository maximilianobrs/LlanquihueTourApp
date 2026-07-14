package model;

import interfaces.Registrable;

/**
 * Representa un vehículo utilizado por la agencia turística.
 * Hereda el código identificador de RecursoAgencia e incorpora
 * información propia del vehículo como patente, modelo y capacidad.
 *
 * @author Maxi
 */

public class Vehiculo implements Registrable {
    private String codigoVehiculo;
    private String patente;
    private String modelo;
    private int capacidad;

    public Vehiculo() {
    }

    public Vehiculo(String codigoVehiculo, String patente, String modelo, int capacidad) {
        this.codigoVehiculo = codigoVehiculo;
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String mostrarResumen() {
        return "Vehiculo | " + "Patente: " + getPatente() + " | " + "Modelo: " + getModelo() + " | " + "Capacidad: " + getCapacidad() + " Pasajeros";
    }
}
