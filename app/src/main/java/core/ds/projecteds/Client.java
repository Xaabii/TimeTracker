package core.ds.projecteds;


import java.util.ArrayList;
import java.util.Date;

public class Client extends Thread {

    private static final double duracioMinimaInterval = 1;

    public static void main(final String[] args) {
        final long duracioInterval = 2000;
        Logback logback = Logback.getInstance();
        Rellotge rellotge = Rellotge.getInstance();
        new Tick(duracioInterval, rellotge);
        Projecte projecteTest = new Projecte("arrel", "arrel", null);
        TestA1(projecteTest);

        projecteTest = new Projecte("arrel", "arrel", null);
        TestA2(projecteTest);

        logback.enregistrarInfo("Es carrega el projecte desitjat");
        Fitxer f = new Fitxer();
        Projecte p = f.importar("SERIALIZABLE.ser");
        logback.enregistrarWarning("Possible error d'entrada i/o sortida");
        llegir(p);

        Ascii arxiuAscii = new Ascii();
        Html arxiuHtml = new Html();

        projecteTest = new Projecte("arrel", "arrel", null);
        ArrayList<Date> dates = TestFita2(projecteTest);
        Date dataInicial = dates.get(0);
        Date dataFinal = dates.get(1);
        new InformeBreu(projecteTest, dataInicial, dataFinal, arxiuAscii);
        new InformeBreu(projecteTest, dataInicial, dataFinal, arxiuHtml);
        new InformeDetallat(projecteTest, dataInicial, dataFinal, arxiuHtml);
        new InformeDetallat(projecteTest, dataInicial, dataFinal, arxiuAscii);
    }

    private static void llegir(final Activitat p) {
        if (p instanceof Projecte) {
            for (Activitat g : p.getFills()) {
                System.out.println("el projecte: " + g.getNom()
                        + " amb durada " + g.getDurada());
                llegir(g);
            }
        }
    }

    private static void TestA1(final Projecte projecteTest) {
        Logback logback = Logback.getInstance();
        logback.enregistrarInfo("Inici test A1");
        final int tresMil = 3000;
        final int setMil = 7000;
        final int deuMil = 10000;
        final int dosMil = 2000;
        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3", duracioMinimaInterval);
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1", duracioMinimaInterval);
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2", duracioMinimaInterval);
        new Impressor(projecteTest);


        try {
            tasca3.comencaTasca();
            sleep(tresMil);
            tasca3.acabaTasca();
            sleep(setMil);
            tasca2.comencaTasca();
            sleep(deuMil);
            tasca2.acabaTasca();
            tasca3.comencaTasca();
            sleep(dosMil);
            tasca3.acabaTasca();

        } catch (InterruptedException e) {
            logback.enregistrarError("Sleep ha donat error en el test A1");
            e.printStackTrace();
        }
    }

    private static void TestA2(final Projecte projecteTest) {
        Logback logback = Logback.getInstance();
        logback.enregistrarInfo("Inici test A2");
        final int quatreMil = 4000;
        final int dosMil = 2000;


        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3", duracioMinimaInterval);
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1", duracioMinimaInterval);
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2", duracioMinimaInterval);
        new Impressor(projecteTest);
        Fitxer fitxer = new Fitxer();

        try {
            tasca3.comencaTasca();
            sleep(quatreMil);
            tasca2.comencaTasca();
            sleep(dosMil);
            tasca3.acabaTasca();
            sleep(dosMil);
            tasca1.comencaTasca();
            sleep(quatreMil);
            tasca1.acabaTasca();
            sleep(dosMil);
            tasca2.acabaTasca();
            sleep(quatreMil);
            tasca3.comencaTasca();
            sleep(dosMil);
            tasca3.acabaTasca();
        } catch (InterruptedException e) {
            logback.enregistrarError("Sleep ha donat error en el test A2");
            e.printStackTrace();
        }

        fitxer.exportar("SERIALIZABLE.ser", projecteTest);
    }

    private static ArrayList<Date> TestFita2(final Projecte projecteTest) {
        Logback logback = Logback.getInstance();
        logback.enregistrarInfo("Inici test Fita 2");
        final int quatreMil = 4000;
        final int dosMil = 2000;
        final int sisMil = 6000;

        ArrayList<Date> dates = new ArrayList<>();
        Date dataInicial;
        Date dataFinal;
        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Projecte projecte2 = projecteTest.crearProjecte("projecte2", "dproj2");
        Projecte projecte1_2 = projecte1.crearProjecte("projecte1_2", "dproj1_2");
        Tasca tasca1 = projecte1.crearTasca("tasca1", "dt1", duracioMinimaInterval);
        Tasca tasca2 = projecte1.crearTasca("tasca2", "dt2", duracioMinimaInterval);
        Tasca tasca4 = projecte1_2.crearTasca("tasca4", "dt4", duracioMinimaInterval);
        Tasca tasca3 = projecte2.crearTasca("tasca3", "dt3", duracioMinimaInterval);

        new Impressor(projecteTest);

        try {
            tasca1.comencaTasca();
            tasca4.comencaTasca();
            sleep(quatreMil);
            dataInicial = new Date();
            tasca1.acabaTasca();
            tasca2.comencaTasca();
            sleep(sisMil);
            tasca2.acabaTasca();
            tasca4.acabaTasca();
            tasca3.comencaTasca();
            sleep(quatreMil);
            dataFinal = new Date();
            tasca3.acabaTasca();
            tasca2.comencaTasca();
            sleep(dosMil);
            tasca3.comencaTasca();
            sleep(quatreMil);
            tasca2.acabaTasca();
            tasca3.acabaTasca();
            dates.add(dataInicial);
            dates.add(dataFinal);
        } catch (InterruptedException e) {
            logback.enregistrarError("Sleep ha donat error en el test de la fita 2");
            e.printStackTrace();
        }

        return dates;
    }
}