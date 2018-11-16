package core.ds.projecteds;
import java.io.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe Interval: Forma part del patró observer, en cada tick del rellotge
 * actualitza les dades. Cada interval pertany a una tasca.
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

    /*
     * Quan es finalitza la tasca, es crida a aquest mètode que
     * elimina l'interval dels observadors del rellotge, i actualitza la durada.
     */
    public void finalitzaInterval() {
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.deleteObserver(this);
        setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
    }

    /*
     * Mètode del patró de disseny Observer, que rep la notificació
     * del canvi d'estat del rellotge.
     */
    @Override
    public void update(Observable o, Object arg) {
        Rellotge updateRellotge = (Rellotge) o;
        setDataFinal(updateRellotge.getHora());
        setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
        getTascaPare().actualitza();
    }

    public void acceptVisitorDades(final VisitorDades visitor, final Tasca pare, final int id) {
        visitor.visitaDetallatInterval(this, pare, id);
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