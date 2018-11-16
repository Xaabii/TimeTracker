package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Classe Projecte: És una abstracció d'Activitat, tot projecte pot tenir subprojectes
 * i/o tasques que penjen d'ell (seràn els seus fills).
 * Aquesta classe implementa la estructura Visitor.
 * N'accepta per tal d'imprimir i exportar i importar les dades desades.
 */
public class Projecte extends Activitat {

    private final Collection<Activitat> fills = new ArrayList<>();

    public Projecte(final String nom, final String descripcio, final Projecte projectePare) {
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPare(projectePare);
    }

    @Override
    public Collection<Activitat> getFills() {
        return fills;
    }

    public Projecte crearProjecte(final String nomProjecte, final String descripcio) {
        Projecte nouProjecte = new Projecte(nomProjecte, descripcio, this);
        this.fills.add(nouProjecte);
        return nouProjecte;
    }

    public Tasca crearTasca(final String nomTasca, final String descripcio, final double duracioMinimaInterval) {
        Tasca novaTasca = new Tasca(nomTasca, descripcio, this, duracioMinimaInterval);
        this.fills.add(novaTasca);
        return novaTasca;
    }

    /*
     * Mètode que actualitza la durada del projecte en funció de la durada dels seus
     * fills, així com les dates inicial i final. És una funció recursiva
     * de manera que es recòrre l'arbre cap amunt.
     */
    public void actualitza(final Projecte projecteActual) {
        if (!projecteActual.getNom().equals("arrel")) {
            projecteActual.setDurada(0);
            if (!projecteActual.getFills().isEmpty()) {
                for (Activitat fill : getFills()) {
                    projecteActual.setDurada(fill.getDurada() + projecteActual.getDurada());
                    if (fill.getDataFinal() != null) {
                        if (projecteActual.getDataFinal() != null) {
                            if (fill.getDataFinal().compareTo(projecteActual.getDataFinal()) > 0)
                                projecteActual.setDataFinal(fill.getDataFinal());
                        } else {
                            projecteActual.setDataFinal(fill.getDataFinal());
                        }
                    }
                }
            }
            if (projecteActual.getPare().getNom().equals("arrel")) {
                actualitza(projecteActual.getPare());
            }
        }
    }

    /*
     * Mètode que actualitza les dades del projecte en el moment en què
     * una tasca és iniciada.
     */
    public void iniciTasca(final Tasca tasca) {
        if (this.getDataInicial() == null) {
            this.setDataInicial(tasca.getDataInicial());
        }
        this.setDataFinal(tasca.getDataFinal());
        this.setDurada((getDataFinal().getTime() - getDataInicial().getTime()) / 1000);
    }

    /*
     * Permet l'implementació del Visitor per a ell i els seus fills
     * (recorrent tot l'arbre)
     */
    public void acceptaVisitor(final Visitor visitor) {
        if (!this.getNom().equals("arrel")) {
            actualitza(this);
            visitor.visitaProjecte(this);
        } else if (visitor instanceof Impressor) {
            System.out.println("\n\n");
            System.out.println("Nom         Temps Inici                   "
                    + "   Temps Final                      Durada(hh:mm:ss)");
            System.out.println("----------|--------------------------------|"
                    + "--------------------------------|----------------");
        }
        for (Activitat f : fills) {
            f.acceptaVisitor(visitor);
        }
    }

    public void acceptaVisitorDadesBreu(final VisitorDades visitor, final Date dataInicial, final Date dataFinal) {
        visitor.visitaBreu(this, dataInicial, dataFinal);
    }

    public void acceptaVisitorDadesDetallat(final VisitorDades visitor, final Date dataInicial, final Date dataFinal) {
        visitor.visitaDetallat(this, dataInicial, dataFinal);
    }
}