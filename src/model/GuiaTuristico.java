package model;
import interfaces.Registrable;

/**
 * Representa un guía turístico perteneciente a la agencia.
 * Hereda el código identificador de RecursoAgencia e incorpora
 * información propia del trabajador como nombre, edad e idioma.
 *
 * @author Maxim
 */
public class GuiaTuristico extends Personal implements Registrable {

    private String codigoGuia;
    private String idioma;

    public GuiaTuristico() {
    }

    public GuiaTuristico(String codigoGuia, String idioma) {
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
    }

    public GuiaTuristico(String codigoGuia, String idioma, String cargo) {
        super(cargo);
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
    }

    public GuiaTuristico(String codigoGuia,String nombre, String rut, Contacto contacto, String cargo,  String idioma) {
        super(nombre,rut, contacto, cargo);
        this.codigoGuia = codigoGuia;
        this.idioma = idioma;
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
                " | " + "Rut: " + getRut() +
                " | " + "Correo: " +getCorreo() +
                " | " + "Telefono: " + getTelefono() +
                " | " + "Idioma: " + getIdioma() +
                " | " + "Cargo: " + getCargo();

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
