package core.ds.projecteds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/*
 * Classe Ascii: És la classe on s'implementaran els atributs i mètodes necessaris,
 * per tal que es creiï adequadament l'informe en format ascii.
 */
public class Ascii extends Format {
    private OrdenaDades ordenaDades;

    public Ascii() {
        setOrdenaDades(OrdenaDades.getInstance());
    }

    public void breu(final Date dataInicialInforme, final Date dataFinalInforme) {
        String direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeBreuAscii.txt";
        File fitxer = new File(direccio);
        PrintWriter printerWriter;
        try {
            printerWriter = new PrintWriter(fitxer);
            printerWriter.println("------------------------------------"
                    + "----------------------------------"
                    + "---------------------------------------"
                    + "-------------------------------------------"
                    + "---------------");
            printerWriter.println("Informe Breu");
            printerWriter.println("-----------------------------------------"
                    + "----------------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "-----------");
            printerWriter.println("Període");
            printerWriter.println("Data");
            printerWriter.println("Des de    " + dataInicialInforme);
            printerWriter.println("Fins a    " + dataFinalInforme);
            printerWriter.println("Data de generació de l'informe " + new Date().toString());
            printerWriter.println("-----------------------------------------"
                    + "----------------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "-----------");
            printerWriter.println("Projectes arrel");
            printerWriter.println(String.format("%10s %40s %40s %40s \r\n",
                    "Projecte", "Data d'inici", "Data final", "Temps total"));
            ArrayList llistaProjectesArrel = getOrdenaDades().getLlistaProjectesArrel();
            for (int i = 0; i < llistaProjectesArrel.size(); i++) {
                ArrayList node = (ArrayList) llistaProjectesArrel.get(i);
                String nom = (String) node.get(0);
                String dataInici = (String) node.get(1);
                String dataFi = (String) node.get(2);
                String total = (String) node.get(3);
                printerWriter.println(String.format("%10s %40s %40s %40s \r\n",
                        nom, dataInici, dataFi, total));
            }
            printerWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    + "---------------------------------");
            printerWriter.println("Time Tracker v1.0");
            printerWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void detallat(final Date dataInicialInforme, final Date dataFinalInforme) {
        String direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeDetallatAscii.txt";
        File fitxer = new File(direccio);
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(fitxer);

            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Informe detallat");
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Període");
            printWriter.println("Data");
            printWriter.println("Desde     " + dataInicialInforme);
            printWriter.println("Fins a    " + dataFinalInforme);
            printWriter.println(
                    "Data de generació de l'informe  " + new Date().toString());
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Projectes arrel \n");
            printWriter.println(String.format("%10s %40s %40s %40s \r\n",
                    "Projecte", "Data d'inici", "Data final", "Temps total"));
            ArrayList llistaProjectesArrel = getOrdenaDades().getLlistaProjectesArrel();
            for (int i = 0; i < llistaProjectesArrel.size(); i++) {
                ArrayList node = (ArrayList) llistaProjectesArrel.get(i);
                String nom = (String) node.get(0);
                String dataInici = (String) node.get(1);
                String dataFi = (String) node.get(2);
                String total = (String) node.get(3);
                printWriter.println(String.format("%10s %40s %40s %40s \r",
                        nom, dataInici, dataFi, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Subprojectes");
            printWriter.println("S'inclouen en la següent taula només els "
                    + "subprojectes que tinguin alguna tasca amb algun interval"
                    + " dins del període.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %30s %30s %30s %30s \r\n",
                    "Nom projecte pare", "Subprojecte", "Data d'inici",
                    "Data final", "Temps total"));
            ArrayList llistaSubprojectes = getOrdenaDades().getLlistaSubProjectes();
            for (int i = 0; i < llistaSubprojectes.size(); i++) {
                ArrayList node = (ArrayList) llistaSubprojectes.get(i);
                String pare = (String) node.get(0);
                String nom = (String) node.get(1);
                String inici = (String) node.get(2);
                String fin = (String) node.get(3);
                String total = (String) node.get(4);
                printWriter.println(String.format(
                        "%10s %30s %30s %30s %30s \r",
                        pare, nom, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Tasques");
            printWriter.println("S'inclouen en la següent taula"
                    + " la durada de totes les tasques i"
                    +	" el projecte al qual pertanyen.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %30s %30s %30s %30s \r\n",
                    "Nom projecte pare", "Tasca", "Data d'inici",
                    "Data final", "Temps total"));
            ArrayList llistaTasca = getOrdenaDades().getLlistaTasques();
            for (int i = 0; i < llistaTasca.size(); i++) {
                ArrayList node = (ArrayList) llistaTasca.get(i);
                String pare = (String) node.get(0);
                String nom = (String) node.get(1);
                String inici = (String) node.get(2);
                String fin = (String) node.get(3);
                String total = (String) node.get(4);
                printWriter.println(String.format("%10s %30s %30s %30s %30s \r",
                        pare, nom, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Intervals");
            printWriter.println("S'inclouen en la següent "
                    + "taula el temps d'inici, "
                    + "final i la durada de tots els "
                    + "intervals entre la data inicial i final"
                    + " especificades, i la tasca i projecte al qual pertanyen.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %20s %20s %30s %30s %30s \r\n",
                    "Projecte pare", "Tasca", "Nº interval", "Data d'inici", "Data final", "Temps total"));
            ArrayList llistaIntervals = getOrdenaDades().getLlistaIntervals();
            for (int i = 0; i < llistaIntervals.size(); i++) {
                ArrayList node = (ArrayList) llistaIntervals.get(i);
                String pare = (String) node.get(0);
                String tasca = (String) node.get(1);
                String num = (String) node.get(2);
                String inici = (String) node.get(3);
                String fin = (String) node.get(4);
                String total = (String) node.get(5);
                printWriter.println(String.format(
                        "%10s %20s %20s %30s %30s %30s \r",
                        pare, tasca, num, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------");
            printWriter.println("Time Tracker v1.0");
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public OrdenaDades getOrdenaDades() {
        return ordenaDades;
    }

    public void setOrdenaDades(final OrdenaDades dades) {
        this.ordenaDades = dades;
    }
}
