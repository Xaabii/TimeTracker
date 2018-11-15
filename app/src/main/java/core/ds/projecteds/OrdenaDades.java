package core.ds.projecteds;

import java.util.ArrayList;

/**
 * Classe OrdenaDades: Classe que té l'estructura de dades de l'informe.
 */
public class OrdenaDades {
    private static OrdenaDades dadesOrdenades = null;
    private final ArrayList<ArrayList<String>> llistaProjectesArrel = new ArrayList<>();
    private final ArrayList<ArrayList<String>> llistaSubProjectes = new ArrayList<>();
    private final ArrayList<ArrayList<String>> llistaTasques = new ArrayList<>();
    private final ArrayList<ArrayList<String>> llistaIntervals = new ArrayList<>();

    public static OrdenaDades getInstance() {
        if (dadesOrdenades == null) {
            dadesOrdenades = new OrdenaDades();
        }
        return dadesOrdenades;
    }

    public OrdenaDades() {

    }

    public void netejaDades() {
        if (!getLlistaProjectesArrel().isEmpty()) {
            getLlistaProjectesArrel().clear();
            getLlistaIntervals().clear();
            getLlistaSubProjectes().clear();
            getLlistaTasques().clear();
        }
    }


    public ArrayList<ArrayList<String>> getLlistaProjectesArrel() {
        return llistaProjectesArrel;
    }

    public ArrayList<ArrayList<String>> getLlistaSubProjectes() {
        return llistaSubProjectes;
    }

    public ArrayList<ArrayList<String>> getLlistaTasques() {
        return llistaTasques;
    }

    public ArrayList<ArrayList<String>> getLlistaIntervals() {
        return llistaIntervals;
    }

}