package data;
import model.*;

public class GestorServicios {
    public void crearServicios(){
        RutaGastronomica ruta1 = new RutaGastronomica("Ruta del Salmón", 4, 5);
        RutaGastronomica ruta2 = new RutaGastronomica("Ruta Cervecera", 3, 4);
        RutaGastronomica ruta3 = new RutaGastronomica("Ruta del Mar", 5, 6);
        RutaGastronomica ruta4 = new RutaGastronomica("Ruta Campestre", 2, 3);

        PaseoLacustre paseo1 = new PaseoLacustre("Lago Llanquihue", 2, "Catamarán");
        PaseoLacustre paseo2 = new PaseoLacustre("Lago Todos los Santos", 3, "Lancha");
        PaseoLacustre paseo3 = new PaseoLacustre("Isla Chiloé Tour", 4, "Bote turístico");
        PaseoLacustre paseo4 = new PaseoLacustre("Recorrido Volcán Osorno", 3, "Ferri");

        ExcursionCultural excursion1 = new ExcursionCultural("Museo Colonial Alemán", 2, "Frutillar");
        ExcursionCultural excursion2 = new ExcursionCultural("Patrimonio Histórico", 5, "Puerto Varas");
        ExcursionCultural excursion3 = new ExcursionCultural("Centro Cultural", 3, "Puerto Montt");
        ExcursionCultural excursion4 = new ExcursionCultural("Iglesias Patrimoniales", 4, "Chiloé");

        System.out.println("\n=== RUTAS GASTRONOMICAS ===\n");
        System.out.println(ruta1);
        System.out.println(ruta2);
        System.out.println(ruta3);
        System.out.println(ruta4);

        System.out.println("\n=== PASEOS LOCUSTRES ===\n");
        System.out.println(paseo1);
        System.out.println(paseo2);
        System.out.println(paseo3);
        System.out.println(paseo4);

        System.out.println("\n=== EXCURSIONES CULTURAL ===\n");
        System.out.println(excursion1);
        System.out.println(excursion2);
        System.out.println(excursion3);
        System.out.println(excursion4);
    }
}
