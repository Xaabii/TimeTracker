package core.ds.projecteds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Classe DadesInforme: Aquesta classe implementa el patró visitor. S'encarrega de recòrrer
 * l'arbre, i canviar i guardar les dades de l'informe.
 */
public class DadesInforme extends VisitorDades {
    /**
     *
     */
    private Projecte projecteSeleccionat;
    private Date dataInicialInforme;
    private Date dataFinalInforme;
    private OrdenaDades ordenaDades;

    public DadesInforme(final Projecte projecteDesitjat, final Date dataInicial,
                        final Date dataFinal) {
        setDataInicialInforme(dataInicial);
        setDataFinalInforme(dataFinal);
        setProjecteSeleccionat(projecteDesitjat);
        OrdenaDades ord = OrdenaDades.getInstance();
        setOrdenaDades(ord);
        System.out.println("LLISTA ARRELS: " + ord.getLlistaProjectesArrel());
        System.out.println("LLISTA ARRELS SET: " + getOrdenaDades().getLlistaProjectesArrel());
        //getOrdenaDades().netejaDades();

    }

    public void generaBreu() {
        getProjecteSeleccionat().acceptaVisitorDadesBreu(this,
                getDataInicialInforme(), getDataFinalInforme());
    }

    public void generaDetallat() {
        getProjecteSeleccionat().acceptaVisitorDadesDetallat(this,
                getDataInicialInforme(), getDataFinalInforme());
    }

    public void visitaDetallat(final Projecte projecte, final Date dataInicial,
                               final Date dataFinal) {
        if (projecte != getProjecteSeleccionat()) {
            final int mil = 1000;
            if (projecte.getPare() == getProjecteSeleccionat()) {
                ArrayList<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add("Nom projecte: " + projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add("Data inicial: " + getDataInicialInforme());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + getDataFinalInforme());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        projecteDades.add("Durada: " + projecte.getDurada());
                    }
                    getOrdenaDades().getLlistaProjectesArrel().add(projecteDades);
                }
            } else {
                Collection<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add("Nom subprojecte: " + projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add("Data inicial: " + getDataInicialInforme());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + getDataFinalInforme());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        projecteDades.add("Durada: " + projecte.getDurada());
                    }
                    getOrdenaDades().getLlistaSubProjectes().add(projecteDades);
                }
            }
        }
        detallat(projecte, dataInicial, dataFinal);
        breu(projecte, dataInicial, dataFinal);
    }

    public void visitaBreu(final Projecte projecte, final Date dataInicial,
                           final Date dataFinal) {
        final int mil = 1000;
        System.out.println("VISITA BREU de Dades informe");
        if (projecte != getProjecteSeleccionat()) {
            if (projecte.getPare() == getProjecteSeleccionat()) {
                Collection<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add("Projecte: " + projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add("Data inicial: " + getDataInicialInforme());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + getDataFinalInforme());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("Durada " + durada);
                    } else {
                        projecteDades.add("Data inicial: " + projecte.getDataInicial());
                        projecteDades.add("Data final: " + projecte.getDataFinal());
                        projecteDades.add("Durada: " + projecte.getDurada());
                    }
                    getOrdenaDades().getLlistaProjectesArrel().add(projecteDades);
                }
            }
        }
        breu(projecte, dataInicial, dataFinal);
    }

    public void breu(final Projecte projecte, final Date dataInicial, final Date dataFinal) {
        for (Activitat fill : projecte.getFills()) {
            if (fill instanceof Projecte) {
                Projecte projecteDesitjat = (Projecte) fill;
                projecteDesitjat.acceptaVisitorDadesBreu(this, dataInicial, dataFinal);
            }
        }
    }

    public void detallat(final Projecte projecte, final Date dataInicial, final Date dataFinal) {
        for (Activitat fill : projecte.getFills()) {
            if (fill instanceof Tasca) {
                Tasca tascaDesitjada = (Tasca) fill;
                tascaDesitjada.acceptaVisitorDades(this, dataInicial, dataFinal);
            }
        }
    }

    public Projecte getProjecteSeleccionat() {
        return projecteSeleccionat;
    }

    public void setProjecteSeleccionat(final Projecte projecteSeleccionat) {
        this.projecteSeleccionat = projecteSeleccionat;
    }

    public Date getDataInicialInforme() {
        return dataInicialInforme;
    }

    public void setDataInicialInforme(final Date dataInicialInforme) {
        this.dataInicialInforme = dataInicialInforme;
    }

    public Date getDataFinalInforme() {
        return dataFinalInforme;
    }

    public void setDataFinalInforme(final Date dataFinalInforme) {
        this.dataFinalInforme = dataFinalInforme;
    }

    public OrdenaDades getOrdenaDades() {
        return ordenaDades;
    }

    public void setOrdenaDades(final OrdenaDades dades) {
        this.ordenaDades = dades;
    }
}