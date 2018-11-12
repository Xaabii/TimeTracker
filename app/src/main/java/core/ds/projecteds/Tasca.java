package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;


//És una abstracció d'Activitat, tota tasca té intervals (els comença i els acaba)
//Aquesta classe implementa la estructura Visitor. N'accepta per tal d'imprimir i exportar i importar les dades desades.
public class Tasca extends Activitat {

    private static final long serialVersionUID = 1L;

    private Collection<Interval> intervals = new ArrayList<>();
    private double duradaMinima;
    private Projecte pare;
    private boolean tascaActivada;
    Interval intervalActual;

    public Tasca(String nom, String descripcio, Projecte pare) {
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(pare);
        this.setDataInicial(null);
        this.setDataFinal(null);
        this.setDurada(0);
        this.setDuradaMinima(1);
        this.setTascaActivada(false);
    }

    public void començaTasca() {
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

    //Es comrpova si la durada minima del interval es compleix, si no, es descarta. Si es compleix s'actualitza la durada i la data final de la tasca.
    public void comprovarDurada(Interval interval) {
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

    public Collection<Interval> getIntervals() {
        return intervals;
    }

    public Interval getIntervalActual() { return intervalActual; }
    public void setIntervalActual(Interval intervalActual) {  this.intervalActual = intervalActual; }

    public double getDuradaMinima() { return duradaMinima; }
    public void setDuradaMinima(double duradaMinima) {
        this.duradaMinima = duradaMinima;
    }

    public boolean isTascaActivada() { return tascaActivada; }
    public void setTascaActivada(boolean tascaActivada) {
        this.tascaActivada = tascaActivada;
    }

    public Projecte getPare() {
        return pare;
    }
    public void setPare(Projecte pare) {
        this.pare = pare;
    }
}