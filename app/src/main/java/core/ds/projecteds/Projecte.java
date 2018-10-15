package core.ds.projecteds;

import java.util.ArrayList;

public class Projecte extends Activitat {

    private ArrayList<Activitat> fills;


    public Projecte(String nom, String descripcio, Projecte projectePare) {
        this.setNom(nom);
        this.fills = new ArrayList<>();
        this.setDescripcio(descripcio);
        this.setPare(projectePare);
        this.setDataInicial(null);
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

    public void imprimir() {
        System.out.println("PROJECTE: ");
        System.out.println(this.getNom());
        System.out.println("Data inicial: " + this.getDataInicial());
        System.out.println("Data final: " + this.getDataFinal());
        System.out.println("Durada: " + this.getDurada());
        for (Activitat f : fills) {
            f.imprimir();
        }
    }
}