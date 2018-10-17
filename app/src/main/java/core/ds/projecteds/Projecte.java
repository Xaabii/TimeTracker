package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


//És una bstracció d'Activitat, tot projecte pot tenir subprojectes i/o tasques que penjen d'ell (seràn els seusfills)
//Aquesta classe implementa la estructura Visitor. N'accepta per tal d'imprimir i exportar i importar les dades desades.
public class Projecte extends Activitat {

    private ArrayList<Activitat> fills;

    public Projecte(String nom, String descripcio, Projecte projectePare) {
        this.setNom(nom);
        this.fills = new ArrayList<>();
        this.setDescripcio(descripcio);
        this.setPare(projectePare);
        this.setDataInicial(null);

    }

    public ArrayList<Activitat> getFills() {
        return fills;
    }

    public Projecte crearProjecte(String nomProjecte, String descripcio) {
        Projecte nouProjecte = new Projecte(nomProjecte,descripcio,this);
        this.fills.add(nouProjecte);
        return nouProjecte;
    }

    public Tasca crearTasca(String nomTasca, String descripcio) {
        Tasca novaTasca = new Tasca(nomTasca, descripcio, this);
        this.fills.add(novaTasca);
        return novaTasca;
    }
    //S'actualitza ladurada del projecte en funció de la durada dels seus fills
    public void actualitza() {
        this.setDurada(0);
        for (Activitat f : fills) {
            this.setDurada(f.getDurada() + this.getDurada());
        }
    }


    public void imprimir() {
        System.out.println("PROJECTE: ");
        System.out.println(this.getNom());
        if (this.getNom() != "arrel") actualitza();
        System.out.println("Data inicial: " + this.getDataInicial());
        System.out.println("Data final: " + this.getDataFinal());
        System.out.println("Durada: " + this.getDurada());

    }

    //Permet l'implementació del Visitor per a ell i els seus fills (recorrent tot l'arbre)
    public void acceptaVisitor(Visitor visitor){
        visitor.visitaProjecte(this);
        for (Activitat f : fills) {
            f.acceptaVisitor(visitor);
        }
    }
}