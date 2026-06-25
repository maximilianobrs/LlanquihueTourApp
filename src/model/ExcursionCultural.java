package model;

public class ExcursionCultural extends ServicioTuristico{
    private String lugarTuristico;


    public ExcursionCultural(String nombre, int duracionHoras, String lugarTuristico) {
        super(nombre, duracionHoras);
        this.lugarTuristico = lugarTuristico;
    }

    public String getLugarTuristico() {
        return lugarTuristico;
    }

    public void setLugarTuristico(String lugarTuristico) {
        this.lugarTuristico = lugarTuristico;
    }

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                " Nombre: " + getNombre() +
                " | Duracion: " + getDuracionHoras() + " h" +
                " | lugarTuristico: " + getLugarTuristico() +
                '}';
    }
}
