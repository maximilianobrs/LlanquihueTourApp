package model;

public abstract class Personal extends Persona {
    private String fechaDeIngreso;

    public Personal() {
    }

    public Personal(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Personal(String nombre, int edad, String rut, Contacto contacto, String fechaDeIngreso) {
        super(nombre, edad, rut, contacto);
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }
}
