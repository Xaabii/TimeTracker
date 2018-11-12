package core.ds.projecteds;

//És una classe relacionada amb el rellotge, que simula el pas del temps mitjançant els threads.
public class Tick extends Thread {
    private long tempsInterval;
    Rellotge rellotge;

    public Tick(long interval, Rellotge rellotge) {
        setDaemon(true);
        setInterval(interval);
        setRellotge(rellotge);
        start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(tempsInterval);
                rellotge.notificarObservadors();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void setInterval(long interval) {
        this.tempsInterval = interval;
    }

    public void setRellotge(Rellotge rellotge) {
        this.rellotge = rellotge;
    }
}