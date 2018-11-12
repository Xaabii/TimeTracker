package core.ds.projecteds;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

//És una classe abstracta de la qual hereten projecte i tasca.
public abstract class Activitat implements Serializable {
    protected String nom;
    protected String descripcio;
    protected double durada;
    protected Date dataInicial;
    protected Date dataFinal;
    protected Projecte pare;

    private static final long serialVersionUID = 1L;
    public abstract Collection<Activitat> getFills();

    public abstract void acceptaVisitor(Visitor v);

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) { this.nom = nom; }

    public Projecte getPare() {
        return pare;
    }
    public void setPare(Projecte pare) {
        this.pare = pare;
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


}