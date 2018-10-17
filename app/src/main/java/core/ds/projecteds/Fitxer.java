package core.ds.projecteds;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Fitxer extends Visitor {
    @Override
    public void visitaTasca(Tasca t) {

    }

    @Override
    public void visitaProjecte(Projecte p) {

    }

    public void exportar(String direccio, Projecte arrel) {
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
        try{
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
        }catch(IOException i){
            i.printStackTrace();
        }
        return projecte;
    }
}
