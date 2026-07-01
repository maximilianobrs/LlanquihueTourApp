package data;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    List<ServicioTuristico> servicios = new ArrayList<>();

    public void crearServicios(){
        servicios.add(new RutaGastronomica("Ruta del Salmón", 4, 5));
        servicios.add(new RutaGastronomica("Ruta Cervecera", 3, 4));
        servicios.add(new RutaGastronomica("Ruta del Mar", 5, 6));
        servicios.add(new RutaGastronomica("Ruta Campestre", 2, 3));

        servicios.add(new PaseoLacustre("Lago Llanquihue", 2, "Catamarán"));
        servicios.add(new PaseoLacustre("Lago Todos los Santos", 3, "Lancha"));
        servicios.add(new PaseoLacustre("Isla Chiloé Tour", 4, "Bote turístico"));
        servicios.add(new PaseoLacustre("Recorrido Volcán Osorno", 3, "Ferri"));

        servicios.add(new ExcursionCultural("Museo Colonial Alemán", 2, "Frutillar"));
        servicios.add(new ExcursionCultural("Patrimonio Histórico", 5, "Puerto Varas"));
        servicios.add(new ExcursionCultural("Centro Cultural", 3, "Puerto Montt"));
        servicios.add(new ExcursionCultural("Iglesias Patrimoniales", 4, "Chiloé"));
        servicios.add(new ServicioTuristico("Torre entel",2));

    }

    public List<ServicioTuristico> obtenerServicios() {
        return servicios;
    }

}
