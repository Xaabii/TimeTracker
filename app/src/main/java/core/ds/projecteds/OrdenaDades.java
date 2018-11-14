package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe OrdenaDades: Classe que té l'estructura de dades de l'informe.
 */
public class OrdenaDades {
    private static OrdenaDades dadesOrdenades = null;
    private ArrayList llistaProjectesArrel;
    private ArrayList llistaSubProjectes;
    private ArrayList llistaTasques;
    private ArrayList llistaIntervals;

    public static OrdenaDades getInstance() {
        if (dadesOrdenades == null) {
            dadesOrdenades = new OrdenaDades();
        }
        return dadesOrdenades;
    }

    public OrdenaDades() {
        setLlistaIntervals(new ArrayList());
        setLlistaProjectesArrel(new ArrayList());
        setLlistaTasques(new ArrayList());
        setLlistaSubProjectes(new ArrayList());
    }

    public void netejaDades() {
        if (!getLlistaProjectesArrel().isEmpty()) {
            getLlistaProjectesArrel().clear();
            getLlistaIntervals().clear();
            getLlistaSubProjectes().clear();
            getLlistaTasques().clear();
        }
    }

    public static OrdenaDades getDadesOrdenades() {
        return dadesOrdenades;
    }

    public static void setDadesOrdenades(final OrdenaDades dadesOrd) {
        OrdenaDades.dadesOrdenades = dadesOrd;
    }

    public ArrayList getLlistaProjectesArrel() {
        return llistaProjectesArrel;
    }

    public void setLlistaProjectesArrel(final ArrayList projectesArrel) {
        this.llistaProjectesArrel = projectesArrel;
    }

    public ArrayList getLlistaSubProjectes() {
        return llistaSubProjectes;
    }

    public void setLlistaSubProjectes(ArrayList llistaSubProjectes) {
        this.llistaSubProjectes = llistaSubProjectes;
    }

    public ArrayList getLlistaTasques() {
        return llistaTasques;
    }

    public void setLlistaTasques(ArrayList llistaTasques) {
        this.llistaTasques = llistaTasques;
    }

    public ArrayList getLlistaIntervals() {
        return llistaIntervals;
    }

    public void setLlistaIntervals(ArrayList llistaIntervals) {
        this.llistaIntervals = llistaIntervals;
    }
}