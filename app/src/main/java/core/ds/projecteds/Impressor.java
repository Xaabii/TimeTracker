package core.ds.projecteds;

import java.util.Observable;
import java.util.Observer;

public class Impressor extends Visitor implements Observer {
    private Projecte nodeSeleccionat;

    @Override
    public void visitaTasca(Tasca t) {
        t.imprimir();
    }

    @Override
    public void visitaProjecte(Projecte p) {
        p.imprimir();
    }

    public Impressor(Projecte projecte) {
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.addObserver(this);
        setNodeSeleccionat(projecte);
    }

    @Override
    public void update(Observable o, Object arg) {
        getNodeSeleccionat().acceptaVisitor(this);
    }

    public Projecte getNodeSeleccionat() {
        return nodeSeleccionat;
    }

    public void setNodeSeleccionat(Projecte nodeSeleccionat) {
        this.nodeSeleccionat = nodeSeleccionat;
    }
}
