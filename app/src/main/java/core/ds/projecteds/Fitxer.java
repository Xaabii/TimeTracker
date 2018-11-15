package core.ds.projecteds;
import java.io.*;

/**
 * Classe Fitxer: Classe que implementa el visitor que permet exportar i importar
 * el projecte.
 */
public class Fitxer extends Visitor {
    @Override
    public void visitaTasca(final Tasca t) {

    }

    @Override
    public void visitaProjecte(final Projecte p) {

    }

    public void exportar(final String direccio, final Projecte arrel) {
        try {
            FileOutputStream fitxerSortida = new FileOutputStream(direccio);
            ObjectOutputStream sortida = new ObjectOutputStream(fitxerSortida);
            sortida.writeObject(arrel);
            sortida.close();
            fitxerSortida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param direccio direccio on importar
     * @return projecte
     */
    public Projecte importar(String direccio) {
        Projecte projecte = null;
        try {
            FileInputStream fitxerEntrada = new FileInputStream(direccio);
            ObjectInputStream objecteEntrada = new ObjectInputStream(fitxerEntrada);
            try {
                projecte = (Projecte) objecteEntrada.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            objecteEntrada.close();
            fitxerEntrada.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return projecte;
    }
}
