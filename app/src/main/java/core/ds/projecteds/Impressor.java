package core.ds.projecteds;

import java.util.Observable;
import java.util.Observer;

public class Impressor extends Visitor implements Observer {
    private Projecte nodeSeleccionat;

    @Override
    public void visitaTasca(Tasca t) {
        if (t.getDataInicial() != null) {
            System.out.println(t.getNom() + "      " + t.getDataInicial()
                    + "    " + t.getDataFinal() + "    " + t.getDurada());
        } else {
            System.out.println(t.getNom());
        }
    }

    @Override
    public void visitaProjecte(Projecte p) {
        if (p.getDataInicial() != null) {
            System.out.println(p.getNom() + "   " + p.getDataInicial()
                    + "    " + p.getDataFinal() + "    " + p.getDurada());
        } else {
            System.out.println(p.getNom());
        }
    }

    public Impressor(Projecte projecte) {
        Rellotge.getInstance().addObserver(this);
        setNodeSeleccionat(projecte);
    }

    @Override
    public void update(Observable o, Object arg) {
        getNodeSeleccionat().acceptaVisitor(this);
    }

    private Projecte getNodeSeleccionat() {
        return nodeSeleccionat;
    }

    private void setNodeSeleccionat(Projecte nodeSeleccionat) {
        this.nodeSeleccionat = nodeSeleccionat;
    }
}
