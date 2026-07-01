package data;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    List<ServicioTuristico> lista = new ArrayList<>();

    public void crearServicios(){

        lista.add(new ServicioTuristico("City Tour Puerto Montt", 2));
        lista.add(new ServicioTuristico("Visita al Mercado Angelmó", 3));
        lista.add(new ServicioTuristico("Recorrido Costanera", 1));


        lista.add(new RutaGastronomica("Ruta del Salmón", 4, 5));
        lista.add(new RutaGastronomica("Ruta Cervecera", 3, 4));
        lista.add(new RutaGastronomica("Ruta del Mar", 5, 6));


        lista.add(new PaseoLacustre("Lago Llanquihue", 2, "Catamarán"));
        lista.add(new PaseoLacustre("Lago Todos los Santos", 3, "Lancha"));
        lista.add(new PaseoLacustre("Isla Chiloé Tour", 4, "Bote turístico"));


        lista.add(new ExcursionCultural("Museo Colonial Alemán", 2, "Frutillar"));
        lista.add(new ExcursionCultural("Patrimonio Histórico", 5, "Puerto Varas"));
        lista.add(new ExcursionCultural("Iglesias Patrimoniales", 4, "Chiloé"));

    }

    public List<ServicioTuristico> obtenerServicios() {
        return lista;
    }

}
