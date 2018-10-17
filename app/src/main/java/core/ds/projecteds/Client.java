package core.ds.projecteds;

import java.io.IOException;
import java.util.ArrayList;

public class Client extends Thread {

    private static double duracioMinimaInterval = 1;

    public static void main(String[] args) throws IOException {
        Rellotge rellotge = Rellotge.getInstance();
        new Tick(2, rellotge);
        //TestA1();
        TestA2();
        Fitxer f = new Fitxer();
        Projecte p = f.importar("a.ser");
        llegir(p);
    }

    public static void llegir(Activitat p) {
        if (p instanceof Projecte) {
            for (Activitat g : p.getFills()) {
                System.out.println(g.getNom() + g.getDurada());
                llegir(g);
            }
        }
    }

    public static void TestA1() {
        System.out.println("--------- TEST A1 ---------");
        Impressor impressor = new Impressor();
        Fitxer fitxer = new Fitxer();
        Projecte arrel = new Projecte("arrel", "arrel", null);
        Projecte projecte1 = arrel.crearProjecte("projecte1", "dproj1");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");


        tasca3.començaTasca();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca3.acabaTasca();
        try {
            sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca2.començaTasca();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca2.acabaTasca();
        tasca3.començaTasca();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca3.acabaTasca();
        arrel.acceptaVisitor(impressor);
        arrel.acceptaVisitor(fitxer);

    }

    public static void TestA2() throws IOException {
        System.out.println("--------- TEST A2 ---------");
        Impressor impressor = new Impressor();
        Fitxer fitxer = new Fitxer();
        Projecte arrel = new Projecte("arrel", "arrel", null);
        Projecte projecte1 = arrel.crearProjecte("projecte1", "dproj1");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");

        tasca3.començaTasca();

        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca2.començaTasca();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca3.acabaTasca();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca1.començaTasca();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca1.acabaTasca();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca2.acabaTasca();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca3.començaTasca();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tasca3.acabaTasca();
        arrel.acceptaVisitor(impressor);
        arrel.acceptaVisitor(fitxer);
        fitxer.exportar("a.ser", arrel);
    }
}