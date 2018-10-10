package core.ds.projecteds;

public class Tick extends Thread {
    private long tempsInterval;
    Rellotge rellotge;

    public Tick(long interval, Rellotge rellotge) {
        setDaemon(true);
        this.tempsInterval = interval;
        this.rellotge = rellotge;
        start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(tempsInterval);
                rellotge.tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getInterval() {
        return tempsInterval;
    }

    public void setInterval(long interval) {
        this.tempsInterval = interval;
    }

    public Rellotge getRellotge() {
        return rellotge;
    }

    public void setRellotge(Rellotge rellotge) {
        this.rellotge = rellotge;
    }
}