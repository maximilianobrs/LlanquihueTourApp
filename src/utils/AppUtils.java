package utils;

/**
 * Clase de utilidades que proporciona métodos para generar códigos
 * y validar datos de entrada de la aplicación.
 *
 * @author Maxim
 */
public class AppUtils {

    /**
     * Genera un código correlativo con un prefijo.
     *
     * @param cantidad cantidad actual de registros.
     * @param prefijo prefijo que identificará el tipo de recurso.
     * @return código generado.
     */
    public static String generarCodigo(int cantidad, String prefijo) {
        return prefijo + String.format("%03d", cantidad + 1);
    }

    /**
     * Valida el formato de un RUT chileno.
     *
     * @param rut RUT que se desea validar.
     * @return true si el formato es válido y false en caso contrario.
     */
    public static boolean rutEsValido(String rut) {
        if (rut == null) {
            return false;
        }

        rut = rut.replace(".", "").trim().toUpperCase();


        if (rut.length() < 3 || !rut.contains("-")) {
            return false;
        }

        String[] partes = rut.split("-");

        if (partes.length != 2) {
            return false;
        }

        String cuerpo = partes[0];
        String dv = partes[1];


        if (cuerpo.length() < 7 || cuerpo.length() > 8) {
            return false;
        }

        if (!cuerpo.matches("\\d+")) {
            return false;
        }

        return dv.length() == 1 && dv.matches("[0-9K]");
    }

    /**
     * Valida el formato de un número de teléfono móvil chileno.
     *
     * @param numero número de teléfono que se desea validar.
     * @return true si el formato es válido y false en caso contrario.
     */
    public static boolean mobilEsValido(String numero) {
        if (numero == null) {
            return false;
        }

        numero = numero.replace(" ", "").replace("-", "").trim();

        if (numero.startsWith("+56")) {
            numero = numero.substring(3);
        } else if (numero.startsWith("56")) {
            numero = numero.substring(2);
        }

        return numero.matches("9\\d{8}");
    }

    /**
     * Valida el formato de una dirección de correo electrónico.
     *
     * @param email correo electrónico que se desea validar.
     * @return true si el formato es válido y false en caso contrario.
     */
    public static boolean emailEsValido(String email) {
        if (email == null) {
            return false;
        }

        email = email.trim();

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        return email.matches(regex);
    }

}
