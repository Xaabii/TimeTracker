package core.ds.projecteds;

import java.util.ArrayList;

public class Client extends Thread {

    private static double duracioMinimaInterval = 1;

    public static void main(String[] args) {
        Rellotge rellotge = Rellotge.getInstance();
        new Tick(2, rellotge);
        //rellotge.comencaRellotge(2, rellotge);
        //TestA1();
        TestA2();
    }

    public static void TestA1() {
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
        Impressor impressor = new Impressor(arrel);
        impressor.imprimir();
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
        impressor.imprimir();
    }

    public static void TestA2() {
        Projecte arrel = new Projecte("arrel", "arrel", null);
        Projecte projecte1 = arrel.crearProjecte("projecte1", "dproj1");
        Projecte projecte2 = projecte1.crearProjecte("projecte2", "dproj2");
        Tasca tasca3 = projecte1.crearTasca("tasca3", "dt3");
        Tasca tasca1 = projecte2.crearTasca("tasca1", "dt1");
        Tasca tasca2 = projecte2.crearTasca("tasca2", "dt2");

        projecte1.getFills();
        tasca3.començaTasca();
        Impressor impressor = new Impressor(arrel);
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
        projecte1.getFills();
        impressor.imprimir();

    }
}