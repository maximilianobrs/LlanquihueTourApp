package model;

/**
 * Define el contrato que deben implementar los recursos.
 * que pueden registrarse y mostrar un resumen de su información.
 *
 * @author Maxim
 */
public interface Registrable {
    String mostrarResumen();
    String registrar();
}
