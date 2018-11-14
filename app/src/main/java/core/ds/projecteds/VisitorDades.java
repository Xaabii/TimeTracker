package core.ds.projecteds;

import java.util.Date;

/**
 * Classe VisitorDades: Classe abstracta que implementa el visitor per l'informe.
 */
abstract class VisitorDades {
    public abstract void visitaBreu(Projecte projecte, Date dataInicial, Date dataFinal);
    public abstract void visitaDetallat(Projecte projecte, Date dataInicial, Date dataFinal);
}