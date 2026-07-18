package model;

/**
 * Representa a un cliente de la agencia turística.
 * Hereda los datos de una persona e implementa la interfaz Registrable.
 *
 * @author Maxim
 */
public class Cliente extends Persona implements Registrable {
    private String codigoCliente;

    public Cliente() {
    }

    public Cliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente(String codigoCliente,String nombre,String rut, Contacto contacto) {
        super(nombre,rut, contacto);
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCorreo(){
        return getContacto().getCorreo();
    }
    public String getTelefono(){
        return getContacto().getTelefono();
    }

    @Override
    public String mostrarResumen(){
        return "Cliente | " +
                "Codigo: " + getCodigoCliente() +
                " | "+ "Nombre: " + getNombre() +
                " | " + "Rut: " + getRut() +
                " | " + "Correo: " +getCorreo() +
                " | " + "Telefono: " + getTelefono();
    }

    @Override
    public String registrar() {
        return "Cliente " + getNombre() + " registrado correctamente";
    }

    @Override
    public String toString(){
        return "ID: " + getCodigoCliente() + " C: " + getNombre();
    }
}
