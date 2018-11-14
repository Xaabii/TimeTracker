package core.ds.projecteds;

import java.util.Date;

/**
 * Classe InformeDetallat: Clase que hereta d'Informe, i genera les dades
 * per l'informe detallat.
 */
class InformeDetallat extends Informe {

    public InformeDetallat(final Projecte arrel, final Date dataInicialInforme, final Date dataFinalInforme, final String format) {
        super(arrel, dataInicialInforme, dataFinalInforme);
        getDadesIntervalInforme().generaDetallat();
        if (format == "ascii") {
            Ascii arxiuAscii = new Ascii(dataInicialInforme, dataFinalInforme);
            arxiuAscii.asciiDetallat(dataInicialInforme, dataFinalInforme);
        } else if (format == "html") {
            System.out.println("Informe html");
            //Html arxiuHtml = new Html(dataInicialInforme, dataFinalInforme);
            //arxiuHtml.htmlBreu(dataFinalInforme, dataFinalInforme);
        } else {
            System.out.println("Format erroni");
        }
    }
}
