package core.ds.projecteds;
import java.io.*;

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Projecte importar(String direccio) {
        Projecte projecte = null;
        try {
            FileInputStream fitxerEntrada = new FileInputStream(direccio);
            ObjectInputStream objecteEntrada = new ObjectInputStream(fitxerEntrada);
            try {
                projecte = (Projecte) objecteEntrada.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
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
