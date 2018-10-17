package core.ds.projecteds;

import java.util.Observable;
import java.util.Observer;

public class Impressor extends Visitor {
    @Override
    public void visitaTasca(Tasca t) {
        t.imprimir();
    }

    @Override
    public void visitaProjecte(Projecte p) {
        p.imprimir();
    }
}
