package utils;

import interfaces.Registrable;
import java.util.List;


public class AppUtils {

    public static String generarCodigo(List<Registrable> recursos, Class<?> tipo, String prefijo) {

        int contador = 0;

        for (Registrable r : recursos) {
            if (tipo.isInstance(r)) {
                contador++;
            }
        }

        return prefijo + String.format("%03d", contador + 1);
    }

    public static boolean isValid(String rut) {
        if (rut == null) {
            return false;
        }

        rut = rut.replace(".", "").trim().toUpperCase();

        // Debe tener al menos 2 caracteres y contener un guion
        if (rut.length() < 3 || !rut.contains("-")) {
            return false;
        }

        String[] partes = rut.split("-");

        if (partes.length != 2) {
            return false;
        }

        String cuerpo = partes[0];
        String dv = partes[1];

        // Validar largo del cuerpo (entre 7 y 8 dígitos, típico en Chile)
        if (cuerpo.length() < 7 || cuerpo.length() > 8) {
            return false;
        }

        // El cuerpo debe ser solo números
        if (!cuerpo.matches("\\d+")) {
            return false;
        }

        // El DV debe ser un solo carácter: 0-9 o K
        return dv.length() == 1 && dv.matches("[0-9K]");
    }

    public static boolean isValidMobile(String numero) {
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

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        email = email.trim();

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        return email.matches(regex);
    }

}
