package core.ds.projecteds;

import java.util.Date;

/**
 * Classe InformeBreu: Clase que hereta de la classe abstracta Informe, i genera les dades
 * per l'informe breu.
 */
class InformeBreu extends Informe {

    public InformeBreu(final Projecte arrel, final Date dataInicialInforme, final Date dataFinalInforme, final Format format) {
        super(arrel, dataInicialInforme, dataFinalInforme);
        getDadesIntervalInforme().generaBreu(format);
    }
}