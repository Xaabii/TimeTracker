package core.ds.projecteds;

import java.util.Date;

/**
 * Classe Informe: Classe abstracta de la qual n'hereten InformeBreu i InformeDetallar.
 */
public abstract class Informe {

    private Date dataInicial;
    private Date dataFinal;
    private Date dataGeneracio;
    private Projecte arbre;
    private DadesInforme dadesIntervalInforme;


    public Informe(final Projecte arbreInici, final Date dataInicialInforme, final Date dataFinalInforme) {
        setArbre(arbreInici);
        setDadesIntervalInforme(new DadesInforme(getArbre(), dataInicialInforme, dataFinalInforme));
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(final Date dataInicialInforme) {
        this.dataInicial = dataInicialInforme;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(final Date dataFinalInforme) {
        this.dataFinal = dataFinalInforme;
    }

    public Date getDataGeneracio() {
        return dataGeneracio;
    }

    public void setDataGeneracio(final Date dataGeneracioInforme) {
        this.dataGeneracio = dataGeneracioInforme;
    }

    public Projecte getArbre() {
        return arbre;
    }

    public void setArbre(final Projecte projecteArrel) {
        this.arbre = projecteArrel;
    }

    public DadesInforme getDadesIntervalInforme() {
        return dadesIntervalInforme;
    }

    public void setDadesIntervalInforme(final DadesInforme dadesInterval) {
        this.dadesIntervalInforme = dadesInterval;
    }
}
