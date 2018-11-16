package core.ds.projecteds;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
 * Classe Html: Classe on s'implementaran tots els atributs i mètodes
 * necessaris, per tal que es creiï adequadament l'informe en format html.
 */
public class Html extends Format {
    public OrdenaDades ordenaDades;
    public paginaweb.PaginaWeb paginaWeb = new paginaweb.PaginaWeb();
    public Html() {
        setOrdenaDades(OrdenaDades.getInstance());

    }

    public void breu(final Date dataInicialInforme, final Date dataFinalInforme) {
        String direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeBreuHtml.html";
        paginaWeb = new paginaweb.PaginaWeb();
        paginaWeb.afegeixLiniaSeparacio();
        paginaWeb.afegeixHeader("Informe Breu", 1, true);
        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA INICIAL*/
        paginaWeb.afegeixHeader("Període", 3, false);
        Collection<ArrayList<String>> taula1 = new ArrayList<>();
        ArrayList<String> fila1Taula1 = new ArrayList<>();
        fila1Taula1.add("");
        fila1Taula1.add("Data");
        ArrayList<String> fila2Taula1 = new ArrayList<>();
        fila2Taula1.add("Des de");
        fila2Taula1.add(dataInicialInforme.toString());
        ArrayList<String> fila3Taula1 = new ArrayList<>();
        fila3Taula1.add("Fins a");
        fila3Taula1.add(dataFinalInforme.toString());
        ArrayList<String> fila4Taula1 = new ArrayList<>();
        fila4Taula1.add("Data de generació de l'informe");
        fila4Taula1.add(new Date().toString());
        taula1.add(fila1Taula1);
        taula1.add(fila2Taula1);
        taula1.add(fila3Taula1);
        taula1.add(fila4Taula1);
        paginaWeb.afegeixTaula(taula1,true,true);

        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA PROJECTES ARREL*/
        paginaWeb.afegeixHeader("Projectes arrel", 3, false);
        Collection<ArrayList<String>> taula2 = new ArrayList<>();
        ArrayList<String> fila1Taula2 = new ArrayList<>();
        fila1Taula2.add("Projecte");
        fila1Taula2.add("Temps d'inici");
        fila1Taula2.add("Temps final");
        fila1Taula2.add("Temps total");
        taula2.add(fila1Taula2);
        ArrayList llistaProjectesArrel = getOrdenaDades().getLlistaProjectesArrel();
        for (int i = 0; i < llistaProjectesArrel.size(); i++) {
            ArrayList<String> projectes = new ArrayList<>();
            ArrayList node = (ArrayList) llistaProjectesArrel.get(i);
            projectes.add((String) node.get(0));
            projectes.add((String) node.get(1));
            projectes.add((String) node.get(2));
            projectes.add((String) node.get(3));
            taula2.add(projectes);
        }
        paginaWeb.afegeixTaula(taula2, true, false);
        paginaWeb.afegeixLiniaSeparacio();
        paginaWeb.afegeixTextNormal("Time Tracker v1.0");
        guardarProjecte(direccio);
    }

    public void detallat(final Date dataInicialInforme, final Date dataFinalInforme) {
        String direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeDetallatHtml.html";
        paginaWeb = new paginaweb.PaginaWeb();
        paginaWeb.afegeixLiniaSeparacio();
        paginaWeb.afegeixHeader("Informe Detallat", 1, true);
        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA INICIAL*/
        paginaWeb.afegeixHeader("Període", 3, false);
        Collection<ArrayList<String>> taula1 = new ArrayList<>();
        ArrayList<String> fila1Taula1 = new ArrayList<>();
        fila1Taula1.add("");
        fila1Taula1.add("Data");
        ArrayList<String> fila2Taula1 = new ArrayList<>();
        fila2Taula1.add("Des de");
        fila2Taula1.add(dataInicialInforme.toString());
        ArrayList<String> fila3Taula1 = new ArrayList<>();
        fila3Taula1.add("Fins a");
        fila3Taula1.add(dataFinalInforme.toString());
        ArrayList<String> fila4Taula1 = new ArrayList<>();
        fila4Taula1.add("Data de generació de l'informe");
        fila4Taula1.add(new Date().toString());
        taula1.add(fila1Taula1);
        taula1.add(fila2Taula1);
        taula1.add(fila3Taula1);
        taula1.add(fila4Taula1);
        paginaWeb.afegeixTaula(taula1,true,true);

        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA PROJECTES ARREL*/
        paginaWeb.afegeixHeader("Projectes arrel", 3, false);
        Collection<ArrayList<String>> taula2 = new ArrayList<>();
        ArrayList<String> fila1Taula2 = new ArrayList<>();
        fila1Taula2.add("Projecte");
        fila1Taula2.add("Data d'inici");
        fila1Taula2.add("Data final");
        fila1Taula2.add("Temps total");
        taula2.add(fila1Taula2);
        ArrayList llistaProjectesArrel = getOrdenaDades().getLlistaProjectesArrel();
        for (int i = 0; i < llistaProjectesArrel.size(); i++) {
            ArrayList<String> projectes = new ArrayList<>();
            ArrayList node = (ArrayList) llistaProjectesArrel.get(i);
            projectes.add((String) node.get(0));
            projectes.add((String) node.get(1));
            projectes.add((String) node.get(2));
            projectes.add((String) node.get(3));
            taula2.add(projectes);
        }
        paginaWeb.afegeixTaula(taula2, true, false);
        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA SUB PROJECTES*/
        paginaWeb.afegeixHeader("Subprojectes", 3, false);
        paginaWeb.afegeixTextNormal("S'inclouen en la següent taula només els subprojectes que tinguin alguna tasca amb algun interval dins del període.");
        Collection<ArrayList<String>> taula3 = new ArrayList<>();
        ArrayList<String> fila1Taula3 = new ArrayList<>();
        fila1Taula3.add("Pare");
        fila1Taula3.add("Projecte");
        fila1Taula3.add("Data d'inici");
        fila1Taula3.add("Data final");
        fila1Taula3.add("Temps total");
        taula3.add(fila1Taula3);
        ArrayList llistaSubProjectes = getOrdenaDades().getLlistaSubProjectes();
        for (int i = 0; i < llistaSubProjectes.size(); i++) {
            ArrayList<String> subProjectes = new ArrayList<>();
            ArrayList node = (ArrayList) llistaSubProjectes.get(i);
            subProjectes.add((String) node.get(0));
            subProjectes.add((String) node.get(1));
            subProjectes.add((String) node.get(2));
            subProjectes.add((String) node.get(3));
            subProjectes.add((String) node.get(4));
            taula3.add(subProjectes);
        }
        paginaWeb.afegeixTaula(taula3, true, false);
        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA TASQUES*/
        paginaWeb.afegeixHeader("Tasques", 3, false);
        paginaWeb.afegeixTextNormal("S'inclouen en la següent taula la durada de totes les tasques i el projecte al qual pertanyen.");
        Collection<ArrayList<String>> taula4 = new ArrayList<>();
        ArrayList<String> fila1Taula4 = new ArrayList<>();
        fila1Taula4.add("Pare");
        fila1Taula4.add("Tasca");
        fila1Taula4.add("Data d'inici");
        fila1Taula4.add("Data final");
        fila1Taula4.add("Temps total");
        taula4.add(fila1Taula4);
        ArrayList llistaTasques = getOrdenaDades().getLlistaTasques();
        for (int i = 0; i < llistaTasques.size(); i++) {
            ArrayList<String> tasques = new ArrayList<>();
            ArrayList node = (ArrayList) llistaTasques.get(i);
            tasques.add((String) node.get(0));
            tasques.add((String) node.get(1));
            tasques.add((String) node.get(2));
            tasques.add((String) node.get(3));
            tasques.add((String) node.get(4));
            taula4.add(tasques);
        }
        paginaWeb.afegeixTaula(taula4, true, false);
        paginaWeb.afegeixLiniaSeparacio();

        /*TAULA INTERVALS*/
        paginaWeb.afegeixHeader("Intervals", 3, false);
        paginaWeb.afegeixTextNormal("S'inclouen en la següent taula el temps d'inici, final i durada de tots els intervals" +
                "entre la data inicial i final especificades, i la tasca i projecte al qual pertanyen.");
        Collection<ArrayList<String>> taula5 = new ArrayList<>();
        ArrayList<String> fila1Taula5 = new ArrayList<>();
        fila1Taula5.add("Projecte pare");
        fila1Taula5.add("Tasca");
        fila1Taula5.add("Interval");
        fila1Taula5.add("Data d'inici");
        fila1Taula5.add("Data final");
        fila1Taula5.add("Durada");
        taula5.add(fila1Taula5);
        ArrayList llistaIntervals = getOrdenaDades().getLlistaIntervals();
        for (int i = 0; i < llistaIntervals.size(); i++) {
            ArrayList<String> interval = new ArrayList<>();
            ArrayList node = (ArrayList) llistaIntervals.get(i);
            interval.add((String) node.get(0));
            interval.add((String) node.get(1));
            interval.add((String) node.get(2));
            interval.add((String) node.get(3));
            interval.add((String) node.get(4));
            interval.add((String) node.get(5));
            taula5.add(interval);
        }
        paginaWeb.afegeixTaula(taula5, true, false);
        paginaWeb.afegeixLiniaSeparacio();
        guardarProjecte(direccio);
    }

    public final void guardarProjecte(final String direccio) {
        File file = new File(direccio);
        try {
            FileOutputStream fis = new FileOutputStream(file);
            PrintStream out = new PrintStream(fis);
            System.setOut(out);
            paginaWeb.escriuPagina();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public OrdenaDades getOrdenaDades() {
        return ordenaDades;
    }

    public void setOrdenaDades(OrdenaDades ordenaDades) {
        this.ordenaDades = ordenaDades;
    }
}