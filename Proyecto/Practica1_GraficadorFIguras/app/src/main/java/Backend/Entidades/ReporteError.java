package Backend.Entidades;

import java.io.Serializable;

public class ReporteError extends ReporteOcurrencias implements Serializable {
    private final String tipoError;
    private final String descripcion;

    public ReporteError(String elLexema, int laLinea, int laColumna, String elTipoDeError, String laDescripcion){
        super(elLexema, laLinea, laColumna);

        tipoError = elTipoDeError;
        descripcion = laDescripcion;
    }

    public String darTipoError(){
        return tipoError;
    }

    public String darDescripcion(){
        return descripcion;
    }
}
