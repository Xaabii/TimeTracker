package core.ds.projecteds;

/**
 * Classe Visitor: Classe abstracta que implementa el patró visitor.
 */
abstract class Visitor {
    public abstract void visitaTasca(Tasca t);
    public abstract void visitaProjecte(Projecte p);
}
