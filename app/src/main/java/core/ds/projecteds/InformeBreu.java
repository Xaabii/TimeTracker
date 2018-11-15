package core.ds.projecteds;

import java.util.Date;

/**
 * Classe InformeBreu: Clase que hereta d'Informe, i genera les dades
 * per l'informe breu.
 */
class InformeBreu extends Informe {

    public InformeBreu(final Projecte arrel, final Date dataInicialInforme, final Date dataFinalInforme, final String format) {
        super(arrel, dataInicialInforme, dataFinalInforme);
        getDadesIntervalInforme().generaBreu();
        String direccio;
        switch (format) {
            case "ascii":
                direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeBreuAscii.txt";
                Ascii arxiuAscii = new Ascii();
                arxiuAscii.asciiBreu(dataInicialInforme, dataFinalInforme, direccio);
                break;
            case "html":
                direccio = "C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InformeBreuHtml.html";
                Html arxiuHtml = new Html();
                arxiuHtml.htmlBreu(dataInicialInforme, dataFinalInforme);
                arxiuHtml.guardarProjecte(direccio);
                break;
            default:
                System.out.println("Format erroni");

        }
    }

}
