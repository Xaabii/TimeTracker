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
        getOrdenaDades().netejaDades();

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
                    projecteDades.add(projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add(getDataInicialInforme().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(getDataFinalInforme().toString());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        projecteDades.add("" + projecte.getDurada());
                    }
                    getOrdenaDades().getLlistaProjectesArrel().add(projecteDades);
                }
            } else {
                ArrayList<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add(projecte.getPare().getNom());
                    projecteDades.add(projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add(getDataInicialInforme().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(getDataFinalInforme().toString());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        projecteDades.add("" + projecte.getDurada());
                    }
                    getOrdenaDades().getLlistaSubProjectes().add(projecteDades);
                }
            }
        }
        detallat(projecte, dataInicial, dataFinal);

    }

    public void visitaDetallatTasca(final Tasca tasca, final Date dataInicial, final Date dataFinal) {
        final int mil = 1000;
        ArrayList<String> tascaDades = new ArrayList<>();
        if (tasca.isTascaIniciada()) {
            if (!(tasca.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (tasca.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                tascaDades.add(tasca.getPare().getNom());
                tascaDades.add(tasca.getNom());
                if (tasca.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && tasca.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                    tascaDades.add(getDataInicialInforme().toString());
                    tascaDades.add(tasca.getDataFinal().toString());
                    double durada = (tasca.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                    tascaDades.add("" + durada);
                } else if (tasca.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && tasca.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                    tascaDades.add(tasca.getDataInicial().toString());
                    tascaDades.add(getDataFinalInforme().toString());
                    double durada = (getDataFinalInforme().getTime() - tasca.getDataInicial().getTime()) / mil;
                    tascaDades.add("" + durada);
                } else {
                    tascaDades.add(tasca.getDataInicial().toString());
                    tascaDades.add(tasca.getDataFinal().toString());
                    tascaDades.add("" + tasca.getDurada());
                }
                getOrdenaDades().getLlistaTasques().add(tascaDades);
            }
            int id = 1;
            for (Interval interval : tasca.getIntervals()) {
                interval.acceptVisitorDades(this, dataInicial, dataFinal, tasca, id);
                id++;
            }
        }
    }

    public void visitaDetallatInterval(final Interval interval, final Date dataInicial, final Date dataFinal, final Tasca pare, final int id) {
        ArrayList<String> intervalDades = new ArrayList<>();
        final int mil = 1000;
        if (!(interval.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (interval.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
            intervalDades.add(pare.getPare().getNom());
            intervalDades.add(pare.getNom());
            intervalDades.add("" + id);
            if (interval.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && interval.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                intervalDades.add(getDataInicialInforme().toString());
                intervalDades.add(interval.getDataFinal().toString());
                double durada = (interval.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                intervalDades.add("" + durada);
            } else if (interval.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && interval.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                intervalDades.add(interval.getDataInicial().toString());
                intervalDades.add(getDataFinalInforme().toString());
                double durada = (getDataFinalInforme().getTime() - interval.getDataInicial().getTime()) / mil;
                intervalDades.add("" + durada);
            } else {
                intervalDades.add(interval.getDataInicial().toString());
                intervalDades.add(interval.getDataFinal().toString());
                intervalDades.add("" + interval.getDurada());
            }
            getOrdenaDades().getLlistaIntervals().add(intervalDades);
        }
    }

    public void visitaBreu(final Projecte projecte, final Date dataInicial,
                           final Date dataFinal) {
        final int mil = 1000;
        if (projecte != getProjecteSeleccionat()) {
            if (projecte.getPare() == getProjecteSeleccionat()) {
                ArrayList<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add(projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        projecteDades.add(getDataInicialInforme().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        double durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(getDataFinalInforme().toString());
                        double durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        projecteDades.add(projecte.getDataInicial().toString());
                        projecteDades.add(projecte.getDataFinal().toString());
                        projecteDades.add("" + projecte.getDurada());
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
            } else if (fill instanceof Projecte) {
                Projecte projecteDesitjat = (Projecte) fill;
                projecteDesitjat.acceptaVisitorDadesDetallat(this, dataInicial, dataFinal);
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