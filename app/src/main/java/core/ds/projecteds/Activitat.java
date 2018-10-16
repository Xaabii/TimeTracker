package core.ds.projecteds;
import java.util.Date;

public abstract class Activitat {
    protected String nom;
    protected String descripcio;
    protected double durada;
    protected Date dataInicial;
    protected Date dataFinal;
    protected Projecte pare;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Projecte getPare() {
        return pare;
    }

    public void setPare(Projecte pare) {
        this.pare = pare;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getDurada() {
        return durada;
    }

    public void setDurada(double durada) {
        this.durada = durada;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public abstract void imprimir();
    public abstract void actualitza();
}