package core.ds.projecteds;

import java.io.IOException;

public class Client extends Thread {

    private static double duracioMinimaInterval = 1;

    public static void main(String[] args) throws IOException {
        Rellotge rellotge = Rellotge.getInstance();
        new Tick(2000, rellotge);
        Projecte projecteTest = new Projecte("arrel","arrel",null);
        TestA1(projecteTest);

        projecteTest = new Projecte("arrel","arrel",null);
        TestA2(projecteTest);

       /* Fitxer f = new Fitxer();
        Projecte p = f.importar("SERIALIZABLE.ser");
        llegir(p);*/
    }

    public static void llegir(Activitat p) {
        if (p instanceof Projecte) {
            for (Activitat g : p.getFills()) {
                System.out.println("el projecte: " + g.getNom() + " amb durada " + g.getDurada());
                llegir(g);
            }
        }
    }

    public static void TestA1(Projecte projecteTest) {
        System.out.println("--------- TEST A1 ---------");

        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");
        Impressor impressor = new Impressor(projecteTest);
        Fitxer fitxer = new Fitxer();

        try {
            tasca3.començaTasca();
            sleep(3000);
            tasca3.acabaTasca();
            sleep(7000);
            tasca2.començaTasca();
            sleep(10000);
            tasca2.acabaTasca();
            tasca3.començaTasca();
            sleep(2000);
            tasca3.acabaTasca();

            projecteTest.acceptaVisitor(impressor);
            projecteTest.acceptaVisitor(fitxer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void TestA2(Projecte projecteTest) throws IOException {
        System.out.println("\n\n--------- TEST A2 ---------");

        Projecte projecte1 = projecteTest.crearProjecte("projecte1", "dproj1");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");
        Impressor impressor = new Impressor(projecteTest);
        Fitxer fitxer = new Fitxer();

        try {
            tasca3.començaTasca();
            sleep(4000);
            tasca2.començaTasca();
            sleep(2000);
            tasca3.acabaTasca();
            sleep(2000);
            tasca1.començaTasca();
            sleep(4000);
            tasca1.acabaTasca();
            sleep(2000);
            tasca2.acabaTasca();
            sleep(4000);
            tasca3.començaTasca();
            sleep(2000);
            tasca3.acabaTasca();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        projecteTest.acceptaVisitor(impressor);
        projecteTest.acceptaVisitor(fitxer);
        fitxer.exportar("SERIALIZABLE.ser", projecteTest);
    }
}