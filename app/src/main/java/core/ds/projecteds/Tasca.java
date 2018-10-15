package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Date;

public class Tasca extends Activitat {

    private ArrayList<Interval> intervals;
    private double duradaMinima;
    private Projecte pare;
    private boolean tascaActivada;

    //Falta definir el tipus
    public Tasca(String nom, String descripcio, Projecte pare) {
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(pare);
        this.setDataInicial(null);
        this.setDurada(0);
        this.intervals = new ArrayList<>();
        this.setTascaActivada(false);

    }

    public void començaTasca() {
        if (!isTascaActivada()) {
            Interval nouInterval = new Interval(this);
            if (this.getDataInicial() == null) this.setDataInicial(nouInterval.getDataInicial());
            if (this.getPare().getDataInicial() == null) this.getPare().setDataInicial(this.getDataInicial());
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
            this.setDurada(this.getDurada()+interval.getDurada());
            this.setDataFinal(interval.getDataFinal());
            this.getPare().setDurada(this.getPare().getDurada()+this.getDurada());
            if (this.getPare().getDataInicial() == null) this.getPare().setDataInicial(this.getDataInicial());
            if (this.getPare().getDataFinal() == null) this.getPare().setDataFinal(this.getDataFinal());
            //imprimir();
        }
    }

    public void imprimir() {
        System.out.println("TASCA: ");
        System.out.println(this.getNom());
        System.out.println("Data inicial: " + this.getDataInicial());
        System.out.println("Data final: " + this.getDataFinal());
        System.out.println("Durada: " + this.getDurada());
        for (Interval i : intervals) {
            i.impresioInterval();
        }
    }

    public ArrayList<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<Interval> intervals) {
        this.intervals = intervals;
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