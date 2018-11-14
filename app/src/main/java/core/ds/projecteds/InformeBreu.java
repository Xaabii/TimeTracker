package core.ds.projecteds;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Classe InformeBreu: Clase que hereta d'Informe, i genera les dades
 * per l'informe breu.
 */
class InformeBreu extends Informe {

    public InformeBreu(final Projecte arrel, final Date dataInicialInforme, final Date dataFinalInforme, final String format) {
        super(arrel, dataInicialInforme, dataFinalInforme);
        getDadesIntervalInforme().generaBreu();
        if (format == "ascii") {
            Ascii arxiuAscii = new Ascii(dataInicialInforme, dataFinalInforme);
            arxiuAscii.asciiBreu(dataInicialInforme, dataFinalInforme);
        } else if (format == "html") {
            System.out.println("Informe html");
            //Html arxiuHtml = new Html(dataInicialInforme, dataFinalInforme);
            //arxiuHtml.htmlBreu(dataFinalInforme, dataFinalInforme);
        } else {
            System.out.println("Format erroni");
        }
    }

}
