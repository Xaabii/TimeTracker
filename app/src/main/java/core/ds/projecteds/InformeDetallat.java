package core.ds.projecteds;

import java.util.Date;

/**
 * Classe InformeDetallat: Classe que hereta d'Informe, i genera les dades
 * per l'informe detallat.
 */
class InformeDetallat extends Informe {

    public InformeDetallat(final Projecte arrel, final Date dataInicialInforme, final Date dataFinalInforme, final Format format) {
        super(arrel, dataInicialInforme, dataFinalInforme);
        getDadesIntervalInforme().generaDetallat(format);
    }
}
