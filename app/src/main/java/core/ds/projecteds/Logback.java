package core.ds.projecteds;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Classe Logback: És l'encarregada de generar comentaris i guardar-los
 * en un document extern. Tenim tres tipus, waning, error i info. Per a cada
 * un d'aquests, indiquem quin és el fitxer de sortida on es guardarà la informació
 * i el tipus de missatge que s'ha de guardar.
 */
public class Logback {
    private static Logback logback;

    public static Logback getInstance() {
        if (logback == null) {
            logback = new Logback();
        }
        return logback;
    }

    public void enregistrarWarning(final String missatgeLogback) {
        Logger logger = Logger.getLogger("Warning Log");
        FileHandler fileHandler;
        logger.setUseParentHandlers(false);
        try {
            fileHandler = new FileHandler("C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/WarningLogFile.log");
            logger.addHandler(fileHandler);
            logger.warning(missatgeLogback);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Com que no s'ha trobat el tipus error, s'ha
     * utilitzat el nivell de severe, ja que són bastant semblants.
     */
    public void enregistrarError(final String missatgeLogback) {
        Logger logger = Logger.getLogger("Error Log");
        FileHandler fileHandler;
        logger.setUseParentHandlers(false);
        try {
            fileHandler = new FileHandler("C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/ErrorLogFile.log");
            logger.addHandler(fileHandler);
            logger.severe(missatgeLogback);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void enregistrarInfo(final String missatgeLogback) {
        Logger logger = Logger.getLogger("Info Log");
        FileHandler fileHandler;
        logger.setUseParentHandlers(false);
        try {
            fileHandler = new FileHandler("C:/Users/Anna/Documents/Cole/5e carrera/Disseny del software/Practiques/InfoLogFile.log");
            logger.addHandler(fileHandler);
            logger.info(missatgeLogback);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
