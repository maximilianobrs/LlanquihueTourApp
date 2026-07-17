package model;

/**
 * Representa una persona del sistema.
 * Contiene la información común de clientes y guías turísticos.
 *
 * @author Maxim
 */
public abstract class Persona {

    private String nombre;
    private String rut;
    private Contacto contacto;

    public Persona() {
    }

    public Persona(String nombre, String rut, Contacto contacto) {
        this.nombre = nombre;
        this.rut = rut;
        this.contacto = contacto;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}
