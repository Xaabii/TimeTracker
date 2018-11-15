package core.ds.projecteds;


import java.util.Date;

public class Client extends Thread {

    private static double duracioMinimaInterval = 1;

    public static void main(final String[] args) {
        final long duracioInterval = 2000;
        Rellotge rellotge = Rellotge.getInstance();
        new Tick(duracioInterval, rellotge);
        Projecte projecteTest = new Projecte("arrel", "arrel", null);
        Date dataInicial = Rellotge.getInstance().getHora();
        TestA1(projecteTest);

        //projecteTest = new Projecte("arrel", "arrel", null);
        //TestA2(projecteTest);

       /* Fitxer f = new Fitxer();
        Projecte p = f.importar("SERIALIZABLE.ser");
        llegir(p);*/

       Date dataFinal = Rellotge.getInstance().getHora();
       //new InformeBreu(projecteTest, dataInicial, dataFinal, "ascii");
       new InformeDetallat(projecteTest, dataInicial, dataFinal, "ascii");
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
        System.out.println("--------- TEST A1 ---------");
        final int tresMil = 3000;
        final int setMil = 7000;
        final int deuMil = 10000;
        final int dosMil = 2000;
        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");
        Impressor impressor = new Impressor(projecteTest);
        //Fitxer fitxer = new Fitxer();

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

            //projecteTest.acceptaVisitor(fitxer);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void TestA2(final Projecte projecteTest) {
        System.out.println("\n\n--------- TEST A2 ---------");
        final int quatreMil = 4000;
        final int dosMil = 2000;


        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");
        Impressor impressor = new Impressor(projecteTest);
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
            e.printStackTrace();
        }
        projecteTest.acceptaVisitor(impressor);
        projecteTest.acceptaVisitor(fitxer);
        fitxer.exportar("SERIALIZABLE.ser", projecteTest);
    }
}