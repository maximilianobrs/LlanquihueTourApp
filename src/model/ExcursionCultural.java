package model;

public class ExcursionCultural extends ServicioTuristico{
    private String lugarTuristico;

    public ExcursionCultural() {}

    public ExcursionCultural(String lugarTuristico) {
        this.lugarTuristico = lugarTuristico;
    }

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
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println(" | Lugar turistico: " + getLugarTuristico());
    }

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                " Nombre: " + getNombre() +
                " | Duracion: " + getDuracionHoras() + " h" +
                " | Lugar turistico: " + getLugarTuristico() +
                '}';
    }
}
