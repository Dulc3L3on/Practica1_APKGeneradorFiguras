package Backend.Entidades;

public class ReporteError extends ReporteOcurrencias{
    private String tipoError;
    private String descripcion;

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
