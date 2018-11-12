package core.ds.projecteds;
import java.io.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Interval implements Observer, Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataInicial;
    private Date dataFinal;
    private Tasca tascaPare;

    private double durada;
    private boolean intervalActivat;

    public Interval(Tasca pare) {
        setTascaPare(pare);
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.addObserver(this);
        setDataInicial(rellotge.getHora());
        setDataFinal(rellotge.getHora());
        setDurada((getDataFinal().getTime()-getDataInicial().getTime())/1000);
    }

    public void finalitzaInterval() {
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.deleteObserver(this);
        setDurada((getDataFinal().getTime() - getDataInicial().getTime())/1000);
    }

    //Mètode del patró de disseny Observer, que rep la notificació del canvi d'estat del rellotge.
    @Override
    public void update(Observable o, Object arg) {
        Rellotge updateRellotge = (Rellotge)o;
        setDataFinal(updateRellotge.getHora());
        setDurada((getDataFinal().getTime() - getDataInicial().getTime())/1000);
        getTascaPare().actualitza();
    }

    public Tasca getTascaPare() { return this.tascaPare;}
    public void setTascaPare(Tasca tascaPare) {
        this.tascaPare = tascaPare;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public double getDurada() {
        return durada;
    }
    public void setDurada(double durada) {
        this.durada = durada;
    }

    public Date getDataFinal() {
        return dataFinal;
    }
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isIntervalActivat() {
        return intervalActivat;
    }
    public void setIntervalActivat(boolean intervalActivat) {
        this.intervalActivat = intervalActivat;
    }
}