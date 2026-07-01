package model;

public class PaseoLacustre extends ServicioTuristico{
    private String tipoDeEmbarcacion;

    public PaseoLacustre(){}

    public PaseoLacustre(String tipoDeEmbarcacion) {
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    public PaseoLacustre(String nombre, int duracionHoras, String tipoDeEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }



    public String getTipoDeEmbarcacion() {
        return tipoDeEmbarcacion;
    }

    public void setTipoDeEmbarcacion(String tipoDeEmbarcacion) {
        this.tipoDeEmbarcacion = tipoDeEmbarcacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre() + " | Duracion: " + getDuracionHoras() + " h" + " | tipo de embarcacion: " + getTipoDeEmbarcacion());
    }

    @Override
    public String toString() {
        return "PaseoLacustre{" +
                " Nombre: " + getNombre() +
                " | Duracion: " + getDuracionHoras() + " h" +
                " | tipo de embarcacion: " + getTipoDeEmbarcacion() +
                '}';
    }
}
