package Backend.Entidades;

public class Error {
    private String lexema;
    private String numeroLinea;//bueno, creo que al final de cuentas tendría que ser String porque debo enviar este dato a la tabla... a menos que lo vuelva todo a String como en HTML xD
    private String numeroColumna;
    private String tipoError;
    private String descripcion;

    public Error(String elLexema, int laLinea, int laColumna, String elTipo, String laDescripcion){
        lexema = elLexema;
        numeroLinea = String.valueOf(laLinea);
        numeroColumna = String.valueOf(laColumna);
        tipoError = elTipo;
        descripcion = laDescripcion;
    }

    public String darLexema(){
        return lexema;
    }

    public String darNumeroLinea(){
        return numeroLinea;
    }

    public String darNumeroColumna(){
        return numeroColumna;
    }

    public String darTipoError(){
        return tipoError;
    }

    public String darDescripcion(){
        return descripcion;
    }
}
