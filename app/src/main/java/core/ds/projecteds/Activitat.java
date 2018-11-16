package core.ds.projecteds;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Classe Activitat: Forma part del patró de disseny composite.
 * És l'encarregada de definir tots els atributs que compartiran
 * projecte i tasca.
 */
public abstract class Activitat implements Serializable {

    private String nom;
    private String descripcio;
    private double durada;
    private Date dataInicial;
    private Date dataFinal;
    private Projecte pare;

    public void invariant() {
        assert(!getNom().equals(null));
        assert(!getPare().equals(null));
        assert(!getDescripcio().equals(null));
        assert(durada >= 0);
    }

    public abstract Collection<Activitat> getFills();

    public abstract void acceptaVisitor(Visitor v);

    public String getNom() {
        return nom;
    }

    public void setNom(final String nomActivitat) {
        this.nom = nomActivitat;
    }

    public Projecte getPare() {
        return pare;
    }

    public void setPare(final Projecte pareActivitat) {
        this.pare = pareActivitat;
    }

    public double getDurada() {
        return durada;
    }

    public void setDurada(final double duradaActivitat) {
        this.durada = duradaActivitat;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(final Date dataInicialActivitat) {
        this.dataInicial = dataInicialActivitat;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(final Date dataFinalActivitat) {
        this.dataFinal = dataFinalActivitat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}