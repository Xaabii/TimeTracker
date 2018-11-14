package core.ds.projecteds;
import java.io.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe Interval: Forma part del patró observer, en cada tick del rellotge
 * actualitza les dades.
 */
class Interval implements Observer, Serializable {

    private Date dataInicial;
    private Date dataFinal;
    private Tasca tascaPare;

    private double durada;

    public Interval(Tasca pare) {
        setTascaPare(pare);
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.addObserver(this);
        setDataInicial(rellotge.getHora());
        setDataFinal(rellotge.getHora());
        setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
    }

    public void finalitzaInterval() {
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.deleteObserver(this);
        setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
    }

    //Mètode del patró de disseny Observer, que rep la notificació
    // del canvi d'estat del rellotge.
    @Override
    public void update(Observable o, Object arg) {
        Rellotge updateRellotge = (Rellotge) o;
        setDataFinal(updateRellotge.getHora());
        setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
        getTascaPare().actualitza();
    }

    private Tasca getTascaPare() {
        return this.tascaPare;
    }
    private void setTascaPare(Tasca tascaPare) {
        this.tascaPare = tascaPare;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    private void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public double getDurada() {
        return durada;
    }
    private void setDurada(double durada) {
        this.durada = durada;
    }

    public Date getDataFinal() {
        return dataFinal;
    }
    private void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }


}