package model;
import interfaces.Registrable;

/**
 * Representa un guía turístico perteneciente a la agencia.
 * Hereda el código identificador de RecursoAgencia e incorpora
 * información propia del trabajador como nombre, edad e idioma.
 *
 * @author Maxi
 */

public class GuiaTuristico extends Personal implements Registrable {

    private String codigoGuia;
    private String idioma;
    private int experiencia;

    public GuiaTuristico() {
    }

    public GuiaTuristico(String codigoGuia, String idioma, int experiencia) {
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
        this.experiencia = experiencia;
    }

    public GuiaTuristico(String fechaDeIngreso, String codigoGuia, String idioma, int experiencia) {
        super(fechaDeIngreso);
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
        this.experiencia = experiencia;
    }

    public GuiaTuristico(String nombre, int edad, String rut, Contacto contacto, String fechaDeIngreso, String codigoGuia, String idioma, int experiencia) {
        super(nombre, edad, rut, contacto, fechaDeIngreso);
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
        this.experiencia = experiencia;
    }


    public String getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(String codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getCorreo(){
        return getContacto().getCorreo();
    }
    public String getTelefono(){
        return getContacto().getTelefono();
    }

    @Override
    public String mostrarResumen() {
        return "Guía Turístico | " + "Código: " + getCodigoGuia() +
                " | " + "Nombre: " + getNombre() +
                " | " + "Edad: " + getEdad() + " Años"+
                " | " + "Rut: " + getRut() +
                " | " + "Correo: " +getCorreo() +
                " | " + "Telefono: " + getTelefono() +
                " | " + "Idioma: " + getIdioma() +
                " | " + "Fecha ingreso: " + getFechaDeIngreso() +
                " | " + "Años experiencia: " + getExperiencia() + " Años";

    }

    @Override
    public String registrar() {
        return "Guia "+ getNombre() +" registrado correctamente";
    }

    @Override
    public String toString(){
        return "ID: " + getCodigoGuia() + " G: " + getNombre();
    }
}
