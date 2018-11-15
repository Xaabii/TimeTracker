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
        String direccio;
        switch (format) {
            case "ascii":
                direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeDetallatAscii.txt";
                Ascii arxiuAscii = new Ascii();
                arxiuAscii.asciiDetallat(dataInicialInforme, dataFinalInforme, direccio);
                break;
            case "html":
                direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeDetallatHtml.html";
                Html arxiuHtml = new Html();
                arxiuHtml.htmlDetallat(dataInicialInforme, dataFinalInforme);
                arxiuHtml.guardarProjecte(direccio);
                break;
            default:
                System.out.println("Format erroni");

        }
    }
}
