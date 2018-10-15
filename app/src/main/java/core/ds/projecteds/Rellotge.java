package core.ds.projecteds;

import java.util.Observable;
import java.util.Date;

public class Rellotge extends Observable {
    private Date hora;
    private static Rellotge instancia = null;

    private Rellotge() {
        hora = new Date();
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public static Rellotge getInstance() {
        if (instancia == null) return new Rellotge();
        return instancia;
    }

    public void tick() {
        setHora(new Date());
        setChanged();
        notifyObservers(this);
    }
}