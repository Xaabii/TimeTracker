package core.ds.projecteds;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Interval implements Observer {
    private Date dataInicial;
    private Date dataFinal;
    private Tasca tascaPare;

    private double durada;
    private boolean intervalActivat;

    public Interval(Tasca pare) {
        this.setTascaPare(pare);
        Rellotge.getInstance().addObserver(this);
        setDataInicial(Rellotge.getInstance().getHora());
        setDataFinal(null);
    }

    public void finalitzaInterval() {
        setDataFinal(Rellotge.getInstance().getHora());
        Rellotge.getInstance().deleteObserver(this);
        calculaDurada();
    }

    public void calculaDurada() {
        if (getDataFinal() != null && getDataInicial() != null) {
            setDurada((getDataFinal().getTime() - getDataInicial().getTime())/1000);
        }
    }

    public void impresioInterval() {
        System.out.println("INTERVAL ----> ");
        System.out.println("Data inicial: " + getDataInicial());
        System.out.println("Data final: " + getDataFinal());
        System.out.println("Durada: " + getDurada());
    }

    @Override
    public void update(Observable o, Object arg) {
        Rellotge updateRellotge = (Rellotge)o;
        setDataFinal(updateRellotge.getHora());
    }

    public double getDurada() {
        return durada;
    }

    public void setTascaPare(Tasca tascaPare) {
        this.tascaPare = tascaPare;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
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
