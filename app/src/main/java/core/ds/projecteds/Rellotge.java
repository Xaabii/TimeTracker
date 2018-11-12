package core.ds.projecteds;

import java.util.Observable;
import java.util.Date;

//Classe que implementa el patró Observer, que simula un rellotge virtual.
public class Rellotge extends Observable {
    private Date hora;
    private static Rellotge instancia = null;

    private Rellotge() {
        hora = new Date();
    }


    public static Rellotge getInstance() {
        if (instancia == null) {
            instancia = new Rellotge();
        }
        return instancia;
    }

    public void notificarObservadors() {
        setHora(new Date());
        setChanged();
        notifyObservers();
    }

    public Date getHora() {
        return hora;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }

}