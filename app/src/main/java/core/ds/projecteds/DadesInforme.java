package core.ds.projecteds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Classe DadesInforme: Aquesta classe implementa el patró visitor. S'encarrega de recòrrer
 * l'arbre, i canviar i guardar les dades que s'afegiran a l'informe.
 */
public class DadesInforme extends VisitorDades {
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
        getOrdenaDades().netejaDades();

    }

    public void generaBreu(final Format format) {
        getProjecteSeleccionat().acceptaVisitorDadesBreu(this,
                getDataInicialInforme(), getDataFinalInforme());
        format.breu(getDataInicialInforme(), getDataFinalInforme());
    }

    public void generaDetallat(final Format format) {
        getProjecteSeleccionat().acceptaVisitorDadesDetallat(this,
                getDataInicialInforme(), getDataFinalInforme());
        format.detallat(getDataInicialInforme(), getDataFinalInforme());
    }

    public void visitaDetallat(final Projecte projecte, final Date dataInicial, final Date dataFinal) {
        final int mil = 1000;
        if (projecte != getProjecteSeleccionat()) {
            if (projecte.getPare() == getProjecteSeleccionat()) {
                ArrayList<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add(projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    }  else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0 ) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    }
                    getOrdenaDades().getLlistaProjectesArrel().add(projecteDades);
                }
            } else {
                ArrayList<String> projecteDades = new ArrayList<>();
                if (!(projecte.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (projecte.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                    projecteDades.add(projecte.getPare().getNom());
                    projecteDades.add(projecte.getNom());
                    if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    }  else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0 ) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    }
                    getOrdenaDades().getLlistaSubProjectes().add(projecteDades);
                }
            }
        }
        detallat(projecte, dataInicial, dataFinal);

    }

    public void visitaDetallatTasca(final Tasca tasca) {
        final int mil = 1000;
        ArrayList<String> tascaDades = new ArrayList<>();
        if (tasca.isTascaIniciada()) {
            if (!(tasca.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (tasca.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
                tascaDades.add(tasca.getPare().getNom());
                tascaDades.add(tasca.getNom());
                if (tasca.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && tasca.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                    String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                    tascaDades.add(formatDateInicial);
                    String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(tasca.getDataFinal());
                    tascaDades.add(formatDateFinal);
                    long durada = (tasca.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                    tascaDades.add("" + durada);
                } else if (tasca.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && tasca.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                    String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(tasca.getDataInicial());
                    tascaDades.add(formatDateInicial);
                    String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                    tascaDades.add(formatDateFinal);
                    long durada = (getDataFinalInforme().getTime() - tasca.getDataInicial().getTime()) / mil;
                    tascaDades.add("" + durada);
                }  else if (tasca.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && tasca.getDataFinal().compareTo(this.getDataFinalInforme()) > 0 ) {
                    String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                    tascaDades.add(formatDateInicial);
                    String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                    tascaDades.add(formatDateFinal);
                    long durada = (getDataFinalInforme().getTime() - getDataInicialInforme().getTime()) / mil;
                    tascaDades.add("" + durada);
                } else {
                    String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(tasca.getDataInicial());
                    tascaDades.add(formatDateInicial);
                    String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(tasca.getDataFinal());
                    tascaDades.add(formatDateFinal);
                    long durada = (tasca.getDataFinal().getTime() - tasca.getDataInicial().getTime()) / mil;
                    tascaDades.add("" + durada);
                }
                getOrdenaDades().getLlistaTasques().add(tascaDades);
            }
            int id = 1;
            for (Interval interval : tasca.getIntervals()) {
                interval.acceptVisitorDades(this, tasca, id);
                id++;
            }
        }
    }

    public void visitaDetallatInterval(final Interval interval, final Tasca pare, final int id) {
        ArrayList<String> intervalDades = new ArrayList<>();
        final int mil = 1000;
        if (!(interval.getDataFinal().compareTo(this.getDataInicialInforme()) < 0 || (interval.getDataInicial().compareTo(this.getDataFinalInforme()) > 0))) {
            intervalDades.add(pare.getPare().getNom());
            intervalDades.add(pare.getNom());
            intervalDades.add("" + id);
            if (interval.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && interval.getDataFinal().compareTo(this.getDataFinalInforme()) < 0) {
                String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                intervalDades.add(formatDateInicial);
                String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(interval.getDataFinal());
                intervalDades.add(formatDateFinal);
                long durada = (interval.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                intervalDades.add("" + durada);
            } else if (interval.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && interval.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(interval.getDataInicial());
                intervalDades.add(formatDateInicial);
                String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                intervalDades.add(formatDateFinal);
                long durada = (getDataFinalInforme().getTime() - interval.getDataInicial().getTime()) / mil;
                intervalDades.add("" + durada);
            }  else if (interval.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && interval.getDataFinal().compareTo(this.getDataFinalInforme()) > 0 ) {
                String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                intervalDades.add(formatDateInicial);
                String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                intervalDades.add(formatDateFinal);
                long durada = (getDataFinalInforme().getTime() - getDataInicialInforme().getTime()) / mil;
                intervalDades.add("" + durada);
            } else {
                String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(interval.getDataInicial());
                intervalDades.add(formatDateInicial);
                String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(interval.getDataFinal());
                intervalDades.add(formatDateFinal);
                long durada = (interval.getDataFinal().getTime() - interval.getDataInicial().getTime()) / mil;
                intervalDades.add("" + durada);
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
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) > 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
                    }  else if (projecte.getDataInicial().compareTo(this.getDataInicialInforme()) < 0 && projecte.getDataFinal().compareTo(this.getDataFinalInforme()) > 0 ) {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataInicialInforme());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(getDataFinalInforme());
                        projecteDades.add(formatDateFinal);
                        long durada = (getDataFinalInforme().getTime() - getDataInicialInforme().getTime()) / mil;
                        projecteDades.add("" + durada);
                    } else {
                        String formatDateInicial = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataInicial());
                        projecteDades.add(formatDateInicial);
                        String formatDateFinal = new SimpleDateFormat("dd-MM-yyyy, hh:mm:ss", Locale.US).format(projecte.getDataFinal());
                        projecteDades.add(formatDateFinal);
                        long durada = (projecte.getDataFinal().getTime() - projecte.getDataInicial().getTime()) / mil;
                        projecteDades.add("" + durada);
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