package model;

public abstract class Persona {

    private String nombre;
    private int edad;
    private String rut;
    private Contacto contacto;

    public Persona() {
    }

    public Persona(String nombre, int edad, String rut, Contacto contacto) {
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}
