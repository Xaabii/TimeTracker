package core.ds.projecteds;

import java.util.Date;

/*
 * Classe Format: Classe abstracta que engloba els formats del fitxer.
 */
public abstract class Format {
    public abstract void breu(final Date dataInicialInforme, final Date dataFinalInforme);
    public abstract void detallat(final Date dataInicialInforme, final Date dataFinalInforme);
}
