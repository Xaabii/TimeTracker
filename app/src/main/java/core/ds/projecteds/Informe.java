package core.ds.projecteds;

import java.util.Date;

/**
 * Classe Informe: Classe abstracta de la qual n'hereten InformeBreu i InformeDetallat.
 */
public abstract class Informe {
    private Projecte arbre;
    private DadesInforme dadesIntervalInforme;


    public Informe(final Projecte arbreInici, final Date dataInicialInforme, final Date dataFinalInforme) {
        setArbre(arbreInici);
        setDadesIntervalInforme(new DadesInforme(getArbre(), dataInicialInforme, dataFinalInforme));
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
