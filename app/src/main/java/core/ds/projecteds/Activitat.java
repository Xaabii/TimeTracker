package core.ds.projecteds;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Classe Activitat: Classe abstracta de la qual n'herenten projecte i tasca.
 */
public abstract class Activitat implements Serializable {

    /*Guarda un número de la versió,
    perquè si es fa una versió més nova es pugui identificar*/
    private static final long serialVersionUID = 1L;

    /**
     * El nom és únic, per tant:
     * no es poden repetir noms dins d'un mateix projecte
     * no poden haver dos projectes amb el mateix nom.
     * @uml.property name = "Nom"
     */
    private String nom;

    /**
     * @uml.property name="descripcio"
     */
    private String descripcio;

    /**
     * @uml.property name="durada"
     */
    private double durada;

    /**
     * @uml.property name="dataInicial"
     */
    private Date dataInicial;

    /**
     * @uml.property name="dataFinal"
     */
    private Date dataFinal;

    /**
     * @uml.property name="pare"
     */
    private Projecte pare;

    /**
     * Getter de la propietat <tt>fills</tt>.
     * @return la variable fills
     * @uml.property name="fills"
     */
    public abstract Collection<Activitat> getFills();

    public abstract void acceptaVisitor(Visitor v);

    /**
     * Getter de la propietat <tt>Nom</tt>.
     * @return la variable nom.
     * @uml.property name="Nom"
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de la propietat <tt>Nom</tt>.
     * @param nomActivitat ha afegir
     * @um.property name="Nom"
     */
    public void setNom(final String nomActivitat) {
        this.nom = nomActivitat;
    }

    /**
     * Getter de la propietat <tt>Pare</tt>.
     * @return la variable pare.
     * @uml.property name="pare"
     */
    public Projecte getPare() {
        return pare;
    }

    /**
     * Setter de la propietat <tt>Pare</tt>.
     * @param pareActivitat ha afegir
     * @uml.property name="pare"
     */
    public void setPare(final Projecte pareActivitat) {
        this.pare = pareActivitat;
    }

    /**
     * Setter de la propietat <tt>descripcio</tt>.
     * @param descripcioActivitat
     * @uml.property name="descripcio"
     */
    public void setDescripcio(final String descripcioActivitat) {
        this.descripcio = descripcioActivitat;
    }

    /**
     * Getter de la propietat <tt>durada</tt>.
     * @return la variable durada
     * @uml.property name"durada"
     */
    public double getDurada() {
        return durada;
    }

    /**
     * Setter de la propietat <tt>durada</tt>.
     * @param duradaActivitat
     * @uml.property name="durada"
     */
    public void setDurada(final double duradaActivitat) {
        this.durada = duradaActivitat;
    }

    /**
     * Getter de la propietat <tt>dataInicial</tt>.
     * @return la variable dataInicial
     * @uml.property name="dataInicial"
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * Setter de la propietat <tt>dataInicial</tt>.
     * @param dataInicialACtivitat
     * @uml.property name="dataInicial"
     */
    public void setDataInicial(final Date dataInicialACtivitat) {
        this.dataInicial = dataInicialACtivitat;
    }

    /**
     * Getter de la propietat <tt>dataFinal</tt>.
     * @return la variable dataFinal
     * @uml.property name="dataFinal"
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * Setter de la propietat <tt>dataFinal</tt>.
     * @param dataFinalActivitat
     * @uml.property name="dataFinal"
     */
    public void setDataFinal(final Date dataFinalActivitat) {
        this.dataFinal = dataFinalActivitat;
    }


}