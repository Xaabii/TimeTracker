package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;

//És una abstracció d'Activitat, tot projecte pot tenir subprojectes
// i/o tasques que penjen d'ell (seràn els seusfills)
// Aquesta classe implementa la estructura Visitor.
//N'accepta per tal d'imprimir i exportar i importar les dades desades.
public class Projecte extends Activitat {

    private static final long serialVersionUID = 1L;
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

    public Tasca crearTasca(final String nomTasca, final String descripcio) {
        Tasca novaTasca = new Tasca(nomTasca, descripcio, this);
        this.fills.add(novaTasca);
        return novaTasca;
    }


    public void actualitza(final Projecte projecteActual) {
        if (projecteActual.getNom().equals("arrel")) {
            projecteActual.setDurada(0);
            if (!projecteActual.getFills().isEmpty()) {
                for (Activitat fill : getFills()) {
                    projecteActual.setDurada(fill.getDurada() + projecteActual.getDurada());
                    if (fill.getDataFinal() != null) {
                        if (projecteActual.getDataFinal() != null) {
                            if (fill.getDataFinal().compareTo(projecteActual.getDataFinal()) > 0) {
                                projecteActual.setDataFinal(fill.getDataFinal());
                            }
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

    public void iniciTasca(final Tasca tasca) {
        if (this.getDataInicial() == null) {
            this.setDataInicial(tasca.getDataInicial());
        }
        this.setDataFinal(tasca.getDataFinal());
    }

    //Permet l'implementació del Visitor per a ell i els seus fills
    // (recorrent tot l'arbre)
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
}