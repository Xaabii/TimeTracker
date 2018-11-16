package core.ds.projecteds;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe Impressor: Classe que implementa els patrons visitor i observer,
 * per cada interval de temps actualitza les dades dels projectes i tasques,
 * i els imprimeix per consola.
 */
public class Impressor extends Visitor implements Observer {
    private Projecte nodeSeleccionat;

    @Override
    public void visitaTasca(final Tasca t) {
        if (t.getDataInicial() != null) {
            System.out.println(t.getNom() + "      " + t.getDataInicial()
                    + "    " + t.getDataFinal() + "    " + t.getDurada());
        } else {
            System.out.println(t.getNom());
        }
    }

    @Override
    public void visitaProjecte(final Projecte p) {
        if (p.getDataInicial() != null) {
            System.out.println(p.getNom() + "   " + p.getDataInicial()
                    + "    " + p.getDataFinal() + "    " + p.getDurada());
        } else {
            System.out.println(p.getNom());
        }
    }

    public Impressor(final Projecte projecte) {
        Rellotge.getInstance().addObserver(this);
        setNodeSeleccionat(projecte);
    }

    @Override
    public void update(final Observable o, final Object arg) {
        getNodeSeleccionat().acceptaVisitor(this);
    }

    private Projecte getNodeSeleccionat() {
        return nodeSeleccionat;
    }

    private void setNodeSeleccionat(final Projecte node) {
        this.nodeSeleccionat = node;
    }
}
