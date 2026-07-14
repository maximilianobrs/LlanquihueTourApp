package utils;

import interfaces.Registrable;
import java.util.ArrayList;

public class AppUtils {

    public String generarCodigo(ArrayList<Registrable> recursos,Class<?> tipo,String prefijo) {

        int contador = 0;

        for (Registrable r : recursos) {
            if (tipo.isInstance(r)) {
                contador++;
            }
        }

        return prefijo + String.format("%03d", contador + 1);
    }

}
