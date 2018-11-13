package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;

/*Classe Tasca: Forma part del patró composite, per tant
 * agafa tots els atributs i mètodes de la classe abstracte Activitat.
 * Aquesta classe és l'encarregada de crear una tasca, la qual està
 * formada per intervals. La suma d'aquests serà la durada total de la
 * tasca. Tota tasca pertany a una projecte pare.
 * Aquesta classe accepta els visitor per tal d'imprimir i
 * exportar/importar les dades desades.
 */
public class Tasca extends Activitat {

    /*Guarda un número de la versió, perquè si es fa una
     * versió més nova es pugui identificar */
    private static final long serialVersionUID = 1L;


    private final Collection<Interval> intervals = new ArrayList<>();
    private double duradaMinima;
    private Projecte pare;
    private boolean tascaActivada;
    private Interval intervalActual;

    public Tasca(final String nom, final String descripcio, final Projecte pare) {
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(pare);
        this.setDataInicial(null);
        this.setDataFinal(null);
        this.setDurada(0);
        this.setDuradaMinima(1);
        this.setTascaActivada(false);
    }

    public void comencaTasca() {
        if (!isTascaActivada()) {
            Interval nouInterval = new Interval(this);
            setIntervalActual(nouInterval);
            setTascaActivada(true);
            if (this.getDataInicial() == null) setDataInicial(nouInterval.getDataInicial());
            this.setDataFinal(nouInterval.getDataFinal());
            this.getPare().iniciTasca(this);
            intervals.add(nouInterval);
        }
    }

    public void acabaTasca() {
        if (isTascaActivada()) {
            setTascaActivada(false);
            getIntervalActual().finalitzaInterval();
            comprovarDurada(getIntervalActual());
        }
    }

    //Es comprova si la durada minima del interval es compleix, si no, es descarta.
    // Si es compleix s'actualitza la durada i la data final de la tasca.
    private void comprovarDurada(Interval interval) {
        if (interval.getDurada() < getDuradaMinima()) {
            this.intervals.remove(interval);
            Rellotge.getInstance().deleteObserver(interval);
        } else {
            this.setDataFinal(interval.getDataFinal());
            this.setDurada(0);
            for (Interval i : getIntervals()) {
                setDurada(i.getDurada()+getDurada());
            }
            getPare().actualitza(this.getPare());
        }
    }

    public void actualitza() {
        if (!this.getIntervals().isEmpty()) {
            this.setDataFinal(getIntervalActual().getDataFinal());
            this.setDurada(0);
            for (Interval i : getIntervals()) {
                this.setDurada(i.getDurada() + this.getDurada());
            }
            getPare().actualitza(this.getPare());
        }
    }

    @Override
    public ArrayList<Activitat> getFills() {
        return null;
    }

    //Permet l'implementació del Visitor per a ell i els seus fills (recorrent tot l'arbre)
    public void acceptaVisitor(Visitor visitor){
        actualitza();
        visitor.visitaTasca(this);
    }

    private Collection<Interval> getIntervals() {
        return intervals;
    }

    private Interval getIntervalActual() { return intervalActual; }
    private void setIntervalActual(Interval intervalActual) {  this.intervalActual = intervalActual; }

    private double getDuradaMinima() { return duradaMinima; }
    private void setDuradaMinima(double duradaMinima) {
        this.duradaMinima = duradaMinima;
    }

    private boolean isTascaActivada() { return tascaActivada; }
    private void setTascaActivada(boolean tascaActivada) {
        this.tascaActivada = tascaActivada;
    }

    private Projecte getPare() {
        return pare;
    }
    private void setPare(Projecte pare) {
        this.pare = pare;
    }
}