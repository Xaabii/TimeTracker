package core.ds.projecteds;

import java.util.Observable;
import java.util.Observer;

public class Impressor implements Observer {
    private Object node;

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Impressor(Object nodeSeleccionat) {
        Rellotge rellotge = Rellotge.getInstance();
        rellotge.addObserver(this);
        setNode(nodeSeleccionat);
    }

    public void imprimir() {
        if (getNode() instanceof  Projecte) {
            ((Projecte) getNode()).imprimir();
        } else if (getNode() instanceof Tasca) {
            ((Tasca) getNode()).imprimir();
        } else if (getNode() instanceof Interval) {
            ((Interval) getNode()).impresioInterval();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        imprimir();
    }
}
