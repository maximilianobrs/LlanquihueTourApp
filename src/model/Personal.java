package model;

/**
 * Representa al personal de la agencia turística.
 * Hereda los datos básicos de una persona y agrega el cargo que desempeña.
 *
 * @author Maxim
 */
public abstract class Personal extends Persona {
    private String cargo;

    public Personal() {
    }

    public Personal(String cargo) {
        this.cargo = cargo;
    }

    public Personal(String nombre, String rut, Contacto contacto, String cargo) {
        super(nombre,rut, contacto);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
