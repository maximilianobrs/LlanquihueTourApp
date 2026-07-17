package model;

/**
 * Representa la información de contacto de una persona.
 * Almacena el teléfono y el correo electrónico.
 *
 * @author Maxim
 */
public class Contacto {
    private String telefono;
    private String correo;

    public Contacto() {
    }

    public Contacto(String telefono, String correo) {
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
