package core.ds.projecteds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
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
        System.out.println("asciiDetallat");
    }

    public OrdenaDades getOrdenaDades() {
        return ordenaDades;
    }

    public void setOrdenaDades(final OrdenaDades dades) {
        this.ordenaDades = dades;
    }
}
