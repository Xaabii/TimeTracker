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
     *
     */
    private String nom;
    //private String descripcio;
    private double durada;
    private Date dataInicial;
    private Date dataFinal;
    private Projecte pare;

    /**
     * Getter de la propietat <tt>fills</tt>.
     * @return la variable fills
     */
    public abstract Collection<Activitat> getFills();

    /**
     * Mètode del patro Visitor.
     * @param v visitor
     */
    public abstract void acceptaVisitor(Visitor v);

    /**
     * Getter de la propietat <tt>Nom</tt>.
     * @return la variable nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de la propietat <tt>Nom</tt>.
     * @param nomActivitat ha afegir
     */
    public void setNom(final String nomActivitat) {
        this.nom = nomActivitat;
    }

    /**
     * Getter de la propietat <tt>Pare</tt>.
     * @return la variable pare.
     */
    public Projecte getPare() {
        return pare;
    }

    /**
     * Setter de la propietat <tt>Pare</tt>.
     * @param pareActivitat ha afegir
     */
    public void setPare(final Projecte pareActivitat) {
        this.pare = pareActivitat;
    }

    /**
     * Setter de la propietat <tt>descripcio</tt>.
     * @param descripcioActivitat decripcio de l'activitat
     */
    /*public void setDescripcio(final String descripcioActivitat) {
        this.descripcio = descripcioActivitat;
    }*/

    /**
     * Getter de la propietat <tt>durada</tt>.
     * @return la variable durada
     */
    public double getDurada() {
        return durada;
    }

    /**
     * Setter de la propietat <tt>duradaActivitat</tt>.
     * @param duradaActivitat durada de l'activitat
     */
    public void setDurada(final double duradaActivitat) {
        this.durada = duradaActivitat;
    }

    /**
     * Getter de la propietat <tt>dataInicial</tt>.
     * @return la variable dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * Setter de la propietat <tt>dataInicial</tt>.
     * @param dataInicialActivitat data inicial activitat
     */
    public void setDataInicial(final Date dataInicialActivitat) {
        this.dataInicial = dataInicialActivitat;
    }

    /**
     * Getter de la propietat <tt>dataFinal</tt>.
     * @return la variable dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * Setter de la propietat <tt>dataFinal</tt>.
     * @param dataFinalActivitat data final activitat
     */
    public void setDataFinal(final Date dataFinalActivitat) {
        this.dataFinal = dataFinalActivitat;
    }


}