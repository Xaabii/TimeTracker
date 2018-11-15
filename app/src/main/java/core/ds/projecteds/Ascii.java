package core.ds.projecteds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Ascii extends Format {
    private OrdenaDades ordenaDades;

    public Ascii(final Date dataInici, final Date dataFinal) {
        setOrdenaDades(OrdenaDades.getInstance());
    }

    public void asciiBreu(final Date dataInicial, final Date dataFinal) {
        final int tres = 3;
        File fitxer = new File("C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeBreuAscii.txt");
        PrintWriter printerWriter;
        try {
            printerWriter = new PrintWriter(fitxer);
            printerWriter.println("------------------------------------"
                    + "----------------------------------"
                    + "---------------------------------------"
                    + "-------------------------------------------"
                    + "---------------------------");
            printerWriter.println("Informe Breu");
            printerWriter.println("-----------------------------------------"
                    + "-----------------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "-----------------------");
            printerWriter.println("Període");
            printerWriter.println("Data");
            printerWriter.println("Des de " + dataInicial);
            printerWriter.println("Fins a " + dataFinal);
            printerWriter.println("Data de generació de l'informe " + new Date().toString());
            printerWriter.println("-----------------------------------------"
                    + "-----------------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "-----------------------");
            printerWriter.println("Projectes arrel");
            printerWriter.println(String.format("%10s %40s %40s %40s \r\n",
                    "Projecte", "Data Inici", "Data final", "Temps total"));
            ArrayList llistaProjectesArrel = getOrdenaDades().getLlistaProjectesArrel();
            for (int i = 0; i < llistaProjectesArrel.size(); i++) {
               ArrayList node = (ArrayList) llistaProjectesArrel.get(i);
               String nom = (String) node.get(0);
               String dataInici = (String) node.get(1);
               String dataFi = (String) node.get(2);
               String total = (String) node.get(3);
               printerWriter.println(String.format("%10s %40s %40s %40s \r\n",
                       nom, dataInici, dataFi, total));
                printerWriter.println("-----------------------------------------"
                        + "-------------------------------------------"
                        + "--------------------------------------------------"
                        + "---------------------------------------------");
                printerWriter.println("Time Tracker v1.0");
            }
            printerWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void asciiDetallat(final Date dataInicial, final Date dataFinal) {
        File fitxer = new File("C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeDetallatAscii.txt");
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(fitxer);

            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
            printWriter.println("Informe detallat");
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
            printWriter.println("Període");
            printWriter.println("Data");
            printWriter.println("Desde" + dataInicial);
            printWriter.println("Fins a" + dataFinal);
            printWriter.println(
                    "Data de generació de l'informe" + new Date().toString());
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
            printWriter.println("Projectes arrel");
            printWriter.println(String.format("%10s %40s %40s %40s \r\n",
                    "Projecte", "Data Inici", "Data final", "Temps total"));
            ArrayList llistaProjectesArrel =
                    getOrdenaDades().getLlistaProjectesArrel();
            for (int i = 0; i < llistaProjectesArrel.size(); i++) {
                ArrayList nodaDades = (ArrayList) llistaProjectesArrel.get(i);
                String nom = (String) nodaDades.get(0);
                String inici = (String) nodaDades.get(1);
                String fin = (String) nodaDades.get(2);
                String total = (String) nodaDades.get(3);
                printWriter.println(String.format(
                        "%10s %40s %40s %40s \r\n", nom, inici, fin, total));
            }
            printWriter.println("Subprojectes");
            printWriter.println("S'inclouen en la següent taula només els "
                    + "subprojectes que tinguin alguna tasca amb algun interval"
                    + " dins del període.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %40s %40s %40s %40s \r\n",
                    "Nom ProjectePare", "Subprojecte", "Data Inici",
                    "Data final", "Temps total"));
            ArrayList llistaSubprojectes =
                    getOrdenaDades().getLlistaSubProjectes();
            for (int i = 0; i < llistaSubprojectes.size(); i++) {
                ArrayList nodaSubProj =
                        (ArrayList) llistaSubprojectes.get(i);
                String pare = "";
                String nom = (String) nodaSubProj.get(0);
                String inici = (String) nodaSubProj.get(1);
                String fin = (String) nodaSubProj.get(2);
                String total = (String) nodaSubProj.get(3);
                printWriter.println(String.format(
                        "%10s %40s %40s %40s %40s \r\n",
                        pare, nom, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
            printWriter.println("Tasques");
            printWriter.println("S'inclouen en la següent taula"
                    + " la durada de totes les tasques i"
                    +	" el projecte al qual pertanyen.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %40s %40s %40s %40s \r\n",
                    "Nom ProjectePare", "Tasca", "Data Inici",
                    "Data final", "Temps total"));
            ArrayList llistaTasca =
                    getOrdenaDades().getLlistaTasques();
            for (int i = 0; i < llistaTasca.size(); i++) {
                ArrayList nodatasca = (ArrayList) llistaTasca.get(i);
                String pare = "";
                String nom = (String) nodatasca.get(0);
                String inici = (String) nodatasca.get(1);
                String fin = (String) nodatasca.get(2);
                String total = (String) nodatasca.get(3);
                printWriter.println(String.format("%10s %40s %40s %40s "
                    + "%40s \r\n", pare, nom, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
            printWriter.println("Intervals");
            printWriter.println("S'inclouen en la següent "
                    + "taula el temps d'inici, "
                    + "final i la durada de tots els "
                    + "intervals entre la data inicial i final"
                    + " especificades, i la tasca i projecte al qual pertanyen.");
            printWriter.println("\n");
            printWriter.println(String.format("%10s %40s %40s %40s %40s \r\n",
                    "Nº", "Tasca", "Data Inici", "Data final", "Temps total"));
            ArrayList llistaInter = getOrdenaDades().getLlistaIntervals();
            for (int i = 0; i < llistaInter.size(); i++) {
                ArrayList nodainter = (ArrayList) llistaInter.get(i);
                String pare = "";
                String num = String.valueOf(i);
                String inici = (String) nodainter.get(0);
                String fin = (String) nodainter.get(1);
                String total = (String) nodainter.get(2);
                printWriter.println(String.format(
                        "%10s %40s %40s %40s %40s \r\n",
                        num, pare, inici, fin, total));
            }
            printWriter.println("-----------------------------------------"
                    + "-------------------------------------------"
                    + "--------------------------------------------------"
                    +	"---------------------------------------------");
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
