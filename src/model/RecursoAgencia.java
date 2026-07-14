package model;

/**
 * Clase abstracta base que representa una entidad gestionable
 * dentro de la agencia turística.
 * Contiene información común como el código identificador.
 *
 * @author Maxi
 */

public abstract class RecursoAgencia {
    private String codigo;

    public RecursoAgencia() {
    }

    public RecursoAgencia(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
