package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**Classe Tasca: Forma part del patró composite, per tant
 * agafa tots els atributs i mètodes de la classe abstracte Activitat.
 * Aquesta classe és l'encarregada de crear una tasca, la qual està
 * formada per intervals. La suma d'aquests serà la durada total de la
 * tasca. Tota tasca pertany a una projecte pare.
 * Aquesta classe accepta els visitor per tal d'imprimir i
 * exportar/importar les dades desades.
 */
public class Tasca extends Activitat {
    private final Collection<Interval> intervals = new ArrayList<>();
    private double duradaMinima;
    private Projecte pare;
    private boolean tascaActivada;
    private Interval intervalActual;
    private boolean tascaIniciada;

    public Tasca(final String nom, final String descripcio, final Projecte paref, final double duradaMinima) {
        //Precondicions
        assert(!nom.equals(null));
        assert(!descripcio.equals(null));
        assert(!paref.equals(null));
        assert(duradaMinima >= 0);

        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(paref);
        this.setDataInicial(null);
        this.setDataFinal(null);
        this.setDurada(0);
        this.setDuradaMinima(duradaMinima);
        this.setTascaActivada(false);
        this.setTascaIniciada(false);
        comprovaInvariant();
    }

    public void comencaTasca() {
        //Precondicions
        assert(!isTascaActivada());
        if (!isTascaActivada()) {
            Interval nouInterval = new Interval(this);
            setIntervalActual(nouInterval);
            setTascaActivada(true);
            setTascaIniciada(true);
            if (this.getDataInicial() == null) setDataInicial(nouInterval.getDataInicial());
            this.setDataFinal(nouInterval.getDataFinal());
            this.getPare().iniciTasca(this);
            intervals.add(nouInterval);
        }
        //Postcondicions
        assert(isTascaActivada());
        assert(isTascaIniciada());
        assert(!getIntervals().isEmpty());
    }

    public void acabaTasca() {
        //Precondicions
        assert(isTascaIniciada());
        assert(isTascaActivada());
        if (isTascaActivada()) {
            setTascaActivada(false);
            getIntervalActual().finalitzaInterval();
            comprovarDurada(getIntervalActual());
        }
        //Postcondicions
        assert(!isTascaActivada());
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
    public void acceptaVisitor(final Visitor visitor) {
        actualitza();
        visitor.visitaTasca(this);
    }


    public void acceptaVisitorDades(final VisitorDades visitor, final Date dataInicial, final Date dataFinal) {
        visitor.visitaDetallatTasca(this, dataInicial, dataFinal);
    }

    public void comprovaInvariant() {
        assert(!getNom().equals(null));
        assert(!getPare().equals(null));
        assert(!getDescripcio().equals(null));
        assert(!isTascaActivada() || isTascaActivada());
        if(!getIntervals().isEmpty()) {
            assert(getDataInicial().compareTo(getDataFinal()) <= getDuradaMinima());
            assert(getDurada() >= getDuradaMinima());
            assert(isTascaIniciada());
        } else {
            assert(getDataInicial().equals(null));
            assert(getDataFinal().equals(null));
            assert(getDurada() == 0);
            assert(!isTascaIniciada());
        }
    }

    public Collection<Interval> getIntervals() {
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

    public Projecte getPare() {
        return pare;
    }
    public void setPare(final Projecte pare) {
        this.pare = pare;
    }

    public boolean isTascaIniciada() {
        return tascaIniciada;
    }

    public void setTascaIniciada(boolean tascaIniciada) {
        this.tascaIniciada = tascaIniciada;
    }
}