package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Date;

public class Tasca extends Activitat {

    private ArrayList<Interval> intervals;
    private double duradaTasca;
    private double duradaMinima;
    private Projecte pare;
    private boolean tascaActivada;

    //Falta definir el tipus
    public Tasca(String nom, String descripcio, Projecte pare) {
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(pare);
        this.setDataInicial(null);
        this.duradaTasca = 0;
        this.intervals = new ArrayList<>();
        this.setTascaActivada(false);

    }

    public void començaTasca() {
        if (!isTascaActivada()) {
            Interval nouInterval = new Interval(this);
            if (this.getDataInicial() == null) this.setDataInicial(nouInterval.getDataInicial());
            intervals.add(nouInterval);
            setTascaActivada(true);
        }
    }

    public void acabaTasca() {
        if (isTascaActivada()) {
            Interval intervalActual = this.intervals.get(this.intervals.size()-1);
            intervalActual.finalitzaInterval();
            setTascaActivada(false);
            comprovarDurada(intervalActual);
        }
    }

    public void comprovarDurada(Interval interval) {
        if (interval.getDurada() < getDuradaMinima()) {
            this.intervals.remove(interval);
        } else {
            this.duradaTasca += interval.getDurada();
        }
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<Interval> intervals) {
        this.intervals = intervals;
    }

    public double getDuradaTasca() {
        return duradaTasca;
    }

    public void setDuradaTasca(double duradaTasca) {
        this.duradaTasca = duradaTasca;
    }

    public double getDuradaMinima() {
        return duradaMinima;
    }

    public void setDuradaMinima(double duradaMinima) {
        this.duradaMinima = duradaMinima;
    }

    public boolean isTascaActivada() {
        return tascaActivada;
    }

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