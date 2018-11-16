package core.ds.projecteds;

/**
 * Classe Tick: Aquesta classe va creant threads per cada interval
 * que es crea, així paralitzem la creació i l'usuari
 * podrà crear diversos threads actius en tasques diferents.
 */
class Tick extends Thread {

    private long tempsInterval;
    private Rellotge rellotge;

   /*
    * El thread que creare serà un daemon i per tant es
    * mantindrà despert en el sistema. Un cop creat estarà
    * constantment escoltant, per notificar.
    * Amb el mètode start, l'encenem.
    */
    public Tick(final long intervalTick, final Rellotge rellotgeTick) {
        setDaemon(true);
        setInterval(intervalTick);
        setRellotge(rellotgeTick);
        start();
    }
    /*
    * Establim el temps que s'han d'esperar abans de
    * tornar a notificar.
    */
    public void run() {
        while (true) {
            try {
                sleep(tempsInterval);
                rellotge.notificarObservadors();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void setInterval(final long interval) {
        this.tempsInterval = interval;
    }

    private void setRellotge(final Rellotge rellotgeTick) {
        this.rellotge = rellotgeTick;
    }
}